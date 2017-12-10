package resolveVetor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dopping.DoppingTodosGenes;
import model.Vetor;
import reproducao.Reproducao;
import reproducao.ReproducaoRandom;

public class ResolveVetorAlgoritmoGenetico{
	
	int cont = 0;

	public List<Vetor> soluciona(List<Vetor> vetores) {
		cont++;
		List<Vetor> geracao = new ArrayList<>();
		
		Collections.sort(vetores);
		vetores.get(0).imprimirVetor();

		if(vetores.get(0).getColisoes() ==  0) {
			System.out.println("Tenho a resposta: " + cont);
			return null;
		} else {
			vetores = vetores.subList(0, vetores.size()/2 - vetores.get(0).getBase());
			vetores.addAll(new DoppingTodosGenes().dopping(vetores.get(0).getBase()));
			
			Reproducao reproducao = new ReproducaoRandom();
			geracao = reproducao.reproducao(vetores);
			Collections.sort(geracao);
			geracao.get(0).imprimirVetor();
			
		}
		
		return soluciona(geracao);
	}
	
	private List<Vetor> solucionar(){
		return null;
	}

}
