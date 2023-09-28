package principal;
import ejercicios7.funciones;
import java.util.Scanner;

public class comprobaciones {


	 
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int d, p, qa, qd, n, add, ini, termi, ada, n2;// TODO Auto-generated method stub
		System.out.println("introduce el numero");
		n=leer.nextInt();
		System.out.println("introduce el  segundo numero");
		n2=leer.nextInt();
		System.out.println("introduce la posicion del digito");
		p=leer.nextInt();
		System.out.println("que digito quieres ubicar?");
		d=leer.nextInt();
		System.out.println("cuantos digitos quieres quitar por detras?");
		qd=leer.nextInt();
		System.out.println("cuantos digitos quieres quitar por delante?");
		qa=leer.nextInt();
		System.out.println("que digito le quieres añadir detrás?");
		add=leer.nextInt();
		System.out.println("que digito le quieres añadir delante?");
		ada=leer.nextInt();
		System.out.println("desde donde quieres cortar el numero?");
		ini=leer.nextInt();
		System.out.println("hasta donde quieres cortar el numero?");
		termi=leer.nextInt();
		if(funciones.escapicua(n)) {
			System.out.println("el numero es capicua");
		}else {
			System.out.println("el numero no es capicua");
		}
		System.out.println("tiene "+funciones.digitos(n)+" cifras");
		System.out.println("al reves es "+funciones.voltea(n));
		System.out.println("el siguiente primo de n es "+funciones.siguienteprimo(n));
		System.out.println("el digito en la posicion "+p+" es "+funciones.digitoN(n,p));
		System.out.println("el digito "+d+" esta en la posicion "+funciones.posicionDeDigito(n,d));
		System.out.println("el numero sin "+qd+" digitos detrás es "+funciones.quitaPorDetras(n,qd));
		System.out.println("el numero sin "+qa+" digitos delante es "+funciones.quitaPorDelante(n,qa));
		System.out.println("el numero añadiendole "+add+" detrás es "+funciones.pegaPorDetras(n, add));
		System.out.println("el numero añadiendole "+ada+" delante es "+funciones.pegaPorDelante(n, ada));
		System.out.println("el numero entre posicion "+ini+" y posicion "+termi+" ambas incluidas, es "+funciones.trozoDeNumero(n, ini, termi));
		System.out.println("el numero "+n+" junto al numero "+n2+"  es "+funciones.juntaNumeros(n, n2));
		}
}
