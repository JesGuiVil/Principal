package ejercicios3;
import java.util.Scanner;
public class Horasdelasemana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int d1, h1, d2, h2, res=0; 
		Scanner leer = new Scanner (System.in);
		System.out.println("Introduce el numero del dia de la semana");
		d1 = leer.nextInt();
		System.out.println("Introduce la hora del dia 1");
		h1 = leer.nextInt();
		System.out.println("Introduce el numero del dia de la semana");
		d2 = leer.nextInt();
		System.out.println("Introduce la hora del dia 2");
		h2 = leer.nextInt();
		if (d1<d2) {
			res=((d2-d1-1)*24)+h2+(24-h1);
		}
		if (d1>d2) {
			res=((7-d1+d2-1)*24)+h2+(24-h1);
		}
		System.out.println(res + " horas");
	}
} 