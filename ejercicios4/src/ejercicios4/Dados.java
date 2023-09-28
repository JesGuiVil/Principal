package ejercicios4;
import java.util.Scanner;
public class Dados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		int i, tirada=1,  res=0;
		for (i=1; i<4; i++) {
			System.out.println("tirada "+i);
			tirada=(int)(Math.random()*6+1);
			System.out.println("sacaste un "+tirada);
			res=res+tirada;
		}
		System.out.println("la suma de tus tirada es "+res);
	}
}