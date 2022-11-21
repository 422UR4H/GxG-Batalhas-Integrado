/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha_personagem;
import java.io.Serializable;

/**
 *
 * @author 422UR4H
 */
public class LvlExp implements Serializable {
    private int lvl;
    private int exp;
    
    
    // construtor
    public LvlExp() {
        lvl = 0;
        exp = 0;
    }
    
    
    public void putExp(int exp) {
        this.exp += exp;
    }
    
    public void incrementaLvl() {
        this.lvl++;
    }
    
    // getters e setters
    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
