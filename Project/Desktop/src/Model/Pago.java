package Model;

public class Pago {
    
    private int idPago;
    private int inscripcion;
    private double monto;
    private String fechaPago;

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(int inscripcion) {
        this.inscripcion = inscripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Pago() {
    }

    public Pago(int idPago, int inscripcion, double monto, String fechaPago) {
        this.idPago = idPago;
        this.inscripcion = inscripcion;
        this.monto = monto;
        this.fechaPago = fechaPago;
    }

    public Pago(int inscripcion, double monto) {
        this.inscripcion = inscripcion;
        this.monto = monto;
    }
    @Override
    public String toString() {
        return "Pago{" + "idPago=" + idPago + ", inscripcion=" + inscripcion + ", monto=" + monto + ", fechaPago=" + fechaPago + '}';
    }

    
    
    
}
