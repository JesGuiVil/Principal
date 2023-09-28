package ejercicios4;
import java.util.Scanner;
public class Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		// TODO Auto-generated method stub
		int num, i;
		for (i=0; i<20; i++) {
			num=(int)(Math.random()*10);
			System.out.print(" "+num);
		}
	}
}