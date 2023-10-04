package messageDigest;


import java.io.*;

public class cifrar {

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

			FileWriter fileWriter = new FileWriter(ruta, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(password);
			bufferedWriter.newLine(); // Agregar una nueva línea para separar contraseñas

			bufferedWriter.close();

			System.out.println("Contraseña guardada en " + ruta);
			System.out.println("Introduzca la contraseña guardada en el archivo:");

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
