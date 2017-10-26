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
public class VMNombreDocumento {
    String nombreCompleto;
    String documento;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public VMNombreDocumento(String nombreCompleto, String documento) {
        this.nombreCompleto = nombreCompleto;
        this.documento = documento;
    }

    public VMNombreDocumento() {
    }

    @Override
    public String toString() {
        return "VMNombreDocumento{" + "nombreCompleto=" + nombreCompleto + ", documento=" + documento + '}';
    }
}
