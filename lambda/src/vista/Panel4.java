package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import controlador.MetodosLambda4;

public class Panel4 extends JPanel {
 
    private JTable productoTable;
    private DefaultTableModel tableModel;
    public JTextArea mediaTextArea; // Agregado para mostrar la media

    public Panel4() {
    	tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Precio");

        productoTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(productoTable);

        // Ajusta el tamaño del JScrollPane
        scrollPane.setPreferredSize(new Dimension(470, 110));

        add(scrollPane);

        mediaTextArea = new JTextArea();
        mediaTextArea.setBounds(10, 135, 470, 25); // Ajusta la posición vertical y la altura aquí
        add(mediaTextArea); 

        JButton consultarButton = new JButton("Leer Archivo");
        consultarButton.addActionListener(e -> MetodosLambda4.leerArchivo(tableModel));
        add(consultarButton);

        JButton reiniciarButton = new JButton("Reiniciar");
        reiniciarButton.addActionListener(e -> MetodosLambda4.resetear(tableModel));
        add(reiniciarButton);
    }
}


