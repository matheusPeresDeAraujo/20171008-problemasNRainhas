package resolveVetor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dopping.DoppingTodosGenes;
import model.Vetor;
import reproducao.ReproducaoRandom;

public class ResolveVetorAlgoritmoGenetico{
	
	int cont = 0;
	int geracoes = 0;
	List<Vetor> vetores = new ArrayList<>();
	List<Vetor> geracao = new ArrayList<>();

	public List<Vetor> soluciona(List<Vetor> vetores) {
		
		do {
			Collections.sort(vetores);
			for(Vetor vetor : vetores) {
				try {
					vetor.arquivarVetor();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			this.vetores = vetores;
			vetores = this.solucionar();
			
		}while(vetores.get(0).getColisoes() > 0);

		return vetores;
	}
	
	private List<Vetor> solucionar(){

		cont++;
		geracoes++;
		
		System.out.println("Geração: " + geracoes);
		Collections.sort(vetores);
		vetores.get(0).imprimirVetor();
		
		if(vetores.get(0).getColisoes() ==  0) {
			return vetores;
		} else{
			
			vetores = vetores.subList(0, (vetores.size()/2 - vetores.get(0).getBase()));
			vetores.addAll(new DoppingTodosGenes().dopping(vetores.get(0).getBase()));
			
			geracao = new ReproducaoRandom().reproducao(vetores, geracoes);
			
			if(cont > vetores.get(0).getBase()) {
				cont = 0;
				return geracao;
			} else {
				vetores = geracao;
				return solucionar();
			}
		}
	}

}
