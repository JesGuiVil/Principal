
package ejercicios3;
import java.util.Scanner;
public class pepelength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, res=0, resto=0;
		String n, p;
		Scanner leer = new Scanner (System.in);
		System.out.println("Introduce el número 1");
		n = leer.next();
		System.out.println("Introduce el número 2");
		p = leer.next();
		String[] pn = n.split("");
		String[] sn = p.split("");
		String pares1="";
		String impares1="";
		String pares2="";
		String impares2="";
		for(i=0; i<pn.length; i++) {
			if (Integer.parseInt(pn[i])%2==0) {
			pares1+=pn[i];	
			}else {
				impares1+=pn[i];
			}
		}
		for(i=0; i<sn.length; i++) {
			if (Integer.parseInt(sn[i])%2==0) {
			pares2+=sn[i];	
			}else {
				impares2+=sn[i];
			}
		}
		System.out.println(pares1);
		System.out.println(impares1);
		System.out.println(pares2);
		System.out.println(impares2);
	}
}