package ejercicios2;
public class Piramiderellena {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//piramide rellena con 9 de base
		int i, j;
		for (i=9; i>0; i--) {
			for (j=i; j>0; j--) {
				System.out.print(" ");
			}
			for (j=i; j<10; j++) {
				System.out.print("* ");
			}
			System.out.println(" ");
		}
	}
} 