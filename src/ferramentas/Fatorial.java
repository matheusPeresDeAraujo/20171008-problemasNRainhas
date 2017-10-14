package ferramentas;

import resolveVetor.ResolveVetorProfundidadePlanejada;

public class Fatorial {

	private int num;
	
	private static Fatorial instance = new Fatorial();
	
	private Fatorial() {};
	
	public static Fatorial getInstance() {
		return instance;
	}
	
	public static long fatorial(long num) {
		if (num <=1 )  return 1;
		else  return num * fatorial(num - 1);
	}

}
