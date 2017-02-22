package br.edu.uni7setembro.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class DividirSteps {

	private Divisor divisor;
	private double divisao;

	private String mensagem;

	@Given("um divisor foi instanciado")
	public void dadoDivisorFoiInstanciado() {
		divisor = new Divisor();
	}

	@When("o numerador $numerador eh dividido pelo denominador $denominador")
	public void quandoNumeradorDivididoPeloDenominador(int numerador, int denominador) {
		try {
			divisao = divisor.dividir(numerador, denominador);
		} catch (ArithmeticException e) {
			mensagem = e.getMessage();
		}
	}

	@Then("o resultado eh $divisao")
	public void entaoResultadoE(double divisao) {
		Assert.assertEquals(this.divisao, divisao, 0.0001);
	}

	@Then("mostra a mensagem de erro: $mensagem")
	public void entaoResultadoMensagemErro(String mensagem) {
		Assert.assertEquals(this.mensagem, mensagem);
	}
}
