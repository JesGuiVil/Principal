package Excepciones;

	import java.sql.SQLException;
import java.util.ArrayList;
	
	public class Ejericio2 {
		
	    public static void main(String[] args) throws SQLException {
	        ArrayList<String> ibans = new ArrayList<String>();
	        SimuladorBaseDatosBanco bd = new SimuladorBaseDatosBanco();
	        int i = 0;
	        while (i < 50) {
	            String iban = obtenerIban(bd);
	            try {
	                comprobarIban(iban);
	                ibans.add(iban);
	                i++;
	            } catch (MiExcepcion e) {
	                System.out.println("Error al añadir el IBAN " + iban + " al ArrayList: " + e.getMessage());
	            }
	        }
	        System.out.println("Lista de IBANs:");
	        for (String iban : ibans) {
	            System.out.println(iban);
	        }
	    }
	    
	    private static String obtenerIban(SimuladorBaseDatosBanco bd) throws SQLException {
	        String iban = null;
	        try {
	            bd.conectarBaseDeDatos();
	            iban = bd.obtenerIbanDeBaseDeDatos();
	        } catch (Exception e) {
	            System.out.println("Error al obtener el IBAN de la base de datos: " + e.getMessage());
	        } finally {
	            bd.desconectarBaseDeDatos();
	        }
	        return iban;
	    }
	    
	    private static void comprobarIban(String iban) throws MiExcepcion {
	        if (iban == null) {
	            throw new MiExcepcion("El IBAN es nulo");
	        }
	        if (iban.length() != 16) {
	            throw new MiExcepcion("El IBAN tiene una longitud incorrecta: " + iban.length());
	        }
	    }
	}
