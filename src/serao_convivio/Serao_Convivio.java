/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serao_convivio;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Lara Trindade e João Miranda
 */
public class Serao_Convivio implements Serializable{


    
    private Ficheiros aux_f /*= new Ficheiros()*/;
    private ArrayList<Pessoa_Dei> pessoas/* = new ArrayList<Pessoa_Dei>()*/;
    private ArrayList<Local> locais /*= new ArrayList<Local>()*/;
    
    private Inscricoes insc;
    //private ArrayList<Inscricao> a;
    //private Local place;
  
    /**
     *
     */
    public Serao_Convivio() {
        
        aux_f = new Ficheiros();
        pessoas = new ArrayList<Pessoa_Dei>();
        locais = new ArrayList<Local>();
        //a = new ArrayList<Inscricao>();
        insc = new Inscricoes();

        //Serao_Convivio o = new Serao_Convivio ();
        Interface_Principal j = new Interface_Principal(this);
        j.setVisible(true);//janela
        
        aux_f.le_fich_obj_Pessoas_Dei(pessoas);
        //aux_f.ler_fich_txt_Pessoas_Dei(pessoas);//ler do ficheiro txt as pessoas do dei
        for(Pessoa_Dei t:pessoas)
            System.out.println(t);
        
        System.out.println();
        
        aux_f.le_fich_obj_Local(locais);
        //aux_f.ler_fich_txt_Local(locais);//ler do ficheiro txt os locais do convivio
        for(Local t:locais)
            System.out.println(t);
        System.out.println();
        
       aux_f.le_fich_obj_Inscritos(insc.getLocais_pessoa());
       //insc.PARA_APAGAR();
       System.out.println();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {        
        Serao_Convivio serao_Convivio = new Serao_Convivio();
    }
    
    /**
     *
     * @param nmr numero da pessoa 
     * @param pal_chave palavra chave
     */
    public void escolher_pass(int nmr, char[] pal_chave){//colocar palavra pass
        for(int i=0; i<pessoas.size(); i++){
            if(nmr == pessoas.get(i).getNmr()){
                pessoas.get(i).setPal_chave(pal_chave);
            }
        }
        for(int i=0; i<pessoas.size(); i++){
            Pessoa_Dei p = pessoas.get(i);
            System.out.println(p);
        }
    }
    
    /**
     *
     * @param l local para inscrever a pessoa
     * @param p pessoa a inscrever no local
     * @return 
     */
    public boolean escolher_locais_inscricoes(Local l, Pessoa_Dei p){
        boolean y;
        //Inscricoes insc = new Inscricoes();
        Inscricao x = new Inscricao(p,l);
        y = insc.inscrever(x);
        System.out.println(y);
        return y;
    }
    
    /**
     *
     * @return retorna as receitas do convivio
     */
    public double receitass(){
        double y;
        y = insc.receitas();
        return y;
    }
    
    /**
     *
     * @param on objeto do tipo local
     * @return retorna o número de pessoas inscritas num local
     */
    public int llocais(Local on){
        //int [] nmr_ins = new int[6];
        int conta/*,i=0*/;
        //for(Local on:locais){
            conta = insc.locais_a_visitar(on);
            //nmr_ins[i] = conta;//coloca o nmr de pessoas inscritas no local (por ordem no array de locais)
            //i++;
            return conta;
        //}
    }
    
    /**
     *
     * @param l objeto do tipo local
     * @return retorna a guest list do local
     */
    public ArrayList<String> guest_list(Local l){
         ArrayList<String>gg = new ArrayList();
        gg = insc.guest(l);
        return gg;
    }
      
    /**
     *
     */
    public void terminar(){
        aux_f.escreve_fich_obj_Pessoas_Dei(pessoas);//atualiza o ficheiro objeto das Pessoas Dei por causa das pass que foram definidas
        aux_f.escreve_fich_obj_Inscritos(insc.getLocais_pessoa());//atualiza o ficheiro objeto das Inscrições
        //System.out.println(insc.getLocais_pessoa().size());
    }

    /**
     *
     * @return retorna um ficheiro
     */
    public Ficheiros getAux_f() {
        return aux_f;
    }

    /**
     *
     * @return retorna uma arraylist de pessoas da comunidade do DEI
     */
    public ArrayList<Pessoa_Dei> getPessoas() {
        return pessoas;
    }

    /**
     *
     * @return retorna uma arraylist de locais disponiveis para o convivio
     */
    public ArrayList<Local> getLocais() {
        return locais;
    }
}
