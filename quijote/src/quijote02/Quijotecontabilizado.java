package quijote02;

import java.io.*;

public class Quijotecontabilizado {

	public static void main(String[] args) {
		int contadorcapitulos=0, contadormolinos=0;
		File quijote= null;
		FileReader fr= null;
		BufferedReader br= null;
		try{	
			quijote = new File("archivos\\elQuijote.txt");
			if(quijote.exists()) {
				fr = new FileReader(quijote);
				br= new BufferedReader(fr);
				String linea;
				while((linea=br.readLine())!=null) {
					if(linea.startsWith("CAPÍTULO ")) {
						contadorcapitulos++;
					}
					if(linea.startsWith("Capítulo ")) {
						contadorcapitulos++;
					}
					contadormolinos=contadormolinos+cuentaPalabra(linea, "molino");
					contadormolinos=contadormolinos+cuentaPalabra(linea, "molinos");
				}
				System.out.println("El Quijote tiene "+contadorcapitulos+" capitulos");
				System.out.println("El Quijote tiene "+contadormolinos+" veces la palabra molino o molinos");
			}else {
				System.out.println("el fichero no existe");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try{
				if(br!=null) {
					br.close();
				}
				if(fr!=null) {
					fr.close();
				}		
			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}

	private static int cuentaPalabra(String linea, String palabra) {
		int contadorlinea=0;
		String[] palabras=linea.split(" ");
		for (String p: palabras) {
			if(p.equalsIgnoreCase(palabra)) {
				contadorlinea++;
			}
		}
		return contadorlinea;
	}
}
