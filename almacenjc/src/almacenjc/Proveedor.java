package almacenjc;

public class Proveedor {
public int codigo;
public String nombre;
public String direccion;
public String fAlta;
public String email;
public String telefono;

public Proveedor(int codigo, String nombre, String direccion, String fAlta, String email, String telefono) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
	this.direccion = direccion;
	this.fAlta = fAlta;
	this.email = email;
	this.telefono = telefono;
}
public Proveedor() {
	
}

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

public String getfAlta() {
	return fAlta;
}

public void setfAlta(String fAlta) {
	this.fAlta = fAlta;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

@Override
public String toString() {
	return "Proveedor [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", fAlta=" + fAlta
			+ ", email=" + email + ", telefono=" + telefono + "]";
}




}
