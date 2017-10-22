package Model;

public class Matriculado {
private int idMatriculado;
    private int legajoMatriculado;
    private int datos;
    private String profesion;

    public int getIdMatriculado() {
        return idMatriculado;
    }

    public void setIdMatriculado(int idMatriculado) {
        this.idMatriculado = idMatriculado;
    }

    public int getLegajoMatriculado() {
        return legajoMatriculado;
    }

    public void setLegajoMatriculado(int legajoMatriculado) {
        this.legajoMatriculado = legajoMatriculado;
    }

    public int getDatos() {
        return datos;
    }

    public void setDatos(int datos) {
        this.datos = datos;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Matriculado() {
    }

    public Matriculado(int idMatriculado, int legajoMatriculado, int datos, String profesion) {
        this.idMatriculado = idMatriculado;
        this.legajoMatriculado = legajoMatriculado;
        this.datos = datos;
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "Matriculado{" + "idMatriculado=" + idMatriculado + ", legajoMatriculado=" + legajoMatriculado + ", datos=" + datos + ", profesion=" + profesion + '}';
    }
}
