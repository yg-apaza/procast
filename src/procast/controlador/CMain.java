package procast.controlador;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.Style;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Token;
import procast.vista.UIMain;

public class CMain implements IMain
{
    private UIMain ventanaPrincipal;
    private File file;
    private String mem;
    
    public CMain(File file)
    {
        ventanaPrincipal = new UIMain(this);
        this.file = file;
    }
    
    @Override
    public void nuevo(RSyntaxTextArea editor)
    {
        if(!mem.equals(editor.getText()))
        {
            int opt = JOptionPane.showConfirmDialog(null, 
                                  "¿Desea guardar su archivo?", 
                                  "El archivo ha sido modificado", 
                                  JOptionPane.YES_NO_OPTION); 
        
            if(opt == JOptionPane.YES_OPTION)
            {
                if(file == null)
                    guardarComo(editor);
                else 
                    guardar(editor);
            }
        }
        file = null;
        mem = "";
        cargar(editor);
        ventanaPrincipal.setTitle("ProCast - Archivo Nuevo");
    }
    
    @Override
    public void abrir(RSyntaxTextArea editor)
    {
        if(!mem.equals(editor.getText()))
        {
            int opt = JOptionPane.showConfirmDialog(null, 
                                  "¿Desea guardar su archivo?", 
                                  "El archivo ha sido modificado", 
                                  JOptionPane.YES_NO_OPTION); 
        
            if(opt == JOptionPane.YES_OPTION)
            {
                if(file == null)
                    guardarComo(editor);
                else 
                    guardar(editor);
            }
        }
        
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Abrir archivo");
        FileFilter filter = new FileNameExtensionFilter("Archivos LeMa","lm");
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(filter);

        if (chooser.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                File fake = chooser.getSelectedFile();
                if(!(fake.getAbsolutePath().substring(fake.getAbsolutePath().length() - 3, fake.getAbsolutePath().length())).equals(".lm"))
                    file = new File(fake.getAbsolutePath() + ".lm");
                else
                    file = new File(fake.getAbsolutePath());
                
                FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
                

                String contenido = "";
                String linea = "";

                while((linea = br.readLine()) != null)     
                    contenido += (linea + "\n");             
                
                editor.setText(contenido);
                mem = editor.getText();
                ventanaPrincipal.setTitle("ProCast - " + file.getAbsolutePath());
            }
            catch (FileNotFoundException ex)
            {
                ex.printStackTrace();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public boolean guardar(RSyntaxTextArea editor)
    {
        PrintWriter out = null;
        try
        {
            if(file != null)
            {
                out = new PrintWriter(file);
                out.print(editor.getText());
                out.close();
                mem = editor.getText();
                return true;
            }
            else
                return guardarComo(editor);
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean guardarComo(RSyntaxTextArea editor)
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Guardar archivo como");
        FileFilter filter = new FileNameExtensionFilter("Archivos LeMa","lm");
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(filter);
        
        if (chooser.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION)
        {
            PrintWriter out = null;
            try {
                File fake = chooser.getSelectedFile();
                if(!(fake.getAbsolutePath().substring(fake.getAbsolutePath().length() - 3, fake.getAbsolutePath().length())).equals(".lm"))
                    file = new File(fake.getAbsolutePath() + ".lm");
                else
                    file = new File(fake.getAbsolutePath());
                
                out = new PrintWriter(file);
                
                out.print(editor.getText());
                
                mem = editor.getText();
                ventanaPrincipal.setTitle("ProCast - " + file.getAbsolutePath());
                return true;
            }
            catch (FileNotFoundException ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                out.close();
            }
        }
        return false;
    }
    
    /* ANALIZADORES */
    
    @Override
    public void analizarLexico(RSyntaxTextArea editor, JTextPane panel)
    {
        boolean archivoGuardado = true;
        
        if(file == null)
            archivoGuardado = guardarComo(editor);
        else if(!mem.equals(editor.getText()))
            archivoGuardado = guardar(editor);
        
        if(archivoGuardado)
        {
            try
            {
                Runtime r = Runtime.getRuntime();
                Process p;
                BufferedReader br;

                String linea;
                
                p = r.exec("cmd /c java -jar LeMa.jar " + file.getAbsolutePath() + " 0");
                br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                panel.setText("");
                while ((linea = br.readLine()) != null)
                {
                    if(linea.contains("Archivo"))
                        appendToPane(panel, "arch", linea + "\n");
                    else if(linea.contains("Error"))
                        appendToPane(panel, "error", linea + "\n");
                    else if(linea.contains("Finalizado"))
                        appendToPane(panel, "final", linea + "\n");
                    else
                        appendToPane(panel, "normal", linea + "\n");
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
   
    @Override
    public void analizarSintactico(RSyntaxTextArea editor, JTextPane panel)
    {
        boolean archivoGuardado = true;
        
        if(file == null)
            archivoGuardado = guardarComo(editor);
        else if(!mem.equals(editor.getText()))
            archivoGuardado = guardar(editor);
        
        if(archivoGuardado)
        {
            try
            {
                Runtime r = Runtime.getRuntime();
                Process p;
                BufferedReader br;

                String linea;

                p = r.exec("cmd /c java -jar LeMa.jar " + file.getAbsolutePath() + " 1");
                br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                panel.setText("");
                while ((linea = br.readLine()) != null)
                {
                    if(linea.contains("Archivo"))
                        appendToPane(panel, "arch", linea + "\n");
                    else if(linea.contains("Error"))
                        appendToPane(panel, "error", linea + "\n");
                    else if(linea.contains("Finalizado"))
                        appendToPane(panel, "final", linea + "\n");
                    else
                        appendToPane(panel, "normal", linea + "\n");
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void analizarSemantico(RSyntaxTextArea editor, JTree arbol, JTextPane panel)
    {
        boolean archivoGuardado = true;
        
        if(file == null)
            archivoGuardado = guardarComo(editor);
        else if(!mem.equals(editor.getText()))
            archivoGuardado = guardar(editor);
        
        if(archivoGuardado)
        {
            try
            {
                Runtime r = Runtime.getRuntime();
                Process p;
                BufferedReader br;

                p = r.exec("cmd /c java -jar LeMa.jar " + file.getAbsolutePath() + " 2");
                br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String linea;

                DefaultTreeModel modelo = null;

                ArrayList <DefaultMutableTreeNode> padres = new ArrayList <>();
                ArrayList <String> labels = new ArrayList <>();
                panel.setText("");
                
                boolean flag = true;
                while (((linea = br.readLine()) != null) && flag)
                {
                    if(linea.contains("Archivo"))
                        appendToPane(panel, "arch", linea + "\n");
                    else if(linea.contains("Error"))
                        appendToPane(panel, "error", linea + "\n");
                    else if(linea.contains("Finalizado"))
                    {
                        flag = false;
                        appendToPane(panel, "final", linea + "\n");
                    }
                    else
                        appendToPane(panel, "normal", linea + "\n");
                }
                if((linea = br.readLine()) != null)
                {
                    String padre = linea.substring(linea.indexOf("[")+2,linea.indexOf("]")-1);
                    DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(padre);
                    padres.add(nodo);
                    labels.add(padre);
                    modelo = new DefaultTreeModel(nodo);
                }

                while((linea = br.readLine()) != null && (!linea.equals("")))
                {
                    String hijo = linea.substring(linea.indexOf("[")+2,linea.indexOf("]")-1);
                    DefaultMutableTreeNode son = new DefaultMutableTreeNode(hijo);
                    padres.add(son);
                    labels.add(hijo);

                    String padre = linea.substring(linea.indexOf("(")+2,linea.indexOf("+")-1);                
                    DefaultMutableTreeNode father = padres.get(labels.lastIndexOf(padre));  

                    int num = Integer.parseInt(linea.substring(linea.indexOf("+")+2,linea.indexOf(")")-1));

                    modelo.insertNodeInto(son, father, num);
                }

                arbol.setModel(modelo);
                for (int i = 0; i < arbol.getRowCount(); i++) {
                    arbol.expandRow(i);
}
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
   
    private void appendToPane(JTextPane tp, String estilo, String msg)
    {
        StyledDocument doc = tp.getStyledDocument();
        try { doc.insertString(doc.getLength(), msg, tp.getStyle(estilo));}
        catch (BadLocationException e){}
    }
    
    @Override
    public void cargar(RSyntaxTextArea editor)
    {
        try
        {
            FileReader fr = new FileReader(new File("plantilla.lm"));
            BufferedReader br = new BufferedReader(fr);
            
            String contenido = "";
            String linea = "";

            while((linea = br.readLine()) != null)     
                contenido += (linea + "\n");             

            editor.setText(contenido);
            mem = "";
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (UnsupportedEncodingException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void personalizar(SyntaxScheme ss)
    {
        Style[] styles = ss.getStyles();

        styles[Token.COMMENT_MULTILINE]             = new Style(new Color(120, 120, 120), null, new Font("Consolas", Font.ITALIC, 14));
        styles[Token.COMMENT_EOL]                   = new Style(new Color(120, 120, 120), null, new Font("Consolas", Font.ITALIC, 14));
        styles[Token.RESERVED_WORD]                 = new Style(new Color(  0,   0, 255), null, new Font("Consolas", Font.TRUETYPE_FONT, 14));
        styles[Token.FUNCTION]                      = new Style(new Color(  0, 128, 255), null, new Font("Consolas", Font.TRUETYPE_FONT, 14));
        styles[Token.LITERAL_NUMBER_DECIMAL_INT]    = new Style(new Color(250,  15, 230), null, new Font("Consolas", Font.TRUETYPE_FONT, 14));
        styles[Token.LITERAL_STRING_DOUBLE_QUOTE]   = new Style(new Color(250,  15, 230), null, new Font("Consolas", Font.TRUETYPE_FONT, 14));
        styles[Token.DATA_TYPE]                     = new Style(new Color(  0, 128,   0), null, new Font("Consolas", Font.TRUETYPE_FONT, 14));
        styles[Token.IDENTIFIER]                    = new Style(new Color(  0,   0,   0), null, new Font("Consolas", Font.TRUETYPE_FONT, 14));
        styles[Token.WHITESPACE]                    = new Style(new Color(  0,   0,   0), null, new Font("Consolas", Font.TRUETYPE_FONT, 14));
        styles[Token.SEPARATOR]                     = new Style(new Color(  0,   0,   0), null, new Font("Consolas", Font.TRUETYPE_FONT, 14));
        styles[Token.OPERATOR]                      = new Style(new Color(  0,   0,   0), null, new Font("Consolas", Font.TRUETYPE_FONT, 14));
        styles[Token.ERROR_IDENTIFIER]              = new Style(new Color(255,   0,   0), null, new Font("Consolas", Font.TRUETYPE_FONT, 14));
    }
    
    public void estilos(JTextPane panel)
    {
        panel.addStyle("arch", null);
        StyleConstants.setForeground(panel.getStyle("arch"), Color.BLUE);
        panel.addStyle("normal", null);
        StyleConstants.setForeground(panel.getStyle("normal"), Color.BLACK);
        panel.addStyle("error", null);
        StyleConstants.setForeground(panel.getStyle("error"), Color.RED);
        panel.addStyle("warning", null);
        StyleConstants.setForeground(panel.getStyle("warning"), new Color(239, 186, 0));
        panel.addStyle("final", null);
        StyleConstants.setForeground(panel.getStyle("final"), Color.BLACK);
        StyleConstants.setBold(panel.getStyle("final"), true);
    }
}