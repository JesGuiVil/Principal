package ejercicios5;
import java.util.Scanner;
public class GraficaTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		// TODO Auto-generated method stub
		int j, i, tmin=100,tmax=0;
		String [] meses= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		String [] mesespoxos= {"    Enero    "," Febrero  ","  Marzo   ","  Abril   ","  Mayo    ","  Junio   ","  Julio   "," Agosto   ","Septiembre"," Octubre  ","Noviembre ","Diciembre "};
		int [] tempmes= new int[12];
		for(i=0; i<12; i++) {
			System.out.println("introduzca la temperatura media de "+meses[i]);
			tempmes[i]=leer.nextInt();
		}
		for(i=0; i<12; i++) {
			if(tempmes[i]>tmax) {
				tmax=tempmes[i];
			}
			if(tempmes[i]<tmin) {
				tmin=tempmes[i];
			}
		}
		for(i=tmax; i>tmin-2; i--) {
			if(i>=10 & i>tmin-1) {
				System.out.print(i+"º");
			}
			if(i>=0 & i>tmin-1 & i<10) {
				System.out.print(" "+i+"º");
			}
			if(i<0 & i>tmin-1) {
				System.out.print(i+"º");
			}
			for (j=0; j<12; j++) {
				if(i==tempmes[j]) {
					System.out.print(" ******** ");	
				}
				if(i>tmin-1 & i!=tempmes[j]) {
					System.out.print("----------");	
				}
				if (i==tmin-1) {
					System.out.print(mesespoxos[j]);	
				}
			}
			System.out.println("  ");	
		}
	}	
}