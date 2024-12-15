/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francesco.rubrica.Interface;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import com.francesco.rubrica.Main.App;
import com.francesco.rubrica.Data.Contatto;
import com.francesco.rubrica.Data.Rubrica;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @class MainInterfaceController
 * @brief Controller per l'interfaccia principale della rubrica.
 * @invariant La rubrica "contatti" non deve mai essere null.
 * @invariant Tutti i campi annotati con @FXML devono essere inizializzati correttamente.
 * @invariant La TableView<Contatto> rubrica deve sempre riflettere lo stato corrente della rubrica.
 * Questa classe fornisce i metodi per interagire con la rubrica tramite
 * l'interfaccia grafica (JavaFX).
 */
public class MainInterfaceController implements Initializable {
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
     * @brief Istanza della rubrica che contiene i contatti.
     * @invariant Non deve mai essere null.
     */
    private Rubrica contatti;



    /**
     * @brief Inizializza il Controller dell'interfaccia.
     * @param url URL per l'inizializzazione del Controller.
     * @param rb ResourceBundle per la localizzazione.
     * @invariant Dopo l'inizializzazione, tutti i campi FXML devono essere non null.
     * Questo metodo viene chiamato automaticamente per inizializzare i componenti
     * FXML al caricamento della scena.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.getRubricaCondivisa().ordina(App.getRubricaCondivisa().getContatti());
        researchField.textProperty().addListener((observable, oldValue, newValue) -> rubrica.setItems(App.getRubricaCondivisa().ricercaContatto(newValue)));
        rubrica.setItems(FXCollections.observableArrayList(App.getRubricaCondivisa().getContatti()));
        nameClm.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
        surnameClm.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCognome()));
        setupDoppioClick();
    }

    /**
     * @brief Imposta la rubrica per il controller.
     * @param contatti Rubrica contenente i contatti.
     * @invariant Non deve mai essere null.
     */

    public void setRubrica(Rubrica contatti) {
        this.contatti = contatti;
    }

    /**
     * @brief Aggiorna la tabella dei contatti.
     * @post La tabella viene aggiornata con la lista corrente dei contatti.
     */
    private void aggiornaTabella() {
        rubrica.setItems(App.getRubricaCondivisa().getContatti());
        App.getRubricaCondivisa().ordina(App.getRubricaCondivisa().getContatti());
        rubrica.refresh();
    }

    /**
     * @brief Imposta un listener per il doppio clic nella tabella.
     * @post Si abilita la selezione di un contatto per visualizzarne i dettagli.
     */
    private void setupDoppioClick() {
        rubrica.setOnMouseClicked(new Doppioclick());
    }

    /**
     * @brief Esporta i contatti della rubrica.
     * @param event L'evento che ha scatenato l'azione(Il tasto "Esporta Contatto").
     * @pre La rubrica può essere sia vuota che occupata.
     * @post Viene generato un file esterno con i contatti esportati.
     * @see Rubrica#esportaContatto(String filename)
     */
    @FXML
    public void esportaContatto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            try {
                App.getRubricaCondivisa().esportaContatto(file.getAbsolutePath());
                System.out.println("Contatti esportati con successo nel file: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Errore durante l'esportazione del file.");
            }
        } else {
            System.out.println("Operazione di salvataggio annullata.");
        }
    }

    /**
     * @brief Importa i contatti da un file esterno.
     * @param event L'evento che ha scatenato l'azione.(Il tasto "Importa Contatto")
     * @pre L'utente ha un fle, supportato dall'app, contenente i contatti.
     * @post I contatti vengono importati correttamente e la rubrica viene aggiornata.
     * @see Rubrica#importaContatto(String filename)
     */
    @FXML
    public void importaContatto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try {
                contatti.importaContatto(file.getAbsolutePath());
                System.out.println("Contatti importati con successo dalla rubrica " + contatti.getContatti());
                aggiornaTabella();
            } catch (IOException e) {
                System.out.println("Errore durante l'importazione del file.");
            }
        } else {
            System.out.println("Operazione di importazione annullata.");
        }
    }
    /**
     * @brief Apre la finestra per aggiungere un nuovo contatto.
     * @param event L'evento che ha scatenato l'azione(Il tasto "+").
     * @pre L'utente ha selezionato "+" per aggiungere il contatto.
     * @post Si apre l'interfaccia per l'aggiunta di un contatto.
     * @see AggiuntaContattoController
     */
    @FXML
    public void displayAggiungiContatto(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/francesco/rubrica/AggiuntaContattoController.fxml"));
        Parent root = loader.load();
        Scene currentScene = ((javafx.scene.Node) event.getSource()).getScene();
        currentScene.setRoot(root);
        AggiuntaContattoController controller = loader.getController();
        controller.setRubrica(this.contatti);
        System.out.println("Hai premuto il pulsante per aggiungere un nuovo contatto.");
        Stage stage = (Stage) currentScene.getWindow();
        stage.setOnHidden(e -> aggiornaTabella());
    }

    /**
     * @brief Apre la finestra per visualizzare un contatto selezionato.
     * @pre L'utente ha selezionato un contatto nella rubrica.
     * @post Si apre l'interfaccia "VisualizzaSingoloContatto.Interface.fxml"
     * @see VisualizzaSingoloContattoController
     */
    private class Doppioclick implements javafx.event.EventHandler<javafx.scene.input.MouseEvent> {
        @Override
        public void handle(javafx.scene.input.MouseEvent event) {
            if (event.getClickCount() == 2) {
                Contatto contattoSelezionato = rubrica.getSelectionModel().getSelectedItem();
                System.out.println("Hai selezionato un contatto");
                if (contattoSelezionato != null) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/francesco/rubrica/VisualizzaSingoloContattoController.fxml"));
                        Parent root = loader.load();
                        Scene currentScene = ((javafx.scene.Node) event.getTarget()).getScene();
                        currentScene.setRoot(root);
                        System.out.println("Hai premuto il pulsante per visualizzare i dettagli di"+ " "+ contattoSelezionato.getNome() + " " + contattoSelezionato.getCognome() + ".");
                        VisualizzaSingoloContattoController controller = loader.getController();
                        controller.setContatto(contattoSelezionato);
                        Stage stage = (Stage) currentScene.getWindow();
                        stage.setOnHidden(e -> aggiornaTabella());

                    } catch (IOException e) {

                        System.out.println("Errore durante il caricamento della vista del singolo contatto.");
                    }
                } else {
                    System.out.println("Nessun contatto selezionato nella tabella.");
                }
            }
        }
    }
}

