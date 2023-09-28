package jerarquia;

public class Tecnico extends Operario {
	
		public String toString() {
			String cadena=super.toString();
			cadena+="--> Tecnico";
			return cadena;
		}
		//CONSTRUCTORES
		public Tecnico() {
			super();
		}
		public Tecnico(String nombre) {
			super(nombre);
		}
	}
