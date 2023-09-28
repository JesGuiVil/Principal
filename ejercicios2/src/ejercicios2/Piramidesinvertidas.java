package ejercicios2;

import java.util.Scanner;

public class Piramidesinvertidas {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//piramide rellena y hueca, invertida
		int i, j, n;
		Scanner leer = new Scanner (System.in);
		System.out.println("Introduce el tamaño");
		n = leer.nextInt();
		for (i=1; i<n+1; i++) {
			for (j=1; j<i; j++) {
				System.out.print(" ");
			}
			for (j=n+1; j>i; j--) {
				System.out.print("* ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		System.out.println(" ");
		for (i=1; i<n+1; i++) {	
			if (i==1) {
				for (j=1; j<n; j++) {
					System.out.print(" *");	
			}	
			}for (j=1; j<i; j++) {
				System.out.print(" ");
			}
			System.out.print(" *");
			if (i<n & i!=1) {
				for (j=i; j<n-1; j++) {
					System.out.print("  ");
				}
				System.out.print(" *");
			}
				
			System.out.println(" ");
			
		}
	}
} 