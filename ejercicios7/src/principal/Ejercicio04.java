package principal;
import java.util.Scanner;
import ejercicios7.funciones;
public class Ejercicio04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer= new Scanner(System.in);
		int n;
	System.out.println("introduce el numero que quieres pasar a binario");	
	n=leer.nextInt();
	System.out.println("el numero en binario es "+funciones.decimalabinario(n));
	}
}
