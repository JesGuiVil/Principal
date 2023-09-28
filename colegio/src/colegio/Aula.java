package colegio;

import java.util.ArrayList;

public class Aula {

	//atributos
	protected String grupo;
	protected Profesor profesor;
	protected ArrayList<Alumno> alumnos;
	
	
	//getters y setters
	
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Aula() {
		super();
		this.grupo = null;;
		this.profesor = null;;
		this.alumnos = null;
	}

	public Aula(String grupo, Profesor profesor, ArrayList<Alumno> alumnos) {
		super();
		this.grupo = grupo;
		this.profesor = profesor;
		this.alumnos = alumnos;
	}



}
