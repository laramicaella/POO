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
public class Exposicao extends Local{
    
    private String fArtistica;
    private double Cingresso;

    /**
     *
     * @param nome_local nome da exposição
     * @param coord_long longitude da exposição
     * @param coord_lat latitude da exposição
     * @param fArtistica forma artistica
     * @param Cingresso custo de ingresso
     */
    public Exposicao(String nome_local, float coord_long, float coord_lat, String fArtistica, double Cingresso) {
        super(nome_local, coord_long, coord_lat);
        this.fArtistica = fArtistica;
        this.Cingresso = Cingresso;
    }
    
    /**
     *
     * @return retorna sempre 0 porque as exposições não têm lotação
     */
    @Override
    public int lotacao(){
        return 0;
    } 
    
    /**
     *
     * @return retorna o custo de ingresso na exposição
     */
    @Override
    public double custo_min(){
        return Cingresso;
    }
    
    /**
     *
     * @return retorna sempre true porque o local é uma exposição
     */
    @Override
    public boolean local_exp(){
        return true;
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
     * @return junta os dados numa string
     */
    @Override
    public String toString(){
        return "Nome do local: "+nome_local+" | coordenadas longuitude: "+coord_long+" | coordenadas latitude: "+" | fonte artistica: "+fArtistica+" | custo do ingresso: "+Cingresso;
    }
}
