package jerarquia;

public class Directivo extends Empleado {
//ATRIBUTOS 
	
	public String toString() {
		String cadena=super.toString();
		cadena+="--> Directivo";
		return cadena;
	}
	//CONSTRUCTORES
		public Directivo() {
			super();
		}
		public Directivo(String nombre) {
			super(nombre);
		}
	
}
