package Palasaca;

public class Cuentas extends Productos implements Cuent{
	protected TiposCuenta tipo;
	protected String iban;
	protected Double saldo;
	
	
	public TiposCuenta getTipo() {
		return tipo;
	}
	protected void setTipo(TiposCuenta tipo) {
		this.tipo = tipo;
	}
	public String getIban() {
		return iban;
	}
	protected void setIban(String iban) {
		this.iban = iban;
	}
	public Double getSaldo() {
		return saldo;
	}
	protected void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public Cuentas() {
		super();
		this.tipo = null;
		this.iban = null;
		this.saldo = null;
	}
	public Cuentas(String descripcion, Double comision, String finicio, String ffinal, Clientes cliente, int clave, TiposCuenta tipo, String iban, Double saldo) {
		super(descripcion,comision,finicio,ffinal,cliente,clave);
		this.tipo = tipo;
		this.iban = iban;
		this.saldo = saldo;
	}
	
	public String toString() {
		return  "\niban=" + iban + ", \nsaldo=" + saldo;
	}
	
	public Double SacarDinero(int cantidad) {
		if (correcto && getSaldo()>cantidad) {
			setSaldo(getSaldo()-cantidad);
			System.out.println("dinero retirado");
		}else {
			System.out.println("clave incorrecta");
		}
		correcto=false;
		return getSaldo();
	}

	public Double IngresarDinero(int cantidad) {
		if (correcto) {
			setSaldo(getSaldo()+cantidad);
			System.out.println("dinero ingresado ("+cantidad+")");
		}else {
			System.out.println("clave incorrecta");
		}
		correcto=false;
		return getSaldo();
	}
	
	public String VisualizarCuenta() {
		String cadena="su saldo es: "+getSaldo();
		return cadena;
	}
	
	public String DatosCuenta() {
		String respuesta="";
		if(correcto) {
		respuesta=toString();
		}else {
			System.out.println("clave incorrecta");
		}
		return respuesta;
	}
	
	public TiposCuenta TipoCuenta() {
		return getTipo();
	}
	
	public Double DevolverIntereses() {
		Double interes=getSaldo()*super.getComision()/100;
		return interes;
	}
	
	

}
