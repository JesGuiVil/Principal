package Rectangulo;

public class Ejecutar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo R1= new Rectangulo();
		System.out.println(R1.toString());
		System.out.println("----------------------");
		Rectangulo R2= new Rectangulo(5,3);
		System.out.println(R2.toString());
		System.out.println("----------------------");
		Rectangulo R3= new Rectangulo(R2);
		System.out.println(R3.toString());
		System.out.println("----------------------");
		
		//si no hubieramos hecho el constructor de dato habria que hacer esto:
		Rectangulo R4= new Rectangulo(R2.getBase(),R2.getAltura());
		
		//asi puedo hacerlo cuadrado (asigno a la altura el valor de la base o al reves)
		R2.setAltura(R2.getBase());
		R2.calcularArea();
		R2.calcularPerimetro();
		R2.informaRectangulo();
		R3.informaRectangulo();
	}

}
