/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.batalhas;

import algoritmos.batalhas.AlgoritmoPrincipal;
import algoritmos.trainer.AlgoritmoPrincipalTrainer;
import algoritmos.trainer.CalculadoraTrainer;
import ficha_personagem.Ficha;
import ficha_personagem.LvlExp;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.trainer.View_distribuir;

/**
 *
 * @author 422UR4H
 */
public class View_treinoNen extends javax.swing.JDialog {

    private int qtd = 0;
    
    /**
     * Creates new form View_treinoNen
     * @param parent
     * @param modal
     */
    public View_treinoNen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        
        // MEU CODIGO
        
        try {
            AlgoritmoPrincipalTrainer.init();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(View_treinoNen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Ficha ficha = AlgoritmoPrincipal.getFicha();
        String nomeTreino = AlgoritmoPrincipal.getLinha();
        
        jLabelNome.setText(ficha.getNick());
        
        // setando informações de lvl
        jLabelLvlAtual.setText(String.valueOf(ficha.getAtr().get(nomeTreino).getLvl()));
        jLabelExpInicial.setText(String.valueOf(ficha.getAtr().get(nomeTreino).getExp()));
        jLabelLevel.setText(String.valueOf(ficha.getLvl()));
        jLabelNen.setText(String.valueOf(ficha.getLvlNen()));
        
        
        // iniciando jProgressBars
        // valores maximos
        if (nomeTreino.equals("MOP")) {
            // a tabela de exp de MOP é diferente das demais
            jProgressBarLvlAtual.setMaximum(CalculadoraTrainer.getExpMop(ficha.getAtr().get("MOP").getLvl() + 1));
        } else {
            jProgressBarLvlAtual.setMaximum(AlgoritmoPrincipal.getEXP_NEN(ficha.getAtr().get(nomeTreino).getLvl() + 1));
        }
        jProgressBarLevel.setMaximum(AlgoritmoPrincipal.getEXP_LVL(ficha.getLvl() + 1));
        jProgressBarNen.setMaximum(AlgoritmoPrincipal.getLVL_NEN(ficha.getLvlNen() + 1));
        // valores atuais
        jProgressBarLvlAtual.setValue(ficha.getAtr().get(nomeTreino).getExp());
        jProgressBarLevel.setValue(ficha.getExp());
        jProgressBarNen.setValue(ficha.getExpNen());
        
        // setando perícia
        switch (nomeTreino) {
            case "AOP":
                CalculadoraTrainer.setModClas(1.0);
                AlgoritmoPrincipal.setValor(ficha.getPerFor());
                jLabelPer.setText(String.valueOf(ficha.getPerFor()));
                break;
            case "MOP":
                CalculadoraTrainer.setModClas(1.0);
                AlgoritmoPrincipal.setValor(ficha.getPerCon());
                jLabelPer.setText(String.valueOf(ficha.getPerCon()));
                break;
            case "RYU":
                CalculadoraTrainer.setModClas(1.0);
                AlgoritmoPrincipal.setValor(ficha.getPerCdn());
                jLabelPer.setText(String.valueOf(ficha.getPerCdn()));
                break;
            case "REF":
                switch (ficha.getNen()) {
                    case "Reforco":
                        CalculadoraTrainer.setModClas(1.0);
                        break;
                    case "Emissao":
                        CalculadoraTrainer.setModClas(0.8);
                        break;
                    case "Manipulacao":
                        CalculadoraTrainer.setModClas(0.6);
                        break;
                    case "Materializacao":
                        CalculadoraTrainer.setModClas(0.6);
                        break;
                    case "Transformacao":
                        CalculadoraTrainer.setModClas(0.8);
                        break;
                    case "Especializacao":
                        CalculadoraTrainer.setModClas(0.4);
                        break;
                }
                AlgoritmoPrincipal.setValor(ficha.getPerInt());
                jLabelPer.setText(String.valueOf(ficha.getPerInt()));
                break;
            case "EMS":
                switch (ficha.getNen()) {
                    case "Reforco":
                        CalculadoraTrainer.setModClas(0.8);
                        break;
                    case "Emissao":
                        CalculadoraTrainer.setModClas(1.0);
                        break;
                    case "Manipulacao":
                        CalculadoraTrainer.setModClas(0.8);
                        break;
                    case "Materializacao":
                        CalculadoraTrainer.setModClas(0.4);
                        break;
                    case "Transformacao":
                        CalculadoraTrainer.setModClas(0.6);
                        break;
                    case "Especialista":
                        CalculadoraTrainer.setModClas(0.6);
                        break;
                }
                AlgoritmoPrincipal.setValor(ficha.getPerInt());
                jLabelPer.setText(String.valueOf(ficha.getPerInt()));
                break;
            case "TRS":
                switch (ficha.getNen()) {
                    case "Reforco":
                        CalculadoraTrainer.setModClas(0.8);
                        break;
                    case "Emissao":
                        CalculadoraTrainer.setModClas(0.6);
                        break;
                    case "Manipulacao":
                        CalculadoraTrainer.setModClas(0.4);
                        break;
                    case "Materializacao":
                        CalculadoraTrainer.setModClas(0.8);
                        break;
                    case "Transformacao":
                        CalculadoraTrainer.setModClas(1.0);
                        break;
                    case "Especialista":
                        CalculadoraTrainer.setModClas(0.6);
                        break;
                }
                AlgoritmoPrincipal.setValor(ficha.getPerInt());
                jLabelPer.setText(String.valueOf(ficha.getPerInt()));
                break;
            case "MAN":
                switch (ficha.getNen()) {
                    case "Reforco":
                        CalculadoraTrainer.setModClas(0.6);
                        break;
                    case "Emissao":
                        CalculadoraTrainer.setModClas(0.8);
                        break;
                    case "Manipulacao":
                        CalculadoraTrainer.setModClas(1.0);
                        break;
                    case "Materializacao":
                        CalculadoraTrainer.setModClas(0.6);
                        break;
                    case "Transformacao":
                        CalculadoraTrainer.setModClas(0.4);
                        break;
                    case "Especialista":
                        CalculadoraTrainer.setModClas(0.8);
                        break;
                }
                AlgoritmoPrincipal.setValor(ficha.getPerInt());
                jLabelPer.setText(String.valueOf(ficha.getPerInt()));
                break;
            case "MAT":
                switch (ficha.getNen()) {
                    case "Reforco":
                        CalculadoraTrainer.setModClas(0.6);
                        break;
                    case "Emissao":
                        CalculadoraTrainer.setModClas(0.4);
                        break;
                    case "Manipulacao":
                        CalculadoraTrainer.setModClas(0.6);
                        break;
                    case "Materializacao":
                        CalculadoraTrainer.setModClas(1.0);
                        break;
                    case "Transformacao":
                        CalculadoraTrainer.setModClas(0.8);
                        break;
                    case "Especialista":
                        CalculadoraTrainer.setModClas(0.8);
                        break;
                }
                AlgoritmoPrincipal.setValor(ficha.getPerInt());
                jLabelPer.setText(String.valueOf(ficha.getPerInt()));
                break;
            case "ESP":
                switch (ficha.getNen()) {
                    case "Reforco":
                        CalculadoraTrainer.setModClas(0.4);
                        break;
                    case "Emissao":
                        CalculadoraTrainer.setModClas(0.6);
                        break;
                    case "Manipulacao":
                        CalculadoraTrainer.setModClas(0.8);
                        break;
                    case "Materializacao":
                        CalculadoraTrainer.setModClas(0.8);
                        break;
                    case "Transformacao":
                        CalculadoraTrainer.setModClas(0.6);
                        break;
                    case "Especialista":
                        CalculadoraTrainer.setModClas(1.0);
                        break;
                }
                AlgoritmoPrincipal.setValor(ficha.getPerInt());
                jLabelPer.setText(String.valueOf(ficha.getPerInt()));
                break;
            default:
                CalculadoraTrainer.setModClas(1.0);
                AlgoritmoPrincipal.setValor(ficha.getPerInt());
                jLabelPer.setText(String.valueOf(ficha.getPerInt()));
                break;
        }
        
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
        jPanel2 = new javax.swing.JPanel();
        jLabelDado = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelPer = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelExpInicial = new javax.swing.JLabel();
        jLabelLvlAtual = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldDado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonDadoOk = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButtonFechar = new javax.swing.JButton();
        jProgressBarLvlAtual = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        jLabelLevel = new javax.swing.JLabel();
        jProgressBarLevel = new javax.swing.JProgressBar();
        jProgressBarNen = new javax.swing.JProgressBar();
        jLabelNen = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Treino Nen");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabelDado.setBackground(new java.awt.Color(102, 102, 102));
        jLabelDado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel9.setBackground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("+");

        jLabel10.setBackground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Per");

        jLabelPer.setBackground(new java.awt.Color(102, 102, 102));
        jLabelPer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel12.setBackground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("=");

        jLabel13.setBackground(new java.awt.Color(102, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Total");

        jLabelTotal.setBackground(new java.awt.Color(102, 102, 102));
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel15.setBackground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Exp Inicial: ");

        jLabelExpInicial.setBackground(new java.awt.Color(102, 102, 102));
        jLabelExpInicial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelLvlAtual.setBackground(new java.awt.Color(102, 102, 102));
        jLabelLvlAtual.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setBackground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("Lvl Atual: ");

        jTextFieldDado.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldDado.setForeground(new java.awt.Color(0, 255, 0));
        jTextFieldDado.setCaretColor(new java.awt.Color(0, 255, 0));
        jTextFieldDado.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldDado.setSelectionColor(new java.awt.Color(0, 255, 255));
        jTextFieldDado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDadoFocusGained(evt);
            }
        });
        jTextFieldDado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDadoKeyPressed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Dado:");

        jButtonDadoOk.setBackground(new java.awt.Color(102, 102, 102));
        jButtonDadoOk.setText("OK");
        jButtonDadoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDadoOkActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Dado");

        jButtonFechar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonFechar.setText("FECHAR");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jProgressBarLvlAtual.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBarLvlAtual.setString("");
        jProgressBarLvlAtual.setStringPainted(true);
        jProgressBarLvlAtual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarLvlAtualMouseEntered(evt);
            }
        });

        jLabel4.setText("Level: ");

        jLabelLevel.setBackground(new java.awt.Color(102, 102, 102));
        jLabelLevel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jProgressBarLevel.setForeground(new java.awt.Color(255, 0, 0));
        jProgressBarLevel.setString("");
        jProgressBarLevel.setStringPainted(true);
        jProgressBarLevel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarLevelMouseEntered(evt);
            }
        });

        jProgressBarNen.setForeground(new java.awt.Color(255, 0, 0));
        jProgressBarNen.setString("");
        jProgressBarNen.setStringPainted(true);
        jProgressBarNen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarNenMouseEntered(evt);
            }
        });

        jLabelNen.setBackground(new java.awt.Color(102, 102, 102));
        jLabelNen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Nen: ");

        jLabelNome.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarNen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jProgressBarLevel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jProgressBarLvlAtual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDadoOk))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelExpInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelLvlAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelPer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonDadoOk)
                        .addComponent(jTextFieldDado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDado, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPer, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelExpInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLvlAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jProgressBarLvlAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabelLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jProgressBarLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabelNen, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jProgressBarNen, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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

    private void upgradeNen(LvlExp lvlExp) {
        // mensagem de upgrade ao usuário
        JOptionPane.showMessageDialog(null, "Seu atributo de nen subiu!",
                "Congratulations!", JOptionPane.INFORMATION_MESSAGE);

        // setando novo lvl na jLabelLvlAtual
        jLabelLvlAtual.setText(String.valueOf(lvlExp.getLvl()));
    }
    
    private void upgradeLvl() {
        // mensagem de upgrade ao usuário
        JOptionPane.showMessageDialog(null, "Seu personagem subiu de nível!",
                "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
        
        // abrindo ViewDistribuir
        AlgoritmoPrincipalTrainer.setFicha(AlgoritmoPrincipal.getPerson(jLabelNome.getText()));
        new View_distribuir(null, true).setVisible(true);
        
        // setando jLabelLevel
        jLabelLevel.setText(String.valueOf(AlgoritmoPrincipal.getPerson(jLabelNome.getText()).getLvl()));
    }
    
    public void calculaExp() {
        int dado;
        
        // testando valor valido do dado
        try {
            dado = Integer.parseInt(jTextFieldDado.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entre com um valor inteiro válido",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            
            jTextFieldDado.selectAll();
            return;
        }
        if (dado < 1 || dado > 20) {
            JOptionPane.showMessageDialog(null, "Entre com um valor do D20!",
                    "Logic Error!", JOptionPane.ERROR_MESSAGE);
            
            jTextFieldDado.selectAll();
            return;
        }
        
        
        Ficha ficha = AlgoritmoPrincipal.getPerson(jLabelNome.getText());
        LvlExp lvlExp = ficha.getAtr(AlgoritmoPrincipal.getLinha());
        
        // setando valor do dado
        jLabelDado.setText(String.valueOf(dado));
        // setando valor total
        int exp = (int) ((dado + AlgoritmoPrincipal.getValor()) * ((double) ficha.getExpBonus() / 100.0 + 1.0));
        // multiplicando exp por 2, caso 20 natural
        if (dado == 20) {
            exp *= 2;
        }
        jLabelTotal.setText(String.valueOf(exp));
        
        // calculando exp
        // testando se lvlExp é MOP
        if (AlgoritmoPrincipal.getLinha().equals("MOP")) {
            // CalculadoraUpper.putExpMop retorna true se o atributo upar e false se não upar
            if (CalculadoraTrainer.putExpMop(exp, lvlExp)) {
                jProgressBarLvlAtual.setMaximum(CalculadoraTrainer.getExpMop(lvlExp.getLvl() + 1));
                jProgressBarLvlAtual.setValue(lvlExp.getExp());
                upgradeNen(lvlExp);
                
                // incrementando exp do up na ficha
                // CalculadoraUpper.putExpFicha retorna true se a ficha upar e false se não upar
                if (CalculadoraTrainer.putExpFicha(lvlExp.getLvl() * 10 + 80, ficha)) {
                    jProgressBarLevel.setMaximum(AlgoritmoPrincipal.getEXP_LVL(ficha.getLvl() + 1));
                    jProgressBarLevel.setValue(ficha.getExp());
                    upgradeLvl();
                } else { // mesmo se o personagem nao upar, sua jProgressBar ganha exp
                    jProgressBarLevel.setValue(ficha.getExp());
                }

                // incrementando exp em exp nen
                CalculadoraTrainer.putExpLvlNen(lvlExp.getLvl() * 10 + 80, ficha);
                jLabelNen.setText(String.valueOf(ficha.getLvlNen()));
                jProgressBarNen.setValue(ficha.getExpNen());
                
                // atualizando mop
                ficha.setMopAtual(ficha.getMop() * 1000);
                ficha.setMopMax(ficha.getMop() * 1000);
            } else { // mesmo se o atributo não upar, a jProgressBar ganha exp
                jProgressBarLvlAtual.setValue(lvlExp.getExp());
            }
        } else {
            // CalculadoraUpper.putExpNen retorna true se o atributo upar e false se não upar
            if (CalculadoraTrainer.putExpNen(exp, lvlExp)) {
                jProgressBarLvlAtual.setMaximum(AlgoritmoPrincipal.getEXP_NEN(lvlExp.getLvl() + 1));
                jProgressBarLvlAtual.setValue(lvlExp.getExp());
                upgradeNen(lvlExp);
                
                // incrementando exp do up na ficha
                // CalculadoraUpper.putExpFicha retorna true se a ficha upar e false se não upar
                if (CalculadoraTrainer.putExpFicha(AlgoritmoPrincipal.getEXP_NEN(lvlExp.getLvl()), ficha)) {
                    jProgressBarLevel.setMaximum(AlgoritmoPrincipal.getEXP_LVL(ficha.getLvl() + 1));
                    jProgressBarLevel.setValue(ficha.getExp());
                    upgradeLvl();
                } else { // mesmo se o personagem nao upar, sua jProgressBar ganha exp
                    jProgressBarLevel.setValue(ficha.getExp());
                }

                // incrementando exp em exp nen
                CalculadoraTrainer.putExpLvlNen(AlgoritmoPrincipal.getEXP_NEN(lvlExp.getLvl()), ficha);
                jLabelNen.setText(String.valueOf(ficha.getLvlNen()));
                jProgressBarNen.setValue(ficha.getExpNen());
            } else { // mesmo se o atributo não upar, a jProgressBar ganha exp
                jProgressBarLvlAtual.setValue(lvlExp.getExp());
            }
        }
        
        // testando caso do 20
        if (dado == 20 && lvlExp.getLvl() < 40) {
            // incrementando lvl
            lvlExp.incrementaLvl();
            
            // zerando exp
            lvlExp.setExp(0);
            
            // enviando mensagem ao usuario, *desbilitando campos e setanto lvl na label
            jProgressBarLvlAtual.setValue(0);
            upgradeNen(lvlExp);
            
            // incrementando exp do up na ficha
            // testando se lvlExp é MOP
            if (AlgoritmoPrincipal.getLinha().equals("MOP")) {
                jProgressBarLvlAtual.setMaximum(CalculadoraTrainer.getExpMop(lvlExp.getLvl() + 1));
                // CalculadoraUpper.putExpFicha retorna true se a ficha upar e false se não upar
                if (CalculadoraTrainer.putExpFicha(lvlExp.getLvl() * 10 + 80, ficha)) {
                    jProgressBarLevel.setMaximum(AlgoritmoPrincipal.getEXP_LVL(ficha.getLvl() + 1));
                    jProgressBarLevel.setValue(ficha.getExp());
                    upgradeLvl();
                } else { // mesmo se o personagem nao upar, sua jProgressBar ganha exp
                    jProgressBarLevel.setValue(ficha.getExp());
                }
                
                // atualizando mop
                ficha.setMopAtual(ficha.getMop() * 1000);
                ficha.setMopMax(ficha.getMop() * 1000);
            } else {
                jProgressBarLvlAtual.setMaximum(AlgoritmoPrincipal.getEXP_NEN(lvlExp.getLvl() + 1));
                // CalculadoraUpper.putExpFicha retorna true se a ficha upar e false se não upar
                if (CalculadoraTrainer.putExpFicha(AlgoritmoPrincipal.getEXP_NEN(lvlExp.getLvl()), ficha)) {
                    jProgressBarLevel.setMaximum(AlgoritmoPrincipal.getEXP_LVL(ficha.getLvl() + 1));
                    jProgressBarLevel.setValue(ficha.getExp());
                    upgradeLvl();
                } else { // mesmo se o personagem nao upar, sua jProgressBar ganha exp
                    jProgressBarLevel.setValue(ficha.getExp());
                }
            }
            
            // incrementando exp em exp nen
            CalculadoraTrainer.putExpLvlNen(AlgoritmoPrincipal.getEXP_NEN(lvlExp.getLvl()), ficha);
            jLabelNen.setText(String.valueOf(ficha.getLvlNen()));
            jProgressBarNen.setValue(ficha.getExpNen());
        }
        
        // decrementando a quantidade de treinos
        AlgoritmoPrincipalTrainer.decQtd();
        
        if (AlgoritmoPrincipalTrainer.getQtd() < 1) {
            // desabilitando jText e jButton
            jTextFieldDado.setEnabled(false);
            jButtonDadoOk.setEnabled(false);
        }
    }
    
    private void jTextFieldDadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDadoFocusGained
        jTextFieldDado.selectAll();
    }//GEN-LAST:event_jTextFieldDadoFocusGained

    private void jTextFieldDadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDadoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            calculaExp();
        }
    }//GEN-LAST:event_jTextFieldDadoKeyPressed

    private void jButtonDadoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDadoOkActionPerformed
        calculaExp();
    }//GEN-LAST:event_jButtonDadoOkActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jProgressBarLvlAtualMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarLvlAtualMouseEntered
        jProgressBarLvlAtual.setToolTipText(jProgressBarLvlAtual.getValue()+"/"+jProgressBarLvlAtual.getMaximum());
    }//GEN-LAST:event_jProgressBarLvlAtualMouseEntered

    private void jProgressBarLevelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarLevelMouseEntered
        jProgressBarLevel.setToolTipText(jProgressBarLevel.getValue()+"/"+jProgressBarLevel.getMaximum());
    }//GEN-LAST:event_jProgressBarLevelMouseEntered

    private void jProgressBarNenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarNenMouseEntered
        jProgressBarNen.setToolTipText(jProgressBarNen.getValue()+"/"+jProgressBarNen.getMaximum());
    }//GEN-LAST:event_jProgressBarNenMouseEntered

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
            java.util.logging.Logger.getLogger(View_treinoNen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            View_treinoNen dialog = new View_treinoNen(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonDadoOk;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDado;
    private javax.swing.JLabel jLabelExpInicial;
    private javax.swing.JLabel jLabelLevel;
    private javax.swing.JLabel jLabelLvlAtual;
    private javax.swing.JLabel jLabelNen;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPer;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBarLevel;
    private javax.swing.JProgressBar jProgressBarLvlAtual;
    private javax.swing.JProgressBar jProgressBarNen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldDado;
    // End of variables declaration//GEN-END:variables
}
