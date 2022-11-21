/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.batalhas;

/**
 *
 * @author 422UR4H
 */
public class EstatisticasDeBatalha {
    public int dano;
    public int hp;

    
    // construtores
    public EstatisticasDeBatalha() {
        
    }
    public EstatisticasDeBatalha(int hp, int dano) {
        this.hp = hp;
        this.dano = dano;
    }
    
    
    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        if (dano > 0) {
            this.dano = dano;
        } else {
            this.dano = 0;
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public void reduzHp(int dano) {
        this.hp -= dano;
    }
    
    public void reduzHp() {
        this.hp -= dano;
    }
}
