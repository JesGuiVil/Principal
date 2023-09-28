package proyectoIlerna;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 * @author JESUSGUIJARRO
 * Esta clase contiene todo lo necesario para establecer la conexion a la base de datos y gestionar todas sus tablas 
 * ES MUY IMPORTANTE QUE VUELVA A INTRODUCIR EL VALOR SI EN MITAD DE UN CUESTIONARIO PULSA "ENTER" Y NADA OCURRE.
 * ESTO SE DEBE AL USO DE SC.NEXTLINE() PARA PODER RECOGER STRINGS QUE INCLUYAN ESPACIOS, COMO EN LA DIRECCION O NOMBRE COMPUESTO.
 * LO CONFIGURE DE MANERA QUE NO DA ERROR, PERO A VECES HAY QUE INTRODUCIR EL DATO DOS VECES PARA QUE TE PREGUNTE EL SIGUIENTE DATO.
 */

public class AccesoProyecto {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String BBDD = "jdbc:mysql://localhost/proyecto";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "root";
	private Connection conec=null;
	Scanner sc=new Scanner(System.in);

	/**
	 * metodo basico que conecta a la base de datos
	 */
	public void conexionBBDD() {
		System.out.println("INTENTANDO CONECTAR A LA BASE DE DATOS DE ILERNA....");
		try{
			Class.forName(DRIVER);
			conec = DriverManager.getConnection(BBDD,USUARIO,PASSWORD);
			System.out.println("conexion realizada con exito\n");
			System.out.println("--------BIENVENIDO A ILERNA---------\n");
		} catch (Exception errores){
			System.err.println("se ha producido un error al conectar con la base de datos. \n"+errores);
		}
	}
	/**
	 * menu de identificación que muestra un menu u otro segun el cargo en el centro. este cargo se obtiene de la tabla usuarios con los datos del loggin
	 */
	public void menu() {	
		String user;
		String pw;
		String rol;
		conexionBBDD();
		System.out.println("Introduzca su usuario:");
		user=sc.next();
		System.out.println("Introduzca su contraseña:");
		pw=sc.next();
		rol=reconocerRol(user,pw);
		if (rol.equals("direccion")){
			menuDireccion();
		}
		if (rol.equals("secretaria")){
			menuSecretaria();
		}
		if (rol.equals("profesorado")){
			menuProfesorado();
		}
		cerrarConexion(conec);
		sc.close();
	}
	/**
	 * menu para directivos. tiene acceso a la mayoria de metodos, excepto a la matriculacion de alumnos que se realiza desde secretaría.
	 */
	public void menuDireccion() {
		int opcion=1;
		do {
			System.out.println();
			System.out.println("Seleccione una opción");
			System.out.println("--------------------");
			System.out.println(" 1. Gestión de alumnos");
			System.out.println(" 2. Gestión de personal");
			System.out.println(" 3. Gestión de materias");
			System.out.println(" 4. Gestión de aulas");
			System.out.println(" 5. Gestión de cursos");
			System.out.println(" 6. Gestión de convocatorias");
			System.out.println(" 7. Gestión de notas");
			System.out.println(" 8. Gestión de departamentos");
			System.out.println(" 9. Consultar datos concretos");
			System.out.println("10. Listados");
			System.out.println(" 0. SALIR");

			opcion=sc.nextInt();

			if (opcion==1) {
				int opcionn=1;
				do {
					System.out.println();
					System.out.println("Seleccione una opción");
					System.out.println("--------------------");
					System.out.println(" 1. Eliminar alumno");
					System.out.println(" 2. Modificar alumno");
					System.out.println(" 0. SALIR");

					opcionn=sc.nextInt();

					if (opcionn==1) {
						eliminarAlumno();
					}
					if (opcionn==2) {
						modificarAlumno();
					}

				} while (opcionn!=0);

			}
			if (opcion==2) {
				int opcionn=1;
				do {
					System.out.println();
					System.out.println("Seleccione una opción");
					System.out.println("--------------------");
					System.out.println(" 1. Añadir personal");
					System.out.println(" 2. Eliminar personal");
					System.out.println(" 3. Modificar personal");
					System.out.println(" 0. SALIR");

					opcionn=sc.nextInt();

					if (opcionn==1) {
						aniadirPersonal();
					}
					if (opcionn==2) {
						eliminarPersonal();
					}
					if (opcionn==3) {
						modificarPersonal();
					}

				} while (opcionn!=0);
			}
			if (opcion==3) {
				int opcionn=1;
				do {
					System.out.println();
					System.out.println("Seleccione una opción");
					System.out.println("--------------------");
					System.out.println(" 1. Añadir materia");
					System.out.println(" 2. Eliminar materia");
					System.out.println(" 3. Modificar materia");
					System.out.println(" 0. SALIR");

					opcionn=sc.nextInt();

					if (opcionn==1) {
						aniadirMateria();
					}
					if (opcionn==2) {
						eliminarMateria();
					}
					if (opcionn==3) {
						modificarMateria();
					}					

				}while (opcionn!=0);
			}
			if (opcion==4) {
				int opcionn=1;
				do {
					System.out.println();
					System.out.println("Seleccione una opción");
					System.out.println("--------------------");
					System.out.println(" 1. Añadir aulas");
					System.out.println(" 2. Eliminar aulas");
					System.out.println(" 3. Modificar aulas");
					System.out.println(" 0. SALIR");

					opcionn=sc.nextInt();

					if (opcionn==1) {
						aniadirAula();
					}
					if (opcionn==2) {
						eliminarAula();
					}
					if (opcionn==3) {
						modificarAula();
					}

				} while (opcionn!=0);

			}
			if (opcion==5) {
				int opcionn=1;
				do {
					System.out.println();
					System.out.println("Seleccione una opción");
					System.out.println("--------------------");
					System.out.println(" 1. Añadir cursos (recuerda que necesita añadir las materias primero)");
					System.out.println(" 2. Eliminar cursos");
					System.out.println(" 3. Modificar cursos");
					System.out.println(" 0. SALIR");

					opcionn=sc.nextInt();

					if (opcionn==1) {
						aniadirCurso();
					}
					if (opcionn==2) {
						eliminarCurso();
					}
					if (opcionn==3) {
						modificarCurso();
					}

				} while (opcionn!=0);

			}
			if (opcion==6) {
				int opcionn=1;
				do {
					System.out.println();
					System.out.println("Seleccione una opción");
					System.out.println("--------------------");
					System.out.println(" 1. Añadir convocatoria");
					System.out.println(" 2. Eliminar convocatoria");
					System.out.println(" 3. Modificar convocatoria");
					System.out.println(" 0. SALIR");

					opcionn=sc.nextInt();

					if (opcionn==1) {
						aniadirConvocatoria();
					}
					if (opcionn==2) {
						eliminarConvocatoria();
					}
					if (opcionn==3) {
						modificarConvocatoria();
					}

				} while (opcionn!=0);

			}
			if (opcion==7) {
				int opcionn=1;
				do {
					System.out.println();
					System.out.println("Seleccione una opción");
					System.out.println("--------------------");
					System.out.println(" 1. Añadir notas");
					System.out.println(" 2. Modificar notas");
					System.out.println(" 0. SALIR");

					opcionn=sc.nextInt();

					if (opcionn==1) {
						aniadirNota();
					}
					if (opcionn==2) {
						modificarNota();
					}

				} while (opcionn!=0);

			}
			if (opcion==8) {
				int opcionn=1;
				do {
					System.out.println();
					System.out.println("Seleccione una opción");
					System.out.println("--------------------");
					System.out.println(" 1. Añadir departamentos");
					System.out.println(" 2. Eliminar departamentos");
					System.out.println(" 3. Modificar departamentos");
					System.out.println(" 0. SALIR");

					opcionn=sc.nextInt();

					if (opcionn==1) {
						aniadirDepartamento();
					}
					if (opcionn==2) {
						eliminarDepartamento();
					}
					if (opcionn==3) {
						modificarDepartamento();
					}

				} while (opcionn!=0);

			}

			if (opcion==9) {
				System.out.println();
				System.out.println("introduce el nombre de la tabla de la cual desea consultar el dato");
				String tabla = sc.next();
				System.out.println("introduce el id del registro que desea consultar");
				String id=sc.next();
				System.out.println("¿Desea visualizar todos los datos del registro? (Y) para registro completo (N) para dato especifico");
				String resp=sc.next();
				if(resp.equals("Y")|| resp.equals("y")) {
					mostrarDatos(tabla,"id",id);
				}
				if(resp.equals("N")|| resp.equals("n")) {
					System.out.println("introduce el dato que le interesa conocer");
					String columna=sc.next();
					mostrarDatoConcreto(tabla,"id",id,columna);	
				}

			}
			if (opcion==10) {
				int opcionn=1;
				do {
					System.out.println();
					System.out.println("Seleccione una opción");
					System.out.println("--------------------");
					System.out.println(" 1. Listado de alumnos");
					System.out.println(" 2. Listado de personal");
					System.out.println(" 3. Listado de materias");
					System.out.println(" 4. Listado de aulas");
					System.out.println(" 5. Listado de cursos");
					System.out.println(" 6. Listado de convocatorias");
					System.out.println(" 7. Listado de notas");
					System.out.println(" 8. Listado de departamentos");
					System.out.println(" 0. SALIR");

					opcionn=sc.nextInt();

					if (opcionn==1) {
						datosTabla("alumnos");
					}
					if (opcionn==2) {
						datosTabla("personal");
					}
					if (opcionn==3) {
						datosTabla("materias");
					}
					if (opcionn==4) {
						datosTabla("aulas");
					}
					if (opcionn==5) {
						datosTabla("cursos");
					}
					if (opcionn==6) {
						datosTabla("convocatorias");
					}
					if (opcionn==7) {
						datosTabla("notas");
					}
					if (opcionn==8) {
						datosTabla("departamentos");
					}

				} while (opcionn!=0);
			}
		} while (opcion!=0);
	}
	/**
	 * menu del personal de secretaria. Permite matricular y consultar expedientes y programas escolares pero no gestiona el personal del centro.
	 */
	public void menuSecretaria() {
		int opcion=1;
		do {
			System.out.println();
			System.out.println("Seleccione una opción");
			System.out.println("--------------------");
			System.out.println(" 1. Gestión alumnos");
			System.out.println(" 2. Gestión de matrículas");
			System.out.println(" 3. Gestion aulas");
			System.out.println(" 4. Listados");
			System.out.println(" 0. SALIR");

			opcion=sc.nextInt();

			if (opcion==1) {
				int opcionn=1;
				do {
					System.out.println();
					System.out.println("Seleccione una opción");
					System.out.println("--------------------");
					System.out.println(" 1. Añadir alumno");
					System.out.println(" 2. Eliminar alumno");
					System.out.println(" 3. Modificar alumno");
					System.out.println(" 0. SALIR");

					opcionn=sc.nextInt();

					if (opcionn==1) {
						aniadirAlumno();
					}
					if (opcionn==2) {
						eliminarAlumno();
					}
					if (opcionn==3) {
						modificarAlumno();
					}

				} while (opcionn!=0);

			}
			if (opcion==2) {
				int opcionn=1;
				do {
					System.out.println();
					System.out.println("Seleccione una opción");
					System.out.println("--------------------");
					System.out.println(" 1. Eliminar matricula");
					System.out.println(" 2. Modificar matricula");
					System.out.println(" 0. SALIR");

					opcionn=sc.nextInt();

					if (opcionn==1) {
						eliminarMatricula();
					}
					if (opcionn==2) {
						modificarMatricula();
					}

				}while (opcionn!=0);
			}
			if (opcion==3) {
				int opcionn=1;
				do {
					System.out.println();
					System.out.println("Seleccione una opción");
					System.out.println("--------------------");
					System.out.println(" 1. Añadir aulas");
					System.out.println(" 2. Eliminar aulas");
					System.out.println(" 3. Modificar aulas");
					System.out.println(" 0. SALIR");

					opcionn=sc.nextInt();

					if (opcionn==1) {
						aniadirAula();
					}
					if (opcionn==2) {
						eliminarAula();
					}
					if (opcionn==3) {
						modificarAula();
					}

				} while (opcionn!=0);

			}
			if (opcion==4) {
				int opcionn=1;
				do {
					System.out.println();
					System.out.println("Seleccione una opción");
					System.out.println("--------------------");
					System.out.println(" 1. Listado de alumnos");
					System.out.println(" 2. Listado de materias");
					System.out.println(" 3. Listado de aulas");
					System.out.println(" 4. Listado de cursos");
					System.out.println(" 5. Listado de convocatorias");
					System.out.println(" 6. Listado de notas");
					System.out.println(" 7. Listado de departamentos");
					System.out.println(" 0. SALIR");

					opcionn=sc.nextInt();

					if (opcionn==1) {
						datosTabla("alumnos");
					}
					if (opcionn==2) {
						datosTabla("materias");
					}
					if (opcionn==3) {
						datosTabla("aulas");
					}
					if (opcionn==4) {
						datosTabla("cursos");
					}
					if (opcionn==5) {
						datosTabla("convocatorias");
					}
					if (opcionn==6) {
						datosTabla("notas");
					}
					if (opcionn==7) {
						datosTabla("departamentos");
					}

				} while (opcionn!=0);
			}
		} while (opcion!=0);
	}
	/**
	 * menu del profesorado. identifica mediante DNI que profesor se conectó para autorizarle en gestiones referentes a su curso asignado.
	 * por ejemplo, no podra consultar datos o notas de alumnos a los que no les da clase. Esto esta controlado mediante los metodos que ejecuta el menu.
	 */
	public void menuProfesorado() {
		System.out.println();
		System.out.println("introduce tu DNI");
		String dniprof=sc.next();
		int cursoprof=reconocerCurso(dniprof);
		System.out.println();
		System.out.println("la id del curso que tiene asignado es "+cursoprof);
		System.out.println();
		int opcion=1;
		do {
			System.out.println();
			System.out.println("Seleccione una opción");
			System.out.println("--------------------");
			System.out.println(" 1. Visualizar mis alumnos");
			System.out.println(" 2. Gestionar mis notas");
			System.out.println(" 3. Gestionar mis datos");
			System.out.println(" 0. SALIR");

			opcion=sc.nextInt();

			if (opcion==1) {
				mostrarAlumnos(dniprof);
			}
			if (opcion==2) {
				int opcionn=1;
				do {
					System.out.println();
					System.out.println("Seleccione una opción");
					System.out.println("--------------------");
					System.out.println(" 1. Visualizar notas");
					System.out.println(" 2. Añadir nota");
					System.out.println(" 3. Modificar nota");
					System.out.println(" 0. SALIR");

					opcionn=sc.nextInt();

					if (opcionn==1) {
						verNotas(cursoprof);
					}
					if (opcionn==2) {
						aniadirNotaProf(cursoprof);
					}
					if (opcionn==3) {
						modificarNotaProf(cursoprof);
					}

				} while (opcionn!=0);
			}
			if (opcion==3) {
				int opcionn=1;
				do {
					System.out.println();
					System.out.println("Seleccione una opción");
					System.out.println("--------------------");
					System.out.println(" 1. Ver datos personales");
					System.out.println(" 2. Modificar datos personales");
					System.out.println(" 0. SALIR");

					opcionn=sc.nextInt();

					if (opcionn==1) {
						mostrarDatos("personal","dni",dniprof);
					}
					if (opcionn==2) {

					}
				}while (opcionn!=0);
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
	/**
	 * @param user valor de usuario
	 * @param pw valor de contraseña
	 * @return rol rol de la persona que se ha logeado
	 * metodo que reconoce el rol correspondiente tras ingresar un usuario y contraseña
	 */
	public String reconocerRol(String user, String pw) {
		String rol="";
		if (conec != null) {
			try {
				String baseconsulta = "SELECT rol FROM usuarios WHERE usuario='"+user+"' and clave='"+pw+"'";
				Statement consulta=conec.createStatement();
				if(consulta.execute(baseconsulta)) {
					ResultSet retorno= consulta.getResultSet();
					while(retorno.next()) {
						rol = retorno.getString("rol");
						System.out.println("usuario reconocido");
					}
				}
				consulta.close();
			}catch (SQLException e) {
				System.err.println("usuario o contraseña erronea.\n" + e);
			}
		}
		return rol;
	}
	/**
	 * @param tabla tabla de referencia para la busqueda
	 * @param columna de referencia para la busqueda
	 * @param valor de referencia para la busqueda
	 * metodo que muestra los registros de una tabla dada que cumplan un valor dado en un campo dado
	 */
	public void mostrarDatos(String tabla, String columna, Object valor) {
		if (conec != null) {
			try {
				String baseconsulta = "SELECT * FROM "+tabla+" WHERE " + columna + " = ?";
				PreparedStatement consulta = conec.prepareStatement(baseconsulta);
				consulta.setObject(1, valor);

				ResultSet retorno = consulta.executeQuery();
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

				System.out.println("Registros encontrados correctamente");
				consulta.close();
			} catch (SQLException e) {
				System.err.println("Se ha producido un error al obtener los registros.\n" + e);
			} 
		}
	}
	/**
	 * @param valor dni del profesor
	 * metodo que visualiza los alumnos de un profesor en concreto introduciendo en el metodo el dni del profesor
	 */
	public void mostrarAlumnos(Object valor) {
		if (conec != null) {
			try {
				String baseconsulta = "SELECT * FROM alumnos "+
						" INNER JOIN matriculacion ON alumnos.matricula = matriculacion.matricula " +
						" INNER JOIN cursos ON matriculacion.curso = cursos.id " +
						" INNER JOIN personal ON cursos.tutor = personal.id " +
						" WHERE personal.id = (SELECT id FROM personal WHERE personal.dni = ?)";
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
			} 
		}
	}
	/**
	 * @return id primary key del curso asignado a ese profesor
	 * @param dni dni del profesor
	 * metodo que mediante el dni del profesor obtiene el curso que tiene asignado
	 */
	public int reconocerCurso(String dni) {
		int id=0;
		if (conec != null) {
			try {
				String baseconsulta = "SELECT cursos.id FROM cursos INNER JOIN personal ON cursos.tutor=personal.id WHERE personal.dni='"+dni+"';";
				Statement consulta = conec.createStatement();
				ResultSet salida= consulta.executeQuery(baseconsulta);
				if (salida.next()) {
	                id = salida.getInt(1);
	            }
				salida.close();
	            consulta.close();
			} catch (SQLException e) {
				System.err.println("Se ha producido un error al obtener los registros.\n" + e);
			} 
		}
		return id;
	}
	/**
	 * @param curso curso asignado al profesor
	 * menu que visualiza las notas de un profesor en concreto introduciendo el curso que tiene asignado
	 */
	public void verNotas(int curso) {
		if (conec != null) {
			try {
				String baseconsulta = "SELECT * FROM notas WHERE curso = "+curso;
				PreparedStatement consulta = conec.prepareStatement(baseconsulta);


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
			} 
		}
	}
	/**
	 * @return id primary key de la tabla referencia
	 * @param tabla tabla sobre la que realizar la busqueda
	 * metodo que devuelve el id del ultimo registro introducido en una tabla
	 */
	public int ultimoId(String tabla) {
	    int id = 0;
	    if (conec != null) {
	        try {
	            String baseconsulta = "SELECT MAX(id) FROM " + tabla;
	            Statement consulta = conec.createStatement();
	            ResultSet salida = consulta.executeQuery(baseconsulta);

	            if (salida.next()) {
	                id = salida.getInt(1);
	            }

	            salida.close();
	            consulta.close();
	        } catch (SQLException e) {
	            System.err.println("Se ha producido un error al obtener los registros.\n" + e);
	        }
	    }
	    return id;
	}
	/**
	 * @param tabla tabla de referencia
	 * @param columnaref columna de referencia
	 * @param valorref valor de referencia
	 * @param columnaMostrar dato que se desea consultar
	 * metodo al que se le da una tabla, columna y valor de referencia y la columna del dato que desee saber
	 */
	public void mostrarDatoConcreto(String tabla, String columnaref, Object valorref, String columnaMostrar) {
		if (conec != null) {
			try {
				String baseconsulta = "SELECT " + columnaref + ", " + columnaMostrar + " FROM " + tabla + " WHERE " + columnaref + " = ?";
				PreparedStatement consulta = conec.prepareStatement(baseconsulta);
				consulta.setObject(1, valorref);

				ResultSet retorno = consulta.executeQuery();

				// Imprimir los nombres de las columnas
				ResultSetMetaData basedatos = retorno.getMetaData();
				int cantidadColumnas = basedatos.getColumnCount();
				for (int i = 1; i <= cantidadColumnas; i++) {
					System.out.printf("%-30s", basedatos.getColumnName(i));
				}
				System.out.println();

				// Imprimir los datos de cada fila
				while (retorno.next()) {
					for (int i = 1; i <= cantidadColumnas; i++) {
						System.out.printf("%-30s", retorno.getObject(i));
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
	/**
	 * @param tabla tabla de referencia
	 * @param columna1 columna de referencia
	 * @param valor1 valor de referencia
	 * @param columna2 columna de referencia
	 * @param valor2 valor de referencia
	 * metodo para eliminar registros con dos columnas y valores de referencia (registros de doble primary key)
	 */
	public void eliminarRegistroDosRefs(String tabla, String columna1, Object valor1, String columna2, Object valor2) {
		if (conec != null) {
			try {
				String baseconsulta = "DELETE FROM " + tabla + " WHERE " + columna1 + " = ? AND " + columna2 + " = ?";
				PreparedStatement consulta = conec.prepareStatement(baseconsulta);
				consulta.setObject(1, valor1);
				consulta.setObject(2, valor2);

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
	 * @param datos string para la sentencia sql
	 * metodo que se llama al final de los cuestionarios y permite hacer inserts indicando la tabla y el string de datos que se genera del cuestionario
	 */
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
	/**
	 * @param tabla tabla de referencia
	 * @param columnaRef1 columna de referencia
	 * @param valorRef1 valor de referencia
	 * @param columnaRef2 columna de referencia
	 * @param valorRef2 valor de referencia
	 * @param nuevoValor1 valor a introducir en columnaRef1
	 * @param nuevoValor2 valor a introducir en columnaRef2
	 * metodo para modificar registros de tablas de relacionales con 2 primary keys. se le indica la tabla, las dos columnas de referencia, los 2 valores de referencia y los nuevos valores de referencia
	 */
	public void modificarTablaDosReferencias(String tabla, String columnaRef1, String columnaRef2, Object valorRef1, Object valorRef2, Object nuevoValor1, Object nuevoValor2) {
		if (conec != null) {
			try {
				String baseconsulta = "UPDATE " + tabla + " SET " + columnaRef1 + " = ?, " + columnaRef2 + " = ? WHERE " + columnaRef1 + " = ? AND " + columnaRef2 + " = ?";
				PreparedStatement consulta = conec.prepareStatement(baseconsulta);
				consulta.setObject(1, nuevoValor1);
				consulta.setObject(2, nuevoValor2);
				consulta.setObject(3, valorRef1);
				consulta.setObject(4, valorRef2);

				int filasAfectadas = consulta.executeUpdate();

				System.out.println("Se han modificado " + filasAfectadas + " registro(s) correctamente");

				consulta.close();
			} catch (SQLException e) {
				System.err.println("Se ha producido un error al modificar el registro.\n" + e);
			}
		}
	}
	/**
	 * @param tabla tabla de referencia
	 * @param columnaRef1 columna de referencia
	 * @param valorRef1 valor de referencia
	 * @param columnaRef2 columna de referencia
	 * @param valorRef2 valor de referencia
	 * @param columnaModificar columna a la que se le va a modificar el valor
	 * @param nuevoDato valor a introducir en columnaModificar
	 * metodo similar al anterior pero para modificar una columna distinta a la de los datos de referencia.
	 */
	public void modificarDatoDosReferencias(String tabla, String columnaRef1, String columnaRef2, Object valorRef1, Object valorRef2, String columnaModificar, Object nuevoDato) {
	    if (conec != null) {
	        try {
	            String baseconsulta = "UPDATE " + tabla + " SET " + columnaModificar + " = ? WHERE " + columnaRef1 + " = ? AND " + columnaRef2 + " = ?";
	            PreparedStatement consulta = conec.prepareStatement(baseconsulta);
	            consulta.setObject(1, nuevoDato);
	            consulta.setObject(2, valorRef1);
	            consulta.setObject(3, valorRef2);

	            int filasAfectadas = consulta.executeUpdate();

	            System.out.println("Se han modificado " + filasAfectadas + " registro(s) correctamente");

	            consulta.close();
	        } catch (SQLException e) {
	            System.err.println("Se ha producido un error al modificar el registro.\n" + e);
	        }
	    }
	}
	/**
	 * BLOQUE de metodos que realizan cuestionarios y luego crean un insert para la tabla correspondiente. hay uno por cada tabla.
	 */
	public void aniadirAlumno() {
		System.out.println();
		System.out.println("introduce la matricula");
		String matricula = sc.next();
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
		insertarDatos("alumnos", "(matricula, dni, nombre, apellido1, apellido2, cp, localidad, provincia, domicilio, telefono, email, fechanac, observaciones) "
				+ "VALUES ('"+matricula+"','"+dni+"','"+nombre+"','"+apellido1+"','"+apellido2+"','"+cp+"','"+localidad+"','"+provincia+"','"+domicilio+"','"+telefono+"','"+email+"','"+fechanac+"','"+observaciones+"')");

		System.out.println("introduce el id del curso en el que desea matricularse");
		String curso=sc.next();

		insertarDatos("matriculacion", "(curso, matricula) "
				+ "VALUES ('"+curso+"','"+matricula+"')");

	}
	
	public void aniadirPersonal() {
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
		System.out.println("introduce el telefono");
		String telefono = sc.next();
		System.out.println("introduce el email");
		String email = sc.next();
		System.out.println("introduce el cargo");
		sc.nextLine(); 
		String cargo = sc.nextLine();
		System.out.println("introduce la id del centro");
		String centro = sc.next();
		System.out.println("introduce la titulacion");
		sc.nextLine(); 
		String titulacion = sc.nextLine();
		System.out.println("introduce observaciones");
		sc.nextLine(); 
		String observaciones = sc.nextLine();
		System.out.println("introduce 1 si el empleado esta en activo o 0 si esta de baja");
		String activo = sc.next();
		System.out.println("introduce el id del departamento al que pertenece");
		String departamento = sc.next();
		insertarDatos("personal", "(dni, nombre, apellido1, apellido2, telefono, email, cargo, centro, titulacion, observaciones, l_activo, departamento)"
				+ "VALUES ('"+dni+"','"+nombre+"','"+apellido1+"','"+apellido2+"','"+telefono+"','"+email+"','"+cargo+"','"+centro+"','"+titulacion+"','"+observaciones+"','"+activo+"','"+departamento+"')");
	}
	
	public void aniadirMateria(){
		System.out.println();
		System.out.println("introduce el nombre");
		sc.nextLine();
		String nombre = sc.nextLine();
		System.out.println("introduce descripción");
		sc.nextLine();
		String descripcion = sc.nextLine();
		System.out.println("introduce nomenclatura");
		String nomenclatura = sc.next();
		System.out.println("introduce numero de horas");
		String horas = sc.next();
		System.out.println("introduce coste");
		String coste = sc.next();
		System.out.println("indica si esta disponible (1) o no disponible (0)");
		String activo=sc.next(); 
		System.out.println("introduce el id del departamento");
		int departamento=sc.nextInt();
		insertarDatos("materias", "(nombre, descripcion, nomenclatura, n_horas, coste, l_activo, departamento)"
				+ "VALUES ('"+nombre+"','"+descripcion+"','"+nomenclatura+"','"+horas+"','"+coste+"','"+activo+"','"+departamento+"')");

	}
	
	public void aniadirAula() {
		System.out.println();
		System.out.println("introduce el codigo");
		String codigo = sc.next();
		System.out.println("introduce la ubicacion");
		sc.nextLine();
		String ubicacion = sc.nextLine();
		System.out.println("introduce la capacidad");
		String capacidad = sc.next();
		System.out.println("indica si esta activa (1) o inactiva(0)");
		String activa = sc.next();
		System.out.println("introduce observaciones");
		sc.nextLine();
		String observaciones = sc.nextLine();
		insertarDatos("aulas", "(codigo, ubicacion, capacidad, l_activa, observaciones) "
				+ "VALUES ('"+codigo+"','"+ubicacion+"','"+capacidad+"','"+activa+"','"+observaciones+"')");

	}
	
	public void aniadirCurso() {
		
		try {
			System.out.println();
			System.out.println("introduce el nombre");
			sc.nextLine();
			String nombre = sc.nextLine();
			System.out.println("introduce el año de inicio");
			String anioini = sc.next();
			System.out.println("introduce el año de finalizacion");
			String aniofin = sc.next();
			System.out.println("cantidad maxima de alumnos");
			String maxalumnos = sc.next();
			System.out.println("introduce observaciones");
			sc.nextLine();
			String observaciones = sc.nextLine();
			System.out.println("indica el id del nivel educativo al que corresponde");
			String nivel = sc.next();
			System.out.println("indica el id del aula en la que se imparte");
			String aula = sc.next();
			System.out.println("indica el id del tutor asignado");
			String tutor = sc.next();
			insertarDatos("cursos", "(nombre, anioinicio, aniofin, maxalumnos, observaciones, nivel, aula, tutor) "
					+ "VALUES ('"+nombre+"','"+anioini+"','"+aniofin+"','"+maxalumnos+"','"+observaciones+"','"+nivel+"','"+aula+"','"+tutor+"')");

			int id=ultimoId("cursos");
			System.out.println("el ultimo id es "+id);
			insertarDatos("imparte", "(centro, curso) VALUES ('1','"+id+"')");

			System.out.println("introduce la cantidad de materias que tiene");
			int cantidad=sc.nextInt();
			for(int i=0;i<cantidad;i++) {
				String materia;
				System.out.println("introduce el id de la materia "+(i+1)+" (recuerda que la materia debe ser añadida previamente en la tabla 'materias'");
				materia=sc.next();
				insertarDatos("materiascurso", "(curso, materia) "
						+ "VALUES ('"+id+"','"+materia+"')");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("introduciste algun valor de forma incorrecta");
		}
	}
	
	public void aniadirConvocatoria() {
		System.out.println();
		System.out.println("introduce la descripción");
		sc.nextLine();
		String descripcion = sc.nextLine();
		System.out.println("indica si ordinaria (1) o extraordinaria (0)");
		String ordinaria = sc.next();
		System.out.println("introduce observaciones");
		sc.nextLine();
		String observaciones = sc.nextLine();
		System.out.println("indica id del curso");
		String curso = sc.next();
		insertarDatos("convocatorias", "(descripcion, l_ordinaria, observaciones, id_curso) "
				+ "VALUES ('"+descripcion+"','"+ordinaria+"','"+observaciones+"','"+curso+"')");
	}
	
	public void aniadirDepartamento() {
		System.out.println();
		System.out.println("introduce el nombre");
		sc.nextLine();
		String nombre = sc.nextLine();
		System.out.println("introduce la descripcion");
		sc.nextLine();
		String descripcion = sc.nextLine();
		System.out.println("introduce su codigo o abreviacion");
		String codigo = sc.next();
		System.out.println("introduce la rama");
		sc.nextLine();
		String rama = sc.nextLine();
		System.out.println("indica si esta activo (1) o inactivo(0)");
		String activo = sc.next();
		System.out.println("introduce observaciones");
		sc.nextLine();
		String observaciones = sc.nextLine();
		insertarDatos("departamentos", "(nombre, descripcion, codigo, rama, l_activo, observaciones) "
				+ "VALUES ('"+nombre+"','"+descripcion+"','"+codigo+"','"+rama+"','"+activo+"','"+observaciones+"')");
	}
		
	public void aniadirNota() {
		System.out.println();
		System.out.println("introduce el valor");
		String valor = sc.next();
		System.out.println("introduce id de la materia");
		String materia = sc.next();
		System.out.println("introduce id de la convocatoria");
		String convocatoria = sc.next();
		System.out.println("indica id del alumno");
		String alumno = sc.next();
		System.out.println("indica id del curso");
		String curso = sc.next();
		System.out.println("introduce observaciones");
		sc.nextLine();
		String observaciones = sc.nextLine();
		insertarDatos("notas", "(valor, materia, convocatoria, alumno,curso, observaciones) "
				+ "VALUES ('"+valor+"','"+materia+"','"+convocatoria+"','"+alumno+"','"+curso+"','"+observaciones+"')");

	}
	/**
	 * este metodo se ejecuta tras el metodo añadir alumno para conectar el alumno a un curso en concreto (tabla relacional)
	 */
	public void aniadirMatricula() {
		System.out.println();
		System.out.println("introduce la matricula del alumno");
		String matricula = sc.next();
		System.out.println("introduce el id del curso en el que se matricula");
		String curso = sc.next(); 
		insertarDatos("matriculacion", "(curso, matricula) "
				+ "VALUES ('"+curso+"','"+matricula+"')");

	}
	/**
	 * @param curso curso asignado al profesor
	 * este metodo usa el curso del profesor como dato fijo a la hora de añadir nota lo que evita que ponga notas de otros cursos que no le corresponden
	 */
	public void aniadirNotaProf(int curso) {
		System.out.println();
		System.out.println("introduce el valor");
		String valor = sc.next();
		System.out.println("introduce id de la materia");
		String materia = sc.next();
		System.out.println("introduce id de la convocatoria");
		String convocatoria = sc.next();
		System.out.println("indica id del alumno");
		String alumno = sc.next();
		System.out.println("introduce observaciones");
		sc.nextLine();
		String observaciones = sc.nextLine();
		insertarDatos("notas", "(valor, materia, convocatoria, alumno,curso, observaciones) "
				+ "VALUES ('"+valor+"','"+materia+"','"+convocatoria+"','"+alumno+"','"+curso+"','"+observaciones+"')");

	}
	/**
	 * este metodo se ejecuta tras el metodo añadir curso para conectar el curso a las materias que contiene (tabla relacional)
	 */
	public void asignarMaterias() {
		System.out.println();
		System.out.println("introduzca el id del curso");
		String id=sc.next();
		System.out.println("introduce la cantidad de materias que tiene");
		int cantidad=sc.nextInt();
		for(int i=0;i<cantidad;i++) {
			String materia;
			System.out.println("introduce el id de la materia "+(i+1)+" (recuerda que la materia debe ser añadida previamente en la tabla 'materias'");
			materia=sc.next();
			insertarDatos("materiascurso", "(curso, materia) "
					+ "VALUES ('"+id+"','"+materia+"')");
		}

	}
	/**
	 * BLOQUE de metodos que eliminan registros de la tabla indicada. hay uno por cada tabla.
	 * Debido a la existencia de multiples foreign keys, muchos de estos metodos no consiguen eliminar el registro por que la base de datos
	 * no te permite dejar ciertos campos inconexos ya que son fundamentales para la trazabilidad de otros registros, pero el metodo funciona
	 */
	public void eliminarAlumno() {
		int res=1;
		do {
			System.out.println();
			System.out.println("Seleccione una opción");
			System.out.println("--------------------");
			System.out.println("1.Eliminar por id");
			System.out.println("2.Eliminar por matricula");
			System.out.println("0.SALIR");

			res=sc.nextInt();

			if (res==1) {
				System.out.println();
				System.out.println("introduzca la id del alumno");
				String id=sc.next();
				eliminarRegistro("alumnos","id",id);
			}
			if (res==2) {
				System.out.println();
				System.out.println("introduzca la matricula del alumno");
				String matricula=sc.next();
				eliminarRegistro("alumnos","matricula",matricula);
			}

		} while (res!=0);
	}
	
	public void eliminarPersonal() {
		int res=1;
		do {
			System.out.println();
			System.out.println("Seleccione una opción");
			System.out.println("--------------------");
			System.out.println("1.Eliminar por id");
			System.out.println("2.Eliminar por dni");
			System.out.println("0.SALIR");

			res=sc.nextInt();

			if (res==1) {
				System.out.println("introduzca la id del trabajador");
				String id=sc.next();
				eliminarRegistro("personal","id",id);
			}
			if (res==2) {
				System.out.println("introduzca el dni del trabajador");
				String dni=sc.next();
				eliminarRegistro("personal","dni",dni);
			}

		} while (res!=0);
	}
	
	public void eliminarMateria() {
		System.out.println();
		System.out.println("introduzca la id de la materia que desea eliminar");
		String id=sc.next();
		eliminarRegistro("materias","id",id);
	}

	public void eliminarAula() {
		int res=1;
		do {
			System.out.println();
			System.out.println("Seleccione una opción");
			System.out.println("--------------------");
			System.out.println("1.Eliminar por id");
			System.out.println("2.Eliminar por codigo");
			System.out.println("0.SALIR");

			res=sc.nextInt();

			if (res==1) {				
				System.out.println();
				System.out.println("introduzca la id del aula");
				String id=sc.next();
				eliminarRegistro("aulas","id",id);
			}
			if (res==2) {
				System.out.println();
				System.out.println("introduzca el codigo del aula");
				String matricula=sc.next();
				eliminarRegistro("aulas","codigo",matricula);
			}
		}while (res!=0);
	}

	public void eliminarCurso() {
		System.out.println();
		System.out.println("introduzca el id del curso que desea eliminar");
		String id=sc.next();
		eliminarRegistro("cursos","id",id);
	}

	public void eliminarDepartamento() {
		System.out.println();
		System.out.println("introduzca el id del departamento que desea eliminar");
		String id=sc.next();
		eliminarRegistro("departamentos","id",id);
	}

	public void eliminarMatricula() {
		System.out.println();
		System.out.println("introduzca el curso del registro que desea eliminar");
		String curso=sc.next();
		System.out.println("introduzca la matricula del registro que desea eliminar");
		String matricula=sc.next();
		eliminarRegistroDosRefs("matriculacion","curso",curso,"matricula",matricula);

	}

	public void eliminarConvocatoria() {
		System.out.println();
		System.out.println("introduzca el id de la convocatoria que desea eliminar");
		String id=sc.next();
		eliminarRegistro("convocatorias","id",id);
	}
	/**
	 * BLOQUE de metodos que modifican datos de los registros indicandole la tabla, columna, valor de referencia y nuevo valor a modificar
	 */
	public void modificarAlumno() {
		int res=1;
		do {
			System.out.println();
			System.out.println("Seleccione una opción");
			System.out.println("--------------------");
			System.out.println("1.Seleccionar por id");
			System.out.println("2.Seleccionar por matricula");
			System.out.println("0.SALIR");

			res=sc.nextInt();

			if (res==1) {
				System.out.println("introduzca la id del alumno");
				String id=sc.next();
				System.out.println("introduce el nombre de la columna que desea modificar");
				String columna=sc.next();
				System.out.println("introduce el nuevo valor");
				sc.nextLine();
				String valor=sc.nextLine();
				modificarRegistro("alumnos","id",id,columna,valor);
			}
			if (res==2) {
				System.out.println("introduzca la matricula del alumno");
				String matricula=sc.next();
				System.out.println("introduce el nombre de la columna que desea modificar");
				String columna=sc.next();
				System.out.println("introduce el nuevo valor");
				sc.nextLine();
				String valor=sc.nextLine();
				modificarRegistro("alumnos","matricula",matricula,columna,valor);
			}

		} while (res!=0);

	}
	
	public void modificarPersonal() {
		int res=1;
		do {
			System.out.println();
			System.out.println("Seleccione una opción");
			System.out.println("--------------------");
			System.out.println("1.Seleccionar por id");
			System.out.println("2.Seleccionar por dni");
			System.out.println("0.SALIR");

			res=sc.nextInt();

			if (res==1) {
				System.out.println("introduzca la id del trabajador");
				String id=sc.next();
				System.out.println("introduce el nombre de la columna que desea modificar");
				String columna=sc.next();
				System.out.println("introduce el nuevo valor");
				sc.nextLine();
				String valor=sc.nextLine();
				modificarRegistro("personal","id",id,columna,valor);
			}
			if (res==2) {
				System.out.println("introduzca el dni del trabajador");
				String dni=sc.next();
				System.out.println("introduce el nombre de la columna que desea modificar");
				String columna=sc.next();
				System.out.println("introduce el nuevo valor");
				sc.nextLine();
				String valor=sc.nextLine();
				modificarRegistro("personal","dni",dni,columna,valor);
			}
		} while (res!=0);

	}

	public void modificarMateria() {
		System.out.println();
		System.out.println("introduce la id de la materia de la que desea modificar los datos");
		String id = sc.next();
		System.out.println("introduce el nombre de la columna que desea modificar");
		String columna=sc.next();
		System.out.println("introduce el nuevo valor");
		sc.nextLine();
		String valor=sc.nextLine();
		modificarRegistro("materias","id",id,columna,valor);
	}

	public void modificarAula() {
		int res=1;
		do {
			System.out.println();
			System.out.println("Seleccione una opción");
			System.out.println("--------------------");
			System.out.println("1.Seleccionar por id");
			System.out.println("2.Seleccionar por codigo");
			System.out.println("0.SALIR");

			res=sc.nextInt();

			if (res==1) {
				System.out.println();
				System.out.println("introduzca la id del aula");
				String id=sc.next();
				System.out.println("introduce el nombre de la columna que desea modificar");
				String columna=sc.next();
				System.out.println("introduce el nuevo valor");
				sc.nextLine();
				String valor=sc.nextLine();
				modificarRegistro("aulas","id",id,columna,valor);
			}
			if (res==2) {
				System.out.println();
				System.out.println("introduzca el codigo del aula");
				String codigo=sc.next();
				System.out.println("introduce el nombre de la columna que desea modificar");
				String columna=sc.next();
				System.out.println("introduce el nuevo valor");
				sc.nextLine();
				String valor=sc.nextLine();
				modificarRegistro("aulas","codigo",codigo,columna,valor);
			}
		}while (res!=0);

	}

	public void modificarCurso() {
		System.out.println();
		System.out.println("introduzca el id del curso");
		String id=sc.next();
		System.out.println("introduce el nombre de la columna que desea modificar");
		String columna=sc.next();
		System.out.println("introduce el nuevo valor");
		sc.nextLine();
		String valor=sc.nextLine();
		modificarRegistro("cursos","id",id,columna,valor);
	}

	public void modificarDepartamento() {
		System.out.println();
		System.out.println("introduzca el id del departamento");
		String id=sc.next();
		System.out.println("introduce el nombre de la columna que desea modificar");
		String columna=sc.next();
		System.out.println("introduce el nuevo valor");
		sc.nextLine();
		String valor=sc.nextLine();
		modificarRegistro("departamentos","id",id,columna,valor);
	}

	public void modificarNota() {
		System.out.println();
		System.out.println("introduzca el id de la nota");
		String id=sc.next();
		System.out.println("introduce el nombre de la columna que desea modificar");
		String columna=sc.next();
		System.out.println("introduce el nuevo valor");
		sc.nextLine();
		String valor=sc.nextLine();
		modificarRegistro("notas","id",id,columna,valor);
	}

	public void modificarMatricula() {
		System.out.println();
		System.out.println("introduzca la matricula del alumno");
		String matricula = sc.next();
		System.out.println("introduce el id del curso en el que se realizo la matriculacion incorrecta");
		String curso=sc.next();
		System.out.println("introduce el id del curso en el que se desea matricular");
		String cursocorrecto=sc.next();
		modificarTablaDosReferencias("matriculacion","curso","matricula",curso,matricula,cursocorrecto,matricula);
	}

	public void modificarConvocatoria() {
		System.out.println();
		System.out.println("introduzca el id de la convocatoria");
		String id=sc.next();
		System.out.println("introduce el nombre de la columna que desea modificar");
		String columna=sc.next();
		System.out.println("introduce el nuevo valor");
		sc.nextLine();
		String valor=sc.nextLine();
		modificarRegistro("convocatorias","id",id,columna,valor);
	}
	/**
	 * @param curso curso asignado al profesor
	 * este metodo modifica notas con el valor de curso fijo, asi se evita que el profesor pueda modificar notas de cursos que no le corresponden
	 */
	public void modificarNotaProf(int curso) {
		System.out.println();
		System.out.println("introduzca el id de la nota");
		String id=sc.next();
		System.out.println("introduce el nombre de la columna que desea modificar");
		String columna=sc.next();
		System.out.println("introduce el nuevo valor");
		sc.nextLine();
		String valor=sc.nextLine();
		modificarDatoDosReferencias("Notas","id","curso",id,curso,columna, valor);
	}
	/**
	 * @param dni dni del profesor
	 * este metodo permite modificar sus propios datos al profesor, basandose en el dni introducido al logear
	 */
	public void modificarDatosPersonales(String dni) {
		System.out.println();
		System.out.println("introduce el nombre de la columna que desea modificar");
		String columna=sc.next();
		System.out.println("introduce el nuevo valor");
		sc.nextLine();
		String valor=sc.nextLine();
		modificarRegistro("personal","dni",dni,columna,valor);
	}
}
