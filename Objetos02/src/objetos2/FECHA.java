package objetos2;
public class FECHA {
//ATRIBUTOS
	private int dia, mes, anio;
	private static final int DIA=1, MES=1, ANIO=1;
//getters and setters	

	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	//CONSTRUCTORES
	public FECHA() {
		this.setDia(DIA);
		this.setMes(MES);
		this.setAnio(ANIO);
	}
	public FECHA(FECHA dato) {
		this.setDia(dato.getDia());
		this.setMes(dato.getMes());
		this.setAnio(dato.getAnio());
	}
	public FECHA(int dia, int mes, int anio) {
		this.setDia(dia);
		this.setMes(mes);
		this.setAnio(anio);
		fechaCorrecta();
	}
	//METODOS
	private boolean esBisiesto() {
		boolean correcto=false;
		if((this.getAnio()%400==0) | (this.getAnio()%100!=0 & this.getAnio()%4==0)){
			correcto=true;	
		}
		return correcto;
	}
	public boolean fechaCorrecta() {
		boolean correcto=true;
		if (this.getDia()<1 | this.getMes()<1 | this.getMes()>12) {
			correcto=false;
		}
		if(esBisiesto()==true & this.getMes()==2 & this.getDia()>29){
			correcto=false;
		}
		if(esBisiesto()==false & this.getMes()==2 & this.getDia()>28){
			correcto=false;
		}
		if ((this.getMes()==1 | this.getMes()==3 | this.getMes()==5 | this.getMes()==7 | this.getMes()==8 | this.getMes()==10 | this.getMes()==12) & (this.getDia()>31)) {
			correcto=false;
		}
		if ((this.getMes()==4 | this.getMes()==6 | this.getMes()==9 | this.getMes()==11) & (this.getDia()>30)) {
			correcto=false;
		}
		if(correcto==false) {
			System.out.println("la fecha introducida es incorrecta");
		}
		return correcto;
	}
	
	public void diaSiguiente() {
		this.setDia(this.getDia()+1);
		fechaCorrecta();
		if (!fechaCorrecta()) {
			this.setDia(1);
			this.setMes(this.getMes()+1);
			fechaCorrecta();
		}
		if (!fechaCorrecta()) {
			this.setDia(1);
			this.setMes(1);
			this.setAnio(this.getAnio()+1);
		}
	}
	public String toString() {
		String cadena="";
		if (this.getDia()<10) {
			cadena+="0"+this.getDia();
		}else {
			cadena+=this.getDia();
		}
		if (this.getMes()<10) {
			cadena+="-0"+this.getMes();
		}else {
			cadena+="-"+this.getMes();
		}
		if (Math.abs(this.getAnio())>999 & this.getAnio()>0) {
			cadena+="-"+Math.abs(this.getAnio());
		}
		if (Math.abs(this.getAnio())<1000 & Math.abs(this.getAnio())>99 & this.getAnio()>=0) {
			cadena+="-0"+Math.abs(this.getAnio());
		}
		if (Math.abs(this.getAnio())<100 & Math.abs(this.getAnio())>9 & this.getAnio()>=0) {
			cadena+="-00"+Math.abs(this.getAnio());
		}
		if (Math.abs(this.getAnio())<10 & Math.abs(this.getAnio())>0 & this.getAnio()>=0) {
			cadena+="-000"+Math.abs(this.getAnio());
		}
		if (Math.abs(this.getAnio())>999 & this.getAnio()<0) {
			cadena+=Math.abs(this.getAnio())+"a.c";
		}
		if (Math.abs(this.getAnio())<1000 & Math.abs(this.getAnio())>99 & this.getAnio()<0) {
			cadena+="-0"+Math.abs(this.getAnio())+"a.c";
		}
		if (Math.abs(this.getAnio())<100 & Math.abs(this.getAnio())>9 & this.getAnio()<0) {
			cadena+="-00"+Math.abs(this.getAnio())+"a.c";
		}
		if (Math.abs(this.getAnio())<10 & Math.abs(this.getAnio())>0 & this.getAnio()<0) {
			cadena+="-000"+Math.abs(this.getAnio())+"a.c";
		}
		return cadena;
	}
	public void mostrarFecha() {
		String mes="";
		switch (this.getMes()){
		case 1: mes+="Enero";
		break;
		case 2: mes+="Febrero";
		break;
		case 3: mes+="Marzo";
		break;
		case 4: mes+="Abril";
		break;
		case 5: mes+="Mayo";
		break;
		case 6: mes+="Junio";
		break;
		case 7: mes+="Julio";
		break;
		case 8: mes+="Agosto";
		break;
		case 9: mes+="Septiembre";
		break;
		case 10: mes+="Octubre";
		break;
		case 11: mes+="Noviembre";
		break;
		case 12: mes+="Diciembre";
		break;
		}
		String cadena="";
		if (this.getDia()<10) {
			cadena+="0"+this.getDia();
		}else {
			cadena+=this.getDia();
		}
		cadena+="-"+mes;
		if (Math.abs(this.getAnio())>999 & this.getAnio()>0) {
			cadena+="-"+Math.abs(this.getAnio());
		}
		if (Math.abs(this.getAnio())<1000 & Math.abs(this.getAnio())>99 & this.getAnio()>=0) {
			cadena+="-0"+Math.abs(this.getAnio());
		}
		if (Math.abs(this.getAnio())<100 & Math.abs(this.getAnio())>9 & this.getAnio()>=0) {
			cadena+="-00"+Math.abs(this.getAnio());
		}
		if (Math.abs(this.getAnio())<10 & Math.abs(this.getAnio())>0 & this.getAnio()>=0) {
			cadena+="-000"+Math.abs(this.getAnio());
		}
		if (Math.abs(this.getAnio())>999 & this.getAnio()<0) {
			cadena+=Math.abs(this.getAnio())+"a.c";
		}
		if (Math.abs(this.getAnio())<1000 & Math.abs(this.getAnio())>99 & this.getAnio()<0) {
			cadena+="-0"+Math.abs(this.getAnio())+"a.c";
		}
		if (Math.abs(this.getAnio())<100 & Math.abs(this.getAnio())>9 & this.getAnio()<0) {
			cadena+="-00"+Math.abs(this.getAnio())+"a.c";
		}
		if (Math.abs(this.getAnio())<10 & Math.abs(this.getAnio())>0 & this.getAnio()<0) {
			cadena+="-000"+Math.abs(this.getAnio())+"a.c";
		}
		System.out.println(cadena);
	}
	public boolean esMayorQue(FECHA dato) {
		boolean correcto=true;
		if(this.getAnio()<dato.getAnio()) {
			correcto=false;
		}
		if(this.getAnio()==dato.getAnio() & this.getMes()<dato.getMes()) {
			correcto=false;
		}
		if(this.getAnio()==dato.getAnio() & this.getMes()==dato.getMes() & this.getDia()<dato.getDia()) {
			correcto=false;
		}
		return correcto;
	}
}
