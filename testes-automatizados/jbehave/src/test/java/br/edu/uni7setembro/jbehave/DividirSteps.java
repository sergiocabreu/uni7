package br.edu.uni7setembro.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class DividirSteps {

	private Divisor divisor;
	private double divisao;

	@Given("um divisor foi instanciado")
	public void dadoDivisorFoiInstanciado() {
		divisor = new Divisor();
	}
	
	@When("o numerador $numerador eh dividido pelo denominador $denominador")
	public void quandoNumeradorDivididoPeloDenominador(int numerador, int denominador) {
		divisao = divisor.dividir(numerador, denominador);
	}
	
	@Then("o resultado eh $divisao")
	public void entaoResultadoE(double divisao) {
		Assert.assertEquals(this.divisao, divisao, 0.0001);
	}
	
/*	@When("o numerador $numerador eh dividido pelo denominador $denominador")
	public void numeradorDivididoPorZero(int numerador, int denominador) {		
		divisao = divisor.dividir(numerador, denominador);
	}
	
	@Then("o resultado eh uma mensagem de erro")
	public void resultadoMensagemDeErro() {
		//Assert.assertThat(divisl, Exception.class);
	}*/
}
