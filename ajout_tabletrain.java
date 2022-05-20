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
public class ajout_tabletrain {
    private String nom1;

    private String source1;

    private String des1;

    private int prix1;

    private Time depart1;

    private Time arrive1;

    private String date1;

    public ajout_tabletrain(String nom1, String source1, String des1, int prix1, Time depart1, Time arrive1, String date1) {
        this.nom1 = nom1;
        this.source1 = source1;
        this.des1 = des1;
        this.prix1 = prix1;
        this.depart1 = depart1;
        this.arrive1 = arrive1;
        this.date1 = date1;
    }

    public String getNom1() {
        return nom1;
    }

    public void setNom1(String nom1) {
        this.nom1 = nom1;
    }

    public String getSource1() {
        return source1;
    }

    public void setSource1(String source1) {
        this.source1 = source1;
    }

    public String getDes1() {
        return des1;
    }

    public void setDes1(String des1) {
        this.des1 = des1;
    }

    public int getPrix1() {
        return prix1;
    }

    public void setPrix1(int prix1) {
        this.prix1 = prix1;
    }

    public Time getDepart1() {
        return depart1;
    }

    public void setDepart1(Time depart1) {
        this.depart1 = depart1;
    }

    public Time getArrive1() {
        return arrive1;
    }

    public void setArrive1(Time arrive1) {
        this.arrive1 = arrive1;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

   
    

    
}
