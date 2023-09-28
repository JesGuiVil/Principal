package Telefonos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Telefonos {

	public static void main(String[] args) {
		RandomAccessFile raf= null;
		int aux;
		int random;
		try {
			raf = new RandomAccessFile("archivos/telefonos.dat", "rw");
			raf.seek(0);
			for (int i=0; i<30;i++) {
				aux = (int)(Math.random() * 100000000) + 900000000;   
				random=aux;
				if (random!=0) {
					raf.writeInt(random);
				}
			}
			raf.close();
			raf = new RandomAccessFile("archivos//telefonos.dat", "r");
			raf.seek(0);
			aux = (int)(Math.random()*30);
			random=aux;
			for(int i=0; i<raf.length()/4;i++) {
				raf.seek(i*4);
				int telefono =raf.readInt();
				System.out.println(telefono);
			}
			System.out.println("buscando el telefono en la posicion "+random);
			raf.seek(random*4);
			int telefono =raf.readInt();
			System.out.println("el número en la posicion "+random+" es: "+telefono+" considerando que se empiece en la posicion 0");
			raf.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


