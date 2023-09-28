package Vehiculo;

public class Mainvehiculos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VehiculoCliente coche1=new VehiculoCliente("2816ggc");
		VehiculoCliente coche2=new VehiculoCliente("1234ggc");
		VehiculoCliente coche3=new VehiculoCliente("4416tkm");
		VehiculoCliente coche4=new VehiculoCliente("2934rbb");
		Parking p1=new Parking ("parkinsito",2);
		Parking p2=new Parking ("parkinaso",4);
		
		p1.libre();
		coche1.aparca(p1);
		p1.libre();
		coche2.aparca(p1);
		p1.libre();
		
		p2.libre();
		p2.disponibles();
		coche1.aparca(p2);
		coche2.aparca(p2);
		coche3.aparca(p2);
		coche4.aparca(p2);
		p2.disponibles();
		coche2.setTiempo(5600);
		System.out.println(coche2);
	}

}
