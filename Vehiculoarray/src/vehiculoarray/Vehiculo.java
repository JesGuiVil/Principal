package vehiculoarray;

public class Vehiculo {
protected int id;
protected String tipo;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public Vehiculo(int id, String tipo) {
	this.id=id;
	this.tipo=tipo;
}

public String toString() {
	return "Vehiculo [id=" + id + ", tipo=" + tipo + "]";
}






}
