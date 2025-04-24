/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.Concesionari.Persistens;

import com.practica.Concesionari.Logic.Coche;
import com.practica.Concesionari.Logic.Km0;
import com.practica.Concesionari.Logic.Nuevo;
import com.practica.Concesionari.Logic.SegundaMano;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Element;
import org.jdom2.JDOMException;

// Implementación de la interfaz CocheDAO
public class CocheDAOImplement implements CocheDAO {
    // Aquí aplico el patron DAO, para poner en practica la responsabilidad unica
    // de esta forma mis clases son más limpias y claras de leer.
    
    xmlConector com = new xmlConector();
    @Override
    // Recibe un objeto de las subclases que heredan de coche y las transforma a
    // Element, para luego pasarlo al xmlConector
    public boolean crear(Coche coche) {
        // Elemento
        Element nuevo_elemento = new Element("Coche");
        // Atributos
        nuevo_elemento.setAttribute("Matricula", coche.getMatricula());
        nuevo_elemento.setAttribute("Tipo", coche.getTipo());
        // Elementos comunes
        Element color = new Element("Color").setText(coche.getColor());
        Element precio = new Element("Precio").setText(String.valueOf(coche.getPrecio()));
        Element km = new Element("KM").setText(String.valueOf(coche.getKm()));
        // Nuevos
        String string_fecha = "";
        if (coche instanceof Nuevo) {
            string_fecha = ((Nuevo)coche).getFinalizacion_garantia().toString();
        }
        Element fecha = new Element("Fecha_garantia").setText(string_fecha);
        // Segunda mano
        String propietario = "";
        if (coche instanceof SegundaMano) {
            propietario = ((SegundaMano) coche).getAntiguo_propietario();
        }
        Element antiguo_propietario = new Element("Antiguo_propietario").setText(propietario);
        // KM0
        String string_estado = "";
        if (coche instanceof  Km0) {
            string_estado = ((Km0) coche).getEstado();
        }
        Element estado = new Element("Estado").setText(string_estado);
        // Add
        nuevo_elemento.addContent(color);
        nuevo_elemento.addContent(precio);
        nuevo_elemento.addContent(km);
        nuevo_elemento.addContent(fecha);
        nuevo_elemento.addContent(antiguo_propietario);
        nuevo_elemento.addContent(estado);
        return com.agregarCoche(nuevo_elemento); // Retorna true si se pudo crear y false si no
        
    }
    // Envia la matricula al XmlConector para eliminarlo, esto al comprar un coche.
    @Override
    public boolean eliminar(Coche coche) {
        try {
            com.eliminarCoche(coche.getMatricula());
            
        } catch (JDOMException ex) {
            Logger.getLogger(CocheDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(CocheDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    // Recibe los Element que retorna el XmlConector, y los transforma al tipo de coche adecuado (Nuevo, Km0, SegundaMano)
    @Override
    public List<Coche> listar() {
        List<Coche> lista = new ArrayList<>();
        Coche coche;
        try {
            for(Element e : com.listarCoches()){
                coche = switch (e.getAttributeValue("Tipo")) {
                    case "nuevo" -> new Nuevo(e.getAttributeValue("Matricula"),
                            e.getChildText("Color"),
                            Integer.parseInt(e.getChildText("Precio")));
                    case "km0" -> new Km0(e.getAttributeValue("Matricula"),
                            e.getChildText("Color"),
                            Integer.parseInt(e.getChildText("Precio")),
                            Double.parseDouble(e.getChildText("KM")));
                    default -> new SegundaMano(e.getAttributeValue("Matricula"),
                            e.getChildText("Color"),
                            Integer.parseInt(e.getChildText("Precio")),
                            Double.parseDouble(e.getChildText("KM")),
                            e.getChildText("Antiguo_propietario"));
                };
                lista.add(coche);
            }
        } catch (JDOMException ex) {
            Logger.getLogger(CocheDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CocheDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista; // Retorna la lista.
    }

    
    
}
