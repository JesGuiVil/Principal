package vista;

import java.awt.BorderLayout;

import javax.swing.*;


import controlador.MetodosLambda5;

public class Ventana5 extends JFrame {
	Panel5 panel = new Panel5();
	MetodosLambda5 metodos =new MetodosLambda5(panel);
	
	public Ventana5() {
        setTitle("Suma en paralelo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(505, 500); 
        setResizable(false);
        setLocationRelativeTo(null);
        add(panel, BorderLayout.CENTER);            
        setVisible(true);
        panel.setVisible(true);
    }
}
