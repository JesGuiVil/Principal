package Ejer01;

public class LAVADORA extends ELECTRODOMESTICO {
//ATRIBUTOS
	protected int carga;
	protected static final int CARGA=5;
	protected static final String TIPO="lavadora";
	
	//GETTERS Y SETTERS
	public int getCarga() {
		return carga;
	}
	public void setCarga(int carga) {
		this.carga = carga;
	}
	//CONSTRUCTORES
	public LAVADORA() {
		super();
		this.setPreciobase(PRECIOBASE);
		this.setPeso(PESO);
		this.setColor(COLOR);
		this.setConsumo(CONSUMO);
		this.setCarga(CARGA);
		this.setTipo(TIPO);
	}
	public LAVADORA(double preciobase, int peso) {
		super(preciobase, peso);
		this.setCarga(CARGA);
		this.setColor(COLOR);
		this.setConsumo(CONSUMO);
		this.setTipo(TIPO);
	}
	public LAVADORA(double preciobase, String color, char consumo, int peso, int carga) {
		super(preciobase, color, consumo, peso);
		this.setCarga(carga);
		this.setTipo(TIPO);
		comprobarConsumoEnergetico(this.getConsumo());
		comprobarColor(this.getColor());
	}
	public void precioFinal(){
		super.precioFinal();
		if (this.getCarga()>30) {
			this.setPreciobase(this.getPreciobase()+50);
		}
	}
	
	
	
}
