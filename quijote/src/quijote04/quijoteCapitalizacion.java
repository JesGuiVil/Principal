package quijote04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class quijoteCapitalizacion {

	public static void main(String[] args) {
		File quijote= null;
		FileReader fr= null;
		BufferedReader br= null;
		File archivo=null;
		FileWriter fw=null;
		PrintWriter pw=null;

		try{	
			quijote = new File("archivos\\elQuijote.txt");
			if(quijote.exists()) {
				fr = new FileReader(quijote);
				br= new BufferedReader(fr);
				archivo= new File("copia_elQuijote.txt");
				fw=new FileWriter(archivo);
				pw= new PrintWriter(fw);
				String linea;
				while((linea=br.readLine())!=null) {	
					String[] palabras=linea.split("\\s+");
					for(int i=0; i<palabras.length; i++) {
						if (palabras[i].equals("dulcinea")||palabras[i].equals("Dulcinea")||palabras[i].toUpperCase().equals("HIDALGO")||palabras[i].toUpperCase().equals("MOLINOS")) {
							palabras[i]=(palabras[i].toUpperCase());
						}		
					}
					String lineaAux=String.join(" ", palabras);
					pw.write(lineaAux);
					pw.write("\n");
				}
			}else{
				System.out.println("el archivo no existe");
			}
		}catch (FileNotFoundException e) {
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
				if(fw!=null) {
					fw.close();
				}
			}catch (Exception e2){
				e2.printStackTrace();
			}

		}


	}

}
