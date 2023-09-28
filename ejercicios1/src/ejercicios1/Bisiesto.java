package ejercicios1;

import java.util.Scanner;

public class Bisiesto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//hacer un ejercicio que determine si un año es bisiesto o no
		Scanner leer=new Scanner (System.in);
		double ano;
		System.out.println("Escribe el año");
		ano = leer.nextDouble();
		if ((ano % 4 == 0 & ano % 100 != 0) | ano % 400 == 0){
			System.out.println("el año es bisiesto");
		}else {
			System.out.println("el año no es bisiesto");
		}
	}
}
