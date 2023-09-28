package AccesoDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoSakila {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String BBDD = "jdbc:mysql://localhost/sakila";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "root";


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
	public void getActor() {
		Connection conec= conexionBBDD();
		if (conec!=null) {
			try {
				String baseconsulta = "SELECT * FROM actor;";
				System.out.println(baseconsulta);
				Statement consulta=conec.createStatement();
				if(consulta.execute(baseconsulta)) {
					ResultSet retorno= consulta.getResultSet();
					System.out.println();
					System.out.printf("%-15s  %-20s  %-25s  %-40s","actor_id","first_name","last_name","last_update");
					System.out.println();
					System.out.println();
					while(retorno.next()) {
						System.out.printf("%-15s %-20s %-25s %-40s\n",retorno.getInt("actor_id"),retorno.getString("first_name"),retorno.getString("last_name"),retorno.getTimestamp("last_update"));
					}
				}
				System.out.println("Datos recuperados correctamente");
				consulta.close();
			}catch (SQLException e) {
				System.err.println("Se ha producido un eror al insetar en la base de datos. \n"+e);
			}finally {
				cerrarConexion(conec);
			}

		}
	}
	public void mostrarDatos(String nombreTabla) {
	    Connection conec = conexionBBDD();
	    if (conec != null) {
	        try {
	            Statement consulta = conec.createStatement();
	            ResultSet retorno = consulta.executeQuery("SELECT * FROM " + nombreTabla);

	            ResultSetMetaData basedatos = retorno.getMetaData();
	            int cantidadColumnas = basedatos.getColumnCount();

	            // Imprimir los nombres de las columnas
	            for (int i = 1; i <= cantidadColumnas; i++) {
	                System.out.print(basedatos.getColumnName(i) + "\t\t");
	            }
	            System.out.println();

	            // Imprimir los datos de cada fila
	            while (retorno.next()) {
	                for (int i = 1; i <= cantidadColumnas; i++) {
	                    System.out.print(retorno.getObject(i) + "\t\t");
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
	
}
