/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francesco.rubrica.Data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Collections;
import java.util.Locale;


/**
 * @class Rubrica
 * @brief Classe per la gestione della rubrica dei contatti.
 * @invariant Ogni contatto nella lista contatti deve essere valido.
 * @invariant La lista dei contatti non deve mai essere null.
 * La classe Rubrica fornisce metodi per aggiungere, ordinare, cercare,
 * modificare, esportare, importare ed eliminare contatti.
 */
public class Rubrica {

    /**
     * @brief Lista che contiene tutti i contatti della rubrica.
     * @invariant La lista deve essere sempre inizializzata e non può mai essere null.
     */
    private final ObservableList<Contatto> contatti;

    /**
     * @brief Costruttore per inizializzare una rubrica vuota.
     * @post La lista dei contatti è inizializzata e vuota.
     */
    public Rubrica() {
        this.contatti = FXCollections.observableArrayList();
    }

    /**
     * @return La lista osservabile dei contatti.
     * @brief Restituisce la lista dei contatti.
     */
    public ObservableList<Contatto> getContatti() {
        return contatti;
    }


    /**
     * @param contatto Il contatto da aggiungere.
     * @brief Aggiunge un nuovo contatto alla rubrica.
     * @pre Il contatto non deve essere null.
     * @post Il contatto è aggiunto alla lista dei contatti se è valido.
     * @invariant Il contatto aggiunto deve essere valido (nome o cognome presenti).
     */
    public void aggiungiContatto(Contatto contatto) {
        if (contatto == null) {
            throw new IllegalArgumentException("Il contatto non può essere null.");
        }
        this.contatti.add(contatto);
    }

    /**
     * @param s Stringa con cui ricercare corrispondenze nella Lista.
     * @return Una lista di contatti che corrispondono ai criteri di ricerca.
     * @brief Cerca i contatti nella rubrica in base a una stringa.
     * @pre La stringa di ricerca può essere null o vuota (in tal caso restituisce tutti i contatti).
     * @post Restituisce una lista filtrata dei contatti che corrispondono ai criteri di ricerca.
     */
    public ObservableList<Contatto> ricercaContatto(String s) {
        if (s == null || s.isEmpty()) {
            return contatti;
        }
        ObservableList<Contatto> risultati = FXCollections.observableArrayList();
        for (Contatto contatto : contatti) {
            if (contatto.getNome().toLowerCase().startsWith(s.toLowerCase()) ||
                    contatto.getCognome().toLowerCase().startsWith(s.toLowerCase())) {
                risultati.add(contatto);
            }
        }
        return risultati;
    }

    /**
     * @param filename Il nome del file in cui esportare i contatti.
     * @throws IOException Se si verifica un errore durante l'esportazione.
     * @brief Esporta i contatti della rubrica in un file CSV.
     * @pre La lista dei contatti può essere sia vuota che occupata da contatti.
     * @post Il file specificato contiene i contatti esportati.
     */
    public void esportaContatto(String filename) throws IOException {

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {

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
                else pw.println(" " + ";");
            }
        } catch (IOException e) {
            throw new IOException("Errore durante l'esportazione dei contatti.");
        }
    }

    /**
     * @param filename Il nome del file da cui importare i contatti.
     * @throws IOException Se si verifica un errore durante l'importazione.
     * @brief Importa contatti da un file CSV.
     * @pre Il file deve esistere e seguire il formato corretto.
     * @post I contatti validi sono aggiunti alla rubrica.
     */
    public void importaContatto(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            line = reader.readLine();
            System.out.println("Intestazione ignorata: " + line);
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty() || !line.contains(";")) {
                    continue;
                }
                System.out.println("Riga letta: " + line);
                String[] fields = line.split(";");

                if (fields.length < 11) {
                    String[] newFields = new String[11];
                    System.arraycopy(fields, 0, newFields, 0, fields.length);
                    for (int i = fields.length; i < 11; i++) {
                        newFields[i] = "";
                    }
                    fields = newFields;
                }

                String nome = fields[0].trim();
                String cognome = fields[1].trim();
                String telefono1 = fields[2].trim().isEmpty() ? " " : fields[2].trim();
                String telefono2 = fields[3].trim().isEmpty() ? " " : fields[3].trim();
                String telefono3 = fields[4].trim().isEmpty() ? " " : fields[4].trim();
                String email1 = fields[5].trim().isEmpty() ? " " : fields[5].trim();
                String email2 = fields[6].trim().isEmpty() ? " " : fields[6].trim();
                String email3 = fields[7].trim().isEmpty() ? " " : fields[7].trim();
                String società = fields[8].trim().isEmpty() ? " " : fields[8].trim();
                String indirizzo = fields[9].trim().isEmpty() ? " " : fields[9].trim();
                String compleannoStringa = fields[10].trim().isEmpty() ? " " : fields[10].trim();

                if (nome.isEmpty() && cognome.isEmpty()) {
                    System.out.println("Contatto ignorato: manca sia il nome che il cognome.");
                    continue;
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
                LocalDate compleanno = null;
                if (!compleannoStringa.isEmpty()) {
                    try {
                        compleanno = LocalDate.parse(compleannoStringa, formatter);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato data non valido per: " + compleannoStringa);
                    }
                }
                Contatto nuovoContatto = new Contatto(
                        nome, cognome, telefono1, telefono2, telefono3,
                        email1, email2, email3, società, indirizzo, compleanno
                );
                this.contatti.add(nuovoContatto);
            }
            System.out.println("Contatti importati con successo.");
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        }
    }


    /**
     * @param c Il contatto da eliminare.
     * @brief Elimina un contatto dalla rubrica.
     * @pre Il contatto deve esistere nella lista.
     * @post Il contatto è rimosso dalla lista.
     */
    public void eliminaContatto(Contatto c) {
        contatti.remove(c);
        System.out.println("Contatto eliminato con successo.");
    }

    /**
     * @param contattoOriginale Il contatto da modificare.
     * @param nuoviDati         Il nuovo contatto con i dati aggiornati.
     * @brief Modifica un contatto esistente nella rubrica.
     * @pre Il contatto originale deve esistere nella lista.
     * @post I dettagli del contatto sono aggiornati.
     */
    public void modificaContatto(Contatto contattoOriginale, Contatto nuoviDati) {
        int index = contatti.indexOf(contattoOriginale);
        contatti.set(index, nuoviDati);
        System.out.println("Contatto modificato con successo alla indice" + " " + index);
    }

    /**
     * @param contatti La lista di contatti da ordinare.
     * @brief Ordina la lista dei contatti.
     * @see Collections#sort(List)
     */
    public void ordina(List<Contatto> contatti) {
        Collections.sort(contatti);
    }
}

