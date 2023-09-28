package colegio;

public class Asignatura {
	//atributos
	protected String nombre;
	protected double notamedia;

	//getters ysetters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getNota() {
		return notamedia;
	}
	public void setNota(double nota) {
		this.notamedia = nota;
	}
	
	


	//constructores


	public Asignatura(String nombre) {
		super();
		this.nombre = nombre;
	}
	public Asignatura() {
		super();
		this.nombre = null;
	}

}
