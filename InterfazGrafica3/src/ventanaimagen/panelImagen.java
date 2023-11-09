package ventanaimagen;



	import java.awt.Dimension;
	import java.awt.Graphics;
	import javax.swing.ImageIcon;
	import javax.swing.JPanel;

	public class panelImagen extends JPanel{
		
		//El primer par�metro sera nuestro objeto de tipo ImageIcon, contiene la imagen que vamos a agregar.
		//El segundo y tercer par�metro ser�n dos valores enteros que equivalen a la posici�n en el eje x,y.
		//El cuarto y quinto par�metro ser�n las dimensiones que tendr� nuestra imagen, para este ejemplo las dimensiones sera iguales a las dimensiones de nuestro JPanel de esta manera garantizamos que la imagen tenga el mismo tama�o de nuestra ventana JFrame.
		//El ultimo par�metro solamente pasamos un valor null 

	    @Override
	    public void paint(Graphics g){
	        Dimension dimension = this.getSize();
	        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/onepiece.jpeg"));
	        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
	        setOpaque(false);
	        super.paintChildren(g);
	    }
	 
	    
	}



