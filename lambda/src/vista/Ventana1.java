package vista;

import javax.swing.*;

import controlador.MetodosLambda1;

public class Ventana1 extends JFrame {
    public Ventana1() {
        setTitle("Registro de Números");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Instanciar la clase Panel y agregarla a la ventana
        Panel1 panel = new Panel1();
        add(panel);
        
        new MetodosLambda1(panel);
        
        setVisible(true);
    }
}
