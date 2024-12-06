/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author lucac
 */
import annullaoperazione.AnnullaOperazione;
import java.util.ArrayList;
import java.util.List;

public class Rubrica {
   
   private List<Contatto> contatti;
    
   
   public Rubrica() {
        this.contatti = new ArrayList<>();
    }

    public void aggiungiContatto(Contatto contatto) {
       
       
    }

    public  List<Contatto> mostraRubrica() {
       return this.contatti;
    }
    public List<Contatto> ricercaContatto(){
        return this.contatti;
    }
    public void esportaContatto(){
        
    }
    public void importaContatto(){
        
    }
    public void eliminaContatto(){
        
    }
    
   public void modificaContatto(){
         
   }
   
  
   public void annullaOperazione(){
       
   }
   public void visualizzaContatto(){
       
   }
}

