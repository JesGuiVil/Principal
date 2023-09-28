package objetos2;
import java.util.Date;
import java.util.Scanner;
public class PERSONA {
	Scanner leer= new Scanner(System.in);
	//ATRIBUTOS
	private String nombre;
	private String dir;
	private int cp;
	private String ciudad;
	private FECHA fn;
	
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public FECHA getFn() {
		return fn;
	}
	public void setFn(FECHA fn) {
		this.fn = fn;
	}
	public boolean esMayorDeEdad() {
		boolean correcto=false;
		Date fecha1=new Date();
		FECHA actual= new FECHA(fecha1.getDate(), fecha1.getMonth()+1, fecha1.getYear()+1900);
		FECHA mayor= new FECHA(fn.getDia(), fn.getMes(), fn.getAnio()+18);
		if (actual.esMayorQue(mayor)) {
			correcto=true;	
			System.out.println("es mayor de edad");
		}else {
			System.out.println("es menor de edad");
		}
		return correcto;
	}
	public String toString() {
		String cadena="";
		cadena+="Nombre: "+this.getNombre()+"\nFecha de nacimiento: "+this.getFn().toString()+"\nDirección: "+this.getDir()+"\n"+this.getCp()+" "+this.getCiudad();
		return cadena;
	}
	
	//CONSTRUCTORES
	
	public PERSONA(){
		this.setNombre("");
		this.setDir("");
		this.setCp(0);
		this.setCiudad("");
		this.setFn(fn);
	}
	public PERSONA(String nombre, String dir, int cp, String ciudad, FECHA fn){
		this.setNombre(nombre);
		this.setDir(dir);
		this.setCp(cp);
		this.setCiudad(ciudad);
		this.setFn(fn);
	}
	
}
