package procast.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.CodeEditorPane;
import javax.swing.DefaultSyntaxColorizer;
import procast.controlador.IMain;

public class UIMain extends javax.swing.JFrame {
    
    private IMain interfaceMain;
    private final CodeEditorPane edit;
    
    
    public UIMain(IMain interfaceMain)
    {
        this.setVisible(true);
        this.setTitle("ProCast");
        
        /* editor */
        final HashMap<String, Color> syntax = new DefaultSyntaxColorizer.RegExpHashMap();
        
        /*Tipos de Datos */
        syntax.put("vacio", (new Color(0, 128, 0)));
        syntax.put("entero", (new Color(0, 128, 0)));
        syntax.put("real", (new Color(0, 128, 0)));
        syntax.put("cadena", (new Color(0, 128, 0)));
        
        /* Palabras reservadas */
        syntax.put("suma", Color.BLUE);
        syntax.put("resta", Color.BLUE);
        syntax.put("producto", Color.BLUE);
        syntax.put("transpuesta", Color.BLUE);
        syntax.put("inversa", Color.BLUE);
        syntax.put("leer", Color.BLUE);
        syntax.put("mostrar", Color.BLUE);
        syntax.put("retornar", Color.BLUE);
        syntax.put("si", Color.BLUE);
        syntax.put("sino", Color.BLUE);
        syntax.put("mientras", Color.BLUE);
        syntax.put("hacer", Color.BLUE);
        syntax.put("para", Color.BLUE);
        syntax.put("selector", Color.BLUE);
        syntax.put("saltar", Color.BLUE);
        syntax.put("caso", Color.BLUE);
        syntax.put("pordefecto", Color.BLUE);
        syntax.put("const", Color.BLUE);
        
        syntax.put("principal", Color.RED);
        
        edit = new CodeEditorPane();
        edit.setKeywordColor(syntax);

        HashMap<String, String> help = new HashMap<String, String>();
        help.put("vacio", "Tipo de dato vacío");
        help.put("entero", "Tipo de dato entero");
        help.put("real", "Tipo de dato real");
        help.put("cadena", "Tipo de dato cadena");
        help.put("suma", "Función suma de matrices");
        help.put("resta", "Función resta de matrices");
        help.put("producto", "Función producto de matrices");
        help.put("transpuesta", "Función transpuesta de matrices");
        help.put("inversa", "Función inversa de matrices");
        help.put("leer", "Lee una entrada de datos");
        help.put("mostrar", "Mostrar una salida de datos");
        help.put("retornar", "Retorna al punto desde el que fue llamado");
        help.put("si", "Sentencia Condicional 'si'");
        help.put("sino", "Sentencia Condicional 'sino'");
        help.put("mientras", "Sentencia Cíclica 'mientras'");
        help.put("hacer", "Sentencia Cíclica 'hacer'");
        help.put("para", "Sentencia Cíclica 'para'");
        help.put("selector", "Sentencia selección múltiple 'selector'");
        help.put("saltar", "Aborta una ejecución");
        help.put("caso", "Caso del selector");
        help.put("pordefecto", "Caso por defecto del selector");
        help.put("principal", "Función principal de LeMa");
        edit.setKeywordHelp(help);
        
        edit.setVerticalLineAtPos(80);

        /* fin editor */
        initComponents();
        
        this.panel.setPreferredSize(new Dimension(600, 400));
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));
        this.panel.add(edit.getContainerWithLines());
        this.pack();
        this.interfaceMain = interfaceMain;
        
        interfaceMain.cargar(edit);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jSeparator1 = new javax.swing.JSeparator();
        btnALexico = new javax.swing.JButton();
        btnASintactico = new javax.swing.JButton();
        btnASemantico = new javax.swing.JButton();
        pnl = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txpLexico = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txpSintactico = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ast = new javax.swing.JTree();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnCompilar = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnArchivo = new javax.swing.JMenu();
        mnNuevo = new javax.swing.JMenuItem();
        mnAbrir = new javax.swing.JMenuItem();
        mnGuardar = new javax.swing.JMenuItem();
        mnGuardarComo = new javax.swing.JMenuItem();
        mnAyuda = new javax.swing.JMenu();
        mnAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        txpLexico.setEditable(false);
        jScrollPane3.setViewportView(txpLexico);

        pnl.addTab("Analizador Lexico", jScrollPane3);

        txpSintactico.setEditable(false);
        jScrollPane1.setViewportView(txpSintactico);

        pnl.addTab("Analizador Sintáctico", jScrollPane1);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        ast.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(ast);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnl.addTab("Analizador Semantico", jPanel1);

        btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/play2.png"))); // NOI18N
        btnCompilar.setText("COMPILAR");
        btnCompilar.setBorder(null);
        btnCompilar.setBorderPainted(false);
        btnCompilar.setContentAreaFilled(false);
        btnCompilar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCompilar.setEnabled(false);
        btnCompilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompilar.setIconTextGap(-3);
        btnCompilar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/play3.png"))); // NOI18N
        btnCompilar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/procast/recursos/play1.png"))); // NOI18N
        btnCompilar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCompilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        mnArchivo.setText("Archivo");

        mnNuevo.setText("Nuevo");
        mnNuevo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnNuevoActionPerformed(evt);
            }
        });
        mnArchivo.add(mnNuevo);

        mnAbrir.setText("Abrir");
        mnAbrir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnAbrirActionPerformed(evt);
            }
        });
        mnArchivo.add(mnAbrir);

        mnGuardar.setText("Guardar");
        mnGuardar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnGuardarActionPerformed(evt);
            }
        });
        mnArchivo.add(mnGuardar);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnALexico, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnASintactico, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnASemantico, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(342, 342, 342)
                        .addComponent(btnCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26)
                                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnASintactico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnALexico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnASemantico, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompilar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNuevoActionPerformed
        interfaceMain.nuevo(edit);
    }//GEN-LAST:event_mnNuevoActionPerformed

    private void mnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAbrirActionPerformed
        interfaceMain.abrir(edit);
    }//GEN-LAST:event_mnAbrirActionPerformed

    private void mnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGuardarActionPerformed
        interfaceMain.guardar(edit);
    }//GEN-LAST:event_mnGuardarActionPerformed

    private void mnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGuardarComoActionPerformed
        interfaceMain.guardarComo(edit);
    }//GEN-LAST:event_mnGuardarComoActionPerformed

    private void btnALexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALexicoActionPerformed
        interfaceMain.analizarLexico(edit, this.txpLexico);
    }//GEN-LAST:event_btnALexicoActionPerformed

    private void btnASintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnASintacticoActionPerformed
        interfaceMain.analizarSintactico(edit, this.txpSintactico);
    }//GEN-LAST:event_btnASintacticoActionPerformed

    private void btnASemanticoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnASemanticoActionPerformed
    {//GEN-HEADEREND:event_btnASemanticoActionPerformed
        interfaceMain.analizarSemantico(edit, ast);
    }//GEN-LAST:event_btnASemanticoActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree ast;
    private javax.swing.JButton btnALexico;
    private javax.swing.JButton btnASemantico;
    private javax.swing.JButton btnASintactico;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuItem mnAbrir;
    private javax.swing.JMenuItem mnAcerca;
    private javax.swing.JMenu mnArchivo;
    private javax.swing.JMenu mnAyuda;
    private javax.swing.JMenuItem mnGuardar;
    private javax.swing.JMenuItem mnGuardarComo;
    private javax.swing.JMenuItem mnNuevo;
    private javax.swing.JPanel panel;
    private javax.swing.JTabbedPane pnl;
    private javax.swing.JTextPane txpLexico;
    private javax.swing.JTextPane txpSintactico;
    // End of variables declaration//GEN-END:variables
}
