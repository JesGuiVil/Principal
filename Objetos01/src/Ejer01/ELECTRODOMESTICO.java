package Ejer01;

public class ELECTRODOMESTICO {
//ATRIBUTOS
	protected double preciobase;
	protected String color, tipo;
	protected char consumo;
	protected int peso;
	protected static final int PRECIOBASE=100;
	protected static final int PESO=5;
	protected static final String COLOR="blanco";
	protected static final String TIPO="electrodomestico";
	protected static final char CONSUMO='F';
	//SETTERS Y GETTERS
	public double getPreciobase() {
		return preciobase;
	}
	public void setPreciobase(double preciobase) {
		this.preciobase = preciobase;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public char getConsumo() {
		return consumo;
	}
	public void setConsumo(char consumo) {
		this.consumo = consumo;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void comprobarConsumoEnergetico(char consumo) {
		String letra="";
		letra+=consumo;
		String letras="abcdefABCDEF";
		if (!letras.contains(letra)) {
			this.setConsumo(CONSUMO);
		}
	}
	public void comprobarColor(String color) {
		String colores="blanco,BLANCO,negro,NEGRO,rojo,ROJO,azul,AZUL,gris,GRIS";
		if (!colores.contains(color)) {
			this.setColor(COLOR);
		}
	}
	public void precioFinal() {
		switch(getConsumo()) {
		case 'A': this.setPreciobase(this.getPreciobase()+100); 
		break;
		case 'B': this.setPreciobase(this.getPreciobase()+80); 
		break;
		case 'C': this.setPreciobase(this.getPreciobase()+60); 
		break;
		case 'D': this.setPreciobase(this.getPreciobase()+50); 
		break;
		case 'E': this.setPreciobase(this.getPreciobase()+30); 
		break;
		case 'F': this.setPreciobase(this.getPreciobase()+10); 
		break;
		}
		if (this.getPeso()<20) this.setPreciobase(this.getPreciobase()+10);
		if ((this.getPeso()>19)&(this.getPeso()<50)) this.setPreciobase(this.getPreciobase()+50);
		if ((this.getPeso()>49)&(this.getPeso()<80)) this.setPreciobase(this.getPreciobase()+80);
		if ((this.getPeso()>79)) this.setPreciobase(this.getPreciobase()+100);
	}
	public ELECTRODOMESTICO() {
		this.setPreciobase(PRECIOBASE);
		this.setColor(COLOR);
		this.setConsumo(CONSUMO);
		this.setPeso(PESO);
		this.setTipo(TIPO);
	}
	public ELECTRODOMESTICO(double preciobase, int peso) {
		this.setPreciobase(preciobase);
		this.setColor(COLOR);
		this.setConsumo(CONSUMO);
		this.setPeso(peso);
		this.setTipo(TIPO);
	}
	public ELECTRODOMESTICO(double preciobase, String color, char consumo, int peso) {
		this.setPreciobase(preciobase);
		this.setColor(color);
		this.setConsumo(consumo);
		this.setPeso(peso);
		this.setTipo(TIPO);
		comprobarConsumoEnergetico(getConsumo());
		comprobarColor(getColor());
	}
	public ELECTRODOMESTICO(ELECTRODOMESTICO dato) {
		this.setPreciobase(dato.getPreciobase());
		this.setColor(dato.getColor());
		this.setConsumo(dato.getConsumo());
		this.setPeso(dato.getPeso());
		this.setTipo(dato.getTipo());
	}
	
	
}
