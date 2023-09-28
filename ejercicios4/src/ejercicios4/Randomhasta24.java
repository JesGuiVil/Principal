package ejercicios4;
import java.util.Scanner;
public class Randomhasta24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		int n, num=0, i;
		long cont=0;
			while(num!=24) {
				num=(int)(Math.random()*101);
				System.out.print(num+",");
				cont=cont+1;
			}
			System.out.println("");
			System.out.println("necesitó "+cont+" intentos");
	}
}