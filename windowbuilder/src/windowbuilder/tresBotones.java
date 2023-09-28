package windowbuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class tresBotones {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tresBotones window = new tresBotones();
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
	public tresBotones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 195, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char tecla=e.getKeyChar();
				if(tecla!='1' && tecla !='2' &&tecla !='3') {
					e.consume();
				}
			}
		});

		textField.setBounds(10, 11, 150, 20);
		panel.add(textField);

		JButton botonuno = new JButton("introduce 1");
		botonuno.setBounds(10, 42, 150, 23);
		panel.add(botonuno);

		JButton botondos = new JButton("introduce 2");
		botondos.setBounds(10, 76, 150, 23);
		panel.add(botondos);

		JButton botontres = new JButton("introduce 3");
		botontres.setBounds(10, 110, 150, 23);
		panel.add(botontres);

		JButton limpiar = new JButton("resetear");
		limpiar.setBounds(10, 154, 150, 23);
		panel.add(limpiar);

		limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField.requestFocusInWindow();
			}
		});

		botonuno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"1");
				textField.requestFocusInWindow();
			}
		});
		botondos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"2");
				textField.requestFocusInWindow();
			}
		});
		botontres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"3");
				textField.requestFocusInWindow();
			}
		});

	}

}
