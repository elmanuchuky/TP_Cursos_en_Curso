/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Usuario
 */
public class vwAsistenciaRegistrar {
    
    private String nombreCompleto;
    private int idInscripcion;
    private boolean estaPresente;

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public boolean isEstaPresente() {
        return estaPresente;
    }

    public void setEstaPresente(boolean estaPresente) {
        this.estaPresente = estaPresente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public vwAsistenciaRegistrar() {
    }

    public vwAsistenciaRegistrar(String nombreCompleto, int idInscripcion, boolean estaPresente) {
        this.nombreCompleto = nombreCompleto;
        this.idInscripcion = idInscripcion;
        this.estaPresente = estaPresente;
    }

      

    @Override
    public String toString() {
        return "vmAsistencia{" + "nombreCompleto=" + nombreCompleto + '}';
    }
    
}
