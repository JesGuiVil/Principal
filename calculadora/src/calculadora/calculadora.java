package calculadora;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class calculadora {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculadora window = new calculadora();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 436, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		panel.setLayout(new GridLayout(3, 3, 0, 0));

		JButton uno = new JButton("1");
		panel.add(uno);

		uno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"1");
				textField.requestFocusInWindow();
			}
		});

		JButton dos = new JButton("2");
		panel.add(dos);
		dos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField.requestFocusInWindow();
			}
		});

		JButton tres = new JButton("3");
		panel.add(tres);
		tres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField.requestFocusInWindow();
			}
		});

		JButton cuatro = new JButton("4");
		panel.add(cuatro);

		cuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField.requestFocusInWindow();
			}
		});

		JButton uno_5 = new JButton("1");
		panel.add(uno_5);

		JButton uno_3 = new JButton("1");
		panel.add(uno_3);

		JButton uno_1 = new JButton("1");
		panel.add(uno_1);

		JButton uno_2 = new JButton("1");
		panel.add(uno_2);

		JButton uno_4 = new JButton("1");
		panel.add(uno_4);

	}

}
