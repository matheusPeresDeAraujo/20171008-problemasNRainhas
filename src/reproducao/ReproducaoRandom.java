package reproducao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Vetor;

public class ReproducaoRandom implements Reproducao{

	Random r = new Random();

	@Override
	public List<Vetor> reproducao(List<Vetor> parents, int temperature) {
		
		List<Vetor> children = new ArrayList<>();
		int base = parents.get(0).getBase();
		int listSize = parents.size();
		
		for(int j = 0; j < 2; j++) {
			for(Vetor mother : parents) {
				
				Vetor dad = parents.get(changedDad(temperature, base, listSize));
				Vetor child = new Vetor(mother.getVetor());
				
				List<Integer> usedPositions = new ArrayList<>();
				int alteredPositions = alteredPositions(mother, dad, base, temperature);
				int position;
				for(int i = 0; i < alteredPositions; i++) {
					
					do {
						position = r.nextInt(mother.getBase());
					}while(usedPositions.contains(position));
					usedPositions.add(position);
					
					
					if(mutation(temperature, base)) {
						System.out.println("MUTATION");
						child.getVetor()[position] = r.nextInt(base);
					}else {
						child.getVetor()[position] = dad.getVetor()[position];
					}
					
				}
				child.setColisoes();
				children.add(child);
				
			}
		}
		return children;
	}
	
	private int changedDad(int temperature, int base, int listSize) {
		
		double scope = (temperature % (base*base)) / (double)(base*base);
		
		return r.nextInt(listSize - (int)(scope * listSize));
	}
	
	private int alteredPositions(Vetor mother, Vetor dad, int base, int temperature) {
		/*
		 * Exemplo: 8x8
		 * Pior caso: 	mother.colision = 64
		 * 				dad.colision = 2
		 * Resultado: 5 alterações em vetor de 8
		 * 
		 * Melhor caso:	mother.colision = 2
		 * 				dad.colision = 64
		 * Resultado: 1 alteração em vetor de 8
		 * 
		 */
		int alteredMinimum = 1;
		int altered = (mother.getColisoes() / dad.getColisoes()) / base;
		int alteredMutation = 0;
		
		if(mutation(temperature, base)) {
			alteredMutation = base/4;
			if(mother.getVetor().equals(dad.getVetor())) {
				alteredMutation = base/2;
				System.out.println("EXTREME MUTATION");
			}
		}
		
		return alteredMinimum + altered + alteredMutation;
	}
	
	private boolean mutation(int temperature, int base) {
		
		int lok = temperature / (base*base);
		if(lok % 2 == 0 && r.nextInt(2) == 1 && lok != 0) {
			return true;
		}
		return false;
	}
}
