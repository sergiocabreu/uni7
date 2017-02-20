package com.sergiocabreu.auladois;

public class TestaData {

	public static void main(String[] args) {

		Data hoje = new Data(25, 05, 2016);
		int mes = hoje.getMes();
		System.out.println("Mês: " + mes);
		System.out.println(hoje.toString());
		
		System.out.println();
		
		hoje.setMes(25);
		mes = hoje.getMes();
		System.out.println("Mês: " + mes);
		System.out.println(hoje.toString());
		
		
		hoje.incremetarAno();
		System.out.println(hoje.toString());
		
		hoje.incremetarAno(10);
		System.out.println(hoje.toString());
	}

}
