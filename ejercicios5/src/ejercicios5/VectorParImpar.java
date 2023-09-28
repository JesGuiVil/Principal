package ejercicios5;
import java.util.Scanner;
public class VectorParImpar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		// TODO Auto-generated method stub
		int i;
		int [] vector= new int[8];
		System.out.println("introduce  8 numeros");
		for (i=0; i<8; i++) {
			vector[i]=leer.nextInt();
		}
		for (i=0; i<8; i++) {
			if(vector[i]%2==0) {
				System.out.print(vector[i]+" PAR, ");
			}
			if(vector[i]%2!=0) {
				System.out.print(vector[i]+" IMPAR, ");
			}
		}
	}	
}