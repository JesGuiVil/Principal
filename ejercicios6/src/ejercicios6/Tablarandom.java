package ejercicios6;
import java.util.Scanner;
public class Tablarandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		// TODO Auto-generated method stub
		int j, total=0, i;
		int [][] vector= new int[4][5];
		int [] sumafila= new int[4];
		int [] sumacolumna= new int[5];
		for (i=0; i<4; i++) {
			for(j=0; j<5; j++) {
				vector[i][j]=(int)(Math.random()*100)+100;	
			}
		}
		for (i=0; i<4; i++) {
			for(j=0; j<5; j++) {
				sumafila[i]=sumafila[i]+vector[i][j];
				total=total+vector[i][j];
			}
		}
		for (i=0; i<5; i++) {
			for(j=0; j<4; j++) {
				sumacolumna[i]=sumacolumna[i]+vector[j][i];
			}
		}
		for (i=0; i<5; i++) {
			for(j=0; j<6; j++) {
				if(i<=3 & j<=4) {
					System.out.printf("%6d",vector[i][j]);	
				}
				if(j==5 & i<=3) {
					System.out.printf("%6d",sumafila[i]);	
				}
				if(i==4 & j<=4) {
					System.out.printf("%6d",sumacolumna[i]);
				}
				if(i==4 & j==5) {
					System.out.printf("%6d",total);
				}
			}
			System.out.println("");
		}
	}
}