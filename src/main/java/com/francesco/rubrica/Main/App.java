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
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private  static Rubrica rubricaCondivisa;

    @Override
    public void start(Stage stage) throws IOException {
        rubricaCondivisa = new Rubrica();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("MainInterfaceController.fxml"));
        Parent root = fxmlLoader.load();
        MainInterfaceController mainController = fxmlLoader.getController();
        mainController.setRubrica(rubricaCondivisa);

        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        return fxmlLoader.load();
    }

    /**
     * @return L'istanza della rubrica condivisa.
     */
    public  static Rubrica getRubricaCondivisa() {
        return rubricaCondivisa;
    }

    public static void main(String[] args) {
        launch(args);
    }
}