/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.batalhas;

import algoritmos.batalhas.AlgoritmoPrincipal;
import ficha_personagem.Ficha;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 422UR4H
 */
public class ViewInventario extends javax.swing.JFrame {

    /**
     * Creates new form ViewInventario
     */
    public ViewInventario() {
        initComponents();
        
        // meu codigo
        
        String nome = AlgoritmoPrincipal.getFicha().getNick();
        jTextArea.setText(AlgoritmoPrincipal.getFicha(nome).getInventario());
        
        // fim do meu codigo
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inventário");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jTextArea.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea.setColumns(20);
        jTextArea.setForeground(new java.awt.Color(0, 255, 0));
        jTextArea.setRows(5);
        jTextArea.setCaretColor(new java.awt.Color(0, 255, 0));
        jTextArea.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jTextArea.setSelectionColor(new java.awt.Color(0, 255, 255));
        jScrollPane2.setViewportView(jTextArea);

        jButton.setBackground(new java.awt.Color(102, 102, 102));
        jButton.setText("Salvar Alterações");
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addComponent(jButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        Map <String, Ficha> fichas;
        
        // carregando BD
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(AlgoritmoPrincipal.getDIR() + "dataBase\\BD_Fichas.dat"))) {
            try {
                fichas = (Map<String, Ficha>) ois.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ViewInventario.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            return;
        }
        
        // salvando inventario em BD carregado e na ficha ativa
        fichas.get(AlgoritmoPrincipal.getFicha().getNick()).setInventario(jTextArea.getText());
        AlgoritmoPrincipal.getFicha(AlgoritmoPrincipal.getFicha().getNick()).setInventario(jTextArea.getText());
        
        // salvando o BD com inventário alterado
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(AlgoritmoPrincipal.getDIR() + "dataBase\\BD_Fichas.dat"))) {
            oos.writeObject(fichas);
            oos.close();
        } catch (IOException e) {
            System.out.println(e.toString());
            return;
        }
        
        this.dispose();
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
            java.util.logging.Logger.getLogger(ViewInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ViewInventario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables
}
