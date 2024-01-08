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

/**
 *
 * @author 422UR4H
 */
public class View_gastarMop extends javax.swing.JDialog {

    /**
     * Creates new form View_curarMop
     * @param parent
     * @param modal
     */
    public View_gastarMop(java.awt.Frame parent, boolean modal) {
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
        jTextFieldHoras = new javax.swing.JTextField();
        jButtonHoras = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonGastar = new javax.swing.JButton();
        jButtonGastarFull = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonMinutos = new javax.swing.JButton();
        jTextFieldMinutos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabelAura = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Curar Mop");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Quantas horas de cura?");

        jTextFieldHoras.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldHoras.setForeground(new java.awt.Color(0, 255, 0));
        jTextFieldHoras.setCaretColor(new java.awt.Color(0, 255, 0));
        jTextFieldHoras.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldHoras.setSelectionColor(new java.awt.Color(0, 255, 255));
        jTextFieldHoras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldHorasFocusGained(evt);
            }
        });
        jTextFieldHoras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldHorasKeyPressed(evt);
            }
        });

        jButtonHoras.setBackground(new java.awt.Color(102, 102, 102));
        jButtonHoras.setText("OK");
        jButtonHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHorasActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Gastará:");

        jButtonGastar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonGastar.setText("Gastar");
        jButtonGastar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGastarActionPerformed(evt);
            }
        });

        jButtonGastarFull.setBackground(new java.awt.Color(102, 102, 102));
        jButtonGastarFull.setText("Gastar Full");
        jButtonGastarFull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGastarFullActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonMinutos.setBackground(new java.awt.Color(102, 102, 102));
        jButtonMinutos.setText("OK");
        jButtonMinutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinutosActionPerformed(evt);
            }
        });

        jTextFieldMinutos.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldMinutos.setForeground(new java.awt.Color(0, 255, 0));
        jTextFieldMinutos.setCaretColor(new java.awt.Color(0, 255, 0));
        jTextFieldMinutos.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldMinutos.setSelectionColor(new java.awt.Color(0, 255, 255));
        jTextFieldMinutos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldMinutosFocusGained(evt);
            }
        });
        jTextFieldMinutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldMinutosKeyPressed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Quantas minutos de cura?");

        jLabelAura.setBackground(new java.awt.Color(102, 102, 102));

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("de aura nesse tempo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldMinutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonMinutos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldHoras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonHoras))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGastar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGastarFull, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonHoras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMinutos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addComponent(jButtonGastar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGastarFull)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancelar)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private int getAura() {
        int minutos = 0;
        
        // lendo horas
        try {
            minutos += Integer.parseInt(jTextFieldHoras.getText()) * 60;
        } catch (NumberFormatException e) {
            // nao faz nada
        }
        // lendo minutos
        try {
            minutos += Integer.parseInt(jTextFieldMinutos.getText());
        } catch (NumberFormatException e) {
            // nao faz nada
        }
        
        // convertendo em minutos e retornando
        return minutos * 60;
    }
    
    private void okHoras() {
        jLabelAura.setText(String.valueOf(getAura()));
    }
    
    private void okMinutos() {
        jLabelAura.setText(String.valueOf(getAura()));
    }
    
    private void jTextFieldHorasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldHorasFocusGained
        jTextFieldHoras.selectAll();
    }//GEN-LAST:event_jTextFieldHorasFocusGained

    private void jTextFieldHorasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHorasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            okHoras();
        }
    }//GEN-LAST:event_jTextFieldHorasKeyPressed

    private void jButtonHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHorasActionPerformed
        okHoras();
    }//GEN-LAST:event_jButtonHorasActionPerformed

    private void jButtonGastarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGastarActionPerformed
        Ficha ficha = AlgoritmoPrincipal.getFicha();
        int mop = ficha.getMopAtual() - getAura();
        if (mop < 0) {
            ficha.setMopAtual(0);
        } else {
            ficha.setMopAtual(mop);
        }
        JOptionPane.showMessageDialog(null, "MOP gasto!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_jButtonGastarActionPerformed

    private void jButtonGastarFullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGastarFullActionPerformed
        Ficha ficha = AlgoritmoPrincipal.getFicha();
        ficha.setMopAtual(0);
        JOptionPane.showMessageDialog(null, "MOP zerado!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_jButtonGastarFullActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonMinutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinutosActionPerformed
        okMinutos();
    }//GEN-LAST:event_jButtonMinutosActionPerformed

    private void jTextFieldMinutosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldMinutosFocusGained
        jTextFieldMinutos.selectAll();
    }//GEN-LAST:event_jTextFieldMinutosFocusGained

    private void jTextFieldMinutosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMinutosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            okMinutos();
        }
    }//GEN-LAST:event_jTextFieldMinutosKeyPressed

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
            java.util.logging.Logger.getLogger(View_gastarMop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            View_gastarMop dialog = new View_gastarMop(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGastar;
    private javax.swing.JButton jButtonGastarFull;
    private javax.swing.JButton jButtonHoras;
    private javax.swing.JButton jButtonMinutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAura;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldHoras;
    private javax.swing.JTextField jTextFieldMinutos;
    // End of variables declaration//GEN-END:variables
}
