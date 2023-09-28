package colegio;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Colegio ilerna=new Colegio();
		ilerna.creaColegio(); //en este metodo he metidos unos datos base (profesores alumnos asignaturas etc) sobre los cuales actuará el menu
		ilerna.menu();
		
		//para consultar notas o cosas de los alumnos primero habrá que usar la opcion 1 e insertar alumnos.
		// la opcion 4 (ordenar alumnos) no me ha dado tiempo.
	}

}
