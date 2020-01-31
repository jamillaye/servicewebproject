/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Cell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Personne;
import service.CrudService;
import service.CrudService_Service;




/**
 * FXML Controller class
 *
 * @author jams9
 */
public class AccueilController  implements Initializable {
  
     CrudService c = new CrudService_Service().getCrudServicePort();
     int id=0;
    
    @FXML
    private AnchorPane btnAdd;
    
    @FXML
    private TableView<service.Personne> tablepersonne;
    @FXML
    private TableColumn<Personne, Integer> col_id;

    @FXML
    private TableColumn<Personne, String> col_nom;

    @FXML
    private TableColumn<Personne, String> col_prenom;
    
    @FXML
    private TableColumn<Personne, String> col_adresse;

    @FXML
    private TableColumn<Personne, String> col_tel;

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtPrenom;
    
    @FXML
    private TextField txtAdresse;

    @FXML
    private TextField txtTel;

    
    @FXML
    void add(ActionEvent event) throws Exception {
        
       String nom = txtNom.getText();
       String prenom = txtPrenom.getText();
       String adresse = txtAdresse.getText();
       String tel = txtTel.getText();
      
       c.add(nom, prenom,adresse,tel);
       charger();
       clear();
    } 
   
//    @FXML
//    void tablepersoneclick(MouseEvent event) {
//         if (event.getClickCount() == 2) //Checking double click
//         {
//              
//        }
//    }
    
    @FXML
    void delete(ActionEvent event) throws Exception {
        if(tablepersonne.getSelectionModel().getSelectedItem()!=null) {
    		Alert a =new Alert(Alert.AlertType.CONFIRMATION);
    		a.setTitle("Confirmation");
    		a.setContentText("Voulez vous vraiment Suprimer");
    		Optional<ButtonType> action = a.showAndWait();
    		      //System.out.println("ezzz"+tablepersonne.getSelectionModel().getSelectedItem().getId());
    		if(action.get() == ButtonType.OK){
                    c.delete(tablepersonne.getSelectionModel().getSelectedItem().getId());
                    charger();
                    clear();
                }
    		
    	}else {
    		      //System.out.println("nonn");
    	}
    }
    
     @FXML
    void tablepersoneclick(javafx.scene.input.MouseEvent event) {
          service .Personne p = tablepersonne.getSelectionModel().getSelectedItem();
                //System.out.println("tay"+p);
                txtNom.setText(p.getNom());
                txtPrenom.setText(p.getPrenom());
                txtAdresse.setText(p.getAdresse());
                txtTel.setText(p.getTel());
                id = p.getId();
                //btnAdd.setDisable(true);
    }
    
    @FXML
    void update(ActionEvent event) throws Exception {
        String nom = txtNom.getText();
        String prenom = txtPrenom.getText();
        String adresse = txtAdresse.getText();
        String tel = txtTel.getText();
        c.update(id, nom, prenom,adresse,tel);
        charger();
        clear();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             // TODO
             charger();
         } catch (Exception ex) {
             Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
         }
        col_id.setCellValueFactory(new PropertyValueFactory<Personne,Integer>("id"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<Personne,String>("prenom"));
	col_nom.setCellValueFactory(new PropertyValueFactory<Personne,String>("nom"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<Personne,String>("adresse"));
        col_tel.setCellValueFactory(new PropertyValueFactory<Personne,String>("tel"));
    }   
    
    

    
    public void charger() throws Exception  {
        List<service.Personne> liste = c.liste();
    	ObservableList<service.Personne> per = FXCollections.observableArrayList(liste);
    	tablepersonne.setItems(per);
    	System.out.println("bonjour"+per);
    }
    
    public void clear(){
        txtPrenom.setText("");
        txtNom.setText("");
        txtAdresse.setText("");
        txtTel.setText("");
    }
    
}
