/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.trainer;

import algoritmos.habilidades.CalculadoraHabilidades;
import algoritmos.trainer.AlgoritmoPrincipalTrainer;
import algoritmos.batalhas.AlgoritmoPrincipal;
import algoritmos.trainer.CalculadoraTrainer;
import ficha_personagem.Classes;
import ficha_personagem.Ficha;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 422UR4H
 */
public class View_distribuir extends javax.swing.JDialog {

    /**
     * Creates new form View_distribuir
     * @param parent
     * @param modal
     */
    public View_distribuir(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        
        // meu codigo
        
        Ficha ficha = AlgoritmoPrincipalTrainer.getFicha();

        // recalculando dados possivelmente alterados
        // setando pericias de atributos em ficha
        ficha.setPerCar();
        ficha.setPerFor();
        ficha.setPerCon();
        ficha.setPerDex();
        ficha.setPerMen();
        ficha.setPerInt();
        // setando outros valores
        ficha.setIni();
        ficha.setEsq();
        ficha.setCrt();
        ficha.setApr();
        ficha.setVel();
        ficha.setHp();
        ficha.setbIntCdn();
        
        // setando dados
        jLabelNick.setText(ficha.getNick());
        jLabelLvl.setText(String.valueOf(ficha.getLvl()));
        jLabelExp.setText(String.valueOf(ficha.getExp()));
        jLabelIni.setText(String.valueOf(ficha.getIni()));
        jLabelEsq.setText(String.valueOf(ficha.getEsq()));
        jLabelApr.setText(String.valueOf(ficha.getApr()));
        jLabelCdn.setText(String.valueOf(ficha.getPerCdn()));
        jLabelHp.setText(String.valueOf(ficha.getHpMax()));
        jLabelCrt.setText(String.valueOf(20 - ficha.getCrt()));
        jLabelRen.setText(String.valueOf(CalculadoraTrainer.getRen(ficha.getAtrRef(), ficha.getAop(), ficha.getTen())));
        jLabelVel.setText(String.valueOf(ficha.getVel()));
        
        // setando pontos
        CalculadoraTrainer.setPontos(1);
        jLabelPontos.setText(String.valueOf("1"));
        
        // setando valores iniciais de atributo
        jLabelCarIni.setText(String.valueOf(ficha.getIniCar()));
        jLabelConIni.setText(String.valueOf(ficha.getIniCon()));
        jLabelDexIni.setText(String.valueOf(ficha.getIniDex()));
        jLabelForIni.setText(String.valueOf(ficha.getIniFor()));
        jLabelIntIni.setText(String.valueOf(ficha.getIniInt()));
        jLabelMenIni.setText(String.valueOf(ficha.getIniMen()));
        
        // setando valores de atributo
        jLabelValCar.setText(String.valueOf(ficha.getValCar()));
        jLabelValCon.setText(String.valueOf(ficha.getValCon()));
        jLabelValDex.setText(String.valueOf(ficha.getValDex()));
        jLabelValFor.setText(String.valueOf(ficha.getValFor()));
        jLabelValInt.setText(String.valueOf(ficha.getValInt()));
        jLabelValMen.setText(String.valueOf(ficha.getValMen()));
        
        // setando modificadores de atributo
        jLabelModCar.setText(String.valueOf(ficha.getModCar()));
        jLabelModFor.setText(String.valueOf(ficha.getModFor()));
        jLabelModCon.setText(String.valueOf(ficha.getModCon()));
        jLabelModInt.setText(String.valueOf(ficha.getModInt()));
        jLabelModMen.setText(String.valueOf(ficha.getModMen()));
        jLabelModDex.setText(String.valueOf(ficha.getModDex()));
        
        // setando bonus de atributo
        jLabelBCar.setText(String.valueOf(ficha.getbCar()));
        jLabelBFor.setText(String.valueOf(ficha.getbFor()));
        jLabelBCon.setText(String.valueOf(ficha.getbCon()));
        jLabelBInt.setText(String.valueOf(ficha.getbInt()));
        jLabelBMen.setText(String.valueOf(ficha.getbMen()));
        jLabelBDex.setText(String.valueOf(ficha.getbDex()));
        
        // setando pericias de atributo
        jLabelPerCar.setText(String.valueOf(ficha.getPerCar()));
        jLabelPerFor.setText(String.valueOf(ficha.getPerFor()));
        jLabelPerCon.setText(String.valueOf(ficha.getPerCon()));
        jLabelPerInt.setText(String.valueOf(ficha.getPerInt()));
        jLabelPerMen.setText(String.valueOf(ficha.getPerMen()));
        jLabelPerDex.setText(String.valueOf(ficha.getPerDex()));
        // fim do meu codigo
    }

    // calcula novos valores de bonus
    private int calculaBonus(int bLv, int bFor, int valAtual, boolean valIncrementado) {
        /*
        int modAnterior;
        if (valIncrementado) {
            modAnterior = (valAtual - 1) / 2;
        } else {
            modAnterior = (valAtual + 1) / 2;
        }
        int modAtual = valAtual / 2;
        int perAnterior = modAnterior + bLv + bFor;
        int perAtual = modAtual + bLv + bFor;
        return ((perAtual - 10) / 10) - ((perAnterior - 10) / 10);
        */
        int valAnterior;
        if (valIncrementado) {
            valAnterior = valAtual - 1;
        } else {
            valAnterior = valAtual + 1;
        }
        return ((valAtual - 10) / 10) - ((valAnterior - 10) / 10);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabelLvl = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabelExp = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabelRen = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabelForIni = new javax.swing.JLabel();
        jLabelConIni = new javax.swing.JLabel();
        jLabelDexIni = new javax.swing.JLabel();
        jLabelIntIni = new javax.swing.JLabel();
        jLabelCarIni = new javax.swing.JLabel();
        jLabelMenIni = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabelValCon = new javax.swing.JLabel();
        jLabelValDex = new javax.swing.JLabel();
        jLabelValInt = new javax.swing.JLabel();
        jLabelValCar = new javax.swing.JLabel();
        jLabelValMen = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabelValFor = new javax.swing.JLabel();
        jLabelBMen = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabelBFor = new javax.swing.JLabel();
        jLabelModFor = new javax.swing.JLabel();
        jLabelModCon = new javax.swing.JLabel();
        jLabelModDex = new javax.swing.JLabel();
        jLabelModInt = new javax.swing.JLabel();
        jLabelModCar = new javax.swing.JLabel();
        jLabelModMen = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabelBCon = new javax.swing.JLabel();
        jLabelBDex = new javax.swing.JLabel();
        jLabelBInt = new javax.swing.JLabel();
        jLabelBCar = new javax.swing.JLabel();
        jLabelPerMen = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabelPerFor = new javax.swing.JLabel();
        jLabelPerCon = new javax.swing.JLabel();
        jLabelPerDex = new javax.swing.JLabel();
        jLabelPerInt = new javax.swing.JLabel();
        jLabelPerCar = new javax.swing.JLabel();
        jButtonDecMen = new javax.swing.JButton();
        jButtonDecCar = new javax.swing.JButton();
        jButtonDecCon = new javax.swing.JButton();
        jButtonDecFor = new javax.swing.JButton();
        jButtonDecInt = new javax.swing.JButton();
        jButtonDecDex = new javax.swing.JButton();
        jButtonIncFor = new javax.swing.JButton();
        jButtonIncCon = new javax.swing.JButton();
        jButtonIncInt = new javax.swing.JButton();
        jButtonIncDex = new javax.swing.JButton();
        jButtonIncMen = new javax.swing.JButton();
        jButtonIncCar = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabelHp = new javax.swing.JLabel();
        jLabelEsq = new javax.swing.JLabel();
        jLabelIni = new javax.swing.JLabel();
        jLabelCrt = new javax.swing.JLabel();
        jLabelApr = new javax.swing.JLabel();
        jButtonDistribuirESalvar = new javax.swing.JButton();
        jLabel94 = new javax.swing.JLabel();
        jLabelPontos = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jButtonDecVel = new javax.swing.JButton();
        jLabelVel = new javax.swing.JLabel();
        jButtonIncVel = new javax.swing.JButton();
        jLabelCdn = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabelNick = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Distribuir");
        setResizable(false);

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        jLabel37.setBackground(new java.awt.Color(102, 102, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Distribuição de Pontos");

        jLabel39.setBackground(new java.awt.Color(102, 102, 102));
        jLabel39.setText("Lvl: ");

        jLabelLvl.setBackground(new java.awt.Color(51, 51, 51));
        jLabelLvl.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel41.setBackground(new java.awt.Color(102, 102, 102));
        jLabel41.setText("Exp: ");

        jLabelExp.setBackground(new java.awt.Color(51, 51, 51));
        jLabelExp.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel43.setBackground(new java.awt.Color(102, 102, 102));
        jLabel43.setText("Ren: ");

        jLabelRen.setBackground(new java.awt.Color(51, 51, 51));
        jLabelRen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel45.setBackground(new java.awt.Color(102, 102, 102));
        jLabel45.setText("For: ");

        jLabel46.setBackground(new java.awt.Color(102, 102, 102));
        jLabel46.setText("Con: ");

        jLabel47.setBackground(new java.awt.Color(102, 102, 102));
        jLabel47.setText("Dex: ");

        jLabel48.setBackground(new java.awt.Color(102, 102, 102));
        jLabel48.setText("Int: ");

        jLabel49.setBackground(new java.awt.Color(102, 102, 102));
        jLabel49.setText("Car: ");

        jLabel50.setBackground(new java.awt.Color(102, 102, 102));
        jLabel50.setText("Men: ");

        jLabel51.setBackground(new java.awt.Color(102, 102, 102));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("ATR");

        jLabelForIni.setBackground(new java.awt.Color(51, 51, 51));
        jLabelForIni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelForIni.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelConIni.setBackground(new java.awt.Color(51, 51, 51));
        jLabelConIni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelConIni.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelDexIni.setBackground(new java.awt.Color(51, 51, 51));
        jLabelDexIni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDexIni.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelIntIni.setBackground(new java.awt.Color(51, 51, 51));
        jLabelIntIni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIntIni.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelCarIni.setBackground(new java.awt.Color(51, 51, 51));
        jLabelCarIni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCarIni.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelMenIni.setBackground(new java.awt.Color(51, 51, 51));
        jLabelMenIni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenIni.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel58.setBackground(new java.awt.Color(102, 102, 102));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("INI");

        jLabelValCon.setBackground(new java.awt.Color(51, 51, 51));
        jLabelValCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValCon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValDex.setBackground(new java.awt.Color(51, 51, 51));
        jLabelValDex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValDex.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValInt.setBackground(new java.awt.Color(51, 51, 51));
        jLabelValInt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValInt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValCar.setBackground(new java.awt.Color(51, 51, 51));
        jLabelValCar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValCar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValMen.setBackground(new java.awt.Color(51, 51, 51));
        jLabelValMen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValMen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel64.setBackground(new java.awt.Color(102, 102, 102));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("VAL");

        jLabelValFor.setBackground(new java.awt.Color(51, 51, 51));
        jLabelValFor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValFor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelBMen.setBackground(new java.awt.Color(51, 51, 51));
        jLabelBMen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBMen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel67.setBackground(new java.awt.Color(102, 102, 102));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("B.");

        jLabelBFor.setBackground(new java.awt.Color(51, 51, 51));
        jLabelBFor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBFor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelModFor.setBackground(new java.awt.Color(51, 51, 51));
        jLabelModFor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModFor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelModCon.setBackground(new java.awt.Color(51, 51, 51));
        jLabelModCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModCon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelModDex.setBackground(new java.awt.Color(51, 51, 51));
        jLabelModDex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModDex.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelModInt.setBackground(new java.awt.Color(51, 51, 51));
        jLabelModInt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModInt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelModCar.setBackground(new java.awt.Color(51, 51, 51));
        jLabelModCar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModCar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelModMen.setBackground(new java.awt.Color(51, 51, 51));
        jLabelModMen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModMen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel75.setBackground(new java.awt.Color(102, 102, 102));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("MOD");

        jLabelBCon.setBackground(new java.awt.Color(51, 51, 51));
        jLabelBCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBCon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelBDex.setBackground(new java.awt.Color(51, 51, 51));
        jLabelBDex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBDex.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelBInt.setBackground(new java.awt.Color(51, 51, 51));
        jLabelBInt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBInt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelBCar.setBackground(new java.awt.Color(51, 51, 51));
        jLabelBCar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBCar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerMen.setBackground(new java.awt.Color(51, 51, 51));
        jLabelPerMen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerMen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel81.setBackground(new java.awt.Color(102, 102, 102));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("PER");

        jLabelPerFor.setBackground(new java.awt.Color(51, 51, 51));
        jLabelPerFor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerFor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerCon.setBackground(new java.awt.Color(51, 51, 51));
        jLabelPerCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerCon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerDex.setBackground(new java.awt.Color(51, 51, 51));
        jLabelPerDex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerDex.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerInt.setBackground(new java.awt.Color(51, 51, 51));
        jLabelPerInt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerInt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerCar.setBackground(new java.awt.Color(51, 51, 51));
        jLabelPerCar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerCar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonDecMen.setBackground(new java.awt.Color(102, 102, 102));
        jButtonDecMen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outros/menos.png"))); // NOI18N
        jButtonDecMen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecMenActionPerformed(evt);
            }
        });

        jButtonDecCar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonDecCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outros/menos.png"))); // NOI18N
        jButtonDecCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecCarActionPerformed(evt);
            }
        });

        jButtonDecCon.setBackground(new java.awt.Color(102, 102, 102));
        jButtonDecCon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outros/menos.png"))); // NOI18N
        jButtonDecCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecConActionPerformed(evt);
            }
        });

        jButtonDecFor.setBackground(new java.awt.Color(102, 102, 102));
        jButtonDecFor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outros/menos.png"))); // NOI18N
        jButtonDecFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecForActionPerformed(evt);
            }
        });

        jButtonDecInt.setBackground(new java.awt.Color(102, 102, 102));
        jButtonDecInt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outros/menos.png"))); // NOI18N
        jButtonDecInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecIntActionPerformed(evt);
            }
        });

        jButtonDecDex.setBackground(new java.awt.Color(102, 102, 102));
        jButtonDecDex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outros/menos.png"))); // NOI18N
        jButtonDecDex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecDexActionPerformed(evt);
            }
        });

        jButtonIncFor.setBackground(new java.awt.Color(102, 102, 102));
        jButtonIncFor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outros/mais.png"))); // NOI18N
        jButtonIncFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncForActionPerformed(evt);
            }
        });

        jButtonIncCon.setBackground(new java.awt.Color(102, 102, 102));
        jButtonIncCon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outros/mais.png"))); // NOI18N
        jButtonIncCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncConActionPerformed(evt);
            }
        });

        jButtonIncInt.setBackground(new java.awt.Color(102, 102, 102));
        jButtonIncInt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outros/mais.png"))); // NOI18N
        jButtonIncInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncIntActionPerformed(evt);
            }
        });

        jButtonIncDex.setBackground(new java.awt.Color(102, 102, 102));
        jButtonIncDex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outros/mais.png"))); // NOI18N
        jButtonIncDex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncDexActionPerformed(evt);
            }
        });

        jButtonIncMen.setBackground(new java.awt.Color(102, 102, 102));
        jButtonIncMen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outros/mais.png"))); // NOI18N
        jButtonIncMen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncMenActionPerformed(evt);
            }
        });

        jButtonIncCar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonIncCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outros/mais.png"))); // NOI18N
        jButtonIncCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncCarActionPerformed(evt);
            }
        });

        jLabel87.setBackground(new java.awt.Color(102, 102, 102));
        jLabel87.setText("HP: ");

        jLabel88.setBackground(new java.awt.Color(102, 102, 102));
        jLabel88.setText("CA: ");

        jLabel89.setBackground(new java.awt.Color(102, 102, 102));
        jLabel89.setText("INI: ");

        jLabel92.setBackground(new java.awt.Color(102, 102, 102));
        jLabel92.setText("Apr: ");

        jLabel91.setBackground(new java.awt.Color(102, 102, 102));
        jLabel91.setText("Crt: ");

        jLabelHp.setBackground(new java.awt.Color(51, 51, 51));
        jLabelHp.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelEsq.setBackground(new java.awt.Color(51, 51, 51));
        jLabelEsq.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelIni.setBackground(new java.awt.Color(51, 51, 51));
        jLabelIni.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelCrt.setBackground(new java.awt.Color(51, 51, 51));
        jLabelCrt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelApr.setBackground(new java.awt.Color(51, 51, 51));
        jLabelApr.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonDistribuirESalvar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonDistribuirESalvar.setText("Distribuir e Salvar");
        jButtonDistribuirESalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDistribuirESalvarActionPerformed(evt);
            }
        });

        jLabel94.setText("Pontos para distribuir: ");

        jLabelPontos.setBackground(new java.awt.Color(51, 51, 51));
        jLabelPontos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPontos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel90.setText("Vel:");

        jButtonDecVel.setBackground(new java.awt.Color(102, 102, 102));
        jButtonDecVel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outros/menos.png"))); // NOI18N
        jButtonDecVel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecVelActionPerformed(evt);
            }
        });

        jLabelVel.setBackground(new java.awt.Color(51, 51, 51));
        jLabelVel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonIncVel.setBackground(new java.awt.Color(102, 102, 102));
        jButtonIncVel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outros/mais.png"))); // NOI18N
        jButtonIncVel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncVelActionPerformed(evt);
            }
        });

        jLabelCdn.setBackground(new java.awt.Color(51, 51, 51));
        jLabelCdn.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel42.setBackground(new java.awt.Color(102, 102, 102));
        jLabel42.setText("CDN: ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDistribuirESalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelRen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelExp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelHp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelIni, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel92, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel42))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelApr, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelCdn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelCrt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel94)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jButtonDecVel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelVel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonIncVel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(jLabelIntIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelDexIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelConIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelCarIni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelMenIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelForIni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonDecMen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonDecCar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonDecInt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonDecDex, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonDecCon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonDecFor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValInt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValDex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValCar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValFor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValMen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonIncMen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonIncCar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonIncInt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonIncDex, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonIncCon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonIncFor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModInt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModDex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModCar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModFor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModMen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelBInt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelBDex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelBCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelBCar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelBMen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelBFor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerInt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerDex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerCon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerCar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerFor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerMen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNick, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabelLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabelExp, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabelCrt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelApr, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCdn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRen, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelIni, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHp, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel90, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPontos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel94, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonDecVel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelVel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButtonIncVel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelForIni, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelConIni, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDexIni, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIntIni, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCarIni, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMenIni, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabelValFor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValCon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValDex, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValInt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValCar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValMen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButtonDecFor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDecCon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDecDex, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDecInt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDecCar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDecMen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButtonIncFor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonIncCon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonIncDex, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonIncInt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonIncCar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonIncMen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelModFor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelModCon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelModDex, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelModInt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelModCar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelModMen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelBFor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelBCon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelBDex, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelBInt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelBCar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelBMen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPerFor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPerCon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPerDex, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPerInt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPerCar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPerMen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDistribuirESalvar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDecMenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecMenActionPerformed
        if (Integer.parseInt(jLabelValMen.getText()) - 1 < Integer.parseInt(jLabelMenIni.getText())) {
            JOptionPane.showMessageDialog(null, "Você NÃO PODE reduzir o valor de Mentais para menor que a inicial!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int val = Integer.parseInt(jLabelValMen.getText()) - 1;
        int mod = (val - 10) / 2;
        int bLv = AlgoritmoPrincipalTrainer.getFicha().getLvl() / 2; // bLv é o bonus do lv
        int bMen = AlgoritmoPrincipalTrainer.getFicha().getbMen();
        int per = mod + bLv + bMen;

        jLabelModMen.setText(String.valueOf(mod));
        jLabelPerMen.setText(String.valueOf(per));
        jLabelValMen.setText(String.valueOf(val));

        // bonus
        /*int bonus = calculaBonus(bLv, bMen, val, false);
        if (bonus != 0) {
            // setando em ... da ficha o valor de ... + bonus(que pode ser >0 ou <0)
            AlgoritmoPrincipal.getFicha().setApr(AlgoritmoPrincipal.getFicha().getApr() + bonus);
            // setando em labelApr o valor de labelApr + bonus(que pode ser >0 ou <0)
            jLabelApr.setText(String.valueOf(Integer.parseInt(jLabelApr.getText()) + bonus));
        }*/

        CalculadoraTrainer.incrementarPontos();
        jLabelPontos.setText(String.valueOf(CalculadoraTrainer.getPontos()));
    }//GEN-LAST:event_jButtonDecMenActionPerformed

    private void jButtonDecCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecCarActionPerformed
        if (Integer.parseInt(jLabelValCar.getText()) - 1 < Integer.parseInt(jLabelCarIni.getText())) {
            JOptionPane.showMessageDialog(null, "Você NÃO PODE reduzir o valor de Carisma para menor que a inicial!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int val = Integer.parseInt(jLabelValCar.getText()) - 1;
        int mod = (val - 10) / 2;
        int bLv = AlgoritmoPrincipalTrainer.getFicha().getLvl() / 2; // bLv é o bonus do lv
        int bCar = AlgoritmoPrincipalTrainer.getFicha().getbCar();
        int per = mod + bLv + bCar;

        jLabelModCar.setText(String.valueOf(mod));
        jLabelPerCar.setText(String.valueOf(per));
        jLabelValCar.setText(String.valueOf(val));

        // bonus
        int bonus = calculaBonus(bLv, bCar, val, false);
        if (bonus != 0) {
            // setando em apr da ficha o valor de apr + bonus(que pode ser >0 ou <0)
            AlgoritmoPrincipalTrainer.getFicha().setApr(AlgoritmoPrincipalTrainer.getFicha().getApr() + bonus);
            // setando em labelApr o valor de labelApr + bonus(que pode ser >0 ou <0)
            jLabelApr.setText(String.valueOf(Integer.parseInt(jLabelApr.getText()) + bonus));
        }

        CalculadoraTrainer.incrementarPontos();
        jLabelPontos.setText(String.valueOf(CalculadoraTrainer.getPontos()));
    }//GEN-LAST:event_jButtonDecCarActionPerformed

    private void jButtonDecConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecConActionPerformed
        if (Integer.parseInt(jLabelValCon.getText()) - 1 < Integer.parseInt(jLabelConIni.getText())) {
            JOptionPane.showMessageDialog(null, "Você NÃO PODE reduzir o valor de Constituição para menor que a inicial!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int val = Integer.parseInt(jLabelValCon.getText()) - 1;
        int mod = (val - 10) / 2;
        int bLv = AlgoritmoPrincipalTrainer.getFicha().getLvl() / 2; // bLv é o bonus do lv
        int bCon = AlgoritmoPrincipalTrainer.getFicha().getbCon();
        int per = mod + bLv + bCon;

        jLabelModCon.setText(String.valueOf(mod));
        jLabelPerCon.setText(String.valueOf(per));
        jLabelValCon.setText(String.valueOf(val));

        // bonus
        int bonus = calculaBonus(bLv, bCon, val, false);
        // nao tem if, pois o hp sempre muda
        int coefHp = AlgoritmoPrincipalTrainer.getFicha().getCoefHp() + bonus;
        int lvl = AlgoritmoPrincipalTrainer.getFicha().getLvl();
        int hp = coefHp * lvl + val + AlgoritmoPrincipalTrainer.getHP_INICIAL();
        // setando em coefHp da ficha o valor de coefHp + bonus(que pode ser >0 ou <0)
        AlgoritmoPrincipalTrainer.getFicha().setCoefHp(coefHp);
        // setando em labelHp o novo valor de hp
        jLabelHp.setText(String.valueOf(hp));

        CalculadoraTrainer.incrementarPontos();
        jLabelPontos.setText(String.valueOf(CalculadoraTrainer.getPontos()));
    }//GEN-LAST:event_jButtonDecConActionPerformed

    private void jButtonDecForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecForActionPerformed
        if (Integer.parseInt(jLabelValFor.getText()) - 1 < Integer.parseInt(jLabelForIni.getText())) {
            JOptionPane.showMessageDialog(null, "Você NÃO PODE reduzir o valor de Força para menor que a inicial!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int val = Integer.parseInt(jLabelValFor.getText()) - 1;
        int mod = (val - 10) / 2;
        int bLv = AlgoritmoPrincipalTrainer.getFicha().getLvl() / 2; // bLv é o bonus do lv
        int bFor = AlgoritmoPrincipalTrainer.getFicha().getbFor();
        int per = mod + bLv + bFor;

        jLabelModFor.setText(String.valueOf(mod));
        jLabelPerFor.setText(String.valueOf(per));
        jLabelValFor.setText(String.valueOf(val));

        // bonus
        int bonus = calculaBonus(bLv, bFor, val, false);
        if (bonus != 0) {
            // setando em vel da ficha o valor de vel + bonus(que pode ser >0 ou <0)
            AlgoritmoPrincipalTrainer.getFicha().setVel(AlgoritmoPrincipalTrainer.getFicha().getVel() + bonus);
            // setando em labelVel o valor de labelVel + bonus(que pode ser >0 ou <0)
            jLabelVel.setText(String.valueOf(Integer.parseInt(jLabelVel.getText()) + bonus));
        }

        CalculadoraTrainer.incrementarPontos();
        jLabelPontos.setText(String.valueOf(CalculadoraTrainer.getPontos()));
    }//GEN-LAST:event_jButtonDecForActionPerformed

    private void jButtonDecIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecIntActionPerformed
        if (Integer.parseInt(jLabelValInt.getText()) - 1 < Integer.parseInt(jLabelIntIni.getText())) {
            JOptionPane.showMessageDialog(null, "Você NÃO PODE reduzir o valor de Inteligência para menor que a inicial!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int val = Integer.parseInt(jLabelValInt.getText()) - 1;
        int mod = (val - 10) / 2;
        int bLv = AlgoritmoPrincipalTrainer.getFicha().getLvl() / 2; // bLv é o bonus do lv
        int bInt = AlgoritmoPrincipalTrainer.getFicha().getbInt();
        int per = mod + bLv + bInt;

        jLabelModInt.setText(String.valueOf(mod));
        jLabelPerInt.setText(String.valueOf(per));
        jLabelValInt.setText(String.valueOf(val));

        // bonus
        int bonus = calculaBonus(bLv, bInt, val, false);
        if (bonus != 0) {
            // setando em cdn da ficha o valor de cdn + bonus(que pode ser >0 ou <0)
            AlgoritmoPrincipalTrainer.getFicha().setbIntCdn(AlgoritmoPrincipalTrainer.getFicha().getbIntCdn() + bonus);
            // setando em labelCdn o valor de labelCdn + bonus(que pode ser >0 ou <0)
            jLabelCdn.setText(String.valueOf(Integer.parseInt(jLabelCdn.getText()) + bonus));
        }

        CalculadoraTrainer.incrementarPontos();
        jLabelPontos.setText(String.valueOf(CalculadoraTrainer.getPontos()));
    }//GEN-LAST:event_jButtonDecIntActionPerformed

    private void jButtonDecDexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecDexActionPerformed
        if (Integer.parseInt(jLabelValDex.getText()) - 1 < Integer.parseInt(jLabelDexIni.getText())) {
            JOptionPane.showMessageDialog(null, "Você NÃO PODE reduzir o valor de Destreza para menor que a inicial!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Ficha ficha = AlgoritmoPrincipalTrainer.getFicha();
        int val = Integer.parseInt(jLabelValDex.getText()) - 1;
        int mod = (val - 10) / 2;
        int bLv = AlgoritmoPrincipalTrainer.getFicha().getLvl() / 2; // bLv é o bonus do lv
        int bDex = AlgoritmoPrincipalTrainer.getFicha().getbDex();
        int per = mod + bLv + bDex ;

        jLabelModDex.setText(String.valueOf(mod));
        jLabelPerDex.setText(String.valueOf(per));
        jLabelValDex.setText(String.valueOf(val));
        jLabelEsq.setText(String.valueOf(per + AlgoritmoPrincipalTrainer.getESQ_INICIAL() +
            ficha.getProEsq() + Classes.get(ficha.getClasse()).getbEsq()));
    jLabelIni.setText(String.valueOf(per));

    // bonus
    int bonus = calculaBonus(bLv, bDex, val, false);
    if (bonus != 0) {
        // setando em crt da ficha o valor de crt + bonus(que pode ser >0 ou <0)
        AlgoritmoPrincipalTrainer.getFicha().setCrt(AlgoritmoPrincipalTrainer.getFicha().getCrt() + bonus);
        // setando em labelCrt o valor de labelCrt + bonus(que pode ser >0 ou <0)
        // - bonus, pois se o personagem ganhar critico, então o critico passa a ser 20 - bonus
        jLabelCrt.setText(String.valueOf(Integer.parseInt(jLabelCrt.getText()) - bonus));
        }

        CalculadoraTrainer.incrementarPontos();
        jLabelPontos.setText(String.valueOf(CalculadoraTrainer.getPontos()));
    }//GEN-LAST:event_jButtonDecDexActionPerformed

    private void jButtonIncForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncForActionPerformed
        int val = Integer.parseInt(jLabelValFor.getText()) + 1;
        int mod = (val - 10) / 2;
        int bLv = AlgoritmoPrincipalTrainer.getFicha().getLvl() / 2; // bLv é o bonus do lv
        int bFor = AlgoritmoPrincipalTrainer.getFicha().getbFor();
        int per = mod + bLv + bFor;

        jLabelModFor.setText(String.valueOf(mod));
        jLabelPerFor.setText(String.valueOf(per));
        jLabelValFor.setText(String.valueOf(val));

        // bonus
        int bonus = calculaBonus(bLv, bFor, val, true);
        if (bonus != 0) {
            // setando em vel da ficha o valor de vel + bonus(que pode ser >0 ou <0)
            AlgoritmoPrincipalTrainer.getFicha().setVel(AlgoritmoPrincipalTrainer.getFicha().getVel() + bonus);
            // setando em labelVel o valor de labelVel + bonus(que pode ser >0 ou <0)
            jLabelVel.setText(String.valueOf(Integer.parseInt(jLabelVel.getText()) + bonus));
        }

        CalculadoraTrainer.decrementarPontos();
        jLabelPontos.setText(String.valueOf(CalculadoraTrainer.getPontos()));
    }//GEN-LAST:event_jButtonIncForActionPerformed

    private void jButtonIncConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncConActionPerformed
        int val = Integer.parseInt(jLabelValCon.getText()) + 1;
        int mod = (val - 10) / 2;
        int bLv = AlgoritmoPrincipalTrainer.getFicha().getLvl() / 2; // bLv é o bonus do lv
        int bCon = AlgoritmoPrincipalTrainer.getFicha().getbCon();
        int per = mod + bLv + bCon;

        jLabelModCon.setText(String.valueOf(mod));
        jLabelPerCon.setText(String.valueOf(per));
        jLabelValCon.setText(String.valueOf(val));

        // bonus
        int bonus = calculaBonus(bLv, bCon, val, true);
        // nao tem if, pois o hp sempre muda
        int coefHp = AlgoritmoPrincipalTrainer.getFicha().getCoefHp() + bonus;
        int lvl = AlgoritmoPrincipalTrainer.getFicha().getLvl();
        int hp = coefHp * lvl + val + AlgoritmoPrincipalTrainer.getHP_INICIAL();
        // setando em coefHp da ficha o valor de coefHp + bonus(que pode ser >0 ou <0)
        AlgoritmoPrincipalTrainer.getFicha().setCoefHp(coefHp);
        // setando em labelHp o novo valor de hp
        jLabelHp.setText(String.valueOf(hp));

        CalculadoraTrainer.decrementarPontos();
        jLabelPontos.setText(String.valueOf(CalculadoraTrainer.getPontos()));
    }//GEN-LAST:event_jButtonIncConActionPerformed

    private void jButtonIncIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncIntActionPerformed
        int val = Integer.parseInt(jLabelValInt.getText()) + 1;
        int mod = (val - 10) / 2;
        int bLv = AlgoritmoPrincipalTrainer.getFicha().getLvl() / 2; // bLv é o bonus do lv
        int bInt = AlgoritmoPrincipalTrainer.getFicha().getbInt();
        int per = mod + bLv + bInt;

        jLabelModInt.setText(String.valueOf(mod));
        jLabelPerInt.setText(String.valueOf(per));
        jLabelValInt.setText(String.valueOf(val));

        // bonus
        int bonus = calculaBonus(bLv, bInt, val, true);
        if (bonus != 0) {
            // setando em cdn da ficha o valor de cdn + bonus(que pode ser >0 ou <0)
            AlgoritmoPrincipalTrainer.getFicha().setbIntCdn(AlgoritmoPrincipalTrainer.getFicha().getbIntCdn() + bonus);
            // setando em labelCdn o valor de labelCdn + bonus(que pode ser >0 ou <0)
            jLabelCdn.setText(String.valueOf(Integer.parseInt(jLabelCdn.getText()) + bonus));
        }

        CalculadoraTrainer.decrementarPontos();
        jLabelPontos.setText(String.valueOf(CalculadoraTrainer.getPontos()));
    }//GEN-LAST:event_jButtonIncIntActionPerformed

    private void jButtonIncDexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncDexActionPerformed
        Ficha ficha = AlgoritmoPrincipalTrainer.getFicha();
        int val = Integer.parseInt(jLabelValDex.getText()) + 1;
        int mod = (val - 10) / 2;
        int bLv = AlgoritmoPrincipalTrainer.getFicha().getLvl() / 2; // bLv é o bonus do lv
        int bDex = AlgoritmoPrincipalTrainer.getFicha().getbDex();
        int per = mod + bLv + bDex;

        jLabelModDex.setText(String.valueOf(mod));
        jLabelPerDex.setText(String.valueOf(per));
        jLabelValDex.setText(String.valueOf(val));
        jLabelEsq.setText(String.valueOf(per + AlgoritmoPrincipalTrainer.getESQ_INICIAL() +
            ficha.getProEsq() + Classes.get(ficha.getClasse()).getbEsq()));
        jLabelIni.setText(String.valueOf(per));

        // bonus
        int bonus = calculaBonus(bLv, bDex, val, true);
        if (bonus != 0) {
        // setando em crt da ficha o valor de crt + bonus(que pode ser >0 ou <0)
        AlgoritmoPrincipalTrainer.getFicha().setCrt(AlgoritmoPrincipalTrainer.getFicha().getCrt() + bonus);
        // setando em labelCrt o valor de labelCrt + bonus(que pode ser >0 ou <0)
        // - bonus, pois se o personagem ganhar critico, então o critico passa a ser 20 - bonus
        jLabelCrt.setText(String.valueOf(Integer.parseInt(jLabelCrt.getText()) - bonus));
        }

        CalculadoraTrainer.decrementarPontos();
        jLabelPontos.setText(String.valueOf(CalculadoraTrainer.getPontos()));
    }//GEN-LAST:event_jButtonIncDexActionPerformed

    private void jButtonIncMenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncMenActionPerformed
        int val = Integer.parseInt(jLabelValMen.getText()) + 1;
        int mod = (val - 10) / 2;
        int per = mod + AlgoritmoPrincipalTrainer.getFicha().getLvl() / 2 + AlgoritmoPrincipalTrainer.getFicha().getbMen();

        jLabelModMen.setText(String.valueOf(mod));
        jLabelPerMen.setText(String.valueOf(per));
        jLabelValMen.setText(String.valueOf(val));

        // bonus
        /*int bonus = calculaBonus(bLv, bMen, val, false);
        if (bonus != 0) {
            // setando em ... da ficha o valor de ... + bonus(que pode ser >0 ou <0)
            AlgoritmoPrincipal.getFicha().setApr(AlgoritmoPrincipal.getFicha().getApr() + bonus);
            // setando em labelApr o valor de labelApr + bonus(que pode ser >0 ou <0)
            jLabelApr.setText(String.valueOf(Integer.parseInt(jLabelApr.getText()) + bonus));
        }*/

        CalculadoraTrainer.decrementarPontos();
        jLabelPontos.setText(String.valueOf(CalculadoraTrainer.getPontos()));
    }//GEN-LAST:event_jButtonIncMenActionPerformed

    private void jButtonIncCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncCarActionPerformed
        int val = Integer.parseInt(jLabelValCar.getText()) + 1;
        int mod = (val - 10) / 2;
        int bLv = AlgoritmoPrincipalTrainer.getFicha().getLvl() / 2; // bLv é o bonus do lv
        int bCar = AlgoritmoPrincipalTrainer.getFicha().getbCar();
        int per = mod + bLv + bCar;

        jLabelModCar.setText(String.valueOf(mod));
        jLabelPerCar.setText(String.valueOf(per));
        jLabelValCar.setText(String.valueOf(val));

        // bonus
        int bonus = calculaBonus(bLv, bCar, val, true);
        if (bonus != 0) {
            // setando em apr da ficha o valor de apr + bonus(que pode ser >0 ou <0)
            AlgoritmoPrincipalTrainer.getFicha().setApr(AlgoritmoPrincipalTrainer.getFicha().getApr() + bonus);
            // setando em labelApr o valor de labelApr + bonus(que pode ser >0 ou <0)
            jLabelApr.setText(String.valueOf(Integer.parseInt(jLabelApr.getText()) + bonus));
        }

        CalculadoraTrainer.decrementarPontos();
        jLabelPontos.setText(String.valueOf(CalculadoraTrainer.getPontos()));
    }//GEN-LAST:event_jButtonIncCarActionPerformed

    private void jButtonDistribuirESalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDistribuirESalvarActionPerformed
        if (CalculadoraTrainer.getPontos() != 0) {
            JOptionPane.showMessageDialog(null, "Distribua todos os pontos corretamente!",
                "Error!", JOptionPane.ERROR_MESSAGE);

            return;
        }

        Ficha ficha = AlgoritmoPrincipalTrainer.getFicha();

        // setando valores de atributos em ficha
        ficha.setValCar(Integer.parseInt(jLabelValCar.getText()));
        ficha.setValFor(Integer.parseInt(jLabelValFor.getText()));
        ficha.setValCon(Integer.parseInt(jLabelValCon.getText()));
        ficha.setValDex(Integer.parseInt(jLabelValDex.getText()));
        ficha.setValInt(Integer.parseInt(jLabelValInt.getText()));
        ficha.setValMen(Integer.parseInt(jLabelValMen.getText()));

        // setando modificadores de atributos em ficha
        ficha.setModCar(Integer.parseInt(jLabelModCar.getText()));
        ficha.setModFor(Integer.parseInt(jLabelModFor.getText()));
        ficha.setModCon(Integer.parseInt(jLabelModCon.getText()));
        ficha.setModDex(Integer.parseInt(jLabelModDex.getText()));
        ficha.setModInt(Integer.parseInt(jLabelModInt.getText()));
        ficha.setModMen(Integer.parseInt(jLabelModMen.getText()));

        // setando pericias em ficha
        ficha.setPerCar(Integer.parseInt(jLabelPerCar.getText()));
        ficha.setPerFor(Integer.parseInt(jLabelPerFor.getText()));
        ficha.setPerCon(Integer.parseInt(jLabelPerCon.getText()));
        ficha.setPerDex(Integer.parseInt(jLabelPerDex.getText()));
        ficha.setPerInt(Integer.parseInt(jLabelPerInt.getText()));
        ficha.setPerMen(Integer.parseInt(jLabelPerMen.getText()));

        // setando novos valores
        ficha.setIni();
        ficha.setEsq();
        ficha.setCrt();
        ficha.setApr();
        ficha.setVel();
        ficha.setHp();
        ficha.setSorteDiaria();


        // ATUALIZANDO HABILIDADES
        CalculadoraHabilidades.init();

        // recalculando habilidades
        for (String nomeHabilidade : ficha.getHabilidades().keySet()) {
            int dano = CalculadoraHabilidades.calculaDano(ficha, ficha.getHabilidade(nomeHabilidade));
            ficha.getHabilidade(nomeHabilidade).setDano(dano);
        }

        // salvando a ficha
        AlgoritmoPrincipal.saveFicha(ficha);

        // mensagem final
        JOptionPane.showMessageDialog(null, "Ficha salva com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);

        this.dispose();
    }//GEN-LAST:event_jButtonDistribuirESalvarActionPerformed

    private void jButtonDecVelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecVelActionPerformed
        if (Integer.parseInt(jLabelVel.getText()) - 1 < AlgoritmoPrincipalTrainer.getFicha().getVel()) {
            JOptionPane.showMessageDialog(null, "Você NÃO PODE reduzir o valor de Velocidade para menor que a inicial!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        CalculadoraTrainer.incrementarPontos();
        jLabelVel.setText(String.valueOf(Integer.parseInt(jLabelVel.getText()) - 1));
        jLabelPontos.setText(String.valueOf(CalculadoraTrainer.getPontos()));
    }//GEN-LAST:event_jButtonDecVelActionPerformed

    private void jButtonIncVelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncVelActionPerformed
        CalculadoraTrainer.decrementarPontos();
        jLabelVel.setText(String.valueOf(Integer.parseInt(jLabelVel.getText()) + 1));
        jLabelPontos.setText(String.valueOf(CalculadoraTrainer.getPontos()));
    }//GEN-LAST:event_jButtonIncVelActionPerformed

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
            java.util.logging.Logger.getLogger(View_distribuir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            View_distribuir dialog = new View_distribuir(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonDecCar;
    private javax.swing.JButton jButtonDecCon;
    private javax.swing.JButton jButtonDecDex;
    private javax.swing.JButton jButtonDecFor;
    private javax.swing.JButton jButtonDecInt;
    private javax.swing.JButton jButtonDecMen;
    private javax.swing.JButton jButtonDecVel;
    private javax.swing.JButton jButtonDistribuirESalvar;
    private javax.swing.JButton jButtonIncCar;
    private javax.swing.JButton jButtonIncCon;
    private javax.swing.JButton jButtonIncDex;
    private javax.swing.JButton jButtonIncFor;
    private javax.swing.JButton jButtonIncInt;
    private javax.swing.JButton jButtonIncMen;
    private javax.swing.JButton jButtonIncVel;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabelApr;
    private javax.swing.JLabel jLabelBCar;
    private javax.swing.JLabel jLabelBCon;
    private javax.swing.JLabel jLabelBDex;
    private javax.swing.JLabel jLabelBFor;
    private javax.swing.JLabel jLabelBInt;
    private javax.swing.JLabel jLabelBMen;
    private javax.swing.JLabel jLabelCarIni;
    private javax.swing.JLabel jLabelCdn;
    private javax.swing.JLabel jLabelConIni;
    private javax.swing.JLabel jLabelCrt;
    private javax.swing.JLabel jLabelDexIni;
    private javax.swing.JLabel jLabelEsq;
    private javax.swing.JLabel jLabelExp;
    private javax.swing.JLabel jLabelForIni;
    private javax.swing.JLabel jLabelHp;
    private javax.swing.JLabel jLabelIni;
    private javax.swing.JLabel jLabelIntIni;
    private javax.swing.JLabel jLabelLvl;
    private javax.swing.JLabel jLabelMenIni;
    private javax.swing.JLabel jLabelModCar;
    private javax.swing.JLabel jLabelModCon;
    private javax.swing.JLabel jLabelModDex;
    private javax.swing.JLabel jLabelModFor;
    private javax.swing.JLabel jLabelModInt;
    private javax.swing.JLabel jLabelModMen;
    private javax.swing.JLabel jLabelNick;
    private javax.swing.JLabel jLabelPerCar;
    private javax.swing.JLabel jLabelPerCon;
    private javax.swing.JLabel jLabelPerDex;
    private javax.swing.JLabel jLabelPerFor;
    private javax.swing.JLabel jLabelPerInt;
    private javax.swing.JLabel jLabelPerMen;
    private javax.swing.JLabel jLabelPontos;
    private javax.swing.JLabel jLabelRen;
    private javax.swing.JLabel jLabelValCar;
    private javax.swing.JLabel jLabelValCon;
    private javax.swing.JLabel jLabelValDex;
    private javax.swing.JLabel jLabelValFor;
    private javax.swing.JLabel jLabelValInt;
    private javax.swing.JLabel jLabelValMen;
    private javax.swing.JLabel jLabelVel;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
