package colegio;

public class Alumno extends Persona{
	protected int notaprogramacion;
	protected int notabasedatos;
	protected int notalenguaje;
	protected int notasistemas;
	protected int notaentornos;
	protected int notafol;
	
	
	
	public int getNotaprogramacion() {
		return notaprogramacion;
	}
	public void setNotaprogramacion(int notaprogramacion) {
		this.notaprogramacion = notaprogramacion;
	}
	public int getNotabasedatos() {
		return notabasedatos;
	}
	public void setNotabasedatos(int notabasedatos) {
		this.notabasedatos = notabasedatos;
	}
	public int getNotalenguaje() {
		return notalenguaje;
	}
	public void setNotalenguaje(int notalenguaje) {
		this.notalenguaje = notalenguaje;
	}
	public int getNotasistemas() {
		return notasistemas;
	}
	public void setNotasistemas(int notasistemas) {
		this.notasistemas = notasistemas;
	}
	public int getNotaentornos() {
		return notaentornos;
	}
	public void setNotaentornos(int notaentornos) {
		this.notaentornos = notaentornos;
	}
	public int getNotafol() {
		return notafol;
	}
	public void setNotafol(int notafol) {
		this.notafol = notafol;
	}
	

	public Alumno(String nombre, String apellido1, String apellido2, String dni) {
		super(nombre, apellido1, apellido2, dni);
		
	}

	public Alumno() {
		this.nombre = null;
		this.apellido1 = null;
		this.apellido2 = null;
		this.dni = null;
	}
	
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", dni=" + dni
				+ "]";
	}


}
