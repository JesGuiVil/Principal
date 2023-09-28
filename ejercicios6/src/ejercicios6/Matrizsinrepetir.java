package ejercicios6;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
public class Matrizsinrepetir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		// TODO Auto-generated method stub
		int j, total=0, i, aux, mayor=0, menor=1000;
		int [][] matriz= new int[6][10];	
		Set<Integer> lista= new HashSet<>();
		for(i=0; i<6; i++) {
			for(j=0; j<10; j++) {
				boolean existe =false;
				while(!existe) {
					aux=(int)(Math.random()*1001);
					if (!lista.contains(aux)) {
						lista.add(aux);
						matriz[i][j]=aux;
						existe=true;
					}
				}
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
					System.out.println("el mayor esta en la posición fila "+(i+1)+" columna "+(j+1));
				}
				if(matriz[i][j]==menor) {
					System.out.println("el menor esta en la posición fila "+(i+1)+" columna "+(j+1));
				}
			}
		}
	}
}