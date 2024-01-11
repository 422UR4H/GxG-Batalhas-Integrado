/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.batalhas;

import algoritmos.dal.ModuloConexao;
import algoritmos.gerador.AlgoritmoPrincipalGerador;
import ficha_personagem.Ficha;
import ficha_personagem.Habilidades;
import ficha_personagem.InfoPerson;
import ficha_personagem.Iniciativa;
import ficha_personagem.InfoTurno;
import ficha_personagem.LvlBonus;
import ficha_personagem.LvlExp;
import ficha_personagem.TreinoPosBatalha;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

import java.sql.*;

/**
 *
 * @author 422UR4H
 */
public class AlgoritmoPrincipal {
    private static Ficha atacante;
    private static Ficha defensor;
    private static Ficha ficha;
    private static Habilidades habilidade;
    private static int qtdPersonagens;
    private static int valor;
    private static String linha;
    private static Color cor;
    private static List<String> emBatalha = new ArrayList<>();
    private static InfoTurno infoTurno;
    private static Map<Integer, InfoTurno> infoTurnos = new HashMap<>();
    private static Map<String, InfoPerson> infoHpsMops = new HashMap<>();
    private static Map<String, Ficha> fichas = new HashMap<>();
    private static Map<String, Iniciativa> iniciativa = new HashMap<>();
    private static Map<String, TreinoPosBatalha> tpb = new HashMap<>();
    private static boolean calculadoraBloqueadaPorAtacante = true;
    private static boolean calculadoraBloqueadaPorDefensor = true;
    private static boolean itemAddedByFunction = false;
    private static final int EXP_LVL[] = new int[AlgoritmoPrincipalGerador.getEXP_LVL_MAX()];
    private static final int EXP_NEN[] = new int[AlgoritmoPrincipalGerador.getEXP_NEN_MAX()];
    private static final int LVL_NEN[] = new int[AlgoritmoPrincipalGerador.getLVL_NEN_MAX()];
    private static final String DIR = "C:\\";
    private static final String DIR_INFO = "C:\\dataBase\\BD_Info.dat";
    private static final String DIR_FICHAS = "C:\\dataBase\\fichas";
    private static final String MOP = "MOP";
    private static final String HP = "HP";
    private static final String STUN = "STUN";
    private static final String EXT = "EXT";
    private static final String LVL = "LVL";


    public static List<String> getEmBatalha() {
        return emBatalha;
    }

    public static void setEmBatalha(List<String> emBatalha) {
        AlgoritmoPrincipal.emBatalha = emBatalha;
    }
    
    public static void addEmBatalha(String nick) {
        emBatalha.add(nick);
    }
    
    public static void clearEmBatalha() {
        emBatalha.clear();
    }
    
    public static boolean containsEmBatalha(String nome) {
        return emBatalha.contains(nome);
    }

    public static Color getCor() {
        return cor;
    }

    public static void setCor(Color cor) {
        AlgoritmoPrincipal.cor = cor;
    }
    
    public static int getEXP_LVL(int i) {
        return EXP_LVL[i];
    }

    public static int getEXP_NEN(int i) {
        return EXP_NEN[i];
    }

    public static int getLVL_NEN(int i) {
        return LVL_NEN[i];
    }
    
    public static String getDIR() {
        return DIR;
    }

    public static String getMOP() {
        return MOP;
    }

    public static String getHP() {
        return HP;
    }

    public static String getSTUN() {
        return STUN;
    }

    public static String getEXT() {
        return EXT;
    }
    
    public static String getLVL() {
        return LVL;
    }

    public static String getDIR_FICHAS() {
        return DIR_FICHAS;
    }
    
    public static Ficha getFicha(String nome) {
        return fichas.get(nome);
    }

    public static Map<Integer, InfoTurno> getInfoTurnos() {
        return infoTurnos;
    }

    public static void setInfoTurnos(Map<Integer, InfoTurno> infoTurnos) {
        AlgoritmoPrincipal.infoTurnos = infoTurnos;
    }
    
    public static boolean isItemAddedByFunction() {
        return itemAddedByFunction;
    }

    public static void setItemAddedByFunction(boolean itemAddedByFunction) {
        AlgoritmoPrincipal.itemAddedByFunction = itemAddedByFunction;
    }
    
    public static void removeFicha(String nome) {
        AlgoritmoPrincipal.fichas.remove(nome);
    }
    
    public static boolean deleteFicha(String nick) {
        PreparedStatement pst;
        String sql;
        Connection execute = ModuloConexao.postgresConector();

        try {
            // deletando habilidades
            sql = "DELETE FROM habilidades WHERE nick = ?";
            pst = execute.prepareStatement(sql);
            pst.setString(1, nick);

            pst.execute();

            // deletendo proficiencias
            sql = "DELETE FROM pro WHERE nick = ? ";
            pst = execute.prepareStatement(sql);
            pst.setString(1, nick);

            pst.execute();

            // deletando pericias
            sql = "DELETE FROM per WHERE nick = ?";
            pst = execute.prepareStatement(sql);
            pst.setString(1, nick);

            pst.execute();
            
            // deletando ficha
            sql = "DELETE FROM ficha WHERE nick = ?";
            pst = execute.prepareStatement(sql);
            pst.setString(1, nick);
            
            pst.execute();
            
            execute.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("falha no delete - ficha");
            return false;
        }
    }
    
    public static boolean loadFichas() {
        String sql = "select * from ficha";
        PreparedStatement pst;
        ResultSet rs;
        Connection execute = ModuloConexao.postgresConector();
        
        if (execute == null) {
            return false;
        }
        
        try {
            
            pst = execute.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Ficha ficha = new Ficha();
                Map<String, LvlExp> atr = ficha.getAtr();
                
                ficha.setNick(rs.getString(1));
                ficha.setNome(rs.getString(2));
                ficha.setClasse(rs.getString(3));
                ficha.setNen(rs.getString(4));
                ficha.setTendencia(rs.getString(5));
                ficha.setHunter(rs.getString(6));
                
                ficha.setDias(Double.parseDouble(rs.getString(7)));
                ficha.setAltura(Double.parseDouble(rs.getString(8)));
                ficha.setPeso(Double.parseDouble(rs.getString(9)));
                ficha.setIdade(Integer.parseInt(rs.getString(10)));
                
                ficha.setInventario(rs.getString(11));
                ficha.setDescricao(rs.getString(12));
                ficha.setDescricaoBreve(rs.getString(13));
                
                ficha.setIniFor(Integer.parseInt(rs.getString(14)));
                ficha.setIniCon(Integer.parseInt(rs.getString(15)));
                ficha.setIniDex(Integer.parseInt(rs.getString(16)));
                ficha.setIniInt(Integer.parseInt(rs.getString(17)));
                ficha.setIniCar(Integer.parseInt(rs.getString(18)));
                ficha.setIniMen(Integer.parseInt(rs.getString(19)));
                
                ficha.setValFor(Integer.parseInt(rs.getString(20)));
                ficha.setValCon(Integer.parseInt(rs.getString(21)));
                ficha.setValDex(Integer.parseInt(rs.getString(22)));
                ficha.setValInt(Integer.parseInt(rs.getString(23)));
                ficha.setValCar(Integer.parseInt(rs.getString(24)));
                ficha.setValMen(Integer.parseInt(rs.getString(25)));
                
                ficha.setModFor(Integer.parseInt(rs.getString(26)));
                ficha.setModCon(Integer.parseInt(rs.getString(27)));
                ficha.setModDex(Integer.parseInt(rs.getString(28)));
                ficha.setModInt(Integer.parseInt(rs.getString(29)));
                ficha.setModCar(Integer.parseInt(rs.getString(30)));
                ficha.setModMen(Integer.parseInt(rs.getString(31)));
                
                ficha.setbFor(Integer.parseInt(rs.getString(32)));
                ficha.setbCon(Integer.parseInt(rs.getString(33)));
                ficha.setbDex(Integer.parseInt(rs.getString(34)));
                ficha.setbInt(Integer.parseInt(rs.getString(35)));
                ficha.setbCar(Integer.parseInt(rs.getString(36)));
                ficha.setbMen(Integer.parseInt(rs.getString(37)));
                
                ficha.setPerFor(Integer.parseInt(rs.getString(38)));
                ficha.setPerCon(Integer.parseInt(rs.getString(39)));
                ficha.setPerDex(Integer.parseInt(rs.getString(40)));
                ficha.setPerInt(Integer.parseInt(rs.getString(41)));
                ficha.setPerCar(Integer.parseInt(rs.getString(42)));
                ficha.setPerMen(Integer.parseInt(rs.getString(43)));
                
                atr.get("REF").setExp(Integer.parseInt(rs.getString(44)));
                atr.get("EMS").setExp(Integer.parseInt(rs.getString(45)));
                atr.get("MAT").setExp(Integer.parseInt(rs.getString(46)));
                atr.get("MAN").setExp(Integer.parseInt(rs.getString(47)));
                atr.get("TRS").setExp(Integer.parseInt(rs.getString(48)));
                atr.get("ESP").setExp(Integer.parseInt(rs.getString(49)));
                atr.get("CDN").setExp(Integer.parseInt(rs.getString(50)));
                atr.get("TEN").setExp(Integer.parseInt(rs.getString(51)));
                atr.get("RYU").setExp(Integer.parseInt(rs.getString(52)));
                atr.get("AOP").setExp(Integer.parseInt(rs.getString(53)));
                atr.get("MOP").setExp(Integer.parseInt(rs.getString(54)));
                atr.get("ZTS").setExp(Integer.parseInt(rs.getString(55)));
                atr.get("EN").setExp(Integer.parseInt(rs.getString(56)));
                
                atr.get("REF").setLvl(Integer.parseInt(rs.getString(57)));
                atr.get("EMS").setLvl(Integer.parseInt(rs.getString(58)));
                atr.get("MAT").setLvl(Integer.parseInt(rs.getString(59)));
                atr.get("MAN").setLvl(Integer.parseInt(rs.getString(60)));
                atr.get("TRS").setLvl(Integer.parseInt(rs.getString(61)));
                atr.get("ESP").setLvl(Integer.parseInt(rs.getString(62)));
                atr.get("CDN").setLvl(Integer.parseInt(rs.getString(63)));
                atr.get("TEN").setLvl(Integer.parseInt(rs.getString(64)));
                atr.get("RYU").setLvl(Integer.parseInt(rs.getString(65)));
                atr.get("AOP").setLvl(Integer.parseInt(rs.getString(66)));
                atr.get("MOP").setLvl(Integer.parseInt(rs.getString(67)));
                atr.get("ZTS").setLvl(Integer.parseInt(rs.getString(68)));
                atr.get("EN").setLvl(Integer.parseInt(rs.getString(69)));
                
                ficha.setModCdn(Integer.parseInt(rs.getString(70)));
                ficha.setCoefHp(Integer.parseInt(rs.getString(71)));
                ficha.setLvl(Integer.parseInt(rs.getString(72)));
                ficha.setExp(Integer.parseInt(rs.getString(73)));
                ficha.setExpBonus(Integer.parseInt(rs.getString(74)));
                ficha.setLvlNen(Integer.parseInt(rs.getString(75)));
                ficha.setExpNen(Integer.parseInt(rs.getString(76)));
                ficha.setExpBonusNen(Integer.parseInt(rs.getString(77)));
                
//              ficha.setHpMax(Integer.parseInt(rs.getString(78)))
                ficha.setMopMax(Integer.parseInt(rs.getString(79)));
                ficha.setHpNegMax(Integer.parseInt(rs.getString(80)));
                
                ficha.setHpAtual(Integer.parseInt(rs.getString(81)));
                ficha.setMopAtual(Integer.parseInt(rs.getString(82)));
                ficha.setHpNegAtual(Integer.parseInt(rs.getString(83)));
                
                ficha.setIni(Integer.parseInt(rs.getString(84)));
                ficha.setEsq(Integer.parseInt(rs.getString(85)));
                ficha.setApr(Integer.parseInt(rs.getString(86)));
                ficha.setCrt(Integer.parseInt(rs.getString(87)));
                ficha.setVel(Integer.parseInt(rs.getString(88)));
                
                ficha.setbIntCdn(Integer.parseInt(rs.getString(89)));
//              ficha.setSorte(Integer.parseInt(rs.getString(90)));
                ficha.setSorteDiaria(Integer.parseInt(rs.getString(91)));
                ficha.setModClas(Double.parseDouble(rs.getString(92)));
                
                ficha.setSortePorLvl(convertStB(rs.getString(93)));
                ficha.setPersonagemDeJogador(convertStB(rs.getString(94)));
                ficha.setCriaturaDoMestre(convertStB(rs.getString(95)));
                
                ficha.setPontosHeroicos(Integer.parseInt(rs.getString(96)));
                ficha.setPontosInspiracao(Integer.parseInt(rs.getString(97)));
                
                ficha.setShu(Integer.parseInt(rs.getString(98)));
                ficha.setStun(Integer.parseInt(rs.getString(99)));
                
                ficha.setDesmaiado(convertStB(rs.getString(100)));
                
                ficha.setAtkPad(rs.getString(101));
                ficha.setDefPad(rs.getString(102));
                
                
                ficha.setHp();
                ficha.resetSortes();
                
                
                // habilidades
                sql = "select * from habilidades where nick = ?";
                PreparedStatement pst2 = execute.prepareStatement(sql);
                pst2.setString(1, ficha.getNick());
                ResultSet rs2 = pst2.executeQuery();
                
                ficha.getHabilidades().clear();
                
                while (rs2.next()) {
                    Habilidades habilidade = new Habilidades();
                    
                    habilidade.setNome(rs2.getString(2));
                    habilidade.setArma(rs2.getString(3));
                    habilidade.setDados(rs2.getString(4));
                    habilidade.setProficiencia(rs2.getString(5));
                    
                    habilidade.setDescricao(rs2.getString(6));
                    habilidade.setDescricaoBreve(rs2.getString(7));
                    
                    habilidade.setRestricao(Double.parseDouble(rs2.getString(8)));
                    
                    habilidade.setDano(Integer.parseInt(rs2.getString(9)));
                    habilidade.setDanoPorSegundo(Integer.parseInt(rs2.getString(10)));
                    habilidade.setAuraBonus(Integer.parseInt(rs2.getString(11)));
                    habilidade.setTurnoDps(Integer.parseInt(rs2.getString(12)));
                    habilidade.setDecrescimoDpsPorTurno(Integer.parseInt(rs2.getString(13)));
                    habilidade.setQtd(Integer.parseInt(rs2.getString(14)));
                    habilidade.setVol(Integer.parseInt(rs2.getString(15)));
                    habilidade.setCrt(Integer.parseInt(rs2.getString(16)));
                    habilidade.setDanoFixo(Integer.parseInt(rs2.getString(17)));
                    habilidade.setAcertoFixo(Integer.parseInt(rs2.getString(18)));
                    habilidade.setLvl(Integer.parseInt(rs2.getString(19)));
                    habilidade.setSubLvl(Integer.parseInt(rs2.getString(20)));
                    habilidade.setBonus(Integer.parseInt(rs2.getString(21)));
                    
                    habilidade.setQtdFor(Integer.parseInt(rs2.getString(22)));
                    habilidade.setQtdCon(Integer.parseInt(rs2.getString(23)));
                    habilidade.setQtdDex(Integer.parseInt(rs2.getString(24)));
                    habilidade.setQtdInt(Integer.parseInt(rs2.getString(25)));
                    habilidade.setQtdCar(Integer.parseInt(rs2.getString(26)));
                    habilidade.setQtdMen(Integer.parseInt(rs2.getString(27)));
                    habilidade.setQtdRef(Integer.parseInt(rs2.getString(28)));
                    habilidade.setQtdEms(Integer.parseInt(rs2.getString(29)));
                    habilidade.setQtdMan(Integer.parseInt(rs2.getString(30)));
                    habilidade.setQtdMat(Integer.parseInt(rs2.getString(31)));
                    habilidade.setQtdTrs(Integer.parseInt(rs2.getString(32)));
                    habilidade.setQtdEsp(Integer.parseInt(rs2.getString(33)));
                    habilidade.setQtdEsq(Integer.parseInt(rs2.getString(34)));
                    habilidade.setQtdVel(Integer.parseInt(rs2.getString(35)));
                    habilidade.setQtdTen(Integer.parseInt(rs2.getString(36)));
                    habilidade.setQtdAop(Integer.parseInt(rs2.getString(37)));
                    habilidade.setQtdMop(Integer.parseInt(rs2.getString(38)));
                    habilidade.setQtdCdn(Integer.parseInt(rs2.getString(39)));
                    
                    habilidade.setPerfurante(convertStB(rs2.getString(40)));
                    habilidade.setGastaAura(convertStB(rs2.getString(41)));
                    habilidade.setTrs(convertStB(rs2.getString(42)));
                    habilidade.setMat(convertStB(rs2.getString(43)));
                    habilidade.setMan(convertStB(rs2.getString(44)));
                    habilidade.setDps(convertStB(rs2.getString(45)));
                    habilidade.setRebote(convertStB(rs2.getString(46)));
                    
                    habilidade.setSomarFor(convertStB(rs2.getString(47)));
                    habilidade.setSomarCon(convertStB(rs2.getString(48)));
                    habilidade.setSomarDex(convertStB(rs2.getString(49)));
                    habilidade.setSomarInt(convertStB(rs2.getString(50)));
                    habilidade.setSomarCar(convertStB(rs2.getString(51)));
                    habilidade.setSomarMen(convertStB(rs2.getString(52)));
                    habilidade.setSomarRef(convertStB(rs2.getString(53)));
                    habilidade.setSomarEms(convertStB(rs2.getString(54)));
                    habilidade.setSomarMan(convertStB(rs2.getString(55)));
                    habilidade.setSomarMat(convertStB(rs2.getString(56)));
                    habilidade.setSomarTrs(convertStB(rs2.getString(57)));
                    habilidade.setSomarEsp(convertStB(rs2.getString(58)));
                    habilidade.setSomarEsq(convertStB(rs2.getString(59)));
                    habilidade.setSomarVel(convertStB(rs2.getString(60)));
                    habilidade.setSomarTen(convertStB(rs2.getString(61)));
                    habilidade.setSomarAop(convertStB(rs2.getString(62)));
                    habilidade.setSomarMop(convertStB(rs2.getString(63)));
                    habilidade.setSomarCdn(convertStB(rs2.getString(64)));
                    
                    try {
                        habilidade.setRyu(Integer.parseInt(rs2.getString(65)));
                        habilidade.setDanoRebote(convertStB(rs2.getString(66)));
                        habilidade.setGastaRyu(convertStB(rs2.getString(67)));
                    } catch (NumberFormatException e) {
                        
                    }
                    
                    
                    // inserindo habilidade
                    ficha.putHabilidade(habilidade.getNome(), habilidade);
                }
                
                
                // pro
                sql = "select * from pro where nick = ?";
                PreparedStatement pst3 = execute.prepareStatement(sql);
                pst3.setString(1, ficha.getNick());
                ResultSet rs3 = pst3.executeQuery();
                
                ficha.getPro().clear();
                
                while (rs3.next()) {
                    LvlBonus lvlBonus = new LvlBonus();
                    
                    lvlBonus.setLvl(Integer.parseInt(rs3.getString(3)));
                    lvlBonus.setLvj(Integer.parseInt(rs3.getString(4)));
                    lvlBonus.setBonus(Integer.parseInt(rs3.getString(5)));
                    
                    ficha.getPro().put(rs3.getString(2), lvlBonus);
                }
                
                
                // per
                sql = "select * from per where nick = ?";
                PreparedStatement pst4 = execute.prepareStatement(sql);
                pst4.setString(1, ficha.getNick());
                ResultSet rs4 = pst4.executeQuery();
                
                ficha.getPer().clear();
                
                while (rs4.next()) {
                    LvlBonus lvlBonus = new LvlBonus();
                    
                    lvlBonus.setLvl(Integer.parseInt(rs4.getString(3)));
                    lvlBonus.setLvj(Integer.parseInt(rs4.getString(4)));
                    lvlBonus.setBonus(Integer.parseInt(rs4.getString(5)));
                    
                    ficha.getPer().put(rs4.getString(2), lvlBonus);
                }
                
                fichas.put(ficha.getNick(), ficha);
                
            }
            
            execute.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    // new
//    public static boolean loadFichas() throws FileNotFoundException, IOException, ClassNotFoundException {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(/*DIR_GERADOR +*/ "C:\\dataBase\\BD_Fichas.dat"))) {
//            fichas = (Map<String, Ficha>) ois.readObject();
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            JOptionPane.showMessageDialog(null, "Banco de Dados de Fichas não encontrado!", "No DataBase!",
//                    JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//    }
    
//    public static boolean loadFichas(File folder) throws ClassNotFoundException {
//        for (File file : folder.listFiles()) {
//            if (!file.isDirectory()) {
//                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + file.getName()))) {
//                    Ficha ficha = (Ficha) ois.readObject();
//                    fichas.put(ficha.getNick(), ficha);
//                } catch (IOException e) {
//                    System.out.println(e.toString());
//                    JOptionPane.showMessageDialog(null, "Algo errado!", "No DataBase!",
//                            JOptionPane.WARNING_MESSAGE);
//                    System.out.println(folder + "\\" + file.getName());
//                    return false;
//                }
//            } else {
//                loadFichas(file);
//            }
//        }
//        return true;
//    }
    
//    public static boolean loadAtkPad() throws ClassNotFoundException {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DIR_GERADOR + "dataBase\\BD_AtkPad.dat"))) {
//            atkPad = (Map<String, SkillPadrao>) ois.readObject();
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            System.out.println("ruim");
////            JOptionPane.showMessageDialog(null, "Banco de Dados de AtkPad não encontrado!", "No DataBase!",
////                    JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//    }
//    
//    public static boolean loadDefPad() throws ClassNotFoundException {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DIR_GERADOR + "dataBase\\BD_DefPad.dat"))) {
//            defPad = (Map<String, SkillPadrao>) ois.readObject();
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            System.out.println("ruim");
////            JOptionPane.showMessageDialog(null, "Banco de Dados de DefPad não encontrado!", "No DataBase!",
////                    JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//    }
    
    public static boolean containsFicha(String nomeFicha) {
        for (String nome : fichas.keySet()) {
            if (nomeFicha.equals(fichas.get(nome).getNick())) {
                return true;
            }
        }
        return false;
    }
    
    public static String convertBtS(boolean b) {
        if (b) {
            return "1";
        }
        return "0";
    }
    
    public static boolean convertStB(String s) {
        if (s.equals("1")) {
            return true;
        }
        return false;
    }
    
    public static boolean saveFicha(Ficha ficha) {
        PreparedStatement pst;
        String sql;
        Connection execute = ModuloConexao.postgresConector();

        // inserindo ficha
        try {
            sql = "insert into ficha (" +
                "nick, nome, classe, nen, tendencia, hunter," +
                "dias, altura, peso, idade," +
                "inventario, descricao, descricaobreve," +
                "iniFor, iniCon, iniDex, iniInt, iniCar, iniMen," +
                "valFor, valCon, valDex, valInt, valCar, valMen," +
                "modFor, modCon, modDex, modInt, modCar, modMen," +
                "bFor, bCon, bDex, bInt, bCar, bMen," +
                "perFor, perCon, perDex, perInt, perCar, perMen," +
                "expRef, expEms, expMat, expMan, expTrs, expEsp," +
                "expCdn, expTen, expRyu, expAop, expMop, expZts, expEn," +
                "lvlRef, lvlEms, lvlMat, lvlMan, lvlTrs, lvlEsp," +
                "lvlCdn, lvlTen, lvlRyu, lvlAop, lvlMop, lvlZts, lvlEn," +
                "modCdn, coefHp, lvl, exp, expBonus, lvlNen, expNen, expBonusNen," +
                "hpMax, mopMax, hpNegMax, hpAtual, mopAtual, hpNegAtual," +
                "ini, esq, apr, crt, vel," +
                "bIntCdn, sorte, sorteDiaria, modClas, sortePorLvl," +
                "personagemDeJogador, criaturaDoMestre," +
                "pontosHeroicos, pontosInspiracao," +
                "shu, stun, desmaiado, atkPad, defPad" +
                ") values (" +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?)";

            pst = execute.prepareStatement(sql);

            pst.setString(1, ficha.getNick());
            pst.setString(2, ficha.getNome());
            pst.setString(3, ficha.getClasse());
            pst.setString(4, ficha.getNen());
            pst.setString(5, ficha.getTendencia());
            pst.setString(6, ficha.getHunter());

            pst.setDouble(7, ficha.getDias());
            pst.setDouble(8, ficha.getAltura());
            pst.setDouble(9, ficha.getPeso());
            pst.setInt(10, ficha.getIdade());

            pst.setString(11, ficha.getInventario());
            pst.setString(12, ficha.getDescricao());
            pst.setString(13, ficha.getDescricaoBreve());

            pst.setInt(14, ficha.getIniFor());
            pst.setInt(15, ficha.getIniCon());
            pst.setInt(16, ficha.getIniDex());
            pst.setInt(17, ficha.getIniInt());
            pst.setInt(18, ficha.getIniCar());
            pst.setInt(19, ficha.getIniMen());

            pst.setInt(20, ficha.getValFor());
            pst.setInt(21, ficha.getValCon());
            pst.setInt(22, ficha.getValDex());
            pst.setInt(23, ficha.getValInt());
            pst.setInt(24, ficha.getValCar());
            pst.setInt(25, ficha.getValMen());

            pst.setInt(26, ficha.getModFor());
            pst.setInt(27, ficha.getModCon());
            pst.setInt(28, ficha.getModDex());
            pst.setInt(29, ficha.getModInt());
            pst.setInt(30, ficha.getModCar());
            pst.setInt(31, ficha.getModMen());

            pst.setInt(32, ficha.getbFor());
            pst.setInt(33, ficha.getbCon());
            pst.setInt(34, ficha.getbDex());
            pst.setInt(35, ficha.getbInt());
            pst.setInt(36, ficha.getbCar());
            pst.setInt(37, ficha.getbMen());

            pst.setInt(38, ficha.getPerFor());
            pst.setInt(39, ficha.getPerCon());
            pst.setInt(40, ficha.getPerDex());
            pst.setInt(41, ficha.getPerInt());
            pst.setInt(42, ficha.getPerCar());
            pst.setInt(43, ficha.getPerMen());

            pst.setInt(44, ficha.getAtr("REF").getExp());
            pst.setInt(45, ficha.getAtr("EMS").getExp());
            pst.setInt(46, ficha.getAtr("MAT").getExp());
            pst.setInt(47, ficha.getAtr("MAN").getExp());
            pst.setInt(48, ficha.getAtr("TRS").getExp());
            pst.setInt(49, ficha.getAtr("ESP").getExp());
            pst.setInt(50, ficha.getAtr("CDN").getExp());
            pst.setInt(51, ficha.getAtr("TEN").getExp());
            pst.setInt(52, ficha.getAtr("RYU").getExp());
            pst.setInt(53, ficha.getAtr("AOP").getExp());
            pst.setInt(54, ficha.getAtr("MOP").getExp());
            pst.setInt(55, ficha.getAtr("ZTS").getExp());
            pst.setInt(56, ficha.getAtr("EN").getExp());

            pst.setInt(57, ficha.getAtrRef());
            pst.setInt(58, ficha.getAtrEms());
            pst.setInt(59, ficha.getAtrMat());
            pst.setInt(60, ficha.getAtrMan());
            pst.setInt(61, ficha.getAtrTrs());
            pst.setInt(62, ficha.getAtrEsp());
            pst.setInt(63, ficha.getAtrCdn());
            pst.setInt(64, ficha.getTen());
            pst.setInt(65, ficha.getRyu());
            pst.setInt(66, ficha.getAop());
            pst.setInt(67, ficha.getMop());
            pst.setInt(68, ficha.getZts());
            pst.setInt(69, ficha.getEn());

            pst.setInt(70, ficha.getModCdn());
            pst.setInt(71, ficha.getCoefHp());
            pst.setInt(72, ficha.getLvl());
            pst.setInt(73, ficha.getExp());
            pst.setInt(74, ficha.getExpBonus());
            pst.setInt(75, ficha.getLvlNen());
            pst.setInt(76, ficha.getExpNen());
            pst.setInt(77, ficha.getExpBonusNen());

            pst.setInt(78, ficha.getHpMax());
            pst.setInt(79, ficha.getMopMax());
            pst.setInt(80, ficha.getHpNegMax());

            pst.setInt(81, ficha.getHpAtual());
            pst.setInt(82, ficha.getMopAtual());
            pst.setInt(83, ficha.getHpNegAtual());

            pst.setInt(84, ficha.getIni());
            pst.setInt(85, ficha.getEsq());
            pst.setInt(86, ficha.getApr());
            pst.setInt(87, ficha.getCrt());
            pst.setInt(88, ficha.getVel());

            pst.setInt(89, ficha.getbIntCdn());
            pst.setInt(90, ficha.getSorte());
            pst.setInt(91, ficha.getSorteDiaria());
            pst.setDouble(92, ficha.getModClas());

            pst.setBoolean(93, ficha.isSortePorLvl());
            pst.setBoolean(94, ficha.isPersonagemDeJogador());
            pst.setBoolean(95, ficha.isCriaturaDoMestre());

            pst.setInt(96, ficha.getPontosHeroicos());
            pst.setInt(97, ficha.getPontosInspiracao());
            pst.setInt(98, ficha.getShu());
            pst.setInt(99, ficha.getStun());

            pst.setBoolean(100, ficha.isDesmaiado());

            pst.setString(101, ficha.getAtkPad());
            pst.setString(102, ficha.getDefPad());

            pst.execute();

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("falha no insert - ficha");
        }


        // habilidades
        for (String nomeHabilidade : ficha.getHabilidades().keySet()) {
            Habilidades skill = ficha.getHabilidade(nomeHabilidade);

            // inserindo habilidades
            try {

                sql = "INSERT INTO habilidades (" +
                    "nick, nomeHabilidade, arma, dados, proficiencia," +
                    "descricao, descricaobreve, restricao, dano, danoPorSegundo," +
                    "auraBonus, turnoDps, decrescimoDpsPorTurno," +
                    "qtd, vol, crt, danoFixo, acertoFixo, lvl, subLvl, bonus," +
                    "qtdFor, qtdCon, qtdDex, qtdInt, qtdCar, qtdMen," +
                    "qtdRef, qtdEms, qtdMan, qtdMat, qtdTrs, qtdEsp," +
                    "qtdEsq, qtdVel, qtdTen, qtdAop, qtdMop, qtdCdn," +
                    "perfurante, gastaAura, trs, mat, man, dps, rebote," +
                    "somarFor, somarCon, somarDex, somarInt, somarCar, somarMen," +
                    "somarRef, somarEms, somarMan, somarMat, somarTrs, somarEsp," +
                    "somarEsq, somarVel, somarTen, somarAop, somarMop, somarCdn," +
                    "ryu, danoRebote, gastaRyu" +
                    ") VALUES(" +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?)";

                pst = execute.prepareStatement(sql);

                pst.setString(1, ficha.getNick());

                pst.setString(2, skill.getNome());
                pst.setString(3, skill.getArma());
                pst.setString(4, skill.getDados());
                pst.setString(5, skill.getProficiencia());
                pst.setString(6, skill.getDescricao());
                pst.setString(7, skill.getDescricaoBreve());

                pst.setDouble(8, skill.getRestricao());
                pst.setInt(9, skill.getDano());
                pst.setInt(10, skill.getDanoPorSegundo());
                pst.setInt(11, skill.getAuraBonus());
                pst.setInt(12, skill.getTurnoDps());
                pst.setInt(13, skill.getDecrescimoDpsPorTurno());
                pst.setInt(14, skill.getQtd());
                pst.setInt(15, skill.getVol());
                pst.setInt(16, skill.getCrt());
                pst.setInt(16, skill.getCrt());
                pst.setInt(17, skill.getDanoFixo());
                pst.setInt(18, skill.getAcertoFixo());
                pst.setInt(19, skill.getLvl());
                pst.setInt(20, skill.getSubLvl());
                pst.setInt(21, skill.getBonus());

                pst.setInt(22, skill.getQtdFor());
                pst.setInt(23, skill.getQtdCon());
                pst.setInt(24, skill.getQtdDex());
                pst.setInt(25, skill.getQtdInt());
                pst.setInt(26, skill.getQtdCar());
                pst.setInt(27, skill.getQtdMen());
                pst.setInt(28, skill.getQtdRef());
                pst.setInt(29, skill.getQtdEms());
                pst.setInt(30, skill.getQtdMan());
                pst.setInt(31, skill.getQtdMat());
                pst.setInt(32, skill.getQtdTrs());
                pst.setInt(33, skill.getQtdEsp());
                pst.setInt(34, skill.getQtdEsq());
                pst.setInt(35, skill.getQtdVel());
                pst.setInt(36, skill.getQtdTen());
                pst.setInt(37, skill.getQtdAop());
                pst.setInt(38, skill.getQtdMop());
                pst.setInt(39, skill.getQtdCdn());

                pst.setBoolean(40, skill.isPerfurante());
                pst.setBoolean(41, skill.isGastaAura());
                pst.setBoolean(42, skill.isTrs());
                pst.setBoolean(43, skill.isMat());
                pst.setBoolean(44, skill.isMan());
                pst.setBoolean(45, skill.isDps());
                pst.setBoolean(46, skill.isRebote());

                pst.setBoolean(47, skill.isSomarFor());
                pst.setBoolean(48, skill.isSomarCon());
                pst.setBoolean(49, skill.isSomarDex());
                pst.setBoolean(50, skill.isSomarInt());
                pst.setBoolean(51, skill.isSomarCar());
                pst.setBoolean(52, skill.isSomarMen());
                pst.setBoolean(53, skill.isSomarRef());
                pst.setBoolean(54, skill.isSomarEms());
                pst.setBoolean(55, skill.isSomarMan());
                pst.setBoolean(56, skill.isSomarMat());
                pst.setBoolean(57, skill.isSomarTrs());
                pst.setBoolean(58, skill.isSomarEsp());
                pst.setBoolean(59, skill.isSomarEsq());
                pst.setBoolean(60, skill.isSomarVel());
                pst.setBoolean(61, skill.isSomarTen());
                pst.setBoolean(62, skill.isSomarAop());
                pst.setBoolean(64, skill.isSomarCdn());

                pst.setInt(65, skill.getRyu());
                pst.setBoolean(66, skill.isDanoRebote());
                pst.setBoolean(67, skill.isGastaRyu());

                pst.execute();

            } catch (SQLException e) {
                System.out.println("falha no insert - habilidades");
            }
        }

        // proficiencias
        for (String nomePro : ficha.getPro().keySet()) {
            LvlBonus pro = ficha.getPro().get(nomePro);

            // inserindo proficiencias
            try {
                sql = "INSERT INTO pro " +
                "(nick, nomePro, lvl, lvj, bonus) " +
                "VALUES (?, ?, ?, ?, ?)";
                pst = execute.prepareStatement(sql);
                pst.setString(1, ficha.getNick());
                pst.setString(2, nomePro);
                pst.setInt(3, pro.getLvl());
                pst.setInt(4, pro.getLvj());
                pst.setInt(5, pro.getBonus());

                pst.execute();

            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("nada foi inserido - pro");
            }
        }

        // pericias
        for (String nomePer : ficha.getPer().keySet()) {
            LvlBonus per = ficha.getPer().get(nomePer);

            // inserindo a pericia
            try {
                sql = "INSERT INTO per " +
                "(nick, nomePer, lvl, lvj, bonus) " +
                "VALUES (?, ?, ?, ?, ?)";
                pst = execute.prepareStatement(sql);
                pst.setString(1, ficha.getNick());
                pst.setString(2, nomePer);
                pst.setInt(3, per.getLvl());
                pst.setInt(4, per.getLvj());
                pst.setInt(5, per.getBonus());

                pst.execute();

            } catch (SQLException e) {
                System.out.println("nada foi inserido - per");
            }
        }

        try {
            execute.close();
        } catch (SQLException e) {
            System.out.println("erro ao fechar");
            System.out.println(e);
        }

        return true;
    }
    
    public static boolean saveFicha(File folder) throws ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(DIR_FICHAS + "\\" + ficha.getNick() + ".dat"))) {
            
            oos.writeObject(ficha);
            oos.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public static void saveFichas(File folder) throws ClassNotFoundException {
        for (String nick : fichas.keySet()) {
            ficha = fichas.get(nick);
            saveFicha(folder);
        }
    }

    public static void saveFichas() throws ClassNotFoundException {
        for (String nick : fichas.keySet()) {
            ficha = fichas.get(nick);
            saveFicha(ficha);
        }
    }
    
//    public static boolean saveAtkPad() {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DIR_GERADOR + "dataBase\\BD_AtkPad.dat"))) {
//            oos.writeObject(atkPad);
//            oos.close();
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            return false;
//        }
//    }
//    
//    public static boolean saveDefPad() {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DIR_GERADOR + "dataBase\\BD_DefPad.dat"))) {
//            oos.writeObject(defPad);
//            oos.close();
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            return false;
//        }
//    }
//    
    public static void replaceFicha(String nick, Ficha ficha) {
        AlgoritmoPrincipal.fichas.remove(nick);
        AlgoritmoPrincipal.fichas.put(ficha.getNick(), ficha);
    }
    
    public static boolean updateFicha(Ficha ficha) {
        PreparedStatement pst;
        String sql;
        Connection execute = ModuloConexao.postgresConector();

        // atualizando ficha
        try {
            sql = "UPDATE ficha SET (" +
                "nome, classe, nen, tendencia, hunter," +
                "dias, altura, peso, idade," +
                "inventario, descricao, descricaobreve," +
                "iniFor, iniCon, iniDex, iniInt, iniCar, iniMen," +
                "valFor, valCon, valDex, valInt, valCar, valMen," +
                "modFor, modCon, modDex, modInt, modCar, modMen," +
                "bFor, bCon, bDex, bInt, bCar, bMen," +
                "perFor, perCon, perDex, perInt, perCar, perMen," +
                "expRef, expEms, expMat, expMan, expTrs, expEsp," +
                "expCdn, expTen, expRyu, expAop, expMop, expZts, expEn," +
                "lvlRef, lvlEms, lvlMat, lvlMan, lvlTrs, lvlEsp," +
                "lvlCdn, lvlTen, lvlRyu, lvlAop, lvlMop, lvlZts, lvlEn," +
                "modCdn, coefHp, lvl, exp, expBonus, lvlNen, expNen, expBonusNen," +
                "hpMax, mopMax, hpNegMax, hpAtual, mopAtual, hpNegAtual," +
                "ini, esq, apr, crt, vel," +
                "bIntCdn, sorte, sorteDiaria, modClas, sortePorLvl," +
                "personagemDeJogador, criaturaDoMestre," +
                "pontosHeroicos, pontosInspiracao," +
                "shu, stun, desmaiado, atkPad, defPad" +
                ") = (" +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?) WHERE nick = ?";

            pst = execute.prepareStatement(sql);

            pst.setString(1, ficha.getNome());
            pst.setString(2, ficha.getClasse());
            pst.setString(3, ficha.getNen());
            pst.setString(4, ficha.getTendencia());
            pst.setString(5, ficha.getHunter());

            pst.setDouble(6, ficha.getDias());
            pst.setDouble(7, ficha.getAltura());
            pst.setDouble(8, ficha.getPeso());
            pst.setInt(9, ficha.getIdade());

            pst.setString(10, ficha.getInventario());
            pst.setString(11, ficha.getDescricao());
            pst.setString(12, ficha.getDescricaoBreve());

            pst.setInt(13, ficha.getIniFor());
            pst.setInt(14, ficha.getIniCon());
            pst.setInt(15, ficha.getIniDex());
            pst.setInt(16, ficha.getIniInt());
            pst.setInt(17, ficha.getIniCar());
            pst.setInt(18, ficha.getIniMen());

            pst.setInt(19, ficha.getValFor());
            pst.setInt(20, ficha.getValCon());
            pst.setInt(21, ficha.getValDex());
            pst.setInt(22, ficha.getValInt());
            pst.setInt(23, ficha.getValCar());
            pst.setInt(24, ficha.getValMen());

            pst.setInt(25, ficha.getModFor());
            pst.setInt(26, ficha.getModCon());
            pst.setInt(27, ficha.getModDex());
            pst.setInt(28, ficha.getModInt());
            pst.setInt(29, ficha.getModCar());
            pst.setInt(30, ficha.getModMen());

            pst.setInt(31, ficha.getbFor());
            pst.setInt(32, ficha.getbCon());
            pst.setInt(33, ficha.getbDex());
            pst.setInt(34, ficha.getbInt());
            pst.setInt(35, ficha.getbCar());
            pst.setInt(36, ficha.getbMen());

            pst.setInt(37, ficha.getPerFor());
            pst.setInt(38, ficha.getPerCon());
            pst.setInt(39, ficha.getPerDex());
            pst.setInt(40, ficha.getPerInt());
            pst.setInt(41, ficha.getPerCar());
            pst.setInt(42, ficha.getPerMen());

            pst.setInt(43, ficha.getAtr("REF").getExp());
            pst.setInt(44, ficha.getAtr("EMS").getExp());
            pst.setInt(45, ficha.getAtr("MAT").getExp());
            pst.setInt(46, ficha.getAtr("MAN").getExp());
            pst.setInt(47, ficha.getAtr("TRS").getExp());
            pst.setInt(48, ficha.getAtr("ESP").getExp());
            pst.setInt(49, ficha.getAtr("CDN").getExp());
            pst.setInt(50, ficha.getAtr("TEN").getExp());
            pst.setInt(51, ficha.getAtr("RYU").getExp());
            pst.setInt(52, ficha.getAtr("AOP").getExp());
            pst.setInt(53, ficha.getAtr("MOP").getExp());
            pst.setInt(54, ficha.getAtr("ZTS").getExp());
            pst.setInt(55, ficha.getAtr("EN").getExp());

            pst.setInt(56, ficha.getAtrRef());
            pst.setInt(57, ficha.getAtrEms());
            pst.setInt(58, ficha.getAtrMat());
            pst.setInt(59, ficha.getAtrMan());
            pst.setInt(60, ficha.getAtrTrs());
            pst.setInt(61, ficha.getAtrEsp());
            pst.setInt(62, ficha.getAtrCdn());
            pst.setInt(63, ficha.getTen());
            pst.setInt(64, ficha.getRyu());
            pst.setInt(65, ficha.getAop());
            pst.setInt(66, ficha.getMop());
            pst.setInt(67, ficha.getZts());
            pst.setInt(68, ficha.getEn());

            pst.setInt(69, ficha.getModCdn());
            pst.setInt(70, ficha.getCoefHp());
            pst.setInt(71, ficha.getLvl());
            pst.setInt(72, ficha.getExp());
            pst.setInt(73, ficha.getExpBonus());
            pst.setInt(74, ficha.getLvlNen());
            pst.setInt(75, ficha.getExpNen());
            pst.setInt(76, ficha.getExpBonusNen());

            pst.setInt(77, ficha.getHpMax());
            pst.setInt(78, ficha.getMopMax());
            pst.setInt(79, ficha.getHpNegMax());

            pst.setInt(80, ficha.getHpAtual());
            pst.setInt(81, ficha.getMopAtual());
            pst.setInt(82, ficha.getHpNegAtual());

            pst.setInt(83, ficha.getIni());
            pst.setInt(84, ficha.getEsq());
            pst.setInt(85, ficha.getApr());
            pst.setInt(86, ficha.getCrt());
            pst.setInt(87, ficha.getVel());

            pst.setInt(88, ficha.getbIntCdn());
            pst.setInt(89, ficha.getSorte());
            pst.setInt(90, ficha.getSorteDiaria());
            pst.setDouble(91, ficha.getModClas());

            pst.setBoolean(92, ficha.isSortePorLvl());
            pst.setBoolean(93, ficha.isPersonagemDeJogador());
            pst.setBoolean(94, ficha.isCriaturaDoMestre());

            pst.setInt(95, ficha.getPontosHeroicos());
            pst.setInt(96, ficha.getPontosInspiracao());
            pst.setInt(97, ficha.getShu());
            pst.setInt(98, ficha.getStun());

            pst.setBoolean(99, ficha.isDesmaiado());

            pst.setString(100, ficha.getAtkPad());
            pst.setString(101, ficha.getDefPad());

            
            pst.setString(102, ficha.getNick());

            pst.execute();

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("falha no update - ficha");
        }


        // habilidades
        for (String nomeHabilidade : ficha.getHabilidades().keySet()) {
            Habilidades skill = ficha.getHabilidade(nomeHabilidade);

            // atualizando habilidades
            try {

                sql = "UPDATE habilidades SET (" +
                    "nomeHabilidade, arma, dados, proficiencia," +
                    "descricao, descricaobreve, restricao, dano, danoPorSegundo," +
                    "auraBonus, turnoDps, decrescimoDpsPorTurno," +
                    "qtd, vol, crt, danoFixo, acertoFixo, lvl, subLvl, bonus," +
                    "qtdFor, qtdCon, qtdDex, qtdInt, qtdCar, qtdMen," +
                    "qtdRef, qtdEms, qtdMan, qtdMat, qtdTrs, qtdEsp," +
                    "qtdEsq, qtdVel, qtdTen, qtdAop, qtdMop, qtdCdn," +
                    "perfurante, gastaAura, trs, mat, man, dps, rebote," +
                    "somarFor, somarCon, somarDex, somarInt, somarCar, somarMen," +
                    "somarRef, somarEms, somarMan, somarMat, somarTrs, somarEsp," +
                    "somarEsq, somarVel, somarTen, somarAop, somarMop, somarCdn," +
                    "ryu, danoRebote, gastaRyu" +
                    ") =(" +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?" +
                    ") WHERE nomeHabilidade = ?";

                pst = execute.prepareStatement(sql);

                pst.setString(1, skill.getNome());
                pst.setString(2, skill.getArma());
                pst.setString(3, skill.getDados());
                pst.setString(4, skill.getProficiencia());
                pst.setString(5, skill.getDescricao());
                pst.setString(6, skill.getDescricaoBreve());

                pst.setDouble(7, skill.getRestricao());
                pst.setInt(8, skill.getDano());
                pst.setInt(9, skill.getDanoPorSegundo());
                pst.setInt(10, skill.getAuraBonus());
                pst.setInt(11, skill.getTurnoDps());
                pst.setInt(12, skill.getDecrescimoDpsPorTurno());
                pst.setInt(13, skill.getQtd());
                pst.setInt(14, skill.getVol());
                pst.setInt(15, skill.getCrt());
                pst.setInt(16, skill.getDanoFixo());
                pst.setInt(17, skill.getAcertoFixo());
                pst.setInt(18, skill.getLvl());
                pst.setInt(19, skill.getSubLvl());
                pst.setInt(20, skill.getBonus());

                pst.setInt(21, skill.getQtdFor());
                pst.setInt(22, skill.getQtdCon());
                pst.setInt(23, skill.getQtdDex());
                pst.setInt(24, skill.getQtdInt());
                pst.setInt(25, skill.getQtdCar());
                pst.setInt(26, skill.getQtdMen());
                pst.setInt(27, skill.getQtdRef());
                pst.setInt(28, skill.getQtdEms());
                pst.setInt(29, skill.getQtdMan());
                pst.setInt(30, skill.getQtdMat());
                pst.setInt(31, skill.getQtdTrs());
                pst.setInt(32, skill.getQtdEsp());
                pst.setInt(33, skill.getQtdEsq());
                pst.setInt(34, skill.getQtdVel());
                pst.setInt(35, skill.getQtdTen());
                pst.setInt(36, skill.getQtdAop());
                pst.setInt(37, skill.getQtdMop());
                pst.setInt(38, skill.getQtdCdn());

                pst.setBoolean(39, skill.isPerfurante());
                pst.setBoolean(40, skill.isGastaAura());
                pst.setBoolean(41, skill.isTrs());
                pst.setBoolean(42, skill.isMat());
                pst.setBoolean(43, skill.isMan());
                pst.setBoolean(44, skill.isDps());
                pst.setBoolean(45, skill.isRebote());

                pst.setBoolean(46, skill.isSomarFor());
                pst.setBoolean(47, skill.isSomarCon());
                pst.setBoolean(48, skill.isSomarDex());
                pst.setBoolean(49, skill.isSomarInt());
                pst.setBoolean(50, skill.isSomarCar());
                pst.setBoolean(51, skill.isSomarMen());
                pst.setBoolean(52, skill.isSomarRef());
                pst.setBoolean(53, skill.isSomarEms());
                pst.setBoolean(54, skill.isSomarMan());
                pst.setBoolean(55, skill.isSomarMat());
                pst.setBoolean(56, skill.isSomarTrs());
                pst.setBoolean(57, skill.isSomarEsp());
                pst.setBoolean(58, skill.isSomarEsq());
                pst.setBoolean(59, skill.isSomarVel());
                pst.setBoolean(60, skill.isSomarTen());
                pst.setBoolean(61, skill.isSomarAop());
                pst.setBoolean(62, skill.isSomarMop());
                pst.setBoolean(63, skill.isSomarCdn());

                pst.setInt(64, skill.getRyu());
                pst.setBoolean(65, skill.isDanoRebote());
                pst.setBoolean(66, skill.isGastaRyu());

                
                pst.setString(67, ficha.getNick());

                pst.execute();

            } catch (SQLException e) {
                System.out.println("falha no update - habilidades");
            }
        }

        // proficiencias
        for (String nomePro : ficha.getPro().keySet()) {
            LvlBonus pro = ficha.getPro().get(nomePro);

            // inserindo proficiencias
            try {
                sql = "UPDATE pro SET (" +
                "nomePro, lvl, lvj, bonus" +
                ") = (?, ?, ?, ?) " + 
                "WHERE nomePro = ?";
                pst = execute.prepareStatement(sql);
                pst.setString(1, nomePro);
                pst.setInt(2, pro.getLvl());
                pst.setInt(3, pro.getLvj());
                pst.setInt(4, pro.getBonus());
                
                pst.setString(5, ficha.getNick());

                pst.execute();

            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("nada foi inserido - pro");
            }
        }

        // pericias
        for (String nomePer : ficha.getPer().keySet()) {
            LvlBonus per = ficha.getPer().get(nomePer);

            // inserindo a pericia
            try {
                sql = "UPDATE per SET (" +
                "nomePer, lvl, lvj, bonus" +
                ") = (?, ?, ?, ?) " +
                "WHERE nomePer = ?";
                pst = execute.prepareStatement(sql);
                pst.setString(1, nomePer);
                pst.setInt(2, per.getLvl());
                pst.setInt(3, per.getLvj());
                pst.setInt(4, per.getBonus());
                
                pst.setString(5, ficha.getNick());

                pst.execute();

            } catch (SQLException e) {
                System.out.println("nada foi inserido - per");
            }
        }

        try {
            execute.close();
        } catch (SQLException e) {
            System.out.println("erro ao fechar");
            System.out.println(e);
        }

        return true;
    }
    
//    public static boolean saveHps() {
//        Connection execute = ModuloConexao.conector();
//        PreparedStatement pst;
//        String sql = "update ficha set hpAtual = ? where nick = ?";
//        
//        try {
//            pst = execute.prepareStatement(sql);
//            
//            for (String nick : fichas.keySet()) {
//                pst.setString(1, String.valueOf(fichas.get(nick).getHpAtual()));
//                pst.setString(2, nick);
//                
//                pst.execute();
//            }
//            
//            execute.close();
//            return true;
//        } catch (SQLException ex) {
//            return false;
//        }
//    }
    
//    public static boolean saveMops() {
//        Connection execute = ModuloConexao.conector();
//        PreparedStatement pst;
//        String sql = "update ficha set mopAtual = ? where nick = ?";
//        
//        try {
//            pst = execute.prepareStatement(sql);
//            
//            for (String nick : fichas.keySet()) {
//                pst.setString(1, String.valueOf(fichas.get(nick).getMopAtual()));
//                pst.setString(2, nick);
//                
//                pst.execute();
//            }
//            
//            execute.close();
//            return true;
//        } catch (SQLException ex) {
//            return false;
//        }
//    }
    
    /*public static boolean loadInfo() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DIR_INFO + "dataBase\\BD_Info.dat"))) {
            infoTurno = (InfoTurno) ois.readObject();
            return true;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }*/
    
    public static boolean loadInfo() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DIR_INFO))) {
            infoHpsMops = (Map<String, InfoPerson>) ois.readObject();
            
            for (String nick : fichas.keySet()) {
                if (infoHpsMops.get(nick) == null) {
                    continue;
                }
                fichas.get(nick).setHpAtual(infoHpsMops.get(nick).getHp());
                fichas.get(nick).setMopAtual(infoHpsMops.get(nick).getMop());
            }
            
            return true;
        } catch (IOException e) {
            System.out.println(e.toString());
            System.out.println(fichas);
            return false;
        }
    }
    
    /*public static boolean saveInfo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DIR_INFO + "dataBase\\BD_Info.dat"))) {
            oos.writeObject(infoTurno);
            oos.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }*/
    
    public static boolean saveInfo() {
        for (String nick : fichas.keySet()) {
            InfoPerson ip = new InfoPerson(nick, fichas.get(nick).getHpAtual(), fichas.get(nick).getMopAtual());
            infoHpsMops.put(nick, ip);
        }
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DIR_INFO))) {
            oos.writeObject(infoHpsMops);
            oos.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
//    public static void loadHps() {
//        Connection execute = ModuloConexao.conector();
//        
//        try {
//            for (String nick : fichas.keySet()) {
//                Ficha ficha = fichas.get(nick);
//                String sql = "select hpAtual from ficha where nick = ?";
//                PreparedStatement pst = execute.prepareStatement(sql);
//                pst.setString(1, nick);
//                ResultSet rs = pst.executeQuery();
//                
//                if (rs.next()) {
//                    ficha.setHpAtual(Integer.parseInt(rs.getString(1)));
//                }
//                
//            }
//            
//            execute.close();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//    
//    public static void loadMops() {
//        Connection execute = ModuloConexao.conector();
//        
//        try {
//            for (String nick : fichas.keySet()) {
//                Ficha ficha = fichas.get(nick);
//                String sql = "select mopAtual from ficha where nick = ?";
//                PreparedStatement pst = execute.prepareStatement(sql);
//                pst.setString(1, nick);
//                ResultSet rs = pst.executeQuery();
//                
//                if (rs.next()) {
//                    ficha.setMopAtual(Integer.parseInt(rs.getString(1)));
//                }
//                
//            }
//            
//            execute.close();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
    
//    public static void loadHpEMop() {
//        for (String nome : fichas.keySet()) {
//            try {
//                fichas.get(nome).setHpAtual(infoHpsMops.get(nome).getHp());
//                fichas.get(nome).setMopAtual(infoHpsMops.get(nome).getMop());
//            } catch (NullPointerException e) {
////                JOptionPane.showMessageDialog(null, "Bando de Dados de HP e MOP não encontrados!", "No DataBase!",
////                    JOptionPane.WARNING_MESSAGE);
//            }
//        }
//    }
    
    public static boolean loadTabelasExp() {
        try { try ( // lendo exp de lvl
//                FileReader arq = new FileReader("src\\dataBase\\exp_lvl.txt")) {
                FileReader arq = new FileReader("C:\\dataBase\\exp_lvl.txt")) {
                BufferedReader lerArq = new BufferedReader(arq);

                // setando o valor 0 na posição 0 do vetor, que corresponde ao nivel 0
                EXP_LVL[0] = 0;
                // setando o valor 0 na posição 1 do vetor, que corresponde ao nivel 1
                EXP_LVL[1] = 0;

                String linha = lerArq.readLine(); // lê a primeira linha
                // a variável "linha" recebe o valor "null" quando o processo
                // de repetição atingir o final do arquivo texto
                int i = 2;
                while (linha != null) {
                    EXP_LVL[i] = Integer.parseInt(linha); // insere o valor no vetor
                    linha = lerArq.readLine(); // lê da segunda até a última linha
                    i++;
                }
                // preenchendo até o nível máximo
                while (i < AlgoritmoPrincipalGerador.getEXP_LVL_MAX()) {
                    EXP_LVL[i] = EXP_LVL[i - 1];
                    i++;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Tabelas de Experiência não encontradas!", "No DataBase!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        try { try ( // lendo exp de nen
//                FileReader arq = new FileReader("src\\dataBase\\exp_nen.txt")) {
                FileReader arq = new FileReader("C:\\dataBase\\exp_nen.txt")) {
                BufferedReader lerArq = new BufferedReader(arq);

                // setando o valor 0 na posição 0 do vetor, que corresponde ao nivel 0
                EXP_NEN[0] = 0;
                int i = 1;
                String linha = lerArq.readLine(); // lê a primeira linha
                // a variável "linha" recebe o valor "null" quando o processo
                // de repetição atingir o final do arquivo texto
                while (linha != null) {
                    EXP_NEN[i] = Integer.parseInt(linha); // insere o valor no vetor
                    linha = lerArq.readLine(); // lê da segunda até a última linha
                    i++;
                }
                // preenchendo até o nen máximo
                while (i < AlgoritmoPrincipalGerador.getEXP_NEN_MAX()) {
                    EXP_NEN[i] = EXP_NEN[i - 1];
                    i++;
                }
            }
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
            return false;
        }
        
        try { try ( // lendo exp de lvl nen
//                FileReader arq = new FileReader("src\\dataBase\\lvl_nen.txt")) {
                FileReader arq = new FileReader("C:\\dataBase\\lvl_nen.txt")) {
                BufferedReader lerArq = new BufferedReader(arq);

                // setando o valor 0 na posição 0 do vetor, que corresponde ao nivel 0
                LVL_NEN[0] = 0;
                int i = 1;
                String linha = lerArq.readLine(); // lê a primeira linha
                // a variável "linha" recebe o valor "null" quando o processo
                // de repetição atingir o final do arquivo texto
                while (linha != null) {
                    LVL_NEN[i] = Integer.parseInt(linha); // insere o valor no vetor
                    linha = lerArq.readLine(); // lê da segunda até a última linha
                    i++;
                }
                // preenchendo até o lvl nen máximo
                while (i < AlgoritmoPrincipalGerador.getLVL_NEN_MAX()) {
                    LVL_NEN[i] = LVL_NEN[i - 1];
                    i++;
                }
            }
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
            return false;
        }
        return true;
    }
    
    public static void salvarTurno() {
        InfoTurno infoTurno = new InfoTurno();
        
        // salvando dados de personagens
        for (String nick : fichas.keySet()) {
            Ficha personagem = fichas.get(nick);
            InfoPerson infoPerson = new InfoPerson();

            // instanciando infoPerson
            infoPerson.setNick(nick);
            infoPerson.setMop(personagem.getMopAtual());
            infoPerson.setHp(personagem.getHpAtual());

            // setano infoPerson em infoTurno
            infoTurno.putInfoPerson(infoPerson);
        }
        
        AlgoritmoPrincipal.setInfoTurno(infoTurno);
        AlgoritmoPrincipal.getInfoTurnos().put(InfoTurno.getQtdTurnos() - 1, infoTurno);
    }
    
    public static void atualizaFicha(Ficha ficha) {
        int hp = ficha.getHpAtual();
        ficha.setHp();
        ficha.setHpAtual(hp);
        
        ficha.setEsq();
        ficha.setVel();
        ficha.setCrt();
        ficha.setIni();
        ficha.setApr();
    }
    
    // carregar hps
    // carregar mops
    
    public static InfoTurno getInfoTurno() {
        return infoTurno;
    }

    public static void setInfoTurno(InfoTurno infoPersons) {
        AlgoritmoPrincipal.infoTurno = infoPersons;
    }

    public static Map<String, Ficha> getFichas() {
        return fichas;
    }

    public static int getValor() {
        return valor;
    }

    public static void setValor(int valor) {
        AlgoritmoPrincipal.valor = valor;
    }

    public static String getLinha() {
        return linha;
    }
    
    public static void setLinha(String linha) {
        AlgoritmoPrincipal.linha = linha;
    }

    public static void putTpb(String personagem, TreinoPosBatalha treino) {
        tpb.put(personagem, treino);
    }
    
    public static TreinoPosBatalha popTpb(String personagem) {
        TreinoPosBatalha treino = AlgoritmoPrincipal.tpb.get(personagem);
        AlgoritmoPrincipal.tpb.remove(personagem);
        return treino;
    }
    
    public static TreinoPosBatalha getTpb(String personagem) {
        return tpb.get(personagem);
    }

    public static Map<String, TreinoPosBatalha> getTpb() {
        return tpb;
    }
    
    public static boolean containsTpb(String personagem) {
        for (String nomePer : AlgoritmoPrincipal.tpb.keySet()) {
            if (personagem.equals(nomePer)) {
                return true;
            }
        }
        return false;
    }
    
    public static void clearIniciativa() {
        iniciativa.clear();
    }
    
    public static void putIniciativa(int posicao, String nick, int teste) {
        Iniciativa ini = new Iniciativa();
        ini.setPosicao(posicao);
        ini.setTeste(teste);
        iniciativa.put(nick, ini);
    }
    
    public static void putIniciativa(String nick, Iniciativa ini) {
        iniciativa.put(nick, ini);
    }

    public static void removeIniciativa(String nick) {
        iniciativa.remove(nick);
    }
    
    public static Map<String, Iniciativa> getIniciativa() {
        return iniciativa;
    }

    public static void setIniciativa(Map<String, Iniciativa> iniciativa) {
        AlgoritmoPrincipal.iniciativa = iniciativa;
    }

    public static Ficha getFicha() {
        return ficha;
    }

    public static void setHabilidade(Habilidades habilidade) {
        AlgoritmoPrincipal.habilidade = habilidade;
    }
    
    public static void setHabilidade(String nomeHabilidade, Ficha personagem) {
        AlgoritmoPrincipal.habilidade = personagem.getHabilidade(nomeHabilidade);
    }

    public static void setFicha(Ficha personagem) {
        AlgoritmoPrincipal.ficha = personagem;
    }

    // os boqueadores são importantes pois um famigerado usuario pode
    // tentar calcular sem ter setado os personagens antes
    
    public static boolean isCalculadoraBloqueadaPorAtacante() {
        return calculadoraBloqueadaPorAtacante;
    }

    public static boolean isCalculadoraBloqueadaPorDefensor() {
        return calculadoraBloqueadaPorDefensor;
    }

    public static void setCalculadoraBloqueadaPorAtacante(boolean valor) {
        AlgoritmoPrincipal.calculadoraBloqueadaPorAtacante = valor;
    }

    public static void setCalculadoraBloqueadaPorDefensor(boolean valor) {
        AlgoritmoPrincipal.calculadoraBloqueadaPorDefensor = valor;
    }

    public static void setFichas(Map<String, Ficha> ficha) {
        AlgoritmoPrincipal.fichas = ficha;
    }
    
    public static void putFicha(Ficha ficha) {
        AlgoritmoPrincipal.fichas.put(ficha.getNick(), ficha);
    }

    public static Ficha getPerson(String nome) {
        return fichas.get(nome);
    }

    public static Habilidades getHabilidade() {
        return habilidade;
    }
    
    public static Ficha getAtacante() {
        return AlgoritmoPrincipal.atacante;
    }
    
    public static Ficha getDefensor() {
        return AlgoritmoPrincipal.defensor;
    }
    
    public static boolean containsPersonagem(String personagem) {
        //personagem = personagem.toUpperCase();
        for (String nome : AlgoritmoPrincipal.fichas.keySet()) {
            // se o nome entrado pelo usuario, armazenado em personagem
            // for igual ao nome de algum personagem, entao o nome
            // entrado é valido (return true)
            if (personagem.equals(fichas.get(nome).getNick())) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean setAtacante(String atacante) {
        // retorna true se atacante for um nome valido
        if (containsPersonagem(atacante)) {
            AlgoritmoPrincipal.atacante = AlgoritmoPrincipal.fichas.get(atacante);
            return true;
        }
        return false;
    }
    
    public static boolean setDefensor(String defensor) {
        // retorna true se defensor for um nome valido
        if (containsPersonagem(defensor)) {
            AlgoritmoPrincipal.defensor = AlgoritmoPrincipal.fichas.get(defensor);
            return true;
        }
        return false;
    }
    
    public static int getQtdPersonagens() {
        return AlgoritmoPrincipal.qtdPersonagens;
    }
}
