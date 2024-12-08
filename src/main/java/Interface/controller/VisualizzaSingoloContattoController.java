/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.controller;
/**
 * @file VisualizzaSingoloContattoController.java
 * @brief Controller per la visualizzazione dei dettagli di un singolo contatto.
 *
 * Questo Interface.fxml.controller gestisce la visualizzazione dei dettagli di un contatto
 * selezionato dall'utente nell'interfaccia grafica di JavaFX.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import data.Contatto;
import javafx.event.ActionEvent;

/**
 * @class VisualizzaSingoloContattoController
 * @brief Classe FXML Controller per visualizzare i dettagli di un singolo contatto.
 * @invariant Il contatto selezionato deve essere sempre valido (non null e con dati consistenti).
 * @invariant Tutti i campi grafici (es. `nameContent`, `surnameContent`, ecc.) devono essere inizializzati correttamente.
 * @invariant La lista `Contacts` deve essere sincronizzata con lo stato della rubrica.
 * Fornisce metodi per gestire l'interazione con i dettagli di un contatto selezionato
 * e permette di modificarlo, eliminarlo o tornare indietro.
 */
public class VisualizzaSingoloContattoController implements Initializable {

    /**
     * @brief Etichetta per mostrare il nome del contatto.
     */
    @FXML
    private Label nameContent;

    /**
     * @brief Etichetta per mostrare il cognome del contatto.
     */
    @FXML
    private Label surnameContent;

    /**
     * @brief Etichetta per mostrare la data di nascita del contatto.
     */
    @FXML
    private Label birthdayContent;

    /**
     * @brief Etichetta per mostrare il nome dell'azienda del contatto.
     */
    @FXML
    private Label companyContent;

    /**
     * @brief Etichetta per mostrare il primo numero di telefono del contatto.
     */
    @FXML
    private Label numberContent1;

    /**
     * @brief Etichetta per mostrare il secondo numero di telefono del contatto.
     */
    @FXML
    private Label numberContent2;

    /**
     * @brief Etichetta per mostrare il terzo numero di telefono del contatto.
     */
    @FXML
    private Label numberContent3;

    /**
     * @brief Etichetta per mostrare la prima email del contatto.
     */
    @FXML
    private Label emailContent1;

    /**
     * @brief Etichetta per mostrare la seconda email del contatto.
     */
    @FXML
    private Label emailContent2;

    /**
     * @brief Etichetta per mostrare la terza email del contatto.
     */
    @FXML
    private Label emailContent3;

    /**
     * @brief Etichetta per mostrare l'indirizzo del contatto.
     */
    @FXML
    private Label adressContent;

    /**
     * @brief Pulsante per aprire la finestra di modifica del contatto.
     */
    @FXML
    private Button modifyButton;

    /**
     * @brief Pulsante per eliminare il contatto.
     */
    @FXML
    private Button deleteButton;

    /**
     * @brief Pulsante per tornare alla visualizzazione della rubrica.
     */
    @FXML
    private Button returnButton;

    /**
     * @brief Lista osservabile contenente i contatti.
     */
    @FXML
    private ObservableList<Contatto> Contacts;

    /**
     * @brief Inizializza il Interface.fxml.controller.
     * @param url URL per l'inizializzazione del Interface.fxml.controller.
     * @param rb ResourceBundle per la localizzazione.
     * @invariant Dopo l'inizializzazione, tutti i campi grafici devono essere non null.
     * Questo metodo viene chiamato automaticamente per inizializzare i componenti
     * FXML al caricamento della scena.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

/**
 * @brief Apre la finestra per modificare il contatto selezionato.
 * @param event L'evento che ha scatenato l'azione(Il tasto "Modifica").
 * @pre L'utente ha selezionato un contatto della rubrica.
 * @post Si apre l'interfaccia "ModificaContattoController.Interface.fxml"
 * Metodo che permette all'utente di passare alla finestra di modifica
 * del contatto attualmente visualizzato. 
 */
@FXML
public void displayModificaContatto(ActionEvent event) {
    
}

/**
 * @brief Elimina il contatto visualizzato.
 * @param event L'evento che ha scatenato l'azione(Il tasto "Elimna").
 * @pre L'utente ha selezionato un contatton in rubrica.
 * @post Il contatto viene rimosso dalla rubrica e la lista dei contatti è aggiornata.
 * Metodo che permette di eliminare il contatto attualmente selezionato
 * dalla rubrica.
 * @see eliminaContatto(Contatto c).
 */
@FXML
public void eliminaContatto(ActionEvent event) {
    
}

/**
 * @brief Annulla l'operazione corrente e torna alla rubrica.
 * @param event L'evento che ha scatenato l'azione(Il tasto "Annulla").
 * @pre L'utente deve aver selezionato un contatto valido per visualizzarne i dettagli.
 * @post L'utente torna alla `MainInterface` senza modificare il contatto.
 * Metodo che permette all'utente di tornare alla visualizzazione della
 * lista completa dei contatti senza modificare nulla. 
 * @see annulla().
 */
@FXML
public void annulla(ActionEvent event) {
}

}