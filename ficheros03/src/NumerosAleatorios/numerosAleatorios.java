package NumerosAleatorios;
import java.io.*;
import java.util.Scanner;
public class numerosAleatorios {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int tamanio,i;
		String ruta;
		System.out.println("introduzca la cantidad de numeros random");
		tamanio=sc.nextInt();
		System.out.println("introduzca la ruta de destino");	
		ruta=sc.next();

		FileOutputStream creacion = null;
		DataOutputStream contenido = null;
		FileInputStream lectura = null;
		DataInputStream leer= null;
		try {
			creacion = new FileOutputStream(ruta, true);
			contenido = new DataOutputStream(creacion);
			for (i=0; i<tamanio; i++) {
				int numero = (int) (Math.random()*100);
				contenido.writeInt(numero);
			}
			lectura= new FileInputStream(ruta);
			leer = new DataInputStream(lectura);

			while(lectura.available()>0) {
				System.out.println(leer.readInt());
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
