package objetos2;

public class TestNif {

	public static void main(String[] args) {
		NIF nif1 = new NIF(); 
        nif1.leer(); 
        System.out.println(nif1); 
 
        NIF nif2 = new NIF(12345678); 
        System.out.println(nif2); 
 
	}

}
