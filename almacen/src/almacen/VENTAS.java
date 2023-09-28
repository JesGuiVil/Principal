package almacen;
import java.util.Date;

public class VENTAS {
protected ARTICULO articulo;
protected String fechacompra;
protected int unidadesvendidas;
protected double preciototal;
protected boolean pagado;
public ARTICULO getArticulo() {
	return articulo;
}
public void setArticulo(ARTICULO articulo) {
	this.articulo = articulo;
}
public String getFechacompra() {
	return fechacompra;
}
public void setFechacompra(String fechacompra) {
	this.fechacompra = fechacompra;
}
public int getUnidadesvendidas() {
	return unidadesvendidas;
}
public void setUnidadesvendidas(int unidadesvendidas) {
	this.unidadesvendidas = unidadesvendidas;
}
public double getPreciototal() {
	return preciototal;
}
public void setPreciototal(double preciototal) {
	this.preciototal = preciototal;
}
public boolean isPagado() {
	return pagado;
}
public void setPagado(boolean pagado) {
	this.pagado = pagado;
}
public VENTAS(ARTICULO articulo, String fechacompra, int unidadesvendidas, double preciototal, boolean pagado) {
	this.articulo = articulo;
	this.fechacompra = fechacompra;
	this.unidadesvendidas = unidadesvendidas;
	this.preciototal = preciototal;
	this.pagado = pagado;
	
}
public String toString() {
	return "VENTAS [articulo=" + articulo + ", fechacompra=" + fechacompra + ", unidadesvendidas=" + unidadesvendidas
			+ ", preciototal=" + preciototal + ", pagado=" + pagado + "]";
}


}
