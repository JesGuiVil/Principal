package messageDigest;


import java.io.*;

public class Cifrar {
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

            // Abrir el archivo para escritura (esto reemplazará el contenido existente)
            FileWriter fileWriter = new FileWriter(ruta);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(password);
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
            if (respuesta.equals(contenidoArchivo)) {
                System.out.println("La contraseña coincide.");
            } else {
                System.out.println("La contraseña no coincide.");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
