package EJ_Almacen;
/** CLASE ALMACÉN. 
 * Clase para incluir todo el código
 * para generar fichero aleatorio del almacén.
 * 
 * @author Juan Carlos
 * @version 1.0
 * @date May/2023
 *
 * @fichero almacen.dat
 * 
 * Nombre de fichero: "ALMACEN.DAT"
 */
public class almacen {
	// INSERTAR TODO EL CóDIGO NECESARIO PARA GESTIONAR EL FICHERO
	// Y RESOLVER EJERCICIO EXAMEN.
	public static void main(String[] args) {
		
		//apartado A, inserción de 10 registros
				articulos bollo=new articulos("PAN001","bollo","tierno","alimentos",0.55,20,"panadero");
				bollo.registrarArticulo();
				articulos leche=new articulos("LEC001","leche","entera","alimentos",0.65,10,"lechero");
				leche.registrarArticulo();
				articulos pollo=new articulos("POL001","pollo","asado","alimentos",3.50,15,"ganadero");
				pollo.registrarArticulo();
				articulos pizza=new articulos("PIZ001","pizza","4quesos","alimentos",2.50,15,"pizzero");
				pizza.registrarArticulo();
				articulos agua=new articulos("AGU001","aguas","mineral","alimentos",1.50,15,"fontbella");
				agua.registrarArticulo();
				articulos atun=new articulos("ATU001","pescado","lata","alimentos",1.50,15,"pescadero");
				atun.registrarArticulo();
				articulos vasos=new articulos("VAS001","maceta","blando","consumible",1.50,15,"fabrica");
				vasos.registrarArticulo();
				articulos platos=new articulos("PLA001","hondo","blanco","consumible",2.50,15,"fabrica");
				platos.registrarArticulo();
				articulos tenedor=new articulos("TEN001","corto","blanco","consumible",1.50,15,"fabrica");
				tenedor.registrarArticulo();
				articulos cuchara=new articulos("CUC001","corta","blanco","consumible",1.50,15,"fabrica");
				cuchara.registrarArticulo();
				
				//apartado B, generar un metodo que nos muestre por pantalla el coste total del stock actual de nuestro almacen
				articulos.coste_almacen();
				
				//apartado C, eliminar un articulo usando un metodo al que se le introduzca el codigo del articulo a eliminar
				articulos.leerBorrar("LEC001");
				
				//apartado D, metodo para realizar ventas al que le introduzcamos codigo y unidades vendidas y se registre en el archivo
				articulos.venta("PAN001", 5);
				
				//apartado F, acceder al elemento en la posicion 7 y mostrar la informacion del articulo
				articulos.leerArticulo(7);
				
				//apartado E, crear un metodo que muestre todo el almacen
				articulos.leerTodos();
				
				/*apartado G, responder preguntas
				1.¿que tamaño tiene nuestro fichero?
				considerando que cada registros son 164 bytes, con 10 registros tendrá 1640bytes
				2.¿cuantos registros tenemos en el fichero?
				podemos dividir los bytes que ocupe el archivo entre 164 y sabremos el numero de registros que tenemos insertados
				3.¿que tamaño tiene un registro cualquiera de nuestro fichero?
				nuestros registros son de 164 bytes, ya que el codigo son 12,
				 descripcion caracteristicas y proveedor son 40 cada uno,
				  departamento son 20, el precio son 8 y las unidades 4
				*/

	}

}
