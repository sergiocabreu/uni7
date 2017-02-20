package com.sergiocabreu.trabalhofinal.questao1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bingo {

	private Set<Integer> numerosSorteados;
	private List<Cartela> cartelas;
	private List<Cartela> cartelasCompletas;
	private Globo globo;
	
	public Bingo(){
		numerosSorteados = new HashSet<Integer>();
		cartelas = new ArrayList<Cartela>();
		cartelasCompletas = new ArrayList<Cartela>();
		globo = new Globo();
	}
	
	public void gerarCartelas() {

		for (int i = 1; i <= 1000000; i++) {
			cartelas.add(new Cartela(i, gerarNumerosCartela()));
		}
	}
	
	
	/**
	 *Realiza o sorteio e verifica se alguém fez bingo! 
	 */
	public void realizarSorteio(){
		
		Integer numeroSorteado = sortearNumero();
		
		marcaEConferirCartelas(numeroSorteado);
	}
	

	/**
	 * Marca o número na cartela e atualiza a lista de cartelas completas.
	 * @param numeroSorteado
	 */
	private void marcaEConferirCartelas(Integer numeroSorteado) {
		
		for (Cartela cartela : cartelas) {
			cartela.marcarNumero(numeroSorteado);
			
			if (cartela.cartelaCompleta())
				cartelasCompletas.add(cartela);
		}
	}

	public boolean temCartelasCompletas(){
		boolean temCartelaCompleta = false;
		
		if (cartelasCompletas.size() > 0 ) 
			temCartelaCompleta = true;
		
		return temCartelaCompleta;
	}
	
	
	
	/**
	 * Gera os números da cartela
	 * @return
	 */
	private Set<Integer> gerarNumerosCartela() {
		
		Set<Integer> numeros = new HashSet<Integer>();
		
		while(numeros.size() != EnumBingo.TOTAL_NUMEROS_CARTELA.getCodigo()){
			
			numeros.add(new Integer(globo.gerarNumero()));
		}
		
		return numeros;
	}

	
	/**
	 * Sorteia um número
	 * @return
	 */
	private Integer sortearNumero() {
		
		Integer numeroSorteado = globo.gerarNumero();
		
		while(numerosSorteados.contains(numeroSorteado)){
			numeroSorteado = globo.gerarNumero();
		};
		
		numerosSorteados.add(numeroSorteado);
		
		return numeroSorteado;
	}
	


	public Set<Integer> getNumerosSorteados() {
		return numerosSorteados;
	}

	public List<Cartela> getCartelasCompletas() {
		return cartelasCompletas;
	}
}
