package ejemplos2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

//Ejemplo crear un JFrame con un texto que diga "Hola Mundo" desde c�digo

public class EjemploFrame extends JFrame {

	/* Definimos un objeto JLabel para la etiqueta. */
	  private JLabel label1;

	  /* En el constructor de la clase llamamos al m�todo heredado de la clase JFrame llamado setLayout y le pasamos como par�metro un valor null.
	   * Con esto estamos informando a la clase JFrame que utilizaremos posicionamiento absoluto para los controles visuales dentro del JFrame*/
	  
	  public EjemploFrame() {

	    //Layout absoluto
	    setLayout(null);

	    //Tama�o de la ventana
	    setBounds(10,10,400,300);

	    //T�tulo
	    setTitle("Ejemplo 1: JLabel");

	    //No redimensionable
	    setResizable(false);

	    //Cerrar proceso al cerrar la ventana
	    setDefaultCloseOperation(EXIT_ON_CLOSE);

	    /* Creamos el objeto de la clase JLabel y le pasamos como par�metro al constructor el texto a mostrar.*/
	    label1 = new JLabel("Hola Mundo.");

	    /* Ubicamos al objeto de la clase JLabel llamando al m�todo setBounds. Como par�metros la columna, fila, ancho y alto del JLabel. 
	     * Finalmente llamamos al m�todo add (metodo heredado de la clase JFrame) que tiene como objetivo a�adir el control JLabel al control JFrame */
	    label1.setBounds(50,70,300,50);
	    add(label1);

	    //Muestro JFrame (para que lo pinte todo)
	    setVisible(true);
	  }

	  /* En el m�todo main creamos un objeto de la clase */
	  public static void main(String[] args) {

	    new EjemploFrame();

	  }


}
