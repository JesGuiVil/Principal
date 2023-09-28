package almacen;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Date;
import java.util.Scanner;


public class Main {
	public static PROVEEDOR codigoproveedor(ArrayList<PROVEEDOR> proveedores, int codigoprov) {
	    return proveedores.stream().filter(proveedor-> codigoprov==proveedor.getCodigo()).findFirst().orElse(null);
	}
	public static ARTICULO codigoarticulo(ArrayList<ARTICULO> articulos, int codigoart) {
	    return articulos.stream().filter(articulo-> codigoart==articulo.getCodigo()).findFirst().orElse(null);
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList <PROVEEDOR> proveedores=new ArrayList<>();
		ArrayList <ARTICULO> articulos=new ArrayList<>();
		ArrayList <VENTAS> ventas=new ArrayList<>();
		int contarticulo=0;
		int contproveedor=0;
		int salir=1;
		while (salir!=0) {
			System.out.println("Elige una opción:\n1. Alta Articulo\n2. Baja Artículo\n3. Alta Proveedor\n4. Baja Proveedor\n5. Listar Artículos\n6. Listar Proveedores\n7. Venta Artículo\n8. Existencias disponibles");
			int respuesta=sc.nextInt();
			while (respuesta>=1 & respuesta<=8) {
				if (respuesta==1) {
				System.out.println("introduce el nombre del producto(sustituye los espacios por barra baja)");
				String nombre=sc.next();
				System.out.println("introduce descripcion del producto(sustituye los espacios por barra baja)");
				String descripcion=sc.next();
				System.out.println("introduce el precio del producto");
				Double precio=sc.nextDouble();
				System.out.println("introduce el iva del producto");
				int iva=sc.nextInt();
				System.out.println("introduce el codigo del proveedor del producto");
				int codigoprov=sc.nextInt();
				if (proveedores.contains(codigoproveedor(proveedores, codigoprov))) {
					System.out.println("introduce el numero de unidades del producto");
					int unidades=sc.nextInt();
					articulos.add(new ARTICULO(contarticulo,nombre,descripcion,precio,iva,codigoproveedor(proveedores,codigoprov),unidades));	
					contarticulo++;
					System.out.println("");
					respuesta=9;
				}else {
					System.out.println("ese proveedor no existe, debe crearlo");
					System.out.println("");
					respuesta=9;
				}
			}
			if (respuesta==2) {
				System.out.println("introduce el codigo del articulo que desea eliminar");
				int codigo=sc.nextInt();
				Iterator <ARTICULO> ite= articulos.iterator();
				while(ite.hasNext()) {
					ARTICULO x =ite.next();
					if(x.getCodigo()==codigo) {
						ite.remove();
						System.out.println("articulo eliminado");
						System.out.println("");
						respuesta=9;
					}
				}
			}
			if (respuesta==3) {
				System.out.println("introduce el nombre del proveedor(sustituye los espacios por barra baja)");
				String nombre=sc.next();
				System.out.println("introduce la direccion del proveedor(sustituye los espacios por barra baja)");
				String direccion=sc.next();
				System.out.println("introduce la fecha de alta");
				String alta=sc.next();
				System.out.println("introduce el tlf del proveedor");
				String tlf=sc.next();
				System.out.println("introduce el correo electronico del proveedor");
				String email=sc.next();
				proveedores.add(new PROVEEDOR(contproveedor,nombre,direccion,alta,tlf,email));
				contproveedor++;
				respuesta=9;
			}
			if (respuesta==4) {
				System.out.println("introduce el codigo del proveedor que desea eliminar");
				int codigo=sc.nextInt();
				Iterator <PROVEEDOR> itep= proveedores.iterator();
				while(itep.hasNext()) {
					PROVEEDOR p =itep.next();
					if(p.getCodigo()==codigo) {
						itep.remove();
						System.out.println("articulo eliminado");
						System.out.println("");
						respuesta=9;
					}
				}
			}
			if(respuesta==5) {
				for(int i=0; i<articulos.size(); i++) {
					System.out.println(articulos.get(i));
				}
				System.out.println("");
				respuesta=9;
			}
			if(respuesta==6) {
				for(int i=0; i<proveedores.size(); i++) {
					System.out.println(proveedores.get(i));	
				}
				System.out.println("");
				respuesta=9;
			}
			if(respuesta==7) {
				System.out.println("introduce el codigo del articulo que vas a vender");
				int codigo=sc.nextInt();
				System.out.println("introduce el numero de unidades que vas a vender");
				int unidades=sc.nextInt();
				System.out.println("introduce la fecha de venta");
				String fecha=sc.next();
				System.out.println("se ha realizado el pago? escriba si o no");
				String pago=sc.next();
				boolean pagado=false;
				if (pago.equals("si")) {
					pagado=true;
				}else {
					pagado=false;
				}
				if(codigoarticulo(articulos,codigo).getUnidades()<unidades) {
					System.out.println("no hay unidades suficientes");
					respuesta=9;
				}else {
						ventas.add(new VENTAS(codigoarticulo(articulos,codigo),fecha,unidades,codigoarticulo(articulos,codigo).preciofinal(),pagado));
						codigoarticulo(articulos,codigo).setUnidades(codigoarticulo(articulos,codigo).getUnidades()-unidades);
					respuesta=9;
				}
			}
			if(respuesta==8) {
				System.out.println("introduzca el codigo del articulo del cual quiere saber las existencias");
				int codigo=sc.nextInt();
				System.out.println("quedan "+codigoarticulo(articulos,codigo).getUnidades()+" unidades de ese articulo");
				System.out.println("");
				respuesta=9;
			}
		}
	}
}
}
