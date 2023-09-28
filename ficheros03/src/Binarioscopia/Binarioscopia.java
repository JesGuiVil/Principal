package Binarioscopia;

import java.io.*;

public class Binarioscopia {

	public static void main(String[] args) {
		FileOutputStream creacion = null;
		DataOutputStream contenido = null;
		FileInputStream origen = null;
        FileOutputStream destino = null;

        String rutaOrigen = "archivos/origen.dat";
        String rutaDestino = "archivos/destino.dat";

        try {
        	creacion = new FileOutputStream("archivos/origen.dat");
        	contenido = new DataOutputStream(creacion);
        	contenido.writeInt(2023);
            origen = new FileInputStream(rutaOrigen);
            destino = new FileOutputStream(rutaDestino);
            byte[] buffer = new byte[origen.available()];

            origen.read(buffer);
            destino.write(buffer);
        } catch (FileNotFoundException ex) {
        	System.out.println(ex.getMessage());
        }catch (EOFException e) {
        	System.out.println(e.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
            	if(destino != null) destino.close();
            	if(origen != null) origen.close();
            	if(creacion != null) creacion.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}
}
