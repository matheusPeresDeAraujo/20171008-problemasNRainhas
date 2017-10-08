package model;

public class ResolveVetorCollisionReduction implements ResolveVetor{

	@Override
	public Vetor soluciona(Vetor vetor) {
		
		if(vetor.interceptar() == 0)
			return vetor;
		
		
		
		return null;
	}
	
}
