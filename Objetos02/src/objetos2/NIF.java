package objetos2;
import java.util.Scanner;
public class NIF {
	Scanner sc=new Scanner(System.in);
//ATRIBUTOS
	protected int dni;
	protected char letra;
	protected static final int DNI=11111111;
	protected static final char LETRA='A';
	//GETTER Y SETTER
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public char getLetra() {
		return letra;
	}
	public void setLetra(char letra) {
		this.letra = letra;
	}
	//METODOS
	
	private void calculaLetra() {
		int resto;
		resto=(this.getDni()%23);
		switch (resto){
		case 0: this.setLetra('T');
		break;
		case 1: this.setLetra('R');
		break;
		case 2: this.setLetra('W');
		break;
		case 3: this.setLetra('A');
		break;
		case 4: this.setLetra('G');
		break;
		case 5: this.setLetra('M');
		break;
		case 6: this.setLetra('Y');
		break;
		case 7: this.setLetra('F');
		break;
		case 8: this.setLetra('P');
		break;
		case 9: this.setLetra('D');
		break;
		case 10: this.setLetra('X');
		break;
		case 11: this.setLetra('B');
		break;
		case 12: this.setLetra('N');
		break;
		case 13: this.setLetra('J');
		break;
		case 14: this.setLetra('Z');
		break;
		case 15: this.setLetra('S');
		break;
		case 16: this.setLetra('Q');
		break;
		case 17: this.setLetra('V');
		break;
		case 18: this.setLetra('H');
		break;
		case 19: this.setLetra('L');
		break;
		case 20: this.setLetra('C');
		break;
		case 21: this.setLetra('K');
		break;
		case 22: this.setLetra('E');
		break;
		}
	}
	public void leer() {
		System.out.println("introduzca los numeros del DNI");
		this.setDni(sc.nextInt());
		calculaLetra();
	}
	public String toString() {
		String cadena="";
		cadena+=this.getDni()+"-"+this.getLetra();
		return cadena;
	}
	//CONSTRUCTORES
	public NIF() {
		this.setDni(DNI);
		this.setLetra(LETRA);
	}
	public NIF(int numero) {
		this.setDni(numero);
		calculaLetra();
	}
}
