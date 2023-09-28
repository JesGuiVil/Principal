package personas;

public class Personas {
 /*Atributos*/
	private String DNI;
	private String Nombre;
	private String Apellidos;
	private boolean Mayor;
	private int Altura;
	
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	
	public boolean isMayor() {
		return Mayor;
	}
	public void setMayor(boolean mayor) {
		Mayor = mayor;
	}
	public int getAltura() {
		return Altura;
	}
	public void setAltura(int altura) {
		Altura = altura;
	}
	
	public Personas() {
		this.setDNI("");
		this.setNombre("");
		this.setApellidos("");
		this.setMayor(false);
		this.setAltura(0);
	}
	public Personas(String Nombre, String Apellidos, String DNI, boolean Mayor, int Altura) {
		this.setDNI(DNI);
		this.setNombre(Nombre);
		this.setApellidos(Apellidos);
		this.setMayor(Mayor);
		this.setAltura(Altura);
	}
	public void imprimirPersona() {
		System.out.println(this.toString());
	}
	public String toString() {
		String cadena="";
		cadena+=this.getNombre()+""+this.getApellidos();
		cadena+=" con DNI "+this.getDNI();
		cadena+=" siendo mayor de edad =" +this.isMayor();
		cadena+=" con "+this.getAltura() + "cm de altura";
		
		return cadena;
		}
}