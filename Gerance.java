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
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
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
public class Gerance implements Initializable {

     @FXML
    private TextField nom;

    @FXML
    private TextField source;

    @FXML
    private TextField des;

    @FXML
    private TextField prix;

    @FXML
    private TextField depart;

    @FXML
    private TextField arrive;

    @FXML
    private DatePicker date;
    @FXML
    private TableView<ajout_tabletrain> table;

    @FXML
    private TableColumn<ajout_tabletrain, String> nom1;

    @FXML
    private TableColumn<ajout_tabletrain, String> source1;

    @FXML
    private TableColumn<ajout_tabletrain, String> des1;

    @FXML
    private TableColumn<ajout_tabletrain, Integer> prix1;

    @FXML
    private TableColumn<ajout_tabletrain, Time> depart1;

    @FXML
    private TableColumn<ajout_tabletrain, Time> arrive1;

    @FXML
    private TableColumn<ajout_tabletrain, Time> date1;

      @Override
    public void initialize(URL url, ResourceBundle rb) {
        nom1.setCellValueFactory(new PropertyValueFactory<>("nom1"));
        source1.setCellValueFactory(new PropertyValueFactory<>("source1"));
        des1.setCellValueFactory(new PropertyValueFactory<>("des1"));
        prix1.setCellValueFactory(new PropertyValueFactory<>("prix1"));
        depart1.setCellValueFactory(new PropertyValueFactory<>("depart1"));
        arrive1.setCellValueFactory(new PropertyValueFactory<>("arrive1"));
        date1.setCellValueFactory(new PropertyValueFactory<>("date1"));

    }  
    @FXML
    void ajout_train(ActionEvent event) {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        try {
            String name = nom.getText();
            String start = source.getText();
            String end = des.getText();
            String price = prix.getText();
            String departure = depart.getText();
            String arrival = arrive.getText();
            //String tplace = totalplace.getText();
            String dat = ((LocalDate)this.date.getValue()).format(DateTimeFormatter.ISO_LOCAL_DATE);
            PreparedStatement ps =connection.prepareStatement("Insert into train values('"+name+"','"+start+"','"+end+"','"+price+"','"+departure+"','"+arrival+"','"+dat+"')");

            int count =ps.executeUpdate();
            if (count > 0){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Enregistré!");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){


                    try {
                        Parent parent = FXMLLoader.load(getClass().getResource("gerance.fxml"));
                        Scene scene = new Scene(parent);
                        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
                        window.setScene(scene);
                        window.show();


                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    
    @FXML
    void voir_trains(ActionEvent event) {
           ObservableList<ajout_tabletrain>  list = FXCollections.observableArrayList();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        try {
            PreparedStatement ps =connection.prepareStatement("select * from train");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                 list.add(new ajout_tabletrain(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getTime(5),rs.getTime(6),rs.getString(7)));
                 table.setItems(list);

            }
        } catch (SQLException t) {
            t.printStackTrace();
        }

    }
    
    @FXML
    void supprimer_train(ActionEvent event) {
        table.setOnMouseClicked(e->{
            ajout_tabletrain service = table.getItems().get(table.getSelectionModel().getSelectedIndex());
            System.out.println(service);
            String no=service.getNom1();
            String source=service.getSource1();
            String des=service.getDes1();
            int price=service.getPrix1();
            Time depart=service.getDepart1();
            Time arrive=service.getArrive1();
            String date=service.getDate1();
             ConnectionClass connectionClass = new ConnectionClass();
             Connection connection = connectionClass.getConnection();
              try {
         
            PreparedStatement ps =connection.prepareStatement("delete FROM train WHERE nom_train='"+no+"' and source='"+source+"'"
                    + " and destination='"+des+"' and prix='"+price+"'");
            int count =ps.executeUpdate();
            if (count > 0){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("suppression");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){


                    try {
                        Parent parent = FXMLLoader.load(getClass().getResource("gerance.fxml"));
                        Scene scene = new Scene(parent);
                        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
                        window.setScene(scene);
                        window.show();


                    } catch (IOException er) {
                        er.printStackTrace();
                    }


                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

             
             
        });

        
    }
                
                
    @FXML
    void annuler(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("vous etes sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){


            try {
                Parent parent = FXMLLoader.load(getClass().getResource("gerance.fxml"));
                Scene scene = new Scene(parent);
                Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
        @FXML
    void retour(MouseEvent event) {
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
      
    
}
