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
    
//    public static boolean loadFichas() {
//        String sql = "select * from ficha";
//        PreparedStatement pst;
//        ResultSet rs;
//        Connection execute = ModuloConexao.conector();
//        
//        if (execute == null) {
//            return false;
//        }
//        
//        try {
//            
//            pst = execute.prepareStatement(sql);
//            rs = pst.executeQuery();
//            
//            while (rs.next()) {
//                Ficha ficha = new Ficha();
//                Map<String, LvlExp> atr = ficha.getAtr();
//                
//                ficha.setNick(rs.getString(1));
//                ficha.setNome(rs.getString(2));
//                ficha.setClasse(rs.getString(3));
//                ficha.setNen(rs.getString(4));
//                ficha.setTendencia(rs.getString(5));
//                ficha.setHunter(rs.getString(6));
//                
//                ficha.setDias(Double.parseDouble(rs.getString(7)));
//                ficha.setAltura(Double.parseDouble(rs.getString(8)));
//                ficha.setPeso(Double.parseDouble(rs.getString(9)));
//                ficha.setIdade(Integer.parseInt(rs.getString(10)));
//                
//                ficha.setInventario(rs.getString(11));
//                ficha.setDescricao(rs.getString(12));
//                ficha.setDescricaoBreve(rs.getString(13));
//                
//                ficha.setIniFor(Integer.parseInt(rs.getString(14)));
//                ficha.setIniCon(Integer.parseInt(rs.getString(15)));
//                ficha.setIniDex(Integer.parseInt(rs.getString(16)));
//                ficha.setIniInt(Integer.parseInt(rs.getString(17)));
//                ficha.setIniCar(Integer.parseInt(rs.getString(18)));
//                ficha.setIniMen(Integer.parseInt(rs.getString(19)));
//                
//                ficha.setValFor(Integer.parseInt(rs.getString(20)));
//                ficha.setValCon(Integer.parseInt(rs.getString(21)));
//                ficha.setValDex(Integer.parseInt(rs.getString(22)));
//                ficha.setValInt(Integer.parseInt(rs.getString(23)));
//                ficha.setValCar(Integer.parseInt(rs.getString(24)));
//                ficha.setValMen(Integer.parseInt(rs.getString(25)));
//                
//                ficha.setModFor(Integer.parseInt(rs.getString(26)));
//                ficha.setModCon(Integer.parseInt(rs.getString(27)));
//                ficha.setModDex(Integer.parseInt(rs.getString(28)));
//                ficha.setModInt(Integer.parseInt(rs.getString(29)));
//                ficha.setModCar(Integer.parseInt(rs.getString(30)));
//                ficha.setModMen(Integer.parseInt(rs.getString(31)));
//                
//                ficha.setbFor(Integer.parseInt(rs.getString(32)));
//                ficha.setbCon(Integer.parseInt(rs.getString(33)));
//                ficha.setbDex(Integer.parseInt(rs.getString(34)));
//                ficha.setbInt(Integer.parseInt(rs.getString(35)));
//                ficha.setbCar(Integer.parseInt(rs.getString(36)));
//                ficha.setbMen(Integer.parseInt(rs.getString(37)));
//                
//                ficha.setPerFor(Integer.parseInt(rs.getString(38)));
//                ficha.setPerCon(Integer.parseInt(rs.getString(39)));
//                ficha.setPerDex(Integer.parseInt(rs.getString(40)));
//                ficha.setPerInt(Integer.parseInt(rs.getString(41)));
//                ficha.setPerCar(Integer.parseInt(rs.getString(42)));
//                ficha.setPerMen(Integer.parseInt(rs.getString(43)));
//                
//                atr.get("REF").setExp(Integer.parseInt(rs.getString(44)));
//                atr.get("EMS").setExp(Integer.parseInt(rs.getString(45)));
//                atr.get("MAT").setExp(Integer.parseInt(rs.getString(46)));
//                atr.get("MAN").setExp(Integer.parseInt(rs.getString(47)));
//                atr.get("TRS").setExp(Integer.parseInt(rs.getString(48)));
//                atr.get("ESP").setExp(Integer.parseInt(rs.getString(49)));
//                atr.get("CDN").setExp(Integer.parseInt(rs.getString(50)));
//                atr.get("TEN").setExp(Integer.parseInt(rs.getString(51)));
//                atr.get("RYU").setExp(Integer.parseInt(rs.getString(52)));
//                atr.get("AOP").setExp(Integer.parseInt(rs.getString(53)));
//                atr.get("MOP").setExp(Integer.parseInt(rs.getString(54)));
//                atr.get("ZTS").setExp(Integer.parseInt(rs.getString(55)));
//                atr.get("EN").setExp(Integer.parseInt(rs.getString(56)));
//                
//                atr.get("REF").setLvl(Integer.parseInt(rs.getString(57)));
//                atr.get("EMS").setLvl(Integer.parseInt(rs.getString(58)));
//                atr.get("MAT").setLvl(Integer.parseInt(rs.getString(59)));
//                atr.get("MAN").setLvl(Integer.parseInt(rs.getString(60)));
//                atr.get("TRS").setLvl(Integer.parseInt(rs.getString(61)));
//                atr.get("ESP").setLvl(Integer.parseInt(rs.getString(62)));
//                atr.get("CDN").setLvl(Integer.parseInt(rs.getString(63)));
//                atr.get("TEN").setLvl(Integer.parseInt(rs.getString(64)));
//                atr.get("RYU").setLvl(Integer.parseInt(rs.getString(65)));
//                atr.get("AOP").setLvl(Integer.parseInt(rs.getString(66)));
//                atr.get("MOP").setLvl(Integer.parseInt(rs.getString(67)));
//                atr.get("ZTS").setLvl(Integer.parseInt(rs.getString(68)));
//                atr.get("EN").setLvl(Integer.parseInt(rs.getString(69)));
//                
//                ficha.setModCdn(Integer.parseInt(rs.getString(70)));
//                ficha.setCoefHp(Integer.parseInt(rs.getString(71)));
//                ficha.setLvl(Integer.parseInt(rs.getString(72)));
//                ficha.setExp(Integer.parseInt(rs.getString(73)));
//                ficha.setExpBonus(Integer.parseInt(rs.getString(74)));
//                ficha.setLvlNen(Integer.parseInt(rs.getString(75)));
//                ficha.setExpNen(Integer.parseInt(rs.getString(76)));
//                ficha.setExpBonusNen(Integer.parseInt(rs.getString(77)));
//                
////              ficha.setHpMax(Integer.parseInt(rs.getString(78)))
//                ficha.setMopMax(Integer.parseInt(rs.getString(79)));
//                ficha.setHpNegMax(Integer.parseInt(rs.getString(80)));
//                
//                ficha.setHpAtual(Integer.parseInt(rs.getString(81)));
//                ficha.setMopAtual(Integer.parseInt(rs.getString(82)));
//                ficha.setHpNegAtual(Integer.parseInt(rs.getString(83)));
//                
//                ficha.setIni(Integer.parseInt(rs.getString(84)));
//                ficha.setEsq(Integer.parseInt(rs.getString(85)));
//                ficha.setApr(Integer.parseInt(rs.getString(86)));
//                ficha.setCrt(Integer.parseInt(rs.getString(87)));
//                ficha.setVel(Integer.parseInt(rs.getString(88)));
//                
//                ficha.setbIntCdn(Integer.parseInt(rs.getString(89)));
////              ficha.setSorte(Integer.parseInt(rs.getString(90)));
//                ficha.setSorteDiaria(Integer.parseInt(rs.getString(91)));
//                ficha.setModClas(Double.parseDouble(rs.getString(92)));
//                
//                ficha.setSortePorLvl(convertStB(rs.getString(93)));
//                ficha.setPersonagemDeJogador(convertStB(rs.getString(94)));
//                ficha.setCriaturaDoMestre(convertStB(rs.getString(95)));
//                
//                ficha.setPontosHeroicos(Integer.parseInt(rs.getString(96)));
//                ficha.setPontosInspiracao(Integer.parseInt(rs.getString(97)));
//                
//                ficha.setShu(Integer.parseInt(rs.getString(98)));
//                ficha.setStun(Integer.parseInt(rs.getString(99)));
//                
//                ficha.setDesmaiado(convertStB(rs.getString(100)));
//                
//                ficha.setAtkPad(rs.getString(101));
//                ficha.setDefPad(rs.getString(102));
//                
//                
//                ficha.setHp();
//                ficha.resetSortes();
//                
//                
//                // habilidades
//                sql = "select * from habilidades where nick = ?";
//                PreparedStatement pst2 = execute.prepareStatement(sql);
//                pst2.setString(1, ficha.getNick());
//                ResultSet rs2 = pst2.executeQuery();
//                
//                ficha.getHabilidades().clear();
//                
//                while (rs2.next()) {
//                    Habilidades habilidade = new Habilidades();
//                    
//                    habilidade.setNome(rs2.getString(2));
//                    habilidade.setArma(rs2.getString(3));
//                    habilidade.setDados(rs2.getString(4));
//                    habilidade.setProficiencia(rs2.getString(5));
//                    
//                    habilidade.setDescricao(rs2.getString(6));
//                    habilidade.setDescricaoBreve(rs2.getString(7));
//                    
//                    habilidade.setRestricao(Double.parseDouble(rs2.getString(8)));
//                    
//                    habilidade.setDano(Integer.parseInt(rs2.getString(9)));
//                    habilidade.setDanoPorSegundo(Integer.parseInt(rs2.getString(10)));
//                    habilidade.setAuraBonus(Integer.parseInt(rs2.getString(11)));
//                    habilidade.setTurnoDps(Integer.parseInt(rs2.getString(12)));
//                    habilidade.setDecrescimoDpsPorTurno(Integer.parseInt(rs2.getString(13)));
//                    habilidade.setQtd(Integer.parseInt(rs2.getString(14)));
//                    habilidade.setVol(Integer.parseInt(rs2.getString(15)));
//                    habilidade.setCrt(Integer.parseInt(rs2.getString(16)));
//                    habilidade.setDanoFixo(Integer.parseInt(rs2.getString(17)));
//                    habilidade.setAcertoFixo(Integer.parseInt(rs2.getString(18)));
//                    habilidade.setLvl(Integer.parseInt(rs2.getString(19)));
//                    habilidade.setSubLvl(Integer.parseInt(rs2.getString(20)));
//                    habilidade.setBonus(Integer.parseInt(rs2.getString(21)));
//                    
//                    habilidade.setQtdFor(Integer.parseInt(rs2.getString(22)));
//                    habilidade.setQtdCon(Integer.parseInt(rs2.getString(23)));
//                    habilidade.setQtdDex(Integer.parseInt(rs2.getString(24)));
//                    habilidade.setQtdInt(Integer.parseInt(rs2.getString(25)));
//                    habilidade.setQtdCar(Integer.parseInt(rs2.getString(26)));
//                    habilidade.setQtdMen(Integer.parseInt(rs2.getString(27)));
//                    habilidade.setQtdRef(Integer.parseInt(rs2.getString(28)));
//                    habilidade.setQtdEms(Integer.parseInt(rs2.getString(29)));
//                    habilidade.setQtdMan(Integer.parseInt(rs2.getString(30)));
//                    habilidade.setQtdMat(Integer.parseInt(rs2.getString(31)));
//                    habilidade.setQtdTrs(Integer.parseInt(rs2.getString(32)));
//                    habilidade.setQtdEsp(Integer.parseInt(rs2.getString(33)));
//                    habilidade.setQtdEsq(Integer.parseInt(rs2.getString(34)));
//                    habilidade.setQtdVel(Integer.parseInt(rs2.getString(35)));
//                    habilidade.setQtdTen(Integer.parseInt(rs2.getString(36)));
//                    habilidade.setQtdAop(Integer.parseInt(rs2.getString(37)));
//                    habilidade.setQtdMop(Integer.parseInt(rs2.getString(38)));
//                    habilidade.setQtdCdn(Integer.parseInt(rs2.getString(39)));
//                    
//                    habilidade.setPerfurante(convertStB(rs2.getString(40)));
//                    habilidade.setGastaAura(convertStB(rs2.getString(41)));
//                    habilidade.setTrs(convertStB(rs2.getString(42)));
//                    habilidade.setMat(convertStB(rs2.getString(43)));
//                    habilidade.setMan(convertStB(rs2.getString(44)));
//                    habilidade.setDps(convertStB(rs2.getString(45)));
//                    habilidade.setRebote(convertStB(rs2.getString(46)));
//                    
//                    habilidade.setSomarFor(convertStB(rs2.getString(47)));
//                    habilidade.setSomarCon(convertStB(rs2.getString(48)));
//                    habilidade.setSomarDex(convertStB(rs2.getString(49)));
//                    habilidade.setSomarInt(convertStB(rs2.getString(50)));
//                    habilidade.setSomarCar(convertStB(rs2.getString(51)));
//                    habilidade.setSomarMen(convertStB(rs2.getString(52)));
//                    habilidade.setSomarRef(convertStB(rs2.getString(53)));
//                    habilidade.setSomarEms(convertStB(rs2.getString(54)));
//                    habilidade.setSomarMan(convertStB(rs2.getString(55)));
//                    habilidade.setSomarMat(convertStB(rs2.getString(56)));
//                    habilidade.setSomarTrs(convertStB(rs2.getString(57)));
//                    habilidade.setSomarEsp(convertStB(rs2.getString(58)));
//                    habilidade.setSomarEsq(convertStB(rs2.getString(59)));
//                    habilidade.setSomarVel(convertStB(rs2.getString(60)));
//                    habilidade.setSomarTen(convertStB(rs2.getString(61)));
//                    habilidade.setSomarAop(convertStB(rs2.getString(62)));
//                    habilidade.setSomarMop(convertStB(rs2.getString(63)));
//                    habilidade.setSomarCdn(convertStB(rs2.getString(64)));
//                    
//                    try {
//                        habilidade.setRyu(Integer.parseInt(rs2.getString(65)));
//                        habilidade.setDanoRebote(convertStB(rs2.getString(66)));
//                        habilidade.setGastaRyu(convertStB(rs2.getString(67)));
//                    } catch (NumberFormatException e) {
//                        
//                    }
//                    
//                    
//                    // inserindo habilidade
//                    ficha.putHabilidade(habilidade.getNome(), habilidade);
//                }
//                
//                
//                // pro
//                sql = "select * from pro where nick = ?";
//                PreparedStatement pst3 = execute.prepareStatement(sql);
//                pst3.setString(1, ficha.getNick());
//                ResultSet rs3 = pst3.executeQuery();
//                
//                ficha.getPro().clear();
//                
//                while (rs3.next()) {
//                    LvlBonus lvlBonus = new LvlBonus();
//                    
//                    lvlBonus.setLvl(Integer.parseInt(rs3.getString(3)));
//                    lvlBonus.setLvj(Integer.parseInt(rs3.getString(4)));
//                    lvlBonus.setBonus(Integer.parseInt(rs3.getString(5)));
//                    
//                    ficha.getPro().put(rs3.getString(2), lvlBonus);
//                }
//                
//                
//                // per
//                sql = "select * from per where nick = ?";
//                PreparedStatement pst4 = execute.prepareStatement(sql);
//                pst4.setString(1, ficha.getNick());
//                ResultSet rs4 = pst4.executeQuery();
//                
//                ficha.getPer().clear();
//                
//                while (rs4.next()) {
//                    LvlBonus lvlBonus = new LvlBonus();
//                    
//                    lvlBonus.setLvl(Integer.parseInt(rs4.getString(3)));
//                    lvlBonus.setLvj(Integer.parseInt(rs4.getString(4)));
//                    lvlBonus.setBonus(Integer.parseInt(rs4.getString(5)));
//                    
//                    ficha.getPer().put(rs4.getString(2), lvlBonus);
//                }
//                
//                fichas.put(ficha.getNick(), ficha);
//                
//            }
//            
//            execute.close();
//            return true;
//            
//        } catch (SQLException e) {
//            System.out.println(e);
//            return false;
//        }
//    }
    
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
    
    public static boolean loadFichas(File folder) throws ClassNotFoundException {
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folder + "\\" + file.getName()))) {
                    Ficha ficha = (Ficha) ois.readObject();
                    fichas.put(ficha.getNick(), ficha);
                } catch (IOException e) {
                    System.out.println(e.toString());
                    JOptionPane.showMessageDialog(null, "Algo errado!", "No DataBase!",
                            JOptionPane.WARNING_MESSAGE);
                    System.out.println(folder + "\\" + file.getName());
                    return false;
                }
            } else {
                loadFichas(file);
            }
        }
        return true;
    }
    
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
    
//    public static boolean saveFichas() {
//        
//        PreparedStatement pst;
//        ResultSet rs;
//        String sql;
//        Connection execute = ModuloConexao.conector();
//        
//        // limpando banco para nova inserção de fichas
////        try {
////            sql = "truncate table pro";
////            pst = execute.prepareStatement(sql);
////            pst.execute();
////            
////            sql = "truncate table per";
////            pst = execute.prepareStatement(sql);
////            pst.execute();
////            
////            sql = "truncate table habilidades";
////            pst = execute.prepareStatement(sql);
////            pst.execute();
//            
////            sql = "alter table per drop foreign key per_ibfk_1";
////            pst = execute.prepareStatement(sql);
////            pst.execute();
////            
////            sql = "alter table pro drop foreign key pro_ibfk_1";
////            pst = execute.prepareStatement(sql);
////            pst.execute();
////            
////            sql = "alter table habilidades drop foreign key habilidades_ibfk_1";
////            pst = execute.prepareStatement(sql);
////            pst.execute();
//            
////            sql = "truncate table ficha";
////            pst = execute.prepareStatement(sql);
////            pst.execute();
//            
////        } catch (SQLException e) {
////            System.out.println("NÃO FOI POSSIVEL LIMPAR O BANCO");
////            System.out.println(e);
////        }
//        
//        
//        for (String nick : fichas.keySet()) {
//            Ficha ficha = fichas.get(nick);
//            boolean existeFicha = false;
//
//            // analizando existencia de ficha
////            try {
////                sql = "select nick from ficha";
////                pst = execute.prepareStatement(sql);
////                rs = pst.executeQuery();
////                // procurando a ficha no banco
////                while (rs.next()) {
////                    if (rs.getString(1).equals(nick)) {
////                        existeFicha = true;
////                        break;
////                    }
////                }
////            } catch (SQLException e) {
////                System.out.println("campo vazio - ficha");
////            }
////            
////            // se existe a ficha, então deletemos ela para reinserir
////            if (existeFicha) {
////                // para deletar a ficha, devemos deletar habilidades
////                // depois pericias e depois proficiencias
////                // para, então, deletarmos ficha. então...
////
////                try {
////                    sql = "delete from habilidades where nick = " + nick;
////                    pst = execute.prepareStatement(sql);
////                    pst.execute();
////                } catch (SQLException e) {
////                    System.out.println("habilidade nao deletada - ficha");
////                    System.out.println(e);
////                }
////
////                try {
////                    sql = "delete from per where nick = " + nick;
////                    pst = execute.prepareStatement(sql);
////                    pst.execute();
////                } catch (Exception e) {
////                    System.out.println("per nao deletada - ficha");
////                    System.out.println(e);
////                }
////
////                try {
////                    sql = "delete from pro where nick = " + nick;
////                    pst = execute.prepareStatement(sql);
////                    pst.execute();
////                } catch (Exception e) {
////                    System.out.println("pro nao deletada - ficha");
////                    System.out.println(e);
////                }
////
////                try {
////                    sql = "delete from ficha where nick = " + nick;
////                    pst = execute.prepareStatement(sql);
////                    pst.execute();
////                } catch (Exception e) {
////                    System.out.println("ficha nao deletada - ficha");
////                    System.out.println(e);
////                }
////            }
//
//            // inserindo ficha
//            try {
//                sql = "insert into ficha values(" +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?)";
//
//                pst = execute.prepareStatement(sql);
//
//                pst.setString(1, nick);
//                pst.setString(2, ficha.getNome());
//                pst.setString(3, ficha.getClasse());
//                pst.setString(4, ficha.getNen());
//                pst.setString(5, ficha.getTendencia());
//                pst.setString(6, ficha.getHunter());
//
//                pst.setString(7, String.valueOf(ficha.getDias()));
//                pst.setString(8, String.valueOf(ficha.getAltura()));
//                pst.setString(9, String.valueOf(ficha.getPeso()));
//                pst.setString(10, String.valueOf(ficha.getIdade()));
//
//                pst.setString(11, ficha.getInventario());
//                pst.setString(12, ficha.getDescricao());
//                pst.setString(13, ficha.getDescricaoBreve());
//
//                pst.setString(14, String.valueOf(ficha.getIniFor()));
//                pst.setString(15, String.valueOf(ficha.getIniCon()));
//                pst.setString(16, String.valueOf(ficha.getIniDex()));
//                pst.setString(17, String.valueOf(ficha.getIniInt()));
//                pst.setString(18, String.valueOf(ficha.getIniCar()));
//                pst.setString(19, String.valueOf(ficha.getIniMen()));
//
//                pst.setString(20, String.valueOf(ficha.getValFor()));
//                pst.setString(21, String.valueOf(ficha.getValCon()));
//                pst.setString(22, String.valueOf(ficha.getValDex()));
//                pst.setString(23, String.valueOf(ficha.getValInt()));
//                pst.setString(24, String.valueOf(ficha.getValCar()));
//                pst.setString(25, String.valueOf(ficha.getValMen()));
//
//                pst.setString(26, String.valueOf(ficha.getModFor()));
//                pst.setString(27, String.valueOf(ficha.getModCon()));
//                pst.setString(28, String.valueOf(ficha.getModDex()));
//                pst.setString(29, String.valueOf(ficha.getModInt()));
//                pst.setString(30, String.valueOf(ficha.getModCar()));
//                pst.setString(31, String.valueOf(ficha.getModMen()));
//
//                pst.setString(32, String.valueOf(ficha.getbFor()));
//                pst.setString(33, String.valueOf(ficha.getbCon()));
//                pst.setString(34, String.valueOf(ficha.getbDex()));
//                pst.setString(35, String.valueOf(ficha.getbInt()));
//                pst.setString(36, String.valueOf(ficha.getbCar()));
//                pst.setString(37, String.valueOf(ficha.getbMen()));
//
//                pst.setString(38, String.valueOf(ficha.getPerFor()));
//                pst.setString(39, String.valueOf(ficha.getPerCon()));
//                pst.setString(40, String.valueOf(ficha.getPerDex()));
//                pst.setString(41, String.valueOf(ficha.getPerInt()));
//                pst.setString(42, String.valueOf(ficha.getPerCar()));
//                pst.setString(43, String.valueOf(ficha.getPerMen()));
//
//                pst.setString(44, String.valueOf(ficha.getAtr("REF").getExp()));
//                pst.setString(45, String.valueOf(ficha.getAtr("EMS").getExp()));
//                pst.setString(46, String.valueOf(ficha.getAtr("MAT").getExp()));
//                pst.setString(47, String.valueOf(ficha.getAtr("MAN").getExp()));
//                pst.setString(48, String.valueOf(ficha.getAtr("TRS").getExp()));
//                pst.setString(49, String.valueOf(ficha.getAtr("ESP").getExp()));
//                pst.setString(50, String.valueOf(ficha.getAtr("CDN").getExp()));
//                pst.setString(51, String.valueOf(ficha.getAtr("TEN").getExp()));
//                pst.setString(52, String.valueOf(ficha.getAtr("RYU").getExp()));
//                pst.setString(53, String.valueOf(ficha.getAtr("AOP").getExp()));
//                pst.setString(54, String.valueOf(ficha.getAtr("MOP").getExp()));
//                pst.setString(55, String.valueOf(ficha.getAtr("ZTS").getExp()));
//                pst.setString(56, String.valueOf(ficha.getAtr("EN").getExp()));
//
//                pst.setString(57, String.valueOf(ficha.getAtrRef()));
//                pst.setString(58, String.valueOf(ficha.getAtrEms()));
//                pst.setString(59, String.valueOf(ficha.getAtrMat()));
//                pst.setString(60, String.valueOf(ficha.getAtrMan()));
//                pst.setString(61, String.valueOf(ficha.getAtrTrs()));
//                pst.setString(62, String.valueOf(ficha.getAtrEsp()));
//                pst.setString(63, String.valueOf(ficha.getAtrCdn()));
//                pst.setString(64, String.valueOf(ficha.getTen()));
//                pst.setString(65, String.valueOf(ficha.getRyu()));
//                pst.setString(66, String.valueOf(ficha.getAop()));
//                pst.setString(67, String.valueOf(ficha.getMop()));
//                pst.setString(68, String.valueOf(ficha.getZts()));
//                pst.setString(69, String.valueOf(ficha.getEn()));
//
//                pst.setString(70, String.valueOf(ficha.getModCdn()));
//                pst.setString(71, String.valueOf(ficha.getCoefHp()));
//                pst.setString(72, String.valueOf(ficha.getLvl()));
//                pst.setString(73, String.valueOf(ficha.getExp()));
//                pst.setString(74, String.valueOf(ficha.getExpBonus()));
//                pst.setString(75, String.valueOf(ficha.getLvlNen()));
//                pst.setString(76, String.valueOf(ficha.getExpNen()));
//                pst.setString(77, String.valueOf(ficha.getExpBonusNen()));
//
//                pst.setString(78, String.valueOf(ficha.getHpMax()));
//                pst.setString(79, String.valueOf(ficha.getMopMax()));
//                pst.setString(80, String.valueOf(ficha.getHpNegMax()));
//
//                pst.setString(81, String.valueOf(ficha.getHpAtual()));
//                pst.setString(82, String.valueOf(ficha.getMopAtual()));
//                pst.setString(83, String.valueOf(ficha.getHpNegAtual()));
//
//                pst.setString(84, String.valueOf(ficha.getIni()));
//                pst.setString(85, String.valueOf(ficha.getEsq()));
//                pst.setString(86, String.valueOf(ficha.getApr()));
//                pst.setString(87, String.valueOf(ficha.getCrt()));
//                pst.setString(88, String.valueOf(ficha.getVel()));
//
//                pst.setString(89, String.valueOf(ficha.getbIntCdn()));
//                pst.setString(90, String.valueOf(ficha.getSorte()));
//                pst.setString(91, String.valueOf(ficha.getSorteDiaria()));
//                pst.setString(92, String.valueOf(ficha.getModClas()));
//
//                pst.setString(93, convertBtS(ficha.isSortePorLvl()));
//                pst.setString(94, convertBtS(ficha.isPersonagemDeJogador()));
//                pst.setString(95, convertBtS(ficha.isCriaturaDoMestre()));
//
//                pst.setString(96, String.valueOf(ficha.getPontosHeroicos()));
//                pst.setString(97, String.valueOf(ficha.getPontosInspiracao()));
//                pst.setString(98, String.valueOf(ficha.getShu()));
//                pst.setString(99, String.valueOf(ficha.getStun()));
//
//                pst.setString(100, convertBtS(ficha.isDesmaiado()));
//                
//                pst.setString(101, ficha.getAtkPad());
//                pst.setString(102, ficha.getDefPad());
//
//                pst.execute();
//
//            } catch (SQLException e) {
//                System.out.println("falha no insert - ficha");
//            }
//
//
//            // habilidades
//            for (String nomeHabilidade : ficha.getHabilidades().keySet()) {
//                Habilidades skill = ficha.getHabilidade(nomeHabilidade);
//                boolean existeSkill = false;
//
//                // analizando existencia de habilidade
////                try {
////                    sql = "select nomeHabilidade from habilidades where nick = " + nick;
////                    pst = execute.prepareStatement(sql);
////                    rs = pst.executeQuery();
////                    // procurando a habilidade no banco
////                    while (rs.next()) {
////                        if (rs.getString(2).equals(nomeHabilidade)) {
////                            existeSkill = true;
////                            break;
////                        }
////                    }
////                } catch (SQLException e) {
////                    System.out.println("campo vazio - habilidades");
////                }
////                
////                // se existe a habilidade, então deletemos ela para reinserir
////                try {
////                    if (existeSkill) {
////                        sql = "delete from habilidades where nick = " + nick;
////                        pst = execute.prepareStatement(sql);
////                        pst.execute();
////                    }
////                } catch (SQLException e) {
////                    System.out.println("nada foi deletado - habilidades");
////                }
//
//                // inserindo habilidades
//                try {
//
//                    sql = "insert into habilidades values(" +
//                        "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                        "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                        "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                        "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                        "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                        "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                        "?, ?, ?, ?, ?, ?, ?)";
//
//                    pst = execute.prepareStatement(sql);
//
//                    pst.setString(1, ficha.getNick());
//
//                    pst.setString(2, skill.getNome());
//                    pst.setString(3, skill.getArma());
//                    pst.setString(4, skill.getDados());
//                    pst.setString(5, skill.getProficiencia());
//                    pst.setString(6, skill.getDescricao());
//                    pst.setString(7, skill.getDescricaoBreve());
//
//                    pst.setString(8, String.valueOf(skill.getRestricao()));
//                    pst.setString(9, String.valueOf(skill.getDano()));
//                    pst.setString(10, String.valueOf(skill.getDanoPorSegundo()));
//                    pst.setString(11, String.valueOf(skill.getAuraBonus()));
//                    pst.setString(12, String.valueOf(skill.getTurnoDps()));
//                    pst.setString(13, String.valueOf(skill.getDecrescimoDpsPorTurno()));
//                    pst.setString(14, String.valueOf(skill.getQtd()));
//                    pst.setString(15, String.valueOf(skill.getVol()));
//                    pst.setString(16, String.valueOf(skill.getCrt()));
//                    pst.setString(17, String.valueOf(skill.getDanoFixo()));
//                    pst.setString(18, String.valueOf(skill.getAcertoFixo()));
//                    pst.setString(19, String.valueOf(skill.getLvl()));
//                    pst.setString(20, String.valueOf(skill.getSubLvl()));
//                    pst.setString(21, String.valueOf(skill.getBonus()));
//
//                    pst.setString(22, String.valueOf(skill.getQtdFor()));
//                    pst.setString(23, String.valueOf(skill.getQtdCon()));
//                    pst.setString(24, String.valueOf(skill.getQtdDex()));
//                    pst.setString(25, String.valueOf(skill.getQtdInt()));
//                    pst.setString(26, String.valueOf(skill.getQtdCar()));
//                    pst.setString(27, String.valueOf(skill.getQtdMen()));
//                    pst.setString(28, String.valueOf(skill.getQtdRef()));
//                    pst.setString(29, String.valueOf(skill.getQtdEms()));
//                    pst.setString(30, String.valueOf(skill.getQtdMan()));
//                    pst.setString(31, String.valueOf(skill.getQtdMat()));
//                    pst.setString(32, String.valueOf(skill.getQtdTrs()));
//                    pst.setString(33, String.valueOf(skill.getQtdEsp()));
//                    pst.setString(34, String.valueOf(skill.getQtdEsq()));
//                    pst.setString(35, String.valueOf(skill.getQtdVel()));
//                    pst.setString(36, String.valueOf(skill.getQtdTen()));
//                    pst.setString(37, String.valueOf(skill.getQtdAop()));
//                    pst.setString(38, String.valueOf(skill.getQtdMop()));
//                    pst.setString(39, String.valueOf(skill.getQtdCdn()));
//
//                    pst.setString(40, convertBtS(skill.isPerfurante()));
//                    pst.setString(41, convertBtS(skill.isGastaAura()));
//                    pst.setString(42, convertBtS(skill.isTrs()));
//                    pst.setString(43, convertBtS(skill.isMat()));
//                    pst.setString(44, convertBtS(skill.isMan()));
//                    pst.setString(45, convertBtS(skill.isDps()));
//                    pst.setString(46, convertBtS(skill.isRebote()));
//
//                    pst.setString(47, convertBtS(skill.isSomarFor()));
//                    pst.setString(48, convertBtS(skill.isSomarCon()));
//                    pst.setString(49, convertBtS(skill.isSomarDex()));
//                    pst.setString(50, convertBtS(skill.isSomarInt()));
//                    pst.setString(51, convertBtS(skill.isSomarCar()));
//                    pst.setString(52, convertBtS(skill.isSomarMen()));
//                    pst.setString(53, convertBtS(skill.isSomarRef()));
//                    pst.setString(54, convertBtS(skill.isSomarEms()));
//                    pst.setString(55, convertBtS(skill.isSomarMan()));
//                    pst.setString(56, convertBtS(skill.isSomarMat()));
//                    pst.setString(57, convertBtS(skill.isSomarTrs()));
//                    pst.setString(58, convertBtS(skill.isSomarEsp()));
//                    pst.setString(59, convertBtS(skill.isSomarEsq()));
//                    pst.setString(60, convertBtS(skill.isSomarVel()));
//                    pst.setString(61, convertBtS(skill.isSomarTen()));
//                    pst.setString(62, convertBtS(skill.isSomarAop()));
//                    pst.setString(63, convertBtS(skill.isSomarMop()));
//                    pst.setString(64, convertBtS(skill.isSomarCdn()));
//                    
//                    pst.setString(65, String.valueOf(skill.getRyu()));
//                    pst.setString(66, convertBtS(skill.isDanoRebote()));
//                    pst.setString(67, convertBtS(skill.isGastaRyu()));
//                    
//                    pst.execute();
//
//                } catch (SQLException e) {
//                    System.out.println("falha no insert - habilidades");
//                }
//
//            }
//
//            // proficiencias
//            for (String nomePro : ficha.getPro().keySet()) {
//                LvlBonus pro = ficha.getPro().get(nomePro);
//                boolean existePro = false;
//
//                // analizando existencia de proficiencias
////                try {
////                    sql = "select nomePro from pro where nick = " + nick;
////                    pst = execute.prepareStatement(sql);
////                    rs = pst.executeQuery();
////                    // procurando a pericia no banco
////                    while (rs.next()) {
////                        if (rs.getString(2).equals(nomePro)) {
////                            existePro = true;
////                            break;
////                        }
////                    }
////                } catch (SQLException e) {
////                    System.out.println("campo vazio - pro");
////                }
////                
////                // se existe a proficiencia, então deletemos ela para reinserir
////                try {
////                    if (existePro) {
////                        sql = "delete from pro where nick = " + nick;
////                        pst = execute.prepareStatement(sql);
////                        pst.execute();
////                    }
////                } catch (SQLException e) {
////                    System.out.println("nada foi deletado - pro");
////                }
//
//                // inserindo proficiencias
//                try {
//                    sql = "insert into pro values(?, ?, ?, ?, ?)";
//                    pst = execute.prepareStatement(sql);
//                    pst.setString(1, ficha.getNick());
//                    pst.setString(2, nomePro);
//                    pst.setString(3, String.valueOf(pro.getLvl()));
//                    pst.setString(4, String.valueOf(pro.getLvj()));
//                    pst.setString(5, String.valueOf(pro.getBonus()));
//                    
//                    pst.execute();
//
//                } catch (SQLException e) {
//                    System.out.println("nada foi inserido - pro");
//                }
//            }
//
//            // pericias
//            for (String nomePer : ficha.getPer().keySet()) {
//                LvlBonus per = ficha.getPer().get(nomePer);
//                boolean existePer = false;
//
//                // analizando existencia de pericias
////                try {
////                    sql = "select nomePer from per where nick = " + nick;
////                    pst = execute.prepareStatement(sql);
////                    rs = pst.executeQuery();
////                    // procurando a pericia no banco
////                    while (rs.next()) {
////                        if (rs.getString(2).equals(nomePer)) {
////                            existePer = true;
////                            break;
////                        }
////                    }
////                } catch (SQLException e) {
////                    System.out.println("campo vazio - per");
////                }
////                
////                // se existe a pericia, então deletemos ela para reinserir
////                try {
////                    if (existePer) {
////                        sql = "delete from per where nick = " + nick;
////                        pst = execute.prepareStatement(sql);
////                        pst.execute();
////                    }
////                } catch (SQLException e) {
////                    System.out.println("nada foi deletado - per");
////                }
//
//                // inserindo a pericia
//                try {
//                    sql = "insert into per values(?, ?, ?, ?, ?)";
//                    pst = execute.prepareStatement(sql);
//                    pst.setString(1, ficha.getNick());
//                    pst.setString(2, nomePer);
//                    pst.setString(3, String.valueOf(per.getLvl()));
//                    pst.setString(4, String.valueOf(per.getLvj()));
//                    pst.setString(5, String.valueOf(per.getBonus()));
//                    
//                    pst.execute();
//
//                } catch (SQLException e) {
//                    System.out.println("nada foi inserido - per");
//                }
//            }
//        }
//
//        try {
//            execute.close();
//        } catch (SQLException e) {
//            System.out.println("erro ao fechar");
//            System.out.println(e);
//        }
//
//        return true;
//    }
    
//    public static boolean saveFicha(Ficha ficha) {
//        
//        PreparedStatement pst;
//        ResultSet rs;
//        String sql;
//        Connection execute = ModuloConexao.conector();
//        
//        // deletando a ficha atual do banco para nova inserção
//        try {
//            sql = "delete from pro where nick = ?";
//            pst = execute.prepareStatement(sql);
//            pst.setString(1, ficha.getNick());
//            pst.execute();
//            
//            sql = "delete from per where nick = ?";
//            pst = execute.prepareStatement(sql);
//            pst.setString(1, ficha.getNick());
//            pst.execute();
//            
//            sql = "delete from habilidades where nick = ?";
//            pst = execute.prepareStatement(sql);
//            pst.setString(1, ficha.getNick());
//            pst.execute();
//            
//            sql = "delete from ficha where nick = ?";
//            pst = execute.prepareStatement(sql);
//            pst.setString(1, ficha.getNick());
//            pst.execute();
//        } catch (SQLException e) {
//            System.err.println("NÃO FOI POSSIVEL LIMPAR O BANCO");
//            System.err.println(e);
//        }
//        
//
//        // inserindo ficha
//        try {
//            sql = "insert into ficha values(" +
//                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                "?, ?)";
//
//            pst = execute.prepareStatement(sql);
//
//            pst.setString(1, ficha.getNick());
//            pst.setString(2, ficha.getNome());
//            pst.setString(3, ficha.getClasse());
//            pst.setString(4, ficha.getNen());
//            pst.setString(5, ficha.getTendencia());
//            pst.setString(6, ficha.getHunter());
//
//            pst.setString(7, String.valueOf(ficha.getDias()));
//            pst.setString(8, String.valueOf(ficha.getAltura()));
//            pst.setString(9, String.valueOf(ficha.getPeso()));
//            pst.setString(10, String.valueOf(ficha.getIdade()));
//
//            pst.setString(11, ficha.getInventario());
//            pst.setString(12, ficha.getDescricao());
//            pst.setString(13, ficha.getDescricaoBreve());
//
//            pst.setString(14, String.valueOf(ficha.getIniFor()));
//            pst.setString(15, String.valueOf(ficha.getIniCon()));
//            pst.setString(16, String.valueOf(ficha.getIniDex()));
//            pst.setString(17, String.valueOf(ficha.getIniInt()));
//            pst.setString(18, String.valueOf(ficha.getIniCar()));
//            pst.setString(19, String.valueOf(ficha.getIniMen()));
//
//            pst.setString(20, String.valueOf(ficha.getValFor()));
//            pst.setString(21, String.valueOf(ficha.getValCon()));
//            pst.setString(22, String.valueOf(ficha.getValDex()));
//            pst.setString(23, String.valueOf(ficha.getValInt()));
//            pst.setString(24, String.valueOf(ficha.getValCar()));
//            pst.setString(25, String.valueOf(ficha.getValMen()));
//
//            pst.setString(26, String.valueOf(ficha.getModFor()));
//            pst.setString(27, String.valueOf(ficha.getModCon()));
//            pst.setString(28, String.valueOf(ficha.getModDex()));
//            pst.setString(29, String.valueOf(ficha.getModInt()));
//            pst.setString(30, String.valueOf(ficha.getModCar()));
//            pst.setString(31, String.valueOf(ficha.getModMen()));
//
//            pst.setString(32, String.valueOf(ficha.getbFor()));
//            pst.setString(33, String.valueOf(ficha.getbCon()));
//            pst.setString(34, String.valueOf(ficha.getbDex()));
//            pst.setString(35, String.valueOf(ficha.getbInt()));
//            pst.setString(36, String.valueOf(ficha.getbCar()));
//            pst.setString(37, String.valueOf(ficha.getbMen()));
//
//            pst.setString(38, String.valueOf(ficha.getPerFor()));
//            pst.setString(39, String.valueOf(ficha.getPerCon()));
//            pst.setString(40, String.valueOf(ficha.getPerDex()));
//            pst.setString(41, String.valueOf(ficha.getPerInt()));
//            pst.setString(42, String.valueOf(ficha.getPerCar()));
//            pst.setString(43, String.valueOf(ficha.getPerMen()));
//
//            pst.setString(44, String.valueOf(ficha.getAtr("REF").getExp()));
//            pst.setString(45, String.valueOf(ficha.getAtr("EMS").getExp()));
//            pst.setString(46, String.valueOf(ficha.getAtr("MAT").getExp()));
//            pst.setString(47, String.valueOf(ficha.getAtr("MAN").getExp()));
//            pst.setString(48, String.valueOf(ficha.getAtr("TRS").getExp()));
//            pst.setString(49, String.valueOf(ficha.getAtr("ESP").getExp()));
//            pst.setString(50, String.valueOf(ficha.getAtr("CDN").getExp()));
//            pst.setString(51, String.valueOf(ficha.getAtr("TEN").getExp()));
//            pst.setString(52, String.valueOf(ficha.getAtr("RYU").getExp()));
//            pst.setString(53, String.valueOf(ficha.getAtr("AOP").getExp()));
//            pst.setString(54, String.valueOf(ficha.getAtr("MOP").getExp()));
//            pst.setString(55, String.valueOf(ficha.getAtr("ZTS").getExp()));
//            pst.setString(56, String.valueOf(ficha.getAtr("EN").getExp()));
//
//            pst.setString(57, String.valueOf(ficha.getAtrRef()));
//            pst.setString(58, String.valueOf(ficha.getAtrEms()));
//            pst.setString(59, String.valueOf(ficha.getAtrMat()));
//            pst.setString(60, String.valueOf(ficha.getAtrMan()));
//            pst.setString(61, String.valueOf(ficha.getAtrTrs()));
//            pst.setString(62, String.valueOf(ficha.getAtrEsp()));
//            pst.setString(63, String.valueOf(ficha.getAtrCdn()));
//            pst.setString(64, String.valueOf(ficha.getTen()));
//            pst.setString(65, String.valueOf(ficha.getRyu()));
//            pst.setString(66, String.valueOf(ficha.getAop()));
//            pst.setString(67, String.valueOf(ficha.getMop()));
//            pst.setString(68, String.valueOf(ficha.getZts()));
//            pst.setString(69, String.valueOf(ficha.getEn()));
//
//            pst.setString(70, String.valueOf(ficha.getModCdn()));
//            pst.setString(71, String.valueOf(ficha.getCoefHp()));
//            pst.setString(72, String.valueOf(ficha.getLvl()));
//            pst.setString(73, String.valueOf(ficha.getExp()));
//            pst.setString(74, String.valueOf(ficha.getExpBonus()));
//            pst.setString(75, String.valueOf(ficha.getLvlNen()));
//            pst.setString(76, String.valueOf(ficha.getExpNen()));
//            pst.setString(77, String.valueOf(ficha.getExpBonusNen()));
//
//            pst.setString(78, String.valueOf(ficha.getHpMax()));
//            pst.setString(79, String.valueOf(ficha.getMopMax()));
//            pst.setString(80, String.valueOf(ficha.getHpNegMax()));
//
//            pst.setString(81, String.valueOf(ficha.getHpAtual()));
//            pst.setString(82, String.valueOf(ficha.getMopAtual()));
//            pst.setString(83, String.valueOf(ficha.getHpNegAtual()));
//
//            pst.setString(84, String.valueOf(ficha.getIni()));
//            pst.setString(85, String.valueOf(ficha.getEsq()));
//            pst.setString(86, String.valueOf(ficha.getApr()));
//            pst.setString(87, String.valueOf(ficha.getCrt()));
//            pst.setString(88, String.valueOf(ficha.getVel()));
//
//            pst.setString(89, String.valueOf(ficha.getbIntCdn()));
//            pst.setString(90, String.valueOf(ficha.getSorte()));
//            pst.setString(91, String.valueOf(ficha.getSorteDiaria()));
//            pst.setString(92, String.valueOf(ficha.getModClas()));
//
//            pst.setString(93, convertBtS(ficha.isSortePorLvl()));
//            pst.setString(94, convertBtS(ficha.isPersonagemDeJogador()));
//            pst.setString(95, convertBtS(ficha.isCriaturaDoMestre()));
//
//            pst.setString(96, String.valueOf(ficha.getPontosHeroicos()));
//            pst.setString(97, String.valueOf(ficha.getPontosInspiracao()));
//            pst.setString(98, String.valueOf(ficha.getShu()));
//            pst.setString(99, String.valueOf(ficha.getStun()));
//
//            pst.setString(100, convertBtS(ficha.isDesmaiado()));
//
//            pst.setString(101, ficha.getAtkPad());
//            pst.setString(102, ficha.getDefPad());
//
//            pst.execute();
//
//        } catch (SQLException e) {
//            System.out.println("falha no insert - ficha");
//        }
//
//
//        // habilidades
//        for (String nomeHabilidade : ficha.getHabilidades().keySet()) {
//            Habilidades skill = ficha.getHabilidade(nomeHabilidade);
//
//            // inserindo habilidades
//            try {
//
//                sql = "insert into habilidades values(" +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
//                    "?, ?, ?, ?, ?, ?, ?)";
//
//                pst = execute.prepareStatement(sql);
//
//                pst.setString(1, ficha.getNick());
//
//                pst.setString(2, skill.getNome());
//                pst.setString(3, skill.getArma());
//                pst.setString(4, skill.getDados());
//                pst.setString(5, skill.getProficiencia());
//                pst.setString(6, skill.getDescricao());
//                pst.setString(7, skill.getDescricaoBreve());
//
//                pst.setString(8, String.valueOf(skill.getRestricao()));
//                pst.setString(9, String.valueOf(skill.getDano()));
//                pst.setString(10, String.valueOf(skill.getDanoPorSegundo()));
//                pst.setString(11, String.valueOf(skill.getAuraBonus()));
//                pst.setString(12, String.valueOf(skill.getTurnoDps()));
//                pst.setString(13, String.valueOf(skill.getDecrescimoDpsPorTurno()));
//                pst.setString(14, String.valueOf(skill.getQtd()));
//                pst.setString(15, String.valueOf(skill.getVol()));
//                pst.setString(16, String.valueOf(skill.getCrt()));
//                pst.setString(17, String.valueOf(skill.getDanoFixo()));
//                pst.setString(18, String.valueOf(skill.getAcertoFixo()));
//                pst.setString(19, String.valueOf(skill.getLvl()));
//                pst.setString(20, String.valueOf(skill.getSubLvl()));
//                pst.setString(21, String.valueOf(skill.getBonus()));
//
//                pst.setString(22, String.valueOf(skill.getQtdFor()));
//                pst.setString(23, String.valueOf(skill.getQtdCon()));
//                pst.setString(24, String.valueOf(skill.getQtdDex()));
//                pst.setString(25, String.valueOf(skill.getQtdInt()));
//                pst.setString(26, String.valueOf(skill.getQtdCar()));
//                pst.setString(27, String.valueOf(skill.getQtdMen()));
//                pst.setString(28, String.valueOf(skill.getQtdRef()));
//                pst.setString(29, String.valueOf(skill.getQtdEms()));
//                pst.setString(30, String.valueOf(skill.getQtdMan()));
//                pst.setString(31, String.valueOf(skill.getQtdMat()));
//                pst.setString(32, String.valueOf(skill.getQtdTrs()));
//                pst.setString(33, String.valueOf(skill.getQtdEsp()));
//                pst.setString(34, String.valueOf(skill.getQtdEsq()));
//                pst.setString(35, String.valueOf(skill.getQtdVel()));
//                pst.setString(36, String.valueOf(skill.getQtdTen()));
//                pst.setString(37, String.valueOf(skill.getQtdAop()));
//                pst.setString(38, String.valueOf(skill.getQtdMop()));
//                pst.setString(39, String.valueOf(skill.getQtdCdn()));
//
//                pst.setString(40, convertBtS(skill.isPerfurante()));
//                pst.setString(41, convertBtS(skill.isGastaAura()));
//                pst.setString(42, convertBtS(skill.isTrs()));
//                pst.setString(43, convertBtS(skill.isMat()));
//                pst.setString(44, convertBtS(skill.isMan()));
//                pst.setString(45, convertBtS(skill.isDps()));
//                pst.setString(46, convertBtS(skill.isRebote()));
//
//                pst.setString(47, convertBtS(skill.isSomarFor()));
//                pst.setString(48, convertBtS(skill.isSomarCon()));
//                pst.setString(49, convertBtS(skill.isSomarDex()));
//                pst.setString(50, convertBtS(skill.isSomarInt()));
//                pst.setString(51, convertBtS(skill.isSomarCar()));
//                pst.setString(52, convertBtS(skill.isSomarMen()));
//                pst.setString(53, convertBtS(skill.isSomarRef()));
//                pst.setString(54, convertBtS(skill.isSomarEms()));
//                pst.setString(55, convertBtS(skill.isSomarMan()));
//                pst.setString(56, convertBtS(skill.isSomarMat()));
//                pst.setString(57, convertBtS(skill.isSomarTrs()));
//                pst.setString(58, convertBtS(skill.isSomarEsp()));
//                pst.setString(59, convertBtS(skill.isSomarEsq()));
//                pst.setString(60, convertBtS(skill.isSomarVel()));
//                pst.setString(61, convertBtS(skill.isSomarTen()));
//                pst.setString(62, convertBtS(skill.isSomarAop()));
//                pst.setString(63, convertBtS(skill.isSomarMop()));
//                pst.setString(64, convertBtS(skill.isSomarCdn()));
//
//                pst.setString(65, String.valueOf(skill.getRyu()));
//                pst.setString(66, convertBtS(skill.isDanoRebote()));
//                pst.setString(67, convertBtS(skill.isGastaRyu()));
//
//                pst.execute();
//
//            } catch (SQLException e) {
//                System.out.println("falha no insert - habilidades");
//            }
//
//        }
//
//        // proficiencias
//        for (String nomePro : ficha.getPro().keySet()) {
//            LvlBonus pro = ficha.getPro().get(nomePro);
//
//            // inserindo proficiencias
//            try {
//                sql = "insert into pro values(?, ?, ?, ?, ?)";
//                pst = execute.prepareStatement(sql);
//                pst.setString(1, ficha.getNick());
//                pst.setString(2, nomePro);
//                pst.setString(3, String.valueOf(pro.getLvl()));
//                pst.setString(4, String.valueOf(pro.getLvj()));
//                pst.setString(5, String.valueOf(pro.getBonus()));
//
//                pst.execute();
//
//            } catch (SQLException e) {
//                System.out.println("nada foi inserido - pro");
//            }
//        }
//
//        // pericias
//        for (String nomePer : ficha.getPer().keySet()) {
//            LvlBonus per = ficha.getPer().get(nomePer);
//
//            // inserindo a pericia
//            try {
//                sql = "insert into per values(?, ?, ?, ?, ?)";
//                pst = execute.prepareStatement(sql);
//                pst.setString(1, ficha.getNick());
//                pst.setString(2, nomePer);
//                pst.setString(3, String.valueOf(per.getLvl()));
//                pst.setString(4, String.valueOf(per.getLvj()));
//                pst.setString(5, String.valueOf(per.getBonus()));
//
//                pst.execute();
//
//            } catch (SQLException e) {
//                System.out.println("nada foi inserido - per");
//            }
//        }
//
//        try {
//            execute.close();
//        } catch (SQLException e) {
//            System.out.println("erro ao fechar");
//            System.out.println(e);
//        }
//
//        return true;
//    }
    
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
                FileReader arq = new FileReader("src\\dataBase\\exp_lvl.txt")) {
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
                FileReader arq = new FileReader("src\\dataBase\\exp_nen.txt")) {
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
                FileReader arq = new FileReader("src\\dataBase\\lvl_nen.txt")) {
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
