package ejercicios3;
import java.util.Scanner;
public class Uderombos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, n, j;
		Scanner leer = new Scanner (System.in);
		System.out.println("Introduce el tamaño");
		n = leer.nextInt();
		
		for (i=0; i<n; i++) {	
			if (i<n-1) {
				System.out.print("*");
			}
			for (j=0; j<n; j++) {
				if ((j<n-1 & i<n-1) | (i==n-1 & j<1) | (i==n-1 & j==n-1)){
					System.out.print("  ");
				}
				if ((i!=n-1 & j==n-1) | (i==n-1 & j>0 & j<n-1)){
					System.out.print(" *");
				}
			}
			System.out.println(" ");
		}
	}
} 