package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BacktrackingMenorQueCien {

    public static void main(String[] args) {
        // Configuración inicial
        int[] puntuaciones = {10, 25, 50, 75};
        int totalDardos = 5;
        int objetivo = 100;

        // Lista para almacenar todas las soluciones encontradas
        List<List<Integer>> soluciones = new ArrayList<>();

        // Llamada a la función de backtracking para encontrar soluciones
        backtrackingDardos(puntuaciones, totalDardos, objetivo, 0, new ArrayList<>(), soluciones);

        // Ordenar las soluciones por la cantidad de dardos utilizados
        Collections.sort(soluciones, (solucion1, solucion2) -> Integer.compare(solucion1.size(), solucion2.size()));

        // Imprimir las soluciones encontradas
        for (List<Integer> solucion : soluciones) {
            System.out.println(solucion);
        }
    }

    // Función principal de backtracking para encontrar soluciones
    private static void backtrackingDardos(int[] puntuaciones, int dardosRestantes, int objetivo,
            int puntuacionActual, List<Integer> dardosUsados, List<List<Integer>> soluciones) {
        
        // Imprimir la solución actual en proceso (para propósitos de depuración)
        System.out.println("Posible solucion: " + dardosUsados);

        // Caso base: no quedan dardos restantes
        if (dardosRestantes == 0) {
            // Verificar si la puntuación actual alcanza el objetivo
            if (puntuacionActual == objetivo) {
                // Se encontró una solución, agregarla a la lista de soluciones
                soluciones.add(new ArrayList<>(dardosUsados));
            }
            return;
        }

        // Iterar sobre las diferentes puntuaciones posibles
        for (int puntuacion : puntuaciones) {
            // Verificar si se puede usar la puntuación actual sin exceder el objetivo
            if (puntuacionActual + puntuacion <= objetivo) {
                // Intentar con esta puntuación
                dardosUsados.add(puntuacion);
                backtrackingDardos(puntuaciones, dardosRestantes - 1, objetivo,
                        puntuacionActual + puntuacion, dardosUsados, soluciones);
                
                // Deshacer la elección para probar con otras puntuaciones
                dardosUsados.remove(dardosUsados.size() - 1);
            }
        }
    }
}
