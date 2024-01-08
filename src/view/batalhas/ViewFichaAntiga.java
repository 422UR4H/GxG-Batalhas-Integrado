/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.batalhas;

import algoritmos.batalhas.AlgoritmoPrincipal;
import ficha_personagem.Ficha;
import ficha_personagem.Habilidades;
import ficha_personagem.LvlBonus;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 422UR4H
 */
public class ViewFichaAntiga extends javax.swing.JFrame {

    /**
     * Creates new form ViewFicha
     * @throws java.lang.ClassNotFoundException
     */
    public ViewFichaAntiga() throws ClassNotFoundException {
        // mudando a cor das jProgressBar
        // grande parte desse codigo foi escrito pelo NetBeans
        /*try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        initComponents();
        
        
        // MEU CODIGO
        
        // recebendo ficha
        Ficha ficha = AlgoritmoPrincipal.getFicha(AlgoritmoPrincipal.getLinha());
        
        // setando titulo da ficha
        setTitle(ficha.getNick());
        
        // setando formulario
        jLabelNome.setText(ficha.getNick());
        jLabelClasse.setText(ficha.getClasse());
        jLabelNen.setText(ficha.getNen());
        jLabelModNen.setText(String.valueOf(ficha.getModClas()));
        
        jLabelTendencia.setText(ficha.getTendencia());
        jLabelHunter.setText(ficha.getHunter());
        
        jLabelIdade.setText(String.valueOf(ficha.getIdade()));
        jLabelPeso.setText(String.valueOf(ficha.getPeso()));
        jLabelHeroicos.setText(String.valueOf(ficha.getPontosHeroicos()));
        jLabelAltura.setText(String.valueOf(ficha.getAltura()));
        jLabelDias.setText(String.valueOf(ficha.getDias()));
        jLabelInspiracoes.setText(String.valueOf(ficha.getPontosInspiracao()));
        
        // setando leveis e exps
        jLabelLvl.setText(String.valueOf(ficha.getLvl()));
        jLabelExpBonus.setText(String.valueOf(ficha.getExpBonus()));
        jLabelLvlNen.setText(String.valueOf(ficha.getLvlNen()));
        
        // setando jProgressBars
        jProgressBarExp.setMaximum(AlgoritmoPrincipal.getEXP_LVL(ficha.getLvl() + 1));
        jProgressBarExpNen.setMaximum(AlgoritmoPrincipal.getLVL_NEN(ficha.getLvlNen() + 1));
        jProgressBarExp.setValue(ficha.getExp());
        jProgressBarExpNen.setValue(ficha.getExpNen());
        
        // setando valores
        jLabelIni.setText(String.valueOf(ficha.getIni()));
        jLabelEsq.setText(String.valueOf(ficha.getEsq()));
        jLabelApr.setText(String.valueOf(ficha.getApr()));
        jLabelHp.setText(String.valueOf(ficha.getHpMax()));
        jLabelVel.setText(String.valueOf(ficha.getVel()));
        jLabelCrt.setText(String.valueOf(20 - ficha.getCrt()));
        jLabelSrt.setText(String.valueOf(ficha.getSorte()) + "/" + String.valueOf(ficha.getSorteDiaria()));
        jLabelMp.setText(String.valueOf(ficha.getMopMax()));
        
        
        // setando atributos fisicos iniciais
        jLabelForIni.setText(String.valueOf(ficha.getIniFor()));
        jLabelConIni.setText(String.valueOf(ficha.getIniCon()));
        jLabelDexIni.setText(String.valueOf(ficha.getIniDex()));
        jLabelIntIni.setText(String.valueOf(ficha.getIniInt()));
        jLabelCarIni.setText(String.valueOf(ficha.getIniCar()));
        jLabelMenIni.setText(String.valueOf(ficha.getIniMen()));
        
        // setando valores de atributos fisicos
        jLabelValFor.setText(String.valueOf(ficha.getValFor()));
        jLabelValCon.setText(String.valueOf(ficha.getValCon()));
        jLabelValDex.setText(String.valueOf(ficha.getValDex()));
        jLabelValInt.setText(String.valueOf(ficha.getValInt()));
        jLabelValCar.setText(String.valueOf(ficha.getValCar()));
        jLabelValMen.setText(String.valueOf(ficha.getValMen()));
        
        // setando modificadores de atributos fisicos
        jLabelModFor.setText(String.valueOf(ficha.getModFor()));
        jLabelModCon.setText(String.valueOf(ficha.getModCon()));
        jLabelModDex.setText(String.valueOf(ficha.getModDex()));
        jLabelModInt.setText(String.valueOf(ficha.getModInt()));
        jLabelModCar.setText(String.valueOf(ficha.getModCar()));
        jLabelModMen.setText(String.valueOf(ficha.getModMen()));
        
        // setando bonus de atributos fisicos
        jLabelBFor.setText(String.valueOf(ficha.getbFor()));
        jLabelBCon.setText(String.valueOf(ficha.getbCon()));
        jLabelBDex.setText(String.valueOf(ficha.getbDex()));
        jLabelBInt.setText(String.valueOf(ficha.getbInt()));
        jLabelBCar.setText(String.valueOf(ficha.getbCar()));
        jLabelBMen.setText(String.valueOf(ficha.getbMen()));
        
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
        
        // setando modificadores de atributos nen
        jLabelModRef.setText(String.valueOf(ficha.getModRef()));
        jLabelModEms.setText(String.valueOf(ficha.getModEms()));
        jLabelModMan.setText(String.valueOf(ficha.getModMan()));
        jLabelModMat.setText(String.valueOf(ficha.getModMat()));
        jLabelModTrs.setText(String.valueOf(ficha.getModTrs()));
        jLabelModEsp.setText(String.valueOf(ficha.getModEsp()));
        
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
        jLabelPerZts.setText(String.valueOf(ficha.getPerZts()));
        jLabelValEn.setText(String.valueOf(ficha.getEn()));
        
        
        // setando pericias
        for (String nome : ficha.getPer().keySet()) {
            jComboBoxPer.addItem(nome);
        }
        
        // setando proficiencias
        for (String nome : ficha.getPro().keySet()) {
            jComboBoxPro.addItem(nome);
        }
        
        // setando habilidades
        for (String nome : ficha.getHabilidades().keySet()) {
            jComboBoxHabilidades.addItem(nome);
        }
        
        // setando skills
        jLabelHitPoints.setText(String.valueOf(ficha.getHpMax()));
        jProgressBarHp.setMaximum(ficha.getHpMax());
        jProgressBarHp.setValue(ficha.getHpAtual());
        
        jLabelMopPoints.setText(String.valueOf(ficha.getMopMax()));
        jProgressBarMp.setMaximum(ficha.getMopMax());
        jProgressBarMp.setValue(ficha.getMopAtual());
        
        jLabelRef.setText(String.valueOf(ficha.getAtrRef()));
        jProgressBarRef.setMaximum(AlgoritmoPrincipal.getEXP_NEN(ficha.getAtrRef() + 1));
        jProgressBarRef.setValue(ficha.getAtr().get("REF").getExp());
        
        jLabelEms.setText(String.valueOf(ficha.getAtrEms()));
        jProgressBarEms.setMaximum(AlgoritmoPrincipal.getEXP_NEN(ficha.getAtrEms() + 1));
        jProgressBarEms.setValue(ficha.getAtr().get("EMS").getExp());
        
        jLabelMan.setText(String.valueOf(ficha.getAtrMan()));
        jProgressBarMan.setMaximum(AlgoritmoPrincipal.getEXP_NEN(ficha.getAtrMan() + 1));
        jProgressBarMan.setValue(ficha.getAtr().get("MAN").getExp());
        
        jLabelMat.setText(String.valueOf(ficha.getAtrMat()));
        jProgressBarMat.setMaximum(AlgoritmoPrincipal.getEXP_NEN(ficha.getAtrMat() + 1));
        jProgressBarMat.setValue(ficha.getAtr().get("MAT").getExp());
        
        jLabelTrs.setText(String.valueOf(ficha.getAtrTrs()));
        jProgressBarTrs.setMaximum(AlgoritmoPrincipal.getEXP_NEN(ficha.getAtrTrs() + 1));
        jProgressBarTrs.setValue(ficha.getAtr().get("TRS").getExp());
        
        jLabelEsp.setText(String.valueOf(ficha.getAtrEsp()));
        jProgressBarEsp.setMaximum(AlgoritmoPrincipal.getEXP_NEN(ficha.getAtrEsp() + 1));
        jProgressBarEsp.setValue(ficha.getAtr().get("ESP").getExp());
        
        jLabelCdn.setText(String.valueOf(ficha.getAtrCdn()));
        jProgressBarCdn.setMaximum(AlgoritmoPrincipal.getEXP_NEN(ficha.getAtrCdn() + 1));
        jProgressBarCdn.setValue(ficha.getAtr().get("CDN").getExp());
        
        jLabelTen.setText(String.valueOf(ficha.getTen()));
        jProgressBarTen.setMaximum(AlgoritmoPrincipal.getEXP_NEN(ficha.getTen() + 1));
        jProgressBarTen.setValue(ficha.getAtr().get("TEN").getExp());
        
        jLabelRyu.setText(String.valueOf(ficha.getRyu()));
        jProgressBarRyu.setMaximum(AlgoritmoPrincipal.getEXP_NEN(ficha.getRyu() + 1));
        jProgressBarRyu.setValue(ficha.getAtr().get("RYU").getExp());
        
        jLabelEn.setText(String.valueOf(ficha.getEn()));
        jProgressBarEn.setMaximum(AlgoritmoPrincipal.getEXP_NEN(ficha.getEn() + 1));
        jProgressBarEn.setValue(ficha.getAtr().get("EN").getExp());
        
        jLabelAop.setText(String.valueOf(ficha.getAop()));
        jProgressBarAop.setMaximum(AlgoritmoPrincipal.getEXP_NEN(ficha.getAop() + 1));
        jProgressBarAop.setValue(ficha.getAtr().get("AOP").getExp());
        
        jLabelMop.setText(String.valueOf(ficha.getMop()));
        jProgressBarMop.setMaximum(AlgoritmoPrincipal.getEXP_NEN(ficha.getMop() + 1));
        jProgressBarMop.setValue(ficha.getAtr().get("MOP").getExp());
        
        jLabelZts.setText(String.valueOf(ficha.getZts()));
        jProgressBarZts.setMaximum(AlgoritmoPrincipal.getEXP_NEN(ficha.getZts() + 1));
        jProgressBarZts.setValue(ficha.getAtr().get("ZTS").getExp());
        
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

        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabelLvlPer = new javax.swing.JLabel();
        jLabelSubLvlPer = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabelBonusPer = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabelIni = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabelVel = new javax.swing.JLabel();
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
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabelCrt = new javax.swing.JLabel();
        jLabelEsq = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelClasse = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelNen = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabelTendencia = new javax.swing.JLabel();
        jLabelHunter = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabelIdade = new javax.swing.JLabel();
        jLabelAltura = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabelDias = new javax.swing.JLabel();
        jLabelPeso = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabelHeroicos = new javax.swing.JLabel();
        jLabelInspiracoes = new javax.swing.JLabel();
        jLabelModNen = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
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
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabelValTen = new javax.swing.JLabel();
        jLabelValAop = new javax.swing.JLabel();
        jLabelPerRyu = new javax.swing.JLabel();
        jLabelPerCdn = new javax.swing.JLabel();
        jLabelPerZts = new javax.swing.JLabel();
        jLabelValEn = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabelModRef = new javax.swing.JLabel();
        jLabelModEms = new javax.swing.JLabel();
        jLabelModMan = new javax.swing.JLabel();
        jLabelModMat = new javax.swing.JLabel();
        jLabelModTrs = new javax.swing.JLabel();
        jLabelModEsp = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabelPerEsp = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabelPerRef = new javax.swing.JLabel();
        jLabelPerEms = new javax.swing.JLabel();
        jLabelPerMan = new javax.swing.JLabel();
        jLabelPerMat = new javax.swing.JLabel();
        jLabelPerTrs = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabelSrt = new javax.swing.JLabel();
        jLabelApr = new javax.swing.JLabel();
        jLabelHp = new javax.swing.JLabel();
        jLabelMp = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jComboBoxPer = new javax.swing.JComboBox<>();
        jComboBoxHabilidades = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jComboBoxPro = new javax.swing.JComboBox<>();
        jButtonDescricao = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jLabelBonusPro = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabelLvlPro = new javax.swing.JLabel();
        jLabelSubLvlPro = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabelDano = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabelLvlHabilidade = new javax.swing.JLabel();
        jLabelArma = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jProgressBarExp = new javax.swing.JProgressBar();
        jProgressBarExpNen = new javax.swing.JProgressBar();
        jProgressBarHp = new javax.swing.JProgressBar();
        jProgressBarMp = new javax.swing.JProgressBar();
        jProgressBarRef = new javax.swing.JProgressBar();
        jProgressBarEms = new javax.swing.JProgressBar();
        jProgressBarMan = new javax.swing.JProgressBar();
        jProgressBarMat = new javax.swing.JProgressBar();
        jProgressBarTrs = new javax.swing.JProgressBar();
        jProgressBarEsp = new javax.swing.JProgressBar();
        jProgressBarCdn = new javax.swing.JProgressBar();
        jProgressBarTen = new javax.swing.JProgressBar();
        jProgressBarRyu = new javax.swing.JProgressBar();
        jProgressBarEn = new javax.swing.JProgressBar();
        jLabel77 = new javax.swing.JLabel();
        jProgressBarAop = new javax.swing.JProgressBar();
        jLabel78 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jProgressBarMop = new javax.swing.JProgressBar();
        jLabel86 = new javax.swing.JLabel();
        jProgressBarZts = new javax.swing.JProgressBar();
        jLabelLvl = new javax.swing.JLabel();
        jLabelLvlNen = new javax.swing.JLabel();
        jLabelExpBonus = new javax.swing.JLabel();
        jLabelHitPoints = new javax.swing.JLabel();
        jLabelCdn = new javax.swing.JLabel();
        jLabelTrs = new javax.swing.JLabel();
        jLabelMopPoints = new javax.swing.JLabel();
        jLabelRef = new javax.swing.JLabel();
        jLabelEms = new javax.swing.JLabel();
        jLabelMan = new javax.swing.JLabel();
        jLabelMat = new javax.swing.JLabel();
        jLabelEsp = new javax.swing.JLabel();
        jLabelTen = new javax.swing.JLabel();
        jLabelRyu = new javax.swing.JLabel();
        jLabelEn = new javax.swing.JLabel();
        jLabelAop = new javax.swing.JLabel();
        jLabelMop = new javax.swing.JLabel();
        jLabelZts = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ficha");
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel35.setForeground(new java.awt.Color(0, 255, 0));
        jLabel35.setText("Level: ");

        jLabel37.setForeground(new java.awt.Color(0, 255, 0));
        jLabel37.setText("Sub-Level: ");

        jLabelLvlPer.setForeground(new java.awt.Color(0, 255, 0));

        jLabelSubLvlPer.setForeground(new java.awt.Color(0, 255, 0));

        jLabel71.setForeground(new java.awt.Color(0, 255, 0));
        jLabel71.setText("Bônus: ");

        jLabelBonusPer.setForeground(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLvlPer, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBonusPer, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSubLvlPer, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLvlPer, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSubLvlPer, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBonusPer, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jScrollPane2.setViewportView(jPanel2);

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        jLabel39.setBackground(new java.awt.Color(51, 51, 51));
        jLabel39.setText("Iniciativa: ");

        jLabelIni.setBackground(new java.awt.Color(0, 255, 0));
        jLabelIni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIni.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel41.setBackground(new java.awt.Color(51, 51, 51));
        jLabel41.setText("Velocidade: ");

        jLabelVel.setBackground(new java.awt.Color(0, 255, 0));
        jLabelVel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLabelValCon.setBackground(new java.awt.Color(0, 255, 255));
        jLabelValCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValCon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValDex.setBackground(new java.awt.Color(0, 255, 255));
        jLabelValDex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValDex.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValInt.setBackground(new java.awt.Color(0, 255, 255));
        jLabelValInt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValInt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValCar.setBackground(new java.awt.Color(0, 255, 255));
        jLabelValCar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValCar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValMen.setBackground(new java.awt.Color(0, 255, 255));
        jLabelValMen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValMen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel64.setBackground(new java.awt.Color(102, 102, 102));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("VAL");

        jLabelValFor.setBackground(new java.awt.Color(0, 255, 255));
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

        jLabelPerMen.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerMen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerMen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel81.setBackground(new java.awt.Color(102, 102, 102));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("PER");

        jLabelPerFor.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerFor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerFor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerCon.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerCon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerDex.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerDex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerDex.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerInt.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerInt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerInt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerCar.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerCar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerCar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel88.setBackground(new java.awt.Color(51, 51, 51));
        jLabel88.setText("Crítico: ");

        jLabel89.setBackground(new java.awt.Color(51, 51, 51));
        jLabel89.setText("Esquiva: ");

        jLabelCrt.setBackground(new java.awt.Color(0, 255, 0));
        jLabelCrt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCrt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelEsq.setBackground(new java.awt.Color(0, 255, 0));
        jLabelEsq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEsq.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nome: ");

        jLabelNome.setBackground(new java.awt.Color(51, 51, 51));
        jLabelNome.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Classe: ");

        jLabelClasse.setBackground(new java.awt.Color(51, 51, 51));
        jLabelClasse.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("Nen: ");

        jLabelNen.setBackground(new java.awt.Color(51, 51, 51));
        jLabelNen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("Tendência: ");

        jLabel14.setText("Hunter: ");

        jLabelTendencia.setBackground(new java.awt.Color(51, 51, 51));
        jLabelTendencia.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelHunter.setBackground(new java.awt.Color(51, 51, 51));
        jLabelHunter.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setText("Altura: ");

        jLabel18.setText("Idade: ");

        jLabelIdade.setBackground(new java.awt.Color(51, 51, 51));
        jLabelIdade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdade.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelAltura.setBackground(new java.awt.Color(51, 51, 51));
        jLabelAltura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAltura.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setText("Peso: ");

        jLabel22.setText("Dias: ");

        jLabelDias.setBackground(new java.awt.Color(51, 51, 51));
        jLabelDias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDias.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPeso.setBackground(new java.awt.Color(51, 51, 51));
        jLabelPeso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPeso.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel25.setText("Pontos Heróicos: ");

        jLabel26.setText("Inspirações: ");

        jLabelHeroicos.setBackground(new java.awt.Color(0, 255, 0));
        jLabelHeroicos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHeroicos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelInspiracoes.setBackground(new java.awt.Color(0, 255, 0));
        jLabelInspiracoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInspiracoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelModNen.setBackground(new java.awt.Color(51, 51, 51));
        jLabelModNen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModNen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel32.setBackground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("Sortes: ");

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

        jLabelValRef.setBackground(new java.awt.Color(51, 51, 51));
        jLabelValRef.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValRef.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValEms.setBackground(new java.awt.Color(51, 51, 51));
        jLabelValEms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValEms.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValMan.setBackground(new java.awt.Color(51, 51, 51));
        jLabelValMan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValMan.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValMat.setBackground(new java.awt.Color(51, 51, 51));
        jLabelValMat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValMat.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValTrs.setBackground(new java.awt.Color(51, 51, 51));
        jLabelValTrs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValTrs.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValEsp.setBackground(new java.awt.Color(51, 51, 51));
        jLabelValEsp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValEsp.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel60.setBackground(new java.awt.Color(102, 102, 102));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("VAL");

        jLabel61.setBackground(new java.awt.Color(102, 102, 102));
        jLabel61.setText("Ten: ");

        jLabel62.setBackground(new java.awt.Color(102, 102, 102));
        jLabel62.setText("Aop: ");

        jLabel63.setBackground(new java.awt.Color(102, 102, 102));
        jLabel63.setText("Ryu:");

        jLabel65.setBackground(new java.awt.Color(102, 102, 102));
        jLabel65.setText("Cdn: ");

        jLabel66.setBackground(new java.awt.Color(102, 102, 102));
        jLabel66.setText("Zts: ");

        jLabel68.setBackground(new java.awt.Color(102, 102, 102));
        jLabel68.setText("En: ");

        jLabel69.setBackground(new java.awt.Color(102, 102, 102));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("NEN");

        jLabelValTen.setBackground(new java.awt.Color(51, 51, 51));
        jLabelValTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValTen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValAop.setBackground(new java.awt.Color(51, 51, 51));
        jLabelValAop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValAop.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerRyu.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerRyu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerRyu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerCdn.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerCdn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerCdn.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerZts.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerZts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerZts.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelValEn.setBackground(new java.awt.Color(51, 51, 51));
        jLabelValEn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValEn.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel70.setBackground(new java.awt.Color(102, 102, 102));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("PER");

        jLabelModRef.setBackground(new java.awt.Color(51, 51, 51));
        jLabelModRef.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModRef.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelModEms.setBackground(new java.awt.Color(51, 51, 51));
        jLabelModEms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModEms.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelModMan.setBackground(new java.awt.Color(51, 51, 51));
        jLabelModMan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModMan.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelModMat.setBackground(new java.awt.Color(51, 51, 51));
        jLabelModMat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModMat.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelModTrs.setBackground(new java.awt.Color(51, 51, 51));
        jLabelModTrs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModTrs.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelModEsp.setBackground(new java.awt.Color(51, 51, 51));
        jLabelModEsp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModEsp.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel76.setBackground(new java.awt.Color(102, 102, 102));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("MOD");

        jLabelPerEsp.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerEsp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerEsp.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel82.setBackground(new java.awt.Color(102, 102, 102));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("PER");

        jLabelPerRef.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerRef.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerRef.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerEms.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerEms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerEms.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerMan.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerMan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerMan.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerMat.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerMat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerMat.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPerTrs.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPerTrs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPerTrs.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel34.setBackground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("Aparência: ");

        jLabelSrt.setBackground(new java.awt.Color(51, 51, 51));
        jLabelSrt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSrt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelApr.setBackground(new java.awt.Color(51, 51, 51));
        jLabelApr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelApr.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelHp.setBackground(new java.awt.Color(51, 51, 51));
        jLabelHp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHp.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelMp.setBackground(new java.awt.Color(51, 51, 51));
        jLabelMp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMp.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel92.setBackground(new java.awt.Color(51, 51, 51));
        jLabel92.setText("Mop: ");

        jLabel91.setBackground(new java.awt.Color(51, 51, 51));
        jLabel91.setText("Hp: ");

        jComboBoxPer.setBackground(new java.awt.Color(102, 102, 102));
        jComboBoxPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPerActionPerformed(evt);
            }
        });

        jComboBoxHabilidades.setBackground(new java.awt.Color(102, 102, 102));
        jComboBoxHabilidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxHabilidadesActionPerformed(evt);
            }
        });

        jLabel30.setText("Perícias");

        jLabel31.setText("Habilidades");

        jLabel33.setText("Proficiências");

        jComboBoxPro.setBackground(new java.awt.Color(102, 102, 102));
        jComboBoxPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProActionPerformed(evt);
            }
        });

        jButtonDescricao.setBackground(new java.awt.Color(102, 102, 102));
        jButtonDescricao.setText("Descrição");
        jButtonDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDescricaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel50))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelIntIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelDexIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelConIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelCarIni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelMenIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelForIni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValInt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValDex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValCar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValMen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValFor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModInt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModDex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModCar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModMen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModFor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(jLabelPerMen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValMat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValMan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValEms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValTrs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValRef, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel76, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModMat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModMan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModEms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModTrs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModEsp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelModRef, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerMat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerMan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerEms, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerTrs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerRef, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPerEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelPerCdn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelPerRyu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValAop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelPerZts, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValEn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelValTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNen, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelModNen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabelTendencia, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabelHunter, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelIdade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelDias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelInspiracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelHeroicos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelVel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelEsq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelCrt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelSrt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelApr, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel92, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelHp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelMp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jSeparator2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxPer, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxPro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonDescricao))
                                    .addComponent(jComboBoxHabilidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelNen, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelModNen, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelTendencia, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelHeroicos, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHunter, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDias, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelInspiracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabelIni, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(jLabelVel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(8, 8, 8)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelCrt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabelApr, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabelSrt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHp, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMp, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel92, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelForIni, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelConIni, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelDexIni, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelIntIni, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelCarIni, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelMenIni, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelValFor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelValCon, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelValDex, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelValInt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelValCar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelValMen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelModFor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelModCon, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelModDex, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelModInt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelModCar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelModMen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelBFor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelBCon, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelBDex, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelBInt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelBCar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelBMen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelPerFor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelPerCon, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelPerDex, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelPerInt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelPerCar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelPerMen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValTen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValAop, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPerRyu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPerCdn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPerZts, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValEn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelModRef, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelModEms, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelModMan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelModMat, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelModTrs, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelModEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPerRef, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPerEms, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPerMan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPerMat, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPerTrs, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPerEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValRef, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValEms, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValMan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValMat, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValTrs, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxHabilidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jComboBoxPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jLabel84.setForeground(new java.awt.Color(0, 255, 0));
        jLabel84.setText("Bônus: ");

        jLabelBonusPro.setForeground(new java.awt.Color(0, 255, 0));

        jLabel80.setForeground(new java.awt.Color(0, 255, 0));
        jLabel80.setText("Level: ");

        jLabel79.setForeground(new java.awt.Color(0, 255, 0));
        jLabel79.setText("Sub-Level: ");

        jLabelLvlPro.setForeground(new java.awt.Color(0, 255, 0));

        jLabelSubLvlPro.setForeground(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLvlPro, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(jLabelSubLvlPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelBonusPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLvlPro, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSubLvlPro, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBonusPro, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel4);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel90.setForeground(new java.awt.Color(0, 255, 0));
        jLabel90.setText("Level: ");

        jLabel87.setForeground(new java.awt.Color(0, 255, 0));
        jLabel87.setText("Arma: ");

        jLabelDano.setForeground(new java.awt.Color(0, 255, 0));

        jLabel85.setForeground(new java.awt.Color(0, 255, 0));
        jLabel85.setText("Dano: ");

        jLabelLvlHabilidade.setForeground(new java.awt.Color(0, 255, 0));

        jLabelArma.setForeground(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel90, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel87))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelArma, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jLabelLvlHabilidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelArma, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLvlHabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDano, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel3);

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setForeground(new java.awt.Color(0, 255, 0));
        jLabel2.setText("Level");

        jLabel7.setForeground(new java.awt.Color(0, 255, 0));
        jLabel7.setText("Exp Bonus");

        jLabel8.setForeground(new java.awt.Color(0, 255, 0));
        jLabel8.setText("Level Nen");

        jLabel12.setForeground(new java.awt.Color(0, 255, 0));
        jLabel12.setText("Hit Points");

        jLabel15.setForeground(new java.awt.Color(0, 255, 0));
        jLabel15.setText("MOP");

        jLabel24.setForeground(new java.awt.Color(0, 255, 0));
        jLabel24.setText("Reforço");

        jLabel27.setForeground(new java.awt.Color(0, 255, 0));
        jLabel27.setText("Emissão");

        jLabel28.setForeground(new java.awt.Color(0, 255, 0));
        jLabel28.setText("Manipulação");

        jLabel29.setForeground(new java.awt.Color(0, 255, 0));
        jLabel29.setText("Materialização");

        jLabel40.setForeground(new java.awt.Color(0, 255, 0));
        jLabel40.setText("Transformação");

        jLabel42.setForeground(new java.awt.Color(0, 255, 0));
        jLabel42.setText("Especialização");

        jLabel72.setForeground(new java.awt.Color(0, 255, 0));
        jLabel72.setText("Controle de Nen");

        jLabel73.setForeground(new java.awt.Color(0, 255, 0));
        jLabel73.setText("Ten");

        jLabel74.setForeground(new java.awt.Color(0, 255, 0));
        jLabel74.setText("Ryu");

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

        jProgressBarHp.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarHp.setForeground(new java.awt.Color(255, 102, 0));
        jProgressBarHp.setString("");
        jProgressBarHp.setStringPainted(true);
        jProgressBarHp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarHpMouseEntered(evt);
            }
        });

        jProgressBarMp.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarMp.setString("");
        jProgressBarMp.setStringPainted(true);
        jProgressBarMp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarMpMouseEntered(evt);
            }
        });

        jProgressBarRef.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarRef.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBarRef.setString("");
        jProgressBarRef.setStringPainted(true);
        jProgressBarRef.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarRefMouseEntered(evt);
            }
        });

        jProgressBarEms.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarEms.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBarEms.setString("");
        jProgressBarEms.setStringPainted(true);
        jProgressBarEms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarEmsMouseEntered(evt);
            }
        });

        jProgressBarMan.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarMan.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBarMan.setString("");
        jProgressBarMan.setStringPainted(true);
        jProgressBarMan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarManMouseEntered(evt);
            }
        });

        jProgressBarMat.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarMat.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBarMat.setString("");
        jProgressBarMat.setStringPainted(true);
        jProgressBarMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarMatMouseEntered(evt);
            }
        });

        jProgressBarTrs.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarTrs.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBarTrs.setString("");
        jProgressBarTrs.setStringPainted(true);
        jProgressBarTrs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarTrsMouseEntered(evt);
            }
        });

        jProgressBarEsp.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarEsp.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBarEsp.setString("");
        jProgressBarEsp.setStringPainted(true);
        jProgressBarEsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarEspMouseEntered(evt);
            }
        });

        jProgressBarCdn.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarCdn.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBarCdn.setString("");
        jProgressBarCdn.setStringPainted(true);
        jProgressBarCdn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarCdnMouseEntered(evt);
            }
        });

        jProgressBarTen.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarTen.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBarTen.setString("");
        jProgressBarTen.setStringPainted(true);
        jProgressBarTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarTenMouseEntered(evt);
            }
        });

        jProgressBarRyu.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarRyu.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBarRyu.setString("");
        jProgressBarRyu.setStringPainted(true);
        jProgressBarRyu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarRyuMouseEntered(evt);
            }
        });

        jProgressBarEn.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarEn.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBarEn.setString("");
        jProgressBarEn.setStringPainted(true);
        jProgressBarEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarEnMouseEntered(evt);
            }
        });

        jLabel77.setForeground(new java.awt.Color(0, 255, 0));
        jLabel77.setText("En");

        jProgressBarAop.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarAop.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBarAop.setString("");
        jProgressBarAop.setStringPainted(true);
        jProgressBarAop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarAopMouseEntered(evt);
            }
        });

        jLabel78.setForeground(new java.awt.Color(0, 255, 0));
        jLabel78.setText("Aop");

        jLabel83.setForeground(new java.awt.Color(0, 255, 0));
        jLabel83.setText("Mop");

        jProgressBarMop.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarMop.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBarMop.setString("");
        jProgressBarMop.setStringPainted(true);
        jProgressBarMop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarMopMouseEntered(evt);
            }
        });

        jLabel86.setForeground(new java.awt.Color(0, 255, 0));
        jLabel86.setText("Zetsu");

        jProgressBarZts.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBarZts.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBarZts.setString("");
        jProgressBarZts.setStringPainted(true);
        jProgressBarZts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProgressBarZtsMouseEntered(evt);
            }
        });

        jLabelLvl.setForeground(new java.awt.Color(0, 255, 0));
        jLabelLvl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelLvlNen.setForeground(new java.awt.Color(0, 255, 0));
        jLabelLvlNen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelExpBonus.setForeground(new java.awt.Color(0, 255, 0));
        jLabelExpBonus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelHitPoints.setForeground(new java.awt.Color(0, 255, 0));
        jLabelHitPoints.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelCdn.setForeground(new java.awt.Color(0, 255, 0));
        jLabelCdn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelTrs.setForeground(new java.awt.Color(0, 255, 0));
        jLabelTrs.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelMopPoints.setForeground(new java.awt.Color(0, 255, 0));
        jLabelMopPoints.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelRef.setForeground(new java.awt.Color(0, 255, 0));
        jLabelRef.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelEms.setForeground(new java.awt.Color(0, 255, 0));
        jLabelEms.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelMan.setForeground(new java.awt.Color(0, 255, 0));
        jLabelMan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelMat.setForeground(new java.awt.Color(0, 255, 0));
        jLabelMat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelEsp.setForeground(new java.awt.Color(0, 255, 0));
        jLabelEsp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelTen.setForeground(new java.awt.Color(0, 255, 0));
        jLabelTen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelRyu.setForeground(new java.awt.Color(0, 255, 0));
        jLabelRyu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelEn.setForeground(new java.awt.Color(0, 255, 0));
        jLabelEn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelAop.setForeground(new java.awt.Color(0, 255, 0));
        jLabelAop.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelMop.setForeground(new java.awt.Color(0, 255, 0));
        jLabelMop.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelZts.setForeground(new java.awt.Color(0, 255, 0));
        jLabelZts.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLvl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelExpBonus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLvlNen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHitPoints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMopPoints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelRef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelRyu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jProgressBarExp, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBarExpNen, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBarHp, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBarMp, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBarRef, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBarEms, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBarMan, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBarMat, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel83)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelZts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jProgressBarZts, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jProgressBarMop, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jProgressBarAop, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jProgressBarEn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jProgressBarRyu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jProgressBarTen, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jProgressBarCdn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCdn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jProgressBarEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jProgressBarTrs, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTrs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jProgressBarExp, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelExpBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jProgressBarExpNen, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelLvlNen, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jProgressBarHp, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelHitPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMopPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jProgressBarMp, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRef, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jProgressBarRef, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEms, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jProgressBarEms, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMan, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jProgressBarMan, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMat, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jProgressBarMat, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jProgressBarTrs, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelTrs, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jProgressBarEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelCdn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jProgressBarCdn, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTen, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jProgressBarTen, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRyu, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jProgressBarRyu, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jProgressBarEn, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAop, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jProgressBarAop, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMop, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jProgressBarMop, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelZts, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jProgressBarZts, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(jPanel7);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane6)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPerActionPerformed
        Ficha ficha = AlgoritmoPrincipal.getFicha(jLabelNome.getText());
        LvlBonus per = ficha.getPer().get(jComboBoxPer.getSelectedItem().toString());
        
        jLabelLvlPer.setText(String.valueOf(per.getLvl()));
        jLabelSubLvlPer.setText(String.valueOf(per.getLvj()));
        jLabelBonusPer.setText(String.valueOf(per.getBonus()));
    }//GEN-LAST:event_jComboBoxPerActionPerformed

    private void jComboBoxProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProActionPerformed
        Ficha ficha = AlgoritmoPrincipal.getFicha(jLabelNome.getText());
        LvlBonus pro = ficha.getPro().get(jComboBoxPro.getSelectedItem().toString());
        
        jLabelLvlPro.setText(String.valueOf(pro.getLvl()));
        jLabelSubLvlPro.setText(String.valueOf(pro.getLvj()));
        jLabelBonusPro.setText(String.valueOf(pro.getBonus()));
    }//GEN-LAST:event_jComboBoxProActionPerformed

    private void jComboBoxHabilidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxHabilidadesActionPerformed
        Ficha ficha = AlgoritmoPrincipal.getFicha(jLabelNome.getText());
        Habilidades habilidade = ficha.getHabilidade(jComboBoxHabilidades.getSelectedItem().toString());
        
        jLabelArma.setText(habilidade.getArma());
        jLabelLvlHabilidade.setText(String.valueOf(habilidade.getLvl()));
        jLabelDano.setText(String.valueOf(habilidade.getDano()));
    }//GEN-LAST:event_jComboBoxHabilidadesActionPerformed

    private void jProgressBarExpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarExpMouseEntered
        jProgressBarExp.setToolTipText(jProgressBarExp.getValue()+"/"+jProgressBarExp.getMaximum());
    }//GEN-LAST:event_jProgressBarExpMouseEntered

    private void jProgressBarExpNenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarExpNenMouseEntered
        jProgressBarExpNen.setToolTipText(jProgressBarExpNen.getValue()+"/"+jProgressBarExpNen.getMaximum());
    }//GEN-LAST:event_jProgressBarExpNenMouseEntered

    private void jProgressBarHpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarHpMouseEntered
        jProgressBarHp.setToolTipText(jProgressBarHp.getValue()+"/"+jProgressBarHp.getMaximum());
    }//GEN-LAST:event_jProgressBarHpMouseEntered

    private void jProgressBarMpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarMpMouseEntered
        jProgressBarMp.setToolTipText(jProgressBarMp.getValue()+"/"+jProgressBarMp.getMaximum());
    }//GEN-LAST:event_jProgressBarMpMouseEntered

    private void jProgressBarRefMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarRefMouseEntered
        jProgressBarRef.setToolTipText(jProgressBarRef.getValue()+"/"+jProgressBarRef.getMaximum());
    }//GEN-LAST:event_jProgressBarRefMouseEntered

    private void jProgressBarEmsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarEmsMouseEntered
        jProgressBarEms.setToolTipText(jProgressBarEms.getValue()+"/"+jProgressBarEms.getMaximum());
    }//GEN-LAST:event_jProgressBarEmsMouseEntered

    private void jProgressBarManMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarManMouseEntered
        jProgressBarMan.setToolTipText(jProgressBarMan.getValue()+"/"+jProgressBarMan.getMaximum());
    }//GEN-LAST:event_jProgressBarManMouseEntered

    private void jProgressBarMatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarMatMouseEntered
        jProgressBarMat.setToolTipText(jProgressBarMat.getValue()+"/"+jProgressBarMat.getMaximum());
    }//GEN-LAST:event_jProgressBarMatMouseEntered

    private void jProgressBarTrsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarTrsMouseEntered
        jProgressBarTrs.setToolTipText(jProgressBarTrs.getValue()+"/"+jProgressBarTrs.getMaximum());
    }//GEN-LAST:event_jProgressBarTrsMouseEntered

    private void jProgressBarEspMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarEspMouseEntered
        jProgressBarEsp.setToolTipText(jProgressBarEsp.getValue()+"/"+jProgressBarEsp.getMaximum());
    }//GEN-LAST:event_jProgressBarEspMouseEntered

    private void jProgressBarCdnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarCdnMouseEntered
        jProgressBarCdn.setToolTipText(jProgressBarCdn.getValue()+"/"+jProgressBarCdn.getMaximum());
    }//GEN-LAST:event_jProgressBarCdnMouseEntered

    private void jProgressBarTenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarTenMouseEntered
        jProgressBarTen.setToolTipText(jProgressBarTen.getValue()+"/"+jProgressBarTen.getMaximum());
    }//GEN-LAST:event_jProgressBarTenMouseEntered

    private void jProgressBarRyuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarRyuMouseEntered
        jProgressBarRyu.setToolTipText(jProgressBarRyu.getValue()+"/"+jProgressBarRyu.getMaximum());
    }//GEN-LAST:event_jProgressBarRyuMouseEntered

    private void jProgressBarEnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarEnMouseEntered
        jProgressBarEn.setToolTipText(jProgressBarEn.getValue()+"/"+jProgressBarEn.getMaximum());
    }//GEN-LAST:event_jProgressBarEnMouseEntered

    private void jProgressBarAopMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarAopMouseEntered
        jProgressBarAop.setToolTipText(jProgressBarAop.getValue()+"/"+jProgressBarAop.getMaximum());
    }//GEN-LAST:event_jProgressBarAopMouseEntered

    private void jProgressBarMopMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarMopMouseEntered
        jProgressBarMop.setToolTipText(jProgressBarMop.getValue()+"/"+jProgressBarMop.getMaximum());
    }//GEN-LAST:event_jProgressBarMopMouseEntered

    private void jProgressBarZtsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBarZtsMouseEntered
        jProgressBarZts.setToolTipText(jProgressBarZts.getValue()+"/"+jProgressBarZts.getMaximum());
    }//GEN-LAST:event_jProgressBarZtsMouseEntered

    private void jButtonDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDescricaoActionPerformed
        String nome;
        try {
            nome = jComboBoxHabilidades.getSelectedItem().toString().toUpperCase();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Primeiro escolha uma habilidade!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AlgoritmoPrincipal.setLinha(AlgoritmoPrincipal.getFicha().getHabilidade(nome).getDescricao());
        new ViewDescricao().setVisible(true);
    }//GEN-LAST:event_jButtonDescricaoActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewFichaAntiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewFichaAntiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewFichaAntiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewFichaAntiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ViewFichaAntiga().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ViewFichaAntiga.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDescricao;
    private javax.swing.JComboBox<String> jComboBoxHabilidades;
    private javax.swing.JComboBox<String> jComboBoxPer;
    private javax.swing.JComboBox<String> jComboBoxPro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
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
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabelAltura;
    private javax.swing.JLabel jLabelAop;
    private javax.swing.JLabel jLabelApr;
    private javax.swing.JLabel jLabelArma;
    private javax.swing.JLabel jLabelBCar;
    private javax.swing.JLabel jLabelBCon;
    private javax.swing.JLabel jLabelBDex;
    private javax.swing.JLabel jLabelBFor;
    private javax.swing.JLabel jLabelBInt;
    private javax.swing.JLabel jLabelBMen;
    private javax.swing.JLabel jLabelBonusPer;
    private javax.swing.JLabel jLabelBonusPro;
    private javax.swing.JLabel jLabelCarIni;
    private javax.swing.JLabel jLabelCdn;
    private javax.swing.JLabel jLabelClasse;
    private javax.swing.JLabel jLabelConIni;
    private javax.swing.JLabel jLabelCrt;
    private javax.swing.JLabel jLabelDano;
    private javax.swing.JLabel jLabelDexIni;
    private javax.swing.JLabel jLabelDias;
    private javax.swing.JLabel jLabelEms;
    private javax.swing.JLabel jLabelEn;
    private javax.swing.JLabel jLabelEsp;
    private javax.swing.JLabel jLabelEsq;
    private javax.swing.JLabel jLabelExpBonus;
    private javax.swing.JLabel jLabelForIni;
    private javax.swing.JLabel jLabelHeroicos;
    private javax.swing.JLabel jLabelHitPoints;
    private javax.swing.JLabel jLabelHp;
    private javax.swing.JLabel jLabelHunter;
    private javax.swing.JLabel jLabelIdade;
    private javax.swing.JLabel jLabelIni;
    private javax.swing.JLabel jLabelInspiracoes;
    private javax.swing.JLabel jLabelIntIni;
    private javax.swing.JLabel jLabelLvl;
    private javax.swing.JLabel jLabelLvlHabilidade;
    private javax.swing.JLabel jLabelLvlNen;
    private javax.swing.JLabel jLabelLvlPer;
    private javax.swing.JLabel jLabelLvlPro;
    private javax.swing.JLabel jLabelMan;
    private javax.swing.JLabel jLabelMat;
    private javax.swing.JLabel jLabelMenIni;
    private javax.swing.JLabel jLabelModCar;
    private javax.swing.JLabel jLabelModCon;
    private javax.swing.JLabel jLabelModDex;
    private javax.swing.JLabel jLabelModEms;
    private javax.swing.JLabel jLabelModEsp;
    private javax.swing.JLabel jLabelModFor;
    private javax.swing.JLabel jLabelModInt;
    private javax.swing.JLabel jLabelModMan;
    private javax.swing.JLabel jLabelModMat;
    private javax.swing.JLabel jLabelModMen;
    private javax.swing.JLabel jLabelModNen;
    private javax.swing.JLabel jLabelModRef;
    private javax.swing.JLabel jLabelModTrs;
    private javax.swing.JLabel jLabelMop;
    private javax.swing.JLabel jLabelMopPoints;
    private javax.swing.JLabel jLabelMp;
    private javax.swing.JLabel jLabelNen;
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
    private javax.swing.JLabel jLabelPeso;
    private javax.swing.JLabel jLabelRef;
    private javax.swing.JLabel jLabelRyu;
    private javax.swing.JLabel jLabelSrt;
    private javax.swing.JLabel jLabelSubLvlPer;
    private javax.swing.JLabel jLabelSubLvlPro;
    private javax.swing.JLabel jLabelTen;
    private javax.swing.JLabel jLabelTendencia;
    private javax.swing.JLabel jLabelTrs;
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
    private javax.swing.JLabel jLabelZts;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JProgressBar jProgressBarAop;
    private javax.swing.JProgressBar jProgressBarCdn;
    private javax.swing.JProgressBar jProgressBarEms;
    private javax.swing.JProgressBar jProgressBarEn;
    private javax.swing.JProgressBar jProgressBarEsp;
    private javax.swing.JProgressBar jProgressBarExp;
    private javax.swing.JProgressBar jProgressBarExpNen;
    private javax.swing.JProgressBar jProgressBarHp;
    private javax.swing.JProgressBar jProgressBarMan;
    private javax.swing.JProgressBar jProgressBarMat;
    private javax.swing.JProgressBar jProgressBarMop;
    private javax.swing.JProgressBar jProgressBarMp;
    private javax.swing.JProgressBar jProgressBarRef;
    private javax.swing.JProgressBar jProgressBarRyu;
    private javax.swing.JProgressBar jProgressBarTen;
    private javax.swing.JProgressBar jProgressBarTrs;
    private javax.swing.JProgressBar jProgressBarZts;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
