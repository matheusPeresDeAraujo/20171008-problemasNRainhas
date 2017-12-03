package inicializacao;

import java.util.ArrayList;
import java.util.List;

import model.Vetor;
import startVetor.StartVetor;
import startVetor.StartVetorRandom;

public class InicializacaoRandom implements Inicializacao{

	@Override
	public List<Vetor> inicializa(int populacao, int tamanhoVetor) {
		
		List<Vetor> vetores = new ArrayList<>();
		
		for(int i = 0; i < populacao; i++) {
			
			Vetor vetor = new Vetor(tamanhoVetor);
			StartVetor startRandom = new StartVetorRandom();
			startRandom.inicializa(vetor);
			
			vetores.add(vetor);
			
		}
		
		
		return vetores;
	}

}
