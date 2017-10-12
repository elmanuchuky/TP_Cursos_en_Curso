package Model;

import java.util.Date;

public class Inscripcion {
    
    private int idInscripcion;
    private Curso curso;
    private Cursante cursante;
    private boolean estado;
    private boolean aprobado;
    private Date fechaRealizada;

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Cursante getCursante() {
        return cursante;
    }

    public void setCursante(Cursante cursante) {
        this.cursante = cursante;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Date getFechaRealizada() {
        return fechaRealizada;
    }

    public void setFechaRealizada(Date fechaRealizada) {
        this.fechaRealizada = fechaRealizada;
    }

    public Inscripcion() {
    }

    public Inscripcion(int idInscripcion, Curso curso, Cursante cursante, boolean estado, boolean aprobado, Date fechaRealizada) {
        this.idInscripcion = idInscripcion;
        this.curso = curso;
        this.cursante = cursante;
        this.estado = estado;
        this.aprobado = aprobado;
        this.fechaRealizada = fechaRealizada;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", curso=" + curso + ", cursante=" + cursante + ", estado=" + estado + ", aprobado=" + aprobado + ", fechaRealizada=" + fechaRealizada + '}';
    }
    
    
    
}
