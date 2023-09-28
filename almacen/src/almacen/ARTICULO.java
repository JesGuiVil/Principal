package almacen;

public class ARTICULO {
 protected int codigo;
 protected String nombre;
 protected String descripcion;
 protected double precio;
 protected int iva;
 protected PROVEEDOR proveedor;
 protected int unidades;
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
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}
public int getIva() {
	return iva;
}
public void setIva(int iva) {
	this.iva = iva;
}
public PROVEEDOR getProveedor() {
	return proveedor;
}
public void setProveedor(PROVEEDOR proveedor) {
	this.proveedor = proveedor;
}
public int getUnidades() {
	return unidades;
}
public void setUnidades(int unidades) {
	this.unidades = unidades;
}
public ARTICULO(int codigo, String nombre, String descripcion, double precio, int iva, PROVEEDOR proveedor,
		int unidades) {
	this.codigo = codigo;
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.precio = precio;
	this.iva = iva;
	this.proveedor = proveedor;
	this.unidades = unidades;
}
public double preciofinal() {
	double fact=this.precio+(this.precio*this.iva/100);
	return fact;
}
@Override
public String toString() {
	return "ARTICULO [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
			+ ", iva=" + iva + ", proveedor=" + proveedor.getNombre() + ", unidades=" + unidades + "]";
}
 
 
}
