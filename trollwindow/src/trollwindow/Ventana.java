package trollwindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JFrame frameUno;
    private ArrayList<JFrame> ventanas = new ArrayList<>();
    private int ventanaIndex = 0;
    private static Timer timer;
    private static Robot robot;
    private static JButton botoncito;

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

        frameUno = new JFrame();
        frameUno.setBounds(200, -40, 1400, 200);
        frameUno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        frameUno.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        botoncito = new JButton("Se abrirán unas ventanas que se cierran dando clic, pero solo una esta habilitada. al cerrar esa se habilitará otra. Que comience el juego..");
        botoncito.setBounds(0, 0, 1380, 180);
        Font fuente = new Font("Arial", Font.PLAIN, 20); // Puedes ajustar el tamaño (18 en este caso)

        // Establecer la fuente en el JButton
        botoncito.setFont(fuente);
        panel.add(botoncito);

        botoncito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanas();
                frameUno.setEnabled(false);
            }
        });
    }

    private void abrirVentanas() {

        int numColumnas = 2;
        int numFilas = 2;
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
                ventana.setVisible(true);
                JButton boton = new JButton("clic para cerrar");
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
                        frameUno.setVisible(true);
                        if(ventanas.size()==1) {
                            frameUno.setEnabled(true);
                            restringirRaton();
                        }else if(ventanas.size()<5 && ventanas.size()>2) {
                        	cambiarTextoBotonPrincipal("COMO SIGAS CERRANDO TE CASTIGO!!");
                        	cambiarColorBotonPrincipal(Color.RED);
                        }
                        if(ventanas.size()<7 && ventanas.size()>5) {
                            cambiarTextoBotones("¿¿estas intentando huir??");
                        } else if(ventanas.size()<13 && ventanas.size()>7) {
                            cambiarTextoBotones("¿sabe una cosssa??");
                        } else if(ventanas.size()<15 && ventanas.size()>13) {
                            cambiarTextoBotones("¿tu tiene el fakin bisho?");
                        } else if(ventanas.size()<17 && ventanas.size()>15) {
                            cambiarTextoBotones("va vení Cristo y va pegá a la Tierra!");
                        } else if(ventanas.size()<19 && ventanas.size()>17) {
                            cambiarTextoBotones("¿y QUIÉN! es el mesejero del mesejero??");
                        } else if(ventanas.size()<22 && ventanas.size()>19) {
                            cambiarTextoBotones("¿unas frases de skippy para amenizar?");
                        } else if(ventanas.size()<25 && ventanas.size()>22) {
                            cambiarTextoBotones("mas rápidos los he visto");
                        }
                        ventanas.remove(ventana);
                        for (int i = 0; i <ventanas.size(); i++) {
                            ventanas.get(i).setVisible(true);
                        }
                        habilitarVentanaAleatoria();
                    }
                });
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

    private static void cambiarTextoBotonPrincipal(String nuevoTexto) {
        if (botoncito != null) {
            botoncito.setText(nuevoTexto);
        }
    }
    private static void cambiarColorBotonPrincipal(Color color) {
        if (botoncito != null) {
            botoncito.setBackground(color);
        }
    }

    private static class RatonClicker extends SwingWorker<Void, Void> {
        @Override
        protected Void doInBackground() throws Exception {
            try {
                robot = new Robot();
                timer = new Timer();

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
            return null;
        }
    }

    public static void restringirRaton() {
        SwingUtilities.invokeLater(() -> {
            cambiarTextoBotonPrincipal("MIRA QUE TE HE AVISAO!!");
            cambiarColorBotonPrincipal(Color.CYAN);
        });

        RatonClicker ratonClicker = new RatonClicker();
        ratonClicker.execute();
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
        cambiarTextoBotonPrincipal("CLIC PARA SALIR DE ESTA MIERDA");
        cambiarColorBotonPrincipal(Color.GREEN);
    }
}
