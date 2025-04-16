/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.Concesionari.Logic;

import com.practica.Concesionari.Persistens.xmlConector;



public abstract class Coche {

    public Coche() {
    }

    public Coche(String tipo ,String matricula, String color, int precio, double km) {
        this.matricula = matricula;
        this.color = color;
        this.precio = precio;
        this.km = km;
        this.tipo = tipo;
    }
    /* Variables */
    protected String tipo; // Especifica el tipo de carro, km0, nuevo o desegunda
    protected String matricula;
    protected String color;
    protected int precio;
    protected double km;
    /* Setters */

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setKm(double km) {
        this.km = km;
    }
    /* Getters */

    public String getTipo() {
        return tipo;
    }
    public String getMatricula() {
        return matricula;
    }

    public String getColor() {
        return color;
    }

    public int getPrecio() {
        return precio;
    }

    public double getKm() {
        return km;
    }
    // Metodos de instancia 
    
    protected void agregarCarroXml(Coche co){
        xml_con.agregarCoche(co.tipo ,co.matricula, co.getColor(), co.precio, "");
    }
    // Medotos de clase
    
    protected static xmlConector xml_con = new xmlConector();
    
   
    
}
