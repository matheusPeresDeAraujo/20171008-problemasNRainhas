package areaDeTeste;

import resolveVetor.*;
import model.*;

import java.util.List;

import alteraPosicao.*;

public class Teste03 {

	public static void main(String[] args) {
		/*	Teste
		 * 	Imprimir variações do vetor inicial
		 * */
		Vetor vetor = new Vetor(8);
		vetor.setVetor(0, 0);
		vetor.setVetor(1, 4);
		vetor.setVetor(2, 7);
		vetor.setVetor(3, 5);
		vetor.setVetor(4, 2);
		vetor.setVetor(5, 6);
		vetor.setVetor(6, 1);
		vetor.setVetor(7, 3);
		
		List<Vetor> filhosLista = AlteraPosicaoVetorFilhos1Posicao.getInstance().altera(vetor);
		System.out.println("Filhos do vetor inicial:");
		
		for(Vetor filho : filhosLista){
			filho.imprimirVetor();
		}
		
	}

}
