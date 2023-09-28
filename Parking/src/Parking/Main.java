package Parking;


import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parking parking= new Parking("Centro",10);
		Scanner sc=new Scanner(System.in);
			int opcion=-1;
			String aux, aux2;
			int plaza=-1;
		do {
			System.out.println("Parking "+parking.getNombre());
			System.out.println("----------------");
			System.out.println("1.Entrada de coche");
			System.out.println("2.Salida de coche");
			System.out.println("3.Mostrar parking");
			System.out.println("4.Salir del programa");
			aux=sc.next();
			try {
			opcion=Integer.parseInt(aux);
		}catch (NumberFormatException  e) {
			System.out.println("numero erroneo\n");
		}catch ( Exception ex) {
			System.out.println("algo ha petao");
			sc.nextLine();
		}
			
			if (opcion==1) {
				System.out.println("introduzca la matricula");
				String matricula=sc.next();
				System.out.println("introduzca la plaza");
				aux2=sc.next();
				try {
					plaza=Integer.parseInt(aux2);
					parking.entrada(matricula, plaza);
				}catch (NumberFormatException  e) {
					System.out.println("numero erroneo\n");
				} catch (ParkingExcepcion e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMensaje() + " " + e.getMatricula());
				}catch ( Exception ex) {
					System.out.println("algo ha petao");
					sc.nextLine();
				}
				System.out.println();
				System.out.println("Plazas totales: "+parking.getPlazasTotales());
				System.out.println("Plazas ocupadas: "+parking.getPlazasOcupadas());
				System.out.println("Plazas libres: "+parking.getPlazasLibres());
				System.out.println();
			}
			if (opcion==2) {
				System.out.println("introduzca la matricula");
				String matricula=sc.next();
				try {
				parking.salida(matricula);
				}catch (ParkingExcepcion e) {
					System.out.println(e.getMensaje()+ " " + e.getMatricula());
				}
				System.out.println();
				System.out.println("Plazas totales: "+parking.getPlazasTotales());
				System.out.println("Plazas ocupadas: "+parking.getPlazasOcupadas());
				System.out.println("Plazas libres: "+parking.getPlazasLibres());
				System.out.println();
			}
			if (opcion==3) {
				System.out.println(parking.toString());
				System.out.println();
			}
		}while (opcion!=4);
		sc.close();
	}
	
}
