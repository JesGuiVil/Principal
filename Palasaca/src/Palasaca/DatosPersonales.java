package Palasaca;

import java.util.Scanner;

public class DatosPersonales implements DatosPers{
	protected String dni;
	protected String nombre;
	protected String apellido1;
	protected String apellido2;
	protected String telefono;
	protected String email;
	protected String direccion;
	protected String localidad;
	protected int codigopostal;
	protected String provincia;
	protected String fn;
	protected String observaciones;

	public String getDni() {
		return dni;
	}
	protected void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	protected void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	protected void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getTelefono() {
		return telefono;
	}
	protected void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	protected void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	protected void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public int getCodigopostal() {
		return codigopostal;
	}
	protected void setCodigopostal(int codigopostal) {
		this.codigopostal = codigopostal;
	}
	public String getProvincia() {
		return provincia;
	}
	protected void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getFn() {
		return fn;
	}
	protected void setFn(String fn) {
		this.fn = fn;
	}
	public String getObservaciones() {
		return observaciones;
	}
	protected void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public DatosPersonales() {
		
	}
	
	public DatosPersonales(String dni, String nombre, String apellido1, String apellido2, String telefono, String email,
			String direccion, String localidad, int codigopostal, String provincia, String fn,
			String observaciones) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.localidad = localidad;
		this.codigopostal = codigopostal;
		this.provincia = provincia;
		this.fn = fn;
		this.observaciones = observaciones;
	}
	
	public void ModificarDatos(DatosPersonales datos) {
		Scanner sc=new Scanner(System.in);
		String respuesta;
		System.out.println("¿DESEA MODIFICAR LOS DATOS? (si/no)");
		respuesta=sc.next();
		if(respuesta.equals("si")) {
			;
			if (datos instanceof Clientes) {
				//MODIFICA CLIENTE
				Clientes cliente = (Clientes) datos;
				cliente.ModificarCliente(cliente);
			}
			if (datos instanceof Empleados) {
				//MODIFICA EMPLEADO
				Empleados empleado = (Empleados) datos;
				empleado.ModificarEmpleado(empleado);
			}
			
		
		
		}
	}
	@Override
	public String toString() {
		return "\ndni=" + dni + ", \nnombre=" + nombre + ", \napellido1=" + apellido1 + ", \napellido2="
				+ apellido2 + ", \ntelefono=" + telefono + ", \nemail=" + email + ", \ndireccion=" + direccion
				+ ", \nlocalidad=" + localidad + ", \ncodigopostal=" + codigopostal + ", \nprovincia=" + provincia + ", \nfecha nacimiento="
				+ fn + ", \nobservaciones=" + observaciones;
	}
	
	

}
