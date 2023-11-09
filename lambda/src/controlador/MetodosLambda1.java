package controlador;

import vista.Panel1;

import java.util.ArrayList;
import java.util.List;

public class MetodosLambda1 {
    private static List<Integer> numerosList = new ArrayList<>();
    private static Panel1 panel;
    
    public MetodosLambda1(Panel1 panel) {
        MetodosLambda1.panel = panel;
    }

    public static void agregarNumero(String numeroStr) {
        try {
            int numero = Integer.parseInt(numeroStr);
            numerosList.add(numero);
            mostrarNumeros();
        } catch (NumberFormatException ex) {
            // Manejar el error
        }
    }

    private static void mostrarNumeros() {
        StringBuilder numerosText = new StringBuilder("Números introducidos:\n");
        for (int numero : numerosList) {
            numerosText.append(numero).append("\n");
        }

    }
    
}
