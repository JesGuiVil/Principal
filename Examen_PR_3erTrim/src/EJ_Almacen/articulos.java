package EJ_Almacen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/** CLASE ARTÍCULOS. 
 * Base para generar fichero aleatorio del almacén.
 * 
 * @author Juan Carlos
 * @version 1.0
 * @date May/2023
 *
 *
 * Nota: Se debe modificar la presente clase para utilizarla para el fichero "ALMACEN.DAT"
 */
public class articulos {
	
	/* ATRIBUTOS de la Clase ARTICULOS */
	
	/** Atributo; COD_ART. Identificación del artículo
	 *  Formato: 3 caracteres + 3 números 
	 *  Ejemplo: Artículo PAN: PAN001 
	 *  Ejemplo: Artículo LECHE: LEC001 .... etc 
	 *  TAMAÑO: 6 caracteres. */
	private String cod_art;
	
	/** Atributo DESCR. Descripción/Identificación del artículo 
	 * TAMAÑO: 20 caracteres. */
	private String descr;
	
	/** Atributo CARACT. Características del artículo. 
	 * TAMAÑO: 20 caracteres. */	
	private String caract;
	
	/** Atributo DEPART. Departamento al que pertenece el artículo 
	 * TAMAÑO: 10 caracteres. */
	private String depart;
	
	/** Atributo PRECIO. Precio en decimal(con dos decimales) del artículo */
	private Double precio;
	
	/** Atributo UNIDADES. Unidades disponibles del artículo. Numérico entero*/
	private int unidades;
	
	/** Atributo PROVEEDOR. Nombre/Identificación del proveedor del artículo 
	 * TAMAÑO: 20 caracteres. */
	private String proveedor;
	
	static RandomAccessFile raf= null;
	/* Constructores de la clase ARTICULO */
	
	public articulos() {
		super();
	}

	public articulos(String cod, String des, String cara, String dep, double p, int s, String prove) {
		super();
		setCod_art(cod);
		setDescr(des);
		setCaract(cara);
		setDepart(dep);
		setPrecio(p);
		setUnidades(s);
		setProveedor(prove);
	}
	
	/*Métodos Setter y Getter de los atributos */
	


	public String getCod_art() {
		return cod_art;
	}

	public void setCod_art(String cod_art) {
		this.cod_art = cod_art;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getCaract() {
		return caract;
	}

	public void setCaract(String caract) {
		this.caract = caract;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	
	/* Método toString predefinido por @author */
	@Override
	public String toString() {
		return "ARTICULO --  ["+ cod_art + " \t " + descr + " - " + caract + " \t" + precio + "€ " + unidades + " unidades ] \n";
	}
	//metodo que determina el espacio de cada atributo en bytes y los escribe en el documento
	public void registrarArticulo() {
		RandomAccessFile raf= null;
		try {
			raf = new RandomAccessFile("almacen.dat", "rw");
			raf.seek(raf.length());
			StringBuffer bufferDescri = new StringBuffer();
			StringBuffer bufferCaract = new StringBuffer();
			StringBuffer bufferDepart = new StringBuffer();
			StringBuffer bufferProove = new StringBuffer();

			if (getCod_art()!=null) {
				raf.writeChars(getCod_art());
			}
			if (getDescr()!=null) {
				bufferDescri.append(getDescr());
				bufferDescri.setLength(20);
				raf.writeChars(bufferDescri.toString());
			}
			if (getCaract()!=null) {
				bufferCaract.append(getCaract());
				bufferCaract.setLength(20);
				raf.writeChars(bufferCaract.toString());
			}
			if (getDepart()!=null) {
				bufferDepart.append(getDepart());
				bufferDepart.setLength(10);
				raf.writeChars(bufferDepart.toString());
			}
			if (getPrecio()!=null) {
				raf.writeDouble(getPrecio());
			}
			if (getUnidades()!=-1) {
				raf.writeInt(getUnidades());
			}
			if (getProveedor()!=null) {
				bufferProove.append(getProveedor());
				bufferProove.setLength(20);
				raf.writeChars(bufferProove.toString());
			}
			
			raf.close();

		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado");
			e.printStackTrace();
		}
	}
	// metodo que secciona el documento en grupos de 164 bytes para leer cada articulo de forma ordenada
	public static void leerTodos() {
		RandomAccessFile raf= null;
		String articuloStr="";
		try {
			raf = new RandomAccessFile("almacen.dat", "r");

			for(int i=0; i<(raf.length()/164); i++) {
			raf.seek(164*i);

			byte[] articuloByte = new byte[164];
			
			raf.read(articuloByte, 0, 12);//este formato es ((arraydebites sobre el que trabajo), (indice donde empiezo a leer), (cantidad de bytes que quiero leer))
			String codigoStr = new String(articuloByte, 0, 12);//trim para que al escribir no me ponga los espacios de relleno
			raf.read(articuloByte, 12, 40);
			String descriStr = new String(articuloByte, 12, 40).trim();
			raf.read(articuloByte, 52, 40);
			String caractStr = new String(articuloByte, 52, 40).trim();
			raf.read(articuloByte, 92, 20);
			String DepartStr = new String(articuloByte, 92, 20).trim();
			Double precio =raf.readDouble();
			String precioStr = Double.toString(precio);
			int unidades =raf.readInt();
			String unidadesStr = Integer.toString(unidades);
			raf.read(articuloByte, 124, 40);
			String proveedorStr = new String(articuloByte, 124, 40).trim();

			articuloStr+="codigo: "+codigoStr+" \t\t descripcion: "+descriStr+" \t\t caracteristica: "+caractStr+" \t\t Departamento:"
					+ " "+DepartStr+" \t\t precio: "+precioStr+" \t\t unidades: "+unidadesStr+" \t\t proveedor: "+proveedorStr+"\n";
			}
			System.out.println(articuloStr);
			
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
	//metodo que recibe una posicion de articulo y lo ubica en el documento para mostrar la informacion por pantalla
	public static void leerArticulo(int n) {
		RandomAccessFile raf= null;
		try {
			raf = new RandomAccessFile("almacen.dat", "r");
			raf.seek(164*(n-1));

			byte[] articuloByte = new byte[164];
			String articuloStr="";
			
			raf.read(articuloByte, 0, 12);
			String codigoStr = new String(articuloByte, 0, 12);
			raf.read(articuloByte, 12, 40);
			String descriStr = new String(articuloByte, 12, 40).trim();
			raf.read(articuloByte, 52, 40);
			String caractStr = new String(articuloByte, 52, 40).trim();
			raf.read(articuloByte, 92, 20);
			String DepartStr = new String(articuloByte, 92, 20).trim();
			Double precio =raf.readDouble();
			String precioStr = Double.toString(precio);
			int unidades =raf.readInt();
			String unidadesStr = Integer.toString(unidades);
			raf.read(articuloByte, 124, 40);
			String proveedorStr = new String(articuloByte, 124, 40).trim();

			articuloStr+="codigo: "+codigoStr+" \t descripcion: "+descriStr+" \t caracteristica: "+caractStr+" \t Departamento:"
					+ " "+DepartStr+" \t precio: "+precioStr+" \t unidades: "+unidadesStr+" \t proveedor: "+proveedorStr+"\n";
			
			System.out.println(articuloStr);
			
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
	//metodo que va de articulo en articulo obteniendo el precio y unidades de cada articulo y va haciendo la suma total
	public static void coste_almacen() {
	    RandomAccessFile raf = null;
	    double total = 0.0;

	    try {
	        raf = new RandomAccessFile("almacen.dat", "r");

	        for (int i = 0; i < (raf.length() / 164); i++) {
	            raf.seek(164 * i + 112); // Saltar a los bytes del precio
	            double precio = raf.readDouble();

	            raf.seek(164 * i + 120); // Saltar a los bytes de las unidades
	            int unidades = raf.readInt();
	            
	            double precioTotal = precio * unidades;
	            total += precioTotal;
	        }

	        System.out.println("Total del precio: " + total);

	        raf.close();

	    } catch (FileNotFoundException e) {
	        System.out.println("Archivo no encontrado");
	        e.printStackTrace();
	    } catch (IOException e) {
	        System.out.println("Ha ocurrido un error de entrada/salida");
	        e.printStackTrace();
	    } catch (Exception e) {
	        System.out.println("Ha ocurrido un error inesperado");
	        e.printStackTrace();
	    }
	}


	//metodo que ubica un articulo segun su codigo, considera la venta realizada y resta las unidades
	public static void venta(String cod, int unidades) {
	    File archivo = new File("almacen.dat");

	    try (RandomAccessFile raf = new RandomAccessFile(archivo, "rw")) {
	        long fileSize = raf.length();
	        long currentPosition = 0;
	        boolean articuloEncontrado = false;

	        while (currentPosition < fileSize) {
	            // Leer el código del artículo actual
	            String currentCod = leerBytes(raf, 12);

	            if (currentCod.equals(cod)) {
	                // Artículo encontrado, actualizar unidades y mostrar venta
	                articuloEncontrado = true;
	                raf.seek(currentPosition + 120); // Posicionarse en el campo de unidades
	                int unidadesActuales = raf.readInt();
	                int unidadesActualizadas = unidadesActuales - unidades;
	                raf.seek(currentPosition + 120); // Posicionarse nuevamente en el campo de unidades
	                raf.writeInt(unidadesActualizadas);

	                System.out.println("Venta realizada:");
	                System.out.println("Código: " + cod);
	                System.out.println("Unidades vendidas: " + unidades);
	                System.out.println("Unidades restantes: " + unidadesActualizadas);
	                break;
	            }

	            currentPosition += 164; // Tamaño total de cada artículo en bytes
	        }

	        if (!articuloEncontrado) {
	            System.out.println("El artículo con código " + cod + " no fue encontrado en el archivo.");
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("No se ha encontrado el archivo");
	        e.printStackTrace();
	    } catch (IOException e) {
	        System.out.println("Ha ocurrido un error de entrada/salida");
	        e.printStackTrace();
	    } catch (Exception e) {
	        System.out.println("Ha ocurrido un error inesperado");
	        e.printStackTrace();
	    }
	}
	//metodo que ubica un articulo segun su codigo en el documento NO SE POR QUE NO FUNCIONA
	public static void leerBorrar(String codigo) {
	    RandomAccessFile raf = null;
	    int posicion = -1;
	    
	    try {
	        raf = new RandomAccessFile("almacen.dat", "r");

	        for (int i = 0; i < (raf.length() / 164); i++) {
	            raf.seek(164 * i);
	            byte[] articuloByte = new byte[164];

	            raf.read(articuloByte, 0, 12);
	            String codigoStr = new String(articuloByte, 0, 12);
	            if (codigoStr.contains(codigo)) {
	                posicion = i;
	                break; // Salir del bucle una vez encontrado el código del artículo
	            }
	            // Resto del código para leer los datos del artículo
	        }
	        
	        raf.close();
	        
	        if (posicion != -1) {
	            eliminarArticulo(posicion);
	        } else {
	            System.out.println("No se encontró el artículo con el código especificado.");
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Archivo no encontrado");
	        e.printStackTrace();
	    } catch (IOException e) {
	        System.out.println("Ha ocurrido un error de entrada/salida");
	        e.printStackTrace();
	    } catch (Exception e) {
	        System.out.println("Ha ocurrido un error inesperado");
	        e.printStackTrace();
	    }
	}
	//metodo que elimina un registro segun su posicion en el docuento TAMPOCO FUNCIONA PORQUE DEPENDE DEL ANTERIOR, PERO ESTAN DESARROLLADOS.
	public static void eliminarArticulo(int posicion) {
	    File archivoOriginal = new File("almacen.dat");
	    File archivoTemporal = new File("almacen.tmp");

	    try (
	        RandomAccessFile rafOriginal = new RandomAccessFile(archivoOriginal, "rw");
	        RandomAccessFile rafTemporal = new RandomAccessFile(archivoTemporal, "rw")
	    ) {
	        long fileSize = rafOriginal.length();
	        long posicionInicial = posicion * 164;

	        if (posicionInicial >= fileSize) {
	            System.out.println("La posición está fuera del rango del archivo.");
	            return;
	        }

	        long currentPosition = 0;

	        while (currentPosition < fileSize) {
	            if (currentPosition == posicionInicial) {
	                // Saltar el artículo a eliminar
	                currentPosition += 164; // tamaño total del artículo a eliminar en bytes
	                rafOriginal.seek(currentPosition);
	            } else {
	                // Copiar el artículo al archivo temporal
	                rafOriginal.seek(currentPosition);
	                for (int i = 0; i < 164; i++) {
	                    rafTemporal.write(rafOriginal.readByte());
	                }
	            }

	            currentPosition += 164; // tamaño total de cada artículo en bytes
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("No se ha encontrado el archivo");
	        e.printStackTrace();
	    } catch (IOException e) {
	        System.out.println("Ha ocurrido un error de entrada/salida");
	        e.printStackTrace();
	    } catch (Exception e) {
	        System.out.println("Ha ocurrido un error inesperado");
	        e.printStackTrace();
	    }

	    // Cerrar los archivos antes de eliminarlos o renombrarlos
	    archivoOriginal.delete();
	    archivoTemporal.renameTo(archivoOriginal);
	}
	

	// Método auxiliar para leer una cadena de bytes del archivo
	public static String leerBytes(RandomAccessFile raf, int length) throws IOException {
	    byte[] buffer = new byte[length];
	    raf.readFully(buffer);
	    return new String(buffer);
	}

	
}
