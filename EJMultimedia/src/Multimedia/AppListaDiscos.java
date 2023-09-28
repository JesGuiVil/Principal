package Multimedia;
public class AppListaDiscos {

	public static void main(String[] args) {
		ListaMultimedia lista = new ListaMultimedia(10);
		Disco disco;
		int pos;
		lista.add(new Disco("Hopes and Fears", "Keane", Formato.mp3, 45, Genero.pop));
		lista.add(new Disco("How to dismantle an atomic bomb", "U2", Formato.cdAudio, 49, Genero.rock));
		lista.add(new Disco("Soy gitano", "Camar�n", Formato.cdAudio, 32, Genero.flamenco));
		
		System.out.println(lista.toString());
		
		disco = new Disco("Soy gitano", "Camar�n", null, 0, null);
		
		pos = lista.indexOf(disco);
		
		System.out.println("Posicion: " + pos + " \n " + lista.get(pos));
		

	}

}
