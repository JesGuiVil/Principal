package vehiculoFicheros;

import java.util.Scanner;
import java.io.*;
public class vehiculoFichero {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		FileOutputStream creacion= null;
		DataOutputStream contenido = null;
		FileInputStream lectura = null;
		DataInputStream leer= null;
		
		try {
			creacion = new FileOutputStream("archivos/vehiculos.txt", true);
			contenido = new DataOutputStream(creacion);
			System.out.println("introduce matricula");
			contenido.writeUTF(sc.next());
			System.out.println("introduce marca");
			contenido.writeUTF(sc.next());
			System.out.println("introduce tamaño deposito");
			contenido.writeDouble(sc.nextDouble());
			System.out.println("introduce modelo");
			contenido.writeUTF(sc.next());
			
			lectura= new FileInputStream("archivos/vehiculos.txt");
			leer = new DataInputStream(lectura);

			while(lectura.available()>0) {
				System.out.print(leer.readUTF()+", ");
				System.out.print(leer.readUTF()+", ");
				System.out.print(leer.readDouble()+", ");
				System.out.print(leer.readUTF());
				System.out.println();
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch (EOFException e) {
			System.out.println(e.getMessage());
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(creacion != null) {
					contenido.close();
					creacion.close();	
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
