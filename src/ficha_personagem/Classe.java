/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha_personagem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author 422UR4H
 */
public class Classe {
    private int bFor, bCon, bDex, bInt, bCar, bMen;
    private int bCrt, bApr;
    private int bVel, bEsq;
    private int bIni, bHp;
    private int tamBLivre;
    private int bProLivre;
    private boolean sortePorLvl;
    private final Vector<Integer> bLivre;
    private final Map<String, Integer> bPro;
    
    
    // construtor
    public Classe() {
        this.bLivre = new Vector<>();
        this.bPro = new HashMap<>();
        bFor = 0;
        bCon = 0;
        bDex = 0;
        bInt = 0;
        bCar = 0;
        bMen = 0;
        bCrt = 0;
        bVel = 0;
        bApr = 0;
        bEsq = 0;
        bProLivre = 0;
        tamBLivre = 0;
        sortePorLvl = false;
    }
    
    public void resetClasse() {
        this.bLivre.removeAllElements();
        this.bPro.clear();
        bFor = 0;
        bCon = 0;
        bDex = 0;
        bInt = 0;
        bCar = 0;
        bMen = 0;
        bCrt = 0;
        bVel = 0;
        bApr = 0;
        bEsq = 0;
        bProLivre = 0;
        tamBLivre = 0;
        sortePorLvl = false;
    }
    
    // getters e setters
    
    public int getSomaBonus() {
        int soma = 0;
        for (int i = 0; i < bLivre.size(); i++) {
            soma += this.bLivre.get(i);
        }
        return soma;
    }

    
    public int getbHp() {
        return bHp;
    }

    public void setbHp(int bHp) {
        this.bHp = bHp;
    }
    
    public int getbIni() {
        return bIni;
    }

    public void setbIni(int bIni) {
        this.bIni = bIni;
    }

    public boolean isSortePorLvl() {
        return sortePorLvl;
    }

    public void setSortePorLvl(boolean sortePorLvl) {
        this.sortePorLvl = sortePorLvl;
    }
    
    public void putbPro(String nome, int valor) {
        this.bPro.put(nome, valor);
    }

    public int getbPro(String nome) {
        return this.bPro.get(nome);
    }

    public int getbProLivre() {
        return bProLivre;
    }

    public void setbProLivre(int bProLivre) {
        this.bProLivre = bProLivre;
    }
    
    public void addBLivre(int i) {
        this.bLivre.add(i);
        tamBLivre++;
    }
    
    public int getBLivre(int i) {
        return this.bLivre.get(i);
    }

    public int getbVel() {
        return bVel;
    }

    public void setbVel(int bVel) {
        this.bVel = bVel;
    }

    public int getbEsq() {
        return bEsq;
    }

    public void setbEsq(int bEsq) {
        this.bEsq = bEsq;
    }

    public int getbFor() {
        return bFor;
    }

    public void setbFor(int bFor) {
        this.bFor = bFor;
    }

    public int getbCon() {
        return bCon;
    }

    public void setbCon(int bCon) {
        this.bCon = bCon;
    }

    public int getbDex() {
        return bDex;
    }

    public void setbDex(int bDex) {
        this.bDex = bDex;
    }

    public int getbInt() {
        return bInt;
    }

    public void setbInt(int bInt) {
        this.bInt = bInt;
    }

    public int getbCar() {
        return bCar;
    }

    public void setbCar(int bCar) {
        this.bCar = bCar;
    }

    public int getbMen() {
        return bMen;
    }

    public void setbMen(int bMen) {
        this.bMen = bMen;
    }

    public int getbCrt() {
        return bCrt;
    }

    public void setbCrt(int bCrt) {
        this.bCrt = bCrt;
    }

    public int getbApr() {
        return bApr;
    }

    public void setbApr(int bApr) {
        this.bApr = bApr;
    }

    public int getTamBLivre() {
        return this.tamBLivre;
    }
    
    public int getSizeBLivre() {
        return this.bLivre.size();
    }
    
    public Set<String> proKeySet() {
        return bPro.keySet();
    }

}
