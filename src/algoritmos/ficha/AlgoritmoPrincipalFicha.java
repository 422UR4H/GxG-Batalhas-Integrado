/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.ficha;

import ficha_personagem.Classes;
import ficha_personagem.Ficha;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 422UR4H
 */
public class AlgoritmoPrincipalFicha {
    private static final int EXP_LVL_MAX = 80; // dobro do máximo para evitar erros
    private static final int EXP_NEN_MAX = 200; // dobro do máximo para evitar erros
    private static final int LVL_NEN_MAX = 200; // dobro do máximo para evitar erros
    private static final int EXP_LVL[] = new int[EXP_LVL_MAX];
    private static final int EXP_NEN[] = new int[EXP_NEN_MAX];
    private static final int LVL_NEN[] = new int[LVL_NEN_MAX];
    private static Ficha ficha;
    private static String text;
    private static char c;

    
    
    public static boolean init() throws IOException, FileNotFoundException, ClassNotFoundException {
        if (!loadTabelasExp()) {
            return false;
        }
        // carregando Classes
        Classes.init();
        
        CalculadoraFicha.setEXP_LVL(EXP_LVL);
        CalculadoraFicha.setEXP_NEN(EXP_NEN);
        CalculadoraFicha.setLVL_NEN(LVL_NEN);
        
        return true;
    }
    
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
                while (i < AlgoritmoPrincipalFicha.getEXP_LVL_MAX()) {
                    EXP_LVL[i] = EXP_LVL[i - 1];
                    i++;
                }
            }
        } catch (IOException e) {
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
                while (i < AlgoritmoPrincipalFicha.getEXP_NEN_MAX()) {
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
                while (i < AlgoritmoPrincipalFicha.getLVL_NEN_MAX()) {
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
    
    public static int getEXP_LVL_MAX() {
        return EXP_LVL_MAX;
    }

    public static int getEXP_NEN_MAX() {
        return EXP_NEN_MAX;
    }

    public static int getLVL_NEN_MAX() {
        return LVL_NEN_MAX;
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
    
    public static Ficha getFicha() {
        return ficha;
    }

    public static void setFicha(Ficha ficha) {
        AlgoritmoPrincipalFicha.ficha = ficha;
    }

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        AlgoritmoPrincipalFicha.text = text;
    }

    public static char getC() {
        return c;
    }

    public static void setC(char c) {
        AlgoritmoPrincipalFicha.c = c;
    }
    
    public static int gastoRyuExcedente(int ryu, int nivelCdn) {
        int gasto = (int) (Math.round(((double) ryu - 50.0) / 10.0) - nivelCdn);
        if (gasto > 0) {
            return gasto;
        }
        return 0;
    }
    
    public static int calculaGastoRyu(int ryu, int aop, int qtd, int volume, int auraBonus) {
        // o raciocinio está em arquivos publicos -> "atuualizações e regras do sistema" ->
        // -> "raciocinio do calculo do gasto de aura.txt"
        if (ryu == 50) {
            // o 1.0 serve para converter aop em double, que converte volume em double logo após
            return (int) (50 * qtd * (auraBonus + 1.0 * aop * volume / 100.0));
        }
        // else (ryu != 50) --- 1.0 tem a mesma serventia do algoritmo anterior
        return (int) (50 * qtd * (auraBonus + 1.0 * aop * ryu / 100));
    }
    
    public static double getPop(int ref, String nen) {
        double modClas = 1.0;
        switch (nen) {
            case "Reforco" :
                modClas = 1.0;
                break;
            case "Emissao" :
                modClas = 0.8;
                break;
            case "Transformacao" :
                modClas = 0.8;
                break;
            case "Materializacao" :
                modClas = 0.6;
                break;
            case "Manipulacao" :
                modClas = 0.6;
                break;
            case "Especialista" :
                modClas = 0.4;
                break;
        }
        return 1 + (Math.floor(modClas * ref) / 10.0);
    }
    
    public static double getRyu(int ryu, int corpo, double ren) {
        return ren * ryu / (double) corpo;
    }
    
    public static int getRen(Ficha ficha, int ryu, String nen) {
        double pop = getPop(ficha.getAtrRef(), nen);
        int aop = ficha.getAop();
        double ryuCalculado = getRyu(ryu, ficha.getCorpo().getValor(), pop * aop);
        return (int) ryuCalculado;
    }
}
