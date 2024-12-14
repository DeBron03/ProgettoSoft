/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francesco.rubrica.Interface;

import java.net.URL;
import java.util.ResourceBundle;
import com.francesco.rubrica.Main.App;
import com.francesco.rubrica.Data.Contatto;
import com.francesco.rubrica.Data.Rubrica;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @class VisualizzaSingoloContattoController
 * @brief Classe FXML Controller per visualizzare i dettagli di un singolo contatto.
 * @invariant Il contatto selezionato deve essere sempre valido (non null e con dati consistenti).
 * @invariant Tutti i campi grafici (es. `nameContent`, `surnameContent`, ecc.) devono essere inizializzati correttamente.
 * @invariant La visualizzazione del contatto deve essere sincronizzata con lo stato della rubrica.
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
    private Label addressContent;

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
     * @brief Oggetto `Contatto` che contiene i dati del contatto selezionato.
     * @invariant `contatto` deve essere inizializzato prima di utilizzarlo nei metodi.
     */
    private Contatto contatto;

    /**
     * @brief Inizializza Controller.
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
     * @brief Imposta i dati del contatto da visualizzare.
     * @param contatto Il contatto da visualizzare.
     * @post I dettagli del contatto vengono visualizzati nei rispettivi campi.
     */
    public void setContatto(Contatto contatto) {
        this.contatto = contatto;
        nameContent.setText(contatto.getNome());
        surnameContent.setText(contatto.getCognome());
        birthdayContent.setText(contatto.getCompleanno() != null ? contatto.getCompleanno().toString() : "");
        companyContent.setText(contatto.getSocietà());
        numberContent1.setText(contatto.getTelefono1());
        numberContent2.setText(contatto.getTelefono2());
        numberContent3.setText(contatto.getTelefono3());
        emailContent1.setText(contatto.getEmail1());
        emailContent2.setText(contatto.getEmail2());
        emailContent3.setText(contatto.getEmail3());
        addressContent.setText(contatto.getIndirizzo());
    }
    /**
     * @brief Aggiorna i dettagli del contatto visualizzato.
     * @post I dettagli del contatto vengono aggiornati nei rispettivi campi.
     */
    public void aggiornaDatiContatto() {
        if (contatto != null) {
            nameContent.setText(contatto.getNome());
            surnameContent.setText(contatto.getCognome());
            birthdayContent.setText(contatto.getCompleanno() != null ? contatto.getCompleanno().toString() : "");
            companyContent.setText(contatto.getSocietà());
            numberContent1.setText(contatto.getTelefono1());
            numberContent2.setText(contatto.getTelefono2());
            numberContent3.setText(contatto.getTelefono3());
            emailContent1.setText(contatto.getEmail1());
            emailContent2.setText(contatto.getEmail2());
            emailContent3.setText(contatto.getEmail3());
            addressContent.setText(contatto.getIndirizzo());
        }
    }
    /**
     * @brief Chiude la finestra per tornare alla MainInterface.
     * @param event L'evento che ha scatenato l'azione(Il tasto "X").
     * @pre L'utente ha selezionato un contatto della rubrica.
     * @post Si chiude l'interfaccia "ModificaContattoController" per tornare alla"MainInterfaceController".
     * Metodo che permette all'utente di passare alla finestra principale
     * dal contatto attualmente visualizzato.
     * @throws IOException
     */
    @FXML
    private void displayMainInterface(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/francesco/rubrica/MainInterfaceController.fxml"));
            Parent root = loader.load();

            Scene currentscene = ((javafx.scene.Node) event.getSource()).getScene();
            currentscene.setRoot(root);

           MainInterfaceController mainController = loader.getController();
            mainController.setRubrica(App.getRubricaCondivisa());

        } catch (IOException e) {
            System.out.println("Impossibile tornare alla MainInterface");
        }
    }
    /**
     *
     * @brief Apre la finestra per modificare il contatto selezionato.
     * @param event L'evento che ha scatenato l'azione(Il tasto "Modifica").
     * @pre L'utente ha selezionato un contatto della rubrica.
     * @post Si apre l'interfaccia "ModificaContatto"
     * Metodo che permette all'utente di passare alla finestra di modifica
     * del contatto attualmente visualizzato.
     * @throws IOException
     */
    @FXML
    public void displayModificaContatto(ActionEvent event) throws IOException {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/francesco/rubrica/ModificaContattoController.fxml"));
        Parent root = loader.load();

        Scene currentScene = ((javafx.scene.Node) event.getSource()).getScene();
        currentScene.setRoot(root);
        ModificaContattoController controller = loader.getController();
        controller.setContatto(this.contatto);
        Stage stage = (Stage) currentScene.getWindow();
        stage.setOnHidden(e -> aggiornaDatiContatto());
        } catch (IOException e) {
            System.out.println("Impossibile aprire l'interfaccia ModificaContattoController");
        }
    }
    /**
     * @brief Elimina il contatto visualizzato.
     * @param event L'evento che ha scatenato l'azione(Il tasto "Elimina").
     * @pre L'utente ha selezionato un contatto dalla rubrica.
     * @post Il contatto viene rimosso dalla rubrica e la rubrica è aggiornata.
     * @see Rubrica#eliminaContatto(Contatto c).
     */
    @FXML
    public void eliminaContatto(ActionEvent event) {
        App.getRubricaCondivisa().eliminaContatto(contatto);
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/francesco/rubrica/MainInterfaceController.fxml"));
            Parent root = loader.load();

            Scene currentscene = ((javafx.scene.Node) event.getSource()).getScene();
            currentscene.setRoot(root);

            MainInterfaceController mainController = loader.getController();
            mainController.setRubrica(App.getRubricaCondivisa());

        } catch (IOException e) {
            System.out.println("Impossibile tornare alla MainInterface");
        }
    }

}
