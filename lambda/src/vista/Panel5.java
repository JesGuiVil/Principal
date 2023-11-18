package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.MetodosLambda5;

public class Panel5 extends JPanel {
 
    public JTextArea numerosTextArea;
    public JTextArea resultadounoTextArea;
    public JTextArea resultadodosTextArea;
    public JTextArea sumaTextArea;
    public JScrollPane scrollPane;
    public JScrollPane resultadounoScrollPane;
    public JScrollPane resultadodosScrollPane;
    public JScrollPane sumaScrollPane;

    public Panel5() {
        setLayout(null); 

        JButton iniciarButton = new JButton("Iniciar");
        iniciarButton.setBounds(170, 10, 150, 25);
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MetodosLambda5.sumaparalelo();
            }
        });
        add(iniciarButton);


        JButton reiniciarButton = new JButton("Reiniciar");
        reiniciarButton.setBounds(330, 10, 150, 25);
        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MetodosLambda5.resetear();
            }
        });
        add(reiniciarButton);

        JLabel label = new JLabel("lista de numeros :");
        label.setBounds(10, 45, 150, 25);
        add(label);

  
        numerosTextArea = new JTextArea();
        numerosTextArea.setLineWrap(true);
        numerosTextArea.setEditable(false);
        scrollPane = new JScrollPane(numerosTextArea);
        scrollPane.setBounds(10, 80, 470, 150);
        add(scrollPane);

        JLabel resultadounoLabel = new JLabel("Resultados de la primera parte :");
        resultadounoLabel.setBounds(10, 245, 300, 25);
        add(resultadounoLabel);


        resultadounoTextArea = new JTextArea();
        resultadounoTextArea.setEditable(false);
        resultadounoScrollPane = new JScrollPane(resultadounoTextArea);
        resultadounoScrollPane.setBounds(10, 280, 470, 25);
        add(resultadounoScrollPane);
        
        JLabel resultadodosLabel = new JLabel("Resultados de la segunda parte :");
        resultadodosLabel.setBounds(10, 320, 300, 25);
        add(resultadodosLabel);


        resultadodosTextArea = new JTextArea();
        resultadodosTextArea.setEditable(false);
        resultadodosScrollPane = new JScrollPane(resultadodosTextArea);
        resultadodosScrollPane.setBounds(10, 355, 470, 25);
        add(resultadodosScrollPane);


        JLabel sumaLabel = new JLabel("Resultado final :");
        sumaLabel.setBounds(10, 390, 200, 25);
        add(sumaLabel);

   
        sumaTextArea = new JTextArea();
        sumaTextArea.setEditable(false);
        sumaScrollPane = new JScrollPane(sumaTextArea);
        sumaScrollPane.setBounds(10, 425, 470, 25);
        add(sumaScrollPane);
    }
}
