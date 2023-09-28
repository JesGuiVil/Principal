package ejercicios2;
import java.util.Scanner;
public class Oroscopo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//calcular oroscopo
		Scanner leer=new Scanner (System.in);
		int dia, Mes;
	       System.out.println ("Ingrese el numero del mes");
	       Mes = leer.nextInt();
	       System.out.println ("Ingrese el numero del dia");
	       dia = leer.nextInt();
	       switch (Mes)
	       {
	           case 1: if (dia<19) {
	        	   System.out.println("capricornio");
	           }else {
	        	   System.out.println("acuario");
	           }
	           break;
	           case 2: if (dia<20) {
	        	   System.out.println("acuario");
	           }else {
	        	   System.out.println("piscis");
	           }
	           break;
	           case 3: if (dia<20) {
	        	   System.out.println("piscis");
	           }else {
	        	   System.out.println("aries");
	           }
	           break;
	           case 4: if (dia<20) {
	        	   System.out.println("aries");
	           }else {
	        	   System.out.println("tauro");
	           }
	           break;
	           case 5: if (dia<20) {
	        	   System.out.println("tauro");
	           }else {
	        	   System.out.println("geminis");
	           }
	           break;
	           case 6: if (dia<20) {
	        	   System.out.println("geminis");
	           }else {
	        	   System.out.println("cancer");
	           }
	           break;
	           case 7: if (dia<20) {
	        	   System.out.println("cancer");
	           }else {
	        	   System.out.println("leo");
	           }
	           break;
	           case 8: if (dia<22) {
	        	   System.out.println("leo");
	           }else {
	        	   System.out.println("virgo");
	           }
	           break;
	           case 9: if (dia<22) {
	        	   System.out.println("virgo");
	           }else {
	        	   System.out.println("libra");
	           }
	           break;
	           case 10: if (dia<23) {
	        	   System.out.println("libra");
	           }else {
	        	   System.out.println("escorpio");
	           }
	           break;
	           case 11: if (dia<22) {
	        	   System.out.println("escorpio");
	           }else {
	        	   System.out.println("sagitario");
	           }
	           break;
	           case 12: if (dia<22) {
	        	   System.out.println("sagitario");
	           }else {
	        	   System.out.println("capricornio");
	           }
	           break;
					}
	       }
	}	