package jerarquia;

public class Empleado {
//ATRIBUTOS
	private String nombre;
//GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//METODOS
	public String toString() {
	String cadena="";
	cadena+="Empleado "+this.getNombre();
	return cadena;
	}
	//CONSTRUCTORES
	public Empleado() {
		this.setNombre("");
	}
	public Empleado(String nombre) {
		this.setNombre(nombre);
	}
}
