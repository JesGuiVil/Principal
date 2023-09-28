package Palasaca;

public interface Cuent extends Product{
	public String getIban();
	public Double getSaldo();
	public boolean Acceso(int codigo);
	public Double SacarDinero(int cantidad);
	public Double IngresarDinero(int cantidad);
	public String VisualizarCuenta();
	public String DatosCuenta();
	public TiposCuenta TipoCuenta();
	public Double DevolverIntereses();
}