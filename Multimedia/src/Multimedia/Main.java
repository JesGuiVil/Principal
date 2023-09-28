package Multimedia;

public class Main {

	public static void main(String[] args) {
		Listamultimedia lista=new Listamultimedia(10);
		Pelicula p1=new Pelicula("jumanji", "paquito",Formatos.dvd,120,"paco", null);
		Pelicula p2=new Pelicula("jumanjo", "paca",Formatos.dvd,120,null, "manoli");
		Pelicula p3=new Pelicula("jumanja", "rodri",Formatos.dvd,130,"paku", "ricarda");

		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		System.out.println(lista.toString());
		
		
		Disco d1=new Disco("billy talent2", "billy talent",Formatos.mp3,3,Genero.rock);
		Disco d2=new Disco("afraid of heights", "billy talent",Formatos.mp3,3,Genero.rock);
		Disco d3=new Disco("savior", "rise against",Formatos.mp3,4,Genero.rock);
		
		lista.add(d1);
		lista.add(d2);
		lista.add(d3);
		
		System.out.println(lista.toString());
		System.out.println("");
		
		Disco d4=new Disco(d2.getTitulo(), d2.getAutor(),Formatos.mp3,3,Genero.rock);
		for(int i=0; i<lista.size(); i++) {
			if(d4.equals(lista.obtenerObjeto(i))){
				System.out.println(" el disco es"+lista.obtenerObjeto(i)+" y su posicion es "+i);
			}
		}
	}
}
