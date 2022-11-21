/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha_personagem;

/**
 *
 * @author 422UR4H
 */
public class Armas {
    String nome;
    String dados;
    int dano;
    int critico;
    boolean perfurante;

    
    // construtor
    public Armas() {
        this.dano = 0;
        this.critico = 2;
        this.perfurante = false;
    }
    
    
    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getCritico() {
        return critico;
    }

    public void setCritico(int critico) {
        this.critico = critico;
    }

    public boolean isPerfurante() {
        return perfurante;
    }

    public void setPerfurante(boolean perfurante) {
        this.perfurante = perfurante;
    }
    
    
    
}
