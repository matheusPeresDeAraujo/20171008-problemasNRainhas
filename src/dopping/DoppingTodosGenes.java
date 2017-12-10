package dopping;

import java.util.ArrayList;
import java.util.List;

import model.Vetor;

public class DoppingTodosGenes implements Dopping{

	@Override
	public List<Vetor> dopping(int base) {
		List<Vetor> vetores = new ArrayList<>();
		for(int i = 0; i < base; i++) {
			Vetor vetor = new Vetor(base);
			for(int j = 0; j < base; j++) {
				vetor.getVetor()[j] = i;
			}
			vetores.add(vetor);
		}
		return vetores;
	}

}
