package testes;

import java.util.List;

import model.Vetor;
import resolveVetor.ResolveVetor;
import resolveVetor.ResolveVetorProfundidadePlanejada;

public class Main {

	public static void main(String[] args) {
		
		/*	Teste:
		 * 	Criar vetor e transformar em uma matriz para visualização.
		 * 
		 * */

		Vetor vetor = new Vetor(22);
//		vetor.setVetor(0, 1);
//		vetor.setVetor(1, 3);
//		vetor.setVetor(2, 0);
//		vetor.setVetor(3, 2);
//		
//		System.out.println("VETOR:");
//		vetor.imprimirVetor();
//		
//		Matriz matriz = new Matriz(vetor);
//		System.out.println("MATRIZ");
//		matriz.imprimirMatriz();
//		
//		
//		/*	Teste
//		 * 	Verificar se o vetor se intercepta
//		 * 
//		 * */
//		
//		if(vetor.getColisoes() > 1) {
//			System.out.println("O vetor gerado se intercepta! \nNo total de " + vetor.getColisoes() + " colisões");
//		}else {
//			System.out.println("O vetor gerado não se intercepta!");
//		}
//		
//		/*	Teste
//		 * 	Formas de inicializar o vetor
//		 * 
//		 * */
//		
//		StartVetor startRandom = new StartVetorRandom();
//		startRandom.inicializa(vetor);
//		System.out.println("\n\nVetor inicializado utilizando a função random:");
//		vetor.imprimirVetor();
		
//		StartVetor startEscada1 = new StartVetorEscada1();
//		startEscada1.inicializa(vetor);
//		System.out.println("\n\nVetor inicializado utilizando a função escada1:");
//		vetor.imprimirVetor();
		
//		StartVetor startEscada0 = new StartVetorEscada0();
//		startEscada0.inicializa(vetor);
//		System.out.println("\n\nVetor inicializado utilizando a função escada0:");
//		vetor.imprimirVetor();
//		
//		/*	Teste
//		 * 	Imprimir variações do vetor inicial
//		 * */
//		
//		AlteraPosicaoVetorFilhos filhos = new AlteraPosicaoVetorFilhos1Posicao();
//		List<Vetor> filhosLista = filhos.altera(vetor);
//		System.out.println("Filhos do vetor inicial:");
//		for(Vetor filho : filhosLista){
//			filho.imprimirVetor();
//		}
		
		
		/*	Teste
		 * 	Tentar resolver
		 * 
		 * */
		
		ResolveVetor resolve = new ResolveVetorProfundidadePlanejada();
		System.out.println("Solução do problema: ");
		
		resolve.soluciona(vetor).imprimirVetor();
		
	
		
	}

}
