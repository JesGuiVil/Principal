package ejercicios1;
import java.util.Scanner;
public class Mesydias {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//dado el numero de un mes presente el nombre del mes y la cantidad de dias que tiene
		Scanner leer=new Scanner (System.in);
		int Mes;
	       System.out.println ("Ingrese el numero del mes");
	       Mes = leer.nextInt();
	       switch (Mes)
	       {
	           case 1: System.out.println("El mes es Enero y tiene 31 dias");
	           break;
	           case 2: System.out.println("El mes es Febrero y tiene 28 dias");
	           break;
	           case 3: System.out.println("El mes es Marzo y tiene 31 dias");
	           break;
	           case 4: System.out.println("El mes es Abril y tiene 30 dias");
	           break;
	           case 5: System.out.println("El mes es Mayo y tiene 31 dias");
	           break;
	           case 6: System.out.println("El mes es Junio y tiene 30 dias");
	           break;
	           case 7: System.out.println("El mes es Julio y tiene 31 dias");
	           break;
	           case 8: System.out.println("El mes es Agosto y tiene 31 dias");
	           break;
	           case 9: System.out.println("El mes es Septiembre y tiene 30 dias");
	           break;
	           case 10: System.out.println("El mes es Octubre y tiene 31 dias");
	           break;
	           case 11: System.out.println("El mes es Noviembre y tiene 30 dias");
	           break;
	           case 12: System.out.println("El mes es Diciembre y tiene 31 dias");
	           break;
					}
	       }
	}			