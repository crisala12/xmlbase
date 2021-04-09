/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Dell
 */
public class Leerxml {
    private ArrayList<Docente> listaDocente = new ArrayList<Docente>();
    
    public ArrayList<Docente> leerXML() {
          try {
            File archivo = new File("datos.xml");
            DocumentBuilderFactory documentoBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentoB = documentoBF.newDocumentBuilder();
            Document documento = documentoB.parse(archivo);
            documento.getDocumentElement().normalize();
            System.out.println("Elemento pricipal: " + documento.getDocumentElement().getNodeName());
            NodeList listaDocentes = documento.getElementsByTagName("docente");
            for (int i = 0; i < listaDocentes.getLength(); i++) {
                Node docente = listaDocentes.item(i);// Cargando todos los docentes en una colección de tipo nodo
                System.out.println("Docente: " + docente.getNodeName() + i); 
                if (docente.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element)docente;
                      String id = element.getAttribute("id");
                      String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                      String usuario = element.getElementsByTagName("username").item(0).getTextContent();
                      String contraseña = element.getElementsByTagName("password").item(0).getTextContent();
                      
                    listaDocente.add(new Docente(Integer.parseInt(id), nombre, usuario, contraseña));
                }
            }
        } catch (ParserConfigurationException ex) {
            System.err.println("Error, " + ex);
        } catch (SAXException ex) {
            System.err.println("Error, " + ex);
        } catch (IOException ex) {
            System.err.println("Error, " + ex);
        } 
          return listaDocente;
    }
    
}
