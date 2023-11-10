package controlador;

import vista.Panel2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MetodosLambda2 {
    private static List<String> nombresList = new ArrayList<>();
    private static Panel2 panel;

    public MetodosLambda2(Panel2 panel) {
        this.panel = panel;
    }

    public static void agregarNombre(String nombreStr) {

            nombresList.add(nombreStr);
            mostrarNombres();
        
    }

    public static void mostrarNombres() {

    	String nombresText = nombresList.stream().collect(Collectors.joining(", "));
    	panel.nombresTextArea.setText(nombresText);
    	

        List<Integer> mapeadoList = mapear();
        String mapeadoText = mapeadoList.stream().map(String::valueOf).collect(Collectors.joining(", "));
        panel.mapeadosTextArea.setText(mapeadoText);

  
        int suma = suma();
        String sumaText = Integer.toString(suma);
        panel.sumaTextArea.setText(sumaText);
    }

    public static List<Integer> mapear() {
        return nombresList.stream().map(nombre->nombre.length()).collect(Collectors.toList());
    }


    private static int suma() {
    	return mapear().stream().mapToInt(Integer::intValue).sum();
    }

    
    public static void resetear() {
    	panel.nombresTextArea.setText(null);
    	panel.mapeadosTextArea.setText(null);
    	panel.sumaTextArea.setText(null);
    	nombresList.clear();
    }
}
