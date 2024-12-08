/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 * @file Applicazione.java
 * @brief Classe principale per avviare l'applicazione JavaFX.
 *
 * La classe `Applicazione` estende `Application` e gestisce l'avvio
 * dell'interfaccia utente principale della rubrica.
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @class Applicazione
 * @brief Classe per avviare l'applicazione JavaFX.
 *
 * Questa classe inizializza e mostra la finestra principale dell'applicazione
 * utilizzando il file `MainInterface.Interface.fxml`.
 */
public class Applicazione extends Application {

    /**
     * @brief Metodo principale per inizializzare l'interfaccia grafica.
     * @param stage Il palco principale dell'applicazione.
     * @throws Exception Se si verifica un errore durante il caricamento della scena.
     * @invariant Il file FXML deve essere caricato correttamente e non deve essere null.
     * Questo metodo carica il file FXML e lo assegna a una scena da mostrare nel
     * palco principale.
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainInterface.Interface.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @brief Metodo principale per avviare l'applicazione.
     * @param args Gli argomenti della riga di comando.
     *
     * Questo metodo chiama `launch`, che avvia il ciclo di vita dell'applicazione JavaFX.
     */
    public static void main(String[] args) {
        launch(args);
    }
}