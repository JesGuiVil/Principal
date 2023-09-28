package ejercicios2;

import java.util.Scanner;

public class Diaonoche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer=new Scanner (System.in);
		int h;
	       System.out.println ("Ingrese la hora");
	       h = leer.nextInt();
	       if (h>5 & h<13) {
	    	   System.out.println("buenos días");
	       }
	       if (h>12 & h<21) {
	    	   System.out.println("buenos tardes");
	       }
	       if ((h>20 & h<24) | (h<6)) {
	    	   System.out.println("buenas noches");
	       }
	}

}
