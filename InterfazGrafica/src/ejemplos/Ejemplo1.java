package ejemplos;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ejemplo1 {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//Creamos el JFrame que nos har� de ventana
		JFrame ventana = new JFrame("Desarrollo Aplicaciones Web");
		
		//Ponemos la ventana visible
		ventana.setVisible(true);
		
		//Le damos un tama�o a nuestra ventana
		ventana.setSize(600,400);
		
		//Creamos un panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GREEN);
		ventana.add(panel);
		
		//Creamos un Label para mostrar un texto
		JLabel etiqueta = new JLabel();
		etiqueta.setText("Primer Ejemplo");
		//Le asignamos una posici�n y tama�o al Label
		etiqueta.setBounds(100, 100, 400, 35);
		//A�adimos la etiqueta al panel
		panel.add(etiqueta);
		
	}

}