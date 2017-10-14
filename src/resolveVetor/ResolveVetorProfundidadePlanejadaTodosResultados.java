package resolveVetor;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Vetor;

public class ResolveVetorProfundidadePlanejadaTodosResultados implements ResolveVetor{
	
	private boolean terminated = false;
	private static int instancia = 0;
	private static long iteracao = 0;
	private int coluna = 0;
	private int linha = 0;
	DecimalFormat saidaInteiro = new DecimalFormat("###,###");
	DecimalFormat saidaPercentual = new DecimalFormat("0.00");
	
	private static ResolveVetorProfundidadePlanejadaTodosResultados instance = new ResolveVetorProfundidadePlanejadaTodosResultados();
	
	private ResolveVetorProfundidadePlanejadaTodosResultados() {};
	
	public static ResolveVetorProfundidadePlanejadaTodosResultados getInstance() {
		return instance;
	}
	
	@Override
	public Vetor soluciona(Vetor vetor) {
		
		while(terminated == false) {
			
			instancia = 0;
			vetor = new Vetor(this.solucionar(vetor).getVetor());
			
		}
		
		return vetor;
	}
	
	public Vetor solucionar(Vetor vetor){
		
		iteracao++;
		instancia++;
		
		//Se a pilha não for estourar e não tenho a resposta.
		if(instancia > 1000) {
			return vetor;
			
		}else { //Proxíma modificação em busca da resposta
			
			vetor.setVetor(coluna, linha);
			System.out.println("Possibilidades utilizadas: " + iteracao);
			System.out.println("Total de possibilidades igual a: " + saidaInteiro.format(Math.pow(vetor.getBase(), vetor.getBase())) + " Verificado: " + saidaPercentual.format(((iteracao*100)/Math.pow(vetor.getBase(), vetor.getBase()))) + " %\n\n");
			vetor.imprimirVetor();
			
			// Valido arquivar
			if(vetor.getColisoes() == 0) {
				try {
					vetor.arquivarVetor();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			//Verifico se após a modificação o vetor está valido até a coluna
			if(vetor.vetorValido(coluna) == 1 && coluna < vetor.getBase()-1) {
				coluna++; //preencho proxima coluna
				linha = 0;
				return this.solucionar(vetor);
				
			} else {
				
				linha ++; // Tento fazer a inserção em outra linha
				
				// Se já tentei todas as linhas na coluna preciso mudar a coluna
				if(linha > vetor.getBase()-1) {
					this.mudaColuna(vetor);
					if(terminated == true) {
						return vetor;
					}
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
				terminated = true;
				return 0;
			}
			
			linha = vetor.getVetor()[coluna];
			linha ++;
			
			return mudaColuna(vetor);
		}
		
		return 1;
	}
}
