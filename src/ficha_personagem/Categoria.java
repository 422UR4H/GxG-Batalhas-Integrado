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
public enum Categoria {
    REFORCO("Reforco"),
    EMISSAO("Emissao"),
    TRANSFORMACAO("Transformacao"),
    MATERIALIZACAO("Materializacao"),
    MANIPULACAO("Manipulacao"),
    ESPECIALISTA("Especialista");
    
    private String parametro;
    
    Categoria(String parametro){
        this.parametro = parametro;
    }

    public String getParametro() {
        return parametro;
    }
}
