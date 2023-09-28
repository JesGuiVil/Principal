package Multimedia;

public class Disco extends Multimedia {
	protected Genero genero;

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Disco() {
		
	}
	
	public Disco(String titulo, String autor, Formatos formato, int duracion, Genero genero) {
		super(titulo, autor, formato, duracion);
		this.genero = genero;
	}

	@Override
	public String toString() {
		return super.toString()+"Disco [genero=" + genero + "]";
	}
	
	
}
