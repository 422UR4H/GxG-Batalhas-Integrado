/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.ficha;

import ficha_personagem.Armas;
import ficha_personagem.Ficha;
import ficha_personagem.Habilidades;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author 422UR4H
 */
public class CalculadoraFicha {
    private static int pontos;
    private static int EXP_LVL[] = new int[AlgoritmoPrincipalFicha.getEXP_LVL_MAX()];
    private static int EXP_NEN[] = new int[AlgoritmoPrincipalFicha.getEXP_NEN_MAX()];
    private static int LVL_NEN[] = new int[AlgoritmoPrincipalFicha.getLVL_NEN_MAX()];
    private static final Map<String, Armas> ARMAS = new HashMap<>();
    
    
    public static void initArmas() {
        Armas arteMarcial = new Armas();
        arteMarcial.setNome("Arte marcial");
        arteMarcial.setDados("D4");
        arteMarcial.setDano(0);
        ARMAS.put(arteMarcial.getNome(), arteMarcial);
        
        Armas adagas = new Armas();
        adagas.setNome("Adaga");
        adagas.setDados("D8");
        adagas.setDano(5);
        ARMAS.put(adagas.getNome(), adagas);
        
        Armas adagasDeA = new Armas();
        adagasDeA.setNome("Adaga de a.");
        adagasDeA.setDados("D8");
        adagasDeA.setDano(2);
        ARMAS.put(adagasDeA.getNome(), adagasDeA);
        
        Armas alabarda = new Armas();
        alabarda.setNome("Alabarda (longa)");
        alabarda.setDados("D12 D10 D6");
        alabarda.setDano(1);
        ARMAS.put(alabarda.getNome(), alabarda);
        
        Armas arco = new Armas();
        arco.setNome("Arco");
        arco.setDados("D12");
        arco.setDano(3);
        arco.setCritico(3);
        arco.setPerfurante(true);
        ARMAS.put(arco.getNome(), arco);
        
        Armas arcoLongo = new Armas();
        arcoLongo.setNome("Arco longo");
        arcoLongo.setDados("2D12");
        arcoLongo.setDano(3);
        arcoLongo.setCritico(3);
        ARMAS.put(arcoLongo.getNome(), arcoLongo);
        
        Armas bastao = new Armas();
        bastao.setNome("Bastão");
        bastao.setDados("D10 D8");
        ARMAS.put(bastao.getNome(), bastao);
        
        Armas cimitarra = new Armas();
        cimitarra.setNome("Cimitarra");
        cimitarra.setDados("D6 D4");
        cimitarra.setDano(4);
        ARMAS.put(cimitarra.getNome(), cimitarra);
        
        Armas chicote = new Armas();
        chicote.setNome("Chicote");
        chicote.setDados("2D4 D8");
        ARMAS.put(chicote.getNome(), chicote);
        
        Armas clava = new Armas();
        clava.setNome("Clava");
        clava.setDados("2D8");
        clava.setDano(1);
        ARMAS.put(clava.getNome(), clava);
        
        Armas clavaLonga = new Armas();
        clavaLonga.setNome("Clava longa");
        clavaLonga.setDados("2D8 D12");
        clavaLonga.setDano(1);
        ARMAS.put(clavaLonga.getNome(), clavaLonga);
        
        Armas espada = new Armas();
        espada.setNome("Espada");
        espada.setDados("D10 D4");
        espada.setDano(2);
        ARMAS.put(espada.getNome(), espada);
        
        Armas espadaLonga = new Armas();
        espadaLonga.setNome("Espada longa");
        espadaLonga.setDados("D12 D10 D4");
        espadaLonga.setDano(2);
        ARMAS.put(espadaLonga.getNome(), espadaLonga);
        
        Armas foice = new Armas();
        foice.setNome("Foice");
        foice.setDados("2D4 D6");
        foice.setDano(2);
        ARMAS.put(foice.getNome(), foice);
        
        Armas foiceLonga = new Armas();
        foiceLonga.setNome("Foice longa");
        foiceLonga.setDados("2D4 D6 D12");
        foiceLonga.setDano(2);
        ARMAS.put(foiceLonga.getNome(), foiceLonga);
        
        Armas katana = new Armas();
        katana.setNome("Katana");
        katana.setDados("D12 D4");
        katana.setDano(7);
        katana.setCritico(3);
        ARMAS.put(katana.getNome(), katana);
        
        Armas katar = new Armas();
        katar.setNome("Katar");
        katar.setDados("D6");
        katar.setDano(6);
        katar.setCritico(3);
        ARMAS.put(katar.getNome(), katar);
        
        Armas lanca = new Armas();
        lanca.setNome("Lança");
        lanca.setDados("D8 D4");
        lanca.setDano(3);
        ARMAS.put(lanca.getNome(), lanca);
        
        Armas lancaLonga = new Armas();
        lancaLonga.setNome("Lança longa");
        lancaLonga.setDados("D12 D8 D4");
        lancaLonga.setDano(3);
        ARMAS.put(lancaLonga.getNome(), lancaLonga);
        
        Armas machado = new Armas();
        machado.setNome("Machado");
        machado.setDados("D10 D6");
        machado.setDano(1);
        ARMAS.put(machado.getNome(), machado);
        
        Armas machadoLongo = new Armas();
        machadoLongo.setNome("Machado longo");
        machadoLongo.setDados("D12 D10 D6");
        machadoLongo.setDano(1);
        ARMAS.put(machadoLongo.getNome(), machadoLongo);
        
        Armas machadoDeA = new Armas();
        machadoDeA.setNome("Machadinha");
        machadoDeA.setDados("D10");
        machadoDeA.setDano(1);
        ARMAS.put(machadoDeA.getNome(), machadoDeA);
        
        Armas martelo = new Armas();
        martelo.setNome("Martelo");
        martelo.setDados("D12 D6");
        ARMAS.put(martelo.getNome(), martelo);
        
        Armas marreta = new Armas();
        marreta.setNome("Marreta");
        marreta.setDados("2D12 D6");
        ARMAS.put(marreta.getNome(), marreta);
        
        Armas marteloDeA = new Armas();
        marteloDeA.setNome("Martelo de a.");
        marteloDeA.setDados("D12");
        ARMAS.put(marteloDeA.getNome(), marteloDeA);
        
        Armas massaMangual = new Armas();
        massaMangual.setNome("Massa/Mangual");
        massaMangual.setDados("D12 D4");
        massaMangual.setDano(1);
        ARMAS.put(massaMangual.getNome(), massaMangual);
        
        Armas massaLonga = new Armas();
        massaLonga.setNome("Massa longa");
        massaLonga.setDados("2D12 D4");
        massaLonga.setDano(1);
        ARMAS.put(massaLonga.getNome(), massaLonga);
        
        Armas nuntchaco = new Armas();
        nuntchaco.setNome("Nuntchaco");
        nuntchaco.setDados("D10");
        nuntchaco.setDano(4);
        ARMAS.put(nuntchaco.getNome(), nuntchaco);
        
        Armas nuntchacoTriplo = new Armas();
        nuntchacoTriplo.setNome("Nuntchaco triplo");
        nuntchacoTriplo.setDados("2D6");
        nuntchacoTriplo.setDano(3);
        ARMAS.put(nuntchacoTriplo.getNome(), nuntchacoTriplo);
        
        Armas picareta = new Armas();
        picareta.setNome("Picareta");
        picareta.setDados("D8 D6");
        picareta.setDano(2);
        ARMAS.put(picareta.getNome(), picareta);
        
        Armas picaretaLonga = new Armas();
        picaretaLonga.setNome("Picareta longa");
        picaretaLonga.setDados("D12 D8 D6");
        picaretaLonga.setDano(2);
        ARMAS.put(picaretaLonga.getNome(), picaretaLonga);
        
        Armas punhos = new Armas();
        punhos.setNome("Punhos");
        punhos.setDados("2D6 D4");
        ARMAS.put(punhos.getNome(), punhos);
        
        Armas rapieira = new Armas();
        rapieira.setNome("Rapieira");
        rapieira.setDados("2D4");
        rapieira.setDano(5);
        ARMAS.put(rapieira.getNome(), rapieira);
        
        Armas tridente = new Armas();
        tridente.setNome("Tridente");
        tridente.setDados("3D8"); // Dano original: 2 D6 + 3
        tridente.setDano(3);
        ARMAS.put(tridente.getNome(), tridente);
        
        Armas ak47 = new Armas();
        ak47.setNome("AK-47");
        ak47.setDados("2D12 2D8");
        ak47.setDano(1);
        ak47.setCritico(3);
        ak47.setPerfurante(true);
        ARMAS.put(ak47.getNome(), ak47);
        
        Armas ar15 = new Armas();
        ar15.setNome("AR-15");
        ar15.setDados("2D10");
        ar15.setDano(6);
        ar15.setCritico(3);
        ar15.setPerfurante(true);
        ARMAS.put(ar15.getNome(), ar15);
        
        Armas besta = new Armas();
        besta.setNome("Besta");
        besta.setDados("3D12");
        besta.setDano(2);
        besta.setCritico(3);
        besta.setPerfurante(true);
        ARMAS.put(besta.getNome(), besta);
        
        Armas metralhadora = new Armas();
        metralhadora.setNome("Metralhadora");
        metralhadora.setDados("D12 D10");
        metralhadora.setDano(3);
        metralhadora.setCritico(3);
        metralhadora.setPerfurante(true);
        ARMAS.put(metralhadora.getNome(), metralhadora);
        
        Armas pistola = new Armas();
        pistola.setNome("Pistola .38");
        pistola.setDados("D12");
        pistola.setDano(4);
        pistola.setCritico(3);
        pistola.setPerfurante(true);
        ARMAS.put(pistola.getNome(), pistola);
        
        Armas pistolaLazer = new Armas();
        pistolaLazer.setNome("Pistola lazer");
        pistolaLazer.setDados("D12");
        pistolaLazer.setDano(8);
        pistolaLazer.setCritico(2);
        pistolaLazer.setPerfurante(true);
        ARMAS.put(pistolaLazer.getNome(), pistolaLazer);
        
        Armas rifle = new Armas();
        rifle.setNome("Rifle");
        rifle.setDados("D12 D10");
        rifle.setDano(8);
        rifle.setCritico(3);
        rifle.setPerfurante(true);
        ARMAS.put(rifle.getNome(), rifle);
        
        Armas uzi = new Armas();
        uzi.setNome("Uzi");
        uzi.setDados("D12 D8");
        uzi.setDano(1);
        uzi.setCritico(3);
        uzi.setPerfurante(true);
        ARMAS.put(uzi.getNome(), uzi);
        
        
        Armas fogo1 = new Armas();
        fogo1.setNome("Fogo 1");
        fogo1.setDados("D12");
        ARMAS.put(fogo1.getNome(), fogo1);
        
        Armas raio1 = new Armas();
        raio1.setNome("Raio 1");
        raio1.setDados("D12");
        ARMAS.put(raio1.getNome(), raio1);
        
        Armas acido1 = new Armas();
        acido1.setNome("Acido 1");
        acido1.setDados("D12");
        ARMAS.put(acido1.getNome(), acido1);
        
        Armas trevas1 = new Armas();
        trevas1.setNome("Trevas 1");
        trevas1.setDados("D12");
        ARMAS.put(trevas1.getNome(), trevas1);
        
        Armas madeira1 = new Armas();
        madeira1.setNome("Madeira 1");
        madeira1.setDados("D10");
        madeira1.setDano(1);
        ARMAS.put(madeira1.getNome(), madeira1);
        
        Armas gelo1 = new Armas();
        gelo1.setNome("Gelo 1");
        gelo1.setDados("D10");
        gelo1.setDano(1);
        ARMAS.put(gelo1.getNome(), gelo1);
        
        Armas terra1 = new Armas();
        terra1.setNome("Terra 1");
        terra1.setDados("D10");
        terra1.setDano(1);
        ARMAS.put(terra1.getNome(), terra1);
        
        Armas metal = new Armas();
        metal.setNome("Metal 1");
        metal.setDados("D10");
        metal.setDano(1);
        ARMAS.put(metal.getNome(), metal);
        
        Armas fogo2 = new Armas();
        fogo2.setNome("Fogo 2");
        fogo2.setDados("2D12");
        ARMAS.put(fogo2.getNome(), fogo2);
        
        Armas raio2 = new Armas();
        raio2.setNome("Raio 2");
        raio2.setDados("2D12");
        ARMAS.put(raio2.getNome(), raio2);
        
        Armas acido2 = new Armas();
        acido2.setNome("Acido 2");
        acido2.setDados("2D12");
        ARMAS.put(acido2.getNome(), acido2);
        
        Armas trevas2 = new Armas();
        trevas2.setNome("Trevas 2");
        trevas2.setDados("2D12");
        ARMAS.put(trevas2.getNome(), trevas2);
        
        Armas madeira = new Armas();
        madeira.setNome("Madeira 2");
        madeira.setDados("2D10");
        madeira.setDano(2);
        ARMAS.put(madeira.getNome(), madeira);
        
        Armas gelo2 = new Armas();
        gelo2.setNome("Gelo 2");
        gelo2.setDados("2D10");
        gelo2.setDano(2);
        ARMAS.put(gelo2.getNome(), gelo2);
        
        Armas terra2 = new Armas();
        terra2.setNome("Terra 2");
        terra2.setDados("2D10");
        terra2.setDano(2);
        ARMAS.put(terra2.getNome(), terra2);
        
        Armas meta2 = new Armas();
        meta2.setNome("Metal 2");
        meta2.setDados("2D10");
        meta2.setDano(2);
        ARMAS.put(meta2.getNome(), meta2);
        
        Armas fogo3 = new Armas();
        fogo3.setNome("Fogo 3");
        fogo3.setDados("3D12");
        ARMAS.put(fogo3.getNome(), fogo3);
        
        Armas raio3 = new Armas();
        raio3.setNome("Raio 3");
        raio3.setDados("3D12");
        ARMAS.put(raio3.getNome(), raio3);
        
        Armas acido3 = new Armas();
        acido3.setNome("Acido 3");
        acido3.setDados("3D12");
        ARMAS.put(acido3.getNome(), acido3);
        
        Armas trevas3 = new Armas();
        trevas3.setNome("Trevas 3");
        trevas3.setDados("3D12");
        ARMAS.put(trevas3.getNome(), trevas3);
        
        Armas madeira3 = new Armas();
        madeira3.setNome("Madeira 3");
        madeira3.setDados("3D10");
        madeira3.setDano(3);
        ARMAS.put(madeira3.getNome(), madeira3);
        
        Armas gelo3 = new Armas();
        gelo3.setNome("Gelo 3");
        gelo3.setDados("3D10");
        gelo3.setDano(3);
        ARMAS.put(gelo3.getNome(), gelo3);
        
        Armas terra3 = new Armas();
        terra3.setNome("Terra 3");
        terra3.setDados("3D10");
        terra3.setDano(3);
        ARMAS.put(terra3.getNome(), terra3);
        
        Armas meta3 = new Armas();
        meta3.setNome("Metal 3");
        meta3.setDados("3D10");
        meta3.setDano(3);
        ARMAS.put(meta3.getNome(), meta3);
        
        Armas fogo4 = new Armas();
        fogo4.setNome("Fogo 4");
        fogo4.setDados("4D12");
        ARMAS.put(fogo4.getNome(), fogo4);
        
        Armas raio4 = new Armas();
        raio4.setNome("Raio 4");
        raio4.setDados("4D12");
        ARMAS.put(raio4.getNome(), raio4);
        
        Armas acido4 = new Armas();
        acido4.setNome("Acido 4");
        acido4.setDados("4D12");
        ARMAS.put(acido4.getNome(), acido4);
        
        Armas trevas4 = new Armas();
        trevas4.setNome("Trevas 4");
        trevas4.setDados("4D12");
        ARMAS.put(trevas4.getNome(), trevas4);
        
        Armas madeira4 = new Armas();
        madeira4.setNome("Madeira 4");
        madeira4.setDados("4D10");
        madeira4.setDano(4);
        ARMAS.put(madeira4.getNome(), madeira4);
        
        Armas gelo4 = new Armas();
        gelo4.setNome("Gelo 4");
        gelo4.setDados("4D10");
        gelo4.setDano(4);
        ARMAS.put(gelo4.getNome(), gelo4);
        
        Armas terra4 = new Armas();
        terra4.setNome("Terra 4");
        terra4.setDados("4D10");
        terra4.setDano(4);
        ARMAS.put(terra4.getNome(), terra4);
        
        Armas meta4 = new Armas();
        meta4.setNome("Metal 4");
        meta4.setDados("4D10");
        meta4.setDano(4);
        ARMAS.put(meta4.getNome(), meta4);
    }
    
    public static int calculaDano(Ficha ficha, Habilidades habilidade) {
        int dano;
        
        dano = habilidade.getDanoFixo();
        
        if (!habilidade.getProficiencia().equals("NENHUMA")) {
            dano += ficha.getPro().get(habilidade.getProficiencia()).getLvl();
        }
        
        if (!habilidade.getArma().equals("Nenhuma")) {
            try {
                dano += ARMAS.get(habilidade.getArma()).getDano();
            } catch (NullPointerException e) {
                // APAGAR ISSO DEPOIS QUE ARRUMAR O ERRO
                JOptionPane.showMessageDialog(null, "Erro! reporte ao programador o nome da arma. Arma: "+
                        habilidade.getArma(), "erro", JOptionPane.ERROR_MESSAGE);
                System.out.println("Error: arrume isso, hazzurah");
                System.out.println("Error: personagem" + ficha.getNick());
                System.out.println("Error: arma" + habilidade.getArma());
            }
        }
        
        if (habilidade.isSomarFor()) {
            dano += ficha.getPerFor() * habilidade.getQtdFor();
        }
        if (habilidade.isSomarCon()) {
            dano += ficha.getPerCon() * habilidade.getQtdCon();
        }
        if (habilidade.isSomarDex()) {
            dano += ficha.getPerDex() * habilidade.getQtdDex();
        }
        if (habilidade.isSomarInt()) {
            dano += ficha.getPerInt() * habilidade.getQtdInt();
        }
        if (habilidade.isSomarCar()) {
            dano += ficha.getPerCar() * habilidade.getQtdCar();
        }
        if (habilidade.isSomarMen()) {
            dano += ficha.getPerMen() * habilidade.getQtdMen();
        }
        
        if (habilidade.isSomarRef()) {
            dano += ficha.getPerRef() * habilidade.getQtdRef();
        }
        if (habilidade.isSomarEms()) {
            dano += ficha.getPerEms() * habilidade.getQtdEms();
        }
        if (habilidade.isSomarMan()) {
            dano += ficha.getPerMan() * habilidade.getQtdMan();
        }
        if (habilidade.isSomarMat()) {
            dano += ficha.getPerMat() * habilidade.getQtdMat();
        }
        if (habilidade.isSomarTrs()) {
            dano += ficha.getPerTrs() * habilidade.getQtdTrs();
        }
        if (habilidade.isSomarEsp()) {
            dano += ficha.getPerEsp() * habilidade.getQtdEsp();
        }
        
        if (habilidade.isSomarVel()) {
            dano += ficha.getVel() * habilidade.getQtdVel();
        }
        if (habilidade.isSomarEsq()) {
            dano += ficha.getEsq() * habilidade.getQtdEsq();
        }
        if (habilidade.isSomarTen()) {
            dano += ficha.getPerTen() * habilidade.getQtdTen();
        }
        if (habilidade.isSomarAop()) {
            dano += ficha.getAop() * habilidade.getQtdAop();
        }
        if (habilidade.isSomarMop()) {
            dano += ficha.getMop() * habilidade.getQtdMop();
        }
        if (habilidade.isSomarCdn()) {
            dano += ficha.getPerCdn() * habilidade.getQtdCdn();
        }
        
        return dano;
    }
    
    // getters e setters
    public static void incrementarPontos() {
        pontos++;
    }
    
    public static void decrementarPontos() {
        pontos--;
    }
    
    public static int getPontos() {
        return pontos;
    }

    public static void setPontos(int pontos) {
        CalculadoraFicha.pontos = pontos;
    }

    public static void setEXP_LVL(int[] EXP_LVL) {
        CalculadoraFicha.EXP_LVL = EXP_LVL;
    }

    public static void setEXP_NEN(int[] EXP_NEN) {
        CalculadoraFicha.EXP_NEN = EXP_NEN;
    }

    public static void setLVL_NEN(int[] LVL_NEN) {
        CalculadoraFicha.LVL_NEN = LVL_NEN;
    }
    
    public static int calculaLvlNen(int exp) {
        // calculando lvlNen
        int i;
        for (i = 0; exp >= 0; i++) {
            exp -= AlgoritmoPrincipalFicha.getLVL_NEN(i + 1);
        }
        i--;
        // exp que sobra
//        exp += AlgoritmoPrincipalGerador.getLVL_NEN(i + 1);
        return i;
    }
    
    public static int calculaExpLvlNen(int lvl) {
        int exp = 0;
        // a posição 0 do vetor tem o valor 0, logo nao conta
        for (int i = 1; i <= lvl; i++) {
            exp += LVL_NEN[i];
        }
        return exp;
    }
    
    public static int calculaExp(int lvl) {
        int exp = 0;
        // a posição 0 do vetor tem o valor 0, logo nao conta
        for (int i = 1; i <= lvl; i++) {
            exp += EXP_NEN[i];
        }
        return exp;
    }
    
    public static int calculaExpMop(int lvl) {
        int exp = 0;
        for (int i = 2; i <= lvl; i++) {
            exp += i * 10 + 80;
        }
        return exp;
    }
    
    public static int getRen(double refPratico, int aop, int ten) {
        if (ten < aop) {
            aop = ten;
        }
        return (int) ((refPratico / 10 + 1) * aop);
    }
}
