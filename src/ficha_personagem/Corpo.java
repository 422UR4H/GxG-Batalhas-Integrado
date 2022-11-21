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
public class Corpo implements Serializable {
    private int valor = 100;
    private final Map<String, Extensao> habilidades = new HashMap<>();
    
    
    // CONSTRUTOR
    public Corpo() {
        Extensao outros = new Extensao();
        outros.setGuardada(false);
        outros.setNome("OUTROS");
        outros.setVolume(0);
        habilidades.put("OUTROS", outros);
    }

    public int getValor() {
        return valor;
    }

    public Map<String, Extensao> getHabilidades() {
        return habilidades;
    }
    
    public Extensao getHabilidade(String nome) {
        return habilidades.get(nome);
    }
    
    public void incrementaOutros(int valor) {
        habilidades.get("OUTROS").setVolume(habilidades.get("OUTROS").getVolume() + valor);
        this.valor += valor;
    } 
    
    // Outros merece um tratamento completamente especial
    public void putHabilidade(Extensao e) {
        boolean incrementou = false;
        
        if (e.getNome().equals("OUTROS")) {
            e.setNome("*OUTROS");
        }
        // tentando encontrar a mesma habilidade ja setada
        // para aumentar a qtd e o volume, ao inves de add
        for (String nome : habilidades.keySet()) {
            if (e.getNome().equals(nome) && e.isGuardada() == habilidades.get(nome).isGuardada()) {
                habilidades.get(nome).incrementaQtd(e.getQtd());
                incrementou = true;
                break;
            }
        }
        // nesse caso, o algoritmo nao tera encontrado uma habilidade,
        // ja setada, com o mesmo nome e estado, logo setaremos a primeira
        if (!incrementou) {
            habilidades.put(e.getNome(), e);
        }
        
        // somando valor da habilidade no valor de corpo
        if (e.isGuardada()) {
            for (int i = 0; i < e.getQtd(); i++) {
                valor += (int) Math.floor((double) e.getVolume() / 2);
            }
        } else {
            for (int i = 0; i < e.getQtd(); i++) {
                valor += e.getVolume();
            }
        }
    }
    
    public boolean removeHabilidade(String nome) {
        Extensao e = habilidades.get(nome);
        
        if (nome.equals("OUTROS")) {
            return false;
        }
        
        // reduzindo o valor de corpo extra
        if (e.isGuardada()) {
            for (int i = 0; i < e.getQtd(); i++) {
                valor -= Math.round((double) e.getVolume() / 2);
            }
        } else {
            for (int i = 0; i < e.getQtd(); i++) {
                valor -= e.getVolume();
            }
        }
       
        // reduzindo a quantidade da habilidade nome a 0
        for (String s : habilidades.keySet()) {
            // tentando encontrar a mesma habilidade ja setada
            if (e.getNome().equals(habilidades.get(s).getNome())) {
                if (habilidades.get(s).getQtd() > 1) {
                    habilidades.get(s).decrementaQtd(e.getQtd());
                    habilidades.remove(nome);
                    break;
                } else if (habilidades.get(s).getQtd() == 1) {
                    habilidades.remove(nome);
                    break;
                } else { // nesse caso a habilidade ja tem qtd 0
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean decrementaHabilidade(String nome) {
        Extensao e = habilidades.get(nome);
        
        if (nome.equals("OUTROS")) {
            return false;
        }
        
        if (e.isGuardada()) {
            valor -= Math.round((double) e.getVolume() / 2);
        } else {
            valor -= e.getVolume();
        }
        
        // reduzindo a quantidade da habilidade nome a 0
        for (String s : habilidades.keySet()) {
            // tentanto encontrar a mesma habilidade ja setada
            if (e.getNome().equals(habilidades.get(s).getNome())) {
                if (habilidades.get(s).getQtd() > 1) {
                    habilidades.get(s).decrementaQtd();
                    break;
                } else if (habilidades.get(s).getQtd() == 1) {
                    habilidades.remove(nome);
                    break;
                } else { // nesse caso a habilidade ja tem qtd 0
                    return false;
                }
            }
        }
        return true;
    }
}
