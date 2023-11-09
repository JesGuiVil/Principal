package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;

 
/**
 * ESTA CLASE DEBE IMPLEMENTAR LA INTERFAZ DE JAVA ACTIONLISTENER
 * Y DEBE SOBREESCRIBIR TODOS LOS M�TODOS QUE CONTENGA ESTA INTERFAZ
 */
 
public class Controlador implements ActionListener {
 
    // Creamos una variable de tipo PintarVentana
    Vista vistaDesactivarVentana;
     
    /**
     * EL M�TODO CONSTRUCTOR RECIBIR� POR PAR�METRO UN
     * OBJETO DE TIPO PINTAR VENTANA Y A ESTE OBJETO
     */
     
    public Controlador(Vista vDesactivar) {
        // A La variable vista se le asignara
        // un objeto de la clase  llamado vDesactivar
        // y el cual se le esta pasando por par�metro
        // en el constructor de esta clase
        this.vistaDesactivarVentana=vDesactivar;
    }
     
    /**
     * ESTE M�TODO PONE A LA ESCUCHA DE LOS EVENTOS
     * DE CLIC DE RATON A CADA UNO DE LOS BOTONES
     * DE LA VENTANA CREADA EN EL PAQUETE VISTA
     */
    public void escucharEventos() {
         
        for(int x=0;x<vistaDesactivarVentana.botones.length;x++) {
            vistaDesactivarVentana.botones[x].addActionListener(this);
        }
    }
     
    /**
     * ESTE M�TODO SE ENCARGA DE EJECUTAR LAS ACCIONES
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
         
          
        if(e.getSource().equals(vistaDesactivarVentana.botones[0])) {
            vistaDesactivarVentana.botones[0].setEnabled(false);
            vistaDesactivarVentana.lblNumero.setText("Bot�n 1 desactivado");
        }
          
        else if(e.getSource().equals(vistaDesactivarVentana.botones[1])) {
            vistaDesactivarVentana.botones[1].setEnabled(false);
            vistaDesactivarVentana.lblNumero.setText("Bot�n 2 desactivado");
        }
          
        else if(e.getSource().equals(vistaDesactivarVentana.botones[2])) {
            vistaDesactivarVentana.botones[2].setEnabled(false);
            vistaDesactivarVentana.lblNumero.setText("Bot�n 3 desactivado");
        }
        else if(e.getSource().equals(vistaDesactivarVentana.botones[3])) {
            vistaDesactivarVentana.botones[3].setEnabled(false);
            vistaDesactivarVentana.lblNumero.setText("Bot�n 4 desactivado");
        }
          
        else if(e.getSource().equals(vistaDesactivarVentana.botones[4])) {
            vistaDesactivarVentana.botones[4].setEnabled(false);
            vistaDesactivarVentana.lblNumero.setText("Bot�n 5 desactivado");
        }
          
        else if(e.getSource().equals(vistaDesactivarVentana.botones[5])) {
            vistaDesactivarVentana.botones[5].setEnabled(false);
            vistaDesactivarVentana.lblNumero.setText("Bot�n 6 desactivado");
        }
         
        else if(e.getSource().equals(vistaDesactivarVentana.botones[6])) {
            vistaDesactivarVentana.botones[6].setEnabled(false);
            vistaDesactivarVentana.lblNumero.setText("Bot�n 7 desactivado");
        }
         
        else if(e.getSource().equals(vistaDesactivarVentana.botones[7])) {
            vistaDesactivarVentana.botones[7].setEnabled(false);
            vistaDesactivarVentana.lblNumero.setText("Bot�n 8 desactivado");
        }
        else if(e.getSource().equals(vistaDesactivarVentana.botones[8])) {
            vistaDesactivarVentana.botones[8].setEnabled(false);
            vistaDesactivarVentana.lblNumero.setText("Bot�n 9 desactivado");
        }
    }
}