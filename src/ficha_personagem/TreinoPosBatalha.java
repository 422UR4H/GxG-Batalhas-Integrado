/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha_personagem;

import java.util.Vector;

/**
 *
 * @author 422UR4H
 */
public class TreinoPosBatalha {
    private String nick;
    private int ref, ems, mat, man, trs, esp, cdn;
    private int ten, ryu, en, aop, mop, zts;
    private Vector<String> pro = new Vector<>();
    private Vector<String> per = new Vector<>();
    private Vector<String> hab = new Vector<>();

    
    // construtor
    public TreinoPosBatalha() {
        ref = ems = mat = man = trs = esp = cdn = 0;
        ten = ryu = en = aop = mop = zts = 0;
    }
    
    
    public boolean contaisPro(String nome) {
        return this.pro.contains(nome);
    }
    
    public boolean contaisPer(String nome) {
        return this.per.contains(nome);
    }
    
    public boolean contaisHab(String nome) {
        return this.hab.contains(nome);
    }
    
    public void addPro(String nome) {
        pro.add(nome);
    }

    public void addPer(String nome) {
        per.add(nome);
    }

    public void addHab(String nome) {
        hab.add(nome);
    }

    public Vector<String> getPro() {
        return pro;
    }

    public Vector<String> getPer() {
        return per;
    }

    public Vector<String> getHab() {
        return hab;
    }
    
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getRef() {
        return ref;
    }

    public void addRef() {
        this.ref++;
    }
    
    public void subRef() {
        this.ref--;
    }
    
    public int getEms() {
        return ems;
    }

    public void addEms() {
        this.ems++;
    }

    public void subEms() {
        this.ems--;
    }
    
    public int getMat() {
        return mat;
    }

    public void addMat() {
        this.mat++;
    }
    
    public void subMat() {
        this.mat--;
    }

    public int getMan() {
        return man;
    }

    public void addMan() {
        this.man++;
    }

    public void subMan() {
        this.man--;
    }

    public int getTrs() {
        return trs;
    }

    public void addTrs() {
        this.trs++;
    }

    public void subTrs() {
        this.trs--;
    }

    public int getEsp() {
        return esp;
    }

    public void addEsp() {
        this.esp++;
    }

    public void subEsp() {
        this.esp--;
    }

    public int getCdn() {
        return cdn;
    }

    public void addCdn() {
        this.cdn++;
    }

    public void subCdn() {
        this.cdn--;
    }

    public int getTen() {
        return ten;
    }

    public void addTen() {
        this.ten++;
    }

    public void subTen() {
        this.ten--;
    }

    public int getRyu() {
        return ryu;
    }

    public void addRyu() {
        this.ryu++;
    }

    public void subRyu() {
        this.ryu--;
    }

    public int getEn() {
        return en;
    }

    public void addEn() {
        this.en++;
    }

    public void subEn() {
        this.en--;
    }

    public int getAop() {
        return aop;
    }

    public void addAop() {
        this.aop++;
    }

    public void subAop() {
        this.aop--;
    }

    public int getMop() {
        return mop;
    }

    public void addMop() {
        this.mop++;
    }

    public void subMop() {
        this.mop--;
    }

    public int getZts() {
        return zts;
    }

    public void addZts() {
        this.zts++;
    }
    
    public void subZts() {
        this.zts--;
    }

    public boolean isRef() {
        return ref > 0;
    }
    
    public boolean isEms() {
        return ems > 0;
    }
    
    public boolean isMat() {
        return mat > 0;
    }
    
    public boolean isMan() {
        return man > 0;
    }
    
    public boolean isTrs() {
        return trs > 0;
    }
    
    public boolean isEsp() {
        return esp > 0;
    }
    
    public boolean isCdn() {
        return cdn > 0;
    }
    
    public boolean isTen() {
        return ten > 0;
    }
    
    public boolean isRyu() {
        return ryu > 0;
    }
    
    public boolean isEn() {
        return en > 0;
    }
    
    public boolean isAop() {
        return aop > 0;
    }
    
    public boolean isMop() {
        return mop > 0;
    }
    
    public boolean isZts() {
        return zts > 0;
    }
    
    public void zerarRef() {
        this.ref = 0;
    }
    
    public void zerarEms() {
        this.ems = 0;
    }
    
    public void zerarTrs() {
        this.trs = 0;
    }
    
    public void zerarMat() {
        this.mat = 0;
    }
    
    public void zerarMan() {
        this.man = 0;
    }
    
    public void zerarEsp() {
        this.esp = 0;
    }
    
    public void zerarCdn() {
        this.cdn = 0;
    }
    
    public void zerarTen() {
        this.ten = 0;
    }
    
    public void zerarRyu() {
        this.ryu = 0;
    }
    
    public void zerarEn() {
        this.en = 0;
    }
    
    public void zerarAop() {
        this.aop = 0;
    }
    
    public void zerarMop() {
        this.mop = 0;
    }
    
    public void zerarZts() {
        this.zts = 0;
    }
}
