package ejercicios5;
import java.util.Scanner;
public class Invertirvector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		// TODO Auto-generated method stub
		int i;
		int [] vector= new int[10];
		System.out.println("Introduce 10 valores");
		for (i=0; i<10; i++) {
			vector[i]=leer.nextInt();	
		}
		System.out.println("su vector a la inversa es: ");
		for (i=9; i>-1; i--) {
			System.out.print("["+vector[i]+"]");
		}
	}
}