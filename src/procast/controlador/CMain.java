package procast.controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.CodeEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    
    public void nuevo(CodeEditorPane editor)
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
        cargar(editor);
    }
    
    public void abrir(CodeEditorPane editor)
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
            try {
                File fake = chooser.getSelectedFile();
                if(!(fake.getAbsolutePath().substring(fake.getAbsolutePath().length() - 3, fake.getAbsolutePath().length())).equals(".lm"))
                    file = new File(fake.getAbsolutePath() + ".lm");
                else
                    file = new File(fake.getAbsolutePath());

                Scanner scan = new Scanner(file);

                String contenido = "";
                while(scan.hasNextLine())
                {
                    contenido += (scan.nextLine() + "\n");
                }
                scan.close();
                editor.setText(contenido);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void guardar(CodeEditorPane editor)
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
                
            }
            else
            {
                guardarComo(editor);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void guardarComo(CodeEditorPane editor)
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
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                out.close();
            }
        }
    }
    
    /* ANALIZADORES */
    
    public void analizarLexico(CodeEditorPane editor, JTextPane panel)
    {
        if(file == null)
            guardarComo(editor);
        try
        {
            Runtime r = Runtime.getRuntime();
            Process p;
            BufferedReader br;
            
            String linea;
            
            /* Compilador */
            p = r.exec("cmd /c java -jar LeMa.jar " + file.getAbsolutePath() + " 0");

            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            panel.setText("");
            
            while ((linea = br.readLine()) != null)
            {
                panel.setText(panel.getText() + linea + "\n");
            }
            
        }
        catch (IOException ex)
        {
            Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void analizarSintactico(CodeEditorPane editor, JTextPane panel)
    {
        if(file == null)
            guardarComo(editor);
        try
        {
            Runtime r = Runtime.getRuntime();
            Process p;
            BufferedReader br;
            
            String linea;
            
            /* Compilador */
            p = r.exec("cmd /c java -jar LeMa.jar " + file.getAbsolutePath() + " 1");

            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            panel.setText("");
            
            while ((linea = br.readLine()) != null)
            {
                panel.setText(panel.getText() + linea + "\n");
            }
            
        }
        catch (IOException ex)
        {
            Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void analizarSemantico(CodeEditorPane editor, JTree arbol)
    {
        if(file == null)
            guardarComo(editor);
        try
        {
            Runtime r = Runtime.getRuntime();
            Process p;
            BufferedReader br;
            
            String linea;
            
            /* Compilador */
            p = r.exec("cmd /c java -jar LeMa.jar " + file.getAbsolutePath() + " 2");

            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            
        }
        catch (IOException ex)
        {
            Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargar(CodeEditorPane editor)
    {
        try {
            Scanner scan = new Scanner(new File("plantilla.lm"));
            String contenido = "";
            while(scan.hasNextLine())
            {
                contenido += (scan.nextLine() + "\n");
            }
            scan.close();
            editor.setText(contenido);
            mem = contenido;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
