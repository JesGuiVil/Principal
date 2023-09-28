package principal;

import ejercicios7.funciones;

public class Ejercicio02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		for (i=1; i<=1000; i++) {
			if (funciones.esprimo(i)) {
				System.out.print(i+",");
			}
		}
	}

}
