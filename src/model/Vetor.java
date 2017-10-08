package model;

import java.util.ArrayList;
import java.util.Random;

public class Vetor implements Comparable<Vetor>{
	
	private int base;
	private int[] vetor;
	private int colisoes;
	
	public Vetor(int base) {
		this.base = base;
		this.vetor = new int[base];
		this.colisoes = this.interceptar();
	}
	
	public Vetor(int[] vetor) {
		this.base = vetor.length;
		this.vetor = new int[base];
		
		for(int i = 0; i < this.base; i ++) {
			this.vetor[i] = vetor[i];
		}
		this.colisoes = this.interceptar();
	}
	
	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int[] getVetor() {
		return vetor;
	}

	public int getColisoes() {
		return colisoes;
	}

	public void setColisoes(int colisoes) {
		this.colisoes = colisoes;
	}

	// Informa coluna e valor para alterar o vetor
	public void setVetor(int coluna, int valor) {
		this.vetor[coluna] = valor;
		this.colisoes = this.interceptar();
	}

	public void imprimirVetor() {
		for(int k = 0; k < this.base; k++) {
			System.out.print(this.vetor[k] + "\t");
		}
		System.err.println(this.colisoes);
		System.out.println("\n\n");
	}
	
	// Verifica se as posições das rainhas se interceptam
	private int interceptar() {
		int cont = 0;
		for(int i = 0; i<this.base; i++) {
			for(int j = 0; j<this.base; j++) {
				if(i != j) { 
					if((vetor[i] == vetor[j]) || (vetor[i]+(j-i) == vetor[j]) || (vetor[i]-(j-i) == vetor[j]))
						cont += 1;
				}
			}
		}
		return cont;
	}

	@Override
	public int compareTo(Vetor outroVetor) {
		if(outroVetor.getColisoes() < this.colisoes) {
			return +1;
		}
		if(outroVetor.getColisoes() > this.colisoes) {
			return -1;
		}	
		return 0;
	}
}
