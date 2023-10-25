package cifrados;

import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class CifradoSimetrico {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Tienes una clave? (si/no): ");
        String respuesta = scanner.nextLine();

        SecretKey secretKey;

        if (respuesta.equalsIgnoreCase("si")) {
            System.out.print("Introduce la clave: ");
            String claveStr = scanner.nextLine();
            secretKey = new SecretKeySpec(claveStr.getBytes(), "AES");

        } else {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            secretKey = keyGenerator.generateKey();
            System.out.println("Clave generada automáticamente.");
        }

        System.out.print("Introduce un mensaje: ");
        String mensaje = scanner.nextLine();

        String mensajeEncriptado = cifrarSimetrico(secretKey, mensaje);
        System.out.println("Mensaje encriptado: " + mensajeEncriptado);

        String mensajeDesencriptado = descifrarSimetrico(secretKey, mensajeEncriptado);
        System.out.println("Mensaje desencriptado: " + mensajeDesencriptado);

        scanner.close();
    }

    public static String cifrarSimetrico(SecretKey secretKey, String mensaje) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] mensajeEncriptado = cipher.doFinal(mensaje.getBytes());
        return Base64.getEncoder().encodeToString(mensajeEncriptado);
    }

    public static String descifrarSimetrico(SecretKey secretKey, String mensajeEncriptado) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] mensajeDesencriptado = cipher.doFinal(Base64.getDecoder().decode(mensajeEncriptado));
        return new String(mensajeDesencriptado);
    }
}
