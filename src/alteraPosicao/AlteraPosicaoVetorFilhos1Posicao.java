package alteraPosicao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Vetor;

public class AlteraPosicaoVetorFilhos1Posicao implements AlteraPosicaoVetorFilhos{

	private static AlteraPosicaoVetorFilhos1Posicao instance = new AlteraPosicaoVetorFilhos1Posicao();
	
	private AlteraPosicaoVetorFilhos1Posicao() {};
	
	public static AlteraPosicaoVetorFilhos1Posicao getInstance() {
		return instance;
	}
	
	@Override
	public List<Vetor> altera(Vetor vetor) {
		
		List<Vetor> vetoresFilhos = new ArrayList<>();
		
		for(int i = 0; i < vetor.getBase(); i++) {

			int temp = vetor.getVetor()[i];
			
			for(int j = 0; j < vetor.getBase(); j++) {
				if(j != vetor.getVetor()[i]) {
					
					vetor.setVetor(i, j);
					vetoresFilhos.add(new Vetor(vetor.getVetor()));
					
				}
				
				vetor.setVetor(i, temp);
			}
		}
		
		Collections.sort(vetoresFilhos);
		
		return vetoresFilhos;
	}

}
