package areaDeTeste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import inicializacao.InicializacaoRandom;
import model.Vetor;

public class Teste07 {

	public static void main(String[] args) {
		
		
		// 1 - Definir tipo de inicialização
		
		InicializacaoRandom iRandom = new InicializacaoRandom();
		List<Vetor> vetores = iRandom.inicializa(10, 10);
		
		for(Vetor vetor : vetores){
			vetor.imprimirVetor();
		}
		
		// 2 - Ordenar os índividuos
		
		Collections.sort(vetores);
		
		// 3 - Verificar se tenho a resposta
		
		if(vetores.get(0).getColisoes() ==  0) {
			System.out.println("Tenho a resposta");
		}
		
		// 4 - Gerar os filhos
		// Mato metade e duplico o restante para combinacao

		System.out.println("Antes: "+vetores.size());
		vetores = vetores.subList(0, vetores.size()/2);
		System.out.println("Depois: "+vetores.size());
		
		
		// Crio uma nova lista de vetores pegando metade do gene de cada par.
		
		List<Vetor> geracao = new ArrayList<>();
		for(int i = 1; i < vetores.size(); i++) {
			
			Vetor v1 = vetores.get(0);
			Vetor v2 = vetores.get(i);
			Vetor result = new Vetor(v1.getBase());
			Vetor result2 = new Vetor(v1.getBase());
			
			for(int j = 0; j < v1.getBase()/2; j++) {
				result.getVetor()[j] = v1.getVetor()[j];
			}
			
			for(int j = v1.getBase()/2; j < v1.getBase(); j++) {
				result.getVetor()[j] = v2.getVetor()[j];
			}
			
			geracao.add(result);
			
			for(int j = 0; j < v1.getBase()/2; j++) {
				result2.getVetor()[j] = v2.getVetor()[j];
			}
			
			for(int j = v1.getBase()/2; j < v1.getBase(); j++) {
				result2.getVetor()[j] = v1.getVetor()[j];
			}
			
			geracao.add(result2);
		}
		
		for(Vetor vetor : geracao){
			vetor.imprimirVetor();
		}
		
	}

}
