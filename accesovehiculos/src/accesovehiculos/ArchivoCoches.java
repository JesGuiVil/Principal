package accesovehiculos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArchivoCoches {

	public static void mostrarMenu() {
		Scanner sc=new Scanner(System.in);
		int opcion=1;
		do {
			System.out.println("Seleccione una opción");
			System.out.println("--------------------");
			System.out.println("1.REGISTRAR COCHE");
			System.out.println("2.LEER COCHE");
			System.out.println("3.LEER TODOS");
			System.out.println("0.SALIR");

			opcion=sc.nextInt();

			if (opcion==1) {
				Vehiculo coche=new Vehiculo();
				coche.pedirDatos();
				coche.registrarCoche();
			}
			if (opcion==2) {
				System.out.println("¿QUÉ COCHE DESEA LEER? (el primer coche es el 0)");
				String respuesta=sc.next();
				int n;
				try {
					n=Integer.parseInt(respuesta);
					leerCoche(n);
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
				}
			}
			if (opcion==3) {
				leerTodos();
			}

		} while (opcion!=0);
	}
	public static void leerCoche(int n) {
		RandomAccessFile raf= null;
		try {
			raf = new RandomAccessFile("archivos//coches.dat", "r");
			raf.seek(102*n);

			byte[] cocheByte = new byte[102];
			String cocheStr="";

			raf.read(cocheByte, 0, 14);//este formato es ((arraydebites sobre el que trabajo), (indice donde empiezo a leer), (cantidad de bytes que quiero leer))
			String matriculaStr = new String(cocheByte, 0, 14);//trim para que al escribir no me ponga los espacios de relleno
			raf.read(cocheByte, 14, 40);
			String marcaStr = new String(cocheByte, 14, 40).trim();
			Double deposit =raf.readDouble();
			String depositoStr = Double.toString(deposit);
			raf.read(cocheByte, 62, 40);
			String modeloStr = new String(cocheByte, 62, 40).trim();

			cocheStr+="Matricula: "+matriculaStr+" \t Marca: "+marcaStr+" \t Deposito: "+depositoStr+" \t Modelo: "+modeloStr+"\n";

			System.out.println(cocheStr);
			
			raf.close();

		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("Ha ocurrido un error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado");
			e.printStackTrace();
		}

	}
	public static void leerTodos() {
		RandomAccessFile raf= null;
		String cocheStr="";
		try {
			raf = new RandomAccessFile("archivos//coches.dat", "r");

			for(int i=0; i<(raf.length()/102); i++) {
			raf.seek(102*i);

			byte[] cocheByte = new byte[102];
			
			raf.read(cocheByte, 0, 14);//este formato es ((arraydebites sobre el que trabajo), (indice donde empiezo a leer), (cantidad de bytes que quiero leer))
			String matriculaStr = new String(cocheByte, 0, 14);//trim para que al escribir no me ponga los espacios de relleno
			raf.read(cocheByte, 14, 40);
			String marcaStr = new String(cocheByte, 14, 40).trim();
			Double deposit =raf.readDouble();
			String depositoStr = Double.toString(deposit);
			raf.read(cocheByte, 62, 40);
			String modeloStr = new String(cocheByte, 62, 40).trim();

			cocheStr+="Matricula: "+matriculaStr+" \t Marca: "+marcaStr+" \t Deposito: "+depositoStr+" \t Modelo: "+modeloStr+"\n";
			}
			System.out.println(cocheStr);
			
			raf.close();

		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("Ha ocurrido un error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado");
			e.printStackTrace();
		}

	}
}
