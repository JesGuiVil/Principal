package principal;
import java.util.Scanner;
import ejercicios7.funciones;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer= new Scanner(System.in);
		int solucion=0, i;
		String n;
		String valor= new String();
		System.out.println("introduce el numero en binario");
		n=leer.next();
		System.out.println(n);
		for (i=n.length()-1; i>=0; i--) {
			valor+=n.charAt(i);
		}
		System.out.println(valor);
		for(i=0; i<valor.length(); i++) {
			if(n.charAt(i)==1) {
				solucion=solucion+funciones.potencia(2,i);
			}
		}
	}

}
