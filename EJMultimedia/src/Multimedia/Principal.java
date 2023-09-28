package Multimedia;

public class Principal {

	public static void main(String[] args) {
		ListaMultimedia lista = new ListaMultimedia(10);
		Pelicula peli;
		int posicion;
		lista.add(new Pelicula("Million Dollar Baby", "Clint Eastwood", Formato.dvd, 137, "Clint Eastwood", "Hillary Swank"));
		lista.add(new Pelicula("El Aviador", "Martin Scorsese", Formato.dvd, 168, "Leonardo Di Caprio", null));
		lista.add(new Pelicula("Mar Adentro", "Alejandro Amenabar", Formato.avi, 125, "Javier Bardem", "Belen Rueda"));
		
		System.out.println(lista.toString());
		
		peli = new Pelicula ("Mar Adentro","Alejandro Amenabar", null, 0, "", "");
		
		posicion = lista.indexOf(peli);
		
		System.out.println("POSICION: " + posicion + "\n" + lista.get(posicion));
		
	}

}
