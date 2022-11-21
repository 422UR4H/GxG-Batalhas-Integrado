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
public class Ficha implements Serializable {
    // valores iniciais de atributos
    private static final int VEL_INICIAL = 15;
    private static final int ESQ_INICIAL = 15;
    private static final int HP_INICIAL = 15;
    
    // formulario do personagem
    private String nick, nome, classe, nen;
    private String tendencia, hunter;
    private double dias;
    private double altura, peso;
    private int idade;
    private String inventario;
    private String descricao, descricaoBreve;
    private String atkPad, defPad;
    
    // atributos fisicos
    private int iniFor, iniCon, iniDex, iniInt, iniCar, iniMen;
    private int valFor, valCon, valDex, valInt, valCar, valMen;
    private int modFor, modCon, modDex, modInt, modCar, modMen;
    private int bFor, bCon, bDex, bInt, bCar, bMen;
    private int perFor, perCon, perDex, perInt, perCar, perMen;
    
    // atributos nen
    private final Map<String, LvlExp> atr = new HashMap<>();
    private int modRef, modEms, modMat, modMan, modTrs, modEsp, modCdn;
    
    // atributos gerados
    private int coefHp;
    private int lvl, exp, expBonus;
    private int lvlNen, expNen, expBonusNen;
    private int hpMax, mopMax, hpNegMax;
    private int hpAtual, mopAtual, hpNegAtual;
    private int ini, esq, apr, crt, vel;
    private int bIntCdn;
    private int sorte, sorteDiaria;
    private double modClas;
    private boolean sortePorLvl;
    private boolean personagemDeJogador;
    private boolean criaturaDoMestre;
    
    // proficiencias e perícias
    private final Map<String, LvlBonus> pro = new HashMap<>();
    private final Map<String, LvlBonus> per = new HashMap<>();
    
    // habilidades
    private final Map<String, Habilidades> habilidade = new HashMap<>();
    
    // pontos extras
    private int pontosHeroicos;
    private int pontosInspiracao;
    
    private int shu, stun;
    private boolean desmaiado;
    
    private Corpo corpo = new Corpo();
    
    
    // construtor
    public Ficha() {
        LvlExp ref = new LvlExp();
        LvlExp ems = new LvlExp();
        LvlExp mat = new LvlExp();
        LvlExp man = new LvlExp();
        LvlExp trs = new LvlExp();
        LvlExp esp = new LvlExp();
        LvlExp cdn = new LvlExp();
        LvlExp ten = new LvlExp();
        LvlExp ryu = new LvlExp();
        LvlExp aop = new LvlExp();
        LvlExp mop = new LvlExp();
        mop.setLvl(1);
        LvlExp zts = new LvlExp();
        LvlExp en = new LvlExp();
        
        LvlBonus ini = new LvlBonus();
        LvlBonus esq = new LvlBonus();
        LvlBonus vel = new LvlBonus();
        LvlBonus apr = new LvlBonus();
        LvlBonus crt = new LvlBonus();
        LvlBonus hp = new LvlBonus();
        
        atr.put("REF", ref);
        atr.put("EMS", ems);
        atr.put("MAT", mat);
        atr.put("MAN", man);
        atr.put("TRS", trs);
        atr.put("ESP", esp);
        atr.put("CDN", cdn);
        atr.put("TEN", ten);
        atr.put("RYU", ryu);
        atr.put("AOP", aop);
        atr.put("MOP", mop);
        atr.put("ZTS", zts);
        atr.put("EN", en);
        
        pro.put("INI", ini);
        pro.put("ESQ", esq);
        pro.put("VEL", vel);
        pro.put("APR", apr);
        pro.put("CRT", crt);
        pro.put("HP", hp);
        
        iniFor = iniCon = iniDex = iniInt = iniCar = iniMen = 0;
        valFor = valCon = valDex = valInt = valCar = valMen = 0;
        modFor = modCon = modDex = modInt = modCar = modMen = 0;
        bFor = bCon = bDex = bInt = bCar = bMen = 0;
        perFor = perCon = perDex = perInt = perCar = perMen = 0;
        
        modRef = modEms = modMat = modMan = modTrs = modEsp = modCdn = 0;
        
        this.ini = this.esq = this.apr = this.crt = this.vel = 0;
        
        coefHp = 5;
        lvl = exp = expBonus = 0;
        hpMax = mopMax = 1000;
        hpNegMax = hpNegAtual = 0;
        modClas = 0;
        
        sorte = sorteDiaria = pontosHeroicos = pontosInspiracao = 0;
        sortePorLvl = false;
        personagemDeJogador = false;
        inventario = "";
        descricao = "";
        descricaoBreve = "";
    }
    
    public void putExp(int exp) {
        this.exp += exp * (1.0 + (double) this.expBonus / 100.0);
    }
    
    public void putExpNen(int exp) {
        this.expNen += exp * (1.0 + (double) this.expBonus / 100.0);
    }
    
    public boolean isStunado() {
        return this.stun > 0;
    }
    
    
    // getters e setters

    public static int getVEL_INICIAL() {
        return VEL_INICIAL;
    }

    public static int getESQ_INICIAL() {
        return ESQ_INICIAL;
    }

    public static int getHP_INICIAL() {
        return HP_INICIAL;
    }

    public String getAtkPad() {
        return atkPad;
    }

    public void setAtkPad(String atkPad) {
        this.atkPad = atkPad;
    }

    public String getDefPad() {
        return defPad;
    }

    public void setDefPad(String defPad) {
        this.defPad = defPad;
    }
    
    public boolean isCriaturaDoMestre() {
        return criaturaDoMestre;
    }

    public void setCriaturaDoMestre(boolean criaturaDoMestre) {
        this.criaturaDoMestre = criaturaDoMestre;
    }

    public boolean isPersonagemDeJogador() {
        return personagemDeJogador;
    }

    public void setPersonagemDeJogador(boolean personagemDeJogador) {
        this.personagemDeJogador = personagemDeJogador;
    }

    public boolean isSortePorLvl() {
        return sortePorLvl;
    }
    
    public void setSortePorLvl(boolean bool) {
        this.sortePorLvl = bool;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getHpNegMax() {
        return hpNegMax;
    }

    public void setHpNegMax(int hpNegMax) {
        this.hpNegMax = hpNegMax;
    }

    public int getHpNegAtual() {
        return hpNegAtual;
    }

    public void setHpNegAtual(int hpNegAtual) {
        this.hpNegAtual = hpNegAtual;
    }

    public int getHpAtual() {
        return hpAtual;
    }

    public void setHpAtual(int hpAtual) {
        this.hpAtual = hpAtual;
    }

    public int getShu() {
        return shu;
    }

    public void setShu(int shu) {
        this.shu = shu;
    }

    public int getStun() {
        return stun;
    }

    public void setStun(int stun) {
        if (stun < 0) {
            this.stun = 0;
        }
        this.stun = stun;
    }
    
    public boolean addStun(int valor) {
        if (valor < 0) {
            return false;
        }
        this.stun += valor;
        return true;
    }
    
    public boolean reduzStun(int valor) {
        if (valor > 0) {
            return false;
        }
        this.stun += valor;
        if (this.stun < 0) {
            this.stun = 0;
        }
        return true;
    }

    public boolean isDesmaiado() {
        return desmaiado;
    }

    public void setDesmaiado(boolean desmaiado) {
        this.desmaiado = desmaiado;
    }

    public Corpo getCorpo() {
        return corpo;
    }

    public void setCorpo(Corpo corpo) {
        this.corpo = corpo;
    }
    
    
    public int getPerCdn() {
        return (this.modCdn + (this.lvl / 2) + this.bIntCdn);
    }
    
    public Map<String, Habilidades> getHabilidades() {    
        return habilidade;
    }
    
    public void putHabilidade(String nome, Habilidades habilidade) {
        this.habilidade.put(nome, habilidade);
    }
    
    public boolean removeHafbilidades(Habilidades habilidade) {
        if (this.habilidade.remove(habilidade.getNome(), habilidade)) {
            return true;
        }
        return false;
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
    
    public void putPro(String nome, LvlBonus lvlBonus) {
        this.pro.put(nome, lvlBonus);
    }
    
    public Map<String, LvlBonus> getPro() {
        return pro;
    }
    
    public LvlBonus getPro(String nomePro) {
        return pro.get(nomePro);
    }
    
    public void putPer(String nome, LvlBonus lvlBonus) {
        this.per.put(nome, lvlBonus);
    }

    public Map<String, LvlBonus> getPer() {
        return per;
    }
    
    public void incrementaLvlNen() {
        this.lvlNen++;
    }
    
    public int getLvlNen() {
        return lvlNen;
    }

    public void setLvlNen(int lvlNen) {
        this.lvlNen = lvlNen;
    }

    public int getExpNen() {
        return expNen;
    }

    public void setExpNen(int expNen) {
        this.expNen = expNen;
    }

    public int getExpBonusNen() {
        return expBonusNen;
    }

    public void setExpBonusNen(int expBonusNen) {
        this.expBonusNen = expBonusNen;
    }

    public int getSorteDiaria() {
        return sorteDiaria;
    }

    public void setSorteDiaria(int sorteDiaria) {
        this.sorteDiaria = sorteDiaria;
    }
    
    public void incrementaSorte() {
        this.sorte++;
    }
    
    public void decrementaSorte() {
        this.sorte--;
    }
    
    public int getSorte() {
        return sorte;
    }

    public String getInventario() {
        return inventario;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
    }
    
    public void incrementaPontosHeroicos() {
        this.pontosHeroicos++;
    }
    
    public void decrementaPontosHeroicos() {
        this.pontosHeroicos--;
    }

    public int getPontosHeroicos() {
        return pontosHeroicos;
    }

    public void setPontosHeroicos(int pontosHeroicos) {
        this.pontosHeroicos = pontosHeroicos;
    }
    
    public void incrementaPontosInspiracao() {
        this.pontosInspiracao++;
    }
    
    public void decrementaPontosInspiracao() {
        this.pontosInspiracao--;
    }

    public int getPontosInspiracao() {
        return pontosInspiracao;
    }

    public void setPontosInspiracao(int pontosInspiracao) {
        this.pontosInspiracao = pontosInspiracao;
    }
    
    public int getbIntCdn() {
        return bIntCdn;
    }

    public void setbIntCdn(int bIntCdn) {
        this.bIntCdn = bIntCdn;
    }
    
    public Habilidades getHabilidade(String nome) {
        if (nome == null || nome.equals("FISICO")) {
            Habilidades skill = new Habilidades();
            skill.setDano(modFor);
            skill.setNome("FISICO");
            skill.setVol(3);
            return skill;
        }
        return habilidade.get(nome);
    }
    
    public double getRyu(int ryu, double nen) {
        return (double) ryu * nen / (double) corpo.getValor();
    }
    
    public int getKen(int ryu, int auraBonus) {
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("ryu " + ryu + " aura bonus " + auraBonus);
        System.out.println("modClas " + modClas + " aop " + atr.get("AOP").getLvl());
        System.out.println("getPop() " + getPop() + " this " + this.getRyu(ryu, atr.get("AOP").getLvl() * getPop()));
        System.out.println("return " + Math.floor(modClas * ((atr.get("AOP").getLvl() + auraBonus) * (double) this.getRyu(ryu, atr.get("AOP").getLvl() * getPop()) / 100.0)));
        System.out.println("++++++++++++++++++++++++++++++++++++");
        return (int) Math.floor(modClas * ((atr.get("AOP").getLvl() + auraBonus) * (double) this.getRyu(ryu, atr.get("AOP").getLvl() * getPop()) / 100.0));
    }
    
    public int getKen(int ryu, Habilidades habilidade) {
        int auraBonus = habilidade.getAuraBonus();
        return (int) Math.floor(modClas * ((atr.get("AOP").getLvl() + auraBonus) * this.getRyu(ryu, atr.get("AOP").getLvl() * getPop())));
    }

    public int getCoefHp() {
        return coefHp;
    }

    public void setCoefHp(int coefHp) {
        this.coefHp = coefHp;
    }

    public String getDescricaoBreve() {
        return descricaoBreve;
    }

    public void setDescricaoBreve(String descricaoBreve) {
        this.descricaoBreve = descricaoBreve;
    }
        
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void incrementaDia() {
        this.dias++;
    }
    
    public void incrementaMeioDia() {
        this.dias += 0.5;
    }

    public double getDias() {
        return dias;
    }

    public void setDias(double dias) {
        this.dias = dias;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getNen() {
        return nen;
    }

    public void setNen(String nen) {
        this.nen = nen;
    }

    public String getTendencia() {
        return tendencia;
    }

    public void setTendencia(String tendencia) {
        this.tendencia = tendencia;
    }

    public String getHunter() {
        return hunter;
    }

    public void setHunter(String hunter) {
        this.hunter = hunter;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getIniFor() {
        return iniFor;
    }

    public void setIniFor(int iniFor) {
        this.iniFor = iniFor;
    }

    public int getIniCon() {
        return iniCon;
    }

    public void setIniCon(int iniCon) {
        this.iniCon = iniCon;
    }

    public int getIniDex() {
        return iniDex;
    }

    public void setIniDex(int iniDex) {
        this.iniDex = iniDex;
    }

    public int getIniInt() {
        return iniInt;
    }

    public void setIniInt(int iniInt) {
        this.iniInt = iniInt;
    }

    public int getIniCar() {
        return iniCar;
    }

    public void setIniCar(int iniCar) {
        this.iniCar = iniCar;
    }

    public int getIniMen() {
        return iniMen;
    }

    public void setIniMen(int iniMen) {
        this.iniMen = iniMen;
    }

    public Map<String, LvlExp> getAtr() {
        return atr;
    }
    
    public LvlExp getAtr(String nome) {
        return this.atr.get(nome);
    }
    
    public int getValFor() {
        return valFor;
    }

    public void setValFor(int valFor) {
        this.valFor = valFor;
    }

    public int getValCon() {
        return valCon;
    }

    public void setValCon(int valCon) {
        this.valCon = valCon;
    }

    public int getValDex() {
        return valDex;
    }

    public void setValDex(int valDex) {
        this.valDex = valDex;
    }

    public int getValInt() {
        return valInt;
    }

    public void setValInt(int valInt) {
        this.valInt = valInt;
    }

    public int getValCar() {
        return valCar;
    }

    public void setValCar(int valCar) {
        this.valCar = valCar;
    }

    public int getValMen() {
        return valMen;
    }

    public void setValMen(int valMen) {
        this.valMen = valMen;
    }

    public int getModFor() {
        return modFor;
    }

    public void setModFor(int modFor) {
        this.modFor = modFor;
    }
    
    public void setbFor() {
        this.bFor = Classes.get(this.classe).getbFor();
    }
    
    public void setbCon() {
        this.bCon = Classes.get(this.classe).getbCon();
    }
    
    public void setbDex() {
        this.bDex = Classes.get(this.classe).getbDex();
    }
    
    public void setbInt() {
        this.bInt = Classes.get(this.classe).getbInt();
    }
    
    public void setbCar() {
        this.bCar = Classes.get(this.classe).getbCar();
    }
    
    public void setbMen() {
        this.bMen = Classes.get(this.classe).getbMen();
    }
    
    public void setModFor() {
        this.modFor = (this.valFor - 10) / 2;
    }
    
    public void setModCon() {
        this.modCon = (this.valCon - 10) / 2;
    }
    
    public void setModDex() {
        this.modDex = (this.valDex - 10) / 2;
    }
    
    public void setModCar() {
        this.modCar = (this.valCar - 10) / 2;
    }
    
    public void setModInt() {
        this.modInt = (this.valInt - 10) / 2;
    }
    
    public void setModMen() {
        this.modMen = (this.valMen - 10) / 2;
    }
    
    public void setModCdn() {
        this.modCdn = this.getAtrCdn() / 2;
    }
    
    public void setPerMen() {
        this.perMen = this.modMen + this.lvl / 2 + this.bMen;
    }
    
    public void setPerFor() {
        this.perFor = this.modFor + this.lvl / 2 + this.bFor;
    }
    
    public void setPerInt() {
        this.perInt = this.modInt + this.lvl / 2 + this.bInt;
    }
    
    public void setPerDex() {
        this.perDex = this.modDex + this.lvl / 2 + this.bDex;
    }
    
    public void setPerCon() {
        this.perCon = this.modCon + this.lvl / 2 + this.bCon;
    }
    
    public void setPerCar() {
        this.perCar = this.modCar + this.lvl / 2 + this.bCar;
    }
    
    public void setIni() {
        this.ini = this.perDex + this.pro.get("INI").getLvl();
    }
    
    public void setEsq() {
        this.esq = this.modDex + Ficha.getESQ_INICIAL() +
                this.pro.get("ESQ").getLvl() + this.lvl / 2 + this.bDex;
    }
    
    public void setCrt() {
        this.crt = (this.valDex - 10) / 10 + this.pro.get("CRT").getLvl();
    }
    
    public void setApr() {
        this.apr = (this.valCar - 10) / 10 + this.iniCar + this.pro.get("APR").getLvl();
    }
    
    public void setbIntCdn() {
        this.bIntCdn = (this.valInt - 10) / 10;
    }
    
    public void setVel() {
        this.vel = (this.valFor - 10) / 10 + this.lvl + this.pro.get("VEL").getLvl() +
                Ficha.getVEL_INICIAL();
    }
    
    public void setHp() {
        //this.hpMax = (this.getProHp() + this.coefHp) * this.lvl + this.valCon + Ficha.getHP_INICIAL();
        this.hpMax = (this.getProHp() + this.modCon + this.coefHp) * this.lvl + this.valCon + Ficha.getHP_INICIAL();
        this.hpAtual = this.hpMax;
        this.hpNegMax = this.valCon + this.lvl + this.getProHp();
        this.hpNegAtual = this.hpNegMax;
    }
    
    public void resetSortes() {
        this.sorte = this.sorteDiaria;
    }
    
    public void setSorteDiaria() {
        if (this.sortePorLvl) {
            this.sorteDiaria = (this.valCar - 10) / 10 + this.lvl / 2 + this.getModCar();
        } else {
            this.sorteDiaria = (this.valCar - 10) / 10;
        }
        this.resetSortes();
    }
    
    public int getModCon() {
        return modCon;
    }

    public void setModCon(int modCon) {
        this.modCon = modCon;
    }

    public int getModDex() {
        return modDex;
    }

    public void setModDex(int modDex) {
        this.modDex = modDex;
    }

    public int getModInt() {
        return modInt;
    }

    public void setModInt(int modInt) {
        this.modInt = modInt;
    }

    public int getModCar() {
        return modCar;
    }

    public void setModCar(int modCar) {
        this.modCar = modCar;
    }

    public int getModMen() {
        return modMen;
    }

    public void setModMen(int modMen) {
        this.modMen = modMen;
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

    public int getPerFor() {
        return perFor;
    }

    public void setPerFor(int perFor) {
        this.perFor = perFor;
    }

    public int getPerCon() {
        return perCon;
    }

    public void setPerCon(int perCon) {
        this.perCon = perCon;
    }

    public int getPerDex() {
        return perDex;
    }

    public void setPerDex(int perDex) {
        this.perDex = perDex;
    }

    public int getPerInt() {
        return perInt;
    }

    public void setPerInt(int perInt) {
        this.perInt = perInt;
    }

    public int getPerCar() {
        return perCar;
    }

    public void setPerCar(int perCar) {
        this.perCar = perCar;
    }

    public int getPerMen() {
        return perMen;
    }

    public void setPerMen(int perMen) {
        this.perMen = perMen;
    }

    public int getAtrRef() {
        return this.atr.get("REF").getLvl();
    }

    public void setAtrRef(int atrRef) {
        this.atr.get("REF").setLvl(atrRef);
    }

    public int getAtrEms() {
        return atr.get("EMS").getLvl();
    }

    public void setAtrEms(int atrEms) {
        this.atr.get("EMS").setLvl(atrEms);
    }

    public int getAtrMat() {
        return this.atr.get("MAT").getLvl();
    }

    public void setAtrMat(int atrMat) {
        this.atr.get("MAT").setLvl(atrMat);
    }

    public int getAtrMan() {
        return atr.get("MAN").getLvl();
    }

    public void setAtrMan(int atrMan) {
        this.atr.get("MAN").setLvl(atrMan);
    }

    public int getAtrTrs() {
        return atr.get("TRS").getLvl();
    }

    public void setAtrTrs(int atrTrs) {
        this.atr.get("TRS").setLvl(atrTrs);
    }

    public int getAtrEsp() {
        return atr.get("ESP").getLvl();
    }

    public void setAtrEsp(int atrEsp) {
        this.atr.get("ESP").setLvl(atrEsp);
    }


    public int getAtrCdn() {
        return atr.get("CDN").getLvl();
    }

    public void setAtrCdn(int atrCdn) {
        this.atr.get("CDN").setLvl(atrCdn);
    }
    
    public int getValPRef() {
        switch (this.nen) {
            case "Reforco":
                return (int) (this.getAtrRef() * 1.0);
            case "Emissao":
                return (int) (this.getAtrRef() * 0.8);
            case "Manipulacao":
                return (int) (this.getAtrRef() * 0.6);
            case "Materializacao":
                return (int) (this.getAtrRef() * 0.6);
            case "Transformacao":
                return (int) (this.getAtrRef() * 0.8);
            case "Especialista":
                return (int) (this.getAtrRef() * 0.4);
            default:
                return 0;
        }
    }

    public int getValPEms() {
        switch (this.nen) {
            case "Reforco":
                return (int) (this.getAtrEms() * 0.8);
            case "Emissao":
                return (int) (this.getAtrEms() * 1.0);
            case "Manipulacao":
                return (int) (this.getAtrEms() * 0.8);
            case "Materializacao":
                return (int) (this.getAtrEms() * 0.4);
            case "Transformacao":
                return (int) (this.getAtrEms() * 0.6);
            case "Especialista":
                return (int) (this.getAtrEms() * 0.6);
            default:
                return 0;
        }
    }

    public int getValPMat() {
        switch (this.nen) {
            case "Reforco":
                return (int) (this.getAtrMat() * 0.6);
            case "Emissao":
                return (int) (this.getAtrMat() * 0.4);
            case "Manipulacao":
                return (int) (this.getAtrMat() * 0.6);
            case "Materializacao":
                return (int) (this.getAtrMat() * 1.0);
            case "Transformacao":
                return (int) (this.getAtrMat() * 0.8);
            case "Especialista":
                return (int) (this.getAtrMat() * 0.8);
            default:
                return 0;
        }
    }

    public int getValPMan() {
        switch (this.nen) {
            case "Reforco":
                return (int) (this.getAtrMan() * 0.6);
            case "Emissao":
                return (int) (this.getAtrMan() * 0.8);
            case "Manipulacao":
                return (int) (this.getAtrMan() * 1.0);
            case "Materializacao":
                return (int) (this.getAtrMan() * 0.6);
            case "Transformacao":
                return (int) (this.getAtrMan() * 0.4);
            case "Especialista":
                return (int) (this.getAtrMan() * 0.8);
            default:
                return 0;
        }
    }

    public int getValPTrs() {
        switch (this.nen) {
            case "Reforco":
                return (int) (this.getAtrTrs() * 0.8);
            case "Emissao":
                return (int) (this.getAtrTrs() * 0.6);
            case "Manipulacao":
                return (int) (this.getAtrTrs() * 0.4);
            case "Materializacao":
                return (int) (this.getAtrTrs() * 0.8);
            case "Transformacao":
                return (int) (this.getAtrTrs() * 1.0);
            case "Especialista":
                return (int) (this.getAtrTrs() * 0.6);
            default:
                return 0;
        }
    }

    public int getValPEsp() {
        switch (this.nen) {
            case "Reforco":
                return (int) (this.getAtrEsp() * 0.4);
            case "Emissao":
                return (int) (this.getAtrEsp() * 0.6);
            case "Manipulacao":
                return (int) (this.getAtrEsp() * 0.8);
            case "Materializacao":
                return (int) (this.getAtrEsp() * 0.8);
            case "Transformacao":
                return (int) (this.getAtrEsp() * 0.6);
            case "Especialista":
                return (int) (this.getAtrEsp() * 1.0);
            default:
                return 0;
        }
    }
    
//      O ANTIGO CODIGO DE MOD ATR NEN ERA ASSIM
//      switch (this.nen) {
//            case "Reforco":
//                return (int) ((this.getAtrRef() * 1.0) - 10) / 2;
//            case "Emissao":
//                return (int) ((this.getAtrRef() * 0.8) - 10) / 2;
//            case "Manipulacao":
//                return (int) ((this.getAtrRef() * 0.6) - 10) / 2;
//            case "Materializacao":
//                return (int) ((this.getAtrRef() * 0.6) - 10) / 2;
//            case "Transformacao":
//                return (int) ((this.getAtrRef() * 0.8) - 10) / 2;
//            case "Especialista":
//                return (int) ((this.getAtrRef() * 0.4) - 10) / 2;
//            default:
//                return 0;
//        }
    
    public int getModRef() {
        switch (this.nen) {
            case "Reforco":
                return (int) (this.getAtrRef() / 2 * 1.0);
            case "Emissao":
                return (int) (this.getAtrRef() / 2 * 0.8);
            case "Manipulacao":
                return (int) (this.getAtrRef() / 2 * 0.6);
            case "Materializacao":
                return (int) (this.getAtrRef() / 2 * 0.6);
            case "Transformacao":
                return (int) (this.getAtrRef() / 2 * 0.8);
            case "Especialista":
                return (int) (this.getAtrRef() / 2 * 0.4);
            default:
                return 0;
        }
    }

    public int getModEms() {
        switch (this.nen) {
            case "Reforco":
                return (int) (this.getAtrEms() / 2 * 0.8);
            case "Emissao":
                return (int) (this.getAtrEms() / 2 * 1.0);
            case "Manipulacao":
                return (int) (this.getAtrEms() / 2 * 0.8);
            case "Materializacao":
                return (int) (this.getAtrEms() / 2 * 0.4);
            case "Transformacao":
                return (int) (this.getAtrEms() / 2 * 0.6);
            case "Especialista":
                return (int) (this.getAtrEms() / 2 * 0.6);
            default:
                return 0;
        }
    }

    public int getModMat() {
        switch (this.nen) {
            case "Reforco":
                return (int) (this.getAtrMat() / 2 * 0.6);
            case "Emissao":
                return (int) (this.getAtrMat() / 2 * 0.4);
            case "Manipulacao":
                return (int) (this.getAtrMat() / 2 * 0.6);
            case "Materializacao":
                return (int) (this.getAtrMat() / 2 * 1.0);
            case "Transformacao":
                return (int) (this.getAtrMat() / 2 * 0.8);
            case "Especialista":
                return (int) (this.getAtrMat() / 2 * 0.8);
            default:
                return 0;
        }
    }

    public int getModMan() {
        switch (this.nen) {
            case "Reforco":
                return (int) (this.getAtrMan() / 2 * 0.6);
            case "Emissao":
                return (int) (this.getAtrMan() / 2 * 0.8);
            case "Manipulacao":
                return (int) (this.getAtrMan() / 2 * 1.0);
            case "Materializacao":
                return (int) (this.getAtrMan() / 2 * 0.6);
            case "Transformacao":
                return (int) (this.getAtrMan() / 2 * 0.4);
            case "Especialista":
                return (int) (this.getAtrMan() / 2 * 0.8);
            default:
                return 0;
        }
    }

    public int getModTrs() {
        switch (this.nen) {
            case "Reforco":
                return (int) (this.getAtrTrs() / 2 * 0.8);
            case "Emissao":
                return (int) (this.getAtrTrs() / 2 * 0.6);
            case "Manipulacao":
                return (int) (this.getAtrTrs() / 2 * 0.4);
            case "Materializacao":
                return (int) (this.getAtrTrs() / 2 * 0.8);
            case "Transformacao":
                return (int) (this.getAtrTrs() / 2 * 1.0);
            case "Especialista":
                return (int) (this.getAtrTrs() / 2 * 0.6);
            default:
                return 0;
        }
    }

    public int getModEsp() {
        switch (this.nen) {
            case "Reforco":
                return (int) (this.getAtrEsp() / 2 * 0.4);
            case "Emissao":
                return (int) (this.getAtrEsp() / 2 * 0.6);
            case "Manipulacao":
                return (int) (this.getAtrEsp() / 2 * 0.8);
            case "Materializacao":
                return (int) (this.getAtrEsp() / 2 * 0.8);
            case "Transformacao":
                return (int) (this.getAtrEsp() / 2 * 0.6);
            case "Especialista":
                return (int) (this.getAtrEsp() / 2 * 1.0);
            default:
                return 0;
        }
    }
    
    public int getModCdn() {
        return modCdn;
    }
    
    public int getNivelCdn() {
        if (modCdn < 3) {
            return 0;
        }
        if (modCdn < 6) {
            return 1;
        }
        if (modCdn < 12) {
            return 2;
        }
        if (modCdn < 24) {
            return 3;
        }
        if (modCdn < 48) {
            return 4;
        }
        // if (modCdn >= 48)
        return 5;
    }

    public void setModCdn(int modCdn) {
        this.modCdn = modCdn;
    }
    
    public int getModTen() {
        return (this.getTen() - 10) / 2;
    }
    
    public int getModZts() {
        return (this.getZts() - 10) / 2;
    }
    
    public int getModRyu() {
        return this.getRyu() / 2;
    }
    
    public int getPerRef() {
        return this.getModRef() + this.lvl / 2;
    }
    
    public int getPerEms() {
        return this.getModEms() + this.lvl / 2;
    }
    
    public int getPerMan() {
        return this.getModMan() + this.lvl / 2;
    }
    
    public int getPerMat() {
        return this.getModMat() + this.lvl / 2;
    }
    
    public int getPerTrs() {
        return this.getModTrs() + this.lvl / 2;
    }
    
    public int getPerEsp() {
        return this.getModEsp() + this.lvl / 2;
    }
    
    public int getPerTen() {
        return (this.getTen() - 10)/2 + this.getLvl() / 2;
    }

    public int getPerZts() {
        return (this.getZts() - 10)/2 + this.getLvl() / 2;
    }

    public int getPerRyu() {
        return this.getRyu() / 2 + this.getLvl() / 2;
    }
    
    public int getTen() {
        return atr.get("TEN").getLvl();
    }

    public void setTen(int ten) {
        this.atr.get("TEN").setLvl(ten);
    }

    public int getRyu() {
        return atr.get("RYU").getLvl();
    }

    public void setRyu(int ryu) {
        this.atr.get("RYU").setLvl(ryu);
    }

    public int getEn() {
        return atr.get("EN").getLvl();
    }

    public void setEn(int en) {
        this.atr.get("EN").setLvl(en);
    }

    public int getMop() {
        return atr.get("MOP").getLvl();
    }

    public void setMop(int mop) {
        this.atr.get("MOP").setLvl(mop);
        this.mopMax = mop * 1000;
        this.mopAtual = mop * 1000;
    }
    
    public int setMopAtual(int mop) {
        if (mop < 0) {
            this.mopAtual = 0;            
            // devolvemos uma quantidade positiva de mop como
            // aop a ser reduzido do personagem
            return (int) Math.round((double) - mop / 50.0);
        }
        this.mopAtual = mop;
        return 0;
    }
    
    public int getMopAtual() {
        return mopAtual;
    }
    
    public double getPop() {
        return 1 + (double) this.atr.get("REF").getLvl() / 10.0;
    }

    public int getAop() {
        return atr.get("AOP").getLvl();
    }

    public void setAop(int aop) {
        this.atr.get("AOP").setLvl(aop);
    }
    
    public int getZts() {
        return atr.get("ZTS").getLvl();
    }
    
    public void setZts(int zts) {
        this.atr.get("ZTS").setLvl(zts);
    }

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
    
    public void incrementaLvl() {
        this.lvl++;
        if (this.isSortePorLvl()) {
            this.sorteDiaria = (this.valCar - 10) / 10 + this.lvl / 2 + this.getModCar();
            this.resetSortes();
        }
    }
    
    public int getExpBonus() {
        return expBonus;
    }

    public void setExpBonus(int expBonus) {
        this.expBonus = expBonus;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getMopMax() {
        return mopMax;
    }

    public void setMopMax(int mopMax) {
        this.mopMax = mopMax;
    }

    public int getProIni() {
        return pro.get("INI").getLvl();
    }

    public void setProIni(int proIni) {
        this.pro.get("INI").setLvl(proIni);
    }

    public int getProEsq() {
        return pro.get("ESQ").getLvl();
    }

    public void setProEsq(int proEsq) {
        this.pro.get("ESQ").setLvl(proEsq);
    }

    public int getProApr() {
        return pro.get("APR").getLvl();
    }

    public void setProApr(int proApr) {
        this.pro.get("APR").setLvl(proApr);
    }

    public int getProCrt() {
        return pro.get("CRT").getLvl();
    }

    public void setProCrt(int proCrt) {
        this.pro.get("CRT").setLvl(proCrt);
    }

    public int getProVel() {
        return pro.get("VEL").getLvl();
    }

    public void setProVel(int proVel) {
        this.pro.get("VEL").setLvl(proVel);
    }
    
    public int getProHp() {
        return pro.get("HP").getLvl();
    }
    
    public void setProHp(int proHp) {
        this.pro.get("HP").setLvl(proHp);
    }

    public int getIni() {
        return ini;
    }

    public void setIni(int ini) {
        this.ini = ini;
    }

    public int getEsq() {
        return esq;
    }

    public void setEsq(int esq) {
        this.esq = esq;
    }

    public int getApr() {
        return apr;
    }

    public void setApr(int apr) {
        this.apr = apr;
    }

    public int getCrt() {
        return crt;
    }

    public void setCrt(int crt) {
        this.crt = crt;
    }

    public int getVel() {
        return vel;
    }
    
    public int getVelMs() {
        return (int) ((double) vel / 3.6);
    }

    public void setVel(int vel) {
        this.vel = vel;
    }

    public double getModClas() {
        return modClas;
    }

    public void setModClas(double modClas) {
        this.modClas = modClas;
    }
}
