package ejercicios4;
import java.util.Scanner;
public class Adivinamaquina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		int n, aux=0, mayor, menor, num=1, i, respuesta, acertar=0;//1 para mayor 2 para menor
		System.out.println("piensa un número, intentaré adivinarlo.");
		System.out.println("¿cuantas oportunidades me das?");
		n =leer.nextInt();
		num=(int)(Math.random()*100)+1;
		System.out.println("creo que tu número es "+num);
		aux=num;
		mayor=100;
		menor=1;
			for (i=1; i<n; i++) {
				System.out.println("¿he acertado? (1 para si, 0 para no )");
				acertar =leer.nextInt();
				if (acertar==1) {
					i=n;
				}
				if (acertar==0) {
					if(i<(n-1)){
							System.out.println("me quedan "+(n-i)+" oportunidades");
					}
					if (i==n-1) {
						System.out.println("solo me queda una oportunidad...");
					}
					System.out.println("¿el numero es mayor o menor? (1 para mayor, 0 para menor)");
					respuesta =leer.nextInt();
					if (respuesta==1) {
						menor=aux;	
					}
					if (respuesta==0) {
						mayor=aux;
					}
					aux=(int)(Math.random()*((mayor+1)-menor)+menor);
					System.out.println("creo que tu número es "+aux);
				}
			}
			if (acertar==1) {
			System.out.println("SOY GOD, AMIGO");
			}else {
				System.out.println("¿he acertado? (1 para si, 0 para no)");
				acertar =leer.nextInt();
				if (acertar==1) {
					System.out.println("SOY GOD, AMIGO");
					}else {
						System.out.println("he petao ;(");	
					}
			}
	} 
}