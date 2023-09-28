package Ejer01;

public class TestElectrodomesticos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ELECTRODOMESTICO [] producto=new ELECTRODOMESTICO[10];
		producto[0] = new ELECTRODOMESTICO();
		producto[1] = new LAVADORA();
		producto[2] = new TELEVISION();
		producto[3] = new ELECTRODOMESTICO(1000, 60);
		producto[4] = new LAVADORA(400,80);
		producto[5] = new TELEVISION(700,15);
		producto[6] = new ELECTRODOMESTICO(500, "rojo", 'A', 30);
		producto[7] = new LAVADORA(200, "azul", 'B', 40, 15);
		producto[8] = new TELEVISION(350, "gris", 'C', 7, 60, true);
		producto[9] = new TELEVISION(900, "negro", 'F', 20, 80, false);
		

		double totalteles=0;
		double totallavas=0;
		double totalelect=0;
		double total=0;
		for(int i=0; i<10; i++) {
			if (producto[i].getTipo().equals("television")) {
				producto[i].precioFinal();
				totalteles=totalteles+producto[i].getPreciobase();
			}
			if (producto[i].getTipo().equals("lavadora")) {
				producto[i].precioFinal();
				totallavas=totallavas+producto[i].getPreciobase();
			}
			if (!producto[i].getTipo().equals("television") & !producto[i].getTipo().equals("lavadora")) {
				producto[i].precioFinal();
				totalelect=totalelect+producto[i].getPreciobase();
			}
		}
		total=totalteles+totallavas+totalelect;
		System.out.println("la venta total de televisiones ha sido de "+totalteles);
		System.out.println("la venta total de lavadoras ha sido de "+totallavas);
		System.out.println("la venta total de otros electrodomesticos ha sido de "+totalelect);
		System.out.println("las ventas totales han sido de "+total);
	}

}
