package AccesoDatos;

public class mainvehiculos {

	public static void main(String[] args) {
		//RECOMIENDO EJECUTAR EL MAIN POR BLOQUES (comentando el resto para que no se ejecute todo a la vez)
		AccesoVehiculos accVehiculos=new AccesoVehiculos();
		//BLOQUE 1: REGISTRAR LOS 10 COCHES
		accVehiculos.insertarDatos("('2816ggc','seat', 'leon',2008,144,5,60,8,1,'va muy bien');");
		accVehiculos.insertarDatos("('2819ggt','seat', 'panda',2019,144,5,60,8,1,'va muy bien');");
		accVehiculos.insertarDatos("('1819gct','seat', 'ibiza',2019,100,5,60,6,1,'penquito');");
		accVehiculos.insertarDatos("('2819ggt','seat', 'altea',2016,120,5,50,9,1,'feo');");
		accVehiculos.insertarDatos("('1819gpt','mercedes', 'a3',2012,160,5,60,9,1,'ay');");
		accVehiculos.insertarDatos("('2819ggt','bmw', 'm3',2016,200,5,60,9,1,'cani');");
		accVehiculos.insertarDatos("('3849ggt','ford', 'fiesta',2016,120,5,50,9,1,'feo');");
		accVehiculos.insertarDatos("('1230ggt','citroen', 'picasso',2016,120,5,50,9,1,'feo');");
		accVehiculos.insertarDatos("('1234ggt','tesla', 'caro',2019,120,5,50,9,1,'hipoteca');");
		accVehiculos.insertarDatos("('4321ggt','seat', 'altea',2011,120,5,50,9,1,'blanco');");
		//BLOQUE 2: MOSTRAR TODA LA TABLA Y LOS COCHES CON AÑO MATRICULACION 2O19
		accVehiculos.datosTabla("vehiculos");
		accVehiculos.mostrarDatos("Anyo", 2019);
		//BLOQUE 3: ELIMINACION DE REGISTROS
		accVehiculos.eliminarRegistro("ID_vehiculo", 2);
		accVehiculos.eliminarRegistro("ID_vehiculo", 4);
		//BLOQUE 4: MOSTRAR LA TABLA FINAL
		accVehiculos.datosTabla("vehiculos");
		//las tabulaciones no he conseguido cuadrarlas, el tema de formatos me pone negro.
		
	}

}
