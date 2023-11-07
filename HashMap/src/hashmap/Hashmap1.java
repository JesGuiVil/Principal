package hashmap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Hashmap1 {

    private JFrame frame;
    private Map<String, Double> registroNotas = new HashMap<>();
    private JTextArea textArea;
    private JTextField nombreField;
    private JTextField notaField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Hashmap1 window = new Hashmap1();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Hashmap1() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 750, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Botón para añadir nota
        JButton btnAddNota = new JButton("Añadir Nota");
        btnAddNota.setBounds(10, 10, 120, 30);
        frame.getContentPane().add(btnAddNota);

        // Botón para modificar nota
        JButton btnModifyNota = new JButton("Modificar Nota");
        btnModifyNota.setBounds(150, 10, 130, 30);
        frame.getContentPane().add(btnModifyNota);

        // Botón para eliminar nota
        JButton btnDeleteNota = new JButton("Eliminar Nota");
        btnDeleteNota.setBounds(296, 10, 130, 30);
        frame.getContentPane().add(btnDeleteNota);

        // Botón para listar notas
        JButton btnListNotas = new JButton("Listar Notas");
        btnListNotas.setBounds(447, 10, 130, 30);
        frame.getContentPane().add(btnListNotas);

        JButton btnExit = new JButton("Salir");
        btnExit.setBounds(595, 10, 130, 30);
        frame.getContentPane().add(btnExit);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 90, 715, 350);
        frame.getContentPane().add(scrollPane);
        
        JLabel lblNombre = new JLabel("Nombre del alumno:");
        lblNombre.setBounds(10, 50, 130, 30);
        frame.getContentPane().add(lblNombre);

        // Campo de texto para el nombre del alumno
        nombreField = new JTextField();
        nombreField.setBounds(150, 50, 350, 30);
        frame.getContentPane().add(nombreField);
        
        JLabel lblNota = new JLabel("Nota:");
        lblNota.setBounds(580, 50, 40, 30);
        frame.getContentPane().add(lblNota);

        // Campo de texto para la nota
        notaField = new JTextField();
        notaField.setBounds(625, 50, 100, 30);
        frame.getContentPane().add(notaField);
        
       
        btnAddNota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNota();
            }
        });

        btnModifyNota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modifyNota();
            }
        });

        btnDeleteNota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteNota();
            }
        });

        btnListNotas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listNotas();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void addNota() {
        String nombre = nombreField.getText();
        try {
            double nota = Double.parseDouble(notaField.getText());
            registroNotas.put(nombre, nota);
            textArea.append("Nota añadida para " + nombre + ": " + nota + "\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Por favor, ingresa una nota válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modifyNota() {
        String nombre = nombreField.getText();
        if (registroNotas.containsKey(nombre)) {
            try {
                double nuevaNota = Double.parseDouble(notaField.getText());
                registroNotas.put(nombre, nuevaNota);
                textArea.append("Nota modificada para " + nombre + ": " + nuevaNota + "\n");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Por favor, ingresa una nota válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "El alumno no existe en el registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteNota() {
        String nombre = nombreField.getText();
        if (registroNotas.containsKey(nombre)) {
            registroNotas.remove(nombre);
            textArea.append("Nota eliminada para " + nombre + "\n");
        } else {
            JOptionPane.showMessageDialog(frame, "El alumno no existe en el registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listNotas() {
        textArea.setText("Notas de los alumnos:\n");
        for (Map.Entry<String, Double> entry : registroNotas.entrySet()) {
            textArea.append("Alumno: " + entry.getKey() + ", Nota: " + entry.getValue() + "\n");
        }
    }
}
