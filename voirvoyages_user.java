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
public class voirvoyages_user {
    private String nom;
    private String source;
    private String destination;
    private String nom_train;
    private String date;
    private Time temps_depart;
    private Time temps_arrive;
    private String places;
    private String total_prix;

    public voirvoyages_user(String nom, String source, String destination, String nom_train, String date,Time temps_depart, Time temps_arrive, String places, String total_prix) {
        this.nom = nom;
        this.source = source;
        this.destination = destination;
        this.nom_train = nom_train;
        this.date = date;
        this.temps_depart = temps_depart;
        this.temps_arrive = temps_arrive;
        this.places = places;
        this.total_prix = total_prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getNom_train() {
        return nom_train;
    }

    public void setNom_train(String nom_train) {
        this.nom_train = nom_train;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public String getTotal_prix() {
        return total_prix;
    }

    public void setTotal_prix(String total_prix) {
        this.total_prix = total_prix;
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
    
    
}
