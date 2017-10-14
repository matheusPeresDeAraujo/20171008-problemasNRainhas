package areaDeTeste;

import model.Vetor;
import resolveVetor.ResolveVetorProfundidadePlanejada;
import resolveVetor.ResolveVetorProfundidadePlanejadaTodosResultados;

public class Teste05 {

	public static void main(String[] args) {
		/*	Teste
		 * 	MOstrar todos os resultados possiveis atráves de busca em profundidade
		 * 
		 * */
		Vetor vetor = new Vetor(7);
		System.out.println("Solução do problema: ");
		
		ResolveVetorProfundidadePlanejadaTodosResultados.getInstance().soluciona(vetor);

	}

}
