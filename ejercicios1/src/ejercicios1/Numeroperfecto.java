package ejercicios1;

import java.util.Scanner;

public class Numeroperfecto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//detecta si n es un numero perfecto.  la suma de sus divisores da el numero ejemplo (28=1,2,4,7,14) 
		Scanner leer=new Scanner (System.in);
		int i, n;
		double suma=0;
		System.out.println("introduzca su numero");
		n = leer.nextInt();
		for (i=1; i<((n/2)+1); i++) {
			if (n%i==0) {
				suma=suma+i;
			}
			}
		if (suma==n) {
			System.out.println(n+" es un numero perfecto");
		}else {
			System.out.println(n+" no es un numero perfecto");
	}
	}
}