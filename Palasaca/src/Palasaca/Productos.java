package Palasaca;

public class Productos implements Product{
	protected String descripcion;
	protected Double comision;
	protected String finicio;
	protected String ffinal;
	protected Clientes cliente;
	protected int clave;
	protected boolean correcto;


	
	public boolean isCorrecto() {
		return correcto;
	}

	protected void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	protected void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getComision() {
		return comision;
	}

	protected void setComision(Double comision) {
		this.comision = comision;
	}

	public String getFinicio() {
		return finicio;
	}

	protected void setFinicio(String finicio) {
		this.finicio = finicio;
	}

	public String getFfinal() {
		return ffinal;
	}

	protected void setFfinal(String ffinal) {
		this.ffinal = ffinal;
	}

	public Clientes getCliente() {
		return cliente;
	}

	protected void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public int getClave() {
		return clave;
	}

	protected void setClave(int clave) {
		this.clave = clave;
	}

	public Productos() {

	}

	public Productos(String descripcion, Double comision, String finicio, String ffinal, Clientes cliente, int clave) {
		super();
		this.descripcion = descripcion;
		this.comision = comision;
		this.finicio = finicio;
		this.ffinal = ffinal;
		this.cliente = cliente;
		this.clave = clave;
		this.correcto=false;
		
	}


	public String toString() {
		return "\ndescripcion=" + descripcion + ", \ncomision=" + comision + "%, \nfecha inicio=" + finicio + ", \nfecha final="+ ffinal + ", \ncliente=" + cliente;
	}
	
	public boolean Acceso(int codigo) {
		correcto=false;
		if(codigo==this.getClave()) {
			correcto=true;
		}
		return correcto;
	}
	
	
	
	


}
