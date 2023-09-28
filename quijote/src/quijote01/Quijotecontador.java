package quijote01;

import java.io.*;

public class Quijotecontador {

	public static void main(String[] args) {
		int contador=0, contadorpalabras=0;
		File quijote= null;
		FileReader fr= null;

		try{	
			quijote = new File("archivos\\elQuijote.txt");
			if(quijote.exists()) {
			fr = new FileReader(quijote);
			int letra;
			letra=fr.read();
			while(letra!=-1) {
				letra=fr.read();
				contador++;
				if(letra==32 || letra==10) {
					contadorpalabras++;
				}
			}
			System.out.println("El Quijote tiene "+contador+" caracteres");
			System.out.println("El Quijote tiene "+contadorpalabras+" palabras");
			}else {
				System.out.println("el fichero no existe");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try{
				if(fr!=null) {
					fr.close();
				}
				}catch (Exception e2){
				e2.printStackTrace();
				}
		
		}
	
	}

}
