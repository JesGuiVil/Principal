package pruebainicial;
import java.sql.*;
import java.util.Scanner;
public class AccesoDatos {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String BBDD = "jdbc:mysql://localhost/congreso";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "root";
	private Connection conec=null;
	Scanner sc=new Scanner(System.in);
	/**
	 * metodo basico que conecta a la base de datos
	 */
	public void conexionBBDD() {
		System.out.println("INTENTANDO CONECTAR A LA BASE DE DATOS DEL CONGRESO....");
		try{
			Class.forName(DRIVER);
			conec = DriverManager.getConnection(BBDD,USUARIO,PASSWORD);
			System.out.println("conexion realizada con exito\n");
			System.out.println("--------GESTION DEL CONGRESO---------\n");
		} catch (Exception errores){
			System.err.println("se ha producido un error al conectar con la base de datos. \n"+errores);
		}
	}	
	public void gestion() {	
		conexionBBDD();
		menu();
		cerrarConexion(conec);
		sc.close();
	}	
	public void menu() {
		int opcion=1;
		do {
			System.out.println();
			System.out.println("Seleccione una opción");
			System.out.println("--------------------");
			System.out.println(" 1. Añadir asistente");
			System.out.println(" 2. Mostrar asistente");
			System.out.println(" 3. Modificar DNI asistente");
			System.out.println(" 4. Eliminar asistente");
			System.out.println(" 0. SALIR");

			opcion=sc.nextInt();

			if (opcion==1) {
				aniadirAsistente();
			}
			if (opcion==2) {
				mostrarAsistentes();
			}
			if (opcion==3) {
				System.out.println("introduce el dni actual del asistente a modificar");
				String respuesta=sc.next();
				modificarDatosPersonales(respuesta);
			}
			if (opcion==4) {
				eliminarAsistente();
			}

		} while (opcion!=0);
	}
	/**@param conection conexion ala base de datos
	 * metodo para cerrar la conexion a la base de datos. se ejecuta al pulsar 0 y salir del menu tras acabar las gestiones.
	 */
	public void cerrarConexion(Connection conection) {
		try {
			conection.close();
		}catch(SQLException e) {
			System.err.println("se ha producido un error al conectar con la base de datos. \n"+e);
		}
	}
	/**
	 * @param tabla nombre de la tabla a consultar
	 * metodo que consulta todos los registros de una tabla
	 */
	public void datosTabla(String nombreTabla) {
		//Connection conec = conexionBBDD();
		if (conec != null) {
			try {
				Statement consulta = conec.createStatement();
				ResultSet retorno = consulta.executeQuery("SELECT * FROM " + nombreTabla);

				ResultSetMetaData basedatos = retorno.getMetaData();
				int cantidadColumnas = basedatos.getColumnCount();

				// Imprimir los nombres de las columnas
				System.out.println();
				for (int i = 1; i <= cantidadColumnas; i++) {
					System.out.printf("%-40s",basedatos.getColumnName(i));
				}
				System.out.println();
				System.out.println();

				// Imprimir los datos de cada fila
				while (retorno.next()) {
					for (int i = 1; i <= cantidadColumnas; i++) {
						System.out.printf("%-40s",retorno.getObject(i));
					}
					System.out.println();
				}

				System.out.println("Datos de la tabla " + nombreTabla + " recuperados correctamente");
				consulta.close();
			} catch (SQLException e) {
				System.err.println("Se ha producido un error al obtener los datos de la tabla " + nombreTabla + "\n" + e);
			} 
		}
	}
	public void mostrarAsistentes() {
		if (conec != null) {
			try {
				String baseconsulta = "SELECT * FROM alumnos";
				Statement consulta= conec.createStatement();

				ResultSet salida = consulta.executeQuery(baseconsulta);
				ResultSetMetaData basedatos = salida.getMetaData();
				int cantidadColumnas = basedatos.getColumnCount();

				// Imprimir los nombres de las columnas
				System.out.println();
				for (int i = 1; i <= cantidadColumnas; i++) {
					System.out.printf("%-30s",basedatos.getColumnName(i));
				}
				System.out.println();
				System.out.println();

				// Imprimir los datos de cada fila
				while (salida.next()) {
					for (int i = 1; i <= cantidadColumnas; i++) {
						System.out.printf("%-30s",salida.getObject(i));
					}
					System.out.println();
				}

				System.out.println("Registros encontrados correctamente");
				consulta.close();
			} catch (SQLException e) {
				System.err.println("Se ha producido un error al obtener los registros.\n" + e);
			} 
		}
	}
	/**
	 * @param tabla tabla de referencia
	 * @param columna columna de referencia
	 * @param valor valor de referencia
	 * metodo para eliminar registros indicandole tabla y el valor y columna de referencia del registro que quiere borrar
	 */
	public void eliminarAsistente(String tabla, String columna, Object valor) {
		if (conec != null) {
			try {
				String baseconsulta = "DELETE FROM "+tabla+" WHERE " + columna + " = ?";
				PreparedStatement consulta = conec.prepareStatement(baseconsulta);
				consulta.setObject(1, valor);

				int filasAfectadas = consulta.executeUpdate();

				System.out.println("Se han eliminado " + filasAfectadas + " registro(s) correctamente");

				consulta.close();
			} catch (SQLException e) {
				System.err.println("Se ha producido un error al eliminar el registro.\n" + e);
			} 
		}
	}
	/**
	 * @param tabla tabla de referencia
	 * @param nombrecolumna columna de referencia
	 * @param valor valor de referencia
	 * @param columna columna a modificar el dato
	 * @param nuevoValor valor a introducir
	 * metodo para modificar un valor de un registro. se le indica la tabla, la columna y valor de referencia (normalmente 'id') y la columna y el dato a modificar
	 */
	public void modificarRegistro(String tabla, String nombrecolumna, String valor, String columna, Object nuevoValor) {
		if (conec != null) {
			try {
				String baseconsulta = "UPDATE " + tabla + " SET " + columna + " = ? WHERE " + nombrecolumna + " = ?";
				PreparedStatement consulta = conec.prepareStatement(baseconsulta);
				consulta.setObject(1, nuevoValor);
				consulta.setString(2, valor);

				int filasAfectadas = consulta.executeUpdate();

				System.out.println("Se han modificado " + filasAfectadas + " registro(s) correctamente");

				consulta.close();
			} catch (SQLException e) {
				System.err.println("Se ha producido un error al modificar el registro.\n" + e);
			}
		}
	}
	public void aniadirAsistente() {
		System.out.println();
		System.out.println("introduce el dni");
		String dni = sc.next();
		System.out.println("introduce el nombre");
		sc.nextLine();
		String nombre = sc.nextLine();
		System.out.println("introduce el primer apellido");
		sc.nextLine();
		String apellido1 = sc.nextLine();
		System.out.println("introduce el segundo apellido");
		sc.nextLine();
		String apellido2 = sc.nextLine();
		System.out.println("introduce el codigo postal");
		String cp = sc.next();
		System.out.println("introduce la localidad");
		sc.nextLine(); 
		String localidad = sc.nextLine();
		System.out.println("introduce la provincia");
		sc.nextLine();
		String provincia = sc.nextLine();
		System.out.println("introduce el domicilio");
		sc.nextLine(); 
		String domicilio = sc.nextLine();
		System.out.println("introduce el telefono");
		String telefono = sc.next();
		System.out.println("introduce el email");
		String email = sc.next();
		System.out.println("introduce la fecha de nacimiento en formato aaaa-mm-dd");
		String fechanac = sc.next();
		System.out.println("introduce observaciones");
		sc.nextLine();
		String observaciones = sc.nextLine();
		insertarDatos("asistentes", "(dni, nombre, apellido1, apellido2, cp, localidad, provincia, domicilio, telefono, email, fechanac, observaciones) "
				+ "VALUES ('"+dni+"','"+nombre+"','"+apellido1+"','"+apellido2+"','"+cp+"','"+localidad+"','"+provincia+"','"+domicilio+"','"+telefono+"','"+email+"','"+fechanac+"','"+observaciones+"')");

		

	}
	public void insertarDatos(String tabla, String datos) {
		if (conec!=null) {
			try {
				String baseconsulta= "INSERT INTO "+tabla+datos;
				System.out.println(baseconsulta);
				Statement consulta=conec.createStatement();
				consulta.executeUpdate(baseconsulta);
				System.out.println("Datos insertados correctamente");
				consulta.close();
			}catch (SQLException e) {
				System.err.println("se ha producido un error al insertar en la base de datos.\n"+e);
			}
		}
	}
	public void eliminarAsistente() {
		
				System.out.println();
				System.out.println("introduzca el dni del asistente");
				String dni=sc.next();
				eliminarRegistro("asistentes","dni",dni);
	}
	public void eliminarRegistro(String tabla, String columna, Object valor) {
		if (conec != null) {
			try {
				String baseconsulta = "DELETE FROM "+tabla+" WHERE " + columna + " = ?";
				PreparedStatement consulta = conec.prepareStatement(baseconsulta);
				consulta.setObject(1, valor);

				int filasAfectadas = consulta.executeUpdate();

				System.out.println("Se han eliminado " + filasAfectadas + " registro(s) correctamente");

				consulta.close();
			} catch (SQLException e) {
				System.err.println("Se ha producido un error al eliminar el registro.\n" + e);
			} 
		}
	}	
	public void modificarDatosPersonales(String dni) {
		System.out.println();
		System.out.println("introduce el nuevo valor");
		sc.nextLine();
		String valor=sc.nextLine();
		modificarRegistro("personal","dni",dni,"dni",valor);
	}
}