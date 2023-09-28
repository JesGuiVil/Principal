package almacenjc;
import java.util.Scanner;
public class almacenjc {

	public static void main(String[] args) {
		Listados listas= new Listados();
		Scanner sc=new Scanner(System.in);
		int opcion=1;
		do {
			System.out.println("selecione opcion");
			System.out.println("----------------");
			System.out.println("1.alta articulo");
			System.out.println("2.baja articulo");
			System.out.println("3.alta proveedor");
			System.out.println("4.baja proveedor");
			System.out.println("5.listar articulos");
			System.out.println("6.listar proveedores");
			System.out.println("7.realizar venta");
			System.out.println("8.stock articulos");
			System.out.println("0.SALIR");
	
			opcion=sc.nextInt();
	
			if (opcion==1) {listas.altaArticulo();}
			if (opcion==2) {listas.bajaArticulo();}
			if (opcion==3) {listas.altaProveedor();}
			if (opcion==4) {listas.bajaProveedor();}
			if (opcion==5) {listas.listaArticulos();}
			if (opcion==6) {listas.listaProveedores();}
			if (opcion==7) {listas.venta();}
			if (opcion==8) {listas.stock();}
	
		}while (opcion!=0);
	}
}
