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
public class Jardim extends Local{
    private double area;
    
    /**
     *
     * @param nome_local nome do jardim
     * @param coord_long longitude do jardim
     * @param coord_lat latitude do jardim
     * @param area área do jardim
     */
    public Jardim(String nome_local, float coord_long, float coord_lat, double area) {
        super(nome_local, coord_long, coord_lat);
        this.area = area;
    }
    
    /**
     *
     * @return retorna sempre  porque os jardins não têm lotação
     */
    @Override
    public int lotacao(){
        return 0;
    } 
    
    /**
     *
     * @return retorna sempre 0 porque os jardins não têm custo minimo
     */
    @Override
    public double custo_min(){
        return 0;
    }  
    
    /**
     *
     * @return retorna sempre false porque um jardim não é um bar
     */
    @Override
    public boolean local_bar(){
        return false;
    }  
    
    /**
     *
     * @return retorna sempre false porque um jardim não é uma exposição
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
        return "Nome do local: "+nome_local+" | coordenadas longuitude: "+coord_long+" | coordenadas latitude: "+coord_lat+" | area: "+area;
    }
}
