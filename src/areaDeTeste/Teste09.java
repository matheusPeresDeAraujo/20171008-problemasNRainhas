package areaDeTeste;

import java.util.List;

import inicializacao.InicializacaoRandom;
import model.Matriz;
import model.Vetor;
import resolveVetor.ResolveVetorAlgoritmoGenetico;

public class Teste09 {

	public static void main(String[] args) {
		/*
		 * Tentiva de resolucao
		 */
		
		List<Vetor> vetores = new InicializacaoRandom().inicializa(50, 10);
		new Matriz(new ResolveVetorAlgoritmoGenetico().soluciona(vetores).get(0)).imprimirMatriz();
	}

}
