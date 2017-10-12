package Model;

import java.sql.Timestamp;
import java.util.Date;

public class Curso {
    
    private int idCurso;
    private String nombreCurso;
    private String descripcion;
    private Date fechaInicio;
    private String temas;
    private int duracionTotalSemanas;
    private double costo;
    private int cupo;
    private String  aula;
    private Timestamp diaHorario;
    private int cargaHoraria;

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getTemas() {
        return temas;
    }

    public void setTemas(String temas) {
        this.temas = temas;
    }

    public int getDuracionTotalSemanas() {
        return duracionTotalSemanas;
    }

    public void setDuracionTotalSemanas(int duracionTotalSemanas) {
        this.duracionTotalSemanas = duracionTotalSemanas;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Timestamp getDiaHorario() {
        return diaHorario;
    }

    public void setDiaHorario(Timestamp diaHorario) {
        this.diaHorario = diaHorario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Curso() {
    }

    public Curso(int idCurso, String nombreCurso, String descripcion, Date fechaInicio, String temas, int duracionTotalSemanas, double costo, int cupo, String aula, Timestamp diaHorario, int cargaHoraria) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.temas = temas;
        this.duracionTotalSemanas = duracionTotalSemanas;
        this.costo = costo;
        this.cupo = cupo;
        this.aula = aula;
        this.diaHorario = diaHorario;
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" + "idCurso=" + idCurso + ", nombreCurso=" + nombreCurso + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", temas=" + temas + ", duracionTotalSemanas=" + duracionTotalSemanas + ", costo=" + costo + ", cupo=" + cupo + ", aula=" + aula + ", diaHorario=" + diaHorario + ", cargaHoraria=" + cargaHoraria + '}';
    }
    
    
    
    
}
