package com.francesco.rubrica.Main;

import com.francesco.rubrica.Data.Rubrica;
import com.francesco.rubrica.Interface.MainInterfaceController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @class App
 * @brief Classe principale dell'applicazione JavaFX che gestisce l'avvio e la navigazione tra le schermate.
 * <p>
 * Questa classe estende {@link javafx.application.Application} e gestisce l'avvio dell'applicazione JavaFX,
 * il caricamento delle interfacce utente tramite FXML e la navigazione tra diverse scene.
 * Inoltre, fornisce un'istanza condivisa della rubrica che può essere utilizzata in tutta l'applicazione.
 */
public class App extends Application {
    /**
     * @brief La scena principale dell'applicazione.
     * <p>
     * Variabile statica che rappresenta la scena attualmente visualizzata nell'applicazione.
     */
    private static Scene scene;
    /**
     * @brief L'istanza condivisa della rubrica.
     * <p>
     * Variabile statica che contiene l'istanza della rubrica, accessibile da tutte le schermate dell'applicazione.
     */
    private static Rubrica rubricaCondivisa;

    /**
     * @param stage Il {@link Stage} principale dell'applicazione.
     * @throws IOException Se c'è un errore durante il caricamento dell'FXML.
     *                     <p>
     *                     Questo metodo viene chiamato all'avvio dell'applicazione per caricare la schermata iniziale,
     *                     inizializzare l'istanza della rubrica e configurare la scena.
     * @brief Metodo di avvio dell'applicazione JavaFX.
     */
    @Override
    public void start(Stage stage) throws IOException {
        rubricaCondivisa = new Rubrica();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/francesco/rubrica/MainInterfaceController.fxml"));
        Parent root = fxmlLoader.load();
        MainInterfaceController mainController = fxmlLoader.getController();
        mainController.setRubrica(rubricaCondivisa);
        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @return L'istanza della rubrica.
     * Metodo che restituisce l'istanza condivisa della rubrica per permettere l'accesso ai dati dei contatti
     * in tutta l'applicazione.
     * @brief Ottiene l'istanza della rubrica condivisa.
     */
    public static Rubrica getRubricaCondivisa() {
        return rubricaCondivisa;
    }

    /**
     * @param args Argomenti passati alla linea di comando.
     * @brief Metodo principale che avvia l'applicazione.
     */
    public static void main(String[] args) {
        launch(args);
    }
}