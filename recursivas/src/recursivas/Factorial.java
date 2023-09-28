package recursivas;
import java.util.Scanner;
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int num = leer.nextInt();
        leer.close();
         
        System.out.println("\nEl factorial de " + num + " es: " + factorial(num));
    }
     
    public static int factorial(int num){
        if(num == 0){
            return 1;
        }
        else
            return num * factorial(num-1);
    }

}