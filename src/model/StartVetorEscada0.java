package model;

public class StartVetorEscada0 implements StartVetor{

	@Override
	public Vetor inicializa(Vetor vetor) {
		
		for(int k = 0; k < vetor.getBase(); k++) {
			if(k < vetor.getBase()/2) {
				vetor.setVetor(k, k*2);
			}else {
				vetor.setVetor(k, (1+ (k - vetor.getBase()/2) * 2));
			}
		}
		
		return vetor;
	}

}
