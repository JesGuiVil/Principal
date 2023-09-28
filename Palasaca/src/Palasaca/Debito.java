package Palasaca;

public class Debito extends Tarjetas{
	protected Double maximoDiario;
	protected Double maximoDia;

	public Double getMaximoDiario() {
		return maximoDiario;
	}

	public void setMaximoDiario(Double maximoDiario) {
		this.maximoDiario = maximoDiario;
	}


	@Override
	public String toString() {
		return super.toString()+"\nDebito: \nmaximoDiario=" + maximoDiario;
	}

	public Debito(String descripcion, Double comision, String finicio, String ffinal, Clientes cliente, int clave, Cuentas cuenta, String numerotarjeta, int ping, String seguridad,String fcaducidad, Double maximoDiario) {
		super(descripcion,comision,finicio,ffinal,cliente,clave,cuenta,numerotarjeta,ping,seguridad,fcaducidad);
		this.maximoDiario = maximoDiario;
		this.maximoDia=maximoDiario;
	}
	public Double sacaDebito(int cantidad) {
		if(correcto) {
			if (cantidad<maximoDiario && cantidad<cuenta.getSaldo()) {
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			maximoDiario=maximoDiario-cantidad;	
			System.out.println("dinero retirado ("+cantidad+")");
			}else {
			System.out.println("esa cantidad supera el maximo diario permitido o la cuenta no tiene saldo suficiente");
			}
		}
		correcto=false;
		return cuenta.getSaldo();
	}
	public void finDia() {
		maximoDiario=maximoDia;
	}
	


}
