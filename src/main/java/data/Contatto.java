/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author gruppo13
 */
/**
 * @file Contatto.java
 * @brief Rappresenta un contatto nella rubrica.
 *
 * La classe `Contatto` modella i dettagli di un contatto, includendo
 * informazioni personali, numeri di telefono, email, azienda e indirizzo.
 */

import java.time.LocalDate;

/**
 * @class Contatto
 * @brief Classe che rappresenta un contatto con i relativi dettagli.
 *
 * Questa classe fornisce metodi per accedere e modificare le informazioni
 * personali di un contatto, tra cui nome, cognome, numeri di telefono, email,
 * azienda, indirizzo e data di compleanno.
 */
public class Contatto {
    /**
     * @brief Nome del contatto.
     */
    private String nome;

    /**
     * @brief Cognome del contatto.
     */
    private String cognome;

    /**
     * @brief Primo numero di telefono del contatto.
     */
    private String telefono1;

    /**
     * @brief Secondo numero di telefono del contatto.
     */
    private String telefono2;

    /**
     * @brief Terzo numero di telefono del contatto.
     */
    private String telefono3;

    /**
     * @brief Prima email del contatto.
     */
    private String email1;

    /**
     * @brief Seconda email del contatto.
     */
    private String email2;

    /**
     * @brief Terza email del contatto.
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
     */
    private LocalDate compleanno;

    /**
     * @brief Costruttore per creare un contatto con dettagli completi.
     * @param nome Nome del contatto.
     * @param cognome Cognome del contatto.
     * @param telefono1 Primo numero di telefono.
     * @param telefono2 Secondo numero di telefono.
     * @param telefono3 Terzo numero di telefono.
     * @param email1 Prima email del contatto.
     * @param email2 Seconda email del contatto.
     * @param email3 Terza email del contatto.
     * @param societa Nome dell'azienda.
     * @param indirizzo Indirizzo del contatto.
     * @param compleanno Data di compleanno del contatto.
     */
    public Contatto(String nome, String cognome, String telefono1, String telefono2,
                    String telefono3, String email1, String email2, String email3,
                    String società, String indirizzo, LocalDate compleanno) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.telefono3 = telefono3;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.società = società;
        this.indirizzo = indirizzo;
        this.compleanno = compleanno;
    }

    // Metodi getter e setter con documentazione

    /**
     * @brief Restituisce il primo numero di telefono.
     * @return Stringa contenente il primo numero di telefono.
     */
    public String getTelefono1() {
        return telefono1;
    }

    /**
     * @brief Imposta il primo numero di telefono.
     * @param telefono1 Primo numero di telefono da impostare.
     */
    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }
    /**
     * @brief Restituisce il cognome del contatto.
     * @return Stringa contenente il cognome.
     */
    public String getCognome() {
        return cognome;
    }
    /**
     * @brief Restituisce il secondo numero di telefono.
     * @return Stringa contenente il secondo numero di telefono.
     */
    public String getTelefono2() {
        return telefono2;
    }
    /**
     * @brief Restituisce il terzo numero di telefono.
     * @return Stringa contenente il terzo numero di telefono.
     */
    public String getTelefono3() {
        return telefono3;
    }
    /**
     * @brief Restituisce la prima mail del contatto.
     * @return Stringa contenente la prima mail del contatto.
     */
    public String getEmail1() {
        return email1;
    }
    /**
     * @brief Restituisce la seconda mail del contatto.
     * @return Stringa contenente la seconda mail del contatto.
     */
    public String getEmail2() {
        return email2;
    }
    /**
     * @brief Restituisce la tera mail del contatto.
     * @return Stringa contenente la terza mail del contatto.
     */
    public String getEmail3() {
        return email3;
    }
    /**
     * @brief Restituisce la società del contatto.
     * @return Stringa contenente la società del contatto.
     */
    public String getSocietà() {
        return società;
    }
    /**
     * @brief Restituisce l'indirizzo del contatto.
     * @return Stringa contenente l'indirizzo del contatto.
     */
    public String getIndirizzo() {
        return indirizzo;
    }
    /**
     * @brief Imposta il cognome del contatto.
     * @param cognome Cognome del contatto da impostare.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    /**
     * @brief Imposta il secondo numero di telefono.
     * @param telefono2 Secondo numero di telefono da impostare.
     */
    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }
    /**
     * @brief Imposta il terzo numero di telefono.
     * @param telefono3 Terzo numero di telefono da impostare.
     */
    public void setTelefono3(String telefono3) {
        this.telefono3 = telefono3;
    }
    /**
     * @brief Imposta la prima mail del contatto.
     * @param email1 Prima mail del contatto da impostare.
     */
    public void setEmail1(String email1) {
        this.email1 = email1;
    }
    /**
     * @brief Imposta la seconda mail del contatto.
     * @param email2 Seconda mail del contatto da impostare.
     */
    public void setEmail2(String email2) {
        this.email2 = email2;
    }
    /**
     * @brief Imposta la terza mail del contatto.
     * @param email3 terza mail del contatto da impostare.
     */
    public void setEmail3(String email3) {
        this.email3 = email3;
    }
    /**
     * @brief Imposta la società del contatto.
     * @param società Società del contatto da impostare.
     */
    public void setSocietà(String società) {
        this.società = società;
    }
    /**
     * @brief Imposta l'indirizzo del contatto.
     * @param indirizzo Indirizzo del contatto da impostare.
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    
    
    /**
     * @brief Restituisce il nome del contatto.
     * @return Stringa contenente il nome.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief Imposta il nome del contatto.
     * @param nome Nome da impostare.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @brief Restituisce la data di compleanno.
     * @return Data di compleanno del contatto come `LocalDate`.
     */
    public LocalDate getCompleanno() {
        return compleanno;
    }

    /**
     * @brief Imposta la data di compleanno del contatto.
     * @param compleanno Data di compleanno da impostare.
     */
    public void setCompleanno(LocalDate compleanno) {
        this.compleanno = compleanno;
    }
}
