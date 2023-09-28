package recursivas;
import java.util.Scanner;
public class fibonazi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer= new Scanner (System.in);
		int n;
		System.out.println("introduce el numero de la cadena");
		n=leer.nextInt();
		System.out.println("el numero "+n+" de la sucesion de fibonacci es "+fibonacci(n));
	}
		public static int fibonacci(int n){
		 if (n== 2 | n == 1) {
		 return 1;
		 }else {
		 return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}
