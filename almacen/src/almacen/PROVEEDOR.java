package almacen;
import java.util.Date;


public class PROVEEDOR {
	protected int codigo;
	protected String nombre;
	protected String direccion;
	protected String alta;
	protected String tlf;
	protected String email;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getAlta() {
		return alta;
	}
	public void setAlta(String alta) {
		this.alta = alta;
	}
	public String getTlf() {
		return tlf;
	}
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public PROVEEDOR(int codigo, String nombre, String direccion, String alta, String tlf, String email) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.alta = alta;
		this.tlf = tlf;
		this.email = email;
	}
	@Override
	public String toString() {
		return "PROVEEDOR [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", alta=" + alta
				+ ", tlf=" + tlf + ", email=" + email + "]";
	}
	
	
}
