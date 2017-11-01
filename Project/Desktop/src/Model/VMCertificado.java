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
public class VMCertificado {

    String alumno;
    String documento;
    String fechaInicio;
    String fechaFinal;
    String horas;
    String nombreCurso;

    public VMCertificado(String alumno, String documento, String fechaInicio, String fechaFinal, String horas, String nombreCurso) {
        this.alumno = alumno;
        this.documento = documento;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.horas = horas;
        this.nombreCurso = nombreCurso;
    }

    public VMCertificado() {
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    
    
}
