/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Gabriel
 */
public class ComboNuevoCursante {
    int id;
    String nombre;
    String fecha;

    public ComboNuevoCursante(int id, String nombre, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public ComboNuevoCursante() {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return nombre+" - "+ fecha;
    }
}
