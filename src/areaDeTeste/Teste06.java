package areaDeTeste;

import model.Vetor;
import resolveVetor.*;

public class Teste06 {

	public static void main(String[] args) {
		/*	Teste
		 * 	Mostrar resultado atráves do Reduction
		 * 
		 * */
		Vetor vetor = new Vetor(100);
		System.out.println("Solução do problema: ");
		
		ResolveVetorCollisionReduction.getInstance().soluciona(vetor);

	}

}
