/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.editor;

import algoritmos.dal.ModuloConexao;
import algoritmos.editor.AlgoritmoPrincipalEditor;
import ficha_personagem.Ficha;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 422UR4H
 */
public class View_descricao extends javax.swing.JDialog {

    /**
     * Creates new form View_descricao
     * @param parent
     * @param modal
     */
    public View_descricao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        
        // MEU CODIGO
        
        Ficha ficha = AlgoritmoPrincipalEditor.getFicha();
        this.setTitle(ficha.getNick());
        jTextPane.setText(ficha.getDescricao());
        
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
        jButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Descrição");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jButton.setBackground(new java.awt.Color(102, 102, 102));
        jButton.setText("Salvar Alterações");
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });

        jTextPane.setBackground(new java.awt.Color(51, 51, 51));
        jTextPane.setForeground(new java.awt.Color(0, 255, 0));
        jTextPane.setCaretColor(new java.awt.Color(0, 255, 0));
        jTextPane.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jTextPane.setSelectionColor(new java.awt.Color(0, 255, 255));
        jScrollPane3.setViewportView(jTextPane);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton)
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

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
        Ficha ficha = AlgoritmoPrincipalEditor.getFicha();
        ficha.setDescricao(jTextPane.getText());
        
        
        // SALVANDO A DESCRICAO
        
        Connection conexao = ModuloConexao.conector();
        String sql = "update ficha set descricao = ? where nick = ?";
        PreparedStatement pst = null;
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, ficha.getDescricao());
            pst.setString(2, ficha.getNick());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Descrição salva com sucesso!",
                    "Success!", JOptionPane.INFORMATION_MESSAGE);
            
            this.dispose();
            
        } catch (SQLException ex) {
            // mensagem ao programador (no netbeans)
            Logger.getLogger(View_descricao.class.getName()).log(Level.SEVERE, null, ex);
            
            int option = JOptionPane.showConfirmDialog(null, "A descrição não foi salva!\n"
                    + "Deseja fechar essa janela SEM salvar seu texto?", "Error!",
                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            
            switch (option) {
                case JOptionPane.YES_OPTION :
                    this.dispose();
            }
        }
    }//GEN-LAST:event_jButtonActionPerformed

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
            java.util.logging.Logger.getLogger(View_descricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            View_descricao dialog = new View_descricao(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane;
    // End of variables declaration//GEN-END:variables
}
