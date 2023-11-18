package vista;

import java.awt.BorderLayout;

import javax.swing.*;


import controlador.MetodosLambda4;

public class Ventana4 extends JFrame {
	Panel4 panel = new Panel4();
	MetodosLambda4 metodos =new MetodosLambda4(panel);
	
	public Ventana4() {
        setTitle("Lector CSV");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(505, 200); 
        setResizable(false);
        setLocationRelativeTo(null);
        add(panel, BorderLayout.CENTER);            
        setVisible(true);
        panel.setVisible(true);
        
    }
}
