/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication14;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafxapplication14.Connection.ConnectionClass;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Archive implements Initializable {

        @FXML
    private TableView<voirvoyages_user> table;

    @FXML
    private TableColumn<?, ?> nom;

    @FXML
    private TableColumn<?, ?> source;

    @FXML
    private TableColumn<?, ?> destination;

    @FXML
    private TableColumn<?, ?> nom_train;

    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> temps_depart;

    @FXML
    private TableColumn<?, ?> temps_arrive;

    @FXML
    private TableColumn<?, ?> places;

    @FXML
    private TableColumn<?, ?> total_prix;
    
    @FXML
    private TextField name;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initColonne();
        //load();
    }   
    
    private void initColonne(){
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        source.setCellValueFactory(new PropertyValueFactory<>("source"));
        destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        nom_train.setCellValueFactory(new PropertyValueFactory<>("nom_train"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        temps_depart.setCellValueFactory(new PropertyValueFactory<>("temps_depart"));
        temps_arrive.setCellValueFactory(new PropertyValueFactory<>("temps_arrive"));
        places.setCellValueFactory(new PropertyValueFactory<>("places"));
        total_prix.setCellValueFactory(new PropertyValueFactory<>("total_prix"));
    }
    /*
    public void load(){
        ObservableList<voirvoyages_user> list12 = FXCollections.observableArrayList();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        PreparedStatement pst;
        try {
            pst=connection.prepareStatement("Select * FROM voyages ");
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                list12.add(new voirvoyages_user(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)));

                table.setItems(list12);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
*/
        @FXML
    public void ok(ActionEvent event) {
        String names=name.getText();
         ObservableList<voirvoyages_user> list12 = FXCollections.observableArrayList();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        PreparedStatement pst;
        try {
            pst=connection.prepareStatement("Select * FROM voyages where nom='"+names+"'");
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                list12.add(new voirvoyages_user(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getTime(6),
                        resultSet.getTime(7),
                        resultSet.getString(8),
                        resultSet.getString(9)));

                table.setItems(list12);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        

    }
    
    @FXML
    void retour_du_menu(MouseEvent event) {
                  try {
            Parent parent = FXMLLoader.load(getClass().getResource("gestion_ticket.fxml"));
            Scene scene = new Scene(parent);
            Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
