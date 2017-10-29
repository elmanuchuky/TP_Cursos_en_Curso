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
public class VMPresinscripto {
    String nombreCompleto;
    String documento;
    String curso;
    double pagado;

    public double getPagado() {
        return pagado;
    }

    public void setPagado(double pagado) {
        this.pagado = pagado;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

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

    public VMPresinscripto(String nombreCompleto, String documento) {
        this.nombreCompleto = nombreCompleto;
        this.documento = documento;
    }

    public VMPresinscripto() {
    }

    @Override
    public String toString() {
        return curso + "  -  " + nombreCompleto + "  -  " + documento + "  -  $" + pagado;
    }    
}
