package ejercicios2;
import java.util.Scanner;
public class MCDandMCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//determina MCD Y MCM de dos numeros
		Scanner leer = new Scanner (System.in);
		double n1, aux1=0, n2, mcm=0, resto=0, temporal=0;
		System.out.println("Introduce el primer numero");
		n1 = leer.nextDouble();
		System.out.println("Introduce el segundo numero");
		n2 = leer.nextDouble();
		aux1=n1;
		resto=n2;
			while(resto!=0) {
				temporal=resto;
				resto = aux1%resto;
				aux1=temporal;
			}
			System.out.println("el mcd es " + aux1);
			mcm=(n1*n2)/aux1;
			System.out.println("el mcm es " + mcm);	
	}
} 