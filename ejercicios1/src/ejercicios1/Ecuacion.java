package ejercicios1;
import java.util.Scanner;
public class Ecuacion {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//hacer un programa que calcule las raices de una ecuacion de segundo grado ax^2+b//
		int a, b, c;
		double pos=0;
		double neg=0;
		Scanner leer = new Scanner (System.in);
		System.out.println("Introduce el valor de a");
		a = leer.nextInt();
		System.out.println("Introduce el valor de b");
		b = leer.nextInt();
		System.out.println("Introduce el valor de c");
		c = leer.nextInt();
		if (a==0 | (b*b)-4*a*c<0){
			System.out.println("no se puede realizar con esos valores. Intentelo de nuevo con otros valores");	
		}else if (a != 0){
		pos=((-b + Math.sqrt((b*b) - 4*a*c))/(2*a));
		neg=((-b - Math.sqrt((b*b) - 4*a*c))/(2*a));
		System.out.println("el resultado es x1 = " + pos);	
		System.out.println("el resultado es x2 = " + neg);
					}
	       }
	}			
		

