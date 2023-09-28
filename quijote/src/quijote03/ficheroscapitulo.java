package quijote03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ficheroscapitulo {

	public static void main(String[] args) {
		int capitulo=0;
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
				String linea;
				while((linea=br.readLine())!=null) {
					if(linea.startsWith("CAPÍTULO ")||linea.startsWith("Capítulo ")) {
						capitulo++;
						archivo= new File("elQuijote_cap"+capitulo+".txt");
						fw=new FileWriter(archivo);
						pw=new PrintWriter(fw);
					}
					if(pw!=null) {
						pw.println(linea);
					}

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
			}catch (Exception e2){
				e2.printStackTrace();
			}

		}

	}


}
