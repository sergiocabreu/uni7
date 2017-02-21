package br.edu.uni7setembro.jbehave;

public class Divisor {

	public double dividir(int numerador, int denominador) {
		if(denominador == 0) {
			throw new ArithmeticException("Não pode dividir por zero.");
		}
		return numerador/denominador;
	}
}
