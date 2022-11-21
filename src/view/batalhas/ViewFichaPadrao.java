/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.batalhas;

import algoritmos.batalhas.AlgoritmoPrincipal;
import algoritmos.batalhas.Calculadora;
import ficha_personagem.Ficha;
import ficha_personagem.Habilidades;
import ficha_personagem.LvlBonus;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 422UR4H
 */
public class ViewFichaPadrao extends javax.swing.JFrame {

    /**
     * Creates new form ViewFichaPadrao
     */
    public ViewFichaPadrao() {
        initComponents();
        
        
        // MEU CODIGO
        
        // recebendo ficha
        Ficha ficha = AlgoritmoPrincipal.getFicha(AlgoritmoPrincipal.getLinha());
        
        // setando titulo da ficha
        setTitle(ficha.getNick());
        
        // setando formulario
        jLabelNome.setText(ficha.getNick());
        
        jLabelTendencia.setText(ficha.getTendencia());
        
        jLabelIdade.setText(String.valueOf(ficha.getIdade()));
        
        // setando leveis e exps
        jLabelLvl.setText(String.valueOf(ficha.getLvl()));
        jLabelLvlNen.setText(String.valueOf(ficha.getLvlNen()));
        
        // setando jProgressBars
        jProgressBarExp.setMaximum(AlgoritmoPrincipal.getEXP_LVL(ficha.getLvl() + 1));
        jProgressBarExpNen.setMaximum(AlgoritmoPrincipal.getLVL_NEN(ficha.getLvlNen() + 1));
        jProgressBarExp.setValue(ficha.getExp());
        jProgressBarExpNen.setValue(ficha.getExpNen());
        
        // setando valores
        jLabelIni.setText(String.valueOf(ficha.getIni()));
        jLabelEsq.setText(String.valueOf(ficha.getEsq()));
        jLabelVel.setText(String.valueOf(ficha.getVel()));
        jLabelCrt.setText(String.valueOf(20 - ficha.getCrt()));
        
        
        // setando valores de atributos fisicos
        jLabelValFor.setText(String.valueOf(ficha.getValFor()));
        jLabelValCon.setText(String.valueOf(ficha.getValCon()));
        jLabelValDex.setText(String.valueOf(ficha.getValDex()));
        jLabelValInt.setText(String.valueOf(ficha.getValInt()));
        jLabelValCar.setText(String.valueOf(ficha.getValCar()));
        jLabelValMen.setText(String.valueOf(ficha.getValMen()));
        
        // setando pericias de atributos fisicos
        jLabelPerFor.setText(String.valueOf(ficha.getPerFor()));
        jLabelPerCon.setText(String.valueOf(ficha.getPerCon()));
        jLabelPerDex.setText(String.valueOf(ficha.getPerDex()));
        jLabelPerInt.setText(String.valueOf(ficha.getPerInt()));
        jLabelPerCar.setText(String.valueOf(ficha.getPerCar()));
        jLabelPerMen.setText(String.valueOf(ficha.getPerMen()));
        
        
        // setando valores de atributos nen
        jLabelValRef.setText(String.valueOf(ficha.getAtrRef()));
        jLabelValEms.setText(String.valueOf(ficha.getAtrEms()));
        jLabelValMan.setText(String.valueOf(ficha.getAtrMan()));
        jLabelValMat.setText(String.valueOf(ficha.getAtrMat()));
        jLabelValTrs.setText(String.valueOf(ficha.getAtrTrs()));
        jLabelValEsp.setText(String.valueOf(ficha.getAtrEsp()));
        
        
        // setando pericias de atributos nen
        jLabelPerRef.setText(String.valueOf(ficha.getPerRef()));
        jLabelPerEms.setText(String.valueOf(ficha.getPerEms()));
        jLabelPerMan.setText(String.valueOf(ficha.getPerMan()));
        jLabelPerMat.setText(String.valueOf(ficha.getPerMat()));
        jLabelPerTrs.setText(String.valueOf(ficha.getPerTrs()));
        jLabelPerEsp.setText(String.valueOf(ficha.getPerEsp()));
        
        
        // setando valores de outros atributos nen
        jLabelValTen.setText(String.valueOf(ficha.getTen()));
        jLabelValAop.setText(String.valueOf(ficha.getAop()));
        jLabelPerRyu.setText(String.valueOf((ficha.getRyu() - 10 + ficha.getLvl()) / 2));
        jLabelPerCdn.setText(String.valueOf(ficha.getPerCdn()));
        jLabelPerZts.setText(String.valueOf((ficha.getZts() - 10 + ficha.getLvl()) / 2));
        jLabelValEn.setText(String.valueOf(ficha.getEn()));
        
        initTableRyu(ficha);
        
        // FIM DO MEU CODIGO
    }
    
    private void initTableRyu(Ficha ficha) {
        DefaultTableModel dtm = (DefaultTableModel) jTableRyu.getModel();
        
        for (int i = 1; i < 21; i++) {
            int ryu = 5 * i;
            int valor = Calculadora.getRen(ficha, ryu, ficha.getNen());
            String linha;
            switch (ryu) {
                case 5:
                    linha = "0" + ryu + "%";
                    break;
                case 10:
                    linha = "TEN";
                    break;
                case 50:
                    linha = "KEN";
                    break;
                case 100:
                    linha = "KOU";
                    break;
                default:
                    linha = ryu + "%";
                    break;
            }
            Object[] vetor = {linha, valor};
            dtm.removeRow(i - 1);
            dtm.insertRow(i - 1, vetor);
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

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelTendencia = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelIdade = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabelIni = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabelValCon = new javax.swing.JLabel();
        jLabelValDex = new javax.swing.JLabel();
        jLabelValInt = new javax.swing.JLabel();
        jLabelValCar = new javax.swing.JLabel();
        jLabelValMen = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabelValFor = new javax.swing.JLabel();
        jLabelPerCar = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabelPerInt = new javax.swing.JLabel();
        jLabelPerMen = new javax.swing.JLabel();
        jLabelPerFor = new javax.swing.JLabel();
        jLabelPerDex = new javax.swing.JLabel();
        jLabelPerCon = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabelValRef = new javax.swing.JLabel();
        jLabelValEms = new javax.swing.JLabel();
        jLabelValMan = new javax.swing.JLabel();
        jLabelValMat = new javax.swing.JLabel();
        jLabelValTrs = new javax.swing.JLabel();
        jLabelValEsp = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabelPerEsp = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabelPerRef = new javax.swing.JLabel();
        jLabelPerEms = new javax.swing.JLabel();
        jLabelPerMan = new javax.swing.JLabel();
        jLabelPerMat = new javax.swing.JLabel();
        jLabelPerTrs = new javax.swing.JLabel();
        jLabelLvl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelLvlNen = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabelValTen = new javax.swing.JLabel();
        jLabelPerCdn = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabelValEn = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jProgressBarExp = new javax.swing.JProgressBar();
        jProgressBarExpNen = new javax.swing.JProgressBar();
        jLabel41 = new javax.swing.JLabel();
        jLabelVel = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabelCrt = new javax.swing.JLabel();
        jLabelEsq = new javax.swing.JLabel();
        jLabelValAop = new javax.swing.JLabel();
        jLabelPerRyu = new javax.swing.JLabel();
        jLabelPerZts = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableRyu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ficha");
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabelNome.setBackground(new java.awt.Color(51, 51, 51));
        jLabelNome.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nick:");

        jLabelTendencia.setBackground(new java.awt.Color(51, 51, 51));
        jLabelTendencia.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("Tendência: ");

        jLabelIdade.setBackground(new java.awt.Color(51, 51, 51));
        jLabelIdade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdade.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setText("Idade: ");

        jLabel39.setBackground(new java.awt.Color(51, 51, 51));
        jLabel39.setText("Ini: ");

        jLabelIni.setBackground(new java.awt.Color(0, 255, 0));
        jLabelIni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIni.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLabelValCon.setBackground(new java.awt.Color(0, 255, 0));
        jLabelValCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValCon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValDex.setBackground(new java.awt.Color(0, 255, 0));
        jLabelValDex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValDex.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValInt.setBackground(new java.awt.Color(0, 255, 0));
        jLabelValInt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValInt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValCar.setBackground(new java.awt.Color(0, 255, 0));
        jLabelValCar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValCar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValMen.setBackground(new java.awt.Color(0, 255, 0));
        jLabelValMen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValMen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel64.setBackground(new java.awt.Color(102, 102, 102));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("VAL");

        jLabelValFor.setBackground(new java.awt.Color(0, 255, 0));
        jLabelValFor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValFor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerCar.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerCar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerCar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel81.setBackground(new java.awt.Color(102, 102, 102));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("PER");

        jLabelPerInt.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerInt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerInt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerMen.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerMen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerMen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerFor.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerFor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerFor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerDex.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerDex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerDex.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerCon.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerCon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel52.setBackground(new java.awt.Color(102, 102, 102));
        jLabel52.setText("Ref: ");

        jLabel53.setBackground(new java.awt.Color(102, 102, 102));
        jLabel53.setText("Ems: ");

        jLabel54.setBackground(new java.awt.Color(102, 102, 102));
        jLabel54.setText("Man: ");

        jLabel55.setBackground(new java.awt.Color(102, 102, 102));
        jLabel55.setText("Mat: ");

        jLabel56.setBackground(new java.awt.Color(102, 102, 102));
        jLabel56.setText("Trs: ");

        jLabel57.setBackground(new java.awt.Color(102, 102, 102));
        jLabel57.setText("Esp: ");

        jLabel59.setBackground(new java.awt.Color(102, 102, 102));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("NEN");

        jLabelValRef.setBackground(new java.awt.Color(0, 255, 255));
        jLabelValRef.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValRef.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValEms.setBackground(new java.awt.Color(0, 255, 255));
        jLabelValEms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValEms.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValMan.setBackground(new java.awt.Color(0, 255, 255));
        jLabelValMan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValMan.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValMat.setBackground(new java.awt.Color(0, 255, 255));
        jLabelValMat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValMat.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValTrs.setBackground(new java.awt.Color(0, 255, 255));
        jLabelValTrs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValTrs.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValEsp.setBackground(new java.awt.Color(0, 255, 255));
        jLabelValEsp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValEsp.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel60.setBackground(new java.awt.Color(102, 102, 102));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("VAL");

        jLabelPerEsp.setBackground(new java.awt.Color(0, 255, 255));
        jLabelPerEsp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerEsp.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel82.setBackground(new java.awt.Color(102, 102, 102));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("PER");

        jLabelPerRef.setBackground(new java.awt.Color(0, 255, 255));
        jLabelPerRef.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerRef.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerEms.setBackground(new java.awt.Color(0, 255, 255));
        jLabelPerEms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerEms.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerMan.setBackground(new java.awt.Color(0, 255, 255));
        jLabelPerMan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerMan.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerMat.setBackground(new java.awt.Color(0, 255, 255));
        jLabelPerMat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerMat.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerTrs.setBackground(new java.awt.Color(0, 255, 255));
        jLabelPerTrs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerTrs.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelLvl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel2.setText("Level");

        jLabelLvlNen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel8.setText("Level Nen");

        jLabel61.setBackground(new java.awt.Color(102, 102, 102));
        jLabel61.setText("Ten: ");

        jLabelValTen.setBackground(new java.awt.Color(0, 255, 255));
        jLabelValTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValTen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerCdn.setBackground(new java.awt.Color(0, 255, 255));
        jLabelPerCdn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerCdn.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel65.setBackground(new java.awt.Color(102, 102, 102));
        jLabel65.setText("Cdn: ");

        jLabel68.setBackground(new java.awt.Color(102, 102, 102));
        jLabel68.setText("En: ");

        jLabelValEn.setBackground(new java.awt.Color(0, 255, 255));
        jLabelValEn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValEn.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel62.setBackground(new java.awt.Color(102, 102, 102));
        jLabel62.setText("Aop: ");

        jLabel66.setBackground(new java.awt.Color(102, 102, 102));
        jLabel66.setText("Zts: ");

        jLabel63.setBackground(new java.awt.Color(102, 102, 102));
        jLabel63.setText("Ryu:");

        jProgressBarExp.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarExp.setForeground(new java.awt.Color(255, 0, 0));
        jProgressBarExp.setString("");
        jProgressBarExp.setStringPainted(true);
        jProgressBarExp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarExpMouseEntered(evt);
            }
        });

        jProgressBarExpNen.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarExpNen.setForeground(new java.awt.Color(255, 0, 0));
        jProgressBarExpNen.setString("");
        jProgressBarExpNen.setStringPainted(true);
        jProgressBarExpNen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarExpNenMouseEntered(evt);
            }
        });

        jLabel41.setBackground(new java.awt.Color(51, 51, 51));
        jLabel41.setText("Vel: ");

        jLabelVel.setBackground(new java.awt.Color(0, 255, 0));
        jLabelVel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel88.setBackground(new java.awt.Color(51, 51, 51));
        jLabel88.setText("Crt: ");

        jLabel89.setBackground(new java.awt.Color(51, 51, 51));
        jLabel89.setText("C.A: ");

        jLabelCrt.setBackground(new java.awt.Color(0, 255, 0));
        jLabelCrt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCrt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelEsq.setBackground(new java.awt.Color(0, 255, 0));
        jLabelEsq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEsq.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValAop.setBackground(new java.awt.Color(0, 255, 255));
        jLabelValAop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValAop.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerRyu.setBackground(new java.awt.Color(0, 255, 255));
        jLabelPerRyu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerRyu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerZts.setBackground(new java.awt.Color(0, 255, 255));
        jLabelPerZts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerZts.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableRyu.setBackground(new java.awt.Color(51, 51, 51));
        jTableRyu.setForeground(new java.awt.Color(0, 255, 0));
        jTableRyu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
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
                "RYU", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRyu.setSelectionBackground(new java.awt.Color(0, 255, 255));
        jTableRyu.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(jTableRyu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTendencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jProgressBarExp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel50))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValInt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValDex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValCar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValMen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValFor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerInt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerDex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerCon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerCar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerFor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerMen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValMat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValMan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValEms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValTrs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValRef, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerMat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerMan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerEms, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerTrs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerRef, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jProgressBarExpNen, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelLvlNen, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValEn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelValTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelPerCdn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelPerZts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPerRyu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelValAop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel88, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelCrt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTendencia, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelIni, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValFor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValCon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValDex, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValInt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValCar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValMen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPerFor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPerCon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPerDex, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPerInt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPerCar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPerMen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelValRef, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelValEms, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelValMan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelValMat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelValTrs, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelValEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelPerRef, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelPerEms, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelPerMan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelPerMat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelPerTrs, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelPerEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLvlNen, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jProgressBarExp, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jProgressBarExpNen, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelValTen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerCdn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelValEn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelPerZts, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelPerRyu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelCrt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelValAop, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelVel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jProgressBarExpNenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarExpNenMouseEntered
        jProgressBarExpNen.setToolTipText(jProgressBarExpNen.getValue()+"/"+jProgressBarExpNen.getMaximum());
    }//GEN-LAST:event_jProgressBarExpNenMouseEntered

    private void jProgressBarExpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarExpMouseEntered
        jProgressBarExp.setToolTipText(jProgressBarExp.getValue()+"/"+jProgressBarExp.getMaximum());
    }//GEN-LAST:event_jProgressBarExpMouseEntered

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
            java.util.logging.Logger.getLogger(ViewFichaPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewFichaPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewFichaPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewFichaPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ViewFichaPadrao().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabelCrt;
    private javax.swing.JLabel jLabelEsq;
    private javax.swing.JLabel jLabelIdade;
    private javax.swing.JLabel jLabelIni;
    private javax.swing.JLabel jLabelLvl;
    private javax.swing.JLabel jLabelLvlNen;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPerCar;
    private javax.swing.JLabel jLabelPerCdn;
    private javax.swing.JLabel jLabelPerCon;
    private javax.swing.JLabel jLabelPerDex;
    private javax.swing.JLabel jLabelPerEms;
    private javax.swing.JLabel jLabelPerEsp;
    private javax.swing.JLabel jLabelPerFor;
    private javax.swing.JLabel jLabelPerInt;
    private javax.swing.JLabel jLabelPerMan;
    private javax.swing.JLabel jLabelPerMat;
    private javax.swing.JLabel jLabelPerMen;
    private javax.swing.JLabel jLabelPerRef;
    private javax.swing.JLabel jLabelPerRyu;
    private javax.swing.JLabel jLabelPerTrs;
    private javax.swing.JLabel jLabelPerZts;
    private javax.swing.JLabel jLabelTendencia;
    private javax.swing.JLabel jLabelValAop;
    private javax.swing.JLabel jLabelValCar;
    private javax.swing.JLabel jLabelValCon;
    private javax.swing.JLabel jLabelValDex;
    private javax.swing.JLabel jLabelValEms;
    private javax.swing.JLabel jLabelValEn;
    private javax.swing.JLabel jLabelValEsp;
    private javax.swing.JLabel jLabelValFor;
    private javax.swing.JLabel jLabelValInt;
    private javax.swing.JLabel jLabelValMan;
    private javax.swing.JLabel jLabelValMat;
    private javax.swing.JLabel jLabelValMen;
    private javax.swing.JLabel jLabelValRef;
    private javax.swing.JLabel jLabelValTen;
    private javax.swing.JLabel jLabelValTrs;
    private javax.swing.JLabel jLabelVel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBarExp;
    private javax.swing.JProgressBar jProgressBarExpNen;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableRyu;
    // End of variables declaration//GEN-END:variables
}
