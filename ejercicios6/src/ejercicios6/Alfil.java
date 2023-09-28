package ejercicios6;
import java.util.Scanner;

public class Alfil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		// TODO Auto-generated method stub
		int j, fila, columna=0, t, i;
		String [][] matriz= new String[8][8];
		String [] letras= {"   a "," b "," c "," d "," e "," f "," g "," h "};
		String respuesta="";
		for(i=0; i<8;i++) {
			for(j=0; j<8; j++) {
			matriz[i][j]=" ";
			}
		}
		for(i=0; i<9;i++) {
			for(j=-1; j<8; j++) {
				if(j==-1 & i<8) {
					System.out.print((i+1)+".");
				}
				if(j>-1 & i<8) {
					System.out.print("["+matriz[i][j]+"]");
				}
				if(j>-1 & i==8) {
					System.out.print(letras[j]);
				}
			}
			System.out.println("");
		}
		System.out.println("¿En que fila está el alfil?");
		fila=leer.nextInt();
		System.out.println("¿En que columna está el alfil?");
		respuesta=leer.next();
		if(respuesta.contains("a")) {
			columna=1;
		}else if(respuesta.contains("b")) {
			columna=2;
		}else if(respuesta.contains("c")) {
			columna=3;
		}else if(respuesta.contains("d")) {
			columna=4;
		}else if(respuesta.contains("e")) {
			columna=5;
		}else if(respuesta.contains("f")) {
			columna=6;
		}else if(respuesta.contains("g")) {
			columna=7;
		}else if(respuesta.contains("h")) {
			columna=8;
		}
		matriz[fila-1][columna-1]="X";
		for(t=1; t<9; t++) {
			for(i=0; i<8;i++) {
				for(j=0; j<8; j++) {
					if((i==(fila-1+t)) & (j==(columna-1+t))) {
						matriz[i][j]="O";	
					}
					if((i==(fila-1+t)) & (j==(columna-1-t))) {
						matriz[i][j]="O";	
					}
					if((i==(fila-1-t)) & (j==(columna-1+t))) {
						matriz[i][j]="O";	
					}
					if((i==(fila-1-t)) & (j==(columna-1-t))) {
						matriz[i][j]="O";	
					}
				}
			}
		}
		System.out.println("Tu alfil aparece marcado con X");
		System.out.println("puedes mover el alfil a cualquiera de las casillas marcadas con O");
		for(i=0; i<9;i++) {
			for(j=-1; j<8; j++) {
				if(j==-1 & i<8) {
					System.out.print((i+1)+".");
				}
				if(j>-1 & i<8) {
					System.out.print("["+matriz[i][j]+"]");
				}
				if(j>-1 & i==8) {
					System.out.print(letras[j]);
				}
			}
			System.out.println("");
		}
	}
}