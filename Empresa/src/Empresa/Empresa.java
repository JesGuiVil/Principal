package Empresa;

public class Empresa {
protected String nombre;
protected int tamanio;
protected Empleado [] empleados;


public Empresa(String nombre, int tamanio) {
	this.nombre=nombre;
	this.tamanio=tamanio;
	this.empleados=new Empleado[tamanio];
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

public Empleado getEmpleados(int numero) {
	return empleados[numero];
}
public void despideEmpleados(int numero) {
	this.empleados[numero]=null;
}

public void nuevoEmpleado(String nombre, int sueldo) {
	for(int i=0; i<tamanio;i++) {
		if (empleados[i]==null) {
		empleados[i]=new Empleado(this, nombre, sueldo, i);	
		i=tamanio;
		}else if (i==(tamanio-1)){
		System.out.println("no hay mas huecos");
		}	
	}
}
}
