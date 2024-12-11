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
 * @invariant La lista `contatti` non deve mai essere null.
 * @invariant Non ci devono essere duplicati nella lista `contatti`.
 * @invariant Ogni contatto nella lista `contatti` deve essere valido.
 * La classe `Rubrica` fornisce metodi per aggiungere, visualizzare, cercare,
 * modificare, esportare, importare ed eliminare contatti, oltre a supportare
 * l'annullamento di operazioni.
 */

import annullaoperazione.AnnullaOperazione;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

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
     * @invariant La lista deve essere sempre inizializzata e non può mai essere null.
     */
    private List<Contatto> contatti;
    private String nomerubrica;
    //private AnnullaOperazione annullaOperazione;
    /**
     * @brief Costruttore per inizializzare una rubrica vuota.
     */
    public Rubrica(String nomerubrica) {
        this.contatti = new ArrayList<>();
        // this.annullaOperazione = new AnnullaOperazione();
        this.nomerubrica=nomerubrica;
    }

    /**
     * @brief Aggiunge un nuovo contatto alla rubrica.
     * @param contatto Il contatto da aggiungere.
     * @invariant Dopo l'aggiunta, la lista non deve contenere duplicati.
     * @invariant Il contatto aggiunto deve essere valido(aggiunta di un nome o un cognome).
     */
    public void aggiungiContatto(Contatto contatto) {
        contatti.add(contatto);
        System.out.println("Contatto aggiunto con successo.");

    }




    /**
     * @brief Cerca i contatti nella rubrica.
     * @param s Stringa con cui ricercare corrispondenze nella Lista.
     * @return Una lista di contatti che corrispondono ai criteri di ricerca.
     *
     * Metodo da implementare per filtrare i contatti in base a criteri specifici.
     */
    public List<Contatto> ricercaContatto(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>(contatti); // Restituisce una copia della lista originale
        }

        List<Contatto> risultati = new ArrayList<>();
        for (Contatto contatto : contatti) {
            if (contatto.getNome().toLowerCase().startsWith(s.toLowerCase()) ||
                    contatto.getCognome().toLowerCase().startsWith(s.toLowerCase())) {
                risultati.add(contatto);
            }
        }

        return risultati; // Restituisce solo i risultati trovati
    }

    /**
     * @brief Esporta i contatti della rubrica.
     *
     * Metodo da implementare per esportare i contatti in un formato specifico
     *
     */
    public void esportaContatto(String filename) throws IOException{

        try( PrintWriter pw= new PrintWriter(new BufferedWriter(new FileWriter(filename))) ){
            // 1. Scrive l'intestazione delle colonne nel file CSV
            pw.println("NOME;COGNOME;TELEFONO 1; TELEFONO 2;TELEFONO 3; EMAIL1; "
                    + "EMAIL2; EMAIL3;SOCIETA';INDIRIZZO;COMPLEANNO");
            //  Itera su tutti gli studenti nell'anagrafica
            for(Contatto s: contatti){

                pw.print(s.getNome());
                pw.append(';');

                pw.print(s.getCognome());
                pw.append(';');

                pw.print(s.getTelefono1());
                pw.append(';');

                pw.print(s.getTelefono2());
                pw.append(';');

                pw.println(s.getTelefono3());
                pw.append(';');

                pw.print(s.getEmail1());
                pw.append(';');

                pw.print(s.getEmail2());
                pw.append(';');

                pw.print(s.getEmail3());
                pw.append(';');

                pw.print(s.getSocietà());
                pw.append(';');

                pw.println(s.getIndirizzo());
                pw.append(';');

                pw.println(s.getCompleanno());
                pw.append(';');
            }


        }
    }

    /**
     * @brief Importa contatti nella rubrica.
     *@invariant I contatti importati devono essere validi e non devono introdurre duplicati.
     * Metodo da implementare per importare contatti da un formato specifico
     *
     */
    public Rubrica importaContatto(String filename) throws  IOException{
        String name= filename.split("[.]")[0];//nome senza .csv

        Rubrica rubrica=new Rubrica(name);

        try(Scanner s=new Scanner(new BufferedReader(new FileReader(filename)))){

            if (!s.hasNextLine()) {
                System.out.println("Errore: Il file " + filename + " è vuoto.");
                return rubrica; // Ritorna una rubrica vuota
            }//file vuoto
            s.useDelimiter("[;\n\r]"); //quando si usa lo scanner
            s.useLocale(Locale.US);//per i numeri decimali

            while(s.hasNext()){//s.hasNext(): verifica se ci sono ancora dati da leggere.

                String nome=s.next();//s.next(): legge il prossimo elemento, separato dal delimitatore configurato.
                String cognome=s.next();
                String telefono1=s.next();
                String telefono2=s.next();
                String telefono3=s.next();
                String email1=s.next();
                String email2=s.next();
                String email3=s.next();
                String società=s.next();
                String indirizzo=s.next();
                String compleannostringa=s.next();

                LocalDate compleanno = null;
                try {
                    compleanno = LocalDate.parse(compleannostringa);
                } catch (DateTimeParseException e) {
                    System.out.println("Formato data non valido per: " + compleannostringa);
                    continue;
                }

                Contatto c=new Contatto(nome,cognome,telefono1,telefono2,telefono3,email1,email2,email3,società,indirizzo,compleanno);
                rubrica.aggiungiContatto(c);
            }
            System.out.println("Contatto importato con successo.");
        }


        return rubrica;
    }



    /**
     * @brief Elimina un contatto dalla rubrica.
     *@param c Contatto da Eliminare nella Lista.
     * Metodo da implementare per rimuovere un contatto specifico dalla lista.
     */
    public void eliminaContatto(Contatto c) {
        contatti.remove(c);
        System.out.println("Contatto eliminato con successo.");
    }

    /**
     * @brief Modifica un contatto esistente nella rubrica.
     *@param c Contatto da Modificare nella Lista.
     * @invariant Dopo la modifica, il contatto deve rimanere valido.
     * Metodo da implementare per aggiornare i dettagli di un contatto esistente.
     *  @see setNome(), setCognome(), setTelefono1(), setTelefono2(),setTelefono3(),setEmail1(),setEmail2(),setEmail3(),setSocietà(),setIndirizzo(),setCompleanno().
     */
    public void modificaContatto(Contatto contattoOriginale, Contatto nuoviDati) {
        int index = contatti.indexOf(contattoOriginale);
        contatti.set(index, nuoviDati);
        System.out.println("Contatto modificato con successo.");
    }

    /**
     * @brief Annulla l'ultima operazione eseguita.
     *@invariant Lo stato della rubrica deve tornare allo stato precedente.
     * Metodo da implementare per ripristinare lo stato precedente della rubrica,
     * utilizzando un'istanza di `AnnullaOperazione`.
     */

    /*public void annulla() {
       List<Contatto> statoPrecedente = annullaOperazione.annulla();
        if (statoPrecedente != null) {
            contatti = statoPrecedente;
            System.out.println("Rubrica ripristinata allo stato precedente.");
        } else {
        System.out.println("Nessuno stato da ripristinare.");
    }*/


    public void ordina(List<Contatto> contatti){
        Collections.sort(contatti);
    }
}