/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.gerador;

import algoritmos.dal.ModuloConexao;
import ficha_personagem.Classes;
import ficha_personagem.Ficha;
import ficha_personagem.Habilidades;
import ficha_personagem.InfoPerson;
import ficha_personagem.LvlBonus;
import ficha_personagem.LvlExp;
import ficha_personagem.Personagem;
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
import algoritmos.batalhas.AlgoritmoPrincipal;

import java.sql.*;

/**
 *
 * @author 422UR4H
 */
public class AlgoritmoPrincipalGerador {
//    private static final int FOR_INC_VEL = 10;
//    private static final int DEX_INC_CRT = 10;
//    private static final int CON_INC_HP = 10;
//    private static final int INT_INC_CDN = 10;
//    private static final int CAR_INC_APR = 10;
    
//    private static final String DIR_GERADOR = System.getProperty("user.dir") + "\\GxG_Batalhas_3_0_Integrado\\";
//    private static final String DIR_BATALHAS = System.getProperty("user.dir") + "\\GxG_Batalhas_3_0_Integrado\\";
    private static final int DISTRIBUIR_E_SALVAR = 0;
    private static final int LIMPAR_FICHA = 1;
    private static final int RECALCULAR_FICHA = 2;
    private static final int EXP_LVL_MAX = 80; // dobro do máximo para evitar erros
    private static final int EXP_NEN_MAX = 200; // dobro do máximo para evitar erros
    private static final int LVL_NEN_MAX = 200; // dobro do máximo para evitar erros
    private static final int EXP_LVL[] = new int[EXP_LVL_MAX];
    private static final int EXP_NEN[] = new int[EXP_NEN_MAX];
    private static final int LVL_NEN[] = new int[LVL_NEN_MAX];
    private static final int LVL_INICIAL = 3;
    private static Map<String, Personagem> per = new HashMap<>();
    private static Map<String, Personagem> perDerivados = new HashMap<>();
    private static Map<String, Ficha> fichas = new HashMap<>();
    private static Map<String, Ficha> fichasDerivadas = new HashMap<>();
    private static Ficha ficha = new Ficha();
    private static int jButton = 0;
    private static boolean treino = false;
    private static String nome;
    
    
    public static Ficha getFicha(String nome) {
        return fichas.get(nome);
    }
    
    // construtor
    public AlgoritmoPrincipalGerador() {
    }
    
    public static boolean init() throws IOException, FileNotFoundException, ClassNotFoundException {
        if (!loadTabelasExp()) {
            JOptionPane.showMessageDialog(null, "O Gerador não pode rodar sem as tabelas de experiência",
                    "Hard Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // carregando Classes
        Classes.init();
        
        // carregando fichas
//        loadPersonagens();
//        File folder = new File(algoritmos.batalhas.AlgoritmoPrincipal.getDIR_FICHAS());
//        if (!AlgoritmoPrincipalGerador.loadFichas(folder)) {
        if (!AlgoritmoPrincipal.loadFichas()) {
            JOptionPane.showMessageDialog(null, "Fichas não encontradas!",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
        
//        loadHps();
//        loadMops();
        algoritmos.batalhas.AlgoritmoPrincipal.loadTabelasExp();
        
        CalculadoraGerador.setEXP_LVL(EXP_LVL);
        CalculadoraGerador.setEXP_NEN(EXP_NEN);
        CalculadoraGerador.setLVL_NEN(LVL_NEN);
        
        AlgoritmoPrincipalGerador.jButton = 0;
        
        return true;
    }
    
    public static boolean containsPersonagem(String personagem) {
        //personagem = personagem.toUpperCase();
        for (String nome : per.keySet()) {
            // se o nome entrado pelo usuario, armazenado em personagem
            // for igual ao nome de algum personagem, entao o nome
            // entrado é valido (return true)
            if (personagem.equals(per.get(nome).getNome())) {
                return true;
            }
        }
        return false;
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
        int hp = ficha.getHpAtual();
        ficha.setHp();
        ficha.setHpAtual(hp);
        
        ficha.setEsq();
        ficha.setVel();
        ficha.setCrt();
        ficha.setIni();
        ficha.setApr();
    }
    
    public static void removeFicha(String nome) {
        AlgoritmoPrincipalGerador.fichas.remove(nome);
    }
    
    public static void removeFicha(Ficha ficha) {
        AlgoritmoPrincipalGerador.fichas.remove(ficha.getNick());
    }
    

    public static int getjButton() {
        return jButton;
    }

    public static void setjButton(int jButtonFinal) {
        AlgoritmoPrincipalGerador.jButton = jButtonFinal;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        AlgoritmoPrincipalGerador.nome = nome;
    }

    public static int getLVL_INICIAL() {
        return LVL_INICIAL;
    }
    
    public static int getDISTRIBUIR_E_SALVAR() {
        return DISTRIBUIR_E_SALVAR;
    }

    public static int getLIMPAR_FICHA() {
        return LIMPAR_FICHA;
    }

    public static int getRECALCULAR_FICHA() {
        return RECALCULAR_FICHA;
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
    
    public static int getEXP_MOP(int lvl) {
        int exp = 0;
        for (int i = 2; i <= lvl; i++) {
            exp = i * 10 + 80;
        }
        return exp;
    }
    
    public static Ficha getFicha() {
        return ficha;
    }

    public static void setFicha(Ficha ficha) {
        AlgoritmoPrincipalGerador.ficha = ficha;
    }
    
    public static int getEXP_LVL_MAX() {
        return EXP_LVL_MAX;
    }

    public static int getEXP_NEN_MAX() {
        return EXP_NEN_MAX;
    }

    public static int getLVL_NEN_MAX() {
        return LVL_NEN_MAX;
    }

    public static boolean isTreino() {
        return treino;
    }

    public static void setTreino(boolean treino) {
        AlgoritmoPrincipalGerador.treino = treino;
    }
    
    public static void replacePer(String nome, Personagem per) {
        AlgoritmoPrincipalGerador.per.remove(nome);
        AlgoritmoPrincipalGerador.per.put(per.getNome(), per);
    }
    
    public static void putPer(Personagem per) {
        AlgoritmoPrincipalGerador.per.put(per.getNome(), per);
    }
    
    public static void replaceFicha(String nome, Ficha ficha) {
        AlgoritmoPrincipalGerador.fichas.remove(nome);
        AlgoritmoPrincipalGerador.fichas.put(ficha.getNick(), ficha);
    }
    
    public static void putFicha(Ficha ficha) {
        AlgoritmoPrincipalGerador.fichas.put(ficha.getNick(), ficha);
    }
    
//    public static boolean loadPersonagens() throws FileNotFoundException, IOException, ClassNotFoundException {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DIR_BATALHAS + "dataBase\\BD_Personagens.dat"))) {
//            per = (Map<String, Personagem>) ois.readObject();
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            JOptionPane.showMessageDialog(null, "Banco de Dados de Personagens não encontrado!", "No DataBase!",
//                    JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//    }
    
    public static boolean saveFicha(File folder) throws ClassNotFoundException {
        // IMPORTANT JOptionPane WARNING on subscribe ficha.dat file
        for (File file : folder.listFiles()) {
            String nick = file.getName();
            
            if (nick.equals(ficha.getNick() + ".dat")) {
                int confirm = JOptionPane.showConfirmDialog(null, "Deseja sobrescrever a ficha.dat original?", "Warning!",
                        JOptionPane.YES_NO_OPTION);
                
                switch (confirm) {
                    case JOptionPane.NO_OPTION:
                        return false;
                }
            }
        }
            
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                algoritmos.batalhas.AlgoritmoPrincipal.getDIR_FICHAS() + "\\" + ficha.getNick() + ".dat"))) {
            oos.writeObject(ficha);
            oos.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
//    public static boolean loadFichas() throws FileNotFoundException, IOException, ClassNotFoundException {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DIR_GERADOR + "dataBase\\BD_Fichas.dat"))) {
//            fichas = (Map<String, Ficha>) ois.readObject();
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            JOptionPane.showMessageDialog(null, "Banco de Dados de Fichas não encontrado!", "No DataBase!",
//                    JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//    }
    
//    public static boolean loadFichasDerivadas() throws FileNotFoundException, IOException, ClassNotFoundException {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DIR_GERADOR + "dataBase\\BD_Fichas_Derivadas.dat"))) {
//            fichasDerivadas = (Map<String, Ficha>) ois.readObject();
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            JOptionPane.showMessageDialog(null, "Banco de Dados de Fichas Derivadas não encontrado!", "No DataBase!",
//                    JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//    }
    
//    public static boolean saveFichas() {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DIR_GERADOR + "dataBase\\BD_Fichas.dat"))) {
//            oos.writeObject(fichas);
//            oos.close();
//            // temporario
//            /*for (String nome : fichas.keySet()) {
//                Ficha1 ficha1 = new Ficha1();
//                ficha1.setAltura(fichas.get(nome).getAltura());
//                ficha1.setAop(fichas.get(nome).getAop());
//                ficha1.setApr(fichas.get(nome).getApr());
//                ficha1.setAtrCar(fichas.get(nome).getAtrCar());
//                ficha1.setAtrCdn(fichas.get(nome).getAtrCdn());
//                ficha1.setAtrCon(fichas.get(nome).getAtrCon());
//                ficha1.setAtrDex(fichas.get(nome).getAtrDex());
//                ficha1.setAtrEms(fichas.get(nome).getAtrEms());
//                ficha1.setAtrEsp(fichas.get(nome).getAtrEsp());
//                ficha1.setAtrFor(fichas.get(nome).getAtrFor());
//                ficha1.setAtrInt(fichas.get(nome).getAtrInt());
//                ficha1.setAtrMan(fichas.get(nome).getAtrMan());
//                ficha1.setAtrMat(fichas.get(nome).getAtrMat());
//                ficha1.setAtrMen(fichas.get(nome).getAtrMen());
//                ficha1.setAtrRef(fichas.get(nome).getAtrRef());
//                ficha1.setAtrTrs(fichas.get(nome).getAtrTrs());
//                ficha1.setCoefHp(fichas.get(nome).getCoefHp());
//                ficha1.setCrt(fichas.get(nome).getCrt());
//                ficha1.setEn(fichas.get(nome).getEn());
//                ficha1.setEsq(fichas.get(nome).getEsq());
//                ficha1.setExp(fichas.get(nome).getExp());
//                ficha1.setExpBonus(fichas.get(nome).getExpBonus());
//                ficha1.setHpMax(fichas.get(nome).getHpMax());
//                ficha1.setIdade(fichas.get(nome).getIdade());
//                ficha1.setIni(fichas.get(nome).getIni());
//                ficha1.setIniCar(fichas.get(nome).getIniCar());
//                ficha1.setIniCon(fichas.get(nome).getIniCon());
//                ficha1.setIniDex(fichas.get(nome).getIniDex());
//                ficha1.setIniFor(fichas.get(nome).getIniFor());
//                ficha1.setIniInt(fichas.get(nome).getIniInt());
//                ficha1.setIniMen(fichas.get(nome).getIniMen());
//                ficha1.setLvl(fichas.get(nome).getLvl());
//                ficha1.setModCar(fichas.get(nome).getModCar());
//                ficha1.setModCdn(fichas.get(nome).getModCdn());
//                ficha1.setModClas(fichas.get(nome).getModClas());
//                ficha1.setModCon(fichas.get(nome).getModCon());
//                ficha1.setModDex(fichas.get(nome).getModDex());
//                ficha1.setModEms(fichas.get(nome).getModEms());
//                ficha1.setModEsp(fichas.get(nome).getModEsp());
//                ficha1.setModFor(fichas.get(nome).getModFor());
//                ficha1.setModInt(fichas.get(nome).getModInt());
//                ficha1.setModMan(fichas.get(nome).getModMan());
//                ficha1.setModMat(fichas.get(nome).getModMat());
//                ficha1.setModMen(fichas.get(nome).getModMen());
//                ficha1.setModRef(fichas.get(nome).getModRef());
//                ficha1.setModTrs(fichas.get(nome).getModTrs());
//                ficha1.setMop(fichas.get(nome).getMop());
//                ficha1.setMopMax(fichas.get(nome).getMopMax());
//                ficha1.setPerCar(fichas.get(nome).getPerCar());
//                ficha1.setPerCon(fichas.get(nome).getPerCon());
//                ficha1.setPerDex(fichas.get(nome).getPerDex());
//                ficha1.setPerFor(fichas.get(nome).getPerFor());
//                ficha1.setPerInt(fichas.get(nome).getPerInt());
//                ficha1.setPerMen(fichas.get(nome).getPerMen());
//                ficha1.setPeso(fichas.get(nome).getPeso());
//                ficha1.setProApr(fichas.get(nome).getProApr());
//                ficha1.setProCrt(fichas.get(nome).getProCrt());
//                ficha1.setProEsq(fichas.get(nome).getProEsq());
//                ficha1.setProIni(fichas.get(nome).getProIni());
//                ficha1.setProVel(fichas.get(nome).getProVel());
//                ficha1.setRyu(fichas.get(nome).getRyu());
//                ficha1.setTen(fichas.get(nome).getTen());
//                ficha1.setVel(fichas.get(nome).getVel());
//                ficha1.setbCar(fichas.get(nome).getbCar());
//                ficha1.setbCon(fichas.get(nome).getbCon());
//                ficha1.setbDex(fichas.get(nome).getbDex());
//                ficha1.setbFor(fichas.get(nome).getbFor());
//                ficha1.setbInt(fichas.get(nome).getbInt());
//                ficha1.setbMen(fichas.get(nome).getbMen());
//                ficha1.setClasse(fichas.get(nome).getClasse());
//                ficha1.setNome(fichas.get(nome).getNome());
//                ficha1.setNen(fichas.get(nome).getNen());
//                ficha1.setHunter(fichas.get(nome).getHunter());
//                ficha1.setTendencia(fichas.get(nome).getTendencia());
//                fichas1.put(nome, ficha1);
//            }
//            oos.writeObject(fichas1);
//            oos.close();*/
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            return false;
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
    
//    public static boolean loadPersonagensDerivados() throws FileNotFoundException, IOException, ClassNotFoundException {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DIR_BATALHAS + "dataBase\\BD_Personagens_derivados.dat"))) {
//            perDerivados = (Map<String, Personagem>) ois.readObject();
//            return true;
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            return false;
//        }
//    }
    
    public static Ficha loadFicha() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ficha.dat"))) {
            Ficha ficha = (Ficha) ois.readObject();
            AlgoritmoPrincipalGerador.putFicha(ficha);
            AlgoritmoPrincipalGerador.setFicha(ficha);
            return ficha;
        } catch (IOException e) {
            System.out.println(e.toString());
            return null;
        }
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
        // limpando fichas
        fichas.clear();
        
        // carregando fichas
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
    
//    public static boolean saveFicha(Ficha ficha) {
//        
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
    
//    public static void integrarPersonagensDerivados() {
//        for(String nome : perDerivados.keySet()) {
//            per.put(nome, perDerivados.get(nome));
//        }
//    }
//    
//    public static void integrarFichasDerivadas() {
//        for(String nome : fichasDerivadas.keySet()) {
//            fichas.put(nome, fichasDerivadas.get(nome));
//        }
//    }
}
