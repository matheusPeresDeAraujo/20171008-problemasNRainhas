package model;

public class Matriz {
	
	private int base;
	private int[][] matriz;
	
	public Matriz(Vetor vetor) {
		this.base = vetor.getBase();
		this.matriz = new int[this.base][this.base];
		
		for(int i = 0; i < this.base; i++) {
			int x = vetor.getVetor()[i];
			matriz[i][x] = 1;
		}
		
	}
	
	public void imprimirMatriz() {
		for(int k = 0; k < this.base; k++) {
			for(int q = 0; q < this.base; q++) {
				System.out.print(this.matriz[k][q] + "\t");
			}
			System.out.println("\n\n");
		}
	}
}
