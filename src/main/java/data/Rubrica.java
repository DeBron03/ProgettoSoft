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
/**
 * @file Rubrica.java
 * @brief Classe per la gestione della rubrica dei contatti.
 *
 * La classe `Rubrica` fornisce metodi per aggiungere, visualizzare, cercare,
 * modificare, esportare, importare ed eliminare contatti, oltre a supportare
 * l'annullamento di operazioni.
 */

import annullaoperazione.AnnullaOperazione;
import java.util.ArrayList;
import java.util.List;

/**
 * @class Rubrica
 * @brief Classe che rappresenta una rubrica per la gestione dei contatti.
 *
 * Questa classe contiene una lista di contatti e fornisce metodi per la gestione
 * e la manipolazione dei contatti.
 */
public class Rubrica {
    /**
     * @brief Lista che contiene tutti i contatti della rubrica.
     */
    private List<Contatto> contatti;

    /**
     * @brief Costruttore per inizializzare una rubrica vuota.
     */
    public Rubrica() {
        this.contatti = new ArrayList<>();
    }

    /**
     * @brief Aggiunge un nuovo contatto alla rubrica.
     * @param contatto Il contatto da aggiungere.
     */
    public void aggiungiContatto(Contatto contatto) {
        contatti.add(contatto);
    }

    /**
     * @brief Mostra tutti i contatti presenti nella rubrica.
     * @return Una lista di tutti i contatti.
     */
    public List<Contatto> mostraRubrica() {
        return this.contatti;
    }

    /**
     * @brief Cerca i contatti nella rubrica.
     * @param s Stringa con cui ricercare corrispondenze nella Lista.
     * @return Una lista di contatti che corrispondono ai criteri di ricerca.
     *
     * Metodo da implementare per filtrare i contatti in base a criteri specifici.
     */
    public List<Contatto> ricercaContatto(String s) {
        return this.contatti;
    }

    /**
     * @brief Esporta i contatti della rubrica.
     *
     * Metodo da implementare per esportare i contatti in un formato specifico
     * 
     */
    public void esportaContatto() {
       
    }

    /**
     * @brief Importa contatti nella rubrica.
     *
     * Metodo da implementare per importare contatti da un formato specifico
     * 
     */
    public void importaContatto() {
       
    }

    /**
     * @brief Elimina un contatto dalla rubrica.
     *@param c Contatto da Eliminare nella Lista.
     * Metodo da implementare per rimuovere un contatto specifico dalla lista.
     */
    public void eliminaContatto(Contatto c) {
        
    }

    /**
     * @brief Modifica un contatto esistente nella rubrica.
     *@param c Contatto da Modificare nella Lista.
     * Metodo da implementare per aggiornare i dettagli di un contatto esistente.
     *  @see setNome(), setCognome(), setTelefono1(), setTelefono2(),setTelefono3(),setEmail1(),setEmail2(),setEmail3(),setSocietà(),setIndirizzo(),setCompleanno().
     */
    public void modificaContatto(Contatto c) {
        
    }

    /**
     * @brief Annulla l'ultima operazione eseguita.
     *
     * Metodo da implementare per ripristinare lo stato precedente della rubrica,
     * utilizzando un'istanza di `AnnullaOperazione`.
     */
    public void annulla() {
       
    }

    /**
     * @brief Visualizza i dettagli di un contatto specifico.
     *
     * Metodo da implementare per mostrare i dettagli di un contatto selezionato.
     */
    public void visualizzaContatto() {
       
    }
}
