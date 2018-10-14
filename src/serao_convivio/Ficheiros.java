/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serao_convivio;

import java.util.*;
import java.io.*;

/**
 *
 * @author Lara Trindade e João Miranda
 */
public class Ficheiros implements Serializable{

    /**
     *
     */
    public Ficheiros() {
    }
    
    /**
     *
     * @param pessoas arraylist de pessoas da comunidade do DEI
     */
    private void ler_fich_txt_Pessoas_Dei(ArrayList<Pessoa_Dei> pessoas)
    {
        try{
            File f = new File("pessoas_dei.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String s;
            //String as;
            String [] as = new String [5];
            while((s = br.readLine()) != null){
                //System.out.println(s);
                as = s.split(" ");
                if ((as[0].compareTo("Estudante")) == 0)
                {
                    if((as[3].compareTo("null")) == 0){
                        Estudante e = new Estudante(as[1], null , Integer.parseInt(as[3]), as[4], as[5]);
                        pessoas.add(e);  
                    }
                    
                    if((as[3].compareTo("null")) != 0){
                        char[] array = as[2].toCharArray();//converte String para char
                        Estudante e = new Estudante(as[1], array , Integer.parseInt(as[3]), as[4], as[5]);
                        pessoas.add(e);  
                    }
                }
                
                else if ((as[0].compareTo("Professor")) == 0)
                {
                    if((as[3].compareTo("null")) == 0){
                        Professor p = new Professor(as[1], null , Integer.parseInt(as[3]), as[4], as[5]);
                        pessoas.add(p);
                    }
                    
                    if((as[3].compareTo("null")) != 0){
                        char[] array = as[2].toCharArray();
                        Professor p = new Professor(as[1], array , Integer.parseInt(as[3]), as[4], as[5]);
                        pessoas.add(p);
                    }
                }
                
                else if ((as[0].compareTo("Funcionario")) == 0)
                {
                    if((as[3].compareTo("null")) == 0){
                        Funcionario fun = new Funcionario(as[1], null , Integer.parseInt(as[3]), as[4], as[5]);
                        pessoas.add(fun);
                    }
                    
                    if((as[3].compareTo("null")) != 0){
                        char[] array = as[2].toCharArray();
                        Funcionario fun = new Funcionario(as[1], array , Integer.parseInt(as[3]), as[4], as[5]);
                        pessoas.add(fun);
                    }
                }
                
                else
                    System.out.println("Erro no tipo de Pessoa_Dei!\n");
            } 
            br.close();
        } catch (IOException e){
            System.out.println("Ocorreu a exceção "+e);
        }
    }
    
    /**
     *
     * @param locais arraylist dos locais disponiveis para o convivio
     */
    private void ler_fich_txt_Local(ArrayList<Local> locais ){
        double percent = 0;
        try{
            File f = new File("Locais.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String s;
            //String as;
            ArrayList<String> d = new ArrayList<>();
            String [] as = new String [10];
            while((s = br.readLine()) != null){
                //System.out.println(s);
                as = s.split("-");
                if ((as[0].compareTo("Bar")) == 0)
                {
                    Bar b = new Bar(as[1], Float.parseFloat(as[2]), Float.parseFloat(as[3]),  Double.parseDouble(as[4]), Integer.parseInt(as[5])/*, Integer.parseInt(as[6])*/);
                    locais.add(b);  
                }
                
                else if((as[0].compareTo("Exposicao")) == 0)
                {
                    Exposicao e = new Exposicao(as[1], Float.parseFloat(as[2]), Float.parseFloat(as[3]), as[4], Double.parseDouble(as[5]));
                    locais.add(e);  
                }
                
                else if((as[0].compareTo("Jardim")) == 0)
                {
                    Jardim j = new Jardim(as[1], Float.parseFloat(as[2]), Float.parseFloat(as[3]), Double.parseDouble(as[4]));
                    locais.add(j);  
                }
                
                else if((as[0].compareTo("AreaDesportiva")) == 0)
                {
                    int i=4;
                    while(as[i].compareTo("*") != 0){
                        d.add(as[i]);
                        i++;
                    }
                    
                    Area_desportiva a = new Area_desportiva(as[1], Float.parseFloat(as[2]), Float.parseFloat(as[3]), d);
                    locais.add(a);  
                }
                else if ((as[0].compareTo("Percentagem")) == 0)
                {
                    percent =  Double.parseDouble(as[1]) ;
                    //System.out.println(percent);
                }
                else
                    System.out.println("Erro no tipo de Local!\n");
            } 
            br.close();
        } catch (IOException e){
            System.out.println("Ocorrreu a exceção "+e);
        }
    }
    
    /**
     *
     * @param locais arraylist de locais
     * @return retorna a percentagem de pessoas ue podem estar na guest list
     */
    public double percentagem_gl(ArrayList<Local> locais){
        double percent = 0;
         try{
            File f = new File("Locais.txt");
            String s;
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String [] as = new String [10];
            while((s = br.readLine()) != null){
                //System.out.println(s);
                as = s.split("-");
                if ((as[0].compareTo("Percentagem")) == 0)
                        {
                            percent =  Double.parseDouble(as[1]) ;
                            //System.out.println(percent);
                        }
            }
        } catch (IOException e){
            System.out.println("Ocorrreu a exceção "+e);
        }
        return percent;
    }
    
    /**
     *
     * @param pessoas arraylist de pessoas da comunidade do DEI
     */
    public void escreve_fich_obj_Pessoas_Dei(ArrayList<Pessoa_Dei> pessoas/*, String nome_fich*/){
        try{
            File f = new File("Pessoas_Dei.obj");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream obj = new ObjectOutputStream(fos);
            //System.out.println(pessoas.toString());
            for(Pessoa_Dei pes:pessoas)
                System.out.println(pes);
            for(Pessoa_Dei p:pessoas){
                //System.out.println(p.getNmr());
                obj.writeObject(p);
            }
            obj.close();
            
        }catch(FileNotFoundException e){
            System.out.println("Ocorreu a exceção-> "+e+"<- na escrita do ficheiro de objetos Pessoas_Dei.\n");
            
        }catch(IOException e){
            System.out.println("Ocorreu a exceção-> "+e+" <-na escrita do ficheiro de objetos Pessoas_Dei.");
        }
    }
    
    /**
     *
     * @param pessoas arraylist de pessoas da comunidade do DEI
     */
    public void le_fich_obj_Pessoas_Dei(ArrayList<Pessoa_Dei> pessoas/*, String nome_fich*/){
        try{//tenta ler do ficheiro OBJ
            FileInputStream fis = new FileInputStream("Pessoas_Dei.obj");
            ObjectInputStream obj = new ObjectInputStream(fis);
            Pessoa_Dei pd;
            while((pd=(Pessoa_Dei)obj.readObject()) != null){
                pessoas.add(pd);
            }
            obj.close();
        }catch(FileNotFoundException e){//nao consegue
            System.out.println("Ocorreu a exceção-> "+e+" <-na leitura do ficheiro de objetos Pessoas_Dei. A escrever o ficheiro de objetos\n");
            System.out.println("------------------------------------------------------------------------------------------>");
            ler_fich_txt_Pessoas_Dei(pessoas);//le do ficheiro de objetos
            escreve_fich_obj_Pessoas_Dei(pessoas/*,nome_fich*/);//escreve no ficheiro de objetos
        }catch(ClassNotFoundException | IOException e){
            System.out.println("Ocorreu a exceção-> "+e+" <-na leitura do ficheiro de objetos Pessoas_Dei.\n");
        }
    }
    
    /**
     *
     * @param locais arraylist de locais disponiveis para o convivio
     */
    public void escreve_fich_obj_Local(ArrayList<Local> locais){
        try{
            File f = new File("Locais.obj");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream obj = new ObjectOutputStream(fos);
            
            for(Local l:locais){
                obj.writeObject(l);
            }
            obj.close();
            
        }catch(FileNotFoundException e){
            System.out.println("Ocorreu a exceção ->"+e+"<- na escrita do ficheiro de objetos Local.");
            
        }catch(IOException e){
            System.out.println("Ocorreu a exceção ->"+e+"<- na escrita do ficheiro de objetos Local.");
        }
    }
    
    /**
     *
     * @param locais arraylist de locais disponiveis para o convivio
     */
    public void le_fich_obj_Local(ArrayList<Local> locais){
        try{
            FileInputStream fis = new FileInputStream("Locais.obj");
            ObjectInputStream obj = new ObjectInputStream(fis);
            Local lc;
            while((lc=(Local)obj.readObject()) != null){
                locais.add(lc);
            }
            obj.close();
        }catch(FileNotFoundException e){
            System.out.println("Ocorreu a exceção ->"+e+"<- na leitura do ficheiro de objetos Local. A escrever o ficheiro de objetos");
            ler_fich_txt_Local(locais);
            escreve_fich_obj_Local(locais);
        }catch(ClassNotFoundException | IOException e){
            System.out.println("Ocorreu a exceção ->"+e+"<- na leitura do ficheiro de objetos Local.");
        }
    }
    
    /**
     *
     * @param inscritos arraylist que associa pessoas a locais (inscrições)
     */
    public void escreve_fich_obj_Inscritos(ArrayList<Inscricao> inscritos){
          try{
              File f = new File("Inscritos.obj");
              FileOutputStream fos = new FileOutputStream(f);
              ObjectOutputStream obj = new ObjectOutputStream(fos);
              
              for (Inscricao i:inscritos){
                  //System.out.println(i.getPessoa().getNome());
                  obj.writeObject(i);
              }
              obj.close();
          }catch(FileNotFoundException e){
              System.out.println("Impossível escrever ficheiro de objetos de inscritos. Ainda ninguém se inscreveu!");
          }catch(IOException e){
              System.out.println("Ocorreu a exceção ->"+e+"<- na escrita do ficheiro de objetos de inscritos.");
          }
      }
      
    /**
     *
     * @param inscritos arraylist que associa pessoas a locais (inscrições)
     */
    public void le_fich_obj_Inscritos(ArrayList<Inscricao> inscritos){
          try{
            FileInputStream fis = new FileInputStream("Inscritos.obj");
            ObjectInputStream obj = new ObjectInputStream(fis);
            Inscricao ins;
            while((ins=(Inscricao)obj.readObject()) != null){
                inscritos.add(ins);
            }
            obj.close();
          }catch(FileNotFoundException e){
              System.out.println("Ficheiro de objetos de inscritos não encontrado. A escrever ficheiro de objetos...");
              escreve_fich_obj_Inscritos(inscritos);
          }catch(ClassNotFoundException | IOException e){
              System.out.println("Ocorreu a exceção -> "+e+" <- na leitura do ficheiro de objetos Inscritos");
          }
      }
}