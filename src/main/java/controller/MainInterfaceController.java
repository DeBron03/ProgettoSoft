/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 * @file MainInterfaceController.java
 * @brief Controller per la gestione dell'interfaccia principale della rubrica.
 *
 * Questa classe gestisce l'interfaccia principale della rubrica, permettendo
 * di effettuare operazioni come ricerca, aggiunta, esportazione e importazione
 * dei contatti.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import data.Contatto;
import data.Rubrica;
import javafx.event.ActionEvent;

/**
 * @class MainInterfaceController
 * @brief Controller per l'interfaccia principale della rubrica.
 *
 * Questa classe fornisce i metodi per interagire con la rubrica tramite
 * l'interfaccia grafica (JavaFX).
 */
public class MainInterfaceController implements Initializable {

    /**
     * @brief Istanza della rubrica che contiene i contatti.
     */
    private Rubrica contatti = new Rubrica();

    /**
     * @brief Campo di testo per la ricerca di contatti.
     */
    @FXML
    private TextField researchField;

    /**
     * @brief Pulsante per aggiungere un nuovo contatto.
     */
    @FXML
    private Button addContact;

    /**
     * @brief Pulsante per esportare i contatti.
     */
    @FXML
    private Button exportContact;

    /**
     * @brief Pulsante per importare i contatti.
     */
    @FXML
    private Button importContact;

    /**
     * @brief Tabella per visualizzare i contatti nella rubrica.
     */
    @FXML
    private TableView<Contatto> rubrica;

    /**
     * @brief Colonna della tabella per i nomi dei contatti.
     */
    @FXML
    private TableColumn<Contatto, String> nameClm;

    /**
     * @brief Colonna della tabella per i cognomi dei contatti.
     */
    @FXML
    private TableColumn<Contatto, String> surnameClm;

    /**
     * @brief Lista osservabile dei contatti visualizzati nella tabella.
     */
    @FXML
    private ObservableList<Contatto> Contacts;

    /**
     * @brief Inizializza il controller.
     * @param url URL per l'inizializzazione del controller.
     * @param rb ResourceBundle per la localizzazione.
     *
     * Questo metodo viene chiamato automaticamente per inizializzare i componenti
     * FXML al caricamento della scena.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

    /**
 * @brief Esporta i contatti della rubrica.
 * @param event L'evento che ha scatenato l'azione(Il tasto "esporta").
 * @pre Deve esserci almeno un contatto nella rubrica
 * @post Viene generato un file esterno con i contatti esportati.
 * Metodo che gestisce l'esportazione dei contatti in un file esterno.
 * @see esportaContatto().
 */
@FXML
public void esportaContatto(ActionEvent event) {
    
}

/**
 * @brief Importa i contatti da un file esterno.
 * @param event L'evento che ha scatenato l'azione.(Il tasto "importa")
 * @pre L'utente ha un fle, supportato dall'app, contenente i contatti.
 * @post I contatti vengono importati correttamente e la rubrica viene aggiornata.
 * Metodo che gestisce l'importazione di contatti da un file esterno.
 * @see importaContatto() 
 */
@FXML
public void importaContatto(ActionEvent event) {
    
}

/**
 * @brief Apre la finestra per aggiungere un nuovo contatto.
 * @param event L'evento che ha scatenato l'azione(Il tasto "+").
 * @pre L'utente ha selezionato "+" per aggiungere il contatto.
 * @post Si apre l'interfaccia "AggiuntaContattoController.fxml"
 * Metodo che cambia la scena per permettere l'aggiunta di un nuovo contatto.
 * Il parametro `event` può essere usato per gestire dinamicamente la transizione.
 */
@FXML
public void displayAggiungiContatto(ActionEvent event) {
   
}

/**
 * @brief Apre la finestra per visualizzare un contatto selezionato.
 * @param event L'evento che ha scatenato l'azione.
 * @pre L'utente ha selezionato un contatto nella rubrica.
 * @post Si apre l'interfaccia "VisualizzaSingoloContatto.fxml"
 * Metodo che cambia la scena per visualizzare i dettagli di un contatto.
 * Può essere utilizzato per navigare verso una vista dettagliata.
 */
@FXML
public void displayVisualizzaSingoloContatto(ActionEvent event) {
    
}

/**
 * @brief Effettua una ricerca di contatti nella rubrica.
 * @param event L'evento che ha scatenato l'azione(Utente scrive nella barra di ricerca).
 * @pre L'utente clicca sulla barra di ricerca
 * @post L'app mostra i contatti che corrispondono ai criteri di ricerca
 * Metodo che filtra i contatti visualizzati nella tabella in base al testo
 * inserito nel campo di ricerca. 
 * @see ricercaContatto(String s)
 */
@FXML
public void ricercaContatto(ActionEvent event) {
   
}
}