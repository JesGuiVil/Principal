package Excepciones;

	import java.sql.SQLException;
	import java.util.Random;
	
	public class SimuladorBaseDatosBanco {
	private final static String ERROR_TAMANIO = "ErrorTam";
	private final static String ERROR_SQL = "ErrorSql";
	private final static String ERROR_NULL = "ErrorNull";
	private final static String NO_ERROR = "NoError";
	public static boolean isConnected = false;
	
	public SimuladorBaseDatosBanco() {
	}

	public void conectarBaseDeDatos() throws SQLException, ClassNotFoundException
	{

	isConnected = true;
	}

	public void desconectarBaseDeDatos() throws SQLException {

	isConnected = false;
	}

	public String obtenerIbanDeBaseDeDatos() throws SQLException {
	if (!isConnected) {
	throw new SQLException("No se ha establecido conexión a la base de datos.");
	}

	Random rand = new Random();
	String card = "ES";
	String iban = "";
	boolean errorNull = false;
	boolean errorSql = false;
	boolean errorTam = false;
	for (int i = 0; i < 14; i++) {
	int n = rand.nextInt(0, 10);
	card += Integer.toString(n);
	}

	String errorAleatorio = obtenerErrorAleatorio();
	if (ERROR_TAMANIO.equals(errorAleatorio)) {
	errorTam = true;
	} else if (ERROR_SQL.equals(errorAleatorio)) {
	errorSql = true;
	} else if (ERROR_NULL.equals(errorAleatorio)) {
	errorNull = true;
	}
	for (int i = 0; i < 16; i++) {
	if (errorNull) {
	return null; 
	} else if (errorSql) {
	throw new SQLException("Error accediendo a Base de Datos");
	} else {
	iban = iban.concat(card.charAt(i) + "");
	}
	}
	if (errorTam) {
	iban = iban.substring(2); // Error en el IBAN no es de tamaño 16
	}
	return iban;
	}

	private static String obtenerErrorAleatorio() {
	Random randError = new Random();
	int e = randError.nextInt(0, 51);
	if (e > 0 && e <= 5) {
	return ERROR_TAMANIO;
	}
	if (e > 5 && e <= 10) {
	return ERROR_SQL;
	}
	if (e > 10 && e <= 15) {
	return ERROR_NULL;
	}
	return NO_ERROR;
	}
	
}
