/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francesco.rubrica.Data;

import java.time.LocalDate;

/**
 * @class Contatto
 * @brief Classe che rappresenta un contatto con i relativi dettagli.
 * @invariant Il nome e il cognome del contatto non possono essere null o vuoti.
 * @invariant Tutti i numeri di telefono(telefono1, telefono2, telefono3) devono essere validi se specificati.
 * @invariant Tutte le email (email1, email2, email3) devono essere valide se specificate.
 * @invariant La data di compleanno, se presente, deve essere una data valida.
 * Questa classe fornisce metodi per accedere e modificare le informazioni
 * personali di un contatto, tra cui nome, cognome, numeri di telefono, email,
 * azienda, indirizzo e data di compleanno.
 * @see java.time.LocalDate
 */
public class Contatto implements Comparable<Contatto> {
    /**
     * @brief Nome del contatto.
     * @invariant Il nome non può essere null o vuoto.
     */
    private String nome;

    /**
     * @brief Cognome del contatto.
     * @invariant Il cognome non può essere null o vuoto.
     */
    private String cognome;

    /**
     * @brief Primo numero di telefono del contatto.
     * @invariant Se non null, deve essere un numero di telefono valido.
     */
    private String telefono1;

    /**
     * @brief Secondo numero di telefono del contatto.
     * @invariant Se non null, deve essere un numero di telefono valido.
     */
    private String telefono2;

    /**
     * @brief Terzo numero di telefono del contatto.
     * @invariant Se non null, deve essere un numero di telefono valido.
     */
    private String telefono3;

    /**
     * @brief Prima email del contatto.
     * @invariant Se non null, deve essere un indirizzo email valido
     */
    private String email1;

    /**
     * @brief Seconda email del contatto.
     * @invariant Se non null, deve essere un indirizzo email valido
     */
    private String email2;

    /**
     * @brief Terza email del contatto.
     * @invariant Se non null, deve essere un indirizzo email valido
     */
    private String email3;

    /**
     * @brief Nome dell'azienda associata al contatto.
     */
    private String società;

    /**
     * @brief Indirizzo del contatto.
     */
    private String indirizzo;

    /**
     * @brief Data di compleanno del contatto.
     * @invariant Se specificata, deve essere una data valida.
     */
    private LocalDate compleanno;


    /**
     * @param nome    Nome del contatto.
     * @param cognome Cognome del contatto.
     * @brief Costruttore essenziale per creare un contatto con solo nome e cognome.
     * @pre Almeno uno tra nome e cognome deve essere fornito e non vuoto.
     * @post Crea un oggetto Contatto con nome e cognome inizializzati.
     */
    public Contatto(String nome, String cognome) {
        if ((nome == null || nome.isEmpty()) && (cognome == null || cognome.isEmpty())) {
            throw new IllegalArgumentException("Almeno uno tra nome e cognome deve essere fornito.");
        }
        this.nome = nome;
        this.cognome = cognome;
    }


    public static boolean emailValida(String email) {


        if (email == null || email.trim().isEmpty()) {
            return true;
        }

        return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public static boolean numeroValido(String telefono) {

        if (telefono == null || telefono.trim().isEmpty()) {
            return true;
        }
        return (telefono.matches("^\\+?[0-9]{10,15}$"));
    }

    /**
     * @param nome       Nome del contatto.
     * @param cognome    Cognome del contatto.
     * @param telefono1  Primo numero di telefono.
     * @param telefono2  Secondo numero di telefono.
     * @param telefono3  Terzo numero di telefono.
     * @param email1     Prima email del contatto.
     * @param email2     Seconda email del contatto.
     * @param email3     Terza email del contatto.
     * @param società    Nome dell'azienda.
     * @param indirizzo  Indirizzo del contatto.
     * @param compleanno Data di compleanno del contatto.
     * @brief Costruttore completo per creare un contatto con dettagli completi.
     * @pre Almeno uno tra nome e cognome deve essere fornito e non vuoto.
     * @post Crea un oggetto Contatto con tutti i campi inizializzati.
     */
    public Contatto(String nome, String cognome, String telefono1, String telefono2,
                    String telefono3, String email1, String email2, String email3,
                    String società, String indirizzo, LocalDate compleanno) {
        if ((nome == null || nome.isEmpty()) && (cognome == null || cognome.isEmpty())) {
            throw new IllegalArgumentException("Almeno uno tra nome e cognome deve essere fornito.");
        } else {
            this.nome = nome;
            this.cognome = cognome;
        }
        if (numeroValido(telefono1)) {
            this.telefono1 = telefono1;
        } else {
            this.telefono1 = "";
        }

        if (numeroValido(telefono2)) {
            this.telefono2 = telefono2;
        } else {
            this.telefono2 = "";
        }
        if (numeroValido(telefono3)) {
            this.telefono3 = telefono3;
        } else {
            this.telefono3 = "";
        }
        if (emailValida(email1)) {
            this.email1 = email1;
        } else {
            this.email1 = "";
        }
        if (emailValida(email2)) {
            this.email2 = email2;
        } else {
            this.email2 = "";
        }
        if (emailValida(email3)) {
            this.email3 = email3;
        } else {
            this.email3 = "";
        }
        this.società = società;
        this.indirizzo = indirizzo;
        this.compleanno = compleanno;

    }

    /**
     * @return Stringa contenente il primo numero di telefono.
     * @brief Restituisce il primo numero di telefono.
     */
    public String getTelefono1() {
        return telefono1;
    }

    /**
     * @return Stringa contenente il cognome.
     * @brief Restituisce il cognome del contatto.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @return Stringa contenente il secondo numero di telefono.
     * @brief Restituisce il secondo numero di telefono.
     */
    public String getTelefono2() {
        return telefono2;
    }

    /**
     * @return Stringa contenente il terzo numero di telefono.
     * @brief Restituisce il terzo numero di telefono.
     */
    public String getTelefono3() {
        return telefono3;
    }

    /**
     * @return Stringa contenente la prima mail del contatto.
     * @brief Restituisce la prima mail del contatto.
     */
    public String getEmail1() {
        return email1;
    }

    /**
     * @return Stringa contenente la seconda mail del contatto.
     * @brief Restituisce la seconda mail del contatto.
     */
    public String getEmail2() {
        return email2;
    }

    /**
     * @return Stringa contenente la terza mail del contatto.
     * @brief Restituisce la tera mail del contatto.
     */
    public String getEmail3() {
        return email3;
    }

    /**
     * @return Stringa contenente la società del contatto.
     * @brief Restituisce la società del contatto.
     */
    public String getSocietà() {
        return società;
    }

    /**
     * @return Stringa contenente l'indirizzo del contatto.
     * @brief Restituisce l'indirizzo del contatto.
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * @param cognome Cognome del contatto da impostare.
     * @brief Imposta il cognome del contatto.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    /**
     * @brief Imposta il secondo numero di telefono.
     * @param telefono2 Secondo numero di telefono da impostare.
     */

    /**
     * @param telefono1 Primo numero di telefono da impostare.
     * @brief Imposta il primo numero di telefono.
     */
    public void setTelefono1(String telefono1) {
        if (!Contatto.numeroValido(telefono1)) {
            throw new IllegalArgumentException("Telefono1 non valido. Deve contenere solo numeri e può includere un prefisso +.");
        }
        this.telefono1 = telefono1;
    }

    /**
     * @param telefono2 Secondo numero di telefono da impostare.
     * @brief Imposta il secondo numero di telefono.
     */
    public void setTelefono2(String telefono2) {
        if (!Contatto.numeroValido(telefono2)) {
            throw new IllegalArgumentException("Telefono2 non valido. Deve contenere solo numeri e può includere un prefisso +.");
        }
        this.telefono2 = telefono2;
    }

    /**
     * @param telefono3 Terzo numero di telefono da impostare.
     * @brief Imposta il terzo numero di telefono.
     */
    public void setTelefono3(String telefono3) {
        if (!Contatto.numeroValido(telefono3)) {
            throw new IllegalArgumentException("Telefono3 non valido. Deve contenere solo numeri e può includere un prefisso +.");
        }
        this.telefono3 = telefono3;
    }

    /**
     * @param email1 Prima mail del contatto da impostare.
     * @brief Imposta la prima mail del contatto.
     */
    public void setEmail1(String email1) {
        if (email1 == null) {
            this.email1 = null;
            return;
        }
        if (email1.trim().isEmpty()) {
            this.email1 = "";
            return;
        }
        if (!emailValida(email1)) {
            throw new IllegalArgumentException("Email1 non valida.");
        }
        this.email1 = email1;
    }

    /**
     * @param email2 Seconda mail del contatto da impostare.
     * @brief Imposta la seconda mail del contatto.
     */
    public void setEmail2(String email2) {
        if (email2 == null) {
            this.email2 = null;
            return;
        }
        if (email2.trim().isEmpty()) {
            this.email2 = "";
            return;
        }
        if (!emailValida(email2)) {
            throw new IllegalArgumentException("Email2 non valida.");
        }
        this.email2 = email2;
    }

    /**
     * @param email3 terza mail del contatto da impostare.
     * @brief Imposta la terza mail del contatto.
     */
    public void setEmail3(String email3) {
        if (email3 == null) {
            this.email3 = null;
            return;
        }
        if (email3.trim().isEmpty()) {
            this.email3 = "";
            return;
        }
        if (!emailValida(email3)) {
            throw new IllegalArgumentException("Email3 non valida.");
        }
        this.email3 = email3;
    }

    /**
     * @param società Società del contatto da impostare.
     * @brief Imposta la società del contatto.
     */
    public void setSocietà(String società) {
        this.società = società;
    }

    /**
     * @param indirizzo Indirizzo del contatto da impostare.
     * @brief Imposta l'indirizzo del contatto.
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * @return Stringa contenente il nome.
     * @brief Restituisce il nome del contatto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome Nome da impostare.
     * @brief Imposta il nome del contatto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return Data di compleanno del contatto come `LocalDate`.
     * @brief Restituisce la data di compleanno.
     */
    public LocalDate getCompleanno() {
        return compleanno;
    }

    /**
     * @param compleanno Data di compleanno da impostare.
     * @brief Imposta la data di compleanno del contatto.
     */
    public void setCompleanno(LocalDate compleanno) {
        this.compleanno = compleanno;
    }

    /**
     * @param other Contatto con cui confrontare l'istanza corrente.
     * @return Un valore negativo, zero o positivo se il contatto corrente è rispettivamente
     * successivo, uguale o precedente rispetto a "other".
     * @brief Confronta due contatti per ordinamento alfabetico.
     * @see Comparable
     */
    @Override
    public int compareTo(Contatto other) {
        int comparnome = this.nome.compareToIgnoreCase(other.nome);
        if (comparnome != 0) {
            return comparnome;
        }
        return this.cognome.compareToIgnoreCase(other.cognome);
    }

}