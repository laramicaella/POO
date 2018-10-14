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
public class Inscricoes {
    private ArrayList<Inscricao> locais_pessoa ;

    /**
     *
     */
    public Inscricoes() {
        locais_pessoa= new ArrayList<>();;
    }
    
    private int nmr_locais(int num_pessoa){
        int conta = 0, i;
        for(i = 0; i < locais_pessoa.size(); i++){
            if (locais_pessoa.get(i).getPessoa().getNmr() == num_pessoa){
                conta++;  
            }
        }
        return conta;
    }
    
    private boolean inscrito_no_local(int num_pessoa, String loc){
        int i, j;
        for(i = 0; i < locais_pessoa.size(); i++){
            if(locais_pessoa.get(i).getPessoa().getNmr() == num_pessoa){
                if(locais_pessoa.get(i).getLocal().getNome_local().compareTo(loc) == 0){
                    return true;
                }
           } 
        }
        return false;
    }

    /**
     *
     * @return retorna as receitas do convivio
     */
    public double receitas(){
        double conta=0;
        for(Inscricao in:locais_pessoa){
            if(in.getLocal().local_bar() == true)
                conta = conta + in.getLocal().custo_min();
            else if(in.getLocal().local_exp() == true){
                if(in.getPessoa().aluno() == true)
                    conta = conta + (in.getLocal().custo_min() - in.getLocal().custo_min()*0.1);
                else
                    conta = conta + in.getLocal().custo_min();
            } 
        }
        return conta;
    }
    
    private int conta_pessoas_local(Local loc){
        int conta=0;
        for(Inscricao l:locais_pessoa){
            if(l.getLocal().getNome_local().compareTo(loc.getNome_local()) == 0)
                conta ++;
        }
        return conta;
    }
    
    /**
     *
     * @param ins objeto do tipo Inscricao que tem pessoa e local
     * @return
     */
    public boolean inscrever(Inscricao ins){
        if( (inscrito_no_local(ins.getPessoa().getNmr(),ins.getLocal().getNome_local()) == false) && (nmr_locais(ins.getPessoa().getNmr())  < 5) ){
            if ((( conta_pessoas_local(ins.getLocal())) < ins.getLocal().lotacao()) && (ins.getLocal().local_bar() == true) ){
                locais_pessoa.add(ins);
                /*System.out.println("inscreveu!!!!!");
                for(Inscricao in:locais_pessoa)
                    System.out.println(in);
                return true;*/
            }
            else if(ins.getLocal().local_bar() == false ){
                locais_pessoa.add(ins);
                /*System.out.println("inscreveu!!!!!");
                for(Inscricao in:locais_pessoa)
                    System.out.println(in);
                return true;*/
            }
            System.out.println("inscreveu!!!!!");
            for(Inscricao in:locais_pessoa)
                System.out.println(in);
            return true;
        }
        return false;
    }
    
    /**
     *
     * @param l objeto do tipo Local
     * @return retorna o número de pessoas inscritas num local
     */
    public int locais_a_visitar(Local l){
        int soma=0;
        for(Inscricao in:locais_pessoa){
            if(in.getLocal().getNome_local().compareTo(l.getNome_local()) == 0){
                soma++;
            }
        }
        return soma;
    }
    
    /**
     *
     * @param l local que vai ter, ou não, uma guest list
     * @return cria uma arraylist com o nome das pessoas que estão inscritas no local l
     */
    public ArrayList<String> guest(Local l){
        ArrayList<String>gg = new ArrayList();
        int i,k=0;
        for(i=0; i<locais_pessoa.size(); i++)
            if(locais_pessoa.get(i).getPessoa().getPerfil().compareTo("Boemio") == 0 && locais_pessoa.get(i).getLocal().getNome_local().compareTo(l.getNome_local()) == 0){
                System.out.println("guest: "+locais_pessoa.get(i).getPessoa());
                gg.add(locais_pessoa.get(i).getPessoa().getNome());
                k++;
            }
            else if(locais_pessoa.get(i).getPessoa().getPerfil().compareTo("Boemio") != 0 && locais_pessoa.get(i).getLocal().getNome_local().compareTo(l.getNome_local()) == 0){
                System.out.println("guest "+locais_pessoa.get(i).getPessoa());
                gg.add(locais_pessoa.get(i).getPessoa().getNome());
                k++;
            }
        return gg;
    }
    
    /**
     *
     * @return retorna a arraylist de inscrições
     */
    public ArrayList<Inscricao> getLocais_pessoa() {
        return locais_pessoa;
    }

    /**
     *
     * @param locais_pessoa arraylist de inscrições
     */
    public void setLocais_pessoa(ArrayList<Inscricao> locais_pessoa) {
        this.locais_pessoa = locais_pessoa;
    }

    /**
     *
     */
    /*public void PARA_APAGAR() {
        for(Inscricao i:locais_pessoa)
            System.out.println(i);
    }*/
}
