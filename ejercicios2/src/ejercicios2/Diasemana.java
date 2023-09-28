package ejercicios2;
import java.util.Scanner;
public class Diasemana {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//dado el numero de un dia di que dia de la semana es
		Scanner leer=new Scanner (System.in);
		int dia;
	       System.out.println ("Ingrese el numero del dia de la semana");
	       dia = leer.nextInt();
	       switch (dia)
	       {
	           case 1: System.out.println("El dia es lunes");
	           break;
	           case 2: System.out.println("El dia es martes");
	           break;
	           case 3: System.out.println("El dia es miercoles");
	           break;
	           case 4: System.out.println("El dia es jueves");
	           break;
	           case 5: System.out.println("El dia es viernes");
	           break;
	           case 6: System.out.println("El dia es sabado");
	           break;
	           case 7: System.out.println("El dia es domingo");
	           break;
					}
	       }
	}	