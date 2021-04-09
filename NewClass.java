/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @author Dell
 */
public class NewClass {
    public static void main(String[] args) {
        Leerxml leer = new Leerxml();
        Db4o datos = new Db4o();
        datos.crearBaseDeDatos();
        datos.verificarDocente(leer.leerXML());
        for(Docente d: datos.leerDocentes()){
            System.out.println(d.toString());
        }
    }
}
    


    
    