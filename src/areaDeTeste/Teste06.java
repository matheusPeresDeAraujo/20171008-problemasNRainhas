package areaDeTeste;

import model.Vetor;
import resolveVetor.*;
import startVetor.StartVetor;
import startVetor.StartVetorEscada0;
import startVetor.StartVetorEscada1;

public class Teste06 {

	public static void main(String[] args) {
		/*	Teste
		 * 	Mostrar resultado atráves do Reduction
		 * 
		 * */
		Vetor vetor = new Vetor(100);
//		vetor = new StartVetorEscada1().inicializa(vetor);
		System.out.println("Solução do problema: ");
		
		ResolveVetorCollisionReduction.getInstance().soluciona(vetor).imprimirVetor();

	}

}
