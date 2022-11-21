/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.batalhas;

import algoritmos.batalhas.AlgoritmoPrincipal;
import ficha_personagem.Extensao;
import ficha_personagem.Ficha;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 422UR4H
 */
public class View_corpo extends javax.swing.JDialog {

    /**
     * Creates new form View_corpo
     * @param parent
     * @param modal
     */
    public View_corpo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        
        // meu codigo
        
        Ficha personagem = AlgoritmoPrincipal.getFicha();
        
        // carregando a jComboBox
        for (String nome : personagem.getHabilidades().keySet()) {
            jComboBoxHabilidade.addItem(nome);
        }
        jComboBoxHabilidade.addItem("OUTROS");
        
        // carregando jTable
        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        for (String nome : personagem.getCorpo().getHabilidades().keySet()) {
            Object[] vetor = {
                nome,
                personagem.getCorpo().getHabilidade(nome).getVolume(),
                personagem.getCorpo().getHabilidade(nome).getQtd()
            };
            dtm.addRow(vetor);
        }
        
        // carregando outros valores na jTextField
        jTextFieldOutros.setText(String.valueOf(personagem.getCorpo().getHabilidade("OUTROS").getVolume()));
        if (jComboBoxHabilidade.getSelectedItem().toString().equals("OUTROS")) {
            jTextFieldOutros.setEnabled(true);
        } else {
            jTextFieldOutros.setEnabled(false);
        }
        
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

        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxHabilidade = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jSeparator8 = new javax.swing.JSeparator();
        jButtonFechar = new javax.swing.JButton();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonVisualizarNen = new javax.swing.JButton();
        jTextFieldCorpo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldOutros = new javax.swing.JTextField();
        jTextFieldVolume = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Corpo");
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("CORPO");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBoxHabilidade.setBackground(new java.awt.Color(102, 102, 102));
        jComboBoxHabilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxHabilidadeActionPerformed(evt);
            }
        });

        jLabel14.setText("Habilidade: ");

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("VOLUME");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable.setBackground(new java.awt.Color(51, 51, 51));
        jTable.setForeground(new java.awt.Color(0, 200, 120));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Volume", "Qtd"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane7.setViewportView(jTable);

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(51, 51, 51));

        jButtonFechar.setBackground(new java.awt.Color(51, 51, 51));
        jButtonFechar.setText("Fechar");
        jButtonFechar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jButtonAdicionar.setBackground(new java.awt.Color(51, 51, 51));
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonRemover.setBackground(new java.awt.Color(51, 51, 51));
        jButtonRemover.setText("Remover");
        jButtonRemover.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonVisualizarNen.setBackground(new java.awt.Color(51, 51, 51));
        jButtonVisualizarNen.setText("Visualizar Nen");
        jButtonVisualizarNen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonVisualizarNen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizarNenActionPerformed(evt);
            }
        });

        jTextFieldCorpo.setEditable(false);
        jTextFieldCorpo.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldCorpo.setForeground(new java.awt.Color(0, 200, 120));
        jTextFieldCorpo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCorpo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldCorpo.setCaretColor(new java.awt.Color(0, 200, 120));
        jTextFieldCorpo.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("OUTROS");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextFieldOutros.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldOutros.setForeground(new java.awt.Color(0, 200, 120));
        jTextFieldOutros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldOutros.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldOutros.setCaretColor(new java.awt.Color(0, 200, 120));
        jTextFieldOutros.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldOutros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldOutrosFocusGained(evt);
            }
        });

        jTextFieldVolume.setEditable(false);
        jTextFieldVolume.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldVolume.setForeground(new java.awt.Color(0, 200, 120));
        jTextFieldVolume.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldVolume.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldVolume.setCaretColor(new java.awt.Color(0, 200, 120));
        jTextFieldVolume.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonVisualizarNen, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator8)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxHabilidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxHabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVisualizarNen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxHabilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxHabilidadeActionPerformed
        if (jComboBoxHabilidade.getSelectedItem() == null) {
            return;
        }

        String nome = jComboBoxHabilidade.getSelectedItem().toString();
        Ficha ficha = AlgoritmoPrincipal.getFicha();
        Extensao habilidade = new Extensao();
        habilidade.setNome(nome);
        habilidade.setGuardada(false);
        if (nome.equals("OUTROS")) {
            habilidade.setVolume(ficha.getCorpo().getHabilidade("OUTROS").getVolume());
            jTextFieldOutros.setEnabled(true);
        } else {
            habilidade.setVolume(ficha.getHabilidade(nome).getVol());
            jTextFieldOutros.setEnabled(false);
        }

        // inserindo valores nas labels
        jTextFieldVolume.setText(String.valueOf(habilidade.getVolume()));

        // setando valor na label de corpo
        jTextFieldCorpo.setText(String.valueOf(ficha.getCorpo().getValor()));
    }//GEN-LAST:event_jComboBoxHabilidadeActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void adicionar() {
        if (jComboBoxHabilidade.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Escolha uma Habilidade!", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        Object[] vetor = new Object[3];
        Extensao extensao = new Extensao();
        Ficha personagem = AlgoritmoPrincipal.getFicha();
        String nomeSkill = jComboBoxHabilidade.getSelectedItem().toString();

        // adicionando no corpo do personagem
        try {
            if (nomeSkill.equals("OUTROS")) {
                personagem.getCorpo().incrementaOutros(Integer.parseInt(jTextFieldOutros.getText()));
                // atualizando jTable
                // procurando a linha que contem a extensao OUTROS, pelo nome
                int linha;
                for (linha = 0; linha < jTable.getRowCount(); linha++) {
                    if (jTable.getValueAt(linha, 0).equals("OUTROS")) {
                        break;
                    }
                }
                jTable.setValueAt(personagem.getCorpo().getHabilidade("OUTROS").getVolume(), linha, 1);
                jTextFieldVolume.setText(String.valueOf(personagem.getCorpo().getHabilidade("OUTROS").getVolume()));
                jTextFieldCorpo.setText(String.valueOf(personagem.getCorpo().getValor()));

                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite o valor do volume", "Error!", JOptionPane.ERROR_MESSAGE);
            
            return;
        }
        
        extensao.setNome(nomeSkill);
        try {
            extensao.setVolume(Integer.parseInt(jTextFieldVolume.getText()));
        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(null, "Entre com um valor inteiro válido", 
                    "Error!", JOptionPane.ERROR_MESSAGE);

            return;
        }
        personagem.getCorpo().putHabilidade(extensao);

        // adicionando na jTable
        // recopiando o valor da extensao(nome) para e, para receber o valor correto de qtd
        extensao = personagem.getCorpo().getHabilidade(extensao.getNome());
        vetor[0] = extensao.getNome();
        vetor[1] = extensao.getVolume();
        vetor[2] = extensao.getQtd();
        // inserindo na tabela se for a primeira habilidade(do Tipo)
        if (extensao.getQtd() == 1) {
            dtm.addRow(vetor);
        } else { // nesse caso, so aumentamos qtd
            // estamos procurando qual linha contem as informacoes da extensao, pelo nome
            int linha;
            for (linha = 0; linha < jTable.getRowCount(); linha++) {
                // testando se os nomes da habilidade estão iguais
                if (jTable.getValueAt(linha, 0).toString().equals(extensao.getNome())) {
                    break;
                }
            }
            dtm.setValueAt(extensao.getQtd(), linha, 2);
        }
        
        // setando jLabelCorpo
        jTextFieldCorpo.setText(String.valueOf(personagem.getCorpo().getValor()));
    }
    
    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        Ficha personagem = AlgoritmoPrincipal.getFicha();
        int linha = jTable.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Escolha um item na tabela para excluir!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String nome = String.valueOf(jTable.getValueAt(linha, 0));
        //String nome = jLabelNomeHabilidade.getText();

        // removendo da jTable
        if (personagem.getCorpo().getHabilidade(nome).getQtd() > 1) {
            // decrementando o valor da habilidade e do valor do corpo
            if (!personagem.getCorpo().decrementaHabilidade(nome)) {
                JOptionPane.showMessageDialog(null, "Nao é possivel decrementar OUTROS",
                    "Erro de lógica! - Reporte", JOptionPane.ERROR_MESSAGE);
            }
            // inserimos o valor decrementado de qtd na qtd antiga
            jTable.setValueAt((int) jTable.getValueAt(linha, 2) - 1, linha, 2);
        } else { // qtd == 1
            // removendo o valor da habilidade e do valor do corpo
            if (!personagem.getCorpo().removeHabilidade(nome)) {
                JOptionPane.showMessageDialog(null, "Nao é possivel remover OUTROS",
                    "Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // removendo a habilidade da jTable
            dtm.removeRow(linha);
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonVisualizarNenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizarNenActionPerformed
        new ViewNenCorpo().setVisible(true);
    }//GEN-LAST:event_jButtonVisualizarNenActionPerformed

    private void jTextFieldOutrosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldOutrosFocusGained
        jTextFieldOutros.selectAll();
    }//GEN-LAST:event_jTextFieldOutrosFocusGained

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View_corpo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_corpo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_corpo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_corpo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                View_corpo dialog = new View_corpo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonVisualizarNen;
    private javax.swing.JComboBox<String> jComboBoxHabilidade;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldCorpo;
    private javax.swing.JTextField jTextFieldOutros;
    private javax.swing.JTextField jTextFieldVolume;
    // End of variables declaration//GEN-END:variables
}