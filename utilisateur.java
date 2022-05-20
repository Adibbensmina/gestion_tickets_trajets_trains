/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication14;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafxapplication14.Connection.ConnectionClass;

/**
 *
 * @author HP
 */
  




public class utilisateur extends Gestion_ticketController implements Initializable {
    @FXML
    protected AnchorPane loginPane;

    @FXML
    protected JFXTextField text;

   
    @FXML
    protected JFXPasswordField password;

    @FXML
    protected JFXButton co;

    @FXML
    private Label label1;
            
    public utilisateur(){
          System.out.print("aaa");
    }
  

    @FXML
    public void connecter(MouseEvent event) {
         String username = text.getText();
         String pass = password.getText();
        if (username.equals("") && pass.equals("")) {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Invalid username ou password");

            a.show();
        }
        
        else {
            try {
                ConnectionClass connectionClass = new ConnectionClass();
                Connection connection = connectionClass.getConnection();
                PreparedStatement pst = connection.prepareStatement("select * from utilisateurs where prenom=? and password=?");
                pst.setString(1, username);
                pst.setString(2, pass);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {


                    Parent parent = FXMLLoader.load(getClass().getResource("gestion_ticket.fxml"));
                    Scene scene = new Scene(parent);
                    Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                    window.setMaximized(false);
                    static_label.setText(text.getText());

                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("Invalid username or password");
                    alert.show();
                }

            } catch (SQLException | IOException ex) {
                Logger.getLogger(utilisateur.class.getName()).log(Level.SEVERE, null, ex);

            }
        }

    }

    @FXML
    void inscrire(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("inscription.fxml"));
            Scene scene = new Scene(parent);
            Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }
    @FXML
    public void admin_login(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("adminlogin.fxml"));
            Scene scene = new Scene(parent);
            Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getTextoo() {
        return text.getText();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //String user=text.getText();
        text.setStyle("-fx-text-inner-color:white;");
        password.setStyle("-fx-text-inner-color:white;");
    }  
    
 
}
