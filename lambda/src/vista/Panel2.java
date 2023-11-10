package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.MetodosLambda2;

public class Panel2 extends JPanel {
    public JTextField textFieldLista;
    public JTextArea nombresTextArea;
    public JTextArea mapeadosTextArea;
    public JTextArea sumaTextArea;
    public JScrollPane scrollPane;
    public JScrollPane mapeadosScrollPane;
    public JScrollPane sumaScrollPane;

    public Panel2() {
        setLayout(null); 
        textFieldLista = new JTextField();
        textFieldLista.setBounds(10, 10, 150, 25); // x, y, ancho, alto
        add(textFieldLista);


        JButton agregarButton = new JButton("Agregar Nombre");
        agregarButton.setBounds(170, 10, 150, 25);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MetodosLambda2.agregarNombre(textFieldLista.getText());
                MetodosLambda2.mapear();
                textFieldLista.setText(null);
                textFieldLista.requestFocus();
            }
        });
        add(agregarButton);


        JButton reiniciarButton = new JButton("Reiniciar");
        reiniciarButton.setBounds(330, 10, 150, 25);
        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MetodosLambda2.resetear();
            }
        });
        add(reiniciarButton);

        JLabel label = new JLabel("Nombres añadidos:");
        label.setBounds(10, 45, 150, 25);
        add(label);

  
        nombresTextArea = new JTextArea();
        nombresTextArea.setLineWrap(true);
        nombresTextArea.setEditable(false);
        scrollPane = new JScrollPane(nombresTextArea);
        scrollPane.setBounds(10, 80, 470, 50);
        add(scrollPane);

        JLabel mapeoLabel = new JLabel("Lista mapeada:");
        mapeoLabel.setBounds(10, 145, 150, 25);
        add(mapeoLabel);


        mapeadosTextArea = new JTextArea();
        mapeadosTextArea.setEditable(false);
        mapeadosScrollPane = new JScrollPane(mapeadosTextArea);
        mapeadosScrollPane.setBounds(10, 180, 470, 25);
        add(mapeadosScrollPane);


        JLabel sumaLabel = new JLabel("Lista mapeada sumada:");
        sumaLabel.setBounds(10, 220, 200, 25);
        add(sumaLabel);

   
        sumaTextArea = new JTextArea();
        sumaTextArea.setEditable(false);
        sumaScrollPane = new JScrollPane(sumaTextArea);
        sumaScrollPane.setBounds(10, 255, 470, 25);
        add(sumaScrollPane);
    }
}
