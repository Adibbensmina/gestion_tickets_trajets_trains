/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package javafxapplication14;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author HP
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        /*
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        //stage.handleclose(e -> Platform.exit());
        stage.show();
        */
         Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        stage.setTitle("gestion de ticket");
        stage.setScene(new Scene(root));
        stage.show();
        stage.setMaximized(false);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("hiii");
        launch(args);
    }
    
}
