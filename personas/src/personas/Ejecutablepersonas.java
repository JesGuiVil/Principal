package personas;

public class Ejecutablepersonas {

	public static void main(String[] args) {
	Personas p1= new Personas();
	p1.imprimirPersona();
	
	Personas p2= new Personas("Pepe", " Lopez Castro", "11111111L", false, 100);
	p2.imprimirPersona();
	}

}
