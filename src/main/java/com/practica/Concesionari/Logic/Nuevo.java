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
        agregarCarroXml(this);
    }
    
    /* Metodos */
    private void InitFechaGarantia(){
        
        Calendar cl = Calendar.getInstance();
        Finalizacion_garantia = new Date();
        cl.setTime(Finalizacion_garantia);
        cl.add(cl.YEAR, 2);
        Finalizacion_garantia = cl.getTime();
    }
    @Override
    protected void agregarCarroXml(Coche co){
        xml_con.agregarCoche(co.tipo ,co.matricula, co.getColor(), co.precio, Finalizacion_garantia.toString(), km, "");
    }
    
    /* Variable */
    private Date Finalizacion_garantia;
    
    /* Getters */
    public Date getFinalizacion_garantia() {
        return Finalizacion_garantia;
    }
    /* Setters */
   
}
