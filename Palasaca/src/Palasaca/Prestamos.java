package Palasaca;

public class Prestamos extends Productos {
protected Double dineroSolicitado;
protected int plazo;
protected Double interesesM;
protected Double interesesA;
protected String fechaRevision;
protected String fechaSolicitud;
protected boolean fin;


public Double getDineroSolicitado() {
	return dineroSolicitado;
}
protected void setDineroSolicitado(Double dineroSolicitado) {
	this.dineroSolicitado = dineroSolicitado;
}
public int getPlazo() {
	return plazo;
}
protected void setPlazo(int plazo) {
	this.plazo = plazo;
}
public Double getInteresesM() {
	return interesesM;
}
protected void setInteresesM(Double interesesM) {
	this.interesesM = interesesM;
}
public Double getInteresesA() {
	return interesesA;
}
protected void setInteresesA(Double interesesA) {
	this.interesesA = interesesA;
}
public String getFechaRevision() {
	return fechaRevision;
}
protected void setFechaRevision(String fechaRevision) {
	this.fechaRevision = fechaRevision;
}
public String getFechaSolicitud() {
	return fechaSolicitud;
}
protected void setFechaSolicitud(String fechaSolicitud) {
	this.fechaSolicitud = fechaSolicitud;
}
public boolean isFin() {
	return fin;
}
protected void setFin(boolean fin) {
	this.fin = fin;
}

public Prestamos(String descripcion, Double comision, String finicio, String ffinal, Clientes cliente, int clave, Double dineroSolicitado, int plazo, Double interesesM, Double interesesA, String fechaRevision,
		String fechaSolicitud, boolean fin) {
	super(descripcion,comision,finicio,ffinal,cliente,clave);
	this.dineroSolicitado = dineroSolicitado;
	this.plazo = plazo;
	this.interesesM = interesesM;
	this.interesesA = interesesA;
	this.fechaRevision = fechaRevision;
	this.fechaSolicitud = fechaSolicitud;
	this.fin = fin;
}


}