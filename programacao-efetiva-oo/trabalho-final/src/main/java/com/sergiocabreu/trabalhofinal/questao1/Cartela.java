package com.sergiocabreu.trabalhofinal.questao1;

import java.util.HashSet;
import java.util.Set;

public class Cartela {

	private Integer idCartela;
	private Set<Integer> numerosDaCartela;
	private Set<Integer> numerosMarcados;	
	
	public Cartela(Integer idCartela, Set<Integer> numerosDaCartela) {
		this.idCartela = idCartela;
		this.numerosDaCartela = numerosDaCartela;
		this.numerosMarcados = new HashSet<Integer>();
	}

	/**
	 * Verica se a cartela fez bingo, ou seja, completou os 20 números.
	 * @return true se fez bingo. false, caso contário
	 */
	public boolean cartelaCompleta(){
		boolean cartelaCompleta = false;
		
		if (numerosMarcados.size() == EnumBingo.TOTAL_NUMEROS_CARTELA.getCodigo())
			cartelaCompleta = true;
		
		return cartelaCompleta;
	}
	
	/**
	 * Marca o número na cartela.
	 * @param numeroSorteado
	 */
	public void marcarNumero(Integer numeroSorteado){
		
		if (numerosDaCartela.contains(numeroSorteado)){
			numerosMarcados.add(numeroSorteado);
		}			
	}

	public Integer getIdCartela() {
		return idCartela;
	}

	public void setIdCartela(Integer idCartela) {
		this.idCartela = idCartela;
	}

	public Set<Integer> getNumerosDaCartela() {
		return numerosDaCartela;
	}

	public void setNumerosDaCartela(Set<Integer> numerosDaCartela) {
		this.numerosDaCartela = numerosDaCartela;
	}

	public Set<Integer> getNumerosMarcados() {
		return numerosMarcados;
	}

	public void setNumerosMarcados(Set<Integer> numerosMarcados) {
		this.numerosMarcados = numerosMarcados;
	}
}
