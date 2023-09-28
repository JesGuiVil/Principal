package objetos2;

import java.util.Scanner;

public class testPersonas {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		PERSONA[] personas = new PERSONA[4];
		String nombre = "", dir = "", ciudad = "", fn="";
		int codigopostal;
		for (int i = 0; i <4; i++) {
			System.out.println("introduce el nombre de la persona " + (i + 1));
			nombre = leer.nextLine();
			System.out.println("introduce la dirección de la persona " + (i + 1));
			dir = leer.nextLine();
			System.out.println("introduce la ciudad de la persona " + (i + 1));
			ciudad = leer.nextLine();
			System.out.println("introduce el CP de la persona " + (i + 1));
			codigopostal = leer.nextInt();
			System.out.println("introduce la fecha de nacimiento de la persona "+(i+1)+" en formato dd/mm/aaaa");
			fn=leer.nextLine();
			fn=leer.nextLine();
			String[] dma=fn.split("/");
			personas[i] = new PERSONA(nombre, dir, codigopostal, ciudad, new FECHA(Integer.parseInt(dma[0]), Integer.parseInt(dma[1]), Integer.parseInt(dma[2])));
		}
		for (int i = 0; i <4; i++) {
			System.out.println(personas[i]);
		}	
		personas[0].esMayorDeEdad();
	}
}
