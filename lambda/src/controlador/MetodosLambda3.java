package controlador;

import vista.Panel3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MetodosLambda3 {

    private static Panel3 panel;

    public MetodosLambda3(Panel3 panel) {
        this.panel = panel;
    }

    public static void mostrarFechaActual() {
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm 'del' dd 'de' MMMM 'del' yyyy");
        String fechaFormateada = formato.format(fechaActual);
        panel.fechaTextArea.setText(null);
        panel.fechaTextArea.append("Las " + fechaFormateada + "\n");
    }

    public static void resetear() {
    	panel.fechaTextArea.setText(null);

    }
}
