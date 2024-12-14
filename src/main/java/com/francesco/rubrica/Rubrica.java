/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francesco.rubrica;

/**
 *
 * @author lucac
 */
/**
 * @file Rubrica.java
 * @brief Classe per la gestione della rubrica dei contatti.
 * @invariant La lista contatti non deve mai essere null.
 * @invariant Non ci devono essere duplicati nella lista contatti.
 * @invariant Ogni contatto nella lista contatti deve essere valido.
 * La classe Rubrica fornisce metodi per aggiungere, visualizzare, cercare,
 * modificare, esportare, importare ed eliminare contatti, oltre a supportare
 * l'annullamento di operazioni.
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Locale;


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
    private ObservableList<Contatto> contatti;


    /**
     * @brief Costruttore per inizializzare una rubrica vuota.
     */
    public Rubrica(){
        this.contatti = FXCollections.observableArrayList();


    }

    /**
     * @param contatto Il contatto da aggiungere.
     * @brief Aggiunge un nuovo contatto alla rubrica.
     * @invariant Dopo l'aggiunta, la lista non deve contenere duplicati.
     * @invariant Il contatto aggiunto deve essere valido(aggiunta di un nome o un cognome).
     */
    public void aggiungiContatto(Contatto contatto) {
        if (contatto == null) {
            throw new IllegalArgumentException("Il contatto non può essere null.");
        }
        this.contatti.add(contatto); // contatti è la lista osservabile
    }


    public ObservableList<Contatto> getContatti() {
        return contatti;
    }


    /**
     * @param s Stringa con cui ricercare corrispondenze nella Lista.
     * @return Una lista di contatti che corrispondono ai criteri di ricerca.
     * <p>
     * Metodo da implementare per filtrare i contatti in base a criteri specifici.
     * @brief Cerca i contatti nella rubrica.
     */
    public ObservableList<Contatto> ricercaContatto(String s) {
        if (s == null || s.isEmpty()) {
            return contatti;
        }

        ObservableList<Contatto> risultati= FXCollections.observableArrayList();
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
     * <p>
     * Metodo da implementare per esportare i contatti in un formato specifico
     */
    public void esportaContatto(String filename) throws IOException {

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            // 1. Scrive l'intestazione delle colonne nel file CSV
            pw.println("NOME; COGNOME; TELEFONO 1; TELEFONO 2; TELEFONO 3; EMAIL1; EMAIL2; EMAIL3; SOCIETA'; INDIRIZZO; COMPLEANNO");
            for (Contatto s : contatti) {

                pw.print(s.getNome() + ";");
                pw.print(s.getCognome() + ";");
                pw.print(s.getTelefono1() + ";");
                pw.print(s.getTelefono2() + ";");
                pw.print(s.getTelefono3() + ";");
                pw.print(s.getEmail1() + ";");
                pw.print(s.getEmail2() + ";");
                pw.print(s.getEmail3() + ";");
                pw.print(s.getSocietà() + ";");
                pw.print(s.getIndirizzo() + ";");
                if (s.getCompleanno() != null)
                    pw.println((s.getCompleanno()));
                else pw.println("" + ";");
            }


        } catch (IOException e) {

            throw new IOException("Errore durante l'esportazione dei contatti.");
        }
    }

    /**
     * @brief Importa contatti nella rubrica.
     * @invariant I contatti importati devono essere validi e non devono introdurre duplicati.
     * Metodo da implementare per importare contatti da un formato specifico
     */
    public void importaContatto(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            // Leggi la prima riga (intestazione) e ignorala
            line = reader.readLine();
            System.out.println("Intestazione ignorata: " + line);

            // Leggi le righe successive contenenti i contatti
            while ((line = reader.readLine()) != null) {
                // Se la riga è vuota o malformata, la ignoro
                if (line.isEmpty() || !line.contains(";")) {
                    continue;
                }

                // Stampa la riga per il debug
                System.out.println("Riga letta: " + line);

                // Split dei campi della riga
                String[] fields = line.split(";");

                // Estrazione dei campi dal CSV
                String nome = fields[0].trim();
                String cognome = fields[1].trim();
                String telefono1 = fields[2].trim().isEmpty() ? " " : fields[2].trim();
                String telefono2 = fields[3].trim().isEmpty() ? " " : fields[3].trim();
                String telefono3 = fields[4].trim().isEmpty() ? " " : fields[4].trim();
                String email1 = fields[5].trim().isEmpty() ?    " " : fields[5].trim();
                String email2 = fields[6].trim().isEmpty() ? " " : fields[6].trim();
                String email3 = fields[7].trim().isEmpty() ? " " : fields[7].trim();
                String società = fields[8].trim().isEmpty() ? " " : fields[8].trim();
                String indirizzo = fields[9].trim().isEmpty() ? " " : fields[9].trim();
                String compleannoStringa = fields[10].trim();


                // Verifica che almeno nome o cognome non siano vuoti
                if (nome.isEmpty() && cognome.isEmpty()) {
                    System.out.println("Contatto ignorato: manca sia il nome che il cognome.");
                    continue; // Salta il contatto se entrambi sono vuoti
                }

                // Gestione del formato della data
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ENGLISH);
                LocalDate compleanno = null;
                if (!compleannoStringa.isEmpty()) {
                    try {
                        compleanno = LocalDate.parse(compleannoStringa, formatter);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato data non valido per: " + compleannoStringa);
                    }
                }

                // Creazione del nuovo contatto
                Contatto nuovoContatto = new Contatto(
                        nome, cognome, telefono1, telefono2, telefono3,
                        email1, email2, email3, società, indirizzo, compleanno
                );

                // Aggiungi il contatto alla lista
                this.contatti.add(nuovoContatto);
            }

            System.out.println("Contatti importati con successo.");

        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        }
    }


    /**
     * @param c Contatto da Eliminare nella Lista.
     *          Metodo da implementare per rimuovere un contatto specifico dalla lista.
     * @brief Elimina un contatto dalla rubrica.
     */
    public void eliminaContatto(Contatto c) {
        contatti.remove(c);
        System.out.println("Contatto eliminato con successo.");
    }

    /**
     * @param contattoOriginale,nuoviDati Contatto da Modificare nella Lista.
     * @brief Modifica un contatto esistente nella rubrica.
     * @invariant Dopo la modifica, il contatto deve rimanere valido.
     * Metodo da implementare per aggiornare i dettagli di un contatto esistente.
     */
    public void modificaContatto(Contatto contattoOriginale, Contatto nuoviDati) {
        int index = contatti.indexOf(contattoOriginale);
        contatti.set(index, nuoviDati);
        System.out.println("Contatto modificato con successo alla poszione" + " " + index);
    }

    public void ordina (List<Contatto> contatti) {
        Collections.sort(contatti);
    }
}

