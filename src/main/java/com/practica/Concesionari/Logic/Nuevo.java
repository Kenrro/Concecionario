/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.Concesionari.Logic;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Kevin
 */
public class Nuevo extends Coche {

    public Nuevo(String matricula, String color, int precio) {
        super("nuevo", matricula, color, precio);
        InitFechaGarantia();
    }
    
    /* Metodos */
    // Asigna dos años a la fecha actual, esa sera la fecha de finalización de la garantia.
    private void InitFechaGarantia(){
        
        Calendar cl = Calendar.getInstance();
        Finalizacion_garantia = new Date();
        cl.setTime(Finalizacion_garantia);
        cl.add(cl.YEAR, 2);
        Finalizacion_garantia = cl.getTime();
    }
    
    /* Variable */
    private Date Finalizacion_garantia; 
    
    /* Getters */
    public Date getFinalizacion_garantia() {
        return Finalizacion_garantia;
    }
    /* Setters */
   
}
