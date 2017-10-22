package Model;

public class Asistencia {
    
    private int inscripcion;
    private String fechaAsistencia;
    private boolean estaPresente;

    public int getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(int inscripcion) {
        this.inscripcion = inscripcion;
    }

    public String getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(String fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    public boolean isEstaPresente() {
        return estaPresente;
    }

    public void setEstaPresente(boolean estaPresente) {
        this.estaPresente = estaPresente;
    }

    public Asistencia() {
    }

    public Asistencia(int inscripcion, String fechaAsistencia, boolean estaPresente) {
        this.inscripcion = inscripcion;
        this.fechaAsistencia = fechaAsistencia;
        this.estaPresente = estaPresente;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "inscripcion=" + inscripcion + ", fechaAsistencia=" + fechaAsistencia + ", estaPresente=" + estaPresente + '}';
    }   
}