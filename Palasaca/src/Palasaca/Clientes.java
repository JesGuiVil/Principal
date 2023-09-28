package Palasaca;

import java.util.Scanner;

public class Clientes extends DatosPersonales implements Client{
	protected String situacionLaboral;

	public String getSituacionLaboral() {
		return situacionLaboral;
	}

	protected void setSituacionLaboral(String situacionLaboral) {
		this.situacionLaboral = situacionLaboral;
	}

	public Clientes(String dni, String nombre, String apellido1, String apellido2, String telefono, String email,
			String direccion, String localidad, int codigopostal, String provincia, String fn,
			String observaciones, String situacionLaboral) {
		super(dni, nombre, apellido1, apellido2, telefono, email,direccion,localidad,codigopostal,provincia,fn,observaciones);
		this.situacionLaboral = situacionLaboral;
	}

	public Clientes() {
		super();
		this.situacionLaboral=null;
	}
	
	public void ModificarCliente(Clientes datos) {
			Scanner sc=new Scanner(System.in);
			int opcion=1;
			do {
				System.out.println("modificar cliente:");
				System.out.println("----------------");
				System.out.println("1.modificar DNI");
				System.out.println("2.modificar nombre");
				System.out.println("3.modificar apellido1");
				System.out.println("4.modificar apellido2");
				System.out.println("5.modificar Telefono");
				System.out.println("6.modificar email");
				System.out.println("7.modificar direccion");
				System.out.println("8.modificar localidad");
				System.out.println("9.modificar Codigo postal");
				System.out.println("10.modificar Provincia");
				System.out.println("11.modificar fecha nacimiento");
				System.out.println("12.modificar observaciones");
				System.out.println("13.modificar situacion laboral");
				System.out.println("0.SALIR");

				opcion=sc.nextInt();

				if (opcion==1) {
					System.out.println("introduzca nuevo dato");
					String dato=sc.next();
					datos.setDni(dato);
				}
				if (opcion==2) {
					System.out.println("introduzca nuevo dato");
					String dato=sc.next();
					datos.setNombre(dato);
				}
				if (opcion==3) {
					System.out.println("introduzca nuevo dato");
					String dato=sc.next();
					datos.setApellido1(dato);
				}
				if (opcion==4) {
					System.out.println("introduzca nuevo dato");
					String dato=sc.next();
					datos.setApellido2(dato);
				}
				if (opcion==5) {
					System.out.println("introduzca nuevo dato");
					String dato=sc.next();
					datos.setTelefono(dato);
				}
				if (opcion==6) {
					System.out.println("introduzca nuevo dato");
					String dato=sc.next();
					datos.setEmail(dato);
				}
				if (opcion==7) {
					System.out.println("introduzca nuevo dato");
					String dato=sc.next();
					datos.setDireccion(dato);
				}
				if (opcion==8) {
					System.out.println("introduzca nuevo dato");
					String dato=sc.next();
					datos.setLocalidad(dato);
				}
				if(opcion==9) {
					System.out.println("introduzca nuevo dato");
					String dato=sc.next();
					try {
						int codigoPostal = Integer.parseInt(dato);
						datos.setCodigopostal(codigoPostal);
					} catch (NumberFormatException e) {
						System.out.println("El dato introducido no es válido. Introduce un número entero para el código postal.");
					}
				
				}
				if (opcion==10) {
					System.out.println("introduzca nuevo dato");
					String dato=sc.next();
					datos.setProvincia(dato);
				}
				if (opcion==11) {
					System.out.println("introduzca nuevo dato");
					String dato=sc.next();
					datos.setFn(dato);
				}
				if (opcion==12) {
					System.out.println("introduzca nuevo dato");
					String dato=sc.next();
					datos.setObservaciones(dato);
				}
				if (opcion==13) {
					System.out.println("introduzca nuevo dato");
					String dato=sc.next();
					datos.setSituacionLaboral(dato);
				}
			}while (opcion!=0);	
		
		}

	@Override
	public String toString() {
		return super.toString()+ "\nsituacionLaboral=" + situacionLaboral;
	}
			
	
}
