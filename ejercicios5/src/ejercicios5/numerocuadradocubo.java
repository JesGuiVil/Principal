package ejercicios5;
import java.util.Scanner;
public class numerocuadradocubo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		// TODO Auto-generated method stub
		int j, i;
		int [] NUMERO= new int[20];
		int [] CUADRADO= new int[20];
		int [] CUBO= new int[20];
		for (i=0; i<20; i++) {
			NUMERO[i]=(int)(Math.random()*100)+1;	
			CUADRADO[i]=(int)(Math.pow(NUMERO[i],2));
			CUBO[i]=(int)(Math.pow(NUMERO[i],3));
		System.out.printf("%4d%6d%8d\n",NUMERO[i],CUADRADO[i],CUBO[i]);
		}
	}	
}