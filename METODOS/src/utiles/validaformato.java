package utiles;

import java.util.Scanner;
import java.util.regex.Pattern;

public class validaformato {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce un valor: ");
        String valor = input.nextLine();
        
        if (validarFormato(valor)) {
            System.out.println("El valor tiene el formato correcto.");
        } else {
            System.out.println("El valor no tiene el formato correcto.");
        }
    }
    
    public static boolean validarFormato(String valor) {
        // Creamos el patrón de expresión regular para el formato deseado.
        Pattern patron = Pattern.compile("^[1-4]º-ESO-[ABC]$");
        // Comprobamos si el valor cumple con el patrón.
        return patron.matcher(valor).matches();
    }

}
