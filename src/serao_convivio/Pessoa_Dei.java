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
public abstract class Pessoa_Dei implements Serializable{

    /**
     *
     */
    protected String nome,

    /**
     *
     */
    perfil;

    /**
     *
     */
    protected char [] pal_chave;

    /**
     *
     */
    protected int nmr;

    /**
     *
     * @param nome nome da pessoa
     * @param pal_chave palavra chave
     * @param nmr número da pessoa
     * @param perfil perfil da pessoa
     */
    public Pessoa_Dei(String nome, char[]  pal_chave, int nmr, String perfil) {
        this.nome = nome;
        this.pal_chave = pal_chave;
        this.nmr = nmr;
        this.perfil = perfil;
    }

    /**
     *
     * @return método abstrato para verificar se a pessoa é um aluno
     */
    abstract public boolean aluno();
    
    /**
     *
     * @return método abstrato que retorna  curso se existir
     */
    abstract public String curso();
    
    /**
     *
     * @return retorna o número da pessoa
     */
    public int getNmr() {
        return nmr;
    }

    /**
     *
     * @return retorna a palavra chave
     */
    public char[] getPal_chave() {
        return pal_chave;
    }

    /**
     *
     * @return retorna o nome da pessoa
     */
    public String getNome() {
        return nome;
    }
    
    /**
     *
     * @param pal_chave palavra chave
     */
    public void setPal_chave(char[] pal_chave) {
        this.pal_chave = pal_chave;
    } 

    /**
     *
     * @return retorna o perfil da pessoa
     */
    public String getPerfil() {
        return perfil;
    }
        
    /**
     *
     * @return junta os dados numa String
     */
    @Override
    public String toString(){
        return "Nome "+nome+"Palavrachave: "+Arrays.toString(pal_chave)+" nmr: "+nmr+" prefil: "+perfil;
    }
    
    
}
