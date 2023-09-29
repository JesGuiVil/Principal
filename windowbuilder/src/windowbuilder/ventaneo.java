package windowbuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ventaneo {

	private JFrame frameuno;
	private JFrame framedos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventaneo window = new ventaneo();
					window.frameuno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventaneo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameuno = new JFrame();
		frameuno.setBounds(100, 100, 450, 300);
		frameuno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frameuno.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton botoncito = new JButton("cambiar venana");
		botoncito.setBounds(250, 15, 150, 23);
		panel.add(botoncito);

		botoncito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana2();
				frameuno.setEnabled(false);

			}
		});
	}
	public void ventana2() {
		framedos = new JFrame();
		framedos.setBounds(400, 400, 450, 300);
		framedos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framedos.setVisible(true);

		JPanel panel = new JPanel();
		framedos.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton boton = new JButton("cambiar venana");
		boton.setBounds(250, 15, 150, 23);
		panel.add(boton);

		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameuno.setEnabled(true);
				frameuno.setVisible(true);
				framedos.setVisible(false);
			}
		});
		framedos.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frameuno.setEnabled(true);
                frameuno.setVisible(true);
            }
        });
	}

}
