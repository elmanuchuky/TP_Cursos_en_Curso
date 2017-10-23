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
public class vwAsistenciaMostrar {
    
    private String nombreCompleto;
    private String fechaAsistencia;
    

    public String getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(String fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }
    private boolean estaPresente;
    

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public boolean isEstaPresente() {
        return estaPresente;
    }

    public void setEstaPresente(boolean estaPresente) {
        this.estaPresente = estaPresente;
    }

    public vwAsistenciaMostrar() {
    }

    public vwAsistenciaMostrar(String nombreCompleto, String fechaAsistencia, boolean estaPresente) {
        this.nombreCompleto = nombreCompleto;
        this.fechaAsistencia = fechaAsistencia;
        this.estaPresente = estaPresente;
    }

    @Override
    public String toString() {
        return "vmAsistenciaMostrar{" + "nombreCompleto=" + nombreCompleto + ", estaPresente=" + estaPresente + '}';
    }
    
}
