package Multimedia;

public class Multimedia {
	private String titulo;
	private String autor;
	private Formato formato;
	private double duracion;
	
	public Multimedia(String t, String a, Formato f, double d) {
		this.titulo = t;
		this.autor = a;
		this.formato = f;
		this.duracion = d;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public Formato getFormato() {
		return formato;
	}
	public double getDuracion() {
		return duracion;
	}
	@Override
	public String toString() {
		return "TITULO: " + getTitulo() + " DE " + getAutor() + " \n" +
					"Formato " + getFormato() + " Duracion " + getDuracion();
	}
	

	public boolean equals(Multimedia m) {
		
		return titulo.equals(m.getTitulo()) && autor.equals(m.getAutor());
	}
}
