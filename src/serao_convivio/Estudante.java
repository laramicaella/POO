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
public class Estudante extends Pessoa_Dei{
    
    private String curso;

    /**
     *
     * @param nome nome do estudante
     * @param pal_chave palavra chave
     * @param nmr numero de estudante
     * @param perfil perfil
     * @param curso curso
     */
    public Estudante(String nome, char [] pal_chave, int nmr, String perfil, String curso) {
        super(nome, pal_chave, nmr, perfil);
        this.curso=curso;
    }
    
    /**
     *
     * @return retorna sempre true porque é um estudante
     */
    @Override
    public boolean aluno(){
        return true;
    }
    
    /**
     *
     * @return retorna o curso do estudante
     */
    @Override
    public String curso(){
        return curso;
    }
    
    /**
     *
     * @return junta os dados numa string
     */
    @Override
    public String toString(){
        return "Nome: "+nome+" | Palavrachave: "+Arrays.toString(pal_chave)+" | nmr: "+nmr+" | prefil: "+perfil+" | curso: "+ curso;
    }
}
