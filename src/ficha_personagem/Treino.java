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
public class Treino {
    private static int i = 0;
    private int num;
    private String nome;
    private double dias;
    
    public Treino() {
        i++;
        num = i;
    }
    

    public static int getI() {
        return i;
    }
    
    public int getNum() {
        return this.num;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDias() {
        return dias;
    }

    public void setDias(double dias) {
        this.dias = dias;
    }
}
