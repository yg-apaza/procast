package procast.vista;

import java.awt.Frame;
import javax.swing.BoxLayout;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;
import procast.controlador.IMain;

public class UIMain extends javax.swing.JFrame
{
    private IMain interfaceMain;
    private final RSyntaxTextArea textArea = new RSyntaxTextArea(30, 85);  
    
    public UIMain(IMain interfaceMain)
    {
        this.setVisible(true);
        this.setTitle("ProCast - Archivo Nuevo");
        initComponents();
        /* Agregar LeMa como nuevo lenguaje */
        AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory)TokenMakerFactory.getDefaultInstance();
        atmf.putMapping("text/LeMa", "procast.controlador.LeMaTokenMaker");
        
        /* Construcción de RSyntaxTextArea */
        textArea.setCodeFoldingEnabled(true);
        textArea.setSyntaxEditingStyle("text/LeMa");
        SyntaxScheme ss = textArea.getSyntaxScheme();
        RTextScrollPane sp = new RTextScrollPane(textArea);
        
        /* Agregar editor RSyntaxTextArea al panel */
        panel.add(sp);
        panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));
        pack();
        
        setLocationRelativeTo(null);
        this.interfaceMain = interfaceMain;
        
        interfaceMain.estilos(this.txpLexico);
        interfaceMain.estilos(this.txpSintactico);
        interfaceMain.estilos(this.txpSemantico);
        interfaceMain.estilos(this.txpCompilador);
        interfaceMain.personalizar(ss);
        interfaceMain.cargar(textArea);
        
        /*
        try
        {
            textArea.addLineHighlight(2, (new Color(251, 198, 201)));
        } catch (BadLocationException ex)
        {
            Logger.getLogger(UIMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        this.setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel2 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        pnl = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txpLexico = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txpSintactico = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ast = new javax.swing.JTree();
        jScrollPane6 = new javax.swing.JScrollPane();
        txpSemantico = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txpCompilador = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        btnALexico = new javax.swing.JButton();
        btnASintactico = new javax.swing.JButton();
        btnASemantico = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnCompilar1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnArchivo = new javax.swing.JMenu();
        mnNuevo = new javax.swing.JMenuItem();
        mnAbrir = new javax.swing.JMenuItem();
        mnGuardar = new javax.swing.JMenuItem();
        mnGuardarComo = new javax.swing.JMenuItem();
        mnAyuda = new javax.swing.JMenu();
        mnAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnl.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txpLexico.setEditable(false);
        txpLexico.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(txpLexico);

        pnl.addTab("Analizador Lexico", jScrollPane3);

        txpSintactico.setEditable(false);
        txpSintactico.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(txpSintactico);

        pnl.addTab("Analizador Sintáctico", jScrollPane1);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("AST");
        ast.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(ast);

        txpSemantico.setEditable(false);
        txpSemantico.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jScrollPane6.setViewportView(txpSemantico);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnl.addTab("Analizador Semantico", jPanel1);

        txpCompilador.setEditable(false);
        txpCompilador.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jScrollPane5.setViewportView(txpCompilador);

        pnl.addTab("Compilador", jScrollPane5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnALexico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnALexico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/lex2.png"))); // NOI18N
        btnALexico.setText("A. LÉXICO");
        btnALexico.setBorder(null);
        btnALexico.setBorderPainted(false);
        btnALexico.setContentAreaFilled(false);
        btnALexico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnALexico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnALexico.setIconTextGap(-3);
        btnALexico.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/lex3.png"))); // NOI18N
        btnALexico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/lex1.png"))); // NOI18N
        btnALexico.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnALexico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnALexico.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnALexicoActionPerformed(evt);
            }
        });

        btnASintactico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnASintactico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/syn2.png"))); // NOI18N
        btnASintactico.setText("A. SINTÁCTICO");
        btnASintactico.setBorder(null);
        btnASintactico.setBorderPainted(false);
        btnASintactico.setContentAreaFilled(false);
        btnASintactico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnASintactico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnASintactico.setIconTextGap(-3);
        btnASintactico.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/syn3.png"))); // NOI18N
        btnASintactico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/syn1.png"))); // NOI18N
        btnASintactico.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnASintactico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnASintactico.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnASintacticoActionPerformed(evt);
            }
        });

        btnASemantico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnASemantico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/sem2.png"))); // NOI18N
        btnASemantico.setText("A. SEMANTICO");
        btnASemantico.setBorder(null);
        btnASemantico.setBorderPainted(false);
        btnASemantico.setContentAreaFilled(false);
        btnASemantico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnASemantico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnASemantico.setIconTextGap(-3);
        btnASemantico.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/sem3.png"))); // NOI18N
        btnASemantico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/sem1.png"))); // NOI18N
        btnASemantico.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnASemantico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnASemantico.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnASemanticoActionPerformed(evt);
            }
        });

        btnCompilar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/comp2.png"))); // NOI18N
        btnCompilar.setText("COMPILAR");
        btnCompilar.setBorder(null);
        btnCompilar.setBorderPainted(false);
        btnCompilar.setContentAreaFilled(false);
        btnCompilar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCompilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompilar.setIconTextGap(-3);
        btnCompilar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/comp3.png"))); // NOI18N
        btnCompilar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/comp1.png"))); // NOI18N
        btnCompilar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCompilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnCompilar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCompilar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/exec2.png"))); // NOI18N
        btnCompilar1.setText("EJECUTAR");
        btnCompilar1.setBorder(null);
        btnCompilar1.setBorderPainted(false);
        btnCompilar1.setContentAreaFilled(false);
        btnCompilar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCompilar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompilar1.setIconTextGap(-3);
        btnCompilar1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/exec3.png"))); // NOI18N
        btnCompilar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/exec1.png"))); // NOI18N
        btnCompilar1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCompilar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnALexico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnASintactico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnASemantico)
                        .addGap(289, 289, 289)
                        .addComponent(btnCompilar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCompilar1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnASintactico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnALexico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnASemantico, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompilar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCompilar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mnArchivo.setText("Archivo");

        mnNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/new.png"))); // NOI18N
        mnNuevo.setText("Nuevo");
        mnNuevo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnNuevoActionPerformed(evt);
            }
        });
        mnArchivo.add(mnNuevo);

        mnAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/open.png"))); // NOI18N
        mnAbrir.setText("Abrir");
        mnAbrir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnAbrirActionPerformed(evt);
            }
        });
        mnArchivo.add(mnAbrir);

        mnGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        mnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/save.png"))); // NOI18N
        mnGuardar.setText("Guardar");
        mnGuardar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnGuardarActionPerformed(evt);
            }
        });
        mnArchivo.add(mnGuardar);

        mnGuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/save_as.png"))); // NOI18N
        mnGuardarComo.setText("Guardar como");
        mnGuardarComo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnGuardarComoActionPerformed(evt);
            }
        });
        mnArchivo.add(mnGuardarComo);

        jMenuBar1.add(mnArchivo);

        mnAyuda.setText("Ayuda");

        mnAcerca.setText("Acerca de");
        mnAyuda.add(mnAcerca);

        jMenuBar1.add(mnAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNuevoActionPerformed
        interfaceMain.nuevo(textArea);
    }//GEN-LAST:event_mnNuevoActionPerformed

    private void mnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAbrirActionPerformed
        interfaceMain.abrir(textArea);
    }//GEN-LAST:event_mnAbrirActionPerformed

    private void mnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGuardarActionPerformed
        interfaceMain.guardar(textArea);
    }//GEN-LAST:event_mnGuardarActionPerformed

    private void mnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGuardarComoActionPerformed
        interfaceMain.guardarComo(textArea);
    }//GEN-LAST:event_mnGuardarComoActionPerformed

    private void btnALexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALexicoActionPerformed
        interfaceMain.analizarLexico(textArea, this.txpLexico);
    }//GEN-LAST:event_btnALexicoActionPerformed

    private void btnASintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnASintacticoActionPerformed
        interfaceMain.analizarSintactico(textArea, this.txpSintactico);
    }//GEN-LAST:event_btnASintacticoActionPerformed

    private void btnASemanticoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnASemanticoActionPerformed
    {//GEN-HEADEREND:event_btnASemanticoActionPerformed
        interfaceMain.analizarSemantico(textArea, ast, txpSemantico);
    }//GEN-LAST:event_btnASemanticoActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree ast;
    private javax.swing.JButton btnALexico;
    private javax.swing.JButton btnASemantico;
    private javax.swing.JButton btnASintactico;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnCompilar1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem mnAbrir;
    private javax.swing.JMenuItem mnAcerca;
    private javax.swing.JMenu mnArchivo;
    private javax.swing.JMenu mnAyuda;
    private javax.swing.JMenuItem mnGuardar;
    private javax.swing.JMenuItem mnGuardarComo;
    private javax.swing.JMenuItem mnNuevo;
    private javax.swing.JPanel panel;
    private javax.swing.JTabbedPane pnl;
    private javax.swing.JTextPane txpCompilador;
    private javax.swing.JTextPane txpLexico;
    private javax.swing.JTextPane txpSemantico;
    private javax.swing.JTextPane txpSintactico;
    // End of variables declaration//GEN-END:variables
}
