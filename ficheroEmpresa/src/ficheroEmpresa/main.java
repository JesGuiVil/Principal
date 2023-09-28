package ficheroEmpresa;



public class main {

	public static void main(String[] args) {
		Empresa miempresa=new Empresa("prueba",5);
		miempresa.nuevoEmpleado("yerai",2000);
		miempresa.nuevoEmpleado("PEPEPEPE", 2000);
		miempresa.nuevoEmpleado("OXELE", 2100);
		miempresa.leerEmpleados();
		miempresa.despideEmpleados(1);
		miempresa.leerEmpleados();
		System.out.println("-----------------");
		Empresa miempresa2=new Empresa("prueba2",5);
		miempresa2.nuevoEmpleado("yerai",2000);
		miempresa2.nuevoEmpleado("PEPEPEPE", 2000);
		miempresa2.nuevoEmpleado("OXELE", 2100);
		miempresa2.leerEmpleados();
		miempresa2.despideEmpleados(1);
		miempresa2.leerEmpleados();
	}

}
