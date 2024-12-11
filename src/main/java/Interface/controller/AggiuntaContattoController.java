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
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;



/**
 * @class AggiuntaContattoController
 * @brief Classe FXML Controller per la gestione dell'aggiunta dei contatti.
 * @invariant Tutti i campi FXML associati (es. `nameField`, `surnameField`, ecc.) devono essere inizializzati correttamente.
 * @invariant La lista osservabile `Contacts` deve essere non null e riflettere correttamente i contatti attuali.
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
     * @invariant Dopo l'inizializzazione, tutti i campi FXML associati devono essere non null.
     * Questo metodo viene chiamato automaticamente all'avvio per inizializzare
     * i componenti FXML.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    /**
 * @brief Aggiunge un nuovo contatto alla rubrica.
 * @param event L'evento che ha scatenato l'azione(Il tasto "Fine").
 * @pre  I campi "nameField" e "surnameField" devono essere compilati. Gli altri campi possono essere vuoti.
 * @post Un nuovo contatto valido è aggiunto alla lista `Contacts` e visualizzato
 *       nella lista grafica.
 * Metodo che gestisce la logica per l'aggiunta di un contatto alla rubrica.
 * 
 * @see aggiungiContatto() nella classe `Rubrica`.
 * @invariant Dopo l'esecuzione, la lista `Contacts` deve riflettere lo stato aggiornato.
 */
@FXML
public void addContact(ActionEvent event) {
    // Validazione dei campi obbligatori
    Rubrica rubrica=new Rubrica("cervo");
    String nome = nameField.getText().trim();
    String cognome = surnameField.getText().trim();
    
    if (nome.isEmpty() || cognome.isEmpty()) {
        mostraMessaggioErrore("Nome e Cognome sono campi obbligatori.");
        return;
    }

    
    LocalDate compleanno = birthdayField.getValue();
    String società = companyField.getText().trim();
    String telefono1 = numberField1.getText().trim();
    String telefono2 = numberField2.getText().trim();
    String telefono3 = numberField3.getText().trim();
    String email1 = emailField1.getText().trim();
    String email2 = emailField2.getText().trim();
    String email3 = emailField3.getText().trim();
    String indirizzo = adressField.getText().trim();

    
    Contatto nuovoContatto = new Contatto(
        nome, cognome, telefono1, telefono2, telefono3,email1, email2, email3,società,indirizzo,compleanno);
    

    rubrica.aggiungiContatto(nuovoContatto);
    
    Contacts.add(nuovoContatto);

    
    mostraMessaggioConferma("Contatto aggiunto con successo!");

    
    pulisciCampi();
}

/**
 * @brief Mostra un messaggio di errore all'utente.
 * @param messaggio Il messaggio da mostrare.
 */
private void mostraMessaggioErrore(String messaggio) {
    
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Errore");
    alert.setHeaderText(null);
    alert.setContentText(messaggio);
    alert.showAndWait();
}

/**
 * @brief Mostra un messaggio di conferma all'utente.
 * @param messaggio Il messaggio da mostrare.
 */
private void mostraMessaggioConferma(String messaggio) {
    
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Successo");
    alert.setHeaderText(null);
    alert.setContentText(messaggio);
    alert.showAndWait();
}

/**
 * @brief Pulisce i campi di input del form.
 */
private void pulisciCampi() {
    nameField.clear();
    surnameField.clear();
    birthdayField.setValue(null);
    companyField.clear();
    numberField1.clear();
    numberField2.clear();
    numberField3.clear();
    emailField1.clear();
    emailField2.clear();
    emailField3.clear();
    adressField.clear();
}

/**
 * @brief Annulla l'operazione corrente.
 * @param event L'evento che ha scatenato l'azione(Il tasto "Annulla").
 * @pre L'utente deve essere in fase di aggiunta di un nuovo contatto.
 * @post L'interfaccia torna alla `MainInterface` senza salvare il nuovo contatto.
 * Metodo che gestisce la logica per annullare l'aggiunta di un contatto.
 * @see annulla().
 */
@FXML
public void annulla(ActionEvent event) {
    
}

}
