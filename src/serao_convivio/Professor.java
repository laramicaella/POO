/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serao_convivio;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Lara Trindade e João Miranda
 */
public class Professor extends Pessoa_Dei implements Serializable{
    private String tipo;

    /**
     *
     * @param nome nome do professor
     * @param pal_chave palavra chave
     * @param nmr número do professor
     * @param perfil perfil do professor
     * @param tipo tipo do professor
     */
    public Professor(String nome, char[]pal_chave, int nmr, String perfil, String tipo) {
        super(nome, pal_chave, nmr, perfil);
        this.tipo=tipo;
    }
    
    /**
     *
     * @return retorna sempre false porque um professor não é um aluno
     */
    @Override
    public boolean aluno(){
        return false;
    }
    
    /**
     *
     * @return retorna sempre false porque um professor não tem curso
     */
    @Override
    public String curso(){
        return null;
    }
    
    /**
     *
     * @return junta os dados numa string
     */
    @Override
    public String toString(){
        return "Nome: "+nome+" | Palavrachave: "+Arrays.toString(pal_chave)+" | nmr: "+nmr+" | prefil: "+perfil+" | tipo: "+tipo;
    }
}
