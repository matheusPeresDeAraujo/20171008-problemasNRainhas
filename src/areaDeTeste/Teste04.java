package areaDeTeste;

import model.Vetor;
import resolveVetor.*;

public class Teste04 {

	public static void main(String[] args) {
		
		/*	Teste
		 * 	Tentar resolver o vetor atráves de busca em profundidade
		 * 
		 * */
		Vetor vetor = new Vetor(20);
		System.out.println("Solução do problema: ");
		
		ResolveVetorProfundidadePlanejada.getInstance().soluciona(vetor);
	
	}

}
