package ejercicios4;
import java.util.Scanner;
public class Dadosiguales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		int  tirada1=1, tirada2=1, fin=0;
		while (fin<1){
			tirada1=(int)(Math.random()*6+1);
			tirada2=(int)(Math.random()*6+1);
			System.out.print("el primer dado sacó "+tirada1+ ". ");
			System.out.print("el segundo 2 sacó "+tirada2+". ");
			System.out.println();
			System.out.println();
			if(tirada1==tirada2) {
				fin=fin+1;
				System.out.println("las tiradas son iguales");	
			}
		}
	}
}