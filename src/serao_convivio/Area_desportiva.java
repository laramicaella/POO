/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serao_convivio;

import java.util.*;

/**
 *
 * @author Lara Trindade e João Miranda
 */
public class Area_desportiva extends Local{
    private ArrayList<String> desportos = new ArrayList<>();

    /**
     *
     * @param nome_local nome da Área desportiva
     * @param coord_long longitude da Área desportiva
     * @param coord_lat latitude da Área desportiva
     * @param desportos arraylist de desportos que se podem praticar 
     */
    public Area_desportiva(String nome_local, float coord_long, float coord_lat, ArrayList<String> desportos) {
        super(nome_local, coord_long, coord_lat);
        this.desportos=desportos;
    }
    
    /**
     *
     * @return retorna sempre 0 porque as áreas desportivas não têm lotação
     */
    @Override
    public int lotacao(){
        return 0;
    } 
    
    /**
     *
     * @return retorna sempre 0 porque as áreas desposrtivas nã têm custo mínimo
     */
    @Override
    public double custo_min(){
        return 0;
    }  
    
    /**
     *
     * @return retorna sempre false porque o local não é um bar
     */
    @Override
    public boolean local_bar(){
        return false;
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
     * @return junta os dados numa String
     */
    @Override
    public String toString(){
        return "Nome do local: "+nome_local+" | coordenadas longuitude: "+coord_long+" | coordenadas latitude: "+coord_lat+" | desportos: "+ desportos;
    }
}

