package ejercicios4;
import java.util.Scanner;
public class adivinanum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		// TODO Auto-generated method stub
		int n, num, i;

		num=(int)(Math.random()*101);
		for (i=1; i<6; i++) {
			System.out.println("intento "+(i)+", introduzca numero");
			n =leer.nextInt();
			if (n>num) {
				System.out.println("el numero es mas pequeño");
				System.out.println("te quedan "+(5-i)+" intentos"); 
			}
			if (n<num) {
				System.out.println("el numero es mas grande");
				System.out.println("te quedan "+(5-i)+" intentos"); 
			}
			if (n==num) {
				System.out.println("acertaste");
				i=6;
			}
		}
		System.out.println(" el numero secreto era "+num);
	}
}