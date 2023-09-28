package examen;

import java.util.HashSet;
import java.util.Set;

public class primitivaJesusGuijarro {
			
	private static int[] baseprimitiva(){ //esta funcion se encarga de generar los numeros de la primitiva
		Set<Integer> lista= new HashSet<>();//creamos una lista donde almacenaremos los numeros ya usados
		int[] vector = new int[8];
		int aux, i;
		boolean existe=false;
		for (i=0; i<6; i++) {// con este for generamos los primeros 6 numeros del vector
			existe =false;
			while(!existe) { //hacemos un while para comprobar que el numero no esta usado todavia
				aux=(int)(Math.random()*50);
				if (!lista.contains(aux)) {
					lista.add(aux);
					vector[i]=aux;// si no esta usado lo añadimos al vector y a la lista de usados
					existe=true;
				}
			}
		}
		vector[6]=(int)(Math.random()*10); //aqui generamos el reintegro con un random
		existe =false;
		while(!existe) {
			aux=(int)(Math.random()*50); // aqui volvemos a comprobar si esta en la lista  para generar el complementario
			if (!lista.contains(aux)) {
				lista.add(aux);
				vector[7]=aux;
				existe=true;
			}
		}
		return vector;
	}
	private static void imprimirprimitiva(int[] vector) {//esta funcion se encarga de mostrar por pantalla de forma estructurada un vector que se le facilite
		int i;
		System.out.println("----APUESTA PRIMITIVA SENCILLA ---");
		System.out.println();
		System.out.println("----------------------------------");
		System.out.print("Números     ");
			for (i=0; i<5; i++) {
				System.out.print(vector[i]+"--");
			}
			System.out.print(vector[5]);
			System.out.println();
			System.out.println();
			System.out.print("Reintegro:          ");
			System.out.print(vector[6]);
			System.out.println();
			System.out.println();
			System.out.print("Complementario:     ");
			System.out.print(vector[7]);
			System.out.println();
			System.out.println("----------------------------------");
		}
	public static void generarprimitiva() {// esta funcion se encarga de realizar la primitiva en 2 pasos
		int [] vector;
		vector=baseprimitiva();// aqui genera el vector de numeros de la primitiva 
		imprimirprimitiva(vector);//aqui le mete el vector generado a la funcion de impresion y genera x pantalla la primitiva
	}
}

