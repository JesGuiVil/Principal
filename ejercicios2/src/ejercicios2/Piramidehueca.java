package ejercicios2;
import java.util.Scanner;
public class Piramidehueca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//piramide hueca altura determinada por el usuario
		int i, j, n;
		Scanner leer = new Scanner (System.in);
		System.out.println("Introduce el tamaño");
		n = leer.nextInt();
		for (i=1; i<n; i++) {	
			for (j=i; j<n; j++) {
				System.out.print(" ");
			}
			System.out.print(" *");
			if (i>1) {
				for (j=1; j<i-1; j++) {
					System.out.print("  ");
				}
				System.out.print(" *");
			}
				
			System.out.println(" ");
			if (i==n-1)
				for (j=1; j<n+1; j++) {
					System.out.print(" *");
				}
		}
	}
} 