package ejercicios6;
import java.util.Scanner;

public class Tresenraya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		// TODO Auto-generated method stub
		int j, fila, columna, turno, cont=0, i;
		boolean correcto=false;
		String respuesta;
		String [][] matriz= new String[3][3];	
		System.out.println("¿quieres jugar contra otro jugador o contra la maquina?");
		respuesta=leer.next();
		for(i=0; i<3; i++) {
			for(j=0; j<3; j++) {
			matriz[i][j]=" ";
			}
		}
		System.out.println("aqui teneis el tablero");
		for(i=0; i<3; i++) {
			for(j=0; j<3; j++) {
				System.out.print("["+matriz[i][j]+"]");
			}
			System.out.println("");
		}
		if(respuesta.equals("jugador")) {
			for(turno=0; turno<9; turno++) {
				correcto=false;
				while(!correcto) {
					if(turno%2==0) {
						System.out.println("turno del jugador 1:");
						System.out.println("indique en que fila quiere colocar la ficha");
						fila=leer.nextInt();
						System.out.println("indique en que columna quiere colocar la ficha");
						columna=leer.nextInt();
						if(matriz[fila-1][columna-1].equals(" ")){
							matriz[fila-1][columna-1]="X";
							correcto=true;
						}else {
							System.out.println("esa casilla ya esta ocupada, elige otra.");
						}
					}
					if(turno%2!=0) {
						System.out.println("turno del jugador 2:");
						System.out.println("indique en que fila quiere colocar la ficha");
						fila=leer.nextInt();
						System.out.println("indique en que columna quiere colocar la ficha");
						columna=leer.nextInt();
						if(matriz[fila-1][columna-1].equals(" ")){
							matriz[fila-1][columna-1]="O";
							correcto=true;
						}else {
							System.out.println("esa casilla ya esta ocupada, elige otra");
						}
					}
				}
				for(i=0; i<3; i++) {
					for(j=0; j<3; j++) {
						System.out.print("["+matriz[i][j]+"]");
					}
					System.out.println("");
				}
				if( (matriz[0][0]==matriz[0][1] & matriz[0][0]==matriz[0][2] & matriz[0][0].contains("X"))| 
					(matriz[1][0]==matriz[1][1] & matriz[1][0]==matriz[1][2] & matriz[1][0].contains("X"))|
					(matriz[2][0]==matriz[2][1] & matriz[2][0]==matriz[2][2] & matriz[2][0].contains("X"))|
					(matriz[0][0]==matriz[1][0] & matriz[0][0]==matriz[2][0] & matriz[0][0].contains("X"))|
					(matriz[0][1]==matriz[1][1] & matriz[0][1]==matriz[2][1] & matriz[0][1].contains("X"))|
					(matriz[0][2]==matriz[1][2] & matriz[0][2]==matriz[2][2] & matriz[0][2].contains("X"))|
					(matriz[0][0]==matriz[1][1] & matriz[0][0]==matriz[2][2] & matriz[0][0].contains("X"))|
					(matriz[0][2]==matriz[1][1] & matriz[0][2]==matriz[2][0] & matriz[0][2].contains("X"))) {
					System.out.println("fin del juego");
					turno=9;
					System.out.println("el jugador 1 ganó!");
					cont=cont+1;
				}
				if( (matriz[0][0]==matriz[0][1] & matriz[0][0]==matriz[0][2] & matriz[0][0].contains("O"))| 
					(matriz[1][0]==matriz[1][1] & matriz[1][0]==matriz[1][2] & matriz[1][0].contains("O"))|
					(matriz[2][0]==matriz[2][1] & matriz[2][0]==matriz[2][2] & matriz[2][0].contains("O"))|
					(matriz[0][0]==matriz[1][0] & matriz[0][0]==matriz[2][0] & matriz[0][0].contains("O"))|
					(matriz[0][1]==matriz[1][1] & matriz[0][1]==matriz[2][1] & matriz[0][1].contains("O"))|
					(matriz[0][2]==matriz[1][2] & matriz[0][2]==matriz[2][2] & matriz[0][2].contains("O"))|
					(matriz[0][0]==matriz[1][1] & matriz[0][0]==matriz[2][2] & matriz[0][0].contains("O"))|
					(matriz[0][2]==matriz[1][1] & matriz[0][2]==matriz[2][0] & matriz[0][2].contains("O"))) {
						System.out.println("fin del juego");
						turno=9;
						System.out.println("el jugador 2 ganó!");
						cont=cont+1;
					}
			}
			if(cont==0) {
				System.out.println("fin del juego");
				System.out.println("habeis empatado. sois malisimos");
			}
		}
		if(respuesta.equals("maquina")) {
			for(turno=0; turno<9; turno++) {
				correcto=false;
				while(!correcto) {
					if(turno%2==0) {
						System.out.println("turno del jugador 1:");
						System.out.println("indique en que fila quiere colocar la ficha");
						fila=leer.nextInt();
						System.out.println("indique en que columna quiere colocar la ficha");
						columna=leer.nextInt();
						if(matriz[fila-1][columna-1].equals(" ")){
							matriz[fila-1][columna-1]="X";
							correcto=true;
						}else {
							System.out.println("esa casilla ya esta ocupada, elige otra.");
						}
					}
					if(turno%2!=0) {
						System.out.println("turno de la maquina:");
						fila=(int)(Math.random()*3);
						columna=(int)(Math.random()*3);
						if(matriz[fila][columna].equals(" ")){
							matriz[fila][columna]="O";
							correcto=true;
						}
					}
				}
				for(i=0; i<3; i++) {
					for(j=0; j<3; j++) {
						System.out.print("["+matriz[i][j]+"]");
					}
					System.out.println("");
				}
				if( (matriz[0][0]==matriz[0][1] & matriz[0][0]==matriz[0][2] & matriz[0][0].contains("X"))| 
					(matriz[1][0]==matriz[1][1] & matriz[1][0]==matriz[1][2] & matriz[1][0].contains("X"))|
					(matriz[2][0]==matriz[2][1] & matriz[2][0]==matriz[2][2] & matriz[2][0].contains("X"))|
					(matriz[0][0]==matriz[1][0] & matriz[0][0]==matriz[2][0] & matriz[0][0].contains("X"))|
					(matriz[0][1]==matriz[1][1] & matriz[0][1]==matriz[2][1] & matriz[0][1].contains("X"))|
					(matriz[0][2]==matriz[1][2] & matriz[0][2]==matriz[2][2] & matriz[0][2].contains("X"))|
					(matriz[0][0]==matriz[1][1] & matriz[0][0]==matriz[2][2] & matriz[0][0].contains("X"))|
					(matriz[0][2]==matriz[1][1] & matriz[0][2]==matriz[2][0] & matriz[0][2].contains("X"))) {
					System.out.println("fin del juego");
					turno=9;
					System.out.println("el jugador 1 ganó!");
					cont=cont+1;
				}
				if( (matriz[0][0]==matriz[0][1] & matriz[0][0]==matriz[0][2] & matriz[0][0].contains("O"))| 
					(matriz[1][0]==matriz[1][1] & matriz[1][0]==matriz[1][2] & matriz[1][0].contains("O"))|
					(matriz[2][0]==matriz[2][1] & matriz[2][0]==matriz[2][2] & matriz[2][0].contains("O"))|
					(matriz[0][0]==matriz[1][0] & matriz[0][0]==matriz[2][0] & matriz[0][0].contains("O"))|
					(matriz[0][1]==matriz[1][1] & matriz[0][1]==matriz[2][1] & matriz[0][1].contains("O"))|
					(matriz[0][2]==matriz[1][2] & matriz[0][2]==matriz[2][2] & matriz[0][2].contains("O"))|
					(matriz[0][0]==matriz[1][1] & matriz[0][0]==matriz[2][2] & matriz[0][0].contains("O"))|
					(matriz[0][2]==matriz[1][1] & matriz[0][2]==matriz[2][0] & matriz[0][2].contains("O"))) {
						System.out.println("fin del juego");
						turno=9;
						System.out.println("ganó la máquina");
						cont=cont+1;
					}
			}
			if(cont==0) {
				System.out.println("fin del juego");
				System.out.println("habeis empatado. sois malisimos");
			}
		}
	}
}