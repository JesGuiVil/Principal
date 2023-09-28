package AccesoDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoVehiculos {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String BBDD = "jdbc:mysql://localhost/vehiculos";
	private static final String USUARIO = "jesus";
	private static final String PASSWORD = "jesuspw";


	public Connection conexionBBDD() {
		Connection conec = null;
		try{
			Class.forName(DRIVER);
			conec = DriverManager.getConnection(BBDD,USUARIO,PASSWORD);
			System.out.println("conexion hecha");

		} catch (Exception errores){
			System.err.println("se ha producido un error al conectar con la base de datos. \n"+errores);
		}
		return conec;
	}
	public void cerrarConexion(Connection conection) {
		try {
			conection.close();
		}catch(SQLException e) {
			System.err.println("se ha producido un error al conectar con la base de datos. \n"+e);
		}
	}
	public void datosTabla(String nombreTabla) {
		Connection conec = conexionBBDD();
		if (conec != null) {
			try {
				Statement consulta = conec.createStatement();
				ResultSet retorno = consulta.executeQuery("SELECT * FROM " + nombreTabla);

				ResultSetMetaData basedatos = retorno.getMetaData();
				int cantidadColumnas = basedatos.getColumnCount();

				// Imprimir los nombres de las columnas
				System.out.println();
				for (int i = 1; i <= cantidadColumnas; i++) {
					System.out.printf("%-30s",basedatos.getColumnName(i));
				}
				System.out.println();
				System.out.println();

				// Imprimir los datos de cada fila
				while (retorno.next()) {
					for (int i = 1; i <= cantidadColumnas; i++) {
						System.out.printf("%-30s",retorno.getObject(i));
					}
					System.out.println();
				}

				System.out.println("Datos de la tabla " + nombreTabla + " recuperados correctamente");
				consulta.close();
			} catch (SQLException e) {
				System.err.println("Se ha producido un error al obtener los datos de la tabla " + nombreTabla + "\n" + e);
			} finally {
				cerrarConexion(conec);
			}
		}
	}
	public void insertarDatos(String datos) {
		Connection conec= conexionBBDD();
		if (conec!=null) {
			try {
				String baseconsulta= "INSERT INTO vehiculos (Matricula, Marca, Modelo, Anyo,Potencia,Plazas,Deposito,Consumo,L_correcto,Observaciones)"+
						"VALUES "+datos;
				System.out.println(baseconsulta);
				Statement consulta=conec.createStatement();
				consulta.executeUpdate(baseconsulta);
				System.out.println("Datos insertados correctamente");
				consulta.close();
			}catch (SQLException e) {
				System.err.println("se ha producido un error al insertar en la base de datos.\n"+e);
			}finally {
				cerrarConexion(conec);
			}
		}
	}
	public void mostrarDatos(String columna, Object valor) {
	    Connection conec = conexionBBDD();
	    if (conec != null) {
	        try {
	            String baseconsulta = "SELECT * FROM vehiculos WHERE " + columna + " = ?";
	            PreparedStatement consulta = conec.prepareStatement(baseconsulta);
	            consulta.setObject(1, valor);

	            ResultSet retorno = consulta.executeQuery();
	            ResultSetMetaData basedatos = retorno.getMetaData();
	            int cantidadColumnas = basedatos.getColumnCount();

	            // Imprimir los nombres de las columnas
	            System.out.println();
	            for (int i = 1; i <= cantidadColumnas; i++) {
	                System.out.printf("%-30s",basedatos.getColumnName(i));
	            }
	            System.out.println();
	            System.out.println();

	            // Imprimir los datos de cada fila
	            while (retorno.next()) {
	                for (int i = 1; i <= cantidadColumnas; i++) {
	                    System.out.printf("%-30s",retorno.getObject(i));
	                }
	                System.out.println();
	            }

	            System.out.println("Registros encontrados correctamente");
	           consulta.close();
	        } catch (SQLException e) {
	            System.err.println("Se ha producido un error al obtener los registros.\n" + e);
	        } finally {
	            cerrarConexion(conec);
	        }
	    }
	}
	public void eliminarRegistro(String columna, Object valor) {
	    Connection conec = conexionBBDD();
	    if (conec != null) {
	        try {
	            String baseconsulta = "DELETE FROM vehiculos WHERE " + columna + " = ?";
	            PreparedStatement consulta = conec.prepareStatement(baseconsulta);
	            consulta.setObject(1, valor);

	            int filasAfectadas = consulta.executeUpdate();

	            System.out.println("Se han eliminado " + filasAfectadas + " registro(s) correctamente");

	            consulta.close();
	        } catch (SQLException e) {
	            System.err.println("Se ha producido un error al eliminar el registro.\n" + e);
	        } finally {
	            cerrarConexion(conec);
	        }
	    }
	}
}


