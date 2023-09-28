package ejercicios2;
import java.util.Scanner;
public class Pesetaseuros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//convierte de pesetas a euros
		Scanner leer = new Scanner (System.in);
		double p, n;
		System.out.println("Introduce las pesetas");
		n = leer.nextDouble();
		p=n/166.386;
		System.out.println(n+" pesetas son " + p+ " euros");	
	}
} 