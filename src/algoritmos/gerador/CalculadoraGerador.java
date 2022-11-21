/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.gerador;

/**
 *
 * @author 422UR4H
 */
public class CalculadoraGerador {
    private static int pontos;
    private static int EXP_LVL[] = new int[AlgoritmoPrincipalGerador.getEXP_LVL_MAX()];
    private static int EXP_NEN[] = new int[AlgoritmoPrincipalGerador.getEXP_NEN_MAX()];
    private static int LVL_NEN[] = new int[AlgoritmoPrincipalGerador.getLVL_NEN_MAX()];
    
    
    // getters e setters
    public static void incrementarPontos() {
        pontos++;
    }
    
    public static void decrementarPontos() {
        pontos--;
    }
    
    public static int getPontos() {
        return pontos;
    }

    public static void setPontos(int pontos) {
        CalculadoraGerador.pontos = pontos;
    }

    public static void setEXP_LVL(int[] EXP_LVL) {
        CalculadoraGerador.EXP_LVL = EXP_LVL;
    }

    public static void setEXP_NEN(int[] EXP_NEN) {
        CalculadoraGerador.EXP_NEN = EXP_NEN;
    }

    public static void setLVL_NEN(int[] LVL_NEN) {
        CalculadoraGerador.LVL_NEN = LVL_NEN;
    }
    
    public static int calculaLvlNen(int exp) {
        // calculando lvlNen
        int i;
        for (i = 0; exp >= 0; i++) {
            exp -= AlgoritmoPrincipalGerador.getLVL_NEN(i + 1);
        }
        i--;
        // exp que sobra
//        exp += AlgoritmoPrincipalGerador.getLVL_NEN(i + 1);
        return i;
    }
    
    public static int calculaExpLvlNen(int lvl) {
        int exp = 0;
        // a posição 0 do vetor tem o valor 0, logo nao conta
        for (int i = 1; i <= lvl; i++) {
            exp += LVL_NEN[i];
        }
        return exp;
    }
    
    public static int calculaExp(int lvl) {
        int exp = 0;
        // a posição 0 do vetor tem o valor 0, logo nao conta
        for (int i = 1; i <= lvl; i++) {
            exp += EXP_NEN[i];
        }
        return exp;
    }
    
    public static int calculaExpMop(int lvl) {
        int exp = 0;
        for (int i = 2; i <= lvl; i++) {
            exp += i * 10 + 80;
        }
        return exp;
    }
    
    public static int getRen(double refPratico, int aop, int ten) {
        if (ten < aop) {
            aop = ten;
        }
        return (int) ((refPratico / 10 + 1) * aop);
    }
}
