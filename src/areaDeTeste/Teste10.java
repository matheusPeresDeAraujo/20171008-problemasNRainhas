package areaDeTeste;

import java.util.List;

import dopping.DoppingTodosGenes;
import model.Vetor;

public class Teste10 {

	public static void main(String[] args) {
		
		/*
		 * Teste do retorno no dopping all genes
		 * Teste de soma de listas.
		 */
		
		List<Vetor> vetores = new DoppingTodosGenes().dopping(10);
		List<Vetor> vetores2 = new DoppingTodosGenes().dopping(7);
		vetores.addAll(vetores2);
		
		for(Vetor vetor : vetores) {
			vetor.imprimirVetor();
		}
	}

}
