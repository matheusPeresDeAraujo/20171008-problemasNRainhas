package resolveVetor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Vetor;

public class ResolveVetorProfundidadePlanejada implements ResolveVetor{

	public static int instancia = 0;
	public static long iteracao = 0 ;
	private int coluna = 0;
	private int linha = 0;
	
	DecimalFormat saidaInteiro = new DecimalFormat("###,###");
	DecimalFormat saidaPercentual = new DecimalFormat("###.00000000000000000000");
	
	@Override
	public Vetor soluciona(Vetor vetor) {
		
		while(vetor.getColisoes() > 0) {
			instancia = 0;
			vetor = new Vetor(this.solucionar(vetor).getVetor());
			
		}
		
		return vetor;
	}
	
	public Vetor solucionar(Vetor vetor){
		iteracao++;
		instancia++;
		
		System.out.println("Possibilidades utilizadas: " + iteracao);
		//System.out.println("Total de possibilidades igual a: " + saidaInteiro.format(Math.pow(vetor.getBase(), vetor.getBase())) + " Verificado: " + saidaPercentual.format(((iteracao*100)/Math.pow(vetor.getBase(), vetor.getBase()))) + " %\n\n");
		
		
		if(vetor.getColisoes() == 0 || instancia > 1000) {
			return vetor;
		}

		vetor.setVetor(coluna, linha);
		vetor.imprimirVetor();
		
		//Verifico se até a o coluna esta de boas
		if(vetor.vetorValido(coluna) == 1) {
			coluna++; //preencho proxima coluna
			linha = 0;
			return this.solucionar(vetor);
		}
		
		
		linha ++;
		
		
		// Não ta de boas e chegou na ultima linha
		if(linha > vetor.getBase()-1) {
			this.verificaMaximos(vetor);
			return this.solucionar(vetor);
		}
		
		return this.solucionar(vetor);
		
	}
	

	
	public int verificaMaximos(Vetor vetor) {
		
		if(linha > vetor.getBase()-1 || coluna > vetor.getBase()-1) {
			
			vetor.setVetor(coluna, 0);
			
			coluna --;
			
			if(coluna == -1) {
				return 1;
			}
			
			linha = vetor.getVetor()[coluna];
			linha ++;
			
			return verificaMaximos(vetor);
		}
		
		return 1;
	}
	
	
}
