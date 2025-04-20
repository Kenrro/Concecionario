/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.practica.Concesionari;

import com.practica.Concesionari.IGU.INIT;
import com.practica.Concesionari.Logic.Coche;
import com.practica.Concesionari.Logic.Km0;
import com.practica.Concesionari.Logic.Nuevo;
import com.practica.Concesionari.Logic.SegundaMano;
import java.util.Calendar;
import java.util.Date;
import com.practica.Concesionari.Persistens.xmlConector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.JDOMException;

/**
 *
 * @author Kevin
 */
public class Concesionario {

    public static void main(String[] args) throws JDOMException, IOException {
        System.out.println("hol");
        Nuevo km;
        System.out.println(km = new Nuevo("cmd 6598", "Rojo", 10500));
        SegundaMano se = new SegundaMano("jose", "negro", 0, 0, "Cristofer");
        lista_coches = xml.listarCoches();
        for(Coche c : lista_coches){
            System.out.println(c.getMatricula());
        }
        INIT com = new INIT();
        com.setVisible(true);
        
        /*Calendar cl = Calendar.getInstance();
        Date dt = new Date();
        cl.setTime(dt);
        cl.add(cl.YEAR, 2);
        dt = cl.getTime();
        System.out.println(dt);
        xmlConector xml_con = new xmlConector();
        xml_con.agregarCoche("asdf", "asdf", 50);*/
        xml.eliminarCoche("69");
    }
    
    // Atributos
    
    static public List<Coche> lista_coches = new ArrayList<>();
    static xmlConector xml = new xmlConector();
}
