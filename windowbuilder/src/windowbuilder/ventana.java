package windowbuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.border.Border;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class ventana {

	private JFrame frame;
	private static JTextField textField;
	private static int n;
	private static int trys=5;
	private static int num=(int)(Math.random()*101);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		JFrame ventana = new JFrame("mi ventana");
		ventana.setVisible(true);
		ventana.setSize(600,400);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setVisible(true);
		panel.setEnabled(true);
		ventana.getContentPane().add(panel);

		JLabel etiqueta=new JLabel();
		etiqueta.setBackground(new Color(255, 128, 64));
		etiqueta.setText("adivina el numero:");
		etiqueta.setBounds(10,1,150,35);
		panel.add(etiqueta);

		JLabel respuesta=new JLabel();
		respuesta.setBackground(new Color(255, 128, 64));
		respuesta.setText("esperando...");
		respuesta.setBounds(10,50,200,35);
		panel.add(respuesta);

		JLabel intentos=new JLabel();
		intentos.setBackground(new Color(255, 128, 64));
		intentos.setText("intentos: 5");
		intentos.setBounds(10,100,150,35);
		panel.add(intentos);

		textField = new JTextField();
		textField.setBounds(113, 8, 86, 20);
		textField.setColumns(10);
		textField.setVisible(true);
		textField.setEnabled(true);
		panel.add(textField);


		JButton botoncito = new JButton("probar suerte");
		botoncito.setBounds(219, 7, 150, 23);
		botoncito.setVisible(true);
		botoncito.setEnabled(true);
		panel.add(botoncito);
		



		botoncito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n =Integer.parseInt(textField.getText());


				intentos.setText("intentos : "+trys);

				if (n>num) {
					respuesta.setText("solucion: el numero es mas pequeño");
					trys=trys-1;
				}else if (n<num) {
					respuesta.setText("solucion: el numero es mas grande");
					trys=trys-1;
				}else{
					respuesta.setText("acertaste");
				}
				if (trys==0) {
					respuesta.setText(" el numero secreto era "+num);
				}
			}
		});
	}






	public ventana() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}
}
