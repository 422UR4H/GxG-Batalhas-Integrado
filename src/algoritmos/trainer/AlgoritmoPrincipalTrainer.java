/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.trainer;

import algoritmos.batalhas.AlgoritmoPrincipal;
import algoritmos.dal.ModuloConexao;
import ficha_personagem.Classes;
import ficha_personagem.Ficha;
import ficha_personagem.Habilidades;
import ficha_personagem.LvlBonus;
import ficha_personagem.LvlExp;
import ficha_personagem.Treino;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

import java.sql.*;

/**
 *
 * @author 422UR4H
 */
public class AlgoritmoPrincipalTrainer {
    private static final int ESQ_INICIAL = 15;
    private static final int HP_INICIAL = 15;
    private static final int PER = 1;
    private static final int PRO = 2;
    private static final int EXP_LVL_MAX = 80; // dobro do máximo para evitar erros
    private static final int EXP_NEN_MAX = 200; // dobro do máximo para evitar erros
    private static final int LVL_NEN_MAX = 200; // dobro do máximo para evitar erros
    private static final int EXP_LVL[] = new int[EXP_LVL_MAX];
    private static final int EXP_NEN[] = new int[EXP_NEN_MAX];
    private static final int LVL_NEN[] = new int[LVL_NEN_MAX];
//    private static Map<String, Personagem> per = new HashMap<>();
//    private static Map<String, Personagem> perDerivados = new HashMap<>();
    private static Map<String, Ficha> fichas = new HashMap<>();
    private static Map<String, Ficha> fichasDerivadas = new HashMap<>();
    private static Map<Integer, Treino> treino = new HashMap<>();
    private static Ficha ficha = new Ficha();
    private static Habilidades habilidade = new Habilidades();
    private static String nome;
    private static String nomeTreino;
    private static int treinar = 0;
    private static int pericia = 0;
    private static int qtd = 0;
    private static double diasIgnorados = 0;
    private static double modClas = 0;
    private static double diasTreinados = 0;
    private static double diasRestantes = 0;
    private static double subDiasRestantes = 0;
    private static boolean diasRestantesSetados = false;
    private static boolean clickPer = true;
    private static boolean clickPro = true;

    
    public static boolean init() throws IOException, FileNotFoundException, ClassNotFoundException {
        if (!loadTabelasExp()) {
            JOptionPane.showMessageDialog(null, "O Gerador não pode rodar sem as tabelas de experiência",
                    "Hard Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // carregando Classes
        Classes.init();
        
        // carregando fichas e personagens
        //loadPersonagens();
        //loadFichas();
//        File folder = new File(algoritmos.batalhas.AlgoritmoPrincipal.getDIR_FICHAS());
//        AlgoritmoPrincipalTrainer.loadFichas(folder);
        if (!AlgoritmoPrincipal.loadFichas()) {
            JOptionPane.showMessageDialog(null, "Fichas não encontradas!",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
        
//        loadHps();
//        loadMops();
        algoritmos.batalhas.AlgoritmoPrincipal.loadTabelasExp();
        
        CalculadoraTrainer.setEXP_LVL(EXP_LVL);
        CalculadoraTrainer.setEXP_NEN(EXP_NEN);
        CalculadoraTrainer.setLVL_NEN(LVL_NEN);
        
        AlgoritmoPrincipalTrainer.setDiasRestantes(0);
        AlgoritmoPrincipalTrainer.setDiasRestantesSetados(false);
        
        return true;
    }
    
    public static void reset() {
        treino = new HashMap<>();
        ficha = new Ficha();
        habilidade = new Habilidades();
        AlgoritmoPrincipalTrainer.setDiasRestantes(0);
        AlgoritmoPrincipalTrainer.setDiasRestantesSetados(false);
        treinar = 0;
        pericia = 0;
        modClas = 0;
        diasTreinados = 0;
        diasRestantes = 0;
        subDiasRestantes = 0;
        diasIgnorados = 0;
        diasRestantesSetados = false;
        clickPer = true;
        clickPro = true;
    }
    
//    public static boolean saveFicha(Ficha ficha) {
//        PreparedStatement pst;
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
//            System.err.println("Essa ficha não existia no Banco");
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
    
    public static void saveFicha(Ficha ficha) throws ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                algoritmos.batalhas.AlgoritmoPrincipal.getDIR_FICHAS() + "\\" + ficha.getNick() + ".dat"))) {
            oos.writeObject(ficha);
            oos.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    public static void replaceFicha(Ficha ficha) {
        AlgoritmoPrincipal.deleteFicha(ficha.getNick());
        AlgoritmoPrincipal.saveFicha(ficha);
    }
    
//    public static void replacePer(String nome, Personagem per) {
//        AlgoritmoPrincipalUpper.per.remove(nome);
//        AlgoritmoPrincipalUpper.per.put(per.getNome(), per);
//    }
    
//    public static boolean saveFichas() {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DIR_UPPER + "dataBase\\BD_Fichas.dat"))) {
//            oos.writeObject(fichas);
//            oos.close();
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            return false;
//        }
//    }
    
//    public static boolean savePersonagens() {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DIR_BATALHAS + "dataBase\\BD_Personagens.dat"))) {
//            oos.writeObject(per);
//            oos.close();
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            return false;
//        }
//    }
    
//    public static boolean loadFichas() throws FileNotFoundException, IOException, ClassNotFoundException {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DIR_UPPER + "dataBase\\BD_Fichas.dat"))) {
//            fichas = (Map<String, Ficha>) ois.readObject();
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            return false;
//        }
//    }
    
//    public static boolean loadFichasDerivadas() throws FileNotFoundException, IOException, ClassNotFoundException {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DIR_UPPER + "dataBase\\BD_Fichas_Derivadas.dat"))) {
//            fichasDerivadas = (Map<String, Ficha>) ois.readObject();
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            JOptionPane.showMessageDialog(null, "Bando de Dados de Fichas Derivadas não encontrado!", "No DataBase!",
//                    JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//    }
    
//    public static boolean loadPersonagens() throws FileNotFoundException, IOException, ClassNotFoundException {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DIR_BATALHAS + "dataBase\\BD_Personagens.dat"))) {
//            per = (Map<String, Personagem>) ois.readObject();
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            JOptionPane.showMessageDialog(null, "Bando de Dados de Personagens não encontrado!", "No DataBase!",
//                    JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//    }
    
//    public static boolean loadPersonagensDerivados() throws FileNotFoundException, IOException, ClassNotFoundException {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DIR_BATALHAS + "dataBase\\BD_Personagens_derivados.dat"))) {
//            perDerivados = (Map<String, Personagem>) ois.readObject();
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            return false;
//        }
//    }
    
    public static boolean loadTabelasExp() {
        EXP_LVL[0] = 0;
        EXP_LVL[1] = 0;
        EXP_LVL[2] = 800;
        EXP_LVL[3] = 1900;
        EXP_LVL[4] = 2400;
        EXP_LVL[5] = 3600;
        EXP_LVL[6] = 5200;
        EXP_LVL[7] = 8000;
        EXP_LVL[8] = 12000;
        EXP_LVL[9] = 20000;
        EXP_LVL[10] = 40000;
        EXP_LVL[11] = 60000;
        EXP_LVL[12] = 68000;
        EXP_LVL[13] = 72000;
        EXP_LVL[14] = 74800;
        EXP_LVL[15] = 76400;
        EXP_LVL[16] = 77600;
        EXP_LVL[17] = 78400;
        EXP_LVL[18] = 79200;
        EXP_LVL[19] = 79600;
        EXP_LVL[20] = 80000;
        
        EXP_NEN[0] = 0;
        EXP_NEN[1] = 100;
        EXP_NEN[2] = 100;
        EXP_NEN[3] = 100;
        EXP_NEN[4] = 105;
        EXP_NEN[5] = 110;
        EXP_NEN[6] = 115;
        EXP_NEN[7] = 120;
        EXP_NEN[8] = 125;
        EXP_NEN[9] = 130;
        EXP_NEN[10] = 135;
        EXP_NEN[11] = 140;
        EXP_NEN[12] = 150;
        EXP_NEN[13] = 160;
        EXP_NEN[14] = 170;
        EXP_NEN[15] = 180;
        EXP_NEN[16] = 190;
        EXP_NEN[17] = 200;
        EXP_NEN[18] = 210;
        EXP_NEN[19] = 220;
        EXP_NEN[20] = 230;
        EXP_NEN[21] = 245;
        EXP_NEN[22] = 260;
        EXP_NEN[23] = 275;
        EXP_NEN[23] = 290;
        EXP_NEN[25] = 305;
        EXP_NEN[26] = 320;
        EXP_NEN[27] = 340;
        EXP_NEN[28] = 360;
        EXP_NEN[29] = 380;
        EXP_NEN[30] = 400;
        EXP_NEN[31] = 430;
        EXP_NEN[32] = 460;
        EXP_NEN[33] = 490;
        EXP_NEN[34] = 520;
        EXP_NEN[35] = 550;
        EXP_NEN[36] = 600;
        EXP_NEN[37] = 650;
        EXP_NEN[38] = 700;
        EXP_NEN[39] = 750;
        EXP_NEN[40] = 800;
        EXP_NEN[41] = 900;
        EXP_NEN[42] = 1000;
        EXP_NEN[43] = 1100;
        EXP_NEN[44] = 1200;
        EXP_NEN[45] = 1300;
        EXP_NEN[46] = 1400;
        EXP_NEN[47] = 1500;
        EXP_NEN[48] = 1600;
        EXP_NEN[49] = 1700;
        EXP_NEN[50] = 1800;
        EXP_NEN[51] = 1900;
        EXP_NEN[52] = 2000;
        EXP_NEN[53] = 2100;
        EXP_NEN[54] = 2200;
        EXP_NEN[55] = 2300;
        EXP_NEN[56] = 2350;
        EXP_NEN[57] = 2400;
        EXP_NEN[58] = 2450;
        EXP_NEN[59] = 2500;
        EXP_NEN[60] = 2550;
        EXP_NEN[61] = 2580;
        EXP_NEN[62] = 2610;
        EXP_NEN[63] = 2640;
        EXP_NEN[64] = 2670;
        EXP_NEN[65] = 2700;
        EXP_NEN[66] = 2720;
        EXP_NEN[67] = 2740;
        EXP_NEN[68] = 2760;
        EXP_NEN[69] = 2780;
        EXP_NEN[70] = 2800;
        EXP_NEN[71] = 2815;
        EXP_NEN[72] = 2830;
        EXP_NEN[73] = 2845;
        EXP_NEN[74] = 2860;
        EXP_NEN[75] = 2875;
        EXP_NEN[76] = 2890;
        EXP_NEN[77] = 2900;
        EXP_NEN[78] = 2910;
        EXP_NEN[79] = 2920;
        EXP_NEN[80] = 2930;
        EXP_NEN[81] = 2940;
        EXP_NEN[82] = 2950;
        EXP_NEN[83] = 2960;
        EXP_NEN[84] = 2970;
        EXP_NEN[85] = 2980;
        EXP_NEN[86] = 2985;
        EXP_NEN[87] = 2990;
        EXP_NEN[88] = 2995;
        EXP_NEN[89] = 3000;
        EXP_NEN[90] = 3000;
       
        LVL_NEN[0] = 0;
        LVL_NEN[1] = 40;
        LVL_NEN[2] = 80;
        LVL_NEN[3] = 120;
        LVL_NEN[4] = 160;
        LVL_NEN[5] = 200;
        LVL_NEN[6] = 240;
        LVL_NEN[7] = 280;
        LVL_NEN[8] = 320;
        LVL_NEN[9] = 360;
        LVL_NEN[10] = 400;
        LVL_NEN[11] = 440;
        LVL_NEN[12] = 480;
        LVL_NEN[13] = 520;
        LVL_NEN[14] = 560;
        LVL_NEN[15] = 600;
        LVL_NEN[16] = 660;
        LVL_NEN[17] = 720;
        LVL_NEN[18] = 780;
        LVL_NEN[19] = 840;
        LVL_NEN[20] = 900;
        LVL_NEN[21] = 980;
        LVL_NEN[22] = 1060;
        LVL_NEN[23] = 1140;
        LVL_NEN[24] = 1220;
        LVL_NEN[25] = 1300;
        LVL_NEN[26] = 1440;
        LVL_NEN[27] = 1580;
        LVL_NEN[28] = 1720;
        LVL_NEN[29] = 1860;
        LVL_NEN[30] = 2000;
        LVL_NEN[31] = 2200;
        LVL_NEN[32] = 2400;
        LVL_NEN[33] = 2600;
        LVL_NEN[34] = 2800;
        LVL_NEN[35] = 3000;
        LVL_NEN[36] = 3400;
        LVL_NEN[37] = 3800;
        LVL_NEN[38] = 4200;
        LVL_NEN[39] = 4600;
        LVL_NEN[40] = 5000;
        LVL_NEN[41] = 6000;
        LVL_NEN[42] = 7000;
        LVL_NEN[43] = 8000;
        LVL_NEN[44] = 9000;
        LVL_NEN[45] = 10000;
        LVL_NEN[46] = 11000;
        LVL_NEN[47] = 12000;
        LVL_NEN[48] = 13000;
        LVL_NEN[49] = 14000;
        LVL_NEN[50] = 15000;
        LVL_NEN[51] = 15400;
        LVL_NEN[52] = 15800;
        LVL_NEN[53] = 16200;
        LVL_NEN[54] = 16600;
        LVL_NEN[55] = 17000;
        LVL_NEN[56] = 17200;
        LVL_NEN[57] = 17400;
        LVL_NEN[58] = 17600;
        LVL_NEN[59] = 17800;
        LVL_NEN[60] = 18000;
        LVL_NEN[61] = 18140;
        LVL_NEN[62] = 18280;
        LVL_NEN[63] = 18420;
        LVL_NEN[64] = 18560;
        LVL_NEN[65] = 18700;
        LVL_NEN[66] = 18780;
        LVL_NEN[67] = 18860;
        LVL_NEN[68] = 18940;
        LVL_NEN[69] = 19020;
        LVL_NEN[70] = 19100;
        LVL_NEN[71] = 19160;
        LVL_NEN[72] = 19220;
        LVL_NEN[73] = 19280;
        LVL_NEN[74] = 19340;
        LVL_NEN[75] = 19400;
        LVL_NEN[76] = 19440;
        LVL_NEN[77] = 19480;
        LVL_NEN[78] = 19520;
        LVL_NEN[79] = 19560;
        LVL_NEN[80] = 19600;
        LVL_NEN[81] = 19640;
        LVL_NEN[82] = 19680;
        LVL_NEN[83] = 19720;
        LVL_NEN[84] = 19760;
        LVL_NEN[85] = 19800;
        LVL_NEN[86] = 19820;
        LVL_NEN[87] = 19840;
        LVL_NEN[88] = 19860;
        LVL_NEN[89] = 19880;
        LVL_NEN[90] = 19900;
        LVL_NEN[91] = 19920;
        LVL_NEN[92] = 19940;
        LVL_NEN[93] = 19960;
        LVL_NEN[94] = 19980;
        LVL_NEN[95] = 20000;
        
        return true;
    }
    
    public static boolean loadTabelasExpLocais() {
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
                while (i < AlgoritmoPrincipalTrainer.getEXP_LVL_MAX()) {
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
                while (i < AlgoritmoPrincipalTrainer.getEXP_NEN_MAX()) {
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
                while (i < AlgoritmoPrincipalTrainer.getLVL_NEN_MAX()) {
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

    public static void initTreino() {
        AlgoritmoPrincipalTrainer.treino = new HashMap<>();
    }

    public static Map<Integer, Treino> getTreinos() {
        return treino;
    }

    public static Treino getTreino(int i) {
        return treino.get(i);
    }

    public static void putTreino(Integer i, Treino treino) {
        AlgoritmoPrincipalTrainer.treino.put(i, treino);
    }
    
//    public static void integrarPersonagensDerivados() {
//        for(String nome : perDerivados.keySet()) {
//            per.put(nome, perDerivados.get(nome));
//        }
//    }
    
//    public static void integrarFichasDerivadas() {
//        for(String nome : fichasDerivadas.keySet()) {
//            fichas.put(nome, fichasDerivadas.get(nome));
//        }
//    }
    
//    public static boolean containsPersonagem(String personagem) {
//        //personagem = personagem.toUpperCase();
//        for (String nome : per.keySet()) {
//            // se o nome entrado pelo usuario, armazenado em personagem
//            // for igual ao nome de algum personagem, entao o nome
//            // entrado é valido (return true)
//            if (personagem.equals(per.get(nome).getNome())) {
//                return true;
//            }
//        }
//        return false;
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
    
    public static boolean saveFichas() {
        PreparedStatement pst;
        String sql;
        Connection execute = ModuloConexao.conector();
        
        // limpando banco para nova inserção de fichas
        try {
            sql = "truncate table pro";
            pst = execute.prepareStatement(sql);
            pst.execute();
            
            sql = "truncate table per";
            pst = execute.prepareStatement(sql);
            pst.execute();
            
            sql = "truncate table habilidades";
            pst = execute.prepareStatement(sql);
            pst.execute();
            
            sql = "truncate table ficha";
            pst = execute.prepareStatement(sql);
            pst.execute();
            
        } catch (SQLException e) {
            System.out.println("NÃO FOI POSSIVEL LIMPAR O BANCO");
            System.out.println(e);
        }
        
        
        for (String nick : fichas.keySet()) {
            Ficha ficha = fichas.get(nick);

            // inserindo ficha
            try {
                sql = "insert into ficha values(" +
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

                pst.setString(1, nick);
                pst.setString(2, ficha.getNome());
                pst.setString(3, ficha.getClasse());
                pst.setString(4, ficha.getNen());
                pst.setString(5, ficha.getTendencia());
                pst.setString(6, ficha.getHunter());

                pst.setString(7, String.valueOf(ficha.getDias()));
                pst.setString(8, String.valueOf(ficha.getAltura()));
                pst.setString(9, String.valueOf(ficha.getPeso()));
                pst.setString(10, String.valueOf(ficha.getIdade()));

                pst.setString(11, ficha.getInventario());
                pst.setString(12, ficha.getDescricao());
                pst.setString(13, ficha.getDescricaoBreve());

                pst.setString(14, String.valueOf(ficha.getIniFor()));
                pst.setString(15, String.valueOf(ficha.getIniCon()));
                pst.setString(16, String.valueOf(ficha.getIniDex()));
                pst.setString(17, String.valueOf(ficha.getIniInt()));
                pst.setString(18, String.valueOf(ficha.getIniCar()));
                pst.setString(19, String.valueOf(ficha.getIniMen()));

                pst.setString(20, String.valueOf(ficha.getValFor()));
                pst.setString(21, String.valueOf(ficha.getValCon()));
                pst.setString(22, String.valueOf(ficha.getValDex()));
                pst.setString(23, String.valueOf(ficha.getValInt()));
                pst.setString(24, String.valueOf(ficha.getValCar()));
                pst.setString(25, String.valueOf(ficha.getValMen()));

                pst.setString(26, String.valueOf(ficha.getModFor()));
                pst.setString(27, String.valueOf(ficha.getModCon()));
                pst.setString(28, String.valueOf(ficha.getModDex()));
                pst.setString(29, String.valueOf(ficha.getModInt()));
                pst.setString(30, String.valueOf(ficha.getModCar()));
                pst.setString(31, String.valueOf(ficha.getModMen()));

                pst.setString(32, String.valueOf(ficha.getbFor()));
                pst.setString(33, String.valueOf(ficha.getbCon()));
                pst.setString(34, String.valueOf(ficha.getbDex()));
                pst.setString(35, String.valueOf(ficha.getbInt()));
                pst.setString(36, String.valueOf(ficha.getbCar()));
                pst.setString(37, String.valueOf(ficha.getbMen()));

                pst.setString(38, String.valueOf(ficha.getPerFor()));
                pst.setString(39, String.valueOf(ficha.getPerCon()));
                pst.setString(40, String.valueOf(ficha.getPerDex()));
                pst.setString(41, String.valueOf(ficha.getPerInt()));
                pst.setString(42, String.valueOf(ficha.getPerCar()));
                pst.setString(43, String.valueOf(ficha.getPerMen()));

                pst.setString(44, String.valueOf(ficha.getAtr("REF").getExp()));
                pst.setString(45, String.valueOf(ficha.getAtr("EMS").getExp()));
                pst.setString(46, String.valueOf(ficha.getAtr("MAT").getExp()));
                pst.setString(47, String.valueOf(ficha.getAtr("MAN").getExp()));
                pst.setString(48, String.valueOf(ficha.getAtr("TRS").getExp()));
                pst.setString(49, String.valueOf(ficha.getAtr("ESP").getExp()));
                pst.setString(50, String.valueOf(ficha.getAtr("CDN").getExp()));
                pst.setString(51, String.valueOf(ficha.getAtr("TEN").getExp()));
                pst.setString(52, String.valueOf(ficha.getAtr("RYU").getExp()));
                pst.setString(53, String.valueOf(ficha.getAtr("AOP").getExp()));
                pst.setString(54, String.valueOf(ficha.getAtr("MOP").getExp()));
                pst.setString(55, String.valueOf(ficha.getAtr("ZTS").getExp()));
                pst.setString(56, String.valueOf(ficha.getAtr("EN").getExp()));

                pst.setString(57, String.valueOf(ficha.getAtrRef()));
                pst.setString(58, String.valueOf(ficha.getAtrEms()));
                pst.setString(59, String.valueOf(ficha.getAtrMat()));
                pst.setString(60, String.valueOf(ficha.getAtrMan()));
                pst.setString(61, String.valueOf(ficha.getAtrTrs()));
                pst.setString(62, String.valueOf(ficha.getAtrEsp()));
                pst.setString(63, String.valueOf(ficha.getAtrCdn()));
                pst.setString(64, String.valueOf(ficha.getTen()));
                pst.setString(65, String.valueOf(ficha.getRyu()));
                pst.setString(66, String.valueOf(ficha.getAop()));
                pst.setString(67, String.valueOf(ficha.getMop()));
                pst.setString(68, String.valueOf(ficha.getZts()));
                pst.setString(69, String.valueOf(ficha.getEn()));

                pst.setString(70, String.valueOf(ficha.getModCdn()));
                pst.setString(71, String.valueOf(ficha.getCoefHp()));
                pst.setString(72, String.valueOf(ficha.getLvl()));
                pst.setString(73, String.valueOf(ficha.getExp()));
                pst.setString(74, String.valueOf(ficha.getExpBonus()));
                pst.setString(75, String.valueOf(ficha.getLvlNen()));
                pst.setString(76, String.valueOf(ficha.getExpNen()));
                pst.setString(77, String.valueOf(ficha.getExpBonusNen()));

                pst.setString(78, String.valueOf(ficha.getHpMax()));
                pst.setString(79, String.valueOf(ficha.getMopMax()));
                pst.setString(80, String.valueOf(ficha.getHpNegMax()));

                pst.setString(81, String.valueOf(ficha.getHpAtual()));
                pst.setString(82, String.valueOf(ficha.getMopAtual()));
                pst.setString(83, String.valueOf(ficha.getHpNegAtual()));

                pst.setString(84, String.valueOf(ficha.getIni()));
                pst.setString(85, String.valueOf(ficha.getEsq()));
                pst.setString(86, String.valueOf(ficha.getApr()));
                pst.setString(87, String.valueOf(ficha.getCrt()));
                pst.setString(88, String.valueOf(ficha.getVel()));

                pst.setString(89, String.valueOf(ficha.getbIntCdn()));
                pst.setString(90, String.valueOf(ficha.getSorte()));
                pst.setString(91, String.valueOf(ficha.getSorteDiaria()));
                pst.setString(92, String.valueOf(ficha.getModClas()));

                pst.setString(93, convertBtS(ficha.isSortePorLvl()));
                pst.setString(94, convertBtS(ficha.isPersonagemDeJogador()));
                pst.setString(95, convertBtS(ficha.isCriaturaDoMestre()));

                pst.setString(96, String.valueOf(ficha.getPontosHeroicos()));
                pst.setString(97, String.valueOf(ficha.getPontosInspiracao()));
                pst.setString(98, String.valueOf(ficha.getShu()));
                pst.setString(99, String.valueOf(ficha.getStun()));

                pst.setString(100, convertBtS(ficha.isDesmaiado()));
                
                pst.setString(101, ficha.getAtkPad());
                pst.setString(102, ficha.getDefPad());

                
                pst.execute();

            } catch (SQLException e) {
                System.out.println("falha no insert - ficha");
            }


            // habilidades
            for (String nomeHabilidade : ficha.getHabilidades().keySet()) {
                Habilidades skill = ficha.getHabilidade(nomeHabilidade);

                // inserindo habilidades
                try {

                    sql = "insert into habilidades values(" +
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

                    pst.setString(8, String.valueOf(skill.getRestricao()));
                    pst.setString(9, String.valueOf(skill.getDano()));
                    pst.setString(10, String.valueOf(skill.getDanoPorSegundo()));
                    pst.setString(11, String.valueOf(skill.getAuraBonus()));
                    pst.setString(12, String.valueOf(skill.getTurnoDps()));
                    pst.setString(13, String.valueOf(skill.getDecrescimoDpsPorTurno()));
                    pst.setString(14, String.valueOf(skill.getQtd()));
                    pst.setString(15, String.valueOf(skill.getVol()));
                    pst.setString(16, String.valueOf(skill.getCrt()));
                    pst.setString(17, String.valueOf(skill.getDanoFixo()));
                    pst.setString(18, String.valueOf(skill.getAcertoFixo()));
                    pst.setString(19, String.valueOf(skill.getLvl()));
                    pst.setString(20, String.valueOf(skill.getSubLvl()));
                    pst.setString(21, String.valueOf(skill.getBonus()));

                    pst.setString(22, String.valueOf(skill.getQtdFor()));
                    pst.setString(23, String.valueOf(skill.getQtdCon()));
                    pst.setString(24, String.valueOf(skill.getQtdDex()));
                    pst.setString(25, String.valueOf(skill.getQtdInt()));
                    pst.setString(26, String.valueOf(skill.getQtdCar()));
                    pst.setString(27, String.valueOf(skill.getQtdMen()));
                    pst.setString(28, String.valueOf(skill.getQtdRef()));
                    pst.setString(29, String.valueOf(skill.getQtdEms()));
                    pst.setString(30, String.valueOf(skill.getQtdMan()));
                    pst.setString(31, String.valueOf(skill.getQtdMat()));
                    pst.setString(32, String.valueOf(skill.getQtdTrs()));
                    pst.setString(33, String.valueOf(skill.getQtdEsp()));
                    pst.setString(34, String.valueOf(skill.getQtdEsq()));
                    pst.setString(35, String.valueOf(skill.getQtdVel()));
                    pst.setString(36, String.valueOf(skill.getQtdTen()));
                    pst.setString(37, String.valueOf(skill.getQtdAop()));
                    pst.setString(38, String.valueOf(skill.getQtdMop()));
                    pst.setString(39, String.valueOf(skill.getQtdCdn()));

                    pst.setString(40, convertBtS(skill.isPerfurante()));
                    pst.setString(41, convertBtS(skill.isGastaAura()));
                    pst.setString(42, convertBtS(skill.isTrs()));
                    pst.setString(43, convertBtS(skill.isMat()));
                    pst.setString(44, convertBtS(skill.isMan()));
                    pst.setString(45, convertBtS(skill.isDps()));
                    pst.setString(46, convertBtS(skill.isRebote()));

                    pst.setString(47, convertBtS(skill.isSomarFor()));
                    pst.setString(48, convertBtS(skill.isSomarCon()));
                    pst.setString(49, convertBtS(skill.isSomarDex()));
                    pst.setString(50, convertBtS(skill.isSomarInt()));
                    pst.setString(51, convertBtS(skill.isSomarCar()));
                    pst.setString(52, convertBtS(skill.isSomarMen()));
                    pst.setString(53, convertBtS(skill.isSomarRef()));
                    pst.setString(54, convertBtS(skill.isSomarEms()));
                    pst.setString(55, convertBtS(skill.isSomarMan()));
                    pst.setString(56, convertBtS(skill.isSomarMat()));
                    pst.setString(57, convertBtS(skill.isSomarTrs()));
                    pst.setString(58, convertBtS(skill.isSomarEsp()));
                    pst.setString(59, convertBtS(skill.isSomarEsq()));
                    pst.setString(60, convertBtS(skill.isSomarVel()));
                    pst.setString(61, convertBtS(skill.isSomarTen()));
                    pst.setString(62, convertBtS(skill.isSomarAop()));
                    pst.setString(63, convertBtS(skill.isSomarMop()));
                    pst.setString(64, convertBtS(skill.isSomarCdn()));
                    
                    pst.setString(65, String.valueOf(skill.getRyu()));
                    pst.setString(66, convertBtS(skill.isDanoRebote()));
                    pst.setString(67, convertBtS(skill.isGastaRyu()));
                    
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
                    sql = "insert into pro values(?, ?, ?, ?, ?)";
                    pst = execute.prepareStatement(sql);
                    pst.setString(1, ficha.getNick());
                    pst.setString(2, nomePro);
                    pst.setString(3, String.valueOf(pro.getLvl()));
                    pst.setString(4, String.valueOf(pro.getLvj()));
                    pst.setString(5, String.valueOf(pro.getBonus()));
                    
                    pst.execute();

                } catch (SQLException e) {
                    System.out.println("nada foi inserido - pro");
                }
            }

            // pericias
            for (String nomePer : ficha.getPer().keySet()) {
                LvlBonus per = ficha.getPer().get(nomePer);

                // inserindo a pericia
                try {
                    sql = "insert into per values(?, ?, ?, ?, ?)";
                    pst = execute.prepareStatement(sql);
                    pst.setString(1, ficha.getNick());
                    pst.setString(2, nomePer);
                    pst.setString(3, String.valueOf(per.getLvl()));
                    pst.setString(4, String.valueOf(per.getLvj()));
                    pst.setString(5, String.valueOf(per.getBonus()));
                    
                    pst.execute();

                } catch (SQLException e) {
                    System.out.println("nada foi inserido - per");
                }
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
    
//    public static boolean loadFichas() {
//        String sql = "select * from ficha";
//        PreparedStatement pst;
//        ResultSet rs;
//        Connection execute = ModuloConexao.conector();
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
//            
//            try {
//                execute.close();
//            } catch (SQLException ex) {
//                System.out.println("falha no close");
//            }
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
    
    public static void loadHps() {
        Connection execute = ModuloConexao.conector();
        
        try {
            for (String nick : fichas.keySet()) {
                Ficha ficha = fichas.get(nick);
                String sql = "select hpAtual from ficha where nick = ?";
                PreparedStatement pst = execute.prepareStatement(sql);
                pst.setString(1, nick);
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    ficha.setHpAtual(Integer.parseInt(rs.getString(1)));
                }
                
            }
            
            execute.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void loadMops() {
        Connection execute = ModuloConexao.conector();
        
        try {
            for (String nick : fichas.keySet()) {
                Ficha ficha = fichas.get(nick);
                String sql = "select mopAtual from ficha where nick = ?";
                PreparedStatement pst = execute.prepareStatement(sql);
                pst.setString(1, nick);
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    ficha.setMopAtual(Integer.parseInt(rs.getString(1)));
                }
                
            }
            
            execute.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static boolean containsFicha(String nomeFicha) {
        //personagem = personagem.toUpperCase();
        for (String nome : fichas.keySet()) {
            // se o nome entrado pelo usuario, armazenado em personagem
            // for igual ao nome de algum personagem, entao o nome
            // entrado é valido (return true)
            if (nomeFicha.equals(fichas.get(nome).getNick())) {
                return true;
            }
        }
        return false;
    }
    
    public static void atualizaFicha(Ficha ficha) {
        ficha.setHp();
        ficha.setEsq();
        ficha.setVel();
        ficha.setCrt();
        ficha.setIni();
        ficha.setApr();
    }

    public static double getDiasIgnorados() {
        return diasIgnorados;
    }

    public static void setDiasIgnorados(double diasIgnorados) {
        AlgoritmoPrincipalTrainer.diasIgnorados = diasIgnorados;
    }
    
    public static double getModClas() {
        return modClas;
    }

    public static void setModClas(double modClas) {
        AlgoritmoPrincipalTrainer.modClas = modClas;
    }
    
    public static boolean isClickPer() {
        return clickPer;
    }

    public static void setClickPer(boolean clickPer) {
        AlgoritmoPrincipalTrainer.clickPer = clickPer;
    }

    public static boolean isClickPro() {
        return clickPro;
    }

    public static void setClickPro(boolean clickPro) {
        AlgoritmoPrincipalTrainer.clickPro = clickPro;
    }
    
    public static int getLVL_NEN_MAX() {
        return LVL_NEN_MAX;
    }
    
    public static Ficha getFicha(String nome) {
        return fichas.get(nome);
    }

    public static Habilidades getHabilidade() {
        return habilidade;
    }

    public static void setHabilidade(Habilidades habilidade) {
        AlgoritmoPrincipalTrainer.habilidade = habilidade;
    }
    
    public static void decrementaSubDiasRestantes() {
        subDiasRestantes--;
    }
    
    public static double getSubDiasRestantes() {
        return subDiasRestantes;
    }

    public static void setSubDiasRestantes(double subDiasRestantes) {
        AlgoritmoPrincipalTrainer.subDiasRestantes = subDiasRestantes;
    }

    public static String getNomeTreino() {
        return nomeTreino;
    }

    public static void setNomeTreino(String nomePericia) {
        AlgoritmoPrincipalTrainer.nomeTreino = nomePericia;
    }

    public static int getTreinar() {
        return treinar;
    }

    public static boolean isDiasRestantesSetados() {
        return diasRestantesSetados;
    }

    public static void setDiasRestantesSetados(boolean diasRestantesSetados) {
        AlgoritmoPrincipalTrainer.diasRestantesSetados = diasRestantesSetados;
    }

    public static int getPericia() {
        return pericia;
    }

    public static void setPericia(int pericia) {
        AlgoritmoPrincipalTrainer.pericia = pericia;
    }

    public static void setTreinar(int treinar) {
        AlgoritmoPrincipalTrainer.treinar = treinar;
    }

    public static int getPER() {
        return PER;
    }

    public static int getPRO() {
        return PRO;
    }

    public static double getDiasTreinados() {
        return diasTreinados;
    }

    public static void incrementaDiasTreinados() {
        AlgoritmoPrincipalTrainer.diasTreinados++;
    }

    public static void incrementaMeioDiaTreinado() {
        AlgoritmoPrincipalTrainer.diasTreinados += 0.5;
    }
    
    public static void decrementaDiasRestantes() {
        AlgoritmoPrincipalTrainer.diasRestantes--;
    }
    
    public static void decrementaMeioDiaRestante() {
        AlgoritmoPrincipalTrainer.diasRestantes -= 0.5;
    }
    
    public static double getDiasRestantes() {
        return diasRestantes;
    }

    public static void setDiasRestantes(double diasRestantes) {
        AlgoritmoPrincipalTrainer.diasRestantes = diasRestantes;
    }

    public static void setDiasTreinados(double diasTreinados) {
        AlgoritmoPrincipalTrainer.diasTreinados = diasTreinados;
    }
    
    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        AlgoritmoPrincipalTrainer.nome = nome;
    }

//    public static Map<String, Personagem> getPer() {
//        return per;
//    }
//
//    public static void setPer(Map<String, Personagem> per) {
//        AlgoritmoPrincipalUpper.per = per;
//    }

    public static Map<String, Ficha> getFichas() {
        return fichas;
    }

    public static void setFichas(Map<String, Ficha> fichas) {
        AlgoritmoPrincipalTrainer.fichas = fichas;
    }

    public static Ficha getFicha() {
        return ficha;
    }

    public static void setFicha(Ficha ficha) {
        AlgoritmoPrincipalTrainer.ficha = ficha;
    }

    public static int getESQ_INICIAL() {
        return ESQ_INICIAL;
    }

    public static int getHP_INICIAL() {
        return HP_INICIAL;
    }

    public static int getEXP_LVL_MAX() {
        return EXP_LVL_MAX;
    }

    public static int getEXP_NEN_MAX() {
        return EXP_NEN_MAX;
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
    
    public static int[] getEXP_LVL() {
        return EXP_LVL;
    }

    public static int[] getEXP_NEN() {
        return EXP_NEN;
    }

//    public static Map<String, Personagem> getPerDerivados() {
//        return perDerivados;
//    }

    public static Map<String, Ficha> getFichasDerivadas() {
        return fichasDerivadas;
    }

    public static int getQtd() {
        return qtd;
    }

    public static void setQtd(int qtd) {
        AlgoritmoPrincipalTrainer.qtd = qtd;
    }
    
    public static void decQtd() {
        AlgoritmoPrincipalTrainer.qtd--;
    }
}
