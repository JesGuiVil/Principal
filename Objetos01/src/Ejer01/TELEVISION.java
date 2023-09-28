package Ejer01;

public class TELEVISION extends ELECTRODOMESTICO {
 //atributos
	protected int resolucion;
	protected boolean tdt;
	protected static final int RESOLUCION=20;
	protected static final boolean TDT=false;
	protected static final String TIPO="television";
	//GETTERS AND SETTERS
	public int getResolucion() {
		return resolucion;
	}
	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}
	public boolean isTdt() {
		return tdt;
	}
	public void setTdt(boolean tdt) {
		this.tdt = tdt;
	}
	public TELEVISION() {
		super();
		this.setPreciobase(PRECIOBASE);
		this.setPeso(PESO);
		this.setColor(COLOR);
		this.setConsumo(CONSUMO);
		this.setResolucion(RESOLUCION);
		this.setTdt(TDT);
		this.setTipo(TIPO);
	}
	public TELEVISION(double preciobase, int peso) {
		super(preciobase, peso);
		this.setColor(COLOR);
		this.setConsumo(CONSUMO);
		this.setResolucion(RESOLUCION);
		this.setTdt(TDT);
		this.setTipo(TIPO);
	}
	public TELEVISION(double preciobase, String color, char consumo, int peso, int pulgadas, boolean tdt) {
		super(preciobase, color, consumo, peso);
		this.setResolucion(RESOLUCION);
		this.setTdt(TDT);
		this.setTipo(TIPO);
		comprobarConsumoEnergetico(this.getConsumo());
		comprobarColor(this.getColor());
	}
	public void precioFinal(){
		super.precioFinal();
		if (this.getResolucion()>40) {
			this.setPreciobase(this.getPreciobase()*1.3);
		}
		if (this.isTdt()) {
			this.setPreciobase(this.getPreciobase()+50);
		}
	}
	
}
