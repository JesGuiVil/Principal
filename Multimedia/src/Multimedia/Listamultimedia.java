package Multimedia;

public class Listamultimedia {
	protected Multimedia[] multimedias;
	protected int contador=0;
	
	
	public Multimedia[] getMultimedias() {
		return multimedias;
	}
	public Multimedia obtenerObjeto(int posicion) {
		return this.multimedias[posicion];
	}
	public void setMultimedias(Multimedia[] multimedias) {
		this.multimedias = multimedias;
	}
	
	public Listamultimedia(int limite) {
		this.multimedias = new Multimedia[limite];
		this.contador=0;
		
	}
	public int size() {
		return this.contador;
	}
	public boolean add(Multimedia m) {
		boolean respuesta=false;
		if(contador<multimedias.length) {
			if (m instanceof Multimedia) {
				//AGREGO MULTIMEDIA
				this.multimedias[this.contador]=m;
				this.contador=this.contador+1;
				respuesta=true;
			}
			if (m instanceof Pelicula) {
				//AGREGO PELICULA
				this.multimedias[this.contador-1]= m;	
			}
			if (m instanceof Disco) {
				//AGREGO PELICULA
				this.multimedias[this.contador-1]= m;	
			}
		}
		if(!respuesta) {
			System.out.println("no hay espacio");
		}
		return respuesta;
	}
	public Multimedia get(int posicion) {
		return multimedias[posicion];
	}
	public int indexOf(Multimedia m) {
		int solucion=-1;
		for(int i=0; i<multimedias.length; i++) {
			if (multimedias[i]==m) {
				solucion=i;
				i=multimedias.length;
			}
		}
		return solucion;
	}
	public String toString() {
		String respuesta="";
		for(int i=0; i<contador; i++) {
			respuesta+=multimedias[i].toString();
		}
		return respuesta;
	}
	
}
