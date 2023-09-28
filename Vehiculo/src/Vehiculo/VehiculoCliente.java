package Vehiculo;

public class VehiculoCliente {
	
    private final String matricula;
    private int tiempo;
    private final double PRECIO_DIA = 25.0;
    private final double PRECIO_HORA = 1.2;
    private static final int TIEMPO=0;

    public VehiculoCliente(String matricula) {
        this.matricula = matricula;
        this.tiempo = TIEMPO;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public double factura() {
        int dias = tiempo / 1440; 
        int horas = (tiempo % 1440) / 60;
        return dias * PRECIO_DIA + horas * PRECIO_HORA;
    }

    public boolean hayPlaza(Parking parking) {
        return parking.libre();
    }

    public void aparca(Parking parking) {
        parking.ocuparPlaza();
    }

    
    public String toString() {
        return "Coche con matricula=" + matricula + ", ha sido estacionado " + tiempo + " minutos. La factura es de: " + this.factura();
    }

}