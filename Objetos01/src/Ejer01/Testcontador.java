package Ejer01;
import java.util.Scanner;
public class Testcontador {

public static void main(String[] args) { 
        
        Scanner sc = new Scanner(System.in); 
        
        //Utilizar el constructor por defecto 
        CONTADOR contador1 = new CONTADOR(); 
       
        int n; 
        System.out.println("Introduce valor para inicializar el contador: ");                                      
        n = sc.nextInt(); 
        
        //asignar un valor al contador 
        contador1.setCont(n); 
        //incrementar el contador 
        contador1.incrementar(); 
        //mostrar el valor actual 
        System.out.println(contador1.getCont()); 
        
        contador1.incrementar(); 
        contador1.incrementar(); 
        
        //mostrar el valor actual 
        System.out.println(contador1.getCont()); 
        
        //restar 1 al valor del contador 
        contador1.decrementar(); 
        
        //mostrar el valor actual 
        System.out.println(contador1.getCont()); 
 
        //crear un nuevo objeto Contador con valor inicial 10 
        CONTADOR contador2 = new CONTADOR(10); 
        
        //incrementar y decrementar el contador2 y mostrar su valor                                                
        contador2.incrementar(); 
        System.out.println(contador2.getCont()); 
        contador2.decrementar(); 
        System.out.println(contador2.getCont()); 
 
        //crear un objeto Contador utilizando el constructor copia 
        //se crea el objeto contador3 como copia de contador2 
        CONTADOR contador3 = new CONTADOR(contador2); 
 
        //mostrar el valor de contador3 
        System.out.println(contador3.getCont()); 
 
} 

}
