package com.sergiocabreu.trabalhofinal.questao1;

public class TesteBingo {

	public static void main(String[] args) {

		Bingo bingo = new Bingo();
		
		bingo.gerarCartelas();//Gerar Cartelas
		
		//Realiza o sorteio
		while(!bingo.temCartelasCompletas()){		
			bingo.realizarSorteio();
		}
		
		System.out.println("Fim do jogo!!!");
		
		System.out.println("Nº bolas Chamadas: "+bingo.getNumerosSorteados().size());
		
		System.out.println("Bolas Chamadas: ");
		System.out.println(bingo.getNumerosSorteados());
		
		System.out.println("Quantidade de bingos: " + bingo.getCartelasCompletas().size());
		
		for (Cartela cartela : bingo.getCartelasCompletas()) {
			
			System.out.println("Nº cartela: " +cartela.getIdCartela());
			System.out.println("Números da Cartela" + cartela.getNumerosDaCartela());
		}
		
		System.out.println();
		
	}
		
}
