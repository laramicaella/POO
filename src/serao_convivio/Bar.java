/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serao_convivio;

/**
 *
 * @author Lara Trindade e João Miranda
 */
public class Bar extends Local{
    private double consumo_min;
    private int max_lotacao, max_guest;

    /**
     *
     * @param nome_local nome do bar
     * @param coord_long longitude do bar
     * @param coord_lat latitude do local
     * @param consumo_min consumo mínimo
     * @param max_lotacao lotação
     */
    public Bar(String nome_local, float coord_long, float coord_lat, double consumo_min, int max_lotacao) {
        super(nome_local, coord_long, coord_lat);
        this.consumo_min =  consumo_min;
        this.max_lotacao =max_lotacao;
    }
    
    /**
     *
     * @return retorna a lotação máxima do bar
     */
    @Override
    public int lotacao(){
        return max_lotacao;
    } 
    
    /**
     *
     * @return retorna o consumo mínimo do bar
     */
    @Override
    public double custo_min(){
        return consumo_min;
    }  
    
    /**
     *
     * @return sempre true porque o local é um bar
     */
    @Override
    public boolean local_bar(){
        return true;
    }
    
    /**
     *
     * @return retorna sempre false porque o local não é uma exposição
     */
    @Override
    public boolean local_exp(){
        return false;
    }
    
    /**
     *
     * @return junta os dados numa string
     */
    @Override
    public String toString(){
        return "Nome do local: "+nome_local+" | coordenadas longuitude: "+coord_long+" | coordenadas latitude: "+coord_lat+" | comsumo minimo: "+consumo_min+" | lotacao maxima: "+max_lotacao+" | maximo de pessoas na guest list: "+max_guest;
    }   
}
