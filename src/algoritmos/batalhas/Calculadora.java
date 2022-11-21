/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.batalhas;
import ficha_personagem.Ficha;
import ficha_personagem.Habilidades;
import java.util.Vector;
import javax.swing.JOptionPane;
import view.batalhas.ViewEstatisticas;
import view.batalhas.View_stun;

/**
 *
 * @author 422UR4H
 */
public class Calculadora {
    private static Ficha atacante = null;
    private static Ficha defensor = null;
    
    private static int investidaAtacante = 0;
    private static int investidaDefensor = 0;
    private static int ryuInvestidaAtacante = 0;
    private static int ryuInvestidaDefensor = 0;
    private static int investida = 0;
    
    private static int modCritico = 2;
    private static int dano_stun = 0;
    
    private static int dano = 0;
    private static int danoFinal = 0;
    private static int danoFinalPassivo = 0;
    private static int danoCritico = 0;
    
    private static int defesa = 0;
    private static int defesaPassiva = 0;
    
    private static Vector<EstatisticasDeBatalha> estatistica = new Vector<>();
    

    public static void init() {
        
    }
    
    public static void finish() {
        // setando valores default
        atacante = null;
        defensor = null;
        
        investidaAtacante = 0;
        investidaDefensor = 0;
        ryuInvestidaAtacante = 0;
        ryuInvestidaDefensor = 0;
        investida = 0;
        
        modCritico = 2;
        dano_stun = 0;
        
        dano = 0;
        danoFinal = 0;
        danoFinalPassivo = 0;
        danoCritico = 0;
        
        defesa = 0;
        defesaPassiva = 0;
        
        estatistica.clear();
    }
    
    public static int getDanoFinalPassivo() {
        return danoFinalPassivo;
    }

    public static void setDanoFinalPassivo(int danoFinalPassivo) {
        Calculadora.danoFinalPassivo = danoFinalPassivo;
    }

    public static void setDefesaPassiva(int defesaPassiva) {
        Calculadora.defesaPassiva = defesaPassiva;
    }

    public static Vector<EstatisticasDeBatalha> getEstatistica() {
        return estatistica;
    }

    public static void setRyuInvestidaAtacante(int ryuInvestidaAtacante) {
        Calculadora.ryuInvestidaAtacante = ryuInvestidaAtacante;
    }

    public static int getRyuInvestidaAtacante() {
        return ryuInvestidaAtacante;
    }

    public static int getRyuInvestidaDefensor() {
        return ryuInvestidaDefensor;
    }

    public static void setRyuInvestidaDefensor(int ryuInvestidaDefensor) {
        Calculadora.ryuInvestidaDefensor = ryuInvestidaDefensor;
    }

    public static int getDano_stun() {
        return dano_stun;
    }

    public static int getDanoFinal() {
        return danoFinal;
    }

    public static void setDanoFinal(int danoFinal) {
        Calculadora.danoFinal = danoFinal;
    }
    
    public static void setDanoCritico(int danoCritico) {
        Calculadora.danoCritico = danoCritico;
    }
    
    public static int getDefesa() {
        return defesa;
    }
    
    public static void setDefesa(int defesa) {
        Calculadora.defesa = defesa;
    }
    
    public static int getModCritico() {
        return modCritico;
    }

    public static void setModCritico(int modCritico) {
        Calculadora.modCritico = modCritico;
    }

    public static int getDano() {
        return dano;
    }

    public static void setDano(int dano) {
        Calculadora.dano = dano;
    }
    
    public static int getInvestidaAtacante() {
        return investidaAtacante;
    }
    
    public static int getInvestidaAtacanteMs() {
        return (int) Math.floor((double) investidaAtacante / 3.6);
    }

    public static void setInvestidaAtacante(int investidaAtacante) {
        Calculadora.investidaAtacante = investidaAtacante;
    }

    public static int getInvestidaDefensor() {
        return investidaDefensor;
    }

    public static int getInvestidaDefensorMs() {
        return (int) Math.floor((double) investidaDefensor / 3.6);
    }

    public static void setInvestidaDefensor(int investidaDefensor) {
        Calculadora.investidaDefensor = investidaDefensor;
    }

    public static void setInvestida(int investida) {
        Calculadora.investida = investida;
    }
    
    public static int getDanoCritico() {
        return danoCritico;
    }
    
    public static int calculaDanoCritico(int danoFinal) {
        return danoFinal * modCritico;
    }
    
    public static void setDefensor(Ficha defensor) {
        Calculadora.defensor = defensor;
    }

    public static void setAtacante(Ficha atacante) {
        Calculadora.atacante = atacante;
    }

    public static Ficha getAtacante() {
        return atacante;
    }

    public static Ficha getDefensor() {
        return defensor;
    }
    
    public static int getDanoRebote(boolean ems, int defesa, int dano, int perCon) {
        if (!ems && (defesa - (dano + perCon)) < 0) {
            return defesa - (dano + perCon);
        }
        return 0;
    }
    
    public static int getDanoRebote(boolean rebote, int perCon) {
        if (rebote && (defesa - (dano + perCon)) > 0) {
            return defesa - (dano + perCon);
        }
        return 0;
    }
    
    public static int getInvestida() {
        return investida;
    }
    
    /*public static void calculaInvestida() {
        investida = (int) (Math.floor(3.6 * atacante.getKen(ryuInvestidaAtacante, 0)) +
                    Math.floor(3.6 * defensor.getKen(ryuInvestidaDefensor, 0)) +
                    atacante.getVelMs() + defensor.getVelMs());
    }*/
    
    public static void calculaInvestida() {
        investida = investidaAtacante + investidaDefensor + ryuInvestidaAtacante + ryuInvestidaDefensor;
    }
    
    public static int getLvlCdn(int modCdn) {
        if (modCdn < 3) {
            return 0;
        } else if (modCdn < 6) {
            return 1;
        } else if (modCdn < 12) {
            return 2;
        } else if (modCdn < 24) {
            return 3;
        } else if (modCdn < 48) {
            return 4;
        } else if (modCdn < 96) {
            return 5;
        } else {
            return 6;
        }
    }
    
    public static int getRen(Ficha personagem, int ryu) {
        double modClas = personagem.getModClas();
        //double pop = personagem.getPop();
        double pop = Calculadora.getPop(personagem.getAtrRef(), modClas);
        int aop = personagem.getAop();
        //double ryuCalculado = personagem.getRyu(ryu, pop * aop); // ja esta dividido por corpo
        double ryuCalculado = Calculadora.getRyu(ryu, personagem.getCorpo().getValor(), pop * aop);
        //int danoTotal = (int) Math.floor(modClas * ryuCalculado);
        return (int) ryuCalculado;
    }
    
    public static int getRen(Ficha personagem, int ryu, String nen) {
        double pop = Calculadora.getPop(personagem.getAtrRef(), nen);
        int aop = personagem.getAop();
        double ryuCalculado = Calculadora.getRyu(ryu, personagem.getCorpo().getValor(), pop * aop);
        return (int) ryuCalculado;
    }
    
    public static int getRenLivre(Ficha personagem, int ryu) {
        double pop = Calculadora.getPop(personagem.getAtrRef(), personagem.getNen());
        int aop = personagem.getAop();
        double ryuCalculado = (pop * aop); // calculo sem a divisao por corpo
        int danoTotal = (int) Math.floor(ryuCalculado);
        return danoTotal;
    }
    
    public static int getDano(String nomeSkill, String categoriaNen, double ryu, int dado, double bonus, boolean consomeAura) {
        double restricao;
        int damage;
        int corpo = atacante.getCorpo().getValor();
        bonus /= 2.0;
        
        if (nomeSkill.equals("FISICO")) {
            restricao = 1;
            damage = atacante.getPerFor();
        } else {
            Habilidades habilidade = atacante.getHabilidade(nomeSkill);
            restricao = habilidade.getRestricao();
            damage = habilidade.getDano();
            // algoritmo novo que calcula trs
            if (habilidade.isSomarTrs() && consomeAura) {
                damage -= (habilidade.getQtdTrs() * atacante.getPerTrs());
                damage += (int) (ryu / 50.0 * habilidade.getQtdTrs() * atacante.getPerTrs());
            }
            // calculando o proporcional de aura bonus
            if (habilidade.getVol() == 2) {
                bonus *= 2;
            }
            if (habilidade.getVol() == 3) {
                bonus *= 1.5;
            }
        }
        
        // se o personagem tiver usado mais aura no ryu, a quantidade de corpo não importa
        if (ryu > 50) {
            corpo = 100;
        }
        
        double pop = Calculadora.getPop(atacante.getAtrRef(), categoriaNen);
        //int aop = atacante.getAop() + bonus;
        //double ryuCalculado = Calculadora.getRyu(ryu, atacante.getCorpo().getValor(), pop * aop);
        int aop = atacante.getAop();
        int nen = (int) (pop * (bonus + ryu * aop / corpo));
        //int danoTotal = (int) (investida + restricao * (damage + dado + (int) ryuCalculado));
        int danoTotal = (int) (investida + restricao * (damage + dado + nen));
        
        return danoTotal;
    }
    
    public static double getPop(double ref, String nen) {
        double modClas = 1.0;
        switch (nen) {
            case "Reforco" :
                modClas = 1.0;
                break;
            case "Emissao" :
                modClas = 0.8;
                break;
            case "Transformacao" :
                modClas = 0.8;
                break;
            case "Materializacao" :
                modClas = 0.6;
                break;
            case "Manipulacao" :
                modClas = 0.6;
                break;
            case "Especialista" :
                modClas = 0.4;
                break;
            default :
                JOptionPane.showMessageDialog(null, "ERRO ABSURDO!",
                        "Reporte imediatamente ao programador!", JOptionPane.ERROR_MESSAGE);
        }
        return 1 + (Math.floor(modClas * ref) / 10.0);
    }
    
    public static double getPop(int ref, double modClas) {
        return 1 + ((modClas * ref) / 10.0);
    }
    
    public static double getRyu(int ryu, int corpo, double ren) {
        return ren * ryu / (double) corpo;
    }
    
    public static int getDefesa(String nomeSkill, String nen, boolean defendeu, int ryu, int dado, double bonus, boolean consomeAura) {
        double restricao;
        int defense;
        int corpo = defensor.getCorpo().getValor();
        bonus /= 2;
        
        if (nomeSkill.equals("SEM DEFESA")) {
            restricao = 1;
            defense = 0;
        } else {
            Habilidades habilidade = defensor.getHabilidade(nomeSkill);
            restricao = habilidade.getRestricao();
            defense = habilidade.getDano();
            // algoritmo novo que calcula trs
            if (habilidade.isSomarTrs() && consomeAura) {
                defense -= (habilidade.getQtdTrs() * defensor.getPerTrs());
                defense += (int) ((double) ryu / 100.0 * (habilidade.getQtdTrs() * defensor.getPerTrs()));
            }
            // calculando o proporcional de aura bonus
            if (habilidade.getVol() == 2) {
                bonus *= 2;
            }
            if (habilidade.getVol() == 3) {
                bonus *= 1.5;
            }
        }
        
        // se o personagem tiver usado mais aura no ryu, a quantidade de corpo não importa
        if (ryu > 50) {
            corpo = 100;
        }
        
        double pop = Calculadora.getPop(defensor.getAtrRef(), nen);
        int aop = (int) (defensor.getAop() + bonus);
        double ryuCalculado = Calculadora.getRyu(ryu, corpo, pop * aop);
        if (defendeu) {
            defense += defensor.getPerFor();
        }
        int defesaFinal = (int) Math.floor(restricao * (defense + dado + (int) ryuCalculado));
        
        return defesaFinal;
    }
    
    public static int getDefesaPassiva(String categoriaNen, boolean defendeu, int ryu) {
        int defense;
        
        if (defendeu) {
            defense = defensor.getModFor();
        } else {
            defense = 0;
        }
        
        double pop = Calculadora.getPop(defensor.getAtrRef(), categoriaNen);
        int aop = defensor.getAop();
        double ryuCalculado = defensor.getRyu(ryu, pop * aop); // ja esta dividido pelo corpo
        int nen = (int) Math.floor(ryuCalculado);
        int passiveDefense = defense + nen;
        
        return passiveDefense;
    }
    
    public static int calculaDanoFinalPassivo(int dano, boolean ems, boolean perfurante) {
        if (ems) {
            //dano *= 2;
        }
        if (!perfurante) {
            dano -= defesaPassiva;
        } else {
            dano -= (int) Math.floor((double) defesaPassiva / 10);
        }
        return dano;
    }
    
    public static int calculaDanoFinal(int dano, boolean ems, boolean perfurante) {
        if (ems) {
            //dano *= 2;
        }
        if (!perfurante) {
            dano -= defesa;
        } else {
            dano -= (int) Math.floor((double) defesa / 10);
        }
        return dano;
    }
    
    public static int calculaDanoFinal(int dano, int defesa, boolean ems, boolean perfurante) {
        if (ems) {
            dano *= 2;
        }
        // subtraindo da defesa
        if (!perfurante) {
            dano -= defesa;
        } else {
            dano -= (int) Math.floor((double) defesa / 10);
        }
        return dano;
    }
    
    private static void reduzirHp(EstatisticasDeBatalha edb, Ficha defensor) {
        edb.reduzHp();
                
        EstatisticasDeBatalha temp = new EstatisticasDeBatalha(edb.getHp(), edb.getDano());

        estatistica.add(temp);

        // aplicando stun, se danoCritico for maior que a pericia de con
        if (dano_stun > defensor.getPerCon()) {
            new View_stun(null, true).setVisible(true);
        }
    }
    
    public static void aplicaDano(int qtdAcerto, int qtdCritico, int qtdDefesa, Ficha defensor) {
        int iterador = 0;
        EstatisticasDeBatalha edb = new EstatisticasDeBatalha();
        estatistica.clear();
        
        // setando defensor em personagem
        AlgoritmoPrincipal.setFicha(defensor);
        
        // corrigindo qtdCritico e qtdAcerto
        if (qtdCritico > qtdAcerto) {
            qtdCritico = qtdAcerto;
            qtdAcerto = 0;
        } else {
            qtdAcerto -= qtdCritico;
        }
        
        // aplicando dano
        edb.setHp(defensor.getHpAtual());
        if (qtdCritico > qtdDefesa) {
            danoCritico = calculaDanoCritico(danoFinal);
            dano_stun = danoCritico;
            edb.setDano(danoCritico);
            while (qtdDefesa > 0) { // critico VS defesa
                reduzirHp(edb, defensor);
                
                qtdDefesa--;
                qtdCritico--;
                iterador++;
            }
            danoCritico = calculaDanoCritico(danoFinalPassivo);
            dano_stun = danoCritico;
            edb.setDano(danoCritico);
            while (qtdCritico > 0) { // critico VS passiva
                reduzirHp(edb, defensor);
                
                qtdCritico--;
                iterador++;
            }
        } else { // qtdCritico <= qtdDefesa
            danoCritico = calculaDanoCritico(danoFinal);
            dano_stun = danoCritico;
            edb.setDano(danoCritico);
            while (qtdCritico > 0) { // critico VS defesa
                reduzirHp(edb, defensor);
                
                qtdCritico--;
                qtdDefesa--;
                iterador++;
            }
            dano_stun = danoFinal;
            edb.setDano(danoFinal);
            while (qtdDefesa > 0 && qtdAcerto > 0) { // dano VS defesa
                reduzirHp(edb, defensor);
                
                qtdDefesa--;
                qtdAcerto--;
                iterador++;
            }
        }
        dano_stun = danoFinalPassivo;
        edb.setDano(danoFinalPassivo);
        while (qtdAcerto > 0) { // dano VS passiva
            reduzirHp(edb, defensor);
            
            qtdAcerto--;
            iterador++;
        }
        
        // invocando Estatisticas
        if (iterador > 1) {
            AlgoritmoPrincipal.setFicha(defensor);
            new ViewEstatisticas().setVisible(true);
        }
        
        // linha importante - aplicando dano
        defensor.setHpAtual(estatistica.get(iterador - 1).getHp());
        
        // salvando para mostrar na label da ViewPrincipal
        AlgoritmoPrincipal.setValor(edb.getDano());
    }
    
    /*public static boolean aplicaDano(int qtdAcerto, int qtdCritico, int qtdDefesa, Ficha defensor) {
        EstatisticasDeBatalha edb = new EstatisticasDeBatalha();
        Ficha temp = Calculadora.defensor;
        int ultimaIteracaoHp = 0;
        estatistica.clear();
        
        // testando se é dano padrão ou dano de rebote
        if (defensor == Calculadora.defensor) {
            qtdAcerto -= qtdCritico;
        } else if (defensor == Calculadora.atacante) {
            // trocando atacante por defensor
            qtdAcerto += qtdCritico;
            qtdCritico = 0;
            Calculadora.defensor = atacante;
            Calculadora.atacante = temp;
            temp = atacante;
        } else {
            
            JOptionPane.showMessageDialog(null,
                "Escolha atacante e defensor antes de continuar!",
                "Logic Error!", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
        
        // INICIO
        
        AlgoritmoPrincipal.setPersonagem(defensor);
        
        // aplicando dano
        edb.setHp(defensor.getHpAtual());
        if (qtdDefesa > 0) {
            danoCritico = calculaDanoCritico(danoFinal);
        } else {
            danoCritico = calculaDanoCritico(danoFinalPassivo);
        }
        edb.setDano(danoCritico);
        dano_stun = danoCritico;
        for (int i = 0; i < qtdCritico; i++)  {
            EstatisticasDeBatalha dados = new EstatisticasDeBatalha();
            System.out.println("edb.getDano()" + edb.getDano());
            // calcula dano
            System.out.println("edb.getHp()" + edb.getHp());
            edb.reduzHp();
            System.out.println("edb.getHp()" + edb.getHp());
            // setando valores em dados
            dados.setDano(edb.getDano());
            dados.setHp(edb.getHp());
            estatistica.add(dados);
            
            // aplicando stun, se danoCritico for maior que a pericia de con
            if (danoCritico > defensor.getPerCon()) {
                new ViewStun().setVisible(true);
            }
            
            qtdDefesa--;
            if (qtdDefesa <= 0) { // programacao defensiva
                danoCritico = calculaDanoCritico(danoFinalPassivo);
            }
            
            ultimaIteracaoHp++;
        }
        
        
        if (qtdDefesa <= 0) { // programacao defensiva
            danoFinal = danoFinalPassivo;
        }
        
        edb.setDano(danoFinal);
        dano_stun = danoFinal;
        for (int i = 0; i < qtdAcerto; i++) {
            EstatisticasDeBatalha dados = new EstatisticasDeBatalha();
            // calcula dano
            edb.reduzHp();
            // setando valores em dados
            dados.setDano(edb.getDano());
            dados.setHp(edb.getHp());
            estatistica.add(dados);
            
            // aplicando stun, se danoFinal for maior que a pericia de con
            if (danoFinal > defensor.getPerCon()) {
                new ViewStun().setVisible(true);
            }
            
            qtdDefesa--;
            if (qtdDefesa <= 0) {
                danoFinal = danoFinalPassivo;
                edb.setDano(danoFinal);
            }
            
            ultimaIteracaoHp++;
        }
        ultimaIteracaoHp--;
        
        // linha importante - aplicando dano
        defensor.setHpAtual(estatistica.get(ultimaIteracaoHp).getHp());
        
        // salvando para mostrar na label da ViewPrincipal
        AlgoritmoPrincipal.setValor(edb.getDano());
        
        // destrocando atacante por defensor
        if (temp == atacante) {
            atacante = Calculadora.defensor;
            Calculadora.defensor = temp;
        }
        return true;
    }*/
    
    // retorna negativo se o valor do dado for invalido
    public static int getTeste(int dado, int pericia) {
        if (dado > 20 || dado < 1) {
            return -1;
        }
        int teste = dado + pericia;
        if (dado == 20) {
            teste *= 2;
        }
        return teste;
    }
    
    public static int calculaGastoHabilidade(int volume, int auraBonus, int qtd ){
        return 50 * (qtd * (volume + auraBonus));
    }
    
    public static int gastoRyuExcedente(int ryu, int cdn) {
        int gasto = (int) (Math.round(((double) ryu - 50.0) / 10.0) - cdn);
        if (gasto > 0) {
            return gasto;
        }
        return 0;
    }
    
    public static int calculaGastoRyu(int ryu, int aop, int qtd, int volume, int auraBonus) {
        //(double) ryu / 100.0 * 
        // ryu x2 por que um ataque com 50% de nen nao necessariamente gasta 50% de nen,
        // mas sim o volume que esta ocupando. como o janken paa
        // portanto, um kou (como o janken paa) gasta 100% da aura do corpo.
        // logo: ryu - 50; o que sobrar é multiplicado por 2 no gasto
        //return (int) (50.0 * (2.0 * ryu / 100.0) + (aop + auraBonus) * qtd * volume);
        
        // calculo anterior ao novo
//        ryu -= 50;
//        if (ryu < 0) {
//            ryu = 0;
//        }
//        return (int) (50 * qtd * (auraBonus + volume + aop * ((double) ryu / 100.0)));
        
        // o raciocinio está em arquivos publicos -> "atuualizações e regras do sistema" ->
        // -> "raciocinio do calculo do gasto de aura.txt"
        if (ryu > 50) {
            int gastoMax = 50 * (auraBonus + aop);
            // o 1.0 serve para converter aop em double, que converte volume em double logo após
            int gasto = (int) (50 * qtd * (auraBonus + 1.0 * aop * ryu / 100.0));
            if (gasto > gastoMax) {
                gasto = gastoMax;
            }
            return gasto;
        } else if (ryu < 50) {
            // 1.0 tem a mesma serventia do algoritmo anterior
            return (int) (50 * qtd * (auraBonus + 1.0 * aop * volume * ryu / 5000.0));
        } else { // ryu == 50
            // 1.0 tem a mesma serventia do algoritmo anterior
            return (int) (50 * qtd * (auraBonus + 1.0 * aop * volume / 100.0));
        }
    }
    
    public static int calculaGastoRen(int aop) {
        return 50 * aop;
    }
    
    
    /*
    public int getVelMs() {
        return (int) Math.floor((double) velKm / 3.6);
    }
    
    public int getAopHabilidade(Habilidades habilidade) {
        return aop + habilidade.getBonus();
    }
    
    public int getAopHabilidade(String nome) {
        return aop + getHabilidade(nome).getBonus();
    }
    
    public int getRyu(int ryu) {
        return (int) Math.floor((double) ryu / (double) corpo);
    }
    
    public int getKen(int ryu, int auraBonus) {
        return (int) Math.floor((aop + auraBonus) * this.getRyu(ryu) * ((ref / 10) + 1) * modClas);
    }
    
    public int getKen(int ryu, Habilidades habilidade) {
        int auraBonus = habilidade.getBonus();
        return (int) Math.floor((aop + auraBonus) * this.getRyu(ryu) * ((ref / 10) + 1) * modClas);
    }
    */
}
