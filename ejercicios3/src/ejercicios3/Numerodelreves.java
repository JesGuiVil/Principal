package ejercicios3;
import java.util.Scanner;
public class Numerodelreves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=0, resto=0, n; 
		Scanner leer = new Scanner (System.in);
		System.out.println("Introduce el número");
		n = leer.nextInt();
		while (n>0) {
			resto=n%10;
			res=res*10+resto;
			n=n/10;
		}
		System.out.println("el numero al revés es "+res);
	}
} 