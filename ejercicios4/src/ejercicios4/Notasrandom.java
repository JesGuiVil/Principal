package ejercicios4;
import java.util.Scanner;
public class Notasrandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		 
		int num=0, contsuspenso=0, contsuficiente=0, contbien=0, contnotable=0, contsobresaliente=0, i;
		for (i=1; i<21; i++) {
			num=(int)(Math.random()*11);
			if(num<5) {
				contsuspenso=contsuspenso+1;
			}
			if (num>=5 & num<6) {
				contsuficiente=contsuficiente+1;
			}
			if (num>=6 & num<7) {
				contbien=contbien+1;
			}
			if (num>=7 & num<9) {
				contnotable=contnotable+1;
			}
			if (num>=9 & num<=10) {
				contsobresaliente=contsobresaliente+1;
			}
			System.out.print(num+" ");
			}
			System.out.println("");
			System.out.println("hay "+contsuspenso+" suspensos");
			System.out.println("hay "+contsuficiente+" suficientes");
			System.out.println("hay "+contbien+" bien");
			System.out.println("hay "+contnotable+" notables");
			System.out.println("hay "+contsobresaliente+" sobresalientes");
	}
}