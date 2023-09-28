package Multimedia;

public class Multimedia {
protected String titulo;
protected String autor;
protected Formatos formato;
protected int duracion;


public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getAutor() {
	return autor;
}
public void setAutor(String autor) {
	this.autor = autor;
}
public Formatos getFormato() {
	return formato;
}
public void setFormato(Formatos formato) {
	this.formato = formato;
}
public int getDuracion() {
	return duracion;
}
public void setDuracion(int duracion) {
	this.duracion = duracion;
}
public Multimedia(String titulo, String autor, Formatos formato, int duracion) {
	super();
	this.titulo = titulo;
	this.autor = autor;
	this.formato = formato;
	this.duracion = duracion;
}
public Multimedia () {
	
}
@Override
public String toString() {
	return "\n Multimedia [titulo=" + titulo + ", autor=" + autor + ", formato=" + formato + ", duracion=" + duracion
			+ "]";
}
public boolean equals(Multimedia multi) {
	boolean respuesta=false;
	if(multi.getTitulo().equals(this.titulo) & multi.getAutor().equals(this.autor)) {
		respuesta=true;
	}
	return respuesta;
}

}
