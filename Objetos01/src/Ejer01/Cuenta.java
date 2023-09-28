package Ejer01;

public class Cuenta {
//ATRIBUTOS
	String nombre;
	String numero;
	double tipointeres;
	double saldo;
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getTipoInteres() {
		return tipointeres;
	}
	public void setTipoInteres(double tipo) {
		this.tipointeres = tipointeres;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	

	//CONSTRUCTORES
	public Cuenta() {
		this.setNombre("");
		this.setNumero("");
		this.setTipoInteres(0);
		this.setSaldo(0);
	}
	public Cuenta(String nombre, String numero, double tipointeres, double saldo) {
		this.setNombre(nombre);
		this.setNumero(numero);
		this.setTipoInteres(tipointeres);
		this.setSaldo(saldo);
	}
	public Cuenta(Cuenta dato) {
		this.setNombre(dato.getNombre());
		this.setNumero(dato.getNumero());
		this.setTipoInteres(dato.getTipoInteres());
		this.setSaldo(dato.getSaldo());
	}
	
	
	//METODOS
	public boolean ingreso (double ingre) {
		boolean correcto = true;
    	if (ingre>0) {
    		this.setSaldo(this.getSaldo()+ingre);
    		System.out.println("ingreso realizado a la cuenta "+this.getNombre());
    		correcto = true;
    	}else{
    		System.out.println("No se puede ingresar una cantidad negativa");
    		correcto = false;
    	}
    	return correcto; 
    }
	public boolean reintegro (double rein) {
		boolean correcto = true;
    	if (this.getSaldo()>rein) {
    		this.setSaldo(this.getSaldo()-rein);
    		System.out.println("reintegro realizado a la cuenta "+this.getNombre());
    		correcto=true;
    	}else{
    		System.out.println("No hay dinero suficiente");
    		correcto=false;
    	}
    	return correcto;
    }
	public boolean transferencia(Cuenta destino, double canti) {
		boolean correcto=true;
		if (this.getSaldo()>canti && canti>0) {
			reintegro(canti);
			destino.ingreso(canti);
			System.out.println("transferencia de cuenta "+this.getNumero()+" a cuenta "+destino.getNumero()+" realizada con éxito");
		}else {
			correcto=false;
			System.out.println("error en la transferencia");
		}
		return correcto;
	}
	
	
	
}
