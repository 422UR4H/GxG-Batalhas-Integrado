/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.batalhas;

import algoritmos.batalhas.AlgoritmoPrincipal;
import ficha_personagem.Ficha;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 422UR4H
 */
public class View_dias extends javax.swing.JDialog {

    /**
     * Creates new form View_dias
     * @param parent
     * @param modal
     */
    public View_dias(java.awt.Frame parent, boolean modal) {
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
        jTextFieldNome = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonRmv = new javax.swing.JButton();
        jButtonRodarDias = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonFechar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDias = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rodar Dias");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Escolha os personagens");

        jTextFieldNome.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldNome.setForeground(new java.awt.Color(0, 255, 0));
        jTextFieldNome.setCaretColor(new java.awt.Color(0, 255, 0));
        jTextFieldNome.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldNome.setSelectionColor(new java.awt.Color(0, 255, 255));
        jTextFieldNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNomeFocusGained(evt);
            }
        });
        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyPressed(evt);
            }
        });

        jButtonAdd.setBackground(new java.awt.Color(102, 102, 102));
        jButtonAdd.setText("Adicionar");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonRmv.setBackground(new java.awt.Color(102, 102, 102));
        jButtonRmv.setText("Remover");
        jButtonRmv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRmvActionPerformed(evt);
            }
        });

        jButtonRodarDias.setBackground(new java.awt.Color(102, 102, 102));
        jButtonRodarDias.setText("Rodar Dias");
        jButtonRodarDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRodarDiasActionPerformed(evt);
            }
        });

        jTable.setBackground(new java.awt.Color(51, 51, 51));
        jTable.setForeground(new java.awt.Color(0, 255, 0));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setSelectionBackground(new java.awt.Color(0, 255, 255));
        jTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(jTable);

        jButtonFechar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Quantidade de Dias: ");

        jTextFieldDias.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldDias.setForeground(new java.awt.Color(0, 255, 0));
        jTextFieldDias.setCaretColor(new java.awt.Color(0, 255, 0));
        jTextFieldDias.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldDias.setSelectionColor(new java.awt.Color(0, 255, 255));
        jTextFieldDias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDiasFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDias))
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRmv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRodarDias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldDias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonRmv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRodarDias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFechar)
                .addGap(11, 11, 11))
        );

        jScrollPane1.setViewportView(jPanel1);

        jMenu1.setText("Dias");

        jMenuItem1.setText("Rodar Dias Para Todos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

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
    
    private void adicionar() {
        // lendo o nome do personagem
        // retorna true se atacante for um nome valido
        String nomePer = jTextFieldNome.getText().toUpperCase();
        if (!AlgoritmoPrincipal.containsPersonagem(nomePer)) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado um personagem com esse nome",
                    "Error!", JOptionPane.WARNING_MESSAGE);
            
            jTextFieldNome.selectAll();
            return;
        }

        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        Object[] vetor = { nomePer };
        dtm.addRow(vetor);
        
        jTextFieldNome.selectAll();
    }
    
    private void resetarSortes() {
        switch (JOptionPane.showConfirmDialog(null, "Resetar sortes de todos personagens?",
                "Confirm!", JOptionPane.YES_NO_OPTION)) {
            
            case 0:
                // resetando sortes
                for (String nome : AlgoritmoPrincipal.getFichas().keySet()) {
                    AlgoritmoPrincipal.getFicha(nome).resetSortes();
                }
                
                // mensagem ao usuario
                JOptionPane.showMessageDialog(null, "Sortes resetadas!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        switch (JOptionPane.showConfirmDialog(null, "Deseja rodas dias para todos os personagens?",
            "Confirm!", JOptionPane.YES_NO_OPTION)) {

        case 0:
        int dias;
        try {
            dias = Integer.parseInt(jTextFieldDias.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Primeiro sete a quantidade de dias!",
                "Error!", JOptionPane.ERROR_MESSAGE);

            return;
        }

        // rodando dias para todos
        for (String nome : AlgoritmoPrincipal.getFichas().keySet()) {
            Ficha ficha = AlgoritmoPrincipal.getFicha(nome);
            ficha.setDias(ficha.getDias() + dias);
        }

        // mensagem ao usuario
        JOptionPane.showMessageDialog(null, dias+" dias adicionados em todos personagens!",
            "Success!", JOptionPane.INFORMATION_MESSAGE);

        // resetando sortes se o usuario quiser
        resetarSortes();

        break;
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextFieldNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeFocusGained
        jTextFieldNome.selectAll();
    }//GEN-LAST:event_jTextFieldNomeFocusGained

    private void jTextFieldNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            adicionar();
        }
    }//GEN-LAST:event_jTextFieldNomeKeyPressed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        adicionar();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonRmvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRmvActionPerformed
        int linha = jTable.getSelectedRow();
        if (linha < 0) {
            return;
        }

        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        dtm.removeRow(linha);
    }//GEN-LAST:event_jButtonRmvActionPerformed

    private void jButtonRodarDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRodarDiasActionPerformed
        double dias;
        // testando quantidade válida de dias setados
        try {
            dias = Double.parseDouble(jTextFieldDias.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite a quantidade de dias!",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            
            return;
        }
        jTextFieldDias.setEnabled(false);
        jButtonAdd.setEnabled(false);
        jButtonRmv.setEnabled(false);

        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();

        // adicionando dias
        for (int i = 0; i < jTable.getRowCount(); i++) {
            String nome = (String) dtm.getValueAt(i, 0);
            Ficha ficha = AlgoritmoPrincipal.getFicha(nome);
            ficha.setDias(ficha.getDias() + dias);
        }

        // resetando sortes se o usuario quiser
        switch (JOptionPane.showConfirmDialog(null, "Resetar sortes desses personagens?",
            "Confirm!", JOptionPane.YES_NO_OPTION)) {

        case 0:
        // resetando sortes
        for (int i = 0; i < jTable.getRowCount(); i++) {
            String nome = (String) dtm.getValueAt(i, 0);
            Ficha ficha = AlgoritmoPrincipal.getFicha(nome);
            ficha.resetSortes();
        }

        // mensagem ao usuario
        JOptionPane.showMessageDialog(null, "Sortes resetadas!",
            "Success!", JOptionPane.INFORMATION_MESSAGE);

        break;
        }

        // salvando alterações
        File folder = new File(AlgoritmoPrincipal.getDIR_FICHAS());
        try {
            AlgoritmoPrincipal.saveFichas(folder);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(View_dias.class.getName()).log(Level.SEVERE, null, ex);
        }

        // mensagem ao usuario
        JOptionPane.showMessageDialog(null, "Dias adicionados!\nFichas salvas!",
            "Success!", JOptionPane.INFORMATION_MESSAGE);

        // desabilitando botão
        jButtonRodarDias.setEnabled(false);
    }//GEN-LAST:event_jButtonRodarDiasActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jTextFieldDiasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDiasFocusGained
        jTextFieldDias.selectAll();
    }//GEN-LAST:event_jTextFieldDiasFocusGained

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
            java.util.logging.Logger.getLogger(View_dias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            View_dias dialog = new View_dias(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonRmv;
    private javax.swing.JButton jButtonRodarDias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldDias;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}