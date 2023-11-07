package controlador;

import java.util.ArrayList;
import java.util.Scanner;

public class MetodosLambda {
	Scanner sc=new Scanner(System.in);
	public ArrayList solicitaLista() {
		ArrayList lista=new ArrayList();
		int cantidad=0;
		String scantidad;
		boolean correcto=false;
		do {
			System.out.println("¿Cuántos números quiere insertar?");
			scantidad=sc.next();
			try {
				cantidad=Integer.parseInt(scantidad);
				correcto=true;
			} catch (NumberFormatException e) {
				System.out.println("Por favor, introduzca un número válido");
			}	
		}while(!correcto);
		for(int i=0; i<cantidad;i++) {
			System.out.println("introduzca el numero "+(i+1));
			scantidad=sc.next();
			do {
				try {
					cantidad=Integer.parseInt(scantidad);
					correcto=false;
					lista.add(cantidad);
				} catch (NumberFormatException e) {
					System.out.println("Por favor, introduzca un número válido");
				}
			}while(correcto);
		}
		return lista;
	}

}
