/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.controller;

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
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @class MainInterfaceController
 * @brief Controller per l'interfaccia principale della rubrica.
 * @invariant La rubrica "contatti" non deve mai essere null.
 * @invariant Tutti i campi annotati con `@FXML` devono essere inizializzati correttamente.
 * @invariant La lista `Contacts` deve sempre riflettere lo stato corrente della rubrica.
 * Questa classe fornisce i metodi per interagire con la rubrica tramite
 * l'interfaccia grafica (JavaFX).
 */
public class MainInterfaceController implements Initializable {

    /**
     * @brief Istanza della rubrica che contiene i contatti.
     * @invariant Non deve mai essere null.
     */
    private Rubrica contatti = new Rubrica("Hal9000");

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
 * @brief Esporta i contatti della rubrica.
 * @param event L'evento che ha scatenato l'azione(Il tasto "esporta").
 * @pre Deve esserci almeno un contatto nella rubrica (`Contacts` non è vuota).
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
 * @post Si apre l'interfaccia "AggiuntaContattoController.Interface.fxml"
 * Metodo che cambia la scena per permettere l'aggiunta di un nuovo contatto.
 * Il parametro `event` può essere usato per gestire dinamicamente la transizione.
 * @see AggiuntaContattoController.
 */
@FXML
public void displayAggiungiContatto(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/progettoingeseguibile/AggiuntaContattoController.fxml"));
    Parent root = loader.load();
    Stage stage = new Stage();
    stage.setTitle("Aggiungi Contatto");
    stage.setScene(new Scene(root));
    stage.show();
}

/**
 * @brief Apre la finestra per visualizzare un contatto selezionato.
 * @param event L'evento che ha scatenato l'azione.
 * @pre L'utente ha selezionato un contatto nella rubrica.
 * @post Si apre l'interfaccia "VisualizzaSingoloContatto.Interface.fxml"
 * Metodo che cambia la scena per visualizzare i dettagli di un contatto.
 * Può essere utilizzato per navigare verso una vista dettagliata.
 * @see VisualizzaSingoloContattoController
 * 
 */
@FXML
public void displayVisualizzaSingoloContatto(ActionEvent event) throws IOException {
    Contatto contattoSelezionato = rubrica.getSelectionModel().getSelectedItem();
    if (contattoSelezionato == null) {
        System.out.println("Nessun contatto selezionato.");
        return;
    }
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/progettoingeseguibile/VisualizzaSingoloContattoController.fxml"));
    Parent root = loader.load();
    Stage stage = new Stage();
    stage.setTitle("Dettagli Contatto");
    stage.setScene(new Scene(root));
    stage.show();
}

/**
 * @brief Effettua una ricerca di contatti nella rubrica.
 * @param event L'evento che ha scatenato l'azione(Utente scrive nella barra di ricerca).
 * @pre L'utente clicca sulla barra di ricerca
 * @post La tabella mostra i contatti che corrispondono ai criteri di ricerca
 * Metodo che filtra i contatti visualizzati nella tabella in base al testo
 * inserito nel campo di ricerca. 
 * @see ricercaContatto(String s)
 */
@FXML
public void ricercaContatto(ActionEvent event) {
   
}
}
