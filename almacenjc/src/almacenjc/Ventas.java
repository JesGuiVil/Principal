package almacenjc;

public class Ventas {
	protected Articulo articulo;
	protected String fechacompra;
	protected int unidadesvendidas;
	protected double preciototal;
	protected boolean pagado;
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
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
	public Ventas() {
		
	}
	public Ventas(Articulo articulo, String fechacompra, int unidadesvendidas, double preciototal, boolean pagado) {
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
