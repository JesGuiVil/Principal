package messageDigest;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class digest {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String password;
        String ruta;
        String respuesta;

        try {
            System.out.println("Establezca la contraseña:");
            password = reader.readLine();
            System.out.println("Introduzca la ruta de destino:");
            ruta = reader.readLine();

            // Cifrar la contraseña antes de guardarla en el archivo
            String hashedPassword = null;
			try {
				hashedPassword = hashPassword(password);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            // Abrir el archivo para escritura (esto reemplazará el contenido existente)
            FileWriter fileWriter = new FileWriter(ruta);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(hashedPassword);
            bufferedWriter.newLine(); // Agregar una nueva línea para separar contraseñas
            bufferedWriter.close();

            System.out.println("Contraseña guardada en " + ruta);
            System.out.println("Introduzca la contraseña guardada en el archivo:");
            respuesta = reader.readLine();

            // Abrir el archivo y leer su contenido
            FileReader fileReader = new FileReader(ruta);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String contenidoArchivo = bufferedReader.readLine(); // Leer la única línea del archivo
            bufferedReader.close();

            // Comparar el contenido del archivo con la cadena respuesta
            try {
				if (checkPassword(respuesta, contenidoArchivo)) {
				    System.out.println("La contraseña coincide.");
				} else {
				    System.out.println("La contraseña no coincide.");
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método para cifrar la contraseña utilizando MessageDigest
    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedPassword = md.digest(password.getBytes());
        StringBuilder hexPassword = new StringBuilder();

        for (byte b : hashedPassword) {
            hexPassword.append(String.format("%02x", b));
        }

        return hexPassword.toString();
    }

    // Método para comparar contraseñas cifradas
    private static boolean checkPassword(String inputPassword, String hashedPassword) throws NoSuchAlgorithmException {
        String inputHash = hashPassword(inputPassword);
        return inputHash.equals(hashedPassword);
    }
}
