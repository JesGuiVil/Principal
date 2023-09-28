package Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;
		
		public class Ejercicio3 {
			
		static Scanner sc = new Scanner(System.in);
		
		public static void main(String[] args) {
			
		int nuevoValor = -1;
		int posicion = -1;
		String cadena = "";
		int cont = 1;
		int[] valores = {2, -4, -23, 0, 44, -14, 27, 13, -303, 35}; 
		while (cont <= 5) {
			  try {
			    System.out.println("\n");
			    System.out.println("Iteración " + cont);
			    System.out.println("Array 'valores' antes de modificación:");
			    show(valores);
			    System.out.println("\n");
			    System.out.println("Introduce la posición del array 'valores' a modificar:");
			    cadena = sc.next();
			    posicion = Integer.parseInt(cadena);
			    System.out.println("Introduce el nuevo valor de la posición " + posicion + ": ");
			    nuevoValor = sc.nextInt();
			    valores[posicion] = nuevoValor;
			    System.out.println("Posición que se modifica " + posicion);
			    System.out.println("Nuevo valor introducido: " + nuevoValor);
			    System.out.println("Array 'valores' modificado:");
			    show(valores);
			    System.out.println("\n-----------");
			  } catch (ArrayIndexOutOfBoundsException e) {
			    System.out.println("La posición introducida es mayor que el tamaño del array.");
			  } catch (InputMismatchException e) {
			    System.out.println("Se ha introducido una letra en vez de un número.");
			    sc.nextLine();
			  } finally {
			    sc.nextLine();
			    nuevoValor = -1;
			    posicion = -1;
			    cont++;
			  }
		}
			}

		
		private static void show(int[] valores) {
		for (int i = 0; i < valores.length; i++) {
		System.out.printf("%s ", valores[i]);
		}
	} // Fin método show

}


