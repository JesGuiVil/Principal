package windowbuilder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Adivina {

    private JFrame frame;
    private JTextField textField;
    private int tries = 5;
    private int num = (int) (Math.random() * 101);

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Adivina window = new Adivina();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Adivina() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Adivina el número");
        frame.setBounds(700, 300, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel etiqueta = new JLabel("Adivina el número:");
        etiqueta.setBounds(10, 10, 150, 35);
        panel.add(etiqueta);

        JLabel respuesta = new JLabel("Esperando...");
        respuesta.setBounds(10, 50, 200, 35);
        panel.add(respuesta);

        JLabel intentos = new JLabel("Intentos: " + tries);
        intentos.setBounds(10, 100, 150, 35);
        panel.add(intentos);

        textField = new JTextField();
        textField.setBounds(150, 15, 86, 20);
        panel.add(textField);

        JButton botoncito = new JButton("Probar suerte");
        botoncito.setBounds(250, 15, 150, 23);
        panel.add(botoncito);

        JButton reiniciar = new JButton("Reiniciar");
        reiniciar.setBounds(250, 45, 150, 23);
        reiniciar.setVisible(false);
        panel.add(reiniciar);

        botoncito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(textField.getText());
                if (n > num) {
                    respuesta.setText("Solucion: El número es más pequeño");
                    tries--;
                } else if (n < num) {
                    respuesta.setText("Solucion: El número es más grande");
                    tries--;
                } else {
                    respuesta.setText("¡Acertaste!");
                }
                if (tries == 0) {
                    respuesta.setText("El número secreto era " + num);
                    reiniciar.setVisible(true);
                    botoncito.setVisible(false);
                }
                intentos.setText("Intentos: " + tries);
            }
        });

        reiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tries = 5;
                intentos.setText("Intentos: " + tries);
                reiniciar.setVisible(false);
                botoncito.setVisible(true);
                textField.setText("");
                respuesta.setText("Esperando...");
            }
        });

        frame.setVisible(true);
    }
}
