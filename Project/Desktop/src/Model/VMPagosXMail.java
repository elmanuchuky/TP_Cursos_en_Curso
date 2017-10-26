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
public class VMPagosXMail {
    String nombre;
    float monto;
    String fecha;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    public VMPagosXMail() {
    }

    public VMPagosXMail(String nombre, float monto, String fecha) {
        this.nombre = nombre;
        this.monto = monto;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "VMPagosXMail{" + "nombre=" + nombre + ", monto=" + monto + ", fecha=" + fecha + '}';
    }
}
