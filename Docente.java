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
public class Docente {
     private int id;
    private String nombre;
    private String user;
    private String pass;

    public Docente() {
    }
    

    public Docente(int id, String nombre, String user, String pass) {
        this.id = id;
        this.nombre = nombre;
        this.user = user;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    @Override
    public String toString() {
        return "id: " + id + "\nNombre: " + nombre + "\nUsuario: " + user + "\nContraseña: " + pass;
    }
    
    
}
