/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication14;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafxapplication14.Connection.ConnectionClass;

/**
 * FXML Controller class
 *
 * @author HP
 */

public class admin extends utilisateur implements Initializable {
    
   public admin(){
    super();
   }

    @FXML
    public void retour(MouseEvent event) {
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
    
    public void connexion_admin(ActionEvent event) throws IOException {
        String username = text.getText();
        String pass = password.getText();
        if (username.equals("") && pass.equals("")) {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Invalid username ou password");

            a.show();
        } else {
            try {
                ConnectionClass connectionClass = new ConnectionClass();
                Connection connection = connectionClass.getConnection();
                PreparedStatement pst = connection.prepareStatement("select * from adminstrateur where prenom=? and password=?");
                pst.setString(1, username);
                pst.setString(2, pass);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {


                    Parent parent = FXMLLoader.load(getClass().getResource("gerance.fxml"));
                    Scene scene = new Scene(parent);
                    Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                    window.setMaximized(false);

                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("Invalid username ou password");
                    alert.show();
                }

            } catch (SQLException | IOException ex) {
                Logger.getLogger(utilisateur.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        System.out.println("heitage");
        

    }
     @FXML
    void mesvoyages(ActionEvent event) {

    }
    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        super.initialize(url, rb);
    }    
    
}
