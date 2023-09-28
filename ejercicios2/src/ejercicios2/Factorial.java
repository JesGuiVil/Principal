package ejercicios2;
import java.util.Scanner;
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//determina el factorial de un numero
		Scanner leer = new Scanner (System.in);
		double i, aux=0, n;
		System.out.println("Introduce el numero");
		n = leer.nextInt();
		double f=1;
		aux=n;
		for (i=1; i<aux; i++) {
			f=f*n;
			n=n-1;
		}
		System.out.println("el factorial es "+f);
	}
} 