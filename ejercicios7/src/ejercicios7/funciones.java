package ejercicios7;

import java.util.Scanner;

public class funciones {
	
	public static boolean escapicua(int n) {
		int numero, res=0, resto;
		numero=n;
		if(n>9) {
			while (numero>0) {
				resto=numero%10;
				res=res*10+resto;
				numero=numero/10;
			}
		}
		if(res==n) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean esprimo(int n) {
		int i;
		for (i=2; i<n; i++){
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	public static int potencia(int a, int b) {
		int i, potencia=1;
		for(i=0; i<b; i++) {
			potencia= potencia*a;
		}
		return potencia;
	}
	public static int digitos(int n) {
		int cont=0;
		while (n>=1){
				cont=cont+1;
				n=n/10;	
		}
		return cont;
	}
	public static int voltea(int n) {
		int numero, res=0, resto;
		numero=n;
		while (numero>0) {
			resto=numero%10;
			res=res*10+resto;
			numero=numero/10;
		}
		return res;
	}
	public static int siguienteprimo(int n) {
		boolean lihto=false;
		int cont=0, i, aux=0;
		while (!lihto) {
			for (i=2; i<(n+1); i++) {
				cont=0;
				if((n+1)%i==0) {
					i=(n+1);
					n=n+1;
					cont=cont+1;
				}
			}
			if(cont==0) {
				aux=n+1;
				lihto=true;
			}
		}
		return aux;
	}
	public static int digitoN(int n, int p) {
		String numero=Integer.toString(n);
		char [] digitos=numero.toCharArray();
		int  i, solucion=0;
		for (i=0; i<digitos.length; i++) {
			if(i==p) {
				solucion=Character.getNumericValue(digitos[i]);
			}
		}
		return solucion;
	}
	public static int posicionDeDigito(int n, int p) {
		int i, posicion=0;
		String numero=Integer.toString(n);
		char [] digitos=numero.toCharArray();
		for (i=0; i<digitos.length; i++) {
			if(Character.getNumericValue(digitos[i])==p) {
			posicion=i;
			return posicion;
			}
		}
		return -1;
	}
	public static int quitaPorDetras(int n, int qd) {
		int solucion, c, i;
		String numero=Integer.toString(n);
		String numero2=new String();
		char [] digitos=numero.toCharArray();
		for (i=0; i<digitos.length; i++) {
			 numero2+=digitos[i];
			}
		solucion=Integer.parseInt(numero2);
		return solucion;
	}
	public static int quitaPorDelante(int n, int qa) {
		int solucion, i;
		String numero=Integer.toString(n);
		String numero2= new String();
		char [] digitos=numero.toCharArray();
		for (i=qa; i<digitos.length; i++) {
			 numero2+=digitos[i];
			}
		solucion=Integer.parseInt(numero2);
		return solucion;
	}
	public static int pegaPorDetras(int n, int add) {
		int solucion;
		String numero=Integer.toString(n);
		String siguiente=Integer.toString(add);
		numero+=siguiente;
		solucion=Integer.parseInt(numero);
		return solucion;
	}
	public static int pegaPorDelante(int n, int ada) {
		int solucion;
		String numero=Integer.toString(n);
		String anterior=Integer.toString(ada);
		anterior+=numero;
		solucion=Integer.parseInt(anterior);
		return solucion;
	}
	public static int trozoDeNumero(int n, int ini, int termi) {
		int solucion, i; 
		String numero=Integer.toString(n);
		String numero2= new String();
		char [] digitos=numero.toCharArray();
		if (termi<digitos.length) {
			for (i=ini; i<=termi; i++) {
			numero2+=digitos[i];
			}
		}
		solucion=Integer.parseInt(numero2);
		return solucion;
	}
	public static int juntaNumeros(int n, int n2) {
		int solucion;
		String numero=Integer.toString(n);
		String siguiente=Integer.toString(n2);
		numero+=siguiente;
		solucion=Integer.parseInt(numero);
		return solucion;
	}
	public static String decimalabinario(int n) {
			int resto, i;
			String binario=new String();
			String valor= new String();
			if(n==0) {
				return "0";
			}
			while(n>0) {
				resto=n%2;
				n=n/2;
				valor+=resto;
			}
			for (i=valor.length()-1; i>=0; i--) {
				binario+=valor.charAt(i);
			}
			return binario;
	}
	public static int binarioadecimal(String n) {
		int numero;
		numero=Integer.parseInt(n);
		int resto, cont=-1, solucion=0;
		if(numero==0) {
			return 0;
		}
		while(numero>0) {
			resto=numero%10;
			numero=numero/10;
			cont=cont+1;
			if(resto==1) {
				solucion=solucion+funciones.potencia(2, cont);
			}
		}
		return solucion;
	}
	public static String decimalahexadecimal(int n) {
		int resto,  i;
		String hexa=new String();
		String valor= new String();
		if(n==0) {
			return "0";
		}
		while(n>0) {
			resto=n%16;
			n=n/16;
			if(resto<10) {
			valor+=resto;
			}
			if(resto>9) {
				switch(resto) {
				case 10:
					valor+="A";
				break;
				case 11:
					valor+="B";
				break;
				case 12:
					valor+="C";
				break;
				case 13:
					valor+="D";
				break;
				case 14:
					valor+="E";
				break;
				case 15:
					valor+="F";
				break;
				}
			}
	
		}
		for (i=valor.length()-1; i>=0; i--) {
			hexa+=valor.charAt(i);
		}
		return hexa;
	}
	public static String decimalaoctal(int n) {
		int resto, i;
		String octal=new String();
		String valor= new String();
		if(n==0) {
			return "0";
		}
		while(n>0) {
			resto=n%8;
			n=n/8;
			valor+=resto;
		}
		for (i=valor.length()-1; i>=0; i--) {
			octal+=valor.charAt(i);
		}
		return octal;
	}
	public static int octaladecimal(String n) {
		int numero;
		numero=Integer.parseInt(n);
		int resto, cont=-1, solucion=0;
		if(numero==0) {
			return 0;
		}
		while(numero>0) {
			resto=numero%10;
			numero=numero/10;
			cont=cont+1;
			solucion=solucion+(resto*funciones.potencia(8, cont));
		}
		return solucion;
	}
	public static int hexadecimaladecimal(String n) {
		String posibilidades="0123456789ABCDEF";
		int i, valor, solucion=0;
		char cosa;
		for(i=n.length()-1; i>=0; i--) {
			cosa=n.charAt(i);
			valor=posibilidades.indexOf(cosa);
			solucion=solucion+(valor*(funciones.potencia(16, (n.length()-1)-i)));
		}
		return solucion;
	}
}
