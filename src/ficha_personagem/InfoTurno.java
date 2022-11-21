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
public class InfoTurno implements Serializable {
    private Map<String, InfoPerson> infoPersons = new HashMap<>();
    private int id; //turno
    private static int qtdTurnos = 0;
    private static int qtdTurnosMax = 0;

    
    // construtor
    public InfoTurno() {
        this.id = qtdTurnos;
        qtdTurnos++;
        // o if impede que, ao instanciar um novo InfoTurno,
        // depois de usar o botão Desfazer, qtdTurnosMax
        // fique sempre além de qtdTurnos, gerando inconsistência
        if (qtdTurnos > qtdTurnosMax) {
            qtdTurnosMax++;
        }
    }
    
    
    public static boolean decrementarQtdTurnos() {
        if (qtdTurnos < 2) {
            return false;
        }
        qtdTurnos--;
        return true;
    }
    
    public static boolean incrementarQtdTurnos() {
        // o if impede qtdTurnos de ser maior que qtdTurnosMax
        if (qtdTurnos == qtdTurnosMax) {
            return false;
        }
        qtdTurnos++;
        return true;
    }
    
    
    // getters e setters
    public static int getQtdTurnos() {
        return qtdTurnos;
    }
    
    public Map<String, InfoPerson> getInfoPersons() {
        return infoPersons;
    }

    public void setInfoPersons(Map<String, InfoPerson> info) {
        this.infoPersons = info;
    }
    
    public void putInfoPerson(InfoPerson infoPerson) {
        this.infoPersons.put(infoPerson.getNick(), infoPerson);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
