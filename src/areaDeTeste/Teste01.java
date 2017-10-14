package areaDeTeste;

import java.util.List;

import model.Matriz;
import model.Vetor;
import resolveVetor.ResolveVetor;
import resolveVetor.ResolveVetorProfundidadePlanejada;

public class Teste01 {

	public static void main(String[] args) {
		
		/*	Teste:
		 * 	Criar vetor e transformar em uma matriz para visualização.
		 * 
		 * */

		Vetor vetor = new Vetor(4);
		vetor.setVetor(0, 1);
		vetor.setVetor(1, 3);
		vetor.setVetor(2, 0);
		vetor.setVetor(3, 2);
		
		System.out.println("VETOR:");
		vetor.imprimirVetor();
		
		Matriz matriz = new Matriz(vetor);
		System.out.println("MATRIZ");
		matriz.imprimirMatriz();
		
	}

}
