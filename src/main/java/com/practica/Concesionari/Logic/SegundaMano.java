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
    
    public SegundaMano(String matricula, String color, double precio, double km) {
        super(matricula, color, precio, km);
    }
    /* Variables */
    private String antiguo_propietario = "";

    public String getAntiguo_propietario() {
        return antiguo_propietario;
    }

    public void setAntiguo_propietario(String antiguo_propietario) {
        this.antiguo_propietario = antiguo_propietario;
    }
}
