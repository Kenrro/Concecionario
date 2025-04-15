/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.Concesionari.Logic;



public abstract class Coche {

    public Coche() {
    }

    public Coche(String matricula, String color, double precio, double km) {
        this.matricula = matricula;
        this.color = color;
        this.precio = precio;
        this.km = km;
    }

    
    
    /* Variables */
    private String matricula;
    private String color;
    private double precio;
    private double km;
    /* Setters */

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setKm(double km) {
        this.km = km;
    }
    /* Getters */

    public String getMatricula() {
        return matricula;
    }

    public String getColor() {
        return color;
    }

    public double getPrecio() {
        return precio;
    }

    public double getKm() {
        return km;
    }
    
}
