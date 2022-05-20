/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication14;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafxapplication14.Gestion_ticketController;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class InscriptionController extends Gestion_ticketController implements Initializable {
    
    @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXPasswordField pass;
    
    @FXML
    private AnchorPane inscription;

    /**
     * Initializes the controller class.
     */
     @FXML
    void handleclose(MouseEvent event) {
        System.exit(0);

    }
    
    @FXML
    public void inscription(MouseEvent event) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");  // MySQL database connection
       String nomo = nom.getText();
       String prenomo = prenom.getText();   
       String emailo=email.getText();
       String passo =pass.getText();
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_train?" + "user=root&password=");
       String sql4="INSERT INTO utilisateurs(nom,prenom,email,password ) values ( '"+nomo+"' , '"+prenomo+"' ,'"+emailo+"' ,'"+passo+"')";
        if (nomo.equals("") && prenomo.equals("") && emailo.equals("") && passo.equals("")) {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("veuillez remplir le formulaire");

            a.show();
        } else{
       try {
	PreparedStatement pst=conn.prepareStatement(sql4);
	pst.executeUpdate();
	System.out.println("oui");
           try {
            Parent parent = FXMLLoader.load(getClass().getResource("gestion_ticket.fxml"));
            Scene scene = new Scene(parent);
            Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
            static_label.setText(prenom.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
	} catch (SQLException e) {
	e.printStackTrace();
	}
        }
       

    }
      @FXML
    public void retour_du_menu(MouseEvent event) {
          try {
            Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(parent);
            Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    @FXML
    void back(ActionEvent event) {
         try {
            Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(parent);
            Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nom.setStyle("-fx-text-inner-color:white;");
        prenom.setStyle("-fx-text-inner-color:white;");
        email.setStyle("-fx-text-inner-color:white;");
        pass.setStyle("-fx-text-inner-color:white;");
        
    }    
    
}
