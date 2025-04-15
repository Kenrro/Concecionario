/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.practica.Concesionari;

import java.util.Calendar;
import java.util.Date;
import com.practica.Concesionari.Persistens.xmlConector;

/**
 *
 * @author Kevin
 */
public class Concesionario {

    public static void main(String[] args) {
        Calendar cl = Calendar.getInstance();
        Date dt = new Date();
        cl.setTime(dt);
        cl.add(cl.YEAR, 2);
        dt = cl.getTime();
        System.out.println(dt);
        xmlConector xml_con = new xmlConector();
    }
    
    
}
