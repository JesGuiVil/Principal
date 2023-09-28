package colegio;

public class Profesor extends Persona{
	protected int edad;
	protected Asignatura asignatura1,asignatura2,asignatura3;
	protected double nota1, nota2, nota3;
	protected int sueldo;

	//getters y setters
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Asignatura getAsignatura1() {
		return asignatura1;
	}
	public void setAsignatura1(Asignatura asignatura1) {
		this.asignatura1 = asignatura1;
	}
	public Asignatura getAsignatura2() {
		return asignatura2;
	}
	public void setAsignatura2(Asignatura asignatura2) {
		this.asignatura2 = asignatura2;
	}
	public Asignatura getAsignatura3() {
		return asignatura3;
	}
	public void setAsignatura3(Asignatura asignatura3) {
		this.asignatura3 = asignatura3;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getNota3() {
		return nota3;
	}
	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	
	//constructores
	
	public Profesor() {
		super();
	}
	public Profesor(String nombre, String apellido1, String apellido2, String dni, int edad, Asignatura asignatura1,
			Asignatura asignatura2, Asignatura asignatura3,int sueldo) {
		super(nombre, apellido1, apellido2, dni);
		this.edad = edad;
		this.asignatura1 = asignatura1;
		this.asignatura2 = asignatura2;
		this.asignatura3 = asignatura3;
		this.sueldo = sueldo;
	}


}
