package sudokufunc;

public class sudoku_JesusGuijarro {
	
	//esta funcion crea la base del sudoku con numeros que cumplen los requisitos
	private static int[][] basesudoku(int [][] sudoku){
		int i, numero=1, nuevonumero=1, j;
		for (i=0; i<9; i++) {
			numero=nuevonumero;//la fila empieza donde nuevonumero indique
			
			for (j=0; j<9; j++) {
				if (numero<=9) {
					sudoku[i][j]=numero;
					numero++;
				}else {
					numero=1;//si llega a nueve vuelve al 1
					sudoku[i][j]=numero;
					numero++;
				}
			}
			nuevonumero=numero+3;// en la siguiente fila empieza 3 numeros mayor
			if(numero==10) {//con estos dos if conseguimos que al saltar al cuarto "bloque" nos empiece en un numero distinto
				nuevonumero=4;
			}
			if(nuevonumero>9) {
				nuevonumero=(nuevonumero%9+1);
			}
		}
		return sudoku;
		
	}
	//esta funcion baraja las filas del sudoku de forma aleatoria
	private static int[][] intercambiofilas(int [][] sudoku) {
		int  fila1, veces, fila2; 
		for (veces=0; veces<((int)(Math.random()*4)+1); veces++) {//baraja de 1 a 5 veces las filas de los 3 primeros bloques
		fila1=(int) (Math.random()*3);
		fila2=(int) (Math.random()*3);
			if (fila1!=fila2) {
			int j, aux;
				for (j=0; j<9; j++) {
					aux=sudoku[fila1][j];//basicamente guardamos la fila a sustituir en un aux y recolocamos el aux tras la sustitucion
					sudoku[fila1][j]=sudoku[fila2][j];
					sudoku[fila2][j]=aux;
				}
			}
		}
		for (veces=0; veces<((int)(Math.random()*4)+1); veces++) {// baraja de 1 a 5 veces las filas de los 3 bloques del medio
			fila1=(int) (Math.random()*3)+3;
			fila2=(int) (Math.random()*3)+3;
				if (fila1!=fila2) {
				int j, aux;
					for (j=0; j<9; j++) {
						aux=sudoku[fila1][j];
						sudoku[fila1][j]=sudoku[fila2][j];
						sudoku[fila2][j]=aux;
					}
				}
			}
		for (veces=0; veces<((int)(Math.random()*4)+1); veces++) {//baraja de 1 a 5 veces las filas de los 3 ultimos bloques
			fila1=(int) (Math.random()*3)+6;
			fila2=(int) (Math.random()*3)+6;
				if (fila1!=fila2) {
				int j, aux;
					for (j=0; j<9; j++) {
						aux=sudoku[fila1][j];
						sudoku[fila1][j]=sudoku[fila2][j];
						sudoku[fila2][j]=aux;
					}
				}
		}
		return sudoku;
	}
	//esta baraja de forma aleatoria  las columnas 
	private static int[][] intercambiocolumnas(int [][] sudoku) {//baraja de 1 a 5 veces las columnas de los 3 bloques de la izquierda
		int  columna1, veces, columna2; 
		for (veces=0; veces<((int)(Math.random()*4)+1); veces++) {
			columna1=(int) (Math.random()*3);
			columna2=(int) (Math.random()*3);
			if (columna1!=columna2) {
				int i, aux;
				for (i=0; i<9; i++) {
					aux=sudoku[i][columna1];
					sudoku[i][columna1]=sudoku[i][columna2];
					sudoku[i][columna2]=aux;
				}
			}
		}
		for (veces=0; veces<((int)(Math.random()*4)+1); veces++) {//baraja de 1 a 5 veces las columnas de los 3 bloques del medio
			columna1=(int) (Math.random()*3)+3;
			columna2=(int) (Math.random()*3)+3;
				if (columna1!=columna2) {
					int i, aux;
					for (i=0; i<9; i++) {
						aux=sudoku[i][columna1];
						sudoku[i][columna1]=sudoku[i][columna2];
						sudoku[i][columna2]=aux;
					}
				}
			}
		for (veces=0; veces<((int)(Math.random()*4)+1); veces++) {//baraja de 1 a 5 veces las columnas de los 3 bloques de la derecha
			columna1=(int) (Math.random()*3)+6;
			columna2=(int) (Math.random()*3)+6;
				if (columna1!=columna2) {
					int i, aux;
					for (i=0; i<9; i++) {
						aux=sudoku[i][columna1];
						sudoku[i][columna1]=sudoku[i][columna2];
						sudoku[i][columna2]=aux;
					}
				}
		}
		return sudoku;
	}
	//esto borra de 3 a 5 casillas por cuadrado de 3x3 al sudoku ya randomizado
	private static int[][] borrarnumeros(int [][] sudoku){
		int i, c=0, f=0, j, borrarnumeros, cont=0, vaciosporcasilla, vaciostotales=0;
		while (vaciostotales<50){// aqui marco un maximo de 40 casillas a borrar que lo controlo con el contador vaciostotales
			vaciosporcasilla=0;
			borrarnumeros=0;
			borrarnumeros=((int)(Math.random()*3)+4);//aqui hago un random de 3 a 5 que es lo que voy a borrar por bloque
			while(vaciosporcasilla<borrarnumeros) {
				i=((int)(Math.random()*3)+f);//sumandole 3 a la f(mas abajo)  controlo que salte de bloque saltando a las 3 filas siguientes
				j=((int)(Math.random()*3)+c);//sumandole 3 a la c(mas abajo)  controlo que salte de bloque saltando a las 3 columnas siguientes
				if(sudoku[i][j]!=0) {
					sudoku[i][j]=0;
					vaciosporcasilla++;
					vaciostotales++;
				}	
			}
			cont=cont+1;
			// con esto controlo que solo entre una vez en cada matriz xk si el random de borrar sale 3 en muchas bloques
			//el vaciostotales no llega a 40 y me hace una segunda vuelta y me borra mas de la cuenta
			if(cont==9) {
				vaciostotales=50;
			}
			c=c+3;// aqui controlo que se sume 3 a la fila o columna o que se vuelvan a 0 cuando llegue a la ultima
			if(c==9) {
				c=0;
				f=f+3;
			}
		}
		return sudoku;
	}
	//esta se encarga de mostrar el resultado por pantalla
	private static void imprimirsudoku(int [][] sudoku) {
		int i, j;
		for(i=0; i<9; i++) {
			for (j=0; j<9; j++) {
				if(sudoku[i][j]==0) {
					System.out.print("[ ]");
				}else {
					System.out.print("["+sudoku[i][j]+"]");
				}
			}
			System.out.println();
		}
	}
	//esta incluye todas las anteriores, fabrica la plantilla y la muestra.
	public static void jugarsudoku() {
		int [][] sudoku= new int [9][9];
		sudoku=basesudoku(sudoku);
		sudoku=intercambiofilas(sudoku);
		sudoku=intercambiocolumnas(sudoku);
		sudoku=borrarnumeros(sudoku);
		imprimirsudoku(sudoku);
	}
}
