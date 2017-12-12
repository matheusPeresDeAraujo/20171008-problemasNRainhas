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
			
			vetores.add(new StartVetorRandom().inicializa(new Vetor(tamanhoVetor)));
			
		}
		
		return vetores;
	}

}
