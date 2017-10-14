package resolveVetor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import alteraPosicao.AlteraPosicaoVetorFilhos1Posicao;
import model.Vetor;

public class ResolveVetorProfundidadePlanejada implements ResolveVetor{

	private static int instancia = 0;
	private static long iteracao = 0;
	private int coluna = 0;
	private int linha = 0;
	DecimalFormat saidaInteiro = new DecimalFormat("###,###");
	DecimalFormat saidaPercentual = new DecimalFormat("0.00");
	
	private static ResolveVetorProfundidadePlanejada instance = new ResolveVetorProfundidadePlanejada();
	
	private ResolveVetorProfundidadePlanejada() {};
	
	public static ResolveVetorProfundidadePlanejada getInstance() {
		return instance;
	}
	
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
		
		//Se a pilha não for estourar e não tenho a resposta.
		if(vetor.getColisoes() == 0 || instancia > 1000) {
			return vetor;
			
		}else { //Proxíma modificação em busca da resposta
			
			vetor.setVetor(coluna, linha);
			System.out.println("Possibilidades utilizadas: " + iteracao);
			System.out.println("Total de possibilidades igual a: " + saidaInteiro.format(Math.pow(vetor.getBase(), vetor.getBase())) + " Verificado: " + saidaPercentual.format(((iteracao*100)/Math.pow(vetor.getBase(), vetor.getBase()))) + " %\n\n");
			vetor.imprimirVetor();
			
			//Verifico se após a modificação o vetor está valido até a coluna
			if(vetor.vetorValido(coluna) == 1) {
				coluna++; //preencho proxima coluna
				linha = 0;
				return this.solucionar(vetor);
				
			} else {
				
				linha ++; // Tento fazer a inserção em outra linha
				
				// Se já tentei todas as linhas na coluna preciso mudar a coluna
				if(linha > vetor.getBase()-1) {
					this.mudaColuna(vetor);
					return this.solucionar(vetor);
				}
				
				return this.solucionar(vetor);
				
			}
		}
	}
	
	public int mudaColuna(Vetor vetor) {
		
		if(linha > vetor.getBase()-1) {
			
			vetor.setVetor(coluna, 0); // Zero o valor da coluna
			
			coluna --;
			
			if(coluna == -1) {
				return 0;
			}
			
			linha = vetor.getVetor()[coluna];
			linha ++;
			
			return mudaColuna(vetor);
		}
		
		return 1;
	}
}
