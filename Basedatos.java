/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dell
 */
public class Basedatos {
     private ObjectContainer oc = null;
    private File archivo;

    public void crearBaseDeDatos() {
        try {
            archivo = new File("docente.yap");
            if (archivo.createNewFile()) {
                System.out.println("Se creo correctamente la base de datos.");
            }
        } catch (IOException ex) {
            System.err.println("Error: " + ex);
        }
    }

    private void open() {
        oc = Db4o.openFile("docente.yap");
    }

    public void verificarDocente(ArrayList<Docente> docente) {
        for (int i = 0; i < docente.size(); i++) {
            if (archivo.length() == 0) { // Verificamos si hay algun dato dentro del archivo
                insertarDocente(docente.get(0));
            } else {
                for (Docente d : docente) {
                    if (verificar(d) == true) {
                        insertarDocente(d);
                    }
                }
            }
        }

    }

    public boolean verificar(Docente docente) {
        boolean verificar = true;
        ArrayList<Docente> doc = leerDocentes();
        for (Docente d : doc) {
            if (docente.getId() == d.getId()) {
                verificar=false;
            } 
       
    }
    return verificar;    
    }

    public void insertarDocente(Docente docente) {
        try {
            open();
            oc.set(docente);
            oc.close();
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.insertarPersona() : " + e);
        }
    }

    public ArrayList<Docente> leerDocentes() {
        Docente d = new Docente(0, null, null, null);
        String lista[] = new String[4];
        ArrayList<Docente> doc = new ArrayList<Docente>();
        open();
        ObjectSet result = oc.get(d);
        while (result.hasNext()) {
            doc.add((Docente) result.next());
        }
        oc.close();
        return doc;
    }
}
