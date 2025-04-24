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
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class xmlConector {
    // Los metodos retornan true y false para permitir a la lógica continuar o detenerse.
    
    
    // Solo debe crear, eliminar, retornar debe tratar con elementos, y con el xml
    public xmlConector() {
        estructuraDirecotrio();
        crearXml();
    }
    // Comprueba la existencia del directorio, si no existe lo crea.
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
    // Comprueba la existencia del xml, si no existe lo crea
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
    // Actualiza el xml
    private void actualizarXml(Document doc) throws IOException{
        XMLOutputter xml_output = new XMLOutputter(Format.getPrettyFormat());
        xml_output.output(doc, new FileWriter(ruta.toString()));
    }
    // Comprueba si la matricula ya existe, de ser asi retorna un true
    // Evita la repetición de matriculas
    public boolean comprobarExitencia(String matricula) throws JDOMException, IOException{
        Document doc = cargarXml();
        Element root = doc.getRootElement();
        for(Element e : root.getChildren()){
            if(e.getAttributeValue("Matricula").equals(matricula))return true;
        }
        return false;
    }
    // Recibe un elemento y lo agrega al xml
    public boolean agregarCoche(Element elemento){
        try{
            if(comprobarExitencia(elemento.getAttributeValue("Matricula"))) return false;
            Document doc = cargarXml();
            Element root = doc.getRootElement();
            root.addContent(elemento);
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
    
    // Lista todos los coches y los retorna.
    public List<Element> listarCoches() throws JDOMException, IOException{
        return cargarXml().getRootElement().getChildren();
    }
    // Ruta del xml a leer.
    private final Path ruta = Paths.get("Concesionario\\Concesionario.xml");
}
