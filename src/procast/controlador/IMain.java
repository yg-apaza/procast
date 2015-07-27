package procast.controlador;
import javax.swing.JTextPane;
import javax.swing.JTree;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;

public interface IMain
{
    public void nuevo(RSyntaxTextArea editor);
    public void abrir(RSyntaxTextArea editor);
    public boolean guardar(RSyntaxTextArea editor);
    public boolean guardarComo(RSyntaxTextArea editor);
    
    public void analizarLexico(RSyntaxTextArea editor, JTextPane panel);
    public void cargar(RSyntaxTextArea editor);
    public void analizarSintactico(RSyntaxTextArea editor, JTextPane panel);
    public void analizarSemantico(RSyntaxTextArea editor, JTree arbol);

    public void personalizar(SyntaxScheme ss);
}
