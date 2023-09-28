package ejercicios3;
import java.util.Scanner;
public class paresimpares2numeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, aux2=0, aux=0, respar=0, cont=0, resimpar=0, reston=0, restop, n, p, restopar=0, restoimpar=0; 
		String par="", impar="";
		Scanner leer = new Scanner (System.in);
		System.out.println("Introduce el número 1");
		n = leer.nextInt();
		System.out.println("Introduce el número 2");
		p = leer.nextInt();
		aux=p;
		aux2=n;
		while (aux%10==0) {
			aux=aux/10;
			cont=cont+1;
		}
		while (aux2%10==0) {
			aux2=aux2/10;
			cont=cont+1;
		}
		while (n>0 & p>0) {
				if (p>0) {
				restop=p%10;
				p=p/10;
				if (restop%2==0) {
					par+=restop;
					}else {
						impar+=restop;
					}
			}
			if (n>0) {
				reston=n%10;
				n=n/10;
				if (reston%2==0) {
					par+=reston;
					}else {
						impar+=reston;
					}
			}
		}
		System.out.println(par);
		System.out.println(impar);
		int pares=Integer.parseInt(par);
		int impares=Integer.parseInt(impar);
		while (pares>0){
			restopar=pares%10;
			respar=respar*10+restopar;
			pares=pares/10;	
		}
		while (impares>0){
			restoimpar=impares%10;
			resimpar=resimpar*10+restoimpar;
			impares=impares/10;
		}
		for (i=0; i<cont; i++) {
			respar=respar*10;
		}
		System.out.println("el numero de impares es "+resimpar);
		System.out.println("el numero de pares es "+respar);
	}
}