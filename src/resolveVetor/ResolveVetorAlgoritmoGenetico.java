package resolveVetor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dopping.Dopping;
import dopping.DoppingTodosGenes;
import model.Vetor;
import reproducao.Reproducao;
import reproducao.ReproducaoRandom;

public class ResolveVetorAlgoritmoGenetico{
	
	int cont = 0;
	long geracoes = 0;
	List<Vetor> vetores = new ArrayList<>();
	List<Vetor> geracao = new ArrayList<>();
	Reproducao reproducao = new ReproducaoRandom();
	Dopping doppingTodosGenes = new DoppingTodosGenes();

	public List<Vetor> soluciona(List<Vetor> vetores) {
		
		do {

			this.vetores = vetores;
			vetores = this.solucionar();
			
		}while(vetores.get(0).getBase() > 0);

		return vetores;
	}
	
	private List<Vetor> solucionar(){

		cont++;
		geracoes++;
		System.out.println("Geração: " + geracoes);
		
		vetores = vetores.subList(0, (vetores.size()/2 - vetores.get(0).getBase()));
		vetores.addAll(doppingTodosGenes.dopping(vetores.get(0).getBase()));
		System.out.println(vetores.size());
		
		geracao = reproducao.reproducao(vetores);
		Collections.sort(geracao);

		geracao.get(0).imprimirVetor();
		if(geracao.get(0).getColisoes() ==  0) {
			return geracao;
		} else if(cont > 500){
			cont = 0;
			return geracao;
		} else {
			vetores = geracao;
			return solucionar();
		}
	}

}
