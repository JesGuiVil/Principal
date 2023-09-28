package Empresa;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Empresa empresa1=new Empresa("telepizza", 4);
	empresa1.nuevoEmpleado("paco",1000);
	System.out.println(empresa1.empleados[0]);
	empresa1.empleados[0].ascender();
	System.out.println(empresa1.empleados[0]);
	empresa1.despideEmpleados(0);
	System.out.println(empresa1.empleados[0]);
	empresa1.nuevoEmpleado("paco",1000);
	System.out.println(empresa1.empleados[0]);
	empresa1.empleados[0].aumentarsueldo(2);
	System.out.println(empresa1.empleados[0]);
	empresa1.empleados[0].despedir();
	System.out.println(empresa1.empleados[0]);
	System.out.println("---------------------------------");
	
	empresa1.nuevoEmpleado("pepe",1000);
	empresa1.nuevoEmpleado("piki",1000);
	empresa1.nuevoEmpleado("perro",1000);
	empresa1.nuevoEmpleado("gato",1000);
	for (int i=0; i<empresa1.tamanio;i++) {
		System.out.println(empresa1.empleados[i]);
	}
	
	System.out.println("---------------------------------");
	empresa1.despideEmpleados(2);
	
	for (int i=0; i<empresa1.tamanio;i++) {
		System.out.println(empresa1.empleados[i]);
	}
	System.out.println("---------------------------------");
	empresa1.nuevoEmpleado("paco",1000);
	
	for (int i=0; i<empresa1.tamanio;i++) {
		System.out.println(empresa1.empleados[i]);
	}
	System.out.println("---------------------------------");
	empresa1.nuevoEmpleado("guacamayo",2000);
	}
	

}
