/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import data.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lucac
 */
public class VisualizzaSingoloContattoController implements Initializable {

    @FXML
    private Label nameContent;
    @FXML
    private Label surnameContent;
    @FXML
    private Label birthdayContent;
    @FXML
    private Label companyContent;
    @FXML
    private Label numberContent1;
    @FXML
    private Label numberContent2;
    @FXML
    private Label numberContent3;
    @FXML
    private Label emailContent1;
    @FXML
    private Label emailContent2;
    @FXML
    private Label emailContent3;
    @FXML
    private Label adressContent;
    @FXML
    private Button modifyButton;
    @FXML
    private Button deleteButton;
    @FXML
    private ObservableList<Contatto> Contacts;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    public void displayModificaContatto(){
        
    }
     @FXML
    public void eliminaContatto(){
        
    }
     @FXML
    public void visualizzaContatto(){
        
    }
     @FXML
    public void annulla(){
        
    }
}
