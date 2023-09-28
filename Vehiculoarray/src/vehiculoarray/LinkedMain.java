package vehiculoarray;
import java.util.*;
public class LinkedMain {

	public static void main(String[] args) {
		String[] tipos={"camion","coche","furgoneta","moto"};
		LinkedList<Vehiculo> vehiculos=new LinkedList<>();
		int totalcamiones=0, totalcoches=0, totalmotos=0, totalfurgos=0;
		for (int i=0; i<1000; i++) {
		vehiculos.add(new Vehiculo(i,tipos[(int) (Math.random()*4)]));
			if (vehiculos.get(i).getTipo().equals("coche")) {
				totalcoches++;
			}
			if (vehiculos.get(i).getTipo().equals("camion")) {
				totalcamiones++;
			}
			if (vehiculos.get(i).getTipo().equals("moto")) {
				totalmotos++;
			}
			if (vehiculos.get(i).getTipo().equals("furgoneta")) {
				totalfurgos++;
			}
		}
		System.out.println("coches: "+totalcoches);
		System.out.println("motos: "+totalmotos);
		System.out.println("camiones: "+totalcamiones);
		System.out.println("furgos: "+totalfurgos);
		int contador=0;
		for(int i=999; i>=0; i--) {
			if(!vehiculos.get(i).getTipo().equals("coche")) {
				vehiculos.set(i,null);
				contador++;
			}
		}
		for (int i=1000; i<(1000+contador); i++) {
			vehiculos.add(new Vehiculo(i,"coche"));
		}
		totalcamiones=0;
		totalcoches=0;
		totalmotos=0;
		totalfurgos=0;
		for (int i=0; i<vehiculos.size();i++) {
			System.out.println(vehiculos.get(i));
			if (vehiculos.get(i)!=null) {
				if(vehiculos.get(i).getTipo().equals("coche")) {
					totalcoches++;
				}
				if (vehiculos.get(i).getTipo().equals("camion")) {
				totalcamiones++;
				}
				if (vehiculos.get(i).getTipo().equals("moto")) {
				totalmotos++;
				}
				if (vehiculos.get(i).getTipo().equals("furgoneta")) {
				totalfurgos++;
				}
			}
		}
		System.out.println("coches: "+totalcoches);
		System.out.println("motos: "+totalmotos);
		System.out.println("camiones: "+totalcamiones);
		System.out.println("furgos: "+totalfurgos);
		//LA VERDAD ES QUE NO OBSERVO NINGUNA DIFERENCIA
	}
}
