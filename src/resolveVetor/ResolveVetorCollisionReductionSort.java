package resolveVetor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import alteraPosicao.AlteraPosicaoVetorFilhos1Posicao;
import model.Vetor;

public class ResolveVetorCollisionReductionSort implements ResolveVetor{

	public static int instancia = 0;
	
	@Override
	public Vetor soluciona(Vetor vetor) {

		if(vetor.getColisoes() < 1 || instancia > 3000)
			return vetor;
		
		List<Vetor> vetores = new ArrayList<>();
		vetores.add(vetor);
		
		vetor = new Vetor(this.solucionar(vetores).get(0).getVetor());
		
		return vetor;
	}
	
	private List<Vetor> solucionar(List<Vetor> vetores){
		
		//Gero filhos para o primeiro index.Random k = new Random();
		Random k = new Random();
		int p = k.nextInt(vetores.size())/3;
		List<Vetor> filhosLista = AlteraPosicaoVetorFilhos1Posicao.getInstance().altera(vetores.get(p));
		
		vetores.remove(p);
		
		if(filhosLista.get(0).getColisoes() < 1 || instancia > 3000) {
			return filhosLista;
		}
		
		// Junto as duas lista para omitir as repetições
		Map<int[], Vetor> merge = new HashMap<>();
		for(Vetor vetor : vetores) {
			merge.put(vetor.getVetor(), vetor);
		}
		for(Vetor filho : filhosLista) {
			merge.put(filho.getVetor(), filho);
		}
		
		filhosLista.clear();
		
		filhosLista.addAll(merge.values());
		
		
		instancia++;
		System.out.println(instancia);
		
		return solucionar(filhosLista);
		
	}
	
}
