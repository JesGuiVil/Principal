package Multimedia;

public class Pelicula extends Multimedia {
protected String actorprincipal;
protected String actrizprincipal;
public String getActorprincipal() {
	return actorprincipal;
}
public void setActorprincipal(String actorprincipal) {
	this.actorprincipal = actorprincipal;
}
public String getActrizprincipal() {
	return actrizprincipal;
}
public void setActrizprincipal(String actrizprincipal) {
	this.actrizprincipal = actrizprincipal;
}
public Pelicula(String titulo, String autor, Formatos formato, int duracion, String actorprincipal,
		String actrizprincipal) {
	super(titulo, autor, formato, duracion);
	if (actorprincipal==null && actrizprincipal==null) {
		System.out.println("la pelicula necesita un protagonista");
	}else {
		this.actorprincipal = actorprincipal;
		this.actrizprincipal = actrizprincipal;
	}
}
public Pelicula() {
	
}
@Override
public String toString() {
	return super.toString()+" Pelicula [actorprincipal=" + actorprincipal + ", actrizprincipal=" + actrizprincipal + "]";
}

}
