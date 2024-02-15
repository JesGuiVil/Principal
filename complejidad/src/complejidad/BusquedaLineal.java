package complejidad;
public class BusquedaLineal {

    public static boolean busquedaLineal(int[] lista, int objetivo) {
        for (int elemento : lista) {
            if (elemento == objetivo) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int[] miLista = {1, 2, 3, 4, 5};
        int objetivo = 3;
        
        boolean resultado = busquedaLineal(miLista, objetivo);

        if (resultado) {
            System.out.println("El elemento " + objetivo + " está en la lista.");
        } else {
            System.out.println("El elemento " + objetivo + " no está en la lista.");
        }
    }
}
