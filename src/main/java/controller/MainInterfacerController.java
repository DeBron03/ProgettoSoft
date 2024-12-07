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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lucac
 */
public class MainInterfacerController implements Initializable {
    private Rubrica contatti=new Rubrica();
    
    @FXML
    private TextField researchField;
    @FXML
   
    private Button addContact;
    @FXML
    private Button exportContact;
    @FXML
     private Button importContact;
    @FXML
    private TableView<Contatto> rubrica;
    @FXML
    private TableColumn<Contatto, String> nameClm;
    @FXML
    private TableColumn<Contatto, String> surnameClm;
    @FXML
    private ObservableList<Contatto> Contacts;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    } 
    @FXML
     public void esportaContatto(){
        
    }
     @FXML
    public void importaContatto(){
        
    }
    @FXML
    public void mostraRubrica(){
        
    }
    @FXML
    public void displayAggiungiContatto(){
        
    }
    @FXML
    public void displayVisualizzaSingoloContatto(){
        
    }
    @FXML
    public void ricercaContatto(){
        
    }
}
