package com.sergiocabreu.aulatres.interfaces;

public class Ford implements FabricaDeCarros {

	public Carro getCarroPopular() {
		return new Ka();
	}

	public Carro getCarroEsportivo() {
		return new Mustang();
	}

}
