package controlador;

import vista.Panel1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static void mostrarNumeros() {

    	String numerosText = numerosList.stream().map(String::valueOf).collect(Collectors.joining(", "));
    	panel.numerosTextArea.setText(numerosText);
    	

        List<Integer> primosList = obtenerNumerosPrimos();
        String primosText = primosList.stream().map(String::valueOf).collect(Collectors.joining(", "));
        panel.primosTextArea.setText(primosText);

  
        List<Integer> primosOrdenadosList = obtenerNumerosPrimosOrdenados();
        String primosOrdenadosText = primosOrdenadosList.stream().map(String::valueOf).collect(Collectors.joining(", "));
        panel.primosOrdenadosTextArea.setText(primosOrdenadosText);
    }

    private static List<Integer> obtenerNumerosPrimos() {
        return numerosList.stream().filter(MetodosLambda1::esPrimo).collect(Collectors.toList());
    }


    private static List<Integer> obtenerNumerosPrimosOrdenados() {
    	return obtenerNumerosPrimos().stream().sorted((a, b) -> b - a).collect(Collectors.toList());
    }

    private static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        return !IntStream.rangeClosed(2, (int) Math.sqrt(numero)).anyMatch(i -> numero % i == 0);
    }
    public static void resetear() {
    	panel.numerosTextArea.setText(null);
    	panel.primosTextArea.setText(null);
    	panel.primosOrdenadosTextArea.setText(null);
    	numerosList.clear();
    }
}
