package almacenjc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Listados {
 ArrayList<Proveedor> proveedores= new ArrayList<Proveedor>();
 ArrayList<Articulo> articulos= new ArrayList<Articulo>();
 ArrayList<Ventas> ventas= new ArrayList<Ventas>();
 int contadorProveedor=1;
 int contadorArticulo=1;
 Scanner sc=new Scanner(System.in);
 public void altaProveedor() {
	 Proveedor ProveAux= new Proveedor();
	 ProveAux.setCodigo(contadorProveedor);
	 System.out.println("introduce nombre del proveedor(usar barra baja en lugar de espacio)");
	 ProveAux.setNombre(sc.next());
	 System.out.println("direccion del proveedor(usar barra baja en lugar de espacio)");
	 ProveAux.setDireccion(sc.next());
	 System.out.println("fecha de alta dle proveedor");
	 ProveAux.setfAlta(sc.next());
	 System.out.println("email del proveedor");
	 ProveAux.setEmail(sc.next());
	 System.out.println("telefono del proveedor");
	 ProveAux.setTelefono(sc.next());
	 proveedores.add(ProveAux);
	 contadorProveedor++;
 
 }
 public void altaArticulo() {
	 Articulo ArtiAux= new Articulo();
	 ArtiAux.setCodigo(contadorArticulo);
	 System.out.println("introduce nombre del articulo(usar barra baja en lugar de espacio)");
	 ArtiAux.setNombre(sc.next());
	 System.out.println("descripcion del articulo(usar barra baja en lugar de espacio)");
	 ArtiAux.setDescripcion(sc.next());
	 System.out.println("precio del articulo");
	 ArtiAux.setPrecio(sc.nextDouble());
	 System.out.println("iva del articulo");
	 ArtiAux.setIva(sc.nextInt());
	 System.out.println("codigo del proveedor");
	 int codigo=sc.nextInt();
	 boolean existe=false;
	 for(Proveedor a: proveedores) {
		 if(a.getCodigo()==codigo) {
			 ArtiAux.setProveedor(a);
			 System.out.println("unidades del articulo");
			 int unidades=sc.nextInt();
			 ArtiAux.setUnidades(unidades);
			 articulos.add(ArtiAux);
			 contadorArticulo++;
			 existe=true;	 
		 }
	 }
	 if(!existe) {
		 System.out.println("ese proveedor no existe, primero debe crear el proveedor. vamos a ello:");
		 System.out.println("");
		 altaProveedor();	 
	 }
 }
 public void listaArticulos() {
	 for(Articulo a: articulos) {
		 System.out.println(a);
	 }
 }
 public void listaProveedores() {
	 for(Proveedor p: proveedores) {
		 System.out.println(p);
	 }
 }
 public void bajaArticulo(){
	 System.out.println("introduce el codigo del articulo que desea eliminar");
		int codigo=sc.nextInt();
		Iterator <Articulo> ite= articulos.iterator();
		boolean existe=false;
		while(ite.hasNext()) {
			Articulo x =ite.next();
			if(x.getCodigo()==codigo) {
				ite.remove();
				System.out.println("articulo eliminado");
				System.out.println(""); 
				existe=true;
			}
		}
		if(!existe) {
			System.out.println("ese articulo no existe");
			System.out.println("");	 
		}
 }
 public void bajaProveedor() {
	 System.out.println("introduce el codigo del proveedor que desea eliminar");
		int codigo=sc.nextInt();
		Iterator <Proveedor> itep= proveedores.iterator();
		boolean existe=false;
		while(itep.hasNext()) {
			Proveedor p =itep.next();
			if(p.getCodigo()==codigo) {
				itep.remove();
				System.out.println("proveedor eliminado");
				System.out.println("");
				existe=true;
			}
		}
		if(!existe) {
			System.out.println("ese proveedor no existe");
			System.out.println("");	 
		}
 }
 public void venta() {
	 Ventas VentaAux=new Ventas();
	 System.out.println("introduce el codigo del articulo que vas a vender");
	 int codigo=sc.nextInt();
	 System.out.println("fecha de la venta(usar barra baja en lugar de espacio)");
	 VentaAux.setFechacompra(sc.next());
	 System.out.println("introduce las unidades vendidas");
	 VentaAux.setUnidadesvendidas(sc.nextInt());
	 boolean existe=false;
	 for(Articulo a: articulos) {
		 if(a.getCodigo()==codigo) {
			 existe=true;
			 if(a.getUnidades()<VentaAux.getUnidadesvendidas()) {
				 System.out.println("unidades insuficientes para realizar la venta");
			 }else {
				 System.out.println("se ha realizado el pago? escriba si o no");
					String pago=sc.next();
					boolean pagado=false;
					if (pago.equals("si")) {
						pagado=true;
					}else {
						pagado=false;
					}
					VentaAux.setPagado(pagado);
					VentaAux.setArticulo(a);
					 VentaAux.setPreciototal(a.preciofinal()*VentaAux.getUnidadesvendidas());
					 ventas.add(VentaAux); 
					 a.setUnidades(a.getUnidades()-VentaAux.getUnidadesvendidas());
			 }
		 }
	 }
	 if(!existe) {
		System.out.println("ese articulo no existe");
		System.out.println("");	 
	 }
 
 }
 public void stock() {
	 System.out.println("introduzca el codigo del articulo del cual quiere saber las existencias");
		int codigo=sc.nextInt();
		boolean existe=false;
		 for(Articulo a: articulos) {
			 if(a.getCodigo()==codigo) {
				 Articulo artiAux= a; 
				 existe=true;
				 System.out.println("quedan "+artiAux.getUnidades()+" unidades de ese articulo");
				 System.out.println("");
			 }
		 }
		 if(!existe) {
			 System.out.println("ese articulo no existe");
			 System.out.println("");	 
		 }
		
 }
}
