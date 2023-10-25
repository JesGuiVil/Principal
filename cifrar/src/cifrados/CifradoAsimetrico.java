package cifrados;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
public class CifradoAsimetrico {

	private static PublicKey publicKey;
	private static PrivateKey privateKey;

	public static void main(String[] args) {
		generarKeysAsimetrica();

		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("Menú:");
			System.out.println("1. Cifrar mensaje");
			System.out.println("2. Descifrar mensaje");
			System.out.println("3. Regenerar clave pública y privada");
			System.out.println("4. Salir");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Consume la nueva línea
			
			switch (opcion) {
			case 1:
				System.out.print("Ingrese el mensaje a cifrar: ");
				String mensajeSinCifrar = scanner.nextLine();
				String mensajeCifrado = cifrarAsimetrico(mensajeSinCifrar);
				System.out.println("Mensaje cifrado: " + mensajeCifrado);
				break;
			case 2:
				System.out.print("Ingrese el mensaje cifrado: ");
				String textoCifrado = scanner.nextLine();
				String mensajeDescifrado = descifrarAsimetrico(textoCifrado);
				System.out.println("Mensaje descifrado: " + mensajeDescifrado);
				break;
			case 3:
				generarKeysAsimetrica();
				System.out.println("Nuevas claves públicas y privadas generadas.");
				break;
			case 4:
				System.out.println("Saliendo del programa.");
				break;
			default:
				System.out.println("Opción no válida. Intente de nuevo.");
			}
		} while (opcion != 4);
	}

	public static void generarKeysAsimetrica() {
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048); // Tamaño de clave, puedes ajustarlo si es necesario
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			publicKey = keyPair.getPublic();
			privateKey = keyPair.getPrivate();
			System.out.println("Claves públicas y privadas generadas.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String cifrarAsimetrico(String mensajeSinCifrar) {
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] mensajeCifrado = cipher.doFinal(mensajeSinCifrar.getBytes());
			return  Base64.getEncoder().encodeToString(mensajeCifrado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String descifrarAsimetrico(String textoCifrado) {
	    try {
	        Cipher cipher = Cipher.getInstance("RSA");
	        cipher.init(Cipher.DECRYPT_MODE, privateKey);
	        byte[] mensajeCifrado = Base64.getDecoder().decode(textoCifrado); // Decodificar Base64
	        byte[] mensajeDescifrado = cipher.doFinal(mensajeCifrado);
	        return new String(mensajeDescifrado);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}


