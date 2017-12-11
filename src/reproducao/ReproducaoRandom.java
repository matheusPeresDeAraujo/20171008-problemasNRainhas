package reproducao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Vetor;

public class ReproducaoRandom implements Reproducao{

	@Override
	public List<Vetor> reproducao(List<Vetor> pais, int temperatura) {
		
		List<Vetor> filhos = new ArrayList<>();
		for(int j = 0; j < 2; j++) {
		for(Vetor mae : pais) {
			
			Random r = new Random();
			
			Vetor pai = pais.get(r.nextInt(pais.size() - (temperatura%pais.size())));
			
			// Estabelecimento de força
			// Quanto maior a força negativa, mais posições serão alteradas
			int forçaNegativa = (mae.getColisoes() / pai.getColisoes()) 
					/ mae.getBase() + 1;
			
			Vetor filho = new Vetor(mae.getVetor());
			
			List<Integer> posicoesTrocadas = new ArrayList<>();
			int posicao;
			for(int i = 0; i < forçaNegativa; i++) {
				do {
					
					posicao = r.nextInt(mae.getBase());
					
				}while(posicoesTrocadas.contains(posicao));
				posicoesTrocadas.add(posicao);

				filho.getVetor()[posicao] = pai.getVetor()[posicao];
				
				if(temperatura > pais.size()) {
					int lok = temperatura/pais.size();
					if(lok % 2 == 0 && r.nextInt(3) == 1) {
						filho.getVetor()[posicao] = r.nextInt(mae.getBase());
					}
				}
			}
			filho.setColisoes();
			filhos.add(filho);
//			System.out.println("Mae; Pai. Filho /n");
//			mae.imprimirVetor();
//			pai.imprimirVetor();
//			filho.imprimirVetor();
			
		}
		}
		return filhos;
	}

}
