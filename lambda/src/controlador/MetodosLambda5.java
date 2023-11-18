package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

import vista.Panel5;

public class MetodosLambda5 {
	private static List<Integer> numerosList = new ArrayList<>();
	private static Panel5 panel;

	public MetodosLambda5(Panel5 panel) {
		this.panel = panel;
		
	}

	public static void sumaparalelo() {
		for(int i=0;i<100;i++) {
			numerosList.add((int) (Math.random()*50));
		}
		int mitad = numerosList.size() / 2;
		
		String listaNumeros = numerosList.stream().map(Object::toString).collect(Collectors.joining(", "));
	    panel.numerosTextArea.setText(listaNumeros);

		int sumaPrimeraMitad = numerosList.subList(0, mitad).parallelStream().mapToInt(Integer::intValue).sum();
		int sumaSegundaMitad = numerosList.subList(mitad, numerosList.size()).parallelStream().mapToInt(Integer::intValue).sum();
		
		panel.resultadounoTextArea.setText(""+sumaPrimeraMitad);
		panel.resultadodosTextArea.setText(""+sumaSegundaMitad);
		panel.sumaTextArea.setText(""+(sumaPrimeraMitad+sumaSegundaMitad));
	}


	public static void resetear() {
		panel.numerosTextArea.setText(null);
		panel.resultadounoTextArea.setText(null);
		panel.resultadodosTextArea.setText(null);
		panel.sumaTextArea.setText(null);
		numerosList.clear();
	}




}
