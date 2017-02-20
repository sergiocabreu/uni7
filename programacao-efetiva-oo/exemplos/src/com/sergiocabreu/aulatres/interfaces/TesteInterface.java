package com.sergiocabreu.aulatres.interfaces;

public class TesteInterface {

	public static void main(String[] args) {
		
		FabricaDeCarros gm = new GM();
		Carro carroEsportivo = gm.getCarroEsportivo(); 
		System.out.println(carroEsportivo.getDescricao());
		
		Carro carroPopular = gm.getCarroPopular();
		System.out.println(carroPopular.getDescricao());
		
		FabricaDeCarros ford = new Ford();
		System.out.println(ford.getCarroEsportivo().getDescricao());
		System.out.println(ford.getCarroPopular().getDescricao());
	}
}
