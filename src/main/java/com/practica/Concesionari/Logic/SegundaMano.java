/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.Concesionari.Logic;

/**
 *
 * @author Kevin
 */
public class SegundaMano extends Coche {
    
    public SegundaMano(String matricula, String color, int precio, double km, String antiguo_propietario) {
        super("Segunda" ,matricula, color, precio);
        this.km = km;
        this.antiguo_propietario = antiguo_propietario;
    }
    /* Variables */
    private String antiguo_propietario = "";

    public String getAntiguo_propietario() {
        return antiguo_propietario;
    }
    // Metodo único de esta clase
    public void setAntiguo_propietario(String antiguo_propietario) {
        this.antiguo_propietario = antiguo_propietario;
    }
}
