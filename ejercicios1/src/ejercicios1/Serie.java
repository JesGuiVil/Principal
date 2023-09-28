package ejercicios1;

import java.util.Scanner;

public class Serie {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//dado un numero positivo n calcule la siguiente serie 1 + 1/2 + 1/3.... hasta 1/n
		Scanner leer=new Scanner (System.in);
		double i, n;
		double sumafinal=0;
		System.out.println("introduzca el numero");
		n = leer.nextDouble();
		for (i=1;i<(n+1);i++)
		{ 
		sumafinal=sumafinal+(1/i);
		}
		System.out.println("el resultado es " + sumafinal);
	}
}