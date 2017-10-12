package Model;

import java.util.Date;

public class DatosGenerales {
    
    private int idDatosGenerales;
    private String nombreMatriculado;
    private String apellidoMatriculado;
    private int tipoDni;
    private int dni;
    private Date fechaNacimiento;
    private String telefono;
    private String email;

    public int getIdDatosGenerales() {
        return idDatosGenerales;
    }

    public void setIdDatosGenerales(int idDatosGenerales) {
        this.idDatosGenerales = idDatosGenerales;
    }

    public String getNombreMatriculado() {
        return nombreMatriculado;
    }

    public void setNombreMatriculado(String nombreMatriculado) {
        this.nombreMatriculado = nombreMatriculado;
    }

    public String getApellidoMatriculado() {
        return apellidoMatriculado;
    }

    public void setApellidoMatriculado(String apellidoMatriculado) {
        this.apellidoMatriculado = apellidoMatriculado;
    }

    public int getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(int tipoDni) {
        this.tipoDni = tipoDni;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DatosGenerales() {
    }

    public DatosGenerales(int idDatosGenerales, String nombreMatriculado, String apellidoMatriculado, int tipoDni, int dni, Date fechaNacimiento, String telefono, String email) {
        this.idDatosGenerales = idDatosGenerales;
        this.nombreMatriculado = nombreMatriculado;
        this.apellidoMatriculado = apellidoMatriculado;
        this.tipoDni = tipoDni;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public String toString() {
        return "DatosGenerales{" + "idDatosGenerales=" + idDatosGenerales + ", nombreMatriculado=" + nombreMatriculado + ", apellidoMatriculado=" + apellidoMatriculado + ", tipoDni=" + tipoDni + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", email=" + email + '}';
    }
    
    
    
}
