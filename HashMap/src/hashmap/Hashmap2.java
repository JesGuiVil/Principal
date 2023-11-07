package hashmap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Hashmap2 {

    private JFrame frame;
    private Map<String, Producto> inventario = new HashMap<>();
    private JTextArea textArea;
    private JTextField nombreProductoField;
    private JTextField unidadesField;
    private JTextField precioField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Hashmap2 window = new Hashmap2();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Hashmap2() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 825, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Botón para añadir producto
        JButton btnAddProducto = new JButton("Añadir Producto");
        btnAddProducto.setBounds(10, 10, 150, 30);
        frame.getContentPane().add(btnAddProducto);

        // Botón para vender producto
        JButton btnVenderProducto = new JButton("Vender Producto");
        btnVenderProducto.setBounds(170, 10, 150, 30);
        frame.getContentPane().add(btnVenderProducto);

        // Botón para eliminar producto
        JButton btnEliminarProducto = new JButton("Eliminar Producto");
        btnEliminarProducto.setBounds(330, 10, 150, 30);
        frame.getContentPane().add(btnEliminarProducto);

        // Botón para ver productos
        JButton btnVerProductos = new JButton("Ver Productos");
        btnVerProductos.setBounds(490, 10, 150, 30);
        frame.getContentPane().add(btnVerProductos);

        JButton btnExit = new JButton("Salir");
        btnExit.setBounds(650, 10, 150, 30);
        frame.getContentPane().add(btnExit);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 90, 790, 350);
        frame.getContentPane().add(scrollPane);

        JLabel lblNombreProducto = new JLabel("Nombre del Producto:");
        lblNombreProducto.setBounds(30, 50, 150, 30);
        frame.getContentPane().add(lblNombreProducto);

        // Campo de texto para el nombre del producto
        nombreProductoField = new JTextField();
        nombreProductoField.setBounds(170, 50, 230, 30);
        frame.getContentPane().add(nombreProductoField);

        JLabel lblUnidades = new JLabel("Unidades:");
        lblUnidades.setBounds(420, 50, 140, 30);
        frame.getContentPane().add(lblUnidades);

        // Campo de texto para las unidades vendidas
        unidadesField = new JTextField();
        unidadesField.setBounds(490, 50, 100, 30);
        frame.getContentPane().add(unidadesField);
        
        JLabel precioUnidad = new JLabel("Precio unidad:");
        precioUnidad.setBounds(600, 50, 140, 30);
        frame.getContentPane().add(precioUnidad);

        // Campo de texto para las unidades vendidas
        precioField = new JTextField();
        precioField.setBounds(700, 50, 100, 30);
        frame.getContentPane().add(precioField);

        btnAddProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProducto();
            }
        });

        btnVenderProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                venderProducto();
            }
        });

        btnEliminarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });

        btnVerProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verProductos();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void addProducto() {
        String nombreProducto = nombreProductoField.getText();
        if (!nombreProducto.isEmpty()) {
            try {
                int cantidad = Integer.parseInt(unidadesField.getText());
                double precio = Double.parseDouble(precioField.getText());

                inventario.put(nombreProducto, new Producto(cantidad, precio));
                textArea.append("Producto añadido: " + nombreProducto + "\n");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Por favor, ingresa una cantidad y un precio válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Por favor, ingresa el nombre del producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void venderProducto() {
        String nombreProducto = nombreProductoField.getText();
        if (!nombreProducto.isEmpty()) {
            int unidadesVendidas;
            try {
                unidadesVendidas = Integer.parseInt(unidadesField.getText());
                if (inventario.containsKey(nombreProducto)) {
                    Producto producto = inventario.get(nombreProducto);
                    int stockActual = producto.getStock();
                    double precio = producto.getPrecio();

                    if (stockActual >= unidadesVendidas) {
                        inventario.put(nombreProducto, new Producto(stockActual - unidadesVendidas, precio));
                        textArea.append("Vendido " + unidadesVendidas + " unidades de " + nombreProducto + " por un total de $" + (unidadesVendidas * precio) + "\n");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Stock insuficiente para vender.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "El producto no existe en el inventario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Por favor, ingresa un número válido para las unidades vendidas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Por favor, ingresa el nombre del producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarProducto() {
        String nombreProducto = nombreProductoField.getText();
        if (!nombreProducto.isEmpty()) {
            if (inventario.containsKey(nombreProducto)) {
                inventario.remove(nombreProducto);
                textArea.append("Producto eliminado: " + nombreProducto + "\n");
            } else {
                JOptionPane.showMessageDialog(frame, "El producto no existe en el inventario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Por favor, ingresa el nombre del producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void verProductos() {
        textArea.setText("Inventario de productos:\n");
        for (Map.Entry<String, Producto> entry : inventario.entrySet()) {
            String nombreProducto = entry.getKey();
            Producto producto = entry.getValue();
            int stock = producto.getStock();
            double precio = producto.getPrecio();

            // Formatear el precio con 2 decimales
            String precioFormateado = String.format("%.2f", precio);

            textArea.append("Producto: " + nombreProducto + ", Stock: " + stock + ", Precio: " + precioFormateado + "€\n");
        }
    }
}

