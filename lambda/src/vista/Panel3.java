package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.MetodosLambda3;

public class Panel3 extends JPanel {
 
    public JTextArea fechaTextArea;
 

    public Panel3() {
    	fechaTextArea = new JTextArea();
        fechaTextArea.setLineWrap(true);
        fechaTextArea.setEditable(false);
        
    	JLabel label = new JLabel("Fecha actual:");
        label.setBounds(10, 10, 150, 25);
        add(label);
        
        setLayout(null); 
        fechaTextArea = new JTextArea();
        fechaTextArea.setBounds(10, 45, 470, 25); // x, y, ancho, alto
        add(fechaTextArea);


        JButton consultarButton = new JButton("Consultar");
        consultarButton.setBounds(170, 10, 150, 25);
        consultarButton.addActionListener(e -> {
            MetodosLambda3.mostrarFechaActual();
    
        });
        add(consultarButton);


        JButton reiniciarButton = new JButton("Reiniciar");
        reiniciarButton.setBounds(330, 10, 150, 25);
        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MetodosLambda3.resetear();
            }
        });
        add(reiniciarButton);

        
        

      
    }
}
