package Empresa;

public class Ejecutivo extends Empleado {
	protected int presupuesto;
	 
	 public Ejecutivo(Empresa empresa, String nombre, int sueldo) {
		 super(empresa, nombre, sueldo);
	 }
	 protected Ejecutivo(Empresa empresa, String nombre, int sueldo, int numEmpleado) {
		 super(empresa, nombre, sueldo, numEmpleado);
	 }
	public int getPresupuesto() {
		return presupuesto;
	}
	public void asignaPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	public String toString() {
		String cadena=super.toString();
		cadena+=" ejecutivo, presupuesto="+presupuesto;
		return cadena;
	}
	
	 
}
