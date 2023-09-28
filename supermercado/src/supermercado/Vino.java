package supermercado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vino implements EsLiquido, EsAlimento, ConDescuento{
	private String marca, tipoEnvase, tipoVino;
	private double precio, volumen, descuento, grados;
	private LocalDate caducidad;

	
	public Vino(String marca, String tipoVino, double precio, double grados) {
		super();
		this.marca = marca;
		this.tipoVino = tipoVino;
		this.precio = precio;
		this.grados = grados;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public double getGrados() {
		return grados;
	}


	public void setGrados(double grados) {
		this.grados = grados;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getTipoVino() {
		return tipoVino;
	}


	public void setTipoVino(String tipoVino) {
		this.tipoVino = tipoVino;
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

	
	public void setCaducidad(LocalDate fc) {
		this.caducidad=fc;
		
	}

	
	public LocalDate getCaducidad() {
	
		return caducidad;
	}

	
	public int getCalorias() {
		int calorias;
		calorias=(int) getGrados()*10;
		return calorias;
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

	public String toString() {
		return "Vino \nPrecio=" + precio + "\nVolumen=" + volumen + "\nDescuento=" + descuento + "\nGrados=" + grados
				+ "\nMarca=" + marca + "\nTipo de envase=" + tipoEnvase + "\nTipo de vino=" + tipoVino + "\nCalorias="+getCalorias()+"\nCaducidad="
				+ caducidad.format(DateTimeFormatter.ofPattern("d/M/yyyy"));
	}
}
