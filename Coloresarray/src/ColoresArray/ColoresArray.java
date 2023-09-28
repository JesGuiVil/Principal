package ColoresArray;
import java.util.ArrayList;
public class ColoresArray {
	
		public static void main(String[] args) {
			ArrayList<String> misColores = new ArrayList();
			
			misColores.add("ROJO");
			misColores.add("NEGRO");
			misColores.add("CYAN");
			misColores.add("SALMON");
			misColores.add("BLANCO");
			
			for (int i=0; i<misColores.size(); i++) {
				System.out.println("Color -- "+misColores.get(i));
			}
			for (String color: misColores){
				System.out.println("Color "+color);
			
			}
			misColores.remove(3);
			for (String color: misColores){
				System.out.println("Color "+color);
			
			}
			int i=misColores.indexOf("BLANCO");
				System.out.println("posicion "+i);
				//desplaza
				misColores.add(3,"amarillo");
				for (String color: misColores){
					System.out.println("Color "+color);
				
				}
				//machaca el dato
				misColores.set(3,"violeta");
				for (String color: misColores){
					System.out.println("Color "+color);
				
				}
			
			}
		

	}

