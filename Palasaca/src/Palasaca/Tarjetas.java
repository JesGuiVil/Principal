package Palasaca;

import java.util.Scanner;

public class Tarjetas extends Productos{
	protected Cuentas cuenta;
	protected String numerotarjeta;
	protected int ping;
	protected String seguridad;
	protected String fcaducidad;

	public Cuentas getCuenta() {
		return cuenta;
	}
	protected void setCuenta(Cuentas cuenta) {
		this.cuenta = cuenta;
	}
	public String getNumerotarjeta() {
		return numerotarjeta;
	}
	protected void setNumerotarjeta(String numerotarjeta) {
		this.numerotarjeta = numerotarjeta;
	}
	public int getPing() {
		return ping;
	}
	protected void setPing(int ping) {
		this.ping = ping;
	}
	public String getSeguridad() {
		return seguridad;
	}
	protected void setSeguridad(String seguridad) {
		this.seguridad = seguridad;
	}
	public String getFcaducidad() {
		return fcaducidad;
	}
	protected void setFcaducidad(String fcaducidad) {
		this.fcaducidad = fcaducidad;
	}
	public Tarjetas() {
		super();
	}

	@Override
	public String toString() {
		return "\ncuenta=" + cuenta + ", \nnumerotarjeta=" + numerotarjeta + ",\nfecha caducidad=" + fcaducidad;
	}
	public Tarjetas(String descripcion, Double comision, String finicio, String ffinal, Clientes cliente, int clave, Cuentas cuenta, String numerotarjeta, int ping, String seguridad,String fcaducidad) {
		super(descripcion,comision,finicio,ffinal,cliente,clave);
		this.cuenta = cuenta;
		this.numerotarjeta = numerotarjeta;
		this.ping = ping;
		this.seguridad = seguridad;
		this.fcaducidad = fcaducidad;
	}
	public void sacaDinero(int cantidad) {
		if(correcto) {
			if (this instanceof Debito) {
				//MODIFICA CLIENTE
				Debito debito = (Debito) this;
				debito.sacaDebito(cantidad);
			}
			if (this instanceof Credito) {
				//MODIFICA EMPLEADO
				Credito credito = (Credito) this;
				credito.sacaCredito(cantidad);
			}
			if (this instanceof Monedero) {
				//MODIFICA EMPLEADO
				Monedero monedero = (Monedero) this;
				monedero.sacaMonedero(cantidad);
			}	
		}else {
			System.out.println("ping incorrecto");
		}

	}
	public Double cargarMonedero(int cantidad) {
		Double resultado=(double) 0;
		if(correcto) {
			if(this instanceof Monedero){
				Monedero monedero = (Monedero) this;
				if(cuenta.getSaldo()>cantidad) {
					resultado=monedero.cargaSaldo(cantidad);
					cuenta.setSaldo(cuenta.getSaldo()-cantidad);
					System.out.println("dinero ingresado ("+cantidad+")");
				}
			}
		}else {
			System.out.println("ping incorrecto");
		}
		return resultado;
	}

	public String saldoDisponible() {
		String respuesta="";
		if(correcto) {
			if (this instanceof Debito) {
				Debito debito = (Debito) this;
				respuesta="su cuenta dispone de:"+debito.getCuenta().getSaldo();
			}
			if (this instanceof Credito) {
				Credito credito = (Credito) this;
				respuesta="este mes aun dispone de:"+credito.getSaldodisponible();
			}
			if (this instanceof Monedero) {
				Monedero monedero = (Monedero) this;
				respuesta="el saldo en la tarjeta es de:"+monedero.getSaldo();
			}	
		}else {
			System.out.println("ping incorrecto");
		}
		return respuesta;
	}
	public String datosTarjeta() {
		String respuesta="";
		if(correcto) {
			if (this instanceof Debito) {
				Debito debito = (Debito) this;
				respuesta=debito.toString();
			}
			if (this instanceof Credito) {
				Credito credito = (Credito) this;
				respuesta=credito.toString();
			}
			if (this instanceof Monedero) {
				Monedero monedero = (Monedero) this;
				respuesta=monedero.toString();
			}	
		}else {
			System.out.println("ping incorrecto");
		}
		return respuesta;
	}
	public boolean acceso(int codigo) {
		if(codigo==ping) {
			correcto=true;
		}else {
			System.out.println("ping incorrecto");
		}
		return correcto;
	}

}
