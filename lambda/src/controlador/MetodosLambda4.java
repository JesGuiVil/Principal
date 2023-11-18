package controlador;

import javax.swing.table.DefaultTableModel;

import vista.Panel4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;
import java.util.ArrayList;

public class MetodosLambda4 {

    private static Panel4 panel;

    public MetodosLambda4(Panel4 panel) {
        this.panel = panel;
    }

    public static void leerArchivo(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);

        try (BufferedReader br = new BufferedReader(new FileReader("src/productos.csv"))) {
            String line;
            //para que no coja la priemra fila que tiene nombre y precio
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length >= 2) {
                    String nombre = values[0].trim();
                    String precio = values[1].trim();
                    tableModel.addRow(new Object[]{nombre, precio});
                }
            }

            double media = calcularMedia(tableModel);
            panel.mediaTextArea.setText("Media de precios: " + media);

        } catch (IOException e) {
            e.printStackTrace();
            panel.mediaTextArea.setText("Error al leer el archivo");
        }
    }

    private static double calcularMedia(DefaultTableModel tableModel) {
        int rowCount = tableModel.getRowCount();

        double sumaPrecios = IntStream.range(0, rowCount).mapToDouble(i -> Double.parseDouble(tableModel.getValueAt(i, 1).toString())).sum();
        
        return rowCount > 0 ? sumaPrecios / rowCount : 0.0;
    }

    public static void resetear(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        panel.mediaTextArea.setText(null);
    }
}
