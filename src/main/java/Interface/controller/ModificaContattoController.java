/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.controller;

/**
 * @file ModificaContattoController.java
 * @brief Controller per la gestione della modifica di un contatto nell'interfaccia grafica.
 *
 * Questo Interface.fxml.controller permette agli utenti di modificare i dettagli di un contatto
 * già esistente nella rubrica utilizzando JavaFX.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import data.Contatto;
import javafx.event.ActionEvent;

/**
 * @class ModificaContattoController
 * @brief Classe FXML Controller per la gestione della modifica dei contatti.
 * @invariant Tutti i campi annotati con `@FXML` devono essere inizializzati correttamente.
 * @invariant La lista `Contacts` deve essere non null e sincronizzata con lo stato della rubrica.
 * Gestisce i campi di input e i pulsanti relativi alla modifica di un contatto
 * nella rubrica.
 */
public class ModificaContattoController implements Initializable {

    /**
     * @brief Campo per modificare il nome del contatto.
     */
    @FXML
    private TextField nameField;

    /**
     * @brief Campo per modificare il cognome del contatto.
     */
    @FXML
    private TextField surnameField;

    /**
     * @brief Campo per modificare la data di nascita del contatto.
     */
    @FXML
    private DatePicker birthdayField;

    /**
     * @brief Campo per modificare l'azienda del contatto.
     */
    @FXML
    private TextField companyField;

    /**
     * @brief Campo per modificare il primo numero di telefono.
     */
    @FXML
    private TextField numberField1;

    /**
     * @brief Campo per modificare il secondo numero di telefono.
     */
    @FXML
    private TextField numberField2;

    /**
     * @brief Campo per modificare il terzo numero di telefono.
     */
    @FXML
    private TextField numberField3;

    /**
     * @brief Campo per modificare la prima email del contatto.
     */
    @FXML
    private TextField emailField1;

    /**
     * @brief Campo per modificare la seconda email del contatto.
     */
    @FXML
    private TextField emailField2;

    /**
     * @brief Campo per modificare la terza email del contatto.
     */
    @FXML
    private TextField emailField3;

    /**
     * @brief Campo per modificare l'indirizzo del contatto.
     */
    @FXML
    private TextField adressField;

    /**
     * @brief Pulsante per salvare le modifiche apportate al contatto.
     */
    @FXML
    private Button saveButton;

    /**
     * @brief Pulsante per annullare la modifica di un contatto.
     */
    @FXML
    private Button delButton;

    /**
     * @brief Lista osservabile contenente i contatti.
     */
    @FXML
    private ObservableList<Contatto> Contacts;

    /**
     * @brief Inizializza il Interface.fxml.controller.
     * @param url URL per l'inizializzazione del Interface.fxml.controller.
     * @param rb ResourceBundle per la localizzazione.
     * @invariant Dopo l'inizializzazione, tutti i campi FXML devono essere non null.
     * Questo metodo viene chiamato automaticamente per inizializzare i componenti
     * FXML al caricamento della scena.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

    /**
 * @brief Annulla la modifica del contatto.
 * @param event L'evento che ha scatenato l'azione(Il tasto "annulla").
 *  @pre L'utente Deve aver eseguito l'operazione di modifica.
 * @post L'utente torna alla `MainInterface` senza salvare le modifiche apportate.
 * Metodo che gestisce la logica per annullare le modifiche apportate ai dettagli
 * di un contatto e torna alla visualizzazione precedente. 
 * @see annulla().
 */
@FXML
public void annulla(ActionEvent event) {
   
}

/**
 * @brief Salva le modifiche apportate al contatto.
 * @param event L'evento che ha scatenato l'azione(Il tasto "Salva").
 * @pre  L'utente seleziona un contatto nella rubrica, clicca il tasto modifica e visualizza le informazioni del contatto.
 * @post Il contatto modificato è salvato nella rubrica e la lista grafica viene aggiornata.
 * Metodo che gestisce la logica per salvare le modifiche apportate ai dettagli
 * di un contatto esistente. 
 * @invariant Dopo l'esecuzione, i campi grafici e la lista `Contacts` devono essere sincronizzati.
 * @see modificaContatto(Contatto c).
 */
@FXML
public void modificaContatto(ActionEvent event) {
   
}

}
