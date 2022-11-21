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
public class InfoPerson implements Serializable {
    private String nick;
    private int hp;
    private int mop;

    
    
    public InfoPerson(){}
    
    public InfoPerson(String nick, int hp, int mop) {
        this.nick = nick;
        this.mop = mop;
        this.hp = hp;
    }
    
    
    // getters e setters
    
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMop() {
        return mop;
    }

    public void setMop(int mop) {
        this.mop = mop;
    }
}
