package ejercicios2;
import java.util.Scanner;
public class Eurospesetas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//convierte de euros a pesetas
		Scanner leer = new Scanner (System.in);
		double p, n;
		System.out.println("Introduce los euros");
		n = leer.nextDouble();
		p=n*166.386;
		System.out.println(n+" euros son " + p+ " pesetas");	
	}
} 