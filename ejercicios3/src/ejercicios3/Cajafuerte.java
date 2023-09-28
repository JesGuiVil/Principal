package ejercicios3;
import java.util.Scanner;
public class Cajafuerte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer= new Scanner(System.in);
		int i, k, cont=0, j;
		int [] pw= new int [4];
		int [] n= new int [4];
		pw [0]= 1;
		pw [1]= 9;
		pw [2]= 9;
		pw [3]= 3;
		for (i=0; i<4; i++) {
			System.out.println("INTENTO "+(i+1));
			System.out.println(" ");
			for(j=0; j<4; j++) {
				System.out.println("Introduzca la cifra "+(j+1));
				n[j]=leer.nextInt();
			}
			cont=0;
			for (k=0; k<4; k++) {
				if (pw[k]==n[k]) {
					cont=cont+1;
				}
				
			}
			if (cont==4) {
				System.out.println("contraseña correcta");
				i=4;
			}else {
				System.out.println("contraseña incorrecta");
				System.out.println("");
			}
			if (i==3 & cont!=4) {
				System.out.println("no hay mas intentos.");
			}
		}
	}
}