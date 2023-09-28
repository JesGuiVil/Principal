package accesovehiculos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Vehiculo {
	String matricula;
	String marca;
	Double deposito;
	String modelo;

	static RandomAccessFile raf= null;

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Double getDeposito() {
		return deposito;
	}
	public void setDeposito(Double deposito) {
		this.deposito = deposito;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public Vehiculo(String matricula, String marca, Double deposito, String modelo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.deposito = deposito;
		this.modelo = modelo;
	}
	public Vehiculo() {
		super();
		this.matricula = null;
		this.marca = null;
		this.deposito = null;
		this.modelo = null;
	}



	public void pedirDatos() {
		Scanner leer= new Scanner(System.in);
		do{
			System.out.println("Introduce matricula ");
			matricula=leer.next();
		}while(matricula.isEmpty() || matricula.length()>7);
		do{
			System.out.println("Introduce marca");
			marca=leer.next();
		}while(marca.isEmpty() || marca.length()>20);
		do{
			System.out.println("Introduce deposito");
			String depo=leer.next();
			try {
				deposito=Double.parseDouble(depo);
			}catch(NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		}while(Double.isNaN(deposito) || deposito==0);
		do{
			System.out.println("Introduce modelo");
			modelo=leer.next();
		}while(modelo.isEmpty() || modelo.length()>20);

		setMatricula(matricula);
		setMarca(marca);
		setDeposito(deposito);
		setModelo(modelo);
	}



	public void registrarCoche() {
		RandomAccessFile raf= null;
		try {
			raf = new RandomAccessFile("archivos//coches.dat", "rw");
			raf.seek(raf.length());
			StringBuffer bufferMarca = new StringBuffer();
			StringBuffer bufferModelo = new StringBuffer();

			if (getMatricula()!=null) {
				raf.writeChars(getMatricula());
			}
			if (getMarca()!=null) {
				bufferMarca.append(getMarca());
				bufferMarca.setLength(20);
				raf.writeChars(bufferMarca.toString());
			}
			if (getDeposito()!=null) {
				raf.writeDouble(getDeposito());
			}
			if (getModelo()!=null) {
				bufferModelo.append(getModelo());
				bufferModelo.setLength(20);
				raf.writeChars(bufferModelo.toString());
			}
			raf.close();

		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado");
			e.printStackTrace();
		}
	}
	


}
