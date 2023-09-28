package pruebainicial;

import pruebainicial.AccesoDatos;

public class Main {
	/**
	 * El main solo crea un AccesoProyecto y ejecuta el menu.
	 */
	public static void main(String[] args) {
		AccesoDatos congreso= new AccesoDatos();
		congreso.gestion();

	}
}