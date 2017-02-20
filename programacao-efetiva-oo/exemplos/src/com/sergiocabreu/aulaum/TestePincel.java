package com.sergiocabreu.aulaum;

public class TestePincel {

	public static void main(String[] args) {
		
		Pincel p1 = new Pincel();
		p1.cor = "zul";
		p1.forma = "cilindro";
		p1.tamanho = 10;
		p1.riscar("POO");
		
		Pincel p2 = new Pincel();
		p2.cor = "vermelho";
		p2.riscar("JAVA");
		
		System.out.println(p2.obterCor());
		
	}
}
