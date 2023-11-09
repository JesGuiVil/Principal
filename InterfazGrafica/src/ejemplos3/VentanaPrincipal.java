package ejemplos3;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


//Crear una ventana con un bot�n que lleve a otra ventana e impida que se abran nuevas ventanas hasta que se cierre la anterior.

public class VentanaPrincipal extends JFrame implements ActionListener{

	/* Variables */
	  private JButton boton1;
	  private JLabel label1;

	  /* Constructor */
	  public VentanaPrincipal() {

	    //Layout absoluto
	    setLayout(null);
	   
	    

	    //Tama�o de la ventana
	    setBounds(10,10,410,210);

	    //T�tulo
	    setTitle("Ejemplo: Varias Ventanas");

	    //No redimensionable
	    setResizable(false);

	    //Cerrar proceso al cerrar la ventana
	    setDefaultCloseOperation(EXIT_ON_CLOSE);

	    //Etiqueta
	    label1 = new JLabel("Esta es la ventana principal");
	    label1.setBounds(115,60,200,30);
	    add(label1);

	    //Bot�n
	    boton1 = new JButton("Haz clic aqu�");
	    boton1.setBounds(105,110,200,40);
	    add(boton1);

	    /* Inicializo escuchador del bot�n */
	    boton1.addActionListener(this);

	    //Muestro JFrame (lo �ltimo para que lo pinte todo correctamanete)
	    setVisible(true);

	  }

	  /* M�todo que implementa la acci�n del bot�n */
	  public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == boton1) {
	      /* Inicializo y muestro la segunda pantalla con los argumentos this (JFrame) y true (modal) */
	      VentanaSecundaria secundaria = new VentanaSecundaria(this,true);
	      secundaria.setVisible(true);
	    }
	  }

	  /* Incializo el formulario */
	  public static void main(String[] args) {

	    new VentanaPrincipal();

	  }
	}