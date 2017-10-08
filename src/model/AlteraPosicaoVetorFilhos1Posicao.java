package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlteraPosicaoVetorFilhos1Posicao implements AlteraPosicaoVetorFilhos{

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
