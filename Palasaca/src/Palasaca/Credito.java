package Palasaca;

public class Credito extends Tarjetas{
	protected Double saldodisponible;
	protected Double saldofactura;
	protected String fechaFacturacion;
	protected Double recargoCredito;
	


	public Double getSaldodisponible() {
		return saldodisponible;
	}
	public void setSaldodisponible(Double saldodisponible) {
		this.saldodisponible = saldodisponible;
	}
	public Double getSaldofactura() {
		return saldofactura;
	}
	public void setSaldofactura(Double saldofactura) {
		this.saldofactura = saldofactura;
	}
	public String getFechaFacturacion() {
		return fechaFacturacion;
	}
	public void setFechaFacturacion(String fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}
	public Double getRecargoCredito() {
		return recargoCredito;
	}
	public void setRecargoCredito(Double recargoCredito) {
		this.recargoCredito = recargoCredito;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\nCredito: \nsaldodisponible=" + saldodisponible + ", \nsaldofactura=" + saldofactura + ", \nfechaFacturacion="+ fechaFacturacion;
	}
	public Credito() {
		super();
	}

	public Credito(String descripcion, Double comision, String finicio, String ffinal, Clientes cliente, int clave, Cuentas cuenta, String numerotarjeta, int ping, String seguridad,String fcaducidad, Double saldodisponible, String fechaFacturacion) {
		super(descripcion,comision,finicio,ffinal,cliente,clave,cuenta,numerotarjeta,ping,seguridad,fcaducidad);
		this.saldodisponible = saldodisponible;
		this.saldofactura = 0.0;
		this.fechaFacturacion = fechaFacturacion;
		this.recargoCredito = saldodisponible;
	}
	public Double sacaCredito(int cantidad) {
		if(correcto) {
			if (cantidad<saldodisponible) {
			setSaldodisponible(getSaldodisponible()-cantidad);
			setSaldofactura(getSaldofactura()+cantidad);
			System.out.println("dinero retirado ("+cantidad+")");
			}else {
				System.out.println("saldo insuficiente");
			}
		}
		correcto=false;
		return getSaldodisponible();
	}
	public void findemes() {
		setSaldodisponible(recargoCredito);
		getCuenta().setSaldo(getCuenta().getSaldo()-getSaldofactura());
		setSaldofactura(0.0);
	}
	

}
