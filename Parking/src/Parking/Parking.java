package Parking;

import java.text.ParseException;
import java.util.ArrayList;

public class Parking {
	protected ArrayList<String> matriculas;
	protected String nombre;
	
	
	public String getNombre() {
		return nombre;
	}
	public Parking(){
		
	}
	public Parking(String nombre, int tamanio) {
		this.nombre = nombre;
		this.matriculas= new ArrayList<>();
		for (int i=0; i<tamanio; i++) {
			this.matriculas.add(null);
		}
	}
	public void entrada(String matricula, int plaza) throws ParkingExcepcion {
		
		if(plaza>=matriculas.size()) {
			throw new ParkingExcepcion("plaza incorrecta",matricula);
		}
		if (matricula==null || matricula.length()<4) {
			throw new ParkingExcepcion("matricula incorrecta",matricula);
		}
		if (plaza<matriculas.size()) { 
			if (matriculas.get(plaza)!=null) {
				String auxmatricula=matriculas.get(plaza);
				
				throw new ParkingExcepcion("plaza ocupada por matricula: ",auxmatricula);
			}
		}
		boolean existe=false;
		for (String a: matriculas) {
			if( a!=null) {
				if(a.equals(matricula)) {
				existe=true;
				}
			}
		}
		if (existe) {
			throw new ParkingExcepcion("matricula repetida",matricula);
		}
		matriculas.set(plaza, matricula);
	}
	
	
	public int salida(String matricula) throws ParkingExcepcion {
		boolean existe=false;
		int posicion=-1;
		for (String a: matriculas) {
			if(a!=null) {
				if( a.equals(matricula)) {
				existe=true;
				}
			}
		}
		if (!existe) {
			throw new ParkingExcepcion("matricula no existente",matricula);
		}else {
		posicion=matriculas.indexOf(matricula);
		matriculas.set(posicion, null);
		}
		return posicion;
	}
	
	public int getPlazasTotales() {
		return matriculas.size();
	}
	
	public int getPlazasOcupadas() {
		int contador=0;
		for (String a: matriculas) {
			if( a!=null) {
				contador++;
			}
		}
		return contador;
	}
	
	public int getPlazasLibres() {
		int contador=0;
		for (String a: matriculas) {
			if( a==null) {
				contador++;
			}
		}
		return contador;
	}

	@Override
	public String toString() {
		String cadena="";
		cadena+="Parking "+nombre +"\n-------------";
		for (int i=0; i<matriculas.size(); i++) {
			if (matriculas.get(i)==null) {
			cadena+="\n Plaza "+i+": (vacía)";
			}else {
			cadena+="\n Plaza "+i+": "+matriculas.get(i);	
			}
		}
		return cadena;
	}
	
	
}
