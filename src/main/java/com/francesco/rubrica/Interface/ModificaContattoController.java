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
import com.francesco.rubrica.Data.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import static com.francesco.rubrica.Data.Contatto.isValidEmail;
import static com.francesco.rubrica.Data.Contatto.isValidPhoneNumber;


/**
 * @class ModificaContattoController
 * @brief Classe FXML Controller per la gestione della modifica dei contatti.
 * @invariant Tutti i campi annotati con `@FXML` devono essere inizializzati correttamente.
 * @invariant Il contatto "Contatto" non deve essere non null e sincronizzato con lo stato della rubrica.
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
    private TextField addressField;

    /**
     * @brief Pulsante per salvare le modifiche apportate al contatto.
     */
    @FXML
    private Button modifyButton;

    /**
     * @brief Pulsante per annullare la modifica di un contatto.
     */
    @FXML
    private Button delButton;

    /**
     * @brief Rappresenta il contatto che viene modificato.
     * Questa variabile memorizza l'oggetto `Contatto` corrente che è stato selezionato
     * dall'utente per essere modificato. Viene utilizzata per popolare i campi di input
     * con i dati esistenti del contatto, e per salvarne i nuovi dati una volta completata
     * la modifica.
     * @invariant `contatto` non deve essere null quando viene utilizzato, altrimenti non sarà possibile
     * salvare le modifiche.
     */
    private Contatto contatto;


    /**
     * @brief Inizializza il Controller.
     * @param url URL per l'inizializzazione del Controller.
     * @param rb ResourceBundle per la localizzazione.
     * @invariant Dopo l'inizializzazione, tutti i campi FXML devono essere non null.
     * Questo metodo viene chiamato automaticamente per inizializzare i componenti
     * FXML al caricamento della scena.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * @brief Imposta il contatto da modificare nei campi di input.
     * @param contatto Il contatto da modificare.
     * @post I campi di input vengono popolati con i dati del contatto selezionato.
     */
    public void setContatto(Contatto contatto) {
        this.contatto = contatto;
        nameField.setText(contatto.getNome());
        surnameField.setText(contatto.getCognome());
        birthdayField.setValue(contatto.getCompleanno());
        companyField.setText(contatto.getSocietà());
        numberField1.setText(contatto.getTelefono1());
        numberField2.setText(contatto.getTelefono2());
        numberField3.setText(contatto.getTelefono3());
        emailField1.setText(contatto.getEmail1());
        emailField2.setText(contatto.getEmail2());
        emailField3.setText(contatto.getEmail3());
        addressField.setText(contatto.getIndirizzo());
    }


    /**
     * @brief Annulla la modifica del contatto.
     * @param event L'evento che ha scatenato l'azione(Il tasto "annulla").
     *  @pre L'utente deve aver eseguito l'operazione di modifica.
     * @post L'utente torna alla visualizzazione precedente senza salvare le modifiche apportate.
     * Metodo che gestisce la logica per annullare le modifiche apportate ai dettagli
     * di un contatto e torna alla visualizzazione precedente.
     */
    @FXML
    public void annulla(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/francesco/rubrica/VisualizzaSingoloContattoController.fxml"));
            Parent root = loader.load();

            Scene currentscene = ((javafx.scene.Node) event.getSource()).getScene();
            currentscene.setRoot(root);

            VisualizzaSingoloContattoController controller = loader.getController();
            controller.setContatto(contatto);
        } catch (IOException e) {
           System.out.println("Impossibile annullare l'operazione corrente");
        }
    }

    /**
     * @brief Salva le modifiche apportate al contatto.
     * @param event L'evento che ha scatenato l'azione(Il tasto "Salva Modifiche").
     * @pre  L'utente seleziona un contatto nella rubrica, clicca il tasto modifica e visualizza le informazioni del contatto.
     * @post Il contatto modificato è salvato nella rubrica e la lista grafica viene aggiornata.
     * Metodo che gestisce la logica per salvare le modifiche apportate ai dettagli
     * di un contatto esistente.
     * @invariant Dopo l'esecuzione, i campi grafici e la rubrica devono essere sincronizzati.
     * @see Rubrica#modificaContatto(Contatto vecchio,Contatto nuovocontatto)
     */
    @FXML
    private void modificaContatto(ActionEvent event) {
        if (contatto == null) {
            System.out.println("Nessun contatto selezionato per la modifica.");
            return;
        }

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
        Contatto nuovocontatto= new Contatto(
                nameField.getText().trim(),
                surnameField.getText().trim(),
                numberField1.getText().trim(),
                numberField2.getText().trim(),
                numberField3.getText().trim(),
                emailField1.getText().trim(),
                emailField2.getText().trim(),
                emailField3.getText().trim(),
                companyField.getText().trim(),
                addressField.getText().trim(),
                birthdayField.getValue()
        );
        if (App.getRubricaCondivisa() != null) {
                  App.getRubricaCondivisa().modificaContatto(contatto, nuovocontatto);
              } else {
                  System.out.println("Rubrica condivisa non trovata.");
              }

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/francesco/rubrica/VisualizzaSingoloContattoController.fxml"));
            Parent root = loader.load();
            Scene currentscene = ((javafx.scene.Node) event.getSource()).getScene();
            currentscene.setRoot(root);

            VisualizzaSingoloContattoController controller = loader.getController();
            controller.setContatto(nuovocontatto);
        } catch (IOException e) {
           System.out.println("Impossibile tornare alla interfaccia VisualizzaSingoloContatto.");
        }
    }
}
