/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha_personagem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 422UR4H
 */
public class Personagem implements Serializable {
    private String nome = "NULL";
    private double modClas = 0.8;
    private int hpAtual = 0, hpMaximo = 0, mopAtual = 1000, mopMaximo = 1000, aop = 0, ref = 0;
    private int ten = 0, modFor = 0, perCon = 0, qtdAtaques = 0, shu = 0;
    private int cdn = 0, stun = 0, velKm = 10;
    private boolean desmaiado = false;
    private Corpo corpo = new Corpo();
    private Map<String, Habilidades> habilidade = new HashMap<>();

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHpMaximo(int hpMaximo) {
        this.hpMaximo = hpMaximo;
    }

    public void setMopMaximo(int mopMaximo) {
        this.mopMaximo = mopMaximo;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public Personagem() {
        // CONSTRUTOR
    }
    
    /*public void putHabilidades(String nome, Habilidades dados) {
        habilidade.put(nome, dados);
    }*/
    
    public void putHabilidades(Habilidades habilidade) {
        this.habilidade.put(habilidade.getNome(), habilidade);
    }
    
    public void removeHabilidades(Habilidades habilidade) {
        if (this.habilidade.remove(habilidade.getNome(), habilidade)) {
            qtdAtaques--;
        }
    }
    
    public void editHabilidades(Habilidades habilidade, String remover) {
        this.habilidade.remove(remover);
        this.habilidade.put(habilidade.getNome(), habilidade);
    }
    
    public void incrementarShu() {
        this.shu++;
    }
    
    public void decrementarShu() {
        this.shu--;
    }

    public boolean isDesmaiado() {
        return desmaiado;
    }

    public void setDesmaiado(boolean desmaiado) {
        this.desmaiado = desmaiado;
    }
    
    
    // SETTERS
    
    public void setModClas(double modClas) {
        this.modClas = modClas;
    }

    public void setPerCon(int perCon) {
        this.perCon = perCon;
    }
    
    public void setStun(int stun) {
        if (stun < 0) {
            this.stun = 0;
        }
        this.stun = stun;
    }
    
    public boolean addStun(int valor) {
        if (valor < 0)  return false;
        this.stun += valor;
        return true;
    }
    
    // entre com valor negativo
    public boolean reduzStun(int valor) {
        if (valor > 0)  return false;
        this.stun += valor;
        if (this.stun < 0) {
            this.stun = 0;
        }
        return true;
    }

    public void setHpAtual(int hpAtual) {
        this.hpAtual = hpAtual;
    }

    public int setMop(int mop) {
        if (mop < 0) {
            this.mopAtual = 0;            
// devolvemos uma quantidade positiva de mop como
// aop a ser reduzido do personagem
            return (int) Math.round((double) -mop / 50.0);
        }
        this.mopAtual = mop;
        return 0;
    }

    public void setAop(int aop) {
        this.aop = aop;
    }

    public void setCdn(int cdn) {
        this.cdn = cdn;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public void setModFor(int modFor) {
        this.modFor = modFor;
    }

    public void setVelKm(int velKm) {
        this.velKm = velKm;
    }

    public void setShu(int shu) {
        this.shu = shu;
    }
    
    public void setHabilidade(Habilidades habilidade) {
        // adicionando nova habilidade
        this.habilidade.put(habilidade.getNome(), habilidade);
    }
    
    public void setHabilidades(Map<String, Habilidades> habilidades) {
        this.habilidade = habilidades;
    }
    
    // NAO CRIAR UM SETTER DE qtdAtaques
    // ao inves disso, criar uma funcao
    // que cria um ataque e uma que
    // deleta um ataque, logo ela se
    // preocupara com o incremento ou
    // decremento de qtdAtaques
    
    // END setters


    // GETTERS
    
    public int getRef() {
        return ref;
    }

    public Corpo getCorpo() {
        return corpo;
    }
    
    public String getNome() {
        return nome;
    }

    public double getModClas() {
        return modClas;
    }

    public int getPerCon() {
        return perCon;
    }

    public int getStun() {
        return stun;
    }

    public int getHpAtual() {
        return hpAtual;
    }

    public int getHpMaximo() {
        return hpMaximo;
    }

    public int getMopAtual() {
        return mopAtual;
    }

    public int getMopMaximo() {
        return mopMaximo;
    }

    public int getAop() {
        return aop;
    }

    public double getPop() {
        return 1 + (double) ref / 10.0;
    }

    public int getCdn() {
        return cdn;
    }

    public int getModFor() {
        return modFor;
    }

    public int getQtdAtaques() {
        return qtdAtaques;
    }

    public int getShu() {
        return shu;
    }
    
    public int getTen() {
        return ten;
    }
    
    public Map<String, Habilidades> getHabilidades() {
        return habilidade;
    }
    
    public Habilidades getHabilidade(String nome) {
        if (nome.equals("FISICO")) {
            Habilidades skill = new Habilidades();
            skill.setDano(modFor);
            skill.setNome("FISICO");
            skill.setVol(3);
            return skill;
        }
        return this.habilidade.get(nome);
    }
    
    public int getVelKm() {
        return velKm;
    }
    
    public int getVelMs() {
        return (int) Math.floor((double) velKm / 3.6);
    }
    
    public double getRyu(int ryu, double nen) {
        return (double) ryu * nen / (double) corpo.getValor();
    }
    
    public int getKen(int ryu, int auraBonus) {
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("ryu " + ryu + " aura bonus " + auraBonus);
        System.out.println("modClas " + modClas + " aop " + aop);
        System.out.println("getPop() " + getPop() + " this " + this.getRyu(ryu, aop * getPop()));
        System.out.println("return " + Math.floor(modClas * ((aop + auraBonus) * (double) this.getRyu(ryu, aop * getPop()) / 100.0)));
        System.out.println("++++++++++++++++++++++++++++++++++++");
        return (int) Math.floor(modClas * ((aop + auraBonus) * (double) this.getRyu(ryu, aop * getPop()) / 100.0));
    }
    
    public int getKen(int ryu, Habilidades habilidade) {
        int auraBonus = habilidade.getAuraBonus();
        return (int) Math.floor(modClas * ((aop + auraBonus) * this.getRyu(ryu, aop * getPop())));
    }

    // END getters
}
