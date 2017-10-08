package model;

public class StartVetorRandom implements StartVetor{

	@Override
	public Vetor inicializa(Vetor vetor) {
		
		for(int i = 0; i < vetor.getBase(); i++) {
			int random = (int)(Math.random() * vetor.getBase());
			vetor.setVetor(i, random);;
		}
		
		return vetor;
	}

}
