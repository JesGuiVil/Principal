package Multimedia;
public class ListaMultimedia {
	private Multimedia[] lista;
	private int contador;
	
	public ListaMultimedia(int tam) {
		lista = new Multimedia[tam];
		contador = 0;
	}
	
	public int size() {
		return contador;
	}
	
	private boolean llena() {
		return contador == lista.length;
	}
	
	public boolean add(Multimedia m) {
		if (llena()) {
			return false;
			
		} else {
			lista[contador] = m;
			contador ++; 
			return true;
		}
	}
	
	public Multimedia get(int pos) {
		if (pos<0 || pos >=contador) {
			throw new IndexOutOfBoundsException();
		}
		return lista[pos];
	}
	
	public int indexOf(Multimedia m) {
		for (int i=0; i<contador; i++) {
			if (m.equals(lista[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public String toString() {
		String s="";
		for (int i=0; i<contador; i++) {
			s += lista[i].toString() + "\n\n";
		}
		return s;
	}
	
	
}
