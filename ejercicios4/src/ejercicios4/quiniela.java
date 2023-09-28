package ejercicios4;
import java.util.Scanner;
public class quiniela {
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		int n,g;
		for (int i = 1; i <= 14; i++) {
			if ( i<=9 ) {
				System.out.printf(" Partido " + i + ". |");
			}else {
				System.out.printf(" Partido " + i + ".|");
			}
			for (int j = 1; j <= 3; j++) {
				n = (int)(Math.random() * 3) + 1;
				switch(n) {
				case 1:
					System.out.print("1    |");
				break;
				case 2:
					System.out.print("    2|");
				break;
				case 3:
					System.out.print("  X  |");
				default:
				}
			}
			System.out.println();
		}
		System.out.println("");
		System.out.println("PLENO AL 15");
		System.out.println("");
		g = (int)(Math.random()*4);
		System.out.print("Local: ");
			if ( g <= 2 ) {
				System.out.println(g);
			}else if ( g>2 ) {
				System.out.println(" M ");
			}
		g = (int)(Math.random()*4);
		System.out.print("Visitante: ");
			if ( g <= 2 ) {
				System.out.println(g);
			}else if( g>2 ) {
				System.out.println(" M ");
			}
		}
}