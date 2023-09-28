package ejercicios2;
import java.util.Scanner;
public class Contarcifras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//escribir un programa que determine cuantos digitos tiene un numero
		Scanner leer = new Scanner (System.in);
		double n, cont=0;
		System.out.println("Introduce un numero");
		n = leer.nextDouble();
		while (n>=1){
				cont=cont+1;
				n=n/10;	
		}
		System.out.println("tu numero tiene "+ cont + " cifras");
	}

}