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
public class LvlBonus implements Serializable {
    private int lvl;
    private int lvj;
    private int bonus;
    
    // construtor
    public LvlBonus() {
        lvl = lvj = 0;
        bonus = 1;
    }
    
    
    public void incrementaLvj() {
        this.lvj++;
        if (this.lvj > this.lvl) {
            this.lvj = 0;
            this.bonus = 1;
            this.lvl++;
        }
    }
    
    public void incrementaBonus() {
        this.bonus++;
    }
    
    // getters e setters
    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getLvj() {
        return lvj;
    }

    public void setLvj(int lvj) {
        this.lvj = lvj;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
