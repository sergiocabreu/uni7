package br.com.trabalhocursoweb.tipo;

public enum JogadorEnum {

	O('O'),X('X');
	
	public char jogador;
	
	private JogadorEnum(char jogador) {
		this.jogador = jogador;
	}
}
