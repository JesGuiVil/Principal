package jerarquia;

public class Oficial extends Operario {
	
		public String toString() {
			String cadena=super.toString();
			cadena+="--> Oficial";
			return cadena;
		}
		//CONSTRUCTORES
		public Oficial() {
			super();
		}
		public Oficial(String nombre) {
			super(nombre);
		}
	}
