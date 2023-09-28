package Palasaca;

public interface Tarje extends Product{
	public void sacaDinero(int cantidad);
	public Double saldoDisponible();
	public Double cargarMonedero(int cantidad);
	public String datosTarjeta();
}
