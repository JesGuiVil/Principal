package ejercicios5;
import java.util.Scanner;
public class Cambioenvector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		// TODO Auto-generated method stub
		int cambio, select, i;
		int [] vector= new int[100];
		for (i=0; i<100; i++) {
			vector[i]=(int)(Math.random()*21);
			System.out.print(vector[i]+" ");
		}
		System.out.println();
		System.out.println("introduzca el numero que desea cambiar");
		select=leer.nextInt();
		System.out.println("introduzca el numero por el que desea sustituirlo");
		cambio=leer.nextInt();
		for (i=0; i<100; i++) {
			if(vector[i]==select) {
				vector[i]=cambio;
				System.out.print("'"+vector[i]+"' ");	
			}else {
				System.out.print(vector[i]+" ");
			}
		}
	}	
}