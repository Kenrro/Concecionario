/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.Concesionari.Persistens;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
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
    private void actualizarXml(Document doc) throws IOException{
        XMLOutputter xml_output = new XMLOutputter(Format.getPrettyFormat());
        xml_output.output(doc, new FileWriter(ruta.toString()));
    }
    public void agregarCoche(String tipo, String matricula,String color, int precio, String fecha){
        try{
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
            // Fecha garantia
            Element e_fecha_garantia = new Element("Fecha_garantia");
            e_fecha_garantia.setText(fecha.isEmpty() ? null : fecha);
            // Antiguo propietario
            Element e_antiguo_propietario = new Element("Antiguo_propietario");
            e_antiguo_propietario.setText("yo");
            // Add
            e_coche.addContent(e_color);
            e_coche.addContent(e_precio);
            e_coche.addContent(e_fecha_garantia);
            e_coche.addContent(e_antiguo_propietario);
            
            root.addContent(e_coche);
            actualizarXml(doc);
            System.out.println("Succes");
            
        }catch(Exception e){
            System.out.println("Failed");
        }
    }
    // eliminar un elemento
    public void eliminarCoche(String placa) throws JDOMException{
        
        Document doc = cargarXml();
        Element root = doc.getRootElement();
        for(Element e : root.getChildren()){
            
            if(e.getAttribute("Matricula").equals(placa)){
                root.removeContent(e);
                break;
            }
            
        }
        actualizarXml(doc);
        
    }
    private Path ruta = Paths.get("Concesionario\\Concesionario.xml");
}
