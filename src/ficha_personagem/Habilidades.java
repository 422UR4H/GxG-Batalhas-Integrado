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
public class Habilidades implements Serializable {
    private String nome, arma, dados, proficiencia; // essa proficiencia soma no dano
    private String descricao, descricaoBreve;
    private double restricao;
    private int dano, danoPorSegundo, auraBonus, turnoDps, decrescimoDpsPorTurno;
    private int qtd, vol, crt, danoFixo, acertoFixo;
    
    private int lvl, subLvl, bonus;
    
    private int qtdFor, qtdCon, qtdDex, qtdInt, qtdCar, qtdMen;
    private int qtdRef, qtdEms, qtdMan, qtdMat, qtdTrs, qtdEsp;
    private int qtdEsq, qtdVel, qtdTen, qtdAop, qtdMop, qtdCdn;
    
    private boolean perfurante, gastaAura, trs, mat, man, dps;
    private boolean rebote;
    
    private boolean somarFor, somarCon, somarDex, somarInt, somarCar, somarMen;
    private boolean somarRef, somarEms, somarMan, somarMat, somarTrs, somarEsp;
    private boolean somarEsq, somarVel, somarTen, somarAop, somarMop, somarCdn;
    
    // variaveis de AtkPad
    private int ryu;
    private boolean danoRebote, gastaRyu;
    
    
    public Habilidades() {
        nome = "NULL";
        dados = "";
        arma = "Nenhuma";
        proficiencia = "NENHUMA"; // por default, nenhuma pro soma no dano
        descricao = "";
        descricaoBreve = "";
        
        decrescimoDpsPorTurno = 0;
        danoPorSegundo = 0;
        turnoDps = 0;
        dps = false;
        
        dano = auraBonus = 0;
        lvl = subLvl = 0;
        bonus = 1;
        danoFixo = 0;
        qtd = 1;
        crt = 2;
        vol = 3;
        restricao = 1.0;
        
        perfurante = gastaAura = trs = mat = man = false;
        rebote = true;
        
        somarFor = somarCon = somarDex = somarInt = somarCar = somarMen = false;
        somarRef = somarEms = somarMan = somarMat = somarTrs = somarEsp = false;
        somarEsq = somarVel = somarTen = somarAop = somarMop = somarCdn = false;
        
        qtdFor = qtdCon = qtdDex = qtdInt = qtdCar = qtdMen = 0;
        qtdRef = qtdEms = qtdMan = qtdMat = qtdTrs = qtdEsp = 0;
        qtdEsq = qtdVel = qtdTen = qtdAop = qtdMop = qtdCdn = 0;
        
        // variaveis de atkPad
        ryu = 50;
        danoRebote = true;
        gastaRyu = false;
    }

    
    public void incrementaLvl() {
        this.lvl++;
    }
    
    public void incrementaSubLvl() {
        this.subLvl++;
        if (this.subLvl > this.lvl) {
            this.subLvl = 0;
            this.bonus = 1;
            this.lvl++;
        }
    }

    public int getRyu() {
        return ryu;
    }

    public void setRyu(int ryu) {
        this.ryu = ryu;
    }

    public boolean isDanoRebote() {
        return danoRebote;
    }

    public void setDanoRebote(boolean danoRebote) {
        this.danoRebote = danoRebote;
    }

    public boolean isGastaRyu() {
        return gastaRyu;
    }

    public void setGastaRyu(boolean gastaRyu) {
        this.gastaRyu = gastaRyu;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoBreve() {
        return descricaoBreve;
    }

    public void setDescricaoBreve(String descricaoBreve) {
        this.descricaoBreve = descricaoBreve;
    }
    
    public void incrementaBonus() {
        this.bonus++;
    }

    public int getDanoPorSegundo() {
        return danoPorSegundo;
    }

    public void setDanoPorSegundo(int danoPorSegundo) {
        this.danoPorSegundo = danoPorSegundo;
    }

    public int getTurnoDps() {
        return turnoDps;
    }

    public void setTurnoDps(int turnoDps) {
        this.turnoDps = turnoDps;
    }

    public int getDecrescimoDpsPorTurno() {
        return decrescimoDpsPorTurno;
    }

    public void setDecrescimoDpsPorTurno(int decrescimoDpsPorTurno) {
        this.decrescimoDpsPorTurno = decrescimoDpsPorTurno;
    }

    public boolean isDps() {
        return dps;
    }

    public void setDps(boolean dps) {
        this.dps = dps;
    }
    
    public int getSubLvl() {
        return subLvl;
    }

    public void setSubLvl(int subLvl) {
        this.subLvl = subLvl;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    
    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public int getCrt() {
        return crt;
    }

    public void setCrt(int crt) {
        this.crt = crt;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public String getProficiencia() {
        return proficiencia;
    }

    public void setProficiencia(String proficiencia) {
        this.proficiencia = proficiencia;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getDanoFixo() {
        return danoFixo;
    }

    public void setDanoFixo(int danoFixo) {
        this.danoFixo = danoFixo;
    }
    
    public int getAcertoFixo() {
        return acertoFixo;
    }

    public void setAcertoFixo(int acertoFixo) {
        this.acertoFixo = acertoFixo;
    }
    
    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

    public boolean isSomarCon() {
        return somarCon;
    }

    public void setSomarCon(boolean somarCon) {
        this.somarCon = somarCon;
    }

    public boolean isSomarDex() {
        return somarDex;
    }

    public void setSomarDex(boolean somarDex) {
        this.somarDex = somarDex;
    }

    public boolean isSomarInt() {
        return somarInt;
    }

    public void setSomarInt(boolean somarInt) {
        this.somarInt = somarInt;
    }

    public boolean isSomarCar() {
        return somarCar;
    }

    public void setSomarCar(boolean somarCar) {
        this.somarCar = somarCar;
    }

    public boolean isSomarMen() {
        return somarMen;
    }

    public void setSomarMen(boolean somarMen) {
        this.somarMen = somarMen;
    }

    public boolean isSomarRef() {
        return somarRef;
    }

    public void setSomarRef(boolean somarRef) {
        this.somarRef = somarRef;
    }

    public boolean isSomarEms() {
        return somarEms;
    }

    public void setSomarEms(boolean somarEms) {
        this.somarEms = somarEms;
    }

    public boolean isSomarMan() {
        return somarMan;
    }

    public void setSomarMan(boolean somarMan) {
        this.somarMan = somarMan;
    }

    public boolean isSomarMat() {
        return somarMat;
    }

    public void setSomarMat(boolean somarMat) {
        this.somarMat = somarMat;
    }

    public boolean isSomarTrs() {
        return somarTrs;
    }

    public void setSomarTrs(boolean somarTrs) {
        this.somarTrs = somarTrs;
    }

    public boolean isSomarEsp() {
        return somarEsp;
    }

    public void setSomarEsp(boolean somarEsp) {
        this.somarEsp = somarEsp;
    }

    public boolean isSomarEsq() {
        return somarEsq;
    }

    public void setSomarEsq(boolean somarEsq) {
        this.somarEsq = somarEsq;
    }

    public boolean isSomarVel() {
        return somarVel;
    }

    public void setSomarVel(boolean somarVel) {
        this.somarVel = somarVel;
    }

    public boolean isSomarTen() {
        return somarTen;
    }

    public void setSomarTen(boolean somarTen) {
        this.somarTen = somarTen;
    }

    public boolean isSomarAop() {
        return somarAop;
    }

    public void setSomarAop(boolean somarAop) {
        this.somarAop = somarAop;
    }

    public boolean isSomarMop() {
        return somarMop;
    }

    public void setSomarMop(boolean somarMop) {
        this.somarMop = somarMop;
    }

    public boolean isSomarCdn() {
        return somarCdn;
    }

    public void setSomarCdn(boolean somarCdn) {
        this.somarCdn = somarCdn;
    }

    public int getQtdFor() {
        return qtdFor;
    }

    public void setQtdFor(int qtdFor) {
        this.qtdFor = qtdFor;
    }

    public int getQtdCon() {
        return qtdCon;
    }

    public void setQtdCon(int qtdCon) {
        this.qtdCon = qtdCon;
    }

    public int getQtdDex() {
        return qtdDex;
    }

    public void setQtdDex(int qtdDex) {
        this.qtdDex = qtdDex;
    }

    public int getQtdInt() {
        return qtdInt;
    }

    public void setQtdInt(int qtdInt) {
        this.qtdInt = qtdInt;
    }

    public int getQtdCar() {
        return qtdCar;
    }

    public void setQtdCar(int qtdCar) {
        this.qtdCar = qtdCar;
    }

    public int getQtdMen() {
        return qtdMen;
    }

    public void setQtdMen(int qtdMen) {
        this.qtdMen = qtdMen;
    }

    public int getQtdRef() {
        return qtdRef;
    }

    public void setQtdRef(int qtdRef) {
        this.qtdRef = qtdRef;
    }

    public int getQtdEms() {
        return qtdEms;
    }

    public void setQtdEms(int qtdEms) {
        this.qtdEms = qtdEms;
    }

    public int getQtdMan() {
        return qtdMan;
    }

    public void setQtdMan(int qtdMan) {
        this.qtdMan = qtdMan;
    }

    public int getQtdMat() {
        return qtdMat;
    }

    public void setQtdMat(int qtdMat) {
        this.qtdMat = qtdMat;
    }

    public int getQtdTrs() {
        return qtdTrs;
    }

    public void setQtdTrs(int qtdTrs) {
        this.qtdTrs = qtdTrs;
    }

    public int getQtdEsp() {
        return qtdEsp;
    }

    public void setQtdEsp(int qtdEsp) {
        this.qtdEsp = qtdEsp;
    }

    public int getQtdEsq() {
        return qtdEsq;
    }

    public void setQtdEsq(int qtdEsq) {
        this.qtdEsq = qtdEsq;
    }

    public int getQtdVel() {
        return qtdVel;
    }

    public void setQtdVel(int qtdVel) {
        this.qtdVel = qtdVel;
    }

    public int getQtdTen() {
        return qtdTen;
    }

    public void setQtdTen(int qtdTen) {
        this.qtdTen = qtdTen;
    }

    public int getQtdAop() {
        return qtdAop;
    }

    public void setQtdAop(int qtdAop) {
        this.qtdAop = qtdAop;
    }

    public int getQtdMop() {
        return qtdMop;
    }

    public void setQtdMop(int qtdMop) {
        this.qtdMop = qtdMop;
    }

    public int getQtdCdn() {
        return qtdCdn;
    }

    public void setQtdCdn(int qtdCdn) {
        this.qtdCdn = qtdCdn;
    }
    
    public boolean isMat() {
        return mat;
    }

    public void setMat(boolean mat) {
        this.mat = mat;
    }

    public void setTrs(boolean trs) {
        this.trs = trs;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public boolean isRebote() {
        return rebote;
    }

    public void setRebote(boolean rebote) {
        this.rebote = rebote;
    }

    public boolean isGastaAura() {
        return gastaAura;
    }

    public void setGastaAura(boolean gastaAura) {
        this.gastaAura = gastaAura;
    }

    public boolean isPerfurante() {
        return perfurante;
    }

    public void setPerfurante(boolean perfurante) {
        this.perfurante = perfurante;
    }

    public boolean isTrs() {
        return trs;
    }

    public boolean isSomarFor() {
        return somarFor;
    }

    public void setSomarFor(boolean somarFor) {
        this.somarFor = somarFor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public void setAuraBonus(int auraBonus) {
        this.auraBonus = auraBonus;
    }

    public void setRestricao(double restricao) {
        this.restricao = restricao;
    }

    public int getDano() {
        return dano;
    }

    public int getDano(int dado) {
        return dano + dado;
    }

    public int getVol() {
        return vol;
    }

    public int getAuraBonus() {
        return auraBonus;
    }
    
    public double getRestricao() {
        return restricao;
    }
}
