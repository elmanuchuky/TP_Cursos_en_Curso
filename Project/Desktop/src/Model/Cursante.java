package Model;

class Cursante {
    int id;
    int id_Matriculado;
    boolean esFamilia;
    int id_Datos_Generales;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Matriculado() {
        return id_Matriculado;
    }

    public void setId_Matriculado(int id_Matriculado) {
        this.id_Matriculado = id_Matriculado;
    }

    public boolean isEsFamilia() {
        return esFamilia;
    }

    public void setEsFamilia(boolean esFamilia) {
        this.esFamilia = esFamilia;
    }

    public int getId_Datos_Generales() {
        return id_Datos_Generales;
    }

    public void setId_Datos_Generales(int id_Datos_Generales) {
        this.id_Datos_Generales = id_Datos_Generales;
    }

    public Cursante() {
    }

    public Cursante(int id, int id_Matriculado, boolean esFamilia, int id_Datos_Generales) {
        this.id = id;
        this.id_Matriculado = id_Matriculado;
        this.esFamilia = esFamilia;
        this.id_Datos_Generales = id_Datos_Generales;
    }

    @Override
    public String toString() {
        return "Cursante{" + "id=" + id + ", id_Matriculado=" + id_Matriculado + ", esFamilia=" + esFamilia + ", id_Datos_Generales=" + id_Datos_Generales + '}';
    }
    
    
}
