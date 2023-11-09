package vista;



import java.awt.BorderLayout;
import java.awt.GridLayout;
 
// Importamos el paquete swing para trabajar con interfaces gr�ficas
import javax.swing.*;
import controlador.*;
 
/**
 * ESTA CLASE DEBE HEREDAR DE JFRAME PARA PODER
 * CREAR LA VENTANA DE NUESTRA INTERFAZ
 */
public class Vista extends JFrame{
     
    
    // Creamos una l�mina para colocar encima del JFrame
    public JPanel laminaFondo = new JPanel(); 
    public JPanel laminaBotones = new JPanel();
     
    // Creamos los controles que tendr� nuestra l�mina
     private JLabel lblTitulo = new JLabel();
     public JLabel lblNumero = new JLabel(); 
     public JButton [] botones =new JButton[9];
     
    /**
     * EL CONSTRUCTOR CREA LA VENTANA, LE DA UNAS PROPIEDADES
     * Y ADEM�S EN EL, SE INDICA QUE SE LE AGREGUE UN JPANEL,
     * UNA LAMINA PARA PODER AGREGAR
     * LOS CONTROLES NECESARIOS
     */
    
    
    private void configurarLaminaFondo() {
         
        // Le damos a la lamina una distribuci�n de tipo BorderLayout.
        laminaFondo.setLayout(new BorderLayout());
         
        // Colocamos un texto a las etiquetas
        lblTitulo.setText("Pulsa cada bot�n para desactivarlo");
        lblNumero.setText("N�mero");
         
        // Agregamos las etiquetas al norte y al sur de la lamina
        laminaFondo.add(lblNumero,BorderLayout.SOUTH);
        laminaFondo.add(lblTitulo,BorderLayout.NORTH);
         
        // Alineamos el texto de las etiquetas
        lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
           
    }
     
    private void configurarLaminaBotones() {
         
        // Le damos a la lamina botones una distribucion del tipo GridLayout
        laminaBotones.setLayout(new GridLayout(3,3));
         
        /* Con un bucle, agrego los botones del 1 al 9
         * al panel en forma de rejilla*/
        for(int x=0;x<botones.length;x++) {
                      
            botones[x]=new JButton("Bot�n " + (x+1));
            laminaBotones.add(botones[x]);
        }     
      
        // Agregamos la laminaBotones en el centro de la laminaFondo
        laminaFondo.add(laminaBotones,BorderLayout.CENTER);
    }
    
    
    
    //Conectar Vista con Controlador
    
 // Creamos una instancia de nuestra clase controlador
    private Controlador ejecutarAcciones;
     
    /**
    * ESTE M�TODO EJECUTA LAS ACCIONES DEL CONTROLADOR UNA VEZ
    * QUE ES LLAMADO DESDE EL CONSTRUCTOR DE ESTA CLASE
    */
    private void ejecutar() {
        ejecutarAcciones = new Controlador(this);
        ejecutarAcciones.escucharEventos();
    }
     
    /**
    * EL CONSTRUCTOR QUEDAR�A DE LA SIGUIENTE MANERA:
    */
    public Vista() {
              
            // Le damos un tama�o a la ventana
            this.setSize(640, 480);
             
            // Agregamos un t�culo
            this.setTitle("Desactivar botones");
              
            // Lo centramos en pantalla
            this.setLocationRelativeTo(null);
              
            /* Le decimos que no se puede redimensionar*/
            this.setResizable(false);
              
            // Le decimos que al cerrar la ventana, acabe el programa
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              
            // Agregamos una l�mina a la ventana
            this.getContentPane().add(laminaFondo);
             
            // llamamos al m�todo que configura la lamina fondo
            // y la lamina de los botones
            configurarLaminaFondo();
            configurarLaminaBotones();
            ejecutar();
        }    
   
    }