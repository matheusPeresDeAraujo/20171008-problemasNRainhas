package resolveVetor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import alteraPosicao.AlteraPosicaoVetorFilhos1Posicao;
import model.Vetor;

public class ResolveVetorCollisionReduction implements ResolveVetor{

	public static int instancia = 0;
	private Map<String, Vetor> tentativas = new HashMap<>();
	private List<Vetor> folhasAbertas = new LinkedList();
	DecimalFormat saidaInteiro = new DecimalFormat("###,###");
	DecimalFormat saidaPercentual = new DecimalFormat("0.00");
	
	private static ResolveVetorCollisionReduction instance = new ResolveVetorCollisionReduction();
	
	private ResolveVetorCollisionReduction() {};
	
	public static ResolveVetorCollisionReduction getInstance() {
		return instance;
	}
	
	
	@Override
	public Vetor soluciona(Vetor vetor) {
//		
		folhasAbertas.add(vetor);
		
		while(vetor.getColisoes() > 0) {
			
			instancia = 0;
			this.solucionar();
			vetor = new Vetor(folhasAbertas.get(0).getVetor());
			
		}
		return vetor;
	}
	
	private List<Vetor> solucionar(){
		
		instancia++;
		
		//Imprimo o vetor
		System.out.println("Possibilidades utilizadas: " + tentativas.size());
		System.out.println("Folhas abertas: " + folhasAbertas.size());
		//System.out.println("Total de possibilidades igual a: " + saidaInteiro.format(Math.pow(folhasAbertas.get(0).getBase(), folhasAbertas.get(0).getBase())) + " Verificado: " + saidaPercentual.format(((folhasAbertas.size()+tentativas.size())/Math.pow(folhasAbertas.get(0).getBase(), folhasAbertas.get(0).getBase()))) + "\n\n");
		folhasAbertas.get(0).imprimirVetor();
				
		
		//É a resposta
		if(folhasAbertas.get(0).getColisoes() == 0 || instancia > 1000) {
			return folhasAbertas;
		}
		
		//Gero filhos caso não tenha a resposta.
		List<Vetor> filhosLista = AlteraPosicaoVetorFilhos1Posicao.getInstance().altera(folhasAbertas.get(0));
		
		tentativas.put(folhasAbertas.get(0).getSenha(),folhasAbertas.get(0));
		folhasAbertas.remove(0);
		
		// Junto as duas lista para omitir as repetições
		Map<String, Vetor> merge = new HashMap<>();
		
		for(Vetor vetor : folhasAbertas) {
			merge.put(vetor.getSenha(), vetor);
		}
		for(Vetor vetor : filhosLista) {
			merge.put(vetor.getSenha(), vetor);
		}
		
		//remove do map os que já foram utilizados
		for(String usados : tentativas.keySet()) {
			if(merge.containsKey(usados)) {
				merge.remove(usados);
			}
		}
		
		folhasAbertas.clear();
		filhosLista.clear();
		
		folhasAbertas.addAll(merge.values());
		Collections.sort(folhasAbertas);
		
		//Tiro os execeços
		// Quando 20.000 - 	resolve em 68 tentativas
		// Quando 15.000 - 	resolve em 50 tentativas
		// Quando 10.000 - 	resolve em 50 tentativas
		// Quando 8.000	-	resolve em 50 tentativas
		// Quando 5.000 	resolve em 68 tentativas
		// Quando 1.000 	resolve em 100 tentativas
		// Quando 100 		resolve em  100 tentativas
		
		folhasAbertas = folhasAbertas.subList(0, folhasAbertas.size()/4);
		
		return solucionar();
	}
	
}
