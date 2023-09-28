package supermercado;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Detergente detergent=new Detergente("bosqueverde", 1.5);
		Cereales cereal=new Cereales("chococrispis","arroz", 2);
		Vino vinito=new Vino("Don Simon", "blanco", 5, 4.5);
		detergent.setVolumen(2);
		detergent.setDescuento(15);
		detergent.setTipoEnvase("botella");
		cereal.setCaducidad(LocalDate.of(2023,3,20));
		vinito.setDescuento(5);
		vinito.setTipoEnvase("brick");
		vinito.setVolumen(1);
		vinito.setCaducidad(LocalDate.of(2030,3,20));
	
		System.out.println(detergent);
		System.out.println();
		System.out.println();
		System.out.println(cereal);
		System.out.println();
		System.out.println();
		System.out.println(vinito);
		
		ArrayList<EsAlimento> alimentos =new ArrayList<>();
		alimentos.add(cereal);
		alimentos.add(vinito);
		int calorias=0;
		for(EsAlimento cosa:alimentos) {
			calorias=calorias+cosa.getCalorias();
		}
		System.out.println();
		System.out.println();
		System.out.println("calorias totales: "+calorias);
	}

							
}
