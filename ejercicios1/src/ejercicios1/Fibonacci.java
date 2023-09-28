package ejercicios1;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//calcule los primeros n numero de la sucesion de fibonacci 1,1,2,3,5,8,etc
		Scanner leer=new Scanner (System.in);
		int i, n, numeroanterior1=1, numeroanterior2=0, numeroposterior=0;
		System.out.println("introduzca el numero");
		n = leer.nextInt();
		System.out.print("1,");
		for (i=0;i<(n-1);i++)
		{ 
		numeroposterior=numeroanterior1+numeroanterior2;
		System.out.print(numeroposterior + ",");
		numeroanterior2=numeroanterior1;
		numeroanterior1=numeroposterior;
		}
	}
}