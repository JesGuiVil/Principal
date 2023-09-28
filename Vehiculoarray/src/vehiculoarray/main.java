package vehiculoarray;
import java.util.*;
public class main {

	public static void main(String[] args) {
		String[] tipos={"camion","coche","furgoneta","moto"};
		ArrayList<Vehiculo> vehiculos=new ArrayList<>();
		int totalcamiones=0, totalcoches=0, totalmotos=0, totalfurgos=0;
		for (int i=0; i<1000; i++) {
		vehiculos.add(new Vehiculo(i,tipos[(int) (Math.random()*4)]));
			System.out.println(vehiculos.get(i));
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
		int totalborrados=totalmotos+totalfurgos+totalcamiones;
		System.out.println("----se borran los que no son coches----");
		int auxIndice=0;
		Iterator <Vehiculo> ite= vehiculos.iterator();
		while(ite.hasNext()) {
			Vehiculo x =ite.next();
			if(!x.getTipo().equals("coche")) {
				ite.remove();
			}else {
				auxIndice = x.getId();
			}
		}
		
		totalcamiones=0;
		totalcoches=0;
		totalmotos=0;
		totalfurgos=0;
		for (int i=0; i<vehiculos.size();i++) {
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
		
		System.out.println("coches: "+totalcoches);
		System.out.println("motos: "+totalmotos);
		System.out.println("camiones: "+totalcamiones);
		System.out.println("furgos: "+totalfurgos);
		
		System.out.println("----se añade un coche por cada borrado----");
		
		int inicio=vehiculos.get(vehiculos.size()-1).getId()+1;
		for(int i=inicio; i<inicio+totalborrados; i++) {
			vehiculos.add(new Vehiculo(i,"coche"));
		}
		
		totalcamiones=0;
		totalcoches=0;
		totalmotos=0;
		totalfurgos=0;
		for (int i=0; i<vehiculos.size();i++) {
			System.out.println(vehiculos.get(i));
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
		System.out.println("coches: "+totalcoches);
		System.out.println("motos: "+totalmotos);
		System.out.println("camiones: "+totalcamiones);
		System.out.println("furgos: "+totalfurgos);
	}
}


