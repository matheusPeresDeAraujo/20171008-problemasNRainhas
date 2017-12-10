package areaDeTeste;

import java.util.Collections;
import java.util.List;

import inicializacao.InicializacaoRandom;
import model.Vetor;
import reproducao.Reproducao;
import reproducao.ReproducaoRandom;

public class Teste08 {

	public static void main(String[] args) {
		/*
		 * Testando a reprodução 
		 */
		
		// 1 - Definir tipo de inicialização
		
				InicializacaoRandom iRandom = new InicializacaoRandom();
				List<Vetor> vetores = iRandom.inicializa(1000, 8);

				// 2 - Ordenar os índividuos
				Collections.sort(vetores);
				
//				for(Vetor vetor : vetores){
//					vetor.imprimirVetor();
//				}
				vetores.get(0).imprimirVetor();
				
				// 3 - Verificar se tenho a resposta
				
				if(vetores.get(0).getColisoes() ==  0) {
					System.out.println("Tenho a resposta");
				}
				
				// 4 - Gerar os filhos
				// Mato metade e duplico o restante para combinacao

				System.out.println("Antes: "+vetores.size());
				vetores = vetores.subList(0, vetores.size()/2);
				System.out.println("Depois: "+vetores.size());
				
				
				Reproducao reproducao = new ReproducaoRandom();
				List<Vetor> geracao = reproducao.reproducao(vetores);

				Collections.sort(geracao);
//				for(Vetor vetor : geracao){
//					vetor.imprimirVetor();
//				}
				geracao.get(0).imprimirVetor();
				
				
	}

}
