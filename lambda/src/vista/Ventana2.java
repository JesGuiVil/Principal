package vista;

import java.awt.BorderLayout;

import javax.swing.*;

import controlador.MetodosLambda1;
import controlador.MetodosLambda2;

public class Ventana2 extends JFrame {
	Panel2 panel = new Panel2();
	MetodosLambda2 metodos =new MetodosLambda2(panel);
	
	public Ventana2() {
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
