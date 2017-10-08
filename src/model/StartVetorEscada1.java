package model;

public class StartVetorEscada1 implements StartVetor{

	@Override
	public Vetor inicializa(Vetor vetor) {
		
		for(int k = 0; k < vetor.getBase(); k++) {
			if(k < vetor.getBase()/2) {
				vetor.setVetor(k, 1+k*2);
			}else {
				vetor.setVetor(k, (k - vetor.getBase()/2) * 2);
			}
		}
		
		return vetor;
	}

}
