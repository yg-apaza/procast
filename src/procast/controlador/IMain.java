package procast.controlador;

import javax.swing.CodeEditorPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public interface IMain
{
    public void nuevo(CodeEditorPane editor);
    public void abrir(CodeEditorPane editor);
    public void guardar(CodeEditorPane editor);
    public void guardarComo(CodeEditorPane editor);
    
    public void analizarLexico(CodeEditorPane editor, JTextPane panel);
    public void cargar(CodeEditorPane editor);
    public void analizarSintactico(CodeEditorPane editor, JTextPane panel);
}
