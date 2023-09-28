package rentacar;

public class mainrentacar {

	public static void main(String[] args) {
		//apartado 1, metodo que establezca la conexion a la base de datos rentacar
		conexion coches= new conexion();
		coches.conexionBBDD();
		// apartado 2, metodo que consulta los alquileres y los muestra por pantalla de forma ordenada
		coches.datosAlquileres("alquileres");
		// apartado 3, crea metodo para modificar vehiculo y usalo con 3 coches
		coches.modificarVehiculo("123234", "seat", "leon", "gasolina");
		coches.modificarVehiculo("234123", "seat", "panda", "gasolina");
		coches.modificarVehiculo("456567", "open", "astra", "gasolina");
		
		coches.cerrarConexion();

	}

}
