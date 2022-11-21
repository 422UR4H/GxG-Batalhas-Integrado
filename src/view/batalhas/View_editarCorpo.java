/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.batalhas;

import algoritmos.batalhas.AlgoritmoPrincipal;
import ficha_personagem.Extensao;
import ficha_personagem.Ficha;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 422UR4H
 */
public class View_editarCorpo extends javax.swing.JDialog {

    /**
     * Creates new form View_editarCorpo
     */
    public View_editarCorpo(java.awt.Frame parent, boolean modal) {
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
            String linha;
            if (personagem.getCorpo().getHabilidade(nome).isGuardada()) {
                linha = "sim";
            } else {
                linha = "não";
            }
            Object[] vetor = {
                nome,
                personagem.getCorpo().getHabilidade(nome).getVolume(),
                linha,
                personagem.getCorpo().getHabilidade(nome).getQtd()
            };
            dtm.addRow(vetor);
        }
        
        // carregando outros valores na jTextField
        jTextField.setText(String.valueOf(personagem.getCorpo().getHabilidade("OUTROS").getVolume()));
        if (jComboBoxHabilidade.getSelectedItem().toString().equals("OUTROS")) {
            jTextField.setEnabled(true);
        } else {
            jTextField.setEnabled(false);
        }
        
        // fim do meu codigo
    }
    
    private void adicionar() {
        if (jComboBoxHabilidade.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Escolha uma Habilidade!", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        Object[] vetor = new Object[4];
        Extensao e = new Extensao();
        Ficha personagem = AlgoritmoPrincipal.getFicha();

        // adicionando no corpo do personagem
        try {
            if (jLabelNomeHabilidade.getText().equals("OUTROS")) {
                personagem.getCorpo().incrementaOutros(Integer.parseInt(jTextField.getText()));
                // atualizando jTable
                // procurando a linha que contem a extensao OUTROS, pelo nome
                int linha;
                for (linha = 0; linha < jTable.getRowCount(); linha++) {
                    if (jTable.getValueAt(linha, 0).equals("OUTROS")) {
                        break;
                    }
                }
                jTable.setValueAt(personagem.getCorpo().getHabilidade("OUTROS").getVolume(), linha, 1);
                jLabelVolume.setText(String.valueOf(personagem.getCorpo().getHabilidade("OUTROS").getVolume()));
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite o valor do volume", "Error!", JOptionPane.ERROR_MESSAGE);
            
            return;
        }
        
        e.setNome(jLabelNomeHabilidade.getText());
        e.setGuardada(jCheckBoxGuardada.isSelected());
        try {
            e.setVolume(Integer.parseInt(jLabelVolume.getText()));
        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(null, "Entre com um valor inteiro válido", 
                    "Error!", JOptionPane.ERROR_MESSAGE);

            return;
        }
        personagem.getCorpo().putHabilidade(e);

        // adicionando na jTable
        // recopiando o valor da extensao(nome) para e, para receber o valor correto de qtd
        e = personagem.getCorpo().getHabilidade(e.getNome());
        vetor[0] = e.getNome();
        vetor[1] = e.getVolume();
        if (e.isGuardada()) {
            vetor[2] = "sim";
        } else {
            vetor[2] = "não";
        }
        vetor[3] = e.getQtd();
        // inserindo na tabela se for a primeira habilidade(do Tipo)
        if (e.getQtd() == 1) {
            dtm.addRow(vetor);
        } else { // nesse caso, so aumentamos qtd
            // estamos procurando qual linha contem as informacoes da extensao, pelo nome
            int linha;
            for (linha = 0; linha < jTable.getRowCount(); linha++) {
                // testando se alem do nome da habilidade, seu estado (guardado) estão iguais
                if (jTable.getValueAt(linha, 0).toString().equals(e.getNome()) &&
                        jTable.getValueAt(linha, 2).equals(vetor[2])) {
                    break;
                }
            }
            dtm.setValueAt(e.getQtd(), linha, 3);
        }
        
        // setando jLabelCorpo
        jLabelCorpo.setText(String.valueOf(personagem.getCorpo().getValor()));
        
        // incrementando o valor de shu
        if (!jLabelNomeHabilidade.getText().equals("OUTROS")) {
            JOptionPane.showMessageDialog(null, "O valor de Shu foi incrementado em uma unidade!");
            personagem.incrementarShu();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabelNomePersonagem = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelCorpo = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jComboBoxHabilidade = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelNomeHabilidade = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabelVolume = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jSeparator8 = new javax.swing.JSeparator();
        jButtonFechar = new javax.swing.JButton();
        jCheckBoxGuardada = new javax.swing.JCheckBox();
        jButtonHelp = new javax.swing.JButton();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jTextField = new javax.swing.JTextField();
        jButtonVisualizarNen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Corpo");
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel6.setText("Nome: ");

        jLabel13.setText("Corpo: ");

        jLabelCorpo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jComboBoxHabilidade.setBackground(new java.awt.Color(102, 102, 102));
        jComboBoxHabilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxHabilidadeActionPerformed(evt);
            }
        });

        jLabel14.setText("Habilidade: ");

        jLabel15.setText("Nome: ");

        jLabel16.setText("Volume: ");

        jLabelVolume.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jTable.setBackground(new java.awt.Color(51, 51, 51));
        jTable.setForeground(new java.awt.Color(0, 255, 0));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Volume", "Guardado", "Qtd"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setSelectionBackground(new java.awt.Color(0, 255, 255));
        jTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane7.setViewportView(jTable);

        jButtonFechar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jCheckBoxGuardada.setBackground(new java.awt.Color(102, 102, 102));
        jCheckBoxGuardada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxGuardada.setText("Guardada");
        jCheckBoxGuardada.setEnabled(false);
        jCheckBoxGuardada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButtonHelp.setBackground(new java.awt.Color(102, 102, 102));
        jButtonHelp.setText("Help");
        jButtonHelp.setEnabled(false);

        jButtonAdicionar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonRemover.setBackground(new java.awt.Color(102, 102, 102));
        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jTextField.setBackground(new java.awt.Color(51, 51, 51));
        jTextField.setForeground(new java.awt.Color(0, 255, 0));
        jTextField.setCaretColor(new java.awt.Color(0, 255, 0));
        jTextField.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jTextField.setSelectionColor(new java.awt.Color(0, 255, 255));
        jTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldFocusGained(evt);
            }
        });
        jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldKeyPressed(evt);
            }
        });

        jButtonVisualizarNen.setBackground(new java.awt.Color(102, 102, 102));
        jButtonVisualizarNen.setText("Visualizar Nen");
        jButtonVisualizarNen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizarNenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator8)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNomePersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonHelp))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBoxGuardada, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonVisualizarNen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNomeHabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxHabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVolume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabelNomePersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabelCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxHabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabelNomeHabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabelVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxGuardada)
                    .addComponent(jButtonVisualizarNen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemover)
                    .addComponent(jButtonAdicionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFechar)
                    .addComponent(jButtonHelp))
                .addContainerGap())
        );

        jScrollPane6.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxHabilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxHabilidadeActionPerformed
        if (jComboBoxHabilidade.getSelectedItem() == null) {
            return;
        }

        String nome = jComboBoxHabilidade.getSelectedItem().toString();
        Ficha personagem = AlgoritmoPrincipal.getFicha();
        Extensao habilidade = new Extensao();
        habilidade.setNome(nome);
        habilidade.setGuardada(false);
        if (nome.equals("OUTROS")) {
            habilidade.setVolume(personagem.getCorpo().getHabilidade("OUTROS").getVolume());
            jTextField.setEnabled(true);
        } else {
            habilidade.setVolume(personagem.getHabilidade(nome).getVol());
            jTextField.setEnabled(false);
        }

        // inserindo valores nas labels
        jLabelNomeHabilidade.setText(habilidade.getNome());
        jLabelVolume.setText(String.valueOf(habilidade.getVolume()));
        jCheckBoxGuardada.setSelected(habilidade.isGuardada());

        // setando valor na label de corpo
        jLabelCorpo.setText(String.valueOf(personagem.getCorpo().getValor()));
    }//GEN-LAST:event_jComboBoxHabilidadeActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

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
            jTable.setValueAt((int) jTable.getValueAt(linha, 3) - 1, linha, 3);
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
        // decrementando valor de shu
        JOptionPane.showMessageDialog(null, "O valor de Shu foi decrementado em uma unidade!");
        personagem.decrementarShu();
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldFocusGained
        jTextField.selectAll();
    }//GEN-LAST:event_jTextFieldFocusGained

    private void jTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            adicionar();
        }
    }//GEN-LAST:event_jTextFieldKeyPressed

    private void jButtonVisualizarNenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizarNenActionPerformed
        new ViewNenCorpo().setVisible(true);
    }//GEN-LAST:event_jButtonVisualizarNenActionPerformed

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
            java.util.logging.Logger.getLogger(View_editarCorpo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            View_editarCorpo dialog = new View_editarCorpo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonVisualizarNen;
    private javax.swing.JCheckBox jCheckBoxGuardada;
    private javax.swing.JComboBox<String> jComboBoxHabilidade;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCorpo;
    private javax.swing.JLabel jLabelNomeHabilidade;
    private javax.swing.JLabel jLabelNomePersonagem;
    private javax.swing.JLabel jLabelVolume;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField;
    // End of variables declaration//GEN-END:variables
}
