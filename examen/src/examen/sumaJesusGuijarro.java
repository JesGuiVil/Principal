package examen;

public class sumaJesusGuijarro {

	public static double sumarElementosMatriz(int[][] matriz, int numerofilas, int numerocolumnas) {
	double sumatotal=0;
	int i,j;
	for (i=0; i<matriz.length;i++) {
		for(j=0;j<numerocolumnas;j++) {
			sumatotal=sumatotal+matriz[i][j];
		}
	}
	return sumatotal;
	}

}
