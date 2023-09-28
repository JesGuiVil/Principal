package cifrado;

import java.util.Scanner;

public class CifradoCesar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce una frase: ");
        String frase = scanner.nextLine();
        
        System.out.print("Introduce un numero de desplazamientos: ");
        int desplazamiento=scanner.nextInt();
        String fraseCifrada = cifrarFrase(frase,desplazamiento);
        
        System.out.println("Frase cifrada: " + fraseCifrada);
        
        scanner.close();
    }
    
    public static String cifrarFrase(String frase, int n) {
        String resultado="";
        
        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);
            
            if (Character.isLetter(caracter)) {
                char base; 
                		if (Character.isLowerCase(caracter)){
                			base='a'; 
                		}else {
                			base='A';
                		}
                caracter = (char) (base + (caracter - base + n) % 26);
            }
            
            resultado+=caracter;
        }
        
        return resultado.toString();
    }
}