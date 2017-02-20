package com.sergiocabreu.aulatres.interfaces;

public class GM implements FabricaDeCarros {

	@Override
	public Carro getCarroPopular() {
		return new Celta();
	}

	@Override
	public Carro getCarroEsportivo() {
		return new Camaro();
	}

}
