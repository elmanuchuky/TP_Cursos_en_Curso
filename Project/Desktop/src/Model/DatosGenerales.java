package Model;

import java.util.Date;

public class DatosGenerales {
    
    private int idDatosGenerales;
    private String nombre;
    private String apellido;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public DatosGenerales(int idDatosGenerales, String nombre, String apellido, int tipoDni, int dni, Date fechaNacimiento, String telefono, String email) {
        this.idDatosGenerales = idDatosGenerales;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDni = tipoDni;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public String toString() {
        return "DatosGenerales{" + "idDatosGenerales=" + idDatosGenerales + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoDni=" + tipoDni + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", email=" + email + '}';
    }
    
    
    
}
