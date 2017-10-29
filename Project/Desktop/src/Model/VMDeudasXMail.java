/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Fernando M. de Lima
 */
public class VMDeudasXMail {
    String nombre;
    float monto;

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


    
    public VMDeudasXMail() {
    }

    public VMDeudasXMail(String nombre, float monto) {
        this.nombre = nombre;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return nombre + " - $" + monto;
    }
}
