package supermercado;

public class Detergente implements EsLiquido, ConDescuento{
private String marca, tipoEnvase;
private double precio, volumen, descuento;

	
	public Detergente(String marca, double precio) {
	this.marca = marca;
	this.precio = precio;
}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public void setVolumen(double v) {
		this.volumen=v;
	}

	
	public double getVolumen() {
		return volumen;
	}

	
	public void setTipoEnvase(String env) {	
		this.tipoEnvase=env;
	}

	public String getTipoEnvase() {
		return tipoEnvase;
	}

	public void setDescuento(double des) {
		this.descuento=des;
	}


	
	public double getDescuento() {
		return descuento;
	}

	public double getPrecioDescuento() {
		double preciofinal;
		preciofinal= getPrecio()-(getPrecio()*(getDescuento()/100));
		return preciofinal;
	}

	public String toString() {
		return "Detergente: \nMarca=" + getMarca() + "\nTipo de envase=" + getTipoEnvase() + "\nPrecio=" + getPrecio() + "\nVolumen="
				+ getVolumen() + "L\nDescuento=" + getDescuento() +"%\nPrecio final="+getPrecioDescuento();
	}
	
	
}
