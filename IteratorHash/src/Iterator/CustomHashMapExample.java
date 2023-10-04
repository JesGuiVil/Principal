package Iterator;

import java.util.HashMap;
import java.util.Scanner;

public class CustomHashMapExample {
	public static void main(String[] args) {
		int hashMapSize = 12; // Tamaño fijo del HashMap
		HashMap<Integer, Integer> customHashMap = new HashMap<>(hashMapSize);

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("Ingrese un número: ");
			int numero = scanner.nextInt();

			// Utiliza tu función hash personalizada aquí para determinar la posición en el HashMap
			int posicion = customHashFunction(numero, hashMapSize);

			customHashMap.put(posicion, numero);
			System.out.println("Número " + numero + " agregado en la posición " + posicion);

			System.out.print("¿Desea agregar otro número? (s/n): ");
			String continuar = scanner.next();

			if (!continuar.equalsIgnoreCase("s")) {
				break;
			}
		}

		// Mostrar el contenido del HashMap
		System.out.println("Contenido del HashMap:");
		for (int key : customHashMap.keySet()) {
			int value = customHashMap.get(key);
			System.out.println("Clave: " + key + ", Valor: " + value);
		}

		scanner.close();
	}

	// Función hash personalizada
	public static int customHashFunction(int numero, int tamanio) {
		int posicion=numero%tamanio;
		return posicion;
	}
}
