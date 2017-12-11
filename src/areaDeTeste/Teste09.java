package areaDeTeste;

import java.util.List;

import inicializacao.InicializacaoRandom;
import model.Vetor;
import resolveVetor.ResolveVetorAlgoritmoGenetico;

public class Teste09 {

	public static void main(String[] args) {
		/*
		 * Tentiva de resolucao
		 */
		
		InicializacaoRandom iRandom = new InicializacaoRandom();
		List<Vetor> vetores = iRandom.inicializa(50, 12);
		
		ResolveVetorAlgoritmoGenetico resolve = new ResolveVetorAlgoritmoGenetico();
		resolve.soluciona(vetores);
	}

}
