package trollwindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana {
	private JFrame frameUno;
	private ArrayList<JFrame> ventanas = new ArrayList<>();
	private int ventanaIndex = 0;
	private int contador = 0;
	private static Timer timer;
	private static Robot robot;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Ventana window = new Ventana();
				window.frameUno.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Ventana() {
		initialize();
	}

	private void initialize() {
		int screenWidth = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int screenHeight = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		frameUno = new JFrame();
		frameUno.setBounds(0, -70, screenWidth, screenHeight);
		frameUno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JPanel panel = new JPanel();
		frameUno.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 1));

		JButton botoncito = new JButton("hay una ventana que esconde el truco perfecto para perder el tiempo");
		botoncito.setContentAreaFilled(true);
		panel.add(botoncito);

		botoncito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVentanas();
				botoncito.setText("CERRAR TODAS");
				frameUno.setEnabled(false);
			}
		});
	}

	private void abrirVentanas() {

		int numColumnas = 5;
		int numFilas = 5;
		contador=0;

		int screenWidth = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int screenHeight = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		int windowWidth = screenWidth / numColumnas;
		int windowHeight = screenHeight / numFilas;

		ventanas.clear();


		for (int fila = numFilas - 1; fila >= 0; fila--) { // Comienza desde la fila inferior
			for (int columna = 0; columna < numColumnas; columna++) {
				JFrame ventana = new JFrame("Ventana " + (ventanaIndex + 1));
				ventana.setBounds(columna * windowWidth, fila * windowHeight - 30, windowWidth, windowHeight + 80);

				ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ventanas.add(ventana);

				JButton boton = new JButton("¿Será esta?");
				boton.setRolloverEnabled(false);
				ventana.add(boton);

				boton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventana.dispose();
					}
				});

				ventana.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						ventanas.remove(ventana);
						frameUno.setVisible(true);
						contador++;
						for (int i = 0; i < ventanas.size(); i++) {
							ventanas.get(i).setVisible(true); 
							if(contador>=22) {
								cambiarTextoBotones("lo siento...");
								restringirRaton();
							}else if(contador>=16) {
								frameUno.setEnabled(true);
								cambiarTextoBotones("ya puedes clicar en 'cerrar todas'");
							}else if(contador>=13) {
								cambiarTextoBotones("tu sabe una cossa?");
							}else if(contador>=10) {
								cambiarTextoBotones("¿tu tiene el fakin bisho?");
							}else if(contador>=7) {
								cambiarTextoBotones("¿unas frases de skippy para entretener?");
							}else if(contador>=5) {
								cambiarTextoBotones("esto va para rato...");
							}else if(contador>2) {
								cambiarTextoBotones("vaya pateo, ¿no?");
							}
						}
						habilitarVentanaAleatoria();
					}
				});

				ventana.setVisible(true);
				ventanaIndex++;
			}
		}

		habilitarVentanaAleatoria();
	}


	private void habilitarVentanaAleatoria() {
		if (!ventanas.isEmpty()) {
			int randomIndex = new Random().nextInt(ventanas.size());
			for (int i = 0; i < ventanas.size(); i++) {
				ventanas.get(i).setEnabled(i == randomIndex);
			}
		}
	}
	private void cambiarTextoBotones(String nuevoTexto) {
		for (JFrame ventana : ventanas) {
			Component[] components = ventana.getContentPane().getComponents();
			for (Component component : components) {
				if (component instanceof JButton) {
					((JButton) component).setText(nuevoTexto);
				}
			}
		}
	}
	private void cambiarTextoBotonPrincipal(String nuevoTexto) {
		if (frameUno != null) {
			Component[] components = frameUno.getContentPane().getComponents();
			for (Component component : components) {
				if (component instanceof JButton) {
					((JButton) component).setText(nuevoTexto);
				}
			}
		}
	}


	public static void restringirRaton() {
		try {
			robot = new Robot();
			timer = new Timer();

			// Obtiene la posición actual del ratón
			int x = java.awt.MouseInfo.getPointerInfo().getLocation().x;
			int y = java.awt.MouseInfo.getPointerInfo().getLocation().y;

			// Restringe el movimiento del ratón dentro de una región específica
			int xMin = 100;  // Límite izquierdo
			int xMax = 300;  // Límite derecho
			int yMin = 100;  // Límite superior
			int yMax = 200;  // Límite inferior

			// Programa una tarea que restablecerá el movimiento del ratón después de 30 segundos
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					liberarRaton();
				}
			}, 30000); // 30,000 milisegundos (30 segundos)

			while (true) {
				int currentX = java.awt.MouseInfo.getPointerInfo().getLocation().x;
				int currentY = java.awt.MouseInfo.getPointerInfo().getLocation().y;

				if (currentX < xMin) {
					robot.mouseMove(xMin, currentY);
				} else if (currentX > xMax) {
					robot.mouseMove(xMax, currentY);
				}

				if (currentY < yMin) {
					robot.mouseMove(currentX, yMin);
				} else if (currentY > yMax) {
					robot.mouseMove(currentX, yMax);
				}

				Thread.sleep(10); // Espera para evitar que el ciclo sea demasiado rápido
			}
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void liberarRaton() {
		if (robot != null) {
			robot.mouseMove(java.awt.MouseInfo.getPointerInfo().getLocation().x, java.awt.MouseInfo.getPointerInfo().getLocation().y);
			robot = null;
		}
		if (timer != null) {
			timer.cancel();
			timer.purge();
			timer = null;
		}
	}
}






