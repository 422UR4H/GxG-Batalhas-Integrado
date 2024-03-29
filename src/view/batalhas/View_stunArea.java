/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.batalhas;

import algoritmos.batalhas.AlgoritmoPrincipal;
import ficha_personagem.Ficha;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 422UR4H
 */
public class View_stunArea extends javax.swing.JDialog {

    /**
     * Creates new form View_stunArea
     */
    public View_stunArea(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNick = new javax.swing.JTextField();
        jButtonOk = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonAplicar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldStun = new javax.swing.JTextField();
        jButtonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stun em area");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Personagem");

        jTextFieldNick.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldNick.setForeground(new java.awt.Color(0, 255, 0));
        jTextFieldNick.setCaretColor(new java.awt.Color(0, 255, 0));
        jTextFieldNick.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldNick.setSelectionColor(new java.awt.Color(0, 255, 255));
        jTextFieldNick.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNickFocusGained(evt);
            }
        });
        jTextFieldNick.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNickKeyPressed(evt);
            }
        });

        jButtonOk.setBackground(new java.awt.Color(102, 102, 102));
        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jTable.setBackground(new java.awt.Color(51, 51, 51));
        jTable.setForeground(new java.awt.Color(0, 255, 0));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "NICK", "Stun"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(32);
        }

        jButtonAplicar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonAplicar.setText("Aplicar stun");
        jButtonAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAplicarActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Valor de stun");

        jTextFieldStun.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldStun.setForeground(new java.awt.Color(0, 255, 0));
        jTextFieldStun.setCaretColor(new java.awt.Color(0, 255, 0));
        jTextFieldStun.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldStun.setSelectionColor(new java.awt.Color(0, 255, 255));
        jTextFieldStun.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldStunFocusGained(evt);
            }
        });
        jTextFieldStun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldStunKeyPressed(evt);
            }
        });

        jButtonFechar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonAplicar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextFieldStun, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jButtonFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jTextFieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldStun, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAplicar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFechar)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAplicarActionPerformed
        int i;
        for (i = 0; i < jTable.getRowCount(); i++) {
            if (jTable.getValueAt(i, 0) == null) {
                break;
            }
            
            String nick = String.valueOf(jTable.getValueAt(i, 0));
            Ficha personagem = AlgoritmoPrincipal.getPerson(nick);
            int stun = (int) jTable.getValueAt(i, 1);
            
            // inserindo stun
            personagem.addStun(stun);
        }
        
        if (i == 0) {
            JOptionPane.showMessageDialog(null, "Primeiro adicione personagens!", "Wait!", JOptionPane.INFORMATION_MESSAGE);
            //return;
        } else {
            JOptionPane.showMessageDialog(null, "Stuns adicionados!", "Success!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonAplicarActionPerformed

    private void inserir() {
        Ficha personagem = AlgoritmoPrincipal.getPerson(jTextFieldNick.getText().toUpperCase());
        int stun;
        
        // validando nick
        if (personagem == null) {
            JOptionPane.showMessageDialog(null, "Nick inválido!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // testando se o personagem ja esta setado
        for (int i = 0; i < jTable.getRowCount(); i++) {
            if (jTable.getValueAt(i, 0) == null) {
                break;
            }
            if (personagem.getNick().equals(jTable.getValueAt(i, 0).toString())) {
                JOptionPane.showMessageDialog(null, "Personagem já setado!",
                        "Error!", JOptionPane.WARNING_MESSAGE);
                jTextFieldNick.selectAll();
                return;
            }
        }
        // validando valor de stun
        try {
            stun = Integer.parseInt(jTextFieldStun.getText());
            if (stun < 0) {
                stun = 0;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor de stun inválido!",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            
            jTextFieldStun.selectAll();
            return;
        }
        
        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        Object[] vetor = new Object[2];
        int i = 0;
        
        vetor[0] = personagem.getNick();
        vetor[1] = Integer.parseInt(jTextFieldStun.getText());
        
        // setando personagem
        for (i = 0; i < jTable.getRowCount(); i++) {
            if (jTable.getValueAt(i, 0) == null) {
                break;
            }
        }
        dtm.insertRow(i, vetor);
        
        try {
            dtm.removeRow(i + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            // nao faz nada
        }
        
        jTextFieldNick.selectAll();
    }
    
    private void jTextFieldNickKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNickKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            inserir();
        }
    }//GEN-LAST:event_jTextFieldNickKeyPressed

    private void jTextFieldStunKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldStunKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            inserir();
        }
    }//GEN-LAST:event_jTextFieldStunKeyPressed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        inserir();
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jTextFieldNickFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNickFocusGained
        jTextFieldNick.selectAll();
    }//GEN-LAST:event_jTextFieldNickFocusGained

    private void jTextFieldStunFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldStunFocusGained
        jTextFieldStun.selectAll();
    }//GEN-LAST:event_jTextFieldStunFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_stunArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            View_stunArea dialog = new View_stunArea(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAplicar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldNick;
    private javax.swing.JTextField jTextFieldStun;
    // End of variables declaration//GEN-END:variables
}
