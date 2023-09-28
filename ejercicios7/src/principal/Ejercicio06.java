package principal;
import java.util.Scanner;
import ejercicios7.funciones;
public class Ejercicio06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer= new Scanner(System.in);
		String  respuesta;
		String n;
		int numero=0;
	System.out.println("¿que tipo de numero quieres transformar?(binario, decimal, hexadecimal o octal)");	
	respuesta=leer.next();
	System.out.println("introduce el número");	
	n=leer.next();	
		if(respuesta.equals("binario")) {
			System.out.println("el numero en decimal es "+funciones.binarioadecimal(n));	
			System.out.println("el numero en hexadecimal es "+funciones.decimalahexadecimal(funciones.binarioadecimal(n)));
			System.out.println("el numero en octal es "+funciones.decimalaoctal(funciones.binarioadecimal(n)));
		}
		if(respuesta.equals("decimal")) {
			numero=Integer.parseInt(n);
			System.out.println("el numero en binario es "+funciones.decimalabinario(numero));	
			System.out.println("el numero en hexadecimal es "+funciones.decimalahexadecimal(numero));
			System.out.println("el numero en octal es "+funciones.decimalaoctal(numero));
		}
		if(respuesta.equals("hexadecimal")) {
			System.out.println("el numero en decimal es "+funciones.hexadecimaladecimal(n));
			System.out.println("el numero en binario es "+funciones.decimalabinario(funciones.hexadecimaladecimal(n)));	
			System.out.println("el numero en octal es "+funciones.decimalaoctal(funciones.hexadecimaladecimal(n)));
		}
		if(respuesta.equals("octal")) {
			System.out.println("el numero en decimal es "+funciones.octaladecimal(n));
			System.out.println("el numero en binario es "+funciones.decimalabinario(funciones.octaladecimal(n)));	
			System.out.println("el numero en hexadecimal es "+funciones.decimalahexadecimal(funciones.octaladecimal(n)));
		}	
	}//69103
}