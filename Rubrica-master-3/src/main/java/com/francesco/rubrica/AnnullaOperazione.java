/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francesco.rubrica;

/**
 *
 * @author gruppo13
 */
import com.francesco.rubrica.Contatto;
import java.util.ArrayList;
import java.util.List;

/**
 * @class AnnullaOperazione
 * @brief Classe per gestire gli stati precedenti dei contatti.
 * @invariant La lista `statiPrecedenti` non deve mai essere null.
 * @invariant Ogni stato salvato in `statiPrecedenti` deve essere una copia indipendente
 *            dello stato corrente dei contatti.
 * Questa classe permette di salvare lo stato corrente dei contatti e
 * di ripristinare uno stato precedente in caso di annullamento.
 */
public class AnnullaOperazione {
    /**
     * @brief Lista che contiene gli stati precedenti dei contatti.
     * @invariant La lista non deve mai essere null.
     */
    private List<Contatto> statoPrecedente;

    /**
     * @brief Costruttore di default.
     *
     * Inizializza la lista degli stati precedenti come una nuova lista vuota.
     */
    public AnnullaOperazione() {
        statoPrecedente = new ArrayList<>();
    }

    /**
     * @brief Salva lo stato corrente dei contatti.
     * @param statoCorrente La lista dei contatti rappresentante lo stato attuale.
     *
     * Questo metodo consente di memorizzare lo stato corrente dei contatti
     * nella lista degli stati precedenti.
     */
    public void salvaStato(List<Contatto> statoCorrente) {
        statoPrecedente = new ArrayList<>(statoCorrente);
    }

    /**
     * @brief Ripristina uno stato precedente dei contatti.
     * @invariant Se la lista `statiPrecedenti` è vuota, restituisce null o un valore predefinito.
     * @invariant Dopo il ripristino, lo stato attuale deve corrispondere all'ultimo stato salvato.
     *
     * @return Una lista dei contatti che rappresenta lo stato precedente.
     *
     * Questo metodo restituisce l'ultimo stato salvato dei contatti,
     * permettendo di annullare l'operazione corrente.
     */
    public List<Contatto> annulla() {
        return new ArrayList<>(statoPrecedente);
    }
}