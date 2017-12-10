package areaDeTeste;

import model.Matriz;
import model.Vetor;
import resolveVetor.*;
import startVetor.StartVetor;
import startVetor.StartVetorEscada0;
import startVetor.StartVetorEscada1;
import startVetor.StartVetorRandom;

public class Teste06 {

	public static void main(String[] args) {
		/*	Teste
		 * 	Mostrar resultado atráves do Reduction
		 * 
		 * */
		Vetor vetor = new Vetor(100);
//		vetor = new StartVetorRandom().inicializa(vetor);
		System.out.println("Solução do problema: ");
		
		Matriz matriz = new Matriz(ResolveVetorCollisionReduction.getInstance().soluciona(vetor));
		matriz.imprimirMatriz();
	}

}
