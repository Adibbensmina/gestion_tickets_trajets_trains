/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication14;

import static java.awt.Color.yellow;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import static java.time.LocalDate.from;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Optional;
import java.util.ResourceBundle;
import javafxapplication14.Connection.ConnectionClass;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Gestion_ticketController  implements Initializable {
    /*
    public Gestion_ticketController()
    {
        super();

    }
    */
    boolean bta1,bta2,bta3,bta4,btb1,btb2,btb3,btb4,btc1,btc2,btc3,btc4,btd1,btd2,btd3,btd4,bte1,bte2,bte3,bte4;
    String x;
    static String farex;
    
    String yellow = "-fx-background-color:#ffb805";
    String green = "-fx-background-color:#207811";
    Boolean count;
    int seatCounta=0,seatCountb=0,seatCountc=0,seatCountd=0,seatCounte=0,seatCountf=0,seatCountg=0,seatCounth=0,seatCounti=0,
            seatCountj=0,seatCountk=0,seatCountl=0,seatCountm=0,seatCountn=0,seatCounto=0,seatCountp=0;
    ArrayList<Integer> list =  new ArrayList<Integer>();
    @FXML
    private ComboBox depart;

    @FXML
    private ComboBox arrivee;

    @FXML
    private DatePicker date_voyage;

    @FXML
    private Button D4;

    @FXML
    private Button D3;

    @FXML
    private Button D2;

    @FXML
    private Button D1;
    
    @FXML
    private Button C2;
    @FXML
    private Button C4;
        @FXML
    private Button E4;

    @FXML
    private Button E2;

    @FXML
    private Button E3;

    @FXML
    private Button E1;

    @FXML
    private Button C3;
    
    @FXML
    private Button a1;

    @FXML
    private Button a2;

    @FXML
    private Button a4;

    @FXML
    private Button a3;

    @FXML
    private Button C1;

    @FXML
    private Button B1;

    @FXML
    private Button B4;

    @FXML
    private Button B3;

    @FXML
    private Button B2;

      @FXML
    private Button rese;
    
        @FXML
    private Button fac;
 
    
    @FXML
    private TextField txtseat;
    
    @FXML
    private TableView<view_voyages> tableview;

     @FXML
    private TableColumn<view_voyages, String> nom_train;

    @FXML
    private TableColumn<view_voyages, Integer> prix;

    @FXML
    private TableColumn<view_voyages, Integer> temps_depart;

    @FXML
    private TableColumn<view_voyages, Integer> temps_arrive;
    
        @FXML
    private Label sourcelabel;

    @FXML
    private Label dlabel;

    @FXML
    private Label serlabel;

    @FXML
    private Label datelabel;

    @FXML
    private Label totalprix;
    
    @FXML
    private Label price;
    
    @FXML
    private TextField txtnom;
    
    @FXML
    private Label temps_departx;

    @FXML
    private Label temps_arrivex;
    @FXML
    private Label labettext;
    @FXML
    private Button reset;
    
    public static Label static_label;
    
    
    /*
    public void labet()
   {
      labettext.setText(super.getTextoo());
   }

   */
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        static_label=labettext;
        //labet();
        connect();
        setcellvalue();
        nom_train.setCellValueFactory(new PropertyValueFactory<>("nom_train"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        temps_depart.setCellValueFactory(new PropertyValueFactory<>("temps_depart"));
        temps_arrive.setCellValueFactory(new PropertyValueFactory<>("temps_arrive"));

        
      
    }
        public void s(String st){
        this.x=st;
    }
        public void fare(String f){this.farex=f;}
    
    
        public void connect() {
            /*
        Button[] bta = {bt1,bt2,bt3,bt4};
        for (int i = 0; i < bta.length; i++) {
            System.out.println(bta[i]);
        }
            */
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
         ObservableList<Object> data = FXCollections.observableArrayList();
        try {

            PreparedStatement pst = connection.prepareStatement("select * from train ");
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                depart.getItems().addAll(resultSet.getString("source"));
                arrivee.getItems().addAll(resultSet.getString("destination"));

            }




        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void recherche_train(MouseEvent event) {
        loaddata();
        //labet();
        
    }
     public void loaddata() {

        ObservableList<view_voyages> data = FXCollections.observableArrayList();
        String source = depart.getSelectionModel().getSelectedItem().toString();
        String destination = arrivee.getSelectionModel().getSelectedItem().toString();
        String date = ((LocalDate)this.date_voyage.getValue()).format(DateTimeFormatter.ISO_LOCAL_DATE);
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        PreparedStatement pst;
        try {
            pst = connection.prepareStatement("select *  from train where source ='"+source+"' and destination = '"+destination+"'and date = '"+date+"' ");
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
            data.add(new view_voyages(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getInt(4),
                rs.getTime(5),
                rs.getTime(6),
                rs.getString(7)));

               tableview.setItems(data);


            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
     
     
     
     
     public void setcellvalue(){

        String service1 = x;
        tableview.setOnMouseClicked(e-> {


            view_voyages service = tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
            sourcelabel.setText(service.getSource());
            serlabel.setText(service.getNom_train());
            dlabel.setText(service.getDestination());
            temps_departx.setText(String.valueOf(service.getTemps_depart()));
            temps_arrivex.setText(String.valueOf(service. getTemps_arrive()));
            price.setText(String.valueOf(service.getPrix()));
            datelabel.setText(String.valueOf(service.getDate()));
            String srvc = service.getNom_train();
            s(srvc);





            ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            PreparedStatement pst;
            
            try {
                pst=connection.prepareStatement("SELECT count FROM places");

                ResultSet resultSet = pst.executeQuery();


                while (resultSet.next()){
                    list.add(resultSet.getInt(1));


                }
                if(list.get(0)==1){
                    a1.setStyle("-fx-background-color:red");
                }
               if(list.get(1)==1){
                    a2.setStyle("-fx-background-color:red");

                }
                if(list.get(2)==1){
                    a3.setStyle("-fx-background-color:red");
                }
                if(list.get(3)==1){
                    a4.setStyle("-fx-background-color:red");

                }
                if(list.get(4)==1){
                    B1.setStyle("-fx-background-color:red");
                }

                if(list.get(5)==1){
                    B2.setStyle("-fx-background-color:red");
                }
                if(list.get(6)==1){
                    B3.setStyle("-fx-background-color:red");

                }
                if(list.get(7)==1){
                    B4.setStyle("-fx-background-color:red");
                }
                if(list.get(8)==1){
                    C1.setStyle("-fx-background-color:red");
                }
                if(list.get(9)==1){
                    C2.setStyle("-fx-background-color:red");
                }
                if(list.get(9)==1){
                    C3.setStyle("-fx-background-color:red");
                }
                if(list.get(9)==1){
                    C4.setStyle("-fx-background-color:red");
                }
              

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }





        });

     }
     
         @FXML
    public void A1(MouseEvent event) throws SQLException {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("veuiller choisir votre train!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='A1'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Oups! La place est déjà réservée. Sélectionnez une autre");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    a1.setOnAction(e -> {
                        bta1 = true;
                        seatCounta = 1;
                        a1.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }
                 }
            catch (SQLException e) {
                e.printStackTrace();
            }

    }
    }

    @FXML
    public void A2(MouseEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("veuiller choisir votre train!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='A2'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Oups! La place est déjà réservée. Sélectionnez une autre");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    a2.setOnAction(e -> {
                        bta2 = true;
                        seatCountb = 1;
                        a2.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }
                 }
            catch (SQLException e) {
                e.printStackTrace();
            }


    }

    }

    @FXML
    void A3(MouseEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("veuiller choisir votre train!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='A3'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Oups! La place est déjà réservée. Sélectionnez une autre");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    a3.setOnAction(e -> {
                        bta3 = true;
                        seatCountc = 1;
                        a3.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }
                 }
            catch (SQLException e) {
                e.printStackTrace();
            }


    }

    }

    @FXML
    void A4(MouseEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("veuiller choisir votre train!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='A4'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Oups! La place est déjà réservée. Sélectionnez une autre");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    a4.setOnAction(e -> {
                        bta4 = true;
                        seatCountd = 1;
                        a4.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }
                 }
            catch (SQLException e) {
                e.printStackTrace();
            }


    }

    }

    @FXML
    void B1(MouseEvent event) {
         String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("veuiller choisir votre train!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='B1'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Oups! La place est déjà réservée. Sélectionnez une autre");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    B1.setOnAction(e -> {
                        btb1 = true;
                        seatCounte = 1;
                        B1.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }
                 }
            catch (SQLException e) {
                e.printStackTrace();
            }


    }

    }

    @FXML
    void B2(MouseEvent event) {

         String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("veuiller choisir votre train!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='B2'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Oups! La place est déjà réservée. Sélectionnez une autre");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    B2.setOnAction(e -> {
                        btb2 = true;
                        seatCountf = 1;
                        B2.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }
                 }
            catch (SQLException e) {
                e.printStackTrace();
            }


    }
    }

    @FXML
    void B3(MouseEvent event) {
         String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("veuiller choisir votre train!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='B3'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Oups! La place est déjà réservée. Sélectionnez une autre");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    B3.setOnAction(e -> {
                        btb3 = true;
                        seatCountg = 1;
                        B3.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }
                 }
            catch (SQLException e) {
                e.printStackTrace();
            }


    }

    }

    public void selection(){
         ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

            if(bta1){
                try {
            PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='A1'");
            ps.executeUpdate();}
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        if(bta2){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='A2'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(bta3){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='A3'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
            if(bta4){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='A4'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
          if(btc1){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='C1'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btc2){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='C2'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btc3){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='C3'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btc4){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='C4'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(btb1){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='B1'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btb2){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='B2'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btb3){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='B3'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btb4){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='B4'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btd1){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='D1'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btd2){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='D2'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btd3){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='D3'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btd4){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE places SET count = 1 WHERE nom_place='D4'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    void reserver(ActionEvent event) {
         ArrayList<Integer> list4 =  new ArrayList<Integer>();
        rese.setOnAction(e->{
            ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            PreparedStatement pst;
            try {
                pst=connection.prepareStatement("SELECT count FROM places");

                ResultSet resultSet = pst.executeQuery();


                while (resultSet.next()){
                    list4.add(resultSet.getInt(1));


                }}
                catch(Exception ei){
                    System.out.println(ei);
                }



            if((list4.get(0)==1 && bta1)
                ||(list4.get(1)==1 && bta2)
                || (list4.get(2)==1 && bta3)
                ||(list4.get(3)==1 && bta4)
                ||(list4.get(4)==1 && btb1)
                ||(list4.get(5)==1 && btb2)
                ||(list4.get(6)==1 && btb3)
                ||(list4.get(7)==1 && btb4)
                ||(list4.get(8)==1 && btc1)
                ||(list4.get(9)==1 && btc2)
                ||(list4.get(10)==1 && btc3)
                ||(list4.get(11)==1 && btc4)
                ||(list4.get(12)==1 && btd1)
                ||(list4.get(13)==1 && btd2)
                ||(list4.get(14)==1 && btd3)
                ||(list4.get(15)==1 && btd4)
        ){Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Desole! la place est deja reserve");
            alert.showAndWait();}
        else{

            selection();


            view_voyages selectedrow = tableview.getSelectionModel().getSelectedItem();
            if (selectedrow == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("aucun train selectionner");
                alert.showAndWait();
            } else {
                setcellvalue();
                String name = txtnom.getText();
                String seatss = txtseat.getText();
                String date = datelabel.getText();
                String sourc = sourcelabel.getText();
                String des = dlabel.getText();
                String ser = serlabel.getText();
                String places = txtseat.getText();
                String far = price.getText();
                String tempsdepart=temps_departx.getText();
                String tempsarrive=temps_arrivex.getText();
                
                

                Statement statement = null;
                try {


                    int tot = Integer.parseInt(String.valueOf(far)) * Integer.parseInt(String.valueOf(places));
                    totalprix.setText(String.valueOf(tot));
                    String tfare = totalprix.getText();
                    fare(tfare);

                    statement = connection.createStatement();
                    int status = statement.executeUpdate("insert into voyages values('" + name + "','" + sourc + "','" + des + "','" + ser + "'," +
                            "'" + date + "','" + tempsdepart + "','" + tempsarrive + "','" + seatss + "','" + tfare + "')");
                    if (status > 0) {

                    } else {
                        Alert alert = new Alert(Alert.AlertType.NONE);
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setContentText("Invalid ");
                        alert.show();
                    }



                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }





            }}});

    }
    
    @FXML
    public void B4(MouseEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Selectionner un tain !");
            Optional<ButtonType> result = alert.showAndWait();

        }
        else{ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='B4'");
                ResultSet r = ps1.executeQuery();
                r.next() ;
                int s = r.getInt(1);
                if(s == 1){ Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();}
                else{
                    B4.setOnAction(e -> {
                        btb4 = true;
                        seatCounth = 1;
                        B4.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }

            }
            catch (SQLException e) {
                e.printStackTrace();}

        }

    }

    @FXML
    void C1(MouseEvent event) {
         String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("veuiller choisir votre train!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='C1'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Oups! La place est déjà réservée. Sélectionnez une autre");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    C1.setOnAction(e -> {
                        btc1 = true;
                        seatCounti = 1;
                        C1.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }
                 }
            catch (SQLException e) {
                e.printStackTrace();
            }


    }

    }

    @FXML
    void C2(MouseEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("veuiller choisir votre train!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='C2'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Oups! La place est déjà réservée. Sélectionnez une autre");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    C2.setOnAction(e -> {
                        btc2 = true;
                        seatCountj = 1;
                        C2.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }
                 }
            catch (SQLException e) {
                e.printStackTrace();
            }


    }

    }
     @FXML
    void C3(MouseEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("veuiller choisir votre train!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='C3'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Oups! La place est déjà réservée. Sélectionnez une autre");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    C3.setOnAction(e -> {
                        btc3 = true;
                        seatCountk = 1;
                        C3.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }
                 }
            catch (SQLException e) {
                e.printStackTrace();
            }
    }
    }

    @FXML
    void C4(MouseEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("veuiller choisir votre train!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='C4'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Oups! La place est déjà réservée. Sélectionnez une autre");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    C4.setOnAction(e -> {
                        btc4 = true;
                        seatCountl = 1;
                        C4.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }
                 }
            catch (SQLException e) {
                e.printStackTrace();
            }
    }

    }

    @FXML
    void D1(MouseEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("veuiller choisir votre train!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='D1'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Oups! La place est déjà réservée. Sélectionnez une autre");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    D1.setOnAction(e -> {
                        btd1 = true;
                        seatCountm = 1;
                        D1.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }
                 }
            catch (SQLException e) {
                e.printStackTrace();
            }


    }
    }

    @FXML
    void D2(MouseEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("veuiller choisir votre train!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='D2'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Oups! La place est déjà réservée. Sélectionnez une autre");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    D2.setOnAction(e -> {
                        btd2 = true;
                        seatCountn = 1;
                        D2.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }
                 }
            catch (SQLException e) {
                e.printStackTrace();
            }


    }


    }

    @FXML
    void D3(MouseEvent event) {
         String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("veuiller choisir votre train!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='D3'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Oups! La place est déjà réservée. Sélectionnez une autre");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    D3.setOnAction(e -> {
                        btd3 = true;
                        seatCounto = 1;
                        D3.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));

                    });
                }
                 }
            catch (SQLException e) {
                e.printStackTrace();
            }
    }


    }

    @FXML
    void D4(MouseEvent event) {
         String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("veuiller choisir votre train!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from places WHERE nom_place='D4'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("Oups! La place est déjà réservée. Sélectionnez une autre");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    D4.setOnAction(e -> {
                        btd4 = true;
                        seatCountp = 1;
                        D4.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }
                 }
            catch (SQLException e) {
                e.printStackTrace();
            }

    }


    }

    @FXML
    void E1(MouseEvent event) {
        

    }

    @FXML
    void E2(MouseEvent event) {

    }

    @FXML
    void E3(MouseEvent event) {

    }

    @FXML
    void E4(MouseEvent event) {

    }
/*
        @FXML
    public void facture(ActionEvent event) {
          
        
        fac.setOnAction(e->{
            ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            PreparedStatement pst;
            
            
            String places = txtseat.getText();
            String far = price.getText();
            int tot = Integer.parseInt(String.valueOf(far)) * Integer.parseInt(String.valueOf(places));
            totalprix.setText(String.valueOf(tot));
            //String tfare = totalfare.getText();
             //fare(tfare);

        });
    }
*/
    @FXML
    void reset(ActionEvent event) {
        Button[] bta = {a1,a2,a3,a4};
        Button[] btb={B1,B2,B3,B4};
        Button[] btc={C1,C2,C3,C4};
        Button[] btd={D1,D2,D3,D4};
        
        
        ArrayList<Integer> list2 = new ArrayList<>();
            reset.setOnAction(e -> {
            txtseat.setText("");
            
            for (int i = 0; i < bta.length; i++) {
            System.out.print(bta[i]);
            bta[i].setStyle(green);
             bta1 = false;
            seatCounta = 0;
             bta2 = false;
             seatCountb = 0;
             bta3 = false;
             seatCountc = 0;
              bta4 = false;
             seatCountd=0;
            } 
            for(int j=0;j<btb.length;j++)
            {
              btb[j].setStyle(green);
            btb1 = false;
            seatCounte = 0;
             btb2 = false;
             seatCountf = 0;
             btb3 = false;
             seatCountg = 0;
              btb4 = false;
             seatCounth=0;
            }
            for(int k=0;k<btc.length;k++)
            {
             btc[k].setStyle(green);
            btc1 = false;
            seatCounti = 0;
             btc2 = false;
             seatCountj = 0;
             btc3 = false;
             seatCountk = 0;
              btc4 = false;
             seatCountl=0;     
            }
            for(int n=0;n<btd.length;n++)
            {
             btd[n].setStyle(green);
            btd1 = false;
            seatCountm = 0;
             btd2 = false;
             seatCountn = 0;
             btd3 = false;
             seatCounto = 0;
              btd4 = false;
             seatCountp=0;     
            }

                       

        });

    }
        @FXML
    void Back(MouseEvent event) {
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
    void mesvoyages(ActionEvent event) {
            try {
            Parent parent = FXMLLoader.load(getClass().getResource("archive.fxml"));
            Scene scene = new Scene(parent);
            Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
            

    }
    
    @FXML
    void logout(ActionEvent event) {
         Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(parent);
            Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
           
   
}
