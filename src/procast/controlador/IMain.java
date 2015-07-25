package procast.controlador;
import javax.swing.JTextPane;
import javax.swing.JTree;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public interface IMain
{
    public void nuevo(RSyntaxTextArea editor);
    public void abrir(RSyntaxTextArea editor);
    public void guardar(RSyntaxTextArea editor);
    public void guardarComo(RSyntaxTextArea editor);
    
    public void analizarLexico(RSyntaxTextArea editor, JTextPane panel);
    public void cargar(RSyntaxTextArea editor);
    public void analizarSintactico(RSyntaxTextArea editor, JTextPane panel);
    public void analizarSemantico(RSyntaxTextArea editor, JTree arbol);
}
