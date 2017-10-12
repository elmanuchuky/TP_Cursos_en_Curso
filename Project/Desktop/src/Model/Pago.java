package Model;

public class Pago {
    
    private int idPago;
    private Inscripcion inscripcion;
    private double monto;

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
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

    public Pago(int idPago, Inscripcion inscripcion, double monto) {
        this.idPago = idPago;
        this.inscripcion = inscripcion;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Pago{" + "idPago=" + idPago + ", inscripcion=" + inscripcion + ", monto=" + monto + '}';
    }
    
    
    
}
