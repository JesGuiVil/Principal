package calculadora;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class calculadora {

    private JFrame frame;
    private JTextField textField;
    private String operador = "";
    private double primervalor = 0;

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

    public calculadora() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        textField = new JTextField();
        frame.getContentPane().add(textField, BorderLayout.NORTH);
        textField.setColumns(10);

        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btn0 = new JButton("0");
        JButton btnSuma = new JButton("+");
        JButton btnResta = new JButton("-");
        JButton btnMultiplicacion = new JButton("*");
        JButton btnDivision = new JButton("/");
        JButton btnIgual = new JButton("=");
        JButton btnC = new JButton("C");
        

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btnSuma);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btnResta);
        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);
        panel.add(btnMultiplicacion);
        panel.add(btn0);
        panel.add(btnIgual);
        panel.add(btnDivision);
        panel.add(btnC);

        // Manejar eventos de los botones
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textField.setText(textField.getText()+"1");
            }
        });
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textField.setText(textField.getText()+"2");
            }
        });
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textField.setText(textField.getText()+"3");
            }
        });
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textField.setText(textField.getText()+"4");
            }
        });
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textField.setText(textField.getText()+"5");
            }
        });
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textField.setText(textField.getText()+"6");
            }
        });
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textField.setText(textField.getText()+"7");
            }
        });
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textField.setText(textField.getText()+"8");
            }
        });
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textField.setText(textField.getText()+"9");
            }
        });
        
        btnSuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                primervalor=Double.parseDouble(textField.getText());
                operador= "+";
                textField.setText("");
            }
        });

        btnResta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	primervalor=Double.parseDouble(textField.getText());
                operador= "-";
                textField.setText("");
            }
        });

        btnMultiplicacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	primervalor=Double.parseDouble(textField.getText());
                operador= "*";
                textField.setText("");
            }
        });

        btnDivision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	primervalor=Double.parseDouble(textField.getText());
                operador= "/";
                textField.setText("");
            }
        });

        btnIgual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!operador.isEmpty()) {
                    realizarOperacion();
                    operador = "";
                } 
            }
        });
        
    
    
    btnC.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            primervalor = 0.0;
            operador = "";
            textField.setText("");
        }
    });
    
    }

    

    private void realizarOperacion() {
        try {
            double segundovalor = Double.parseDouble(textField.getText());
            if (!operador.isEmpty()) {
                if (operador.equals("+")) {
                    primervalor += segundovalor;
                } else if (operador.equals("-")) {
                    primervalor -= segundovalor;
                } else if (operador.equals("*")) {
                    primervalor *= segundovalor;
                } else if (operador.equals("/")) {
                    if (segundovalor != 0) {
                        primervalor /= segundovalor;
                    } else {
                        textField.setText("Error: División por cero");
                        return;
                    }
                }
            } else {
                primervalor = segundovalor;
            }
            textField.setText(Double.toString(primervalor));
            operador = "";
        } catch (NumberFormatException e) {
            textField.setText("Error: Entrada no válida");
        }
    }

}