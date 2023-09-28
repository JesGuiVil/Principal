package principal;

import ejercicios7.funciones;

public class Ejercicio03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		for (i=1; i<=99999; i++) {
			if (funciones.escapicua(i)) {
				System.out.print(i+",");
			}
		}
	}

}
