package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.MetodosLambda1;

public class Panel1 extends JPanel {
    private JTextField textFieldLista;
    private JTextArea numerosTextArea;
    private JScrollPane scrollPane;

    public Panel1() {
        setLayout(new FlowLayout());

        // Crear JTextField
        textFieldLista = new JTextField(10);
        add(textFieldLista);

        // Crear botón para agregar número
        JButton agregarButton = new JButton("Agregar Número");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MetodosLambda1.agregarNumero(textFieldLista.getText());
            }
        });
        add(agregarButton);
        JButton reiniciarButton = new JButton("Reiniciar");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            }
        });
        add(agregarButton);

        // Crear JTextArea para mostrar números introducidos
        numerosTextArea = new JTextArea(8, 20);
        numerosTextArea.setEditable(false);
        scrollPane = new JScrollPane(numerosTextArea);
        add(scrollPane);
    }

    public void mostrarNumeros(String numerosText) {
        numerosTextArea.setText(numerosText);
    }
}
