package ejercicios1;

import java.util.Scanner;

public class Armstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//dado un N numero detecta si es armstrong ejemplo:371-3^3+7^3+1^3
		Scanner leer=new Scanner (System.in);
		int i, numero, n;
		System.out.println("introduzca su numero completo");
		numero = leer.nextInt();
		System.out.println("introduzca el numero de cifras de su numero");
		n = leer.nextInt();
		int[] cifras= new int[n];
		for (i=0; i<n; i++) {
			System.out.println("introduzca la cifra" + (i+1));
			cifras[i] = leer.nextInt();
		}
		double sumatotal=0;
		for (i=0; i<n; i++) {
			sumatotal=sumatotal+(Math.pow(cifras[i],n));
		}
	   if (sumatotal==numero) {
		   System.out.println(numero + " es un numero armstrong");
	   }else {
		   System.out.println(numero + " no es un numero armstrong");  
       }
	}
}