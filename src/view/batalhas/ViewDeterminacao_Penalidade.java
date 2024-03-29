/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.batalhas;

import algoritmos.batalhas.AlgoritmoPrincipal;
import algoritmos.batalhas.Calculadora;
//import com.sun.glass.events.KeyEvent;
import java.awt.event.KeyEvent;
import ficha_personagem.Ficha;
import javax.swing.JOptionPane;

/**
 *
 * @author 422UR4H
 */
public class ViewDeterminacao_Penalidade extends javax.swing.JFrame {

    /**
     * Creates new form ViewDeterminacao_Penalidade
     */
    public ViewDeterminacao_Penalidade() {
        initComponents();
        
        
        // MEU CODIGO
        
        jTextFieldRen.setEnabled(false);
        jButtonRen.setEnabled(false);
        jButtonAbrirPen.setEnabled(false);
        jButtonAbrirDet.setEnabled(false);
        
        // FIM DO MEU CODIGO
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
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonNome = new javax.swing.JButton();
        jTextFieldRen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonRen = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelPen = new javax.swing.JLabel();
        jLabelDet = new javax.swing.JLabel();
        jButtonFechar = new javax.swing.JButton();
        jButtonAbrirPen = new javax.swing.JButton();
        jButtonAbrirDet = new javax.swing.JButton();
        jComboBoxNen = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Penalidade/Determinação");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Personagem:");

        jTextFieldNome.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldNome.setForeground(new java.awt.Color(0, 255, 0));
        jTextFieldNome.setCaretColor(new java.awt.Color(0, 255, 0));
        jTextFieldNome.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldNome.setSelectionColor(new java.awt.Color(0, 255, 255));
        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyPressed(evt);
            }
        });

        jButtonNome.setBackground(new java.awt.Color(102, 102, 102));
        jButtonNome.setText("OK");
        jButtonNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNomeActionPerformed(evt);
            }
        });

        jTextFieldRen.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldRen.setForeground(new java.awt.Color(0, 255, 0));
        jTextFieldRen.setCaretColor(new java.awt.Color(0, 255, 0));
        jTextFieldRen.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldRen.setSelectionColor(new java.awt.Color(0, 255, 255));
        jTextFieldRen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldRenKeyPressed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Porcentagem de alteração");

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("do Ren: ");

        jButtonRen.setBackground(new java.awt.Color(102, 102, 102));
        jButtonRen.setText("OK");
        jButtonRen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRenActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Penalidade: ");

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Determinação: ");

        jLabelPen.setBackground(new java.awt.Color(102, 102, 102));

        jLabelDet.setBackground(new java.awt.Color(102, 102, 102));

        jButtonFechar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jButtonAbrirPen.setBackground(new java.awt.Color(102, 102, 102));
        jButtonAbrirPen.setText("Abrir Penalidade");
        jButtonAbrirPen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirPenActionPerformed(evt);
            }
        });

        jButtonAbrirDet.setBackground(new java.awt.Color(102, 102, 102));
        jButtonAbrirDet.setText("Abrir Determinação");
        jButtonAbrirDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirDetActionPerformed(evt);
            }
        });

        jComboBoxNen.setBackground(new java.awt.Color(102, 102, 102));
        jComboBoxNen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reforco", "Emissao", "Transformacao", "Materializacao", "Manipulacao", "Especialista" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAbrirPen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPen, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDet, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonNome))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldRen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRen)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButtonAbrirDet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxNen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNome)
                    .addComponent(jButtonNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jComboBoxNen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldRen, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRen, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelPen, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDet, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAbrirPen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAbrirDet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comecar() {
        // lendo o nome do personagem
        // retorna true se atacante for um nome valido
        Ficha ficha;
        String nomePer = jTextFieldNome.getText().toUpperCase();
        if (AlgoritmoPrincipal.containsPersonagem(nomePer)) {
            ficha = AlgoritmoPrincipal.getPerson(nomePer);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi encontrado um personagem com esse nome",
                    "Error!", JOptionPane.WARNING_MESSAGE);
            
            jTextFieldNome.selectAll();
            return;
        }
        
        // setando personagem em algoritmo principal
        AlgoritmoPrincipal.setFicha(ficha);
        
        // habilitando ren
        jTextFieldRen.setEnabled(true);
        jButtonRen.setEnabled(true);
    }
    
    private void jTextFieldNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            comecar();
        }
    }//GEN-LAST:event_jTextFieldNomeKeyPressed

    private void jButtonNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNomeActionPerformed
        comecar();
    }//GEN-LAST:event_jButtonNomeActionPerformed
    
    private boolean validaRen() {
        try {
            Double.parseDouble(jTextFieldRen.getText());
        } catch (NumberFormatException e) {
            return false;
        }
        if (jTextFieldRen.getText() == null) {
            return false;
        }
        return true;
    }
    
    private void calcularRen() {
        
        if (!validaRen()) {
            JOptionPane.showMessageDialog(null, "Campo de ren vazio ou inválido!",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            
            jTextFieldRen.selectAll();
            return;
        }
        
        Ficha ficha = AlgoritmoPrincipal.getPerson(jTextFieldNome.getText().toUpperCase());
        String nen =  jComboBoxNen.getSelectedItem().toString();
        double coef = Double.parseDouble(jTextFieldRen.getText()) / 100.0;
        
        int renPen = (int) ((1 - coef) * Calculadora.getRen(ficha, 100, nen));
        int renDet = (int) ((1 + coef) * Calculadora.getRen(ficha, 100, nen));
        
        // setando calculos realizados nas labels
        jLabelPen.setText(String.valueOf(renPen));
        jLabelDet.setText(String.valueOf(renDet));
        
        // habilitando buttons
        jButtonAbrirPen.setEnabled(true);
        jButtonAbrirDet.setEnabled(true);
    }
    
    private void jTextFieldRenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRenKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            calcularRen();
        }
    }//GEN-LAST:event_jTextFieldRenKeyPressed

    private void jButtonRenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRenActionPerformed
        calcularRen();
    }//GEN-LAST:event_jButtonRenActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonAbrirPenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirPenActionPerformed
        AlgoritmoPrincipal.setValor(Integer.parseInt(jLabelPen.getText()));
        new ViewPercent().setVisible(true);
    }//GEN-LAST:event_jButtonAbrirPenActionPerformed

    private void jButtonAbrirDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirDetActionPerformed
        AlgoritmoPrincipal.setValor(Integer.parseInt(jLabelDet.getText()));
        new ViewPercent().setVisible(true);
    }//GEN-LAST:event_jButtonAbrirDetActionPerformed

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
            java.util.logging.Logger.getLogger(ViewDeterminacao_Penalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ViewDeterminacao_Penalidade().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrirDet;
    private javax.swing.JButton jButtonAbrirPen;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonNome;
    private javax.swing.JButton jButtonRen;
    private javax.swing.JComboBox<String> jComboBoxNen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelDet;
    private javax.swing.JLabel jLabelPen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldRen;
    // End of variables declaration//GEN-END:variables
}
