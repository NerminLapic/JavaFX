package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Ugovor;


/**
 *
 * @author Nermin
 */
public class UgovorController implements Initializable {
    
    @FXML
    private TextField ime;
    @FXML
    private TextField prezime;
    @FXML
    private TextField adresa;
    @FXML
    private ComboBox brzina;
    @FXML
    private ComboBox  protok;
    
    @FXML 
    private ToggleGroup toggleGroup;
    
    @FXML 
    private Button btnSnimi;
    
    @FXML
    private TableView<Ugovor> tableView;
    
    @FXML
    private TableColumn<Ugovor,Integer> idColumn;
    @FXML
    private TableColumn<Ugovor,String> imeColumn;
    @FXML
    private TableColumn<Ugovor,String> prezimeColumn;
    @FXML
    private TableColumn<Ugovor,String> adresaColumn;
    @FXML
    private TableColumn<Ugovor,String> brzinaColumn;
    @FXML
    private TableColumn<Ugovor,String> protokColumn;
    @FXML
    private TableColumn<Ugovor,String> trajanjeColumn;
    
    Ugovor ugovor;
    
    public UgovorController(){
        
    }
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Izlistaj();
        } catch (SQLException ex) {
            Logger.getLogger(UgovorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ugovor=new Ugovor();
        
        ime.textProperty().bindBidirectional(ugovor.imeProperty());
        prezime.textProperty().bindBidirectional(ugovor.prezimeProperty());
        adresa.textProperty().bindBidirectional(ugovor.adresaProperty());
        
        brzina.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        @Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
    
        ugovor.brzinaProperty().set(newValue);
        }  
      
        });
        

        protok.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        @Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
    
          ugovor.protokProperty().set(newValue);
        }  
      
        });
     
        
    toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
    {
    @Override
    public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1)
        {
            
       RadioButton chk = (RadioButton)t1.getToggleGroup().getSelectedToggle(); 
       ugovor.setTrajanjeUgovora(chk.getText());
        }
    
    });
    
    }
   
    @FXML 
    public void clearForm(){
        ime.clear();
        prezime.clear();
        
    }
            
    @FXML
    private void Snimi() throws SQLException{
    
        if(ugovor.isValid()){
          
            Baza.snimiUgovor(ugovor);
            Izlistaj();
    
        } 
        else{
            StringBuilder errMsgs=new StringBuilder();
            ArrayList<String> errList=ugovor.errorProperty().get();
            for(String error:errList){
                errMsgs.append(error);
            }
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ugovor ne može biti snimljen");
            alert.setHeaderText(null);
            alert.setContentText(errMsgs.toString());
            alert.showAndWait();
            errList.clear();
        }
    }
    
    private void Izlistaj() throws SQLException{
       ObservableList listaUgovora=Baza.sviUgovori();
       
        idColumn.setCellValueFactory(new PropertyValueFactory<Ugovor,Integer>("idUgovora"));
        imeColumn.setCellValueFactory(new PropertyValueFactory<Ugovor,String>("ime"));
        prezimeColumn.setCellValueFactory(new PropertyValueFactory<Ugovor,String>("prezime"));
        adresaColumn.setCellValueFactory(new PropertyValueFactory<Ugovor,String>("adresa"));
        brzinaColumn.setCellValueFactory(new PropertyValueFactory<Ugovor,String>("brzina"));
        protokColumn.setCellValueFactory(new PropertyValueFactory<Ugovor,String>("protok"));
        trajanjeColumn.setCellValueFactory(new PropertyValueFactory<Ugovor,String>("trajanjeUgovora"));
        
        
        tableView.setItems(listaUgovora);  
     
            
        
    }
    
    public void Brisi() throws SQLException{
        if(tableView.getSelectionModel().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ugovor ne može biti izbrisan");
            alert.setHeaderText(null);
            alert.setContentText("Morate selektovati ugovor koji želite izbrisati!");
            alert.showAndWait();
            
        }
        else{
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Upozorenje");
        alert.setHeaderText(null);
        alert.setContentText("Ugovor će biti trajno obrisan!");
        
        Optional<ButtonType> rezultat = alert.showAndWait();
        if(rezultat.get()==ButtonType.OK){
        Integer id =tableView.getSelectionModel().getSelectedItem().getIdUgovora();
        Baza.brisiUgovor(id);
        }
        Izlistaj();
        }
      
    }
}
