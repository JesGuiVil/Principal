package rentacar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class conexion {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String BBDD = "jdbc:mysql://localhost/rentacar";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "root";
	private Connection conec=null;
	Scanner sc=new Scanner(System.in);

	//metodo para conectar a la base de datos
	public void conexionBBDD() {
		System.out.println("INTENTANDO CONECTAR A LA BASE DE DATOS....");
		try{
			Class.forName(DRIVER);
			conec = DriverManager.getConnection(BBDD,USUARIO,PASSWORD);
			System.out.println("conexion realizada con exito\n");

		} catch (Exception errores){
			System.err.println("se ha producido un error al conectar con la base de datos. \n"+errores);
		}
	}
	//metodo para cerrar la conexion
	
	public void cerrarConexion() {
		try {
			conec.close();
		}catch(SQLException e) {
			System.err.println("se ha producido un error al conectar con la base de datos. \n"+e);
		}
	}
	//metodo al que se le da matricula de referencia y datos a modificar y realiza el update en la tabla vehiculos
	public void modificarVehiculo(String matricula, String nuevamarca, String nuevomodelo, String nuevoCombustible) {
	    if (conec != null) {
	        try {
	            String baseconsulta = "UPDATE vehiculos SET marca = ?, modelo = ?, combustible = ? WHERE matricula = ?";
	            PreparedStatement consulta = conec.prepareStatement(baseconsulta);
	            consulta.setString(1, nuevamarca);
	            consulta.setString(2, nuevomodelo);
	            consulta.setString(3, nuevoCombustible);
	            consulta.setString(4, matricula);

	            int filasAfectadas = consulta.executeUpdate();

	            System.out.println("Se han modificado " + filasAfectadas + " registro(s) correctamente");

	            // Consultar los registros modificados
	            String consultaRegistrosModificados = "SELECT * FROM vehiculos WHERE matricula = ?";
	            PreparedStatement consultaModificados = conec.prepareStatement(consultaRegistrosModificados);
	            consultaModificados.setString(1, matricula);
	            ResultSet resultado = consultaModificados.executeQuery();

	            // Imprimir los registros modificados
	            System.out.println("Registros modificados:");
	            while (resultado.next()) {
	                String marca = resultado.getString("marca");
	                String modelo = resultado.getString("modelo");
	                String combustible = resultado.getString("combustible");

	                System.out.println("Matrícula: " + matricula);
	                System.out.println("Marca: " + marca);
	                System.out.println("Modelo: " + modelo);
	                System.out.println("Combustible: " + combustible);
	                System.out.println("--------------------");
	            }

	            consulta.close();
	            consultaModificados.close();
	        } catch (SQLException e) {
	            System.err.println("Se ha producido un error al modificar el vehículo.\n" + e);
	        }
	    }
	}
	
	//metodo que consulta todos los registros de la tabla alquileres
	public void datosAlquileres(String nombreTabla) {
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


}
