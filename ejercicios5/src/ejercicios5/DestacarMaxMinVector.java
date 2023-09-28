package ejercicios5;
import java.util.Scanner;
public class DestacarMaxMinVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		// TODO Auto-generated method stub
		int aux, i, j, mayor=0, menor=500;
		int [] vector= new int[10];
		String respuesta="";
		for (i=0; i<10; i++) {
			vector[i]=(int)(Math.random()*501);
			System.out.print("["+vector[i]+"]");
		}
		System.out.println("");
		for(i=1; i<10; i++) {
			if(vector[i]>mayor) {
				mayor=vector[i];
			}
			if(vector[i]<menor) {
				menor=vector[i];
			}
		}
		System.out.println("¿quieres destacar el maximo o el minimo?");
		respuesta=leer.next();
		System.out.println("");
			if(respuesta.equals("maximo")) {
				for (i=0; i<10; i++) {
					if(vector[i]==mayor) {
						System.out.print("**["+vector[i]+"]**");
					}else {
						System.out.print("["+vector[i]+"]");
					}
				}
			}
			if(respuesta.equals("minimo")) {
				for (i=0; i<10; i++) {
					if(vector[i]==menor) {
						System.out.print("**["+vector[i]+"]**");
					}else {
						System.out.print("["+vector[i]+"]");
					}
				}
			}
	}
}