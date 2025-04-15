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
    public void agregarCoche(String matricula){
        try{
            Document doc = cargarXml();
            Element root = doc.getRootElement();
            Element coche = new Element("Coche");
            coche.setAttribute("Matricula", matricula);
        }catch(Exception e){
            
        }
    }
    private Path ruta = Paths.get("Concesionario\\Concesionario.xml");
    /* Variables de clase */
    private static int id_next; //Lleva un conte del id anterior
}
