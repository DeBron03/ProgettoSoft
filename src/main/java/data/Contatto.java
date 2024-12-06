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
import java.time.LocalDate;

public class Contatto {
    private String nome;
    private String cognome;
    private String telefono1;
    private String telefono2;
    private String telefono3;
    private String email1;
    private String email2;
    private String email3;
    private String societa;
    private String indirizzo;
    private LocalDate compleanno;

    public Contatto(String nome, String cognome, String telefono1,String telefono2,String telefono3, String email1,String email2,String email3, String societa, String indirizzo, LocalDate compleanno) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.telefono3 = telefono3;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.societa = societa;
        this.indirizzo = indirizzo;
        this.compleanno = compleanno;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public void setTelefono3(String telefono3) {
        this.telefono3 = telefono3;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public String getTelefono3() {
        return telefono3;
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getSocieta() {
        return societa;
    }

    public void setSocieta(String societa) {
        this.societa = societa;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public LocalDate getCompleanno() {
        return compleanno;
    }

    public void setCompleanno(LocalDate compleanno) {
        this.compleanno = compleanno;
    }

    
}