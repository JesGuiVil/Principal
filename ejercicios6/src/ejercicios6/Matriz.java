package ejercicios6;
import java.util.Scanner;
public class Matriz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		// TODO Auto-generated method stub
		int j, total=0, i, mayor=0, menor=1000;
		int [][] matriz= new int[6][10];
		for(i=0; i<6; i++) {
			for(j=0; j<10; j++) {
				matriz[i][j]=(int)(Math.random()*1001);
				System.out.printf("%6d",matriz[i][j]);
				if(matriz[i][j]>mayor) {
					mayor=matriz[i][j];
				}
				if(matriz[i][j]<menor) {
					menor=matriz[i][j];
				}
			}
			System.out.println("");
		}
		for(i=0; i<6; i++) {
			for(j=0; j<10; j++) {
				if(matriz[i][j]==mayor) {
					System.out.println("el mayor esta en la posición ["+(i+1)+"]["+(j+1)+"]");
				}
				if(matriz[i][j]==menor) {
					System.out.println("el menor esta en la posición ["+(i+1)+"]["+(j+1)+"]");
				}
			}
		}
	}
}