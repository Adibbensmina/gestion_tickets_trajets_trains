/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication14;

import java.sql.Time;

/**
 *
 * @author HP
 */
public class view_voyages {
     public view_voyages(String nom_train, String source, String destination, Integer prix, Time temps_depart, Time temps_arrive,String date) {
        this.nom_train = nom_train;
        this.source = source;
        this.destination = destination;
        this.prix = prix;
        this.temps_depart = temps_depart;
        this.temps_arrive = temps_arrive;
        this.date = date;

    }

    public String getNom_train() {
        return nom_train;
    }

    public void setNom_train(String nom_train) {
        this.nom_train = nom_train;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Time getTemps_depart() {
        return temps_depart;
    }

    public void setTemps_depart(Time temps_depart) {
        this.temps_depart = temps_depart;
    }

    public Time getTemps_arrive() {
        return temps_arrive;
    }

    public void setTemps_arrive(Time temps_arrivee) {
        this.temps_arrive = temps_arrivee;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

  

    private String nom_train;
    private String source;
    private String destination;
    private Integer prix;
    private Time temps_depart;
    private Time temps_arrive;
   private String date;
            
            
           
    
    
}
