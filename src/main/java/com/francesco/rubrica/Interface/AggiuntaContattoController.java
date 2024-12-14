/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francesco.rubrica.Interface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.francesco.rubrica.Main.App;
import com.francesco.rubrica.Data.Contatto;
import com.francesco.rubrica.Data.Rubrica;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import static com.francesco.rubrica.Data.Contatto.isValidEmail;
import static com.francesco.rubrica.Data.Contatto.isValidPhoneNumber;

/**
 * @class AggiuntaContattoController
 * @brief Classe FXML Controller per la gestione dell'aggiunta dei contatti.
 * Questo Controller gestisce l'interfaccia grafica per l'aggiunta di un nuovo contatto
 * alla rubrica utilizzando JavaFX.
 * @invariant Tutti i campi FXML associati (es. nameField, surnameField, ecc.) devono essere inizializzati correttamente.
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
    private TextField addressField;

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
     * @brief Rubrica che viene aggiornata dopo le operazioni .
     */

    private Rubrica rubrica;

    /**
     * @brief Imposta la rubrica condivisa.
     * @param rubrica L'istanza della rubrica da impostare.
     */
    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }

    /**
     * @brief Inizializza il Controller.
     * @param url URL per inizializzare il Controller.
     * @param rb ResourceBundle per localizzazione.
     * @invariant Dopo l'inizializzazione, tutti i campi FXML associati devono essere non null.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.rubrica=App.getRubricaCondivisa();
    }
    /**
     * @brief Aggiunge un nuovo contatto alla rubrica.
     * @param event L'evento che ha scatenato l'azione(Il tasto "Aggiungi").
     * @pre  Uno tra i campi "nameField" e "surnameField" deve essere compilato. Gli altri campi possono essere vuoti.
     * @post Un nuovo contatto valido è aggiunto alla rubrica.
     * @see Rubrica#aggiungiContatto(Contatto)
     * @invariant Dopo l'esecuzione, si ritorna nella MainInterface con la rubrica aggiornata.
     */

    @FXML
    public void aggiungiContatto(ActionEvent event) {
        if ((nameField.getText().trim() == null || nameField.getText().trim().isEmpty()) &&
                (surnameField.getText().trim() == null || surnameField.getText().trim().isEmpty())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText("Nome o cognome non inseriti");
        alert.setContentText("Inserisci almeno un nome o un cognome.");
        alert.showAndWait();
        return; }

        if (!isValidPhoneNumber(numberField1.getText().trim()) ||
                !isValidPhoneNumber(numberField2.getText().trim()) ||
                !isValidPhoneNumber(numberField3.getText().trim())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Numero di telefono non valido");
            alert.setContentText("Inserisci un numero di telefono valido (10-15 cifre).");
            alert.showAndWait();
            return;
        }

        if (!isValidEmail(emailField1.getText().trim()) ||
                !isValidEmail(emailField2.getText().trim()) ||
                !isValidEmail(emailField3.getText().trim())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Email non valida");
            alert.setContentText("Inserisci un'email valida.");
            alert.showAndWait();
            return;
        }
        String nome = nameField.getText().trim();
        String cognome = surnameField.getText().trim();
        LocalDate compleanno = birthdayField.getValue();
        String società = companyField.getText().trim();
        String telefono1 = numberField1.getText().trim();
        String telefono2 = numberField2.getText().trim();
        String telefono3 = numberField3.getText().trim();
        String email1 = emailField1.getText().trim();
        String email2 = emailField2.getText().trim();
        String email3 = emailField3.getText().trim();
        String indirizzo = addressField.getText().trim();

        Contatto nuovoContatto = new Contatto(
                nome, cognome, telefono1, telefono2, telefono3, email1, email2, email3, società, indirizzo, compleanno);

        App.getRubricaCondivisa().aggiungiContatto(nuovoContatto);
        System.out.println("Hai aggiunto"+" "+ nuovoContatto.getNome() +" "+ nuovoContatto.getCognome() +" alla rubrica." );

        pulisciCampi();
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/francesco/rubrica/MainInterfaceController.fxml"));
            Parent root = loader.load();
            Scene currentscene = ((javafx.scene.Node) event.getSource()).getScene();
            currentscene.setRoot(root);
            MainInterfaceController mainController = loader.getController();
            mainController.setRubrica(App.getRubricaCondivisa());

        } catch (IOException e) {
           System.out.println("Impossibile tornare alla MainInterface.");
        }
    }

    /**
     * @brief Annulla l'operazione di aggiunta.
     * @param event L'evento che ha scatenato l'azione(Il tasto "Annulla").
     * @pre L'utente deve essere in fase di aggiunta di un nuovo contatto.
     * @post L'interfaccia torna alla MainInterface senza salvare il nuovo contatto.
     */
    @FXML
    public void annulla (ActionEvent event) {
        pulisciCampi();
        System.out.println("Annullata l'aggiunta di un nuovo contatto.Torno alla MainInterface.");
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/francesco/rubrica/MainInterfaceController.fxml"));
            Parent root = loader.load();

            Scene currentscene = ((javafx.scene.Node) event.getSource()).getScene();
            currentscene.setRoot(root);

            MainInterfaceController mainController = loader.getController();
            mainController.setRubrica(App.getRubricaCondivisa());

        } catch (IOException e) {
            System.out.println("Impossibile annullare l'operazione corrente.");
        }


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
        addressField.clear();
    }
    }