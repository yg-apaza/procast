package procast.controlador;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Main {
    
    private CMain inicio;
    
    public Main()
    {
        ImageIcon icon = new ImageIcon(getClass().getResource("/procast/recursos/nodo.png"));
        UIManager.put("Tree.closedIcon", icon);
        UIManager.put("Tree.openIcon", icon);
        UIManager.put("Tree.leafIcon", icon);
        inicio = new CMain(null);
    }
    
    public static void main(String[] args)
    {
        new Main();
    }
}