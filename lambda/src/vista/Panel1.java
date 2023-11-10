package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.MetodosLambda1;

public class Panel1 extends JPanel {
    public JTextField textFieldLista;
    public JTextArea numerosTextArea;
    public JTextArea primosTextArea;
    public JTextArea primosOrdenadosTextArea;
    public JScrollPane scrollPane;
    public JScrollPane primosScrollPane;
    public JScrollPane primosOrdenadosScrollPane;

    public Panel1() {
        setLayout(null); 
        textFieldLista = new JTextField();
        textFieldLista.setBounds(10, 10, 150, 25); // x, y, ancho, alto
        add(textFieldLista);


        JButton agregarButton = new JButton("Agregar Número");
        agregarButton.setBounds(170, 10, 150, 25);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MetodosLambda1.agregarNumero(textFieldLista.getText());
                MetodosLambda1.mostrarNumeros();
                textFieldLista.setText(null);
                textFieldLista.requestFocus();
            }
        });
        add(agregarButton);


        JButton reiniciarButton = new JButton("Reiniciar");
        reiniciarButton.setBounds(330, 10, 150, 25);
        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MetodosLambda1.resetear();
            }
        });
        add(reiniciarButton);

        JLabel label = new JLabel("Números añadidos:");
        label.setBounds(10, 45, 150, 25);
        add(label);

  
        numerosTextArea = new JTextArea();
        numerosTextArea.setLineWrap(true);
        numerosTextArea.setEditable(false);
        scrollPane = new JScrollPane(numerosTextArea);
        scrollPane.setBounds(10, 80, 470, 50);
        add(scrollPane);

        JLabel primosLabel = new JLabel("Números primos:");
        primosLabel.setBounds(10, 145, 150, 25);
        add(primosLabel);


        primosTextArea = new JTextArea();
        primosTextArea.setEditable(false);
        primosScrollPane = new JScrollPane(primosTextArea);
        primosScrollPane.setBounds(10, 180, 470, 25);
        add(primosScrollPane);


        JLabel primosOrdenadosLabel = new JLabel("Números primos ordenados:");
        primosOrdenadosLabel.setBounds(10, 220, 200, 25);
        add(primosOrdenadosLabel);

   
        primosOrdenadosTextArea = new JTextArea();
        primosOrdenadosTextArea.setEditable(false);
        primosOrdenadosScrollPane = new JScrollPane(primosOrdenadosTextArea);
        primosOrdenadosScrollPane.setBounds(10, 255, 470, 25);
        add(primosOrdenadosScrollPane);
    }
}
