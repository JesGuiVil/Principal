package ejercicios4;
import java.util.Scanner;
public class Randommaxmin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		// TODO Auto-generated method stub
		int num, max=0, min=199, media, suma=0, i;
		for (i=0; i<50; i++) {
			num=(int)(Math.random()*100+100);
			System.out.print(" "+num);
			if (num>max) {
				max=num;
			}
			if (num<min) {
				min=num;
			}
			suma=suma+num;
		}
		media=suma/50;
		System.out.println(" ");
		System.out.println("el numero mayor es "+max);
		System.out.println("el numero mas pequeño es "+min);
		System.out.println("la media es "+media);
	}
}