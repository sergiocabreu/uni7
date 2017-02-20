package com.sergiocabreu.aulaum;

public class Pincel {

	int tamanho;
	String forma;
	String cor;

	public Pincel(){
		this(12, "cilindrico", "preto");
	}
	public Pincel(int tamanho, String forma, String cor) {
		this.tamanho = tamanho;
		this.forma = forma;
		this.cor = cor;
	}

	public void riscar(String texto){
		System.out.println("Riscando: " + texto + " com a cor " + cor);
	}
	
	public String obterCor(){
		return cor;
	}
}