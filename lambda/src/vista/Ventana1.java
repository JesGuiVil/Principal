package vista;

import java.awt.BorderLayout;

import javax.swing.*;

import controlador.MetodosLambda1;

public class Ventana1 extends JFrame {
	Panel1 panel = new Panel1();
	MetodosLambda1 metodos =new MetodosLambda1(panel);
	
	public Ventana1() {
        setTitle("Registro de Números");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(505, 330); 
        setResizable(false);
        setLocationRelativeTo(null);
        add(panel, BorderLayout.CENTER);            
        setVisible(true);
        panel.setVisible(true);
        panel.textFieldLista.requestFocus();
    }
}
