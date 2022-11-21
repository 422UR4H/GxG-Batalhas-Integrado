/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.trainer;

import algoritmos.habilidades.CalculadoraHabilidades;
import ficha_personagem.Ficha;
import ficha_personagem.Habilidades;
import ficha_personagem.LvlExp;

/**
 *
 * @author 422UR4H
 */
public class CalculadoraTrainer {
    private static double modClas = 1.0;
    private static int pontos;
    private static int EXP_LVL[] = new int[AlgoritmoPrincipalTrainer.getEXP_LVL_MAX()];
    private static int EXP_NEN[] = new int[AlgoritmoPrincipalTrainer.getEXP_NEN_MAX()];
    private static int LVL_NEN[] = new int[AlgoritmoPrincipalTrainer.getLVL_NEN_MAX()];
    
    
    public static void incrementarPontos() {
        pontos++;
    }
    
    public static void decrementarPontos() {
        pontos--;
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
    
    public static int getExpMop(int lvl) {
        int exp = 0;
        for (int i = 2; i <= lvl; i++) {
            exp = i * 10 + 80;
        }
        return exp;
    }
    
    public static void recalcularHabilidades(Ficha ficha) {
        for (String nome : ficha.getHabilidades().keySet()) {
            Habilidades habilidade = ficha.getHabilidade(nome);
            habilidade.setDano(CalculadoraHabilidades.calculaDano(ficha, habilidade));
        }
    }
    
    public static boolean putExpFicha(int exp, Ficha ficha) {
        ficha.putExp(exp);
        if (ficha.getExp() > EXP_LVL[ficha.getLvl() + 1]) {
            ficha.setExp(ficha.getExp() - EXP_LVL[ficha.getLvl() + 1]);
            ficha.incrementaLvl();
            recalcularHabilidades(ficha);
            
            return true;
        }
        return false;
    }
    
    public static boolean putExpLvlNen(int exp, Ficha ficha) {
        ficha.putExpNen(exp);
        if (ficha.getExpNen() > LVL_NEN[ficha.getLvlNen() + 1]) {
            ficha.setExpNen(ficha.getExpNen() - LVL_NEN[ficha.getLvlNen() + 1]);
            ficha.incrementaLvlNen();
            
            return true;
        }
        return false;
    }
    
    public static boolean putExpNen(int exp, LvlExp lvlExp) {
        System.out.println("exp antes " + exp);
        lvlExp.putExp((int) ((double) exp * modClas));
        System.out.println("exp depois " + (int) ((double) exp * modClas));
        if (lvlExp.getExp() > EXP_NEN[lvlExp.getLvl() + 1]) {
            lvlExp.setExp(lvlExp.getExp() - EXP_NEN[lvlExp.getLvl() + 1]);
            lvlExp.incrementaLvl();
            
            return true;
        }
        return false;
    }
    
    public static boolean putExpMop(int exp, LvlExp lvlExp) {
        lvlExp.putExp(exp);
        if (lvlExp.getExp() > ((lvlExp.getLvl() + 1) * 10 + 80) ) {
            lvlExp.setExp(lvlExp.getExp() - ((lvlExp.getLvl() + 1) * 10 + 80) );
            lvlExp.incrementaLvl();
            
            return true;
        }
        return false;
    }
    

    // getters e setters

    public static double getModClas() {    
        return modClas;
    }
    
    public static void setModClas(double modClas) {    
        CalculadoraTrainer.modClas = modClas;
    }

    public static int getPontos() {
        return pontos;
    }

    public static int[] getLVL_NEN() {
        return LVL_NEN;
    }

    public static void setLVL_NEN(int[] LVL_NEN) {
        CalculadoraTrainer.LVL_NEN = LVL_NEN;
    }

    public static void setPontos(int pontos) {
        CalculadoraTrainer.pontos = pontos;
    }

    public static void setEXP_LVL(int[] EXP_LVL) {
        CalculadoraTrainer.EXP_LVL = EXP_LVL;
    }

    public static void setEXP_NEN(int[] EXP_NEN) {
        CalculadoraTrainer.EXP_NEN = EXP_NEN;
    }
    public static int getRen(int ref, int aop, int ten) {
        if (ten < aop) {
            aop = ten;
        }
        return (ref / 10 + 1) * aop;
    }
}
