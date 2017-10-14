package areaDeTeste;

import model.*;
import resolveVetor.*;
import startVetor.*;

public class Teste02 {

	public static void main(String[] args) {
		
		/*	Teste
		 * 	Formas de inicializar o vetor
		 * 
		 * */
		Vetor vetor = new Vetor(4);
		
		StartVetor startRandom = new StartVetorRandom();
		startRandom.inicializa(vetor);
		System.out.println("\nVetor inicializado utilizando a função random:");
		vetor.imprimirVetor();
		
		StartVetor startEscada1 = new StartVetorEscada1();
		startEscada1.inicializa(vetor);
		System.out.println("\nVetor inicializado utilizando a função escada1:");
		vetor.imprimirVetor();
		
		StartVetor startEscada0 = new StartVetorEscada0();
		startEscada0.inicializa(vetor);
		System.out.println("\nVetor inicializado utilizando a função escada0:");
		vetor.imprimirVetor();
		
	}

}
