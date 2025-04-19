/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.Concesionari.Persistens;

import com.practica.Concesionari.Logic.Coche;
import com.practica.Concesionari.Logic.Km0;
import com.practica.Concesionari.Logic.Nuevo;
import com.practica.Concesionari.Logic.SegundaMano;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Kevin
 */
public class xmlConector {

    public xmlConector() {
        estructuraDirecotrio();
        crearXml();
    }
    private void estructuraDirecotrio(){
        try{
            File directorio = new File(ruta.getParent().toString());
        if(!directorio.exists()){
            directorio.mkdir();
        }
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
    private void crearXml(){
        if(Files.notExists(ruta)){
            
            try{
                Element concesionario  = new Element("Concesionario");
                Document doc = new Document(concesionario);
                XMLOutputter xml = new XMLOutputter();
                xml.setFormat(Format.getPrettyFormat());
                xml.output(doc, new FileWriter(ruta.toString()));
                System.out.println("Nuevo archivo creado");           
            } catch(Exception e){
                System.out.println("No se ha podido crear el archivo xml.");
            }
            
        }
    }
    // Permite cargar el xml
    private Document cargarXml() throws JDOMException, IOException {
        Document doc = new SAXBuilder().build(new File(ruta.toString()));
        return doc;
    }
    public static Document cargarXmlStatic() throws JDOMException, IOException {
        Document doc = new SAXBuilder().build(new File(ruta.toString()));
        return doc;
    }
    // Actualiza el xml
    private void actualizarXml(Document doc) throws IOException{
        XMLOutputter xml_output = new XMLOutputter(Format.getPrettyFormat());
        xml_output.output(doc, new FileWriter(ruta.toString()));
    }
    // Comprueba si la matricula ya existe, de ser asi retorna un true
    public boolean comprobarExitencia(String matricula) throws JDOMException, IOException{
        Document doc = cargarXml();
        Element root = doc.getRootElement();
        for(Element e : root.getChildren()){
            if(e.getAttributeValue("Matricula").equals(matricula))return true;
        }
        return false;
    }
    public boolean agregarCoche(String tipo, String matricula,String color, int precio, String fecha, double km, String antiguo_propietario){
        try{
            if(comprobarExitencia(matricula)) return false;
            Document doc = cargarXml();
            Element root = doc.getRootElement();
            Element e_coche = new Element("Coche");
            e_coche.setAttribute("Matricula", matricula);
            e_coche.setAttribute("Tipo", tipo);
            // Color
            Element e_color = new Element("Color");
            e_color.setText(color);
            // precio
            Element e_precio = new Element("Precio");
            e_precio.setText(String.valueOf(precio));
            // km
            Element e_km = new Element("KM");
            e_km.setText(Double.toString(km).equals("0") ? null : Double.toString(km));
            // Fecha garantia
            Element e_fecha_garantia = new Element("Fecha_garantia");
            e_fecha_garantia.setText(fecha.isEmpty() ? null : fecha);
            // Antiguo propietario
            Element e_antiguo_propietario = new Element("Antiguo_propietario");
            e_antiguo_propietario.setText(antiguo_propietario.isEmpty() ? null : antiguo_propietario);
            // Add
            e_coche.addContent(e_color);
            e_coche.addContent(e_precio);
            e_coche.addContent(e_km);
            e_coche.addContent(e_fecha_garantia);
            e_coche.addContent(e_antiguo_propietario);
            
            root.addContent(e_coche);
            actualizarXml(doc);
            System.out.println("Succes");
            
        }catch(Exception e){
            System.out.println("Failed");
            return false;
        }
        return true;
    }
    // eliminar un elemento
    public void eliminarCoche(String placa) throws JDOMException, IOException{
        
        Document doc = cargarXml();
        Element root = doc.getRootElement();
        for(Element e : root.getChildren()){
            // busca la matricula, si la encuentra la elimina y sale. No comprueba el resto
            if(e.getAttributeValue("Matricula").equals(placa)){
                root.removeContent(e);
                break;
            }
            
        }
        actualizarXml(doc);
    }
    // Metodos de clase
    
    // Lista todos los coches y los retorna, de esta forma se cargan al empezar el programa
    public List<Coche> listarCoches() throws JDOMException, IOException{
        List<Coche> lista = new ArrayList<>();
        Coche coche;
        Document doc = cargarXml();
        Element root = doc.getRootElement();
        for(Element e : root.getChildren()){
            if(e.getAttributeValue("Tipo").equals("nuevo")){
                coche = new Nuevo(e.getAttributeValue("Matricula"), 
                        e.getChildText("Color"), 
                        Integer.parseInt(e.getChildText("Precio")));
            } else if(e.getAttributeValue("Tipo").equals("km0")){
                coche = new Km0(e.getAttributeValue("Matricula"),
                        e.getChildText("Color"), 
                        Integer.parseInt(e.getChildText("Precio")), 
                        Double.parseDouble(e.getChildText("KM")));
            }
            else{
                coche = new SegundaMano(e.getAttributeValue("Matricula"),
                        e.getChildText("Color"), 
                        Integer.parseInt(e.getChildText("Precio")), 
                        Double.parseDouble(e.getChildText("KM")),
                        e.getChildText("Antiguo_propietario"));
            }
            lista.add(coche);
        }
        return lista;
    }
    
    private static final Path ruta = Paths.get("Concesionario\\Concesionario.xml");
}
