/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serao_convivio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Lara Trindade e João Miranda
 */
public class Inscricao implements Serializable {
    private Pessoa_Dei pessoa;
    private Local local ;

    /**
     *
     * @param pessoa pessoa da comunidade do DEI
     * @param local local disponivel para o convivio
     */
    public Inscricao(Pessoa_Dei pessoa, Local local) {
        this.pessoa = pessoa;
        this.local = local;
    }
    
    /**
     *
     * @return retorna a pessoa
     */
    public Pessoa_Dei getPessoa() {
        return pessoa;
    }

    /**
     *
     * @param pessoa 
     */
    public void setPessoa(Pessoa_Dei pessoa) {
        this.pessoa = pessoa;
    } 

    /**
     *
     * @return retorna o local
     */
    public Local getLocal() {
        return local;
    }

    /**
     *
     * @param local 
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    /**
     *
     * @return junta os dados numa string
     */
    @Override
    public String toString(){
        return "Pessoa: "+pessoa+" | Local: "+local;
    }
}
