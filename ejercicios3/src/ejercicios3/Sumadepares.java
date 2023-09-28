package ejercicios3;
import java.util.Scanner;
public class Sumadepares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long res=0, resto=0, n; 
		Scanner leer = new Scanner (System.in);
		System.out.println("Introduce el número");
		n = leer.nextInt();
		while (n>0) {
			resto=n%10;
			n=n/10;
			if (resto%2==0) {
			res=res+resto;
			System.out.print(resto+" es par, ");
			}
		}
		System.out.println(" su suma es "+res);
	}
} 