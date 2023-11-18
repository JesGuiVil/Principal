package vista;

import java.awt.BorderLayout;

import javax.swing.*;


import controlador.MetodosLambda3;

public class Ventana3 extends JFrame {
	Panel3 panel = new Panel3();
	MetodosLambda3 metodos =new MetodosLambda3(panel);
	
	public Ventana3() {
        setTitle("Mostrador de fechas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(505, 130); 
        setResizable(false);
        setLocationRelativeTo(null);
        add(panel, BorderLayout.CENTER);            
        setVisible(true);
        panel.setVisible(true);
        
    }
}
