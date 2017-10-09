package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResolveVetorCollisionReduction implements ResolveVetor{

	public static int instancia = 0;
	private Map<String, Vetor> tentativas = new HashMap<>();
	private List<Vetor> folhasAbertas = new ArrayList();
	
	@Override
	public Vetor soluciona(Vetor vetor) {
				
		if(vetor.getColisoes() < 1) {
			return vetor;
		}
		
		folhasAbertas.add(vetor);
		
		while(vetor.getColisoes() > 0) {
			
			instancia = 0;
			
			this.solucionar();
			vetor = new Vetor(folhasAbertas.get(0).getVetor());
		}
		
		return vetor;
	}
	
	private List<Vetor> solucionar(){
		
		//É a resposta
		if(folhasAbertas.get(0).getColisoes() < 1 || instancia > 3000) {
			return folhasAbertas;
		}
		
		//Gero filhos caso não tenha a resposta.
		AlteraPosicaoVetorFilhos filhos = new AlteraPosicaoVetorFilhos1Posicao();
		List<Vetor> filhosLista = filhos.altera(folhasAbertas.get(0));
		
		tentativas.put(folhasAbertas.get(0).getSenha(),folhasAbertas.get(0));
		folhasAbertas.get(0).imprimirVetor();
		folhasAbertas.remove(0);
		
		// Junto as duas lista para omitir as repetições
		Map<String, Vetor> merge = new HashMap<>();
		for(Vetor vetor : folhasAbertas) {
			merge.put(vetor.getSenha(), vetor);
		}
		for(Vetor filho : filhosLista) {
			merge.put(filho.getSenha(), filho);
		}
		
		//remove do map os que já foram utilizados
		for(String usados : tentativas.keySet()) {
			if(merge.containsKey(usados)) {
				merge.remove(usados);
			}
		}
		
		folhasAbertas.clear();
		filhosLista.clear();
		
		folhasAbertas.addAll(merge.values());
		
		System.out.println("Possibilidades utilizadas: " + tentativas.size());
		System.out.println("Folhas abertas: " + folhasAbertas.size());
		System.out.println("Total de possibilidades igual a: " + Math.pow(folhasAbertas.get(0).getBase(), folhasAbertas.get(0).getBase()) + " Verificado: " + ((folhasAbertas.size()+tentativas.size())/Math.pow(folhasAbertas.get(0).getBase(), folhasAbertas.get(0).getBase())) + "\n\n");
		instancia++;
		
		return solucionar();
		
	}
	
}
