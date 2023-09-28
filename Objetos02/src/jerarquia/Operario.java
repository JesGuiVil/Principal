package jerarquia;

public class Operario extends Empleado {
	
		public String toString() {
			String cadena=super.toString();
			cadena+="--> Operario";
			return cadena;
		}
		//CONSTRUCTORES
		public Operario() {
			super();
		}
		public Operario(String nombre) {
			super(nombre);
		}
	}
