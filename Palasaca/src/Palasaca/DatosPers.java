package Palasaca;

public interface DatosPers {
	public String getDni();
	public String getNombre();
	public String getApellido1();
	public String getApellido2();
	public String getTelefono();
	public String getEmail();
	public String getDireccion();
	public String getLocalidad();
	public int getCodigopostal();
	public String getProvincia();
	public String getFn();
	public String getObservaciones();
	public void ModificarDatos(DatosPersonales datos);
	//public void ModificaCliente();
	public String toString();
	
	
}
