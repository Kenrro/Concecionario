/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.practica.Concesionari;

import com.practica.Concesionari.Logic.Km0;
import com.practica.Concesionari.Logic.Nuevo;
import java.util.Calendar;
import java.util.Date;
import com.practica.Concesionari.Persistens.xmlConector;

/**
 *
 * @author Kevin
 */
public class Concesionario {

    public static void main(String[] args) {
        System.out.println("hol");
        Nuevo km = new Nuevo("uno", "Gris", 5, 5);
        Km0 km0 = new Km0("dos", "Gris", 5, 5);
        /*Calendar cl = Calendar.getInstance();
        Date dt = new Date();
        cl.setTime(dt);
        cl.add(cl.YEAR, 2);
        dt = cl.getTime();
        System.out.println(dt);
        xmlConector xml_con = new xmlConector();
        xml_con.agregarCoche("asdf", "asdf", 50);*/
    }
    
    
}
