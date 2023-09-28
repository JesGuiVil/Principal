package ficheroEmpresa;

import java.io.*;
import java.util.ArrayList;

public class Empresa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected int tamanio;
	protected transient Empleado [] empleados;
	protected int contador;
	static FileOutputStream escritura = null;
	static ObjectOutputStream escribir = null;
	static FileInputStream lectura = null;
	static ObjectInputStream oisLectura = null;


	public Empresa(String nombre, int tamanio) {
		this.nombre=nombre;
		this.tamanio=tamanio;
		this.empleados=new Empleado[tamanio];

	}


	public int getContador() {
		return contador;
	}


	public void setContador(int contador) {
		this.contador = contador;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public Empleado getEmpleado(int numero) {
		return empleados[numero];
	}
	public void despideEmpleados(int numero) {
		this.empleados[numero]=null;
		try {
			escritura = new FileOutputStream("archivos/"+this.nombre+"MisEmpleados");
			escribir = new ObjectOutputStream(escritura);
			escribir.writeObject(empleados);

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {

				if(escribir!=null) {
					escribir.close();
				}
				if(escritura!=null) {
					escritura.close();
				}
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public void nuevoEmpleado(String nombre, int sueldo) {
		for(int i=0; i<tamanio;i++) {
			if (empleados[i]==null) {
				empleados[i]=new Empleado(this, nombre, sueldo, i);	
				i=tamanio;
				try {
					escritura = new FileOutputStream("archivos/"+this.nombre+"MisEmpleados");
					escribir = new ObjectOutputStream(escritura);
					escribir.writeObject(empleados);

				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					try {

						if(escribir!=null) {
							escribir.close();
						}
						if(escritura!=null) {
							escritura.close();
						}
					}catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
			}else if (i==(tamanio-1)){
				System.out.println("no hay mas huecos");
			}
		}
	}


	public void leerEmpleados() {
		try {
			lectura = new FileInputStream("archivos/"+this.nombre+"MisEmpleados");
			oisLectura = new ObjectInputStream(lectura);

			Empleado[] leerarray= (Empleado[]) oisLectura.readObject();

			for(Empleado emp: leerarray) {
				System.out.println(emp);	
			}

		}catch (Exception e) {
			e.printStackTrace();

		}finally {
			if(oisLectura != null) {
				try {
					oisLectura.close();
					lectura.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}


	}

}



