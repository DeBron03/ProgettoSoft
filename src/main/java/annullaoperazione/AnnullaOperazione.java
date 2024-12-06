/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annullaoperazione;

/**
 *
 * @author lucac
 */
import data.Contatto;
import java.util.ArrayList;
import java.util.List;


public class AnnullaOperazione {
    private List<Contatto> statiPrecedenti;

    public AnnullaOperazione() {
        statiPrecedenti = new ArrayList<>();
    }

    
    public void salvaStato(List<Contatto> statoCorrente) {
        
    }

   
    public List<Contatto> annulla() {
      return statiPrecedenti;
}
}