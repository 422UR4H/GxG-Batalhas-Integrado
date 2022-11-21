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
public class Extensao implements Serializable {
    private int qtd;
    private int volume;
    private boolean guardada;
    private String nome;
    
    
    // CONSTRUTOR
    public Extensao() {
        qtd = 1;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    public void incrementaQtd() {
        this.qtd++;
    }
    
    public void incrementaQtd(int qtd) {
        this.qtd += qtd;
    }
    
    public void decrementaQtd() {
        this.qtd--;
    }
    
    public void decrementaQtd(int qtd) {
        this.qtd -= qtd;
    }
    
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isGuardada() {
        return guardada;
    }

    public void setGuardada(boolean guardada) {
        this.guardada = guardada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
