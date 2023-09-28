package supermercado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cereales implements EsAlimento{
	private String marca, tipoCereal;
	private double precio;
	private LocalDate caducidad;
	

	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getTipoCereal() {
		return tipoCereal;
	}


	public void setTipoCereal(String tipoCereal) {
		this.tipoCereal = tipoCereal;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public Cereales(String marca, String tipoCereal, double precio) {
		this.marca = marca;
		this.tipoCereal = tipoCereal;
		this.precio = precio;
	}


	public void setCaducidad(LocalDate fc) {
		this.caducidad=fc;
		
	}


	public LocalDate getCaducidad() {
		
		return caducidad;
	}

	
	public int getCalorias() {
		int calorias;
		if (getTipoCereal().equalsIgnoreCase("espelta")) {
			calorias=5;
		}else if (getTipoCereal().equalsIgnoreCase("maíz")) {
			calorias=8;
		}else if (getTipoCereal().equalsIgnoreCase("trigo")) {
			calorias=12;	
		}else {
			calorias=15;
		}
		return calorias;
	}


	public String toString() {
		return "Cereales: \nMarca=" + marca + "\nTipo de cereal=" + tipoCereal + "\nPrecio=" + precio + "\nCaducidad="
				+ caducidad.format(DateTimeFormatter.ofPattern("d/M/yyyy"))+"\nCalorias="+getCalorias();
	}
	
	
}

