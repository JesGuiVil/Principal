package Palasaca;

public class Monedero extends Tarjetas{
	protected Double saldo;

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	

	@Override
	public String toString() {
		return super.toString()+"\nMonedero: \nsaldo=" + saldo;
	}

	public Monedero() {
		super();

	}

	public Monedero(String descripcion, Double comision, String finicio, String ffinal, Clientes cliente, int clave, Cuentas cuenta, String numerotarjeta, int ping, String seguridad,String fcaducidad) {
		super(descripcion,comision,finicio,ffinal,cliente,clave,cuenta,numerotarjeta,ping,seguridad,fcaducidad);
		this.saldo = 0.0;
	}
	public Double sacaMonedero(int cantidad) {
		if(correcto) {
			if (cantidad<saldo) {
				setSaldo(getSaldo()-cantidad);
				System.out.println("dinero retirado ("+cantidad+")");
			}else {
				System.out.println("saldo insuficiente");
			}
		}
		correcto=false;
		return getSaldo();
	}
	
	public Double cargaSaldo(int cantidad) {
		if(correcto) {
			setSaldo(getSaldo()+cantidad);
			System.out.println("dinero ingresado");
		}
		correcto=false;
		return getSaldo();
	}
}
