package Multimedia;
public class Disco extends Multimedia {

	private Genero genero;
	
	public Disco(String t, String a, Formato f, double d, Genero g) {
		super(t,a,f,d);
		this.genero=g;

	}
	public Genero getGenero() {
		return genero;
	}

	public String toString() {
		return super.toString() + "\n G�nero: " + genero;
	}
	
	
}
