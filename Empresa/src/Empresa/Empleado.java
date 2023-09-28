package Empresa;

public class Empleado {
 protected String nombre;
 protected int sueldo;
 protected int numEmpleado;
 protected Empresa empresa;
 
 public Empleado(Empresa empresa, String nombre, int sueldo) {
	 this.nombre=nombre;
	 this.sueldo=sueldo;
 	 this.empresa=empresa;
 }
 protected Empleado(Empresa empresa, String nombre, int sueldo, int numEmpleado) {
	 this.nombre=nombre;
	 this.sueldo=sueldo;
	 this.empresa=empresa;
	 this.numEmpleado = numEmpleado;
	 empresa.empleados[numEmpleado]=this;
 }
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getSueldo() {
	return sueldo;
}
public void setSueldo(int sueldo) {
	this.sueldo = sueldo;
}
public int getNumEmpleado() {
	return numEmpleado;
}
public String toString() {
	return "Empresa="+empresa.getNombre()+", Empleado [nombre=" + nombre + ", sueldo=" + sueldo + ", numEmpleado=" + numEmpleado + "]";
}
public void aumentarsueldo(int n) {
	this.setSueldo(this.getSueldo()+(this.getSueldo()*n/100));
}
public void despedir() {
	empresa.despideEmpleados(numEmpleado);
}
public void ascender() {
	this.empresa.empleados[this.getNumEmpleado()]=new Ejecutivo(this.empresa, this.getNombre(), this.getSueldo(),this.getNumEmpleado());
}
 
}
