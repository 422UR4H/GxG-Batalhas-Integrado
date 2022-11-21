/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha_personagem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 422UR4H
 */
public class Classes {
    private static final Map<String, Classe> CLASSE = new HashMap<>();
    
    
    public static List<String> getClasses() {
        List<String> list = new ArrayList<>();// = new ArrayList<String>();
        
        for (String classe : CLASSE.keySet()) {
            list.add(classe);
        }
        Collections.sort(list);
        
        return list;
    }
    
    public static Classe get(String nome) {
        return CLASSE.get(nome);
    }
    
    public static void init() {
        // criando classes
        Classe cacador = new Classe();
        cacador.setbDex(2);
        cacador.setbInt(2);
        cacador.putbPro("ADAGAS", 2);
        cacador.putbPro("FACAS", 2);
        cacador.putbPro("ARCOS", 2);
        Classes.CLASSE.put("Caçador", cacador);
        
        Classe chimera = new Classe();
        chimera.setbFor(4);
        chimera.setbCon(4);
        chimera.setbCar(-3);
        chimera.setbVel(2);
        chimera.setbEsq(2);
        chimera.setbProLivre(2);
        Classes.CLASSE.put("Chimera", chimera);
        
        Classe espadachim = new Classe();
        espadachim.setbFor(2);
        espadachim.setbDex(2);
        espadachim.setbCon(2);
        espadachim.setbInt(1);
        espadachim.setbVel(3);
        espadachim.setbEsq(3);
        espadachim.setbIni(3);
        espadachim.putbPro("ESPADAS", 3);
        Classes.CLASSE.put("Espadachim", espadachim);
        
        Classe gambler = new Classe();
        gambler.setbDex(2);
        gambler.setbCar(3);
        gambler.setbInt(1);
        gambler.setSortePorLvl(true);
        gambler.putbPro("PRO GAMBLER", 3);
        Classes.CLASSE.put("Gambler", gambler);
        
        Classe gatuno = new Classe();
        gatuno.setbDex(3);
        gatuno.setbVel(2);
        gatuno.setbIni(1);
        gatuno.putbPro("ADAGAS E FACAS", 2);
        gatuno.putbPro("ADAGAS DE A.", 2);
        Classes.CLASSE.put("Gatuno", gatuno);
        
        Classe ilusionista = new Classe();
        ilusionista.setbCar(3);
        ilusionista.setbDex(2);
        ilusionista.setbInt(1);
        ilusionista.setbFor(-2);
        ilusionista.setbCon(-1);
        ilusionista.setbProLivre(2);
        Classes.CLASSE.put("Ilusionista", ilusionista);
        
        Classe mafioso = new Classe();
        mafioso.setbCar(3);
        mafioso.setbInt(2);
        mafioso.setbDex(2);
        mafioso.setbFor(1);
        mafioso.setbEsq(2);
        mafioso.setbVel(1);
        mafioso.setbIni(1);
        mafioso.putbPro("ARMAS DE FOGO", 3);
        Classes.CLASSE.put("Mafioso", mafioso);
        
        Classe militar = new Classe();
        militar.setbInt(1);
        militar.setbDex(1);
        militar.setbFor(2);
        militar.setbCon(3);
        militar.setbCar(-2);
        militar.setbEsq(1);
        militar.setbVel(2);
        militar.putbPro("ARMAS DE FOGO", 3);
        Classes.CLASSE.put("Militar", militar);
        
        Classe ninja = new Classe();
        ninja.setbCon(1);
        ninja.setbInt(1);
        ninja.setbFor(2);
        ninja.setbDex(3);
        ninja.setbEsq(1);
        ninja.setbVel(3);
        ninja.putbPro("ADAGAS DE A.", 2);
        ninja.putbPro("KUSARIGAMA", 2);
        Classes.CLASSE.put("Ninja", ninja);
        
        Classe samurai = new Classe();
        samurai.setbFor(1);
        samurai.setbCrt(2);
        samurai.setbDex(3);
        samurai.setbIni(1);
        samurai.setbVel(2);
        samurai.setbEsq(3);
        samurai.putbPro("KATANA", 4);
        Classes.CLASSE.put("Samurai", samurai);
        
        Classe animalEspecial = new Classe();
        animalEspecial.addBLivre(2);
        animalEspecial.addBLivre(2);
        animalEspecial.addBLivre(1);
        animalEspecial.addBLivre(1);
        animalEspecial.setbProLivre(2);
        animalEspecial.setbVel(2);
        Classes.CLASSE.put("Animal Especial", animalEspecial);
        
        Classe armaEspecial = new Classe();
        armaEspecial.addBLivre(2);
        armaEspecial.addBLivre(2);
        armaEspecial.addBLivre(1);
        armaEspecial.addBLivre(1);
        armaEspecial.setbProLivre(3);
        armaEspecial.setbVel(2);
        armaEspecial.setbEsq(2);
        armaEspecial.setbCrt(2);
        Classes.CLASSE.put("Arma Especial", armaEspecial);
        
        Classe atleta = new Classe();
        atleta.setbVel(4);
        atleta.setbEsq(1);
        atleta.addBLivre(3);
        atleta.addBLivre(2);
        atleta.addBLivre(2);
        atleta.setbProLivre(2);
        Classes.CLASSE.put("Atleta", atleta);
        
        Classe cientista = new Classe();
        cientista.setbInt(4);
        cientista.setbCar(2);
        cientista.addBLivre(2);
        cientista.addBLivre(1);
        cientista.setbEsq(2);
        cientista.setbVel(2);
        cientista.setbProLivre(4);
        Classes.CLASSE.put("Cientista", cientista);
        
        Classe circo = new Classe();
        circo.setbCon(1);
        circo.addBLivre(2);
        circo.addBLivre(3);
        circo.setbVel(3);
        circo.setbEsq(3);
        circo.setbProLivre(2);
        Classes.CLASSE.put("Circo", circo);
        
        Classe colecionador = new Classe();
        colecionador.setbCar(2);
        colecionador.setbInt(2);
        colecionador.addBLivre(1);
        colecionador.addBLivre(1);
        colecionador.setbProLivre(1);
        colecionador.setbVel(1);
        Classes.CLASSE.put("Colecionador", colecionador);
        
        Classe netrunner = new Classe();
        netrunner.setbCar(2);
        netrunner.setbInt(3);
        netrunner.addBLivre(3);
        netrunner.addBLivre(1);
        netrunner.setbProLivre(2);
        Classes.CLASSE.put("Netrunner", netrunner);
        
        Classe genio = new Classe();
        genio.setbInt(4);
        genio.addBLivre(2);
        genio.addBLivre(2);
        genio.setbProLivre(2);
        Classes.CLASSE.put("Gênio", genio);
        
        Classe hunterAmador = new Classe();
        hunterAmador.setbInt(3);
        hunterAmador.addBLivre(2);
        hunterAmador.addBLivre(1);
        hunterAmador.setbProLivre(2);
        hunterAmador.setbEsq(2);
        hunterAmador.setbVel(2);
        hunterAmador.setbIni(1);
        Classes.CLASSE.put("Hunter Amador", hunterAmador);
        
//        Classe paladino = new Classe();
//        paladino.setbCar(2);
//        paladino.setbInt(2);
//        paladino.addBLivre(2);
//        paladino.setbProLivre(3);
//        paladino.setbIni(1);
//        Classes.CLASSE.put("Paladino", paladino);
        
        Classe terrorista = new Classe();
        terrorista.setbFor(2);
        terrorista.setbInt(2);
        terrorista.setbCon(2);
        terrorista.setbDex(1);
        terrorista.setbCar(1);
        terrorista.setbProLivre(2);
        terrorista.setbEsq(2);
        terrorista.setbVel(1);
        Classes.CLASSE.put("Terrorista", terrorista);
        
        Classe monge = new Classe();
        monge.setbFor(2);
        monge.setbCon(2);
        monge.setbInt(2);
        monge.setbDex(1);
        monge.setbProLivre(2);
        monge.setbVel(2);
        monge.setbEsq(2);
        Classes.CLASSE.put("Monge", monge);
        
        Classe tribal = new Classe();
        tribal.addBLivre(3);
        tribal.addBLivre(2);
        tribal.addBLivre(1);
        tribal.setbProLivre(2);
        tribal.setbVel(2);
        tribal.setbEsq(1);
        tribal.setbIni(1);
        Classes.CLASSE.put("Tribal", tribal);
        
        Classe kuruta = new Classe();
        kuruta.setbInt(3);
        kuruta.setbDex(2);
        kuruta.putbPro("ARMA KURUTA", 3);
        kuruta.setbVel(2);
        kuruta.setbEsq(2);
        Classes.CLASSE.put("Kuruta", kuruta);
        
        Classe experimento = new Classe();
        experimento.addBLivre(3);
        experimento.addBLivre(2);
        experimento.addBLivre(2);
        experimento.addBLivre(1);
        experimento.setbProLivre(1);
        Classes.CLASSE.put("Experimento", experimento);
        
        Classe pirata = new Classe();
        pirata.setbDex(2);
        pirata.addBLivre(2);
        pirata.setbEsq(2);
        pirata.setbVel(3);
        pirata.setbIni(1);
        pirata.putbPro("ARMAS DE FOGO", 3);
        pirata.setbProLivre(3);
        Classes.CLASSE.put("Pirata", pirata);
        
        Classe mercenario = new Classe();
        mercenario.setbDex(2);
        mercenario.setbFor(2);
        mercenario.setbCon(2);
        mercenario.setbEsq(2);
        mercenario.setbVel(2);
        mercenario.setbIni(2);
        mercenario.putbPro("FACAS", 1);
        mercenario.setbProLivre(3);
        Classes.CLASSE.put("Mercenário", mercenario);
        
        Classe mestre = new Classe();
        mestre.setbDex(3);
        mestre.setbFor(2);
        mestre.setbCon(1);
        mestre.setbProLivre(3);
        mestre.setbEsq(1);
        mestre.setbIni(1);
        mestre.setbVel(1);
        Classes.CLASSE.put("Mestre de Armas", mestre);
        
        
        Classe animal = new Classe();
        animal.addBLivre(4);
        animal.addBLivre(3);
        animal.setbProLivre(1);
        animal.setbVel(1);
        Classes.CLASSE.put("Animal", animal);
        
        
        Classe kamaitachi = new Classe();
        kamaitachi.setbDex(4);
        kamaitachi.setbFor(2);
        kamaitachi.setbCon(2);
        kamaitachi.addBLivre(2);
        kamaitachi.setbEsq(4);
        kamaitachi.setbVel(4);
        kamaitachi.setbIni(4);
        Classes.CLASSE.put("Kamaitachi", kamaitachi);
        
        Classe kaijin = new Classe();
        kaijin.setbDex(3);
        kaijin.setbFor(3);
        kaijin.setbCon(2);
        kaijin.addBLivre(4);
        kaijin.setbEsq(4);
        kaijin.setbVel(3);
        kaijin.setbIni(4);
        Classes.CLASSE.put("Kaijin", kaijin);
        
        Classe youkai = new Classe();
        youkai.setbDex(2);
        youkai.setbFor(3);
        youkai.setbCon(3);
        youkai.addBLivre(4);
        youkai.setbEsq(4);
        youkai.setbVel(2);
        youkai.setbIni(4);
        youkai.setbHp(2);
        Classes.CLASSE.put("Youkai", youkai);
        
        Classe daikaiju = new Classe();
        daikaiju.setbFor(4);
        daikaiju.setbCon(3);
        daikaiju.setbDex(2);
        daikaiju.addBLivre(4);
        daikaiju.setbEsq(4);
        daikaiju.setbVel(2);
        daikaiju.setbIni(4);
        daikaiju.setbHp(2);
        Classes.CLASSE.put("Daikaiju", daikaiju);
        
        Classe kaiju = new Classe();
        kaiju.setbFor(4);
        kaiju.setbCon(4);
        kaiju.addBLivre(1);
        kaiju.setbEsq(4);
        kaiju.setbHp(4);
        Classes.CLASSE.put("Kaiju", kaiju);
        
        Classe volantes = new Classe();
        volantes.setbDex(4);
        volantes.setbFor(3);
        volantes.setbCon(2);
        volantes.addBLivre(1);
        volantes.setbEsq(4);
        volantes.setbVel(4);
        volantes.setbIni(2);
        Classes.CLASSE.put("Volantes", volantes);
        
        
        /*
        Kamaitachi
        Kaijin
        Youkai
        Daikaiju
        Kaiju
        */
        
    }
}
