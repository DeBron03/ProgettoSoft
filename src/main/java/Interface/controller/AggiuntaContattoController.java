/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.controller;

/**
 * @file AggiuntaContattoController.java
 * @brief Controller per la gestione dell'aggiunta di un contatto nell'interfaccia grafica.
 *
 * Questo Interface.fxml.controller gestisce l'interfaccia grafica per l'aggiunta di un nuovo contatto
 * alla rubrica utilizzando JavaFX.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import data.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


/**
 * @class AggiuntaContattoController
 * @brief Classe FXML Controller per la gestione dell'aggiunta dei contatti.
 *
 * Gestisce i campi di input e i pulsanti relativi all'aggiunta di un nuovo contatto
 * nella rubrica.
 */
public class AggiuntaContattoController implements Initializable {

    /**
     * @brief Campo per inserire il nome del contatto.
     */
    @FXML
    private TextField nameField;

    /**
     * @brief Campo per inserire il cognome del contatto.
     */
    @FXML
    private TextField surnameField;

    /**
     * @brief Campo per selezionare la data di nascita del contatto.
     */
    @FXML
    private DatePicker birthdayField;

    /**
     * @brief Campo per inserire la società del contatto.
     */
    @FXML
    private TextField companyField;

    /**
     * @brief Campo per inserire il primo numero di telefono.
     */
    @FXML
    private TextField numberField1;

    /**
     * @brief Campo per inserire il secondo numero di telefono.
     */
    @FXML
    private TextField numberField2;

    /**
     * @brief Campo per inserire il terzo numero di telefono.
     */
    @FXML
    private TextField numberField3;

    /**
     * @brief Campo per inserire la prima email del contatto.
     */
    @FXML
    private TextField emailField1;

    /**
     * @brief Campo per inserire la seconda email del contatto.
     */
    @FXML
    private TextField emailField2;

    /**
     * @brief Campo per inserire la terza email del contatto.
     */
    @FXML
    private TextField emailField3;

    /**
     * @brief Campo per inserire l'indirizzo del contatto.
     */
    @FXML
    private TextField adressField;

    /**
     * @brief Pulsante per aggiungere un nuovo contatto.
     */
    @FXML
    private Button addButton;

    /**
     * @brief Pulsante per annullare l'aggiunta di un contatto.
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
     * @param url URL per inizializzare il Interface.fxml.controller.
     * @param rb ResourceBundle per localizzazione.
     *
     * Questo metodo viene chiamato automaticamente all'avvio per inizializzare
     * i componenti FXML.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    /**
 * @brief Aggiunge un nuovo contatto alla rubrica.
 * @param event L'evento che ha scatenato l'azione(Il tasto "Fine").
 * @pre  I campi "nameField" e "surnameField" devono essere compilati. Gli altri campi possono essere vuoti.
 * @post Un contatto è aggiunto sia alla lista grafica che alla struttura dati sottostante.
 * Metodo che gestisce la logica per l'aggiunta di un contatto alla rubrica.
 * 
 * @see aggiungiContatto().
 */
@FXML
public void aggiungiContatto(ActionEvent event) {
   
}

/**
 * @brief Annulla l'operazione corrente.
 * @param event L'evento che ha scatenato l'azione(Il tasto "Annulla").
 * @pre L'utente Deve aver eseguito l'operazione di aggiunta.
 * @post L'utente torna alla MainInterface.
 * Metodo che gestisce la logica per annullare l'aggiunta di un contatto.
 * @see annulla().
 */
@FXML
public void annulla(ActionEvent event) {
    
}

}
