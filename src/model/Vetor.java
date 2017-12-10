package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

	public void setColisoes() {
		this.colisoes = this.interceptar();
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
		System.out.println("\nColisoes: (" + this.colisoes + ")");
		System.out.println("\n\n");
	}
	
	public void arquivarVetor() throws IOException {
		File arquivo = new File("/home/matheus/Área de Trabalho/txt.txt");
		
		
		FileWriter fw = new FileWriter(arquivo, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(int k = 0; k < this.base; k++) {
			bw.write(this.vetor[k] + "\t");
		}
		bw.write("\nColisoes: (" + this.colisoes + ")");
		bw.write("\n\n");
		
		bw.close();
	}
	
	public String getSenha() {
		String senha = "";
		for(int i = 0; i < this.base; i ++) {
			senha = senha + this.getVetor()[i];
		}
		return senha;
	}
	
	public int vetorValido(int coluna) {
		for(int i = 0; i<= coluna; i++) {
			for(int j = 0; j<= coluna; j++) {
				if(i != j) { 
					if((vetor[i] == vetor[j]) || (vetor[i]+(j-i) == vetor[j]) || (vetor[i]-(j-i) == vetor[j]))
						return 0;
				}
			}
		}
		return 1;
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
