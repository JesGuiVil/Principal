package Parking;

public class ParkingExcepcion extends Exception {
protected String mensaje;
protected String matricula;
public String getMensaje() {
	return mensaje;
}
public void setMensaje(String mensaje) {
	this.mensaje = mensaje;
}
public String getMatricula() {
	return matricula;
}
public void setMatricula(String matricula) {
	this.matricula = matricula;
}
public ParkingExcepcion() {
super();	
}
public ParkingExcepcion(String mensaje, String matricula){
	super(mensaje + " -- " + matricula);
	this.mensaje=mensaje;
	this.matricula=matricula;


}

}
