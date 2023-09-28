package ejercicios5;
import java.util.Scanner;
public class ParesdelanteImparesdetras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		// TODO Auto-generated method stub
		int aux, i, j;
		int [] vector= new int[20];
		for (i=0; i<20; i++) {
			vector[i]=(int)(Math.random()*101);
			System.out.print("["+vector[i]+"]");
		}
		System.out.println("");
		for(i=1; i<20; i++) {
			for (j=0; j<20-1; j++) {
				if(vector[j]%2!=0) {
				aux=vector[j];
				vector[j]=vector[j+1];
				vector[j+1]=aux;
				}
			}
		}
		for (i=0; i<20; i++) {
			System.out.print("["+vector[i]+"]");
		}
	}	
}