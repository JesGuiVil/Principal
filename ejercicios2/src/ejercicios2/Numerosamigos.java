package ejercicios2;
import java.util.Scanner;
public class Numerosamigos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//determina si 2 numeros son amigos
		Scanner leer = new Scanner (System.in);
		double i, n, p, suman=0, sumap=0;
		System.out.println("Introduce el primer numero");
		n = leer.nextInt();
		System.out.println("Introduce el segundo numero");
		p = leer.nextInt();
		for (i=1; i<((n/2)+1); i++) {
			if (n%i==0) {
				suman=suman+i;
			}
			}
		for (i=1; i<((p/2)+1); i++) {
			if (p%i==0) {
				sumap=sumap+i;
			}
			}
		if ((suman==p)&(sumap==n)){
			System.out.println("sus numeros son amigos");
		}else {
			System.out.println("sus numeros no son amigos");
		}
	}

} 