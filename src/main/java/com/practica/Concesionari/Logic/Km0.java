/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.Concesionari.Logic;

/**
 *
 * @author Kevin
 */
public class Km0 extends Coche {

    public Km0() {
    }
    
    
    public Km0(String matricula, String color, int precio, double km) {
        super("km0", matricula, color, precio);
        this.km = km;
        agregarCarroXml(this);
        
    }
    
    /* Variables */
    
}
