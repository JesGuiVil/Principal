package ejercicios1;
import java.util.Scanner;
public class Masacorporal {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				int edad, tel, peso;
				float altura, imc;
				String nombre, direccion;
				Scanner leer = new Scanner (System.in);
				System.out.println("Introduce tu nombre");
				nombre = leer.nextLine();
				System.out.println("Introduce tu direccion");
				direccion = leer.nextLine();
				System.out.println("Introduce tu edad");
				edad = leer.nextInt();
				System.out.println("Introduce tu telefono");
				tel = leer.nextInt();
				System.out.println("el nombre introducido es " + nombre);
				System.out.println(" y la edad es " + edad);
				System.out.println(" su dirección es " + direccion);
				System.out.println(" su telefono es " + tel);
				System.out.println("Introduce tu altura");
				altura = leer.nextFloat();
				System.out.println("introduce tu peso");
				peso = leer.nextInt();
				imc = peso/(altura*altura);
				System.out.println(" su imc es " + imc);
				if (imc<16) {
					System.out.println("delgadez severa ");
				}else if(imc>=16 & imc<17){
						System.out.println("delgadez moderada");
				}else if(imc>=17 & imc<18.5){
					System.out.println("delgadez leve");
				}else if(imc>=18.5 & imc<25){
					System.out.println("peso normal");
				}else if(imc>=25 & imc<30){
					System.out.println("sobrepeso");
				}else if(imc>=30 & imc<35){
					System.out.println("obesidad leve");
				}else if(imc>=35 & imc<40){
					System.out.println("obesidad moderada");
				}else if(imc>40){
					System.out.println("obesidad morbida");
				}
			}	
	}