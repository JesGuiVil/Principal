package ejercicios3;
import java.util.Scanner;
public class piramidenumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i, j, num=0, n=0, di=0, dj=0;
		Scanner leer = new Scanner (System.in);
		System.out.println("Introduce el tamaño");
		n = leer.nextInt();
		
		for (i=1; i<(n+1); i++) {	
			for (j=0; j<(n*2); j++) {
				di=Math.abs(n-i);
				dj=Math.abs(n-j);
				if (dj>i){
					System.out.print(" ");
				}
				if (dj<i) {
					num= n-dj-di;
							System.out.print(num);
				}
			}
			
			System.out.println(" ");
		}
	}
} 