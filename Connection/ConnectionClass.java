/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication14.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class ConnectionClass {
    public Connection connection;
    public Connection getConnection()
    {
        String dbName ="gestion_train";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,username,password);

        } catch (SQLException e) {
            throw new RuntimeException("database non connecter", e);
        }
        catch(ClassNotFoundException e) {
            System.out.println("Couldn't find tfo");
        }
        return connection;
    }
}

    

