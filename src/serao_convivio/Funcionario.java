/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serao_convivio;

import java.util.Arrays;

/**
 *
 * @author Lara Trindade e João Miranda
 */
public class Funcionario extends Pessoa_Dei{
    private String tipo;
    
    /**
     *
     * @param nome nome do funcionário
     * @param pal_chave palavra chave
     * @param nmr numero do funcionário
     * @param perfil perfil do funcionário
     * @param tipo tipo do funcionário
     */
    public Funcionario(String nome, char[] pal_chave, int nmr, String perfil, String tipo) {
        super(nome, pal_chave, nmr, perfil);
        this.tipo =  tipo;
    }
    
    /**
     *
     * @return retorna false porque a pessoa não é um aluno
     */
    @Override
    public boolean aluno(){
        return false;
    }
    
    /**
     *
     * @return retorna null porque os funcionários não têm curso
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
