/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annullaoperazione;

/**
 *
 * @author gruppo13
 */
import data.Contatto;
import java.util.ArrayList;
import java.util.List;

/**
 * @class AnnullaOperazione
 * @brief Classe per gestire gli stati precedenti dei contatti.
 *
 * Questa classe permette di salvare lo stato corrente dei contatti e
 * di ripristinare uno stato precedente in caso di annullamento.
 */
public class AnnullaOperazione {
    /**
     * @brief Lista che contiene gli stati precedenti dei contatti.
     */
    private List<Contatto> statiPrecedenti;

    /**
     * @brief Costruttore di default.
     *
     * Inizializza la lista degli stati precedenti come una nuova lista vuota.
     */
    public AnnullaOperazione() {
        statiPrecedenti = new ArrayList<>();
    }

    /**
     * @brief Salva lo stato corrente dei contatti.
     * @param statoCorrente La lista dei contatti rappresentante lo stato attuale.
     *
     * Questo metodo consente di memorizzare lo stato corrente dei contatti
     * nella lista degli stati precedenti.
     */
    public void salvaStato(List<Contatto> statoCorrente) {
        
    }

   /**
     * @brief Ripristina uno stato precedente dei contatti.
     * @return Una lista dei contatti che rappresenta lo stato precedente.
     *
     * Questo metodo restituisce l'ultimo stato salvato dei contatti,
     * permettendo di annullare l'operazione corrente.
     */
    public List<Contatto> annulla() {
      return statiPrecedenti;
}
}