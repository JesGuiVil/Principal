package utiles;
import java.util.Scanner;

public class Cambianombre {

	public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Introduce tu nombre y apellidos (tres palabras):");
	        String nombrecompleto = scanner.nextLine();
	        String[] palabras = nombrecompleto.split(" ");
	        String nombrefinal ="";

	        for(String palabra : palabras) {
	            String primeraletra = palabra.substring(0, 1).toUpperCase();
	            String resto = palabra.substring(1).toLowerCase();
	            nombrefinal += primeraletra + resto + " ";
	        }
	        System.out.println(nombrefinal);
	    }

	}


