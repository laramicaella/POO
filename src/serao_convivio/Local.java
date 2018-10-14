/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serao_convivio;

import java.io.Serializable;

/**
 *
 * @author Lara Trindade e João Miranda
 */
public abstract class Local implements Serializable{

    /**
     *
     */
    protected String nome_local;

    /**
     *
     */
    protected float coord_long,

    /**
     *
     */
    coord_lat;

    /**
     *
     * @param nome_local nome do local
     * @param coord_long longitude do local
     * @param coord_lat latitude do local
     */
    public Local(String nome_local, float coord_long, float coord_lat) {
        this.nome_local = nome_local;
        this.coord_long = coord_long;
        this.coord_lat = coord_lat;
    }
     
    /**
     *
     * @return método abstrato para calcular o custo mínimo
     */
    abstract public double custo_min();
    
    /**
     *
     * @return método abstrato para verificar se o local é um bar
     */
    abstract public boolean local_bar();
    
    /**
     *
     * @return metodo abstrato para verificar se um local é uma exposição
     */
    abstract public boolean local_exp();
    
    /**
     *
     * @return metodo abstrato para calcular a lotação de um local
     */
    abstract public int lotacao();
             
    /**
     *
     * @return retorna o nome de um local
     */
    public String getNome_local() {
        return nome_local;
    }
    
    
}
