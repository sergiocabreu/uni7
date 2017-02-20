package com.sergiocabreu.trabalhofinal.questao1;

import java.util.Random;

public class Globo {
	/**
	 * Gera um número aleatório entre 1 e 99.
	 * @return return um Integer
	 */
	public Integer gerarNumero() {
		Random random = new Random();
		Integer numero = random.nextInt(99);
		return numero + 1;
	}
}
