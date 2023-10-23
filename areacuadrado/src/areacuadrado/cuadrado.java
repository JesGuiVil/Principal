package areacuadrado;

import java.util.Scanner;

public class cuadrado {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("dime tu edad");
		int edad=sc.nextInt();
		for(int i=0;i<edad;i++) {
			if (i%2==0)
			System.out.println("felicidades por tu cumpleaños del año"+(i));
		}
	}

}
