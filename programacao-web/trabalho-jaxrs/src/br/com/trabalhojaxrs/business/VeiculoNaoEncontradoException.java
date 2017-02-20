package br.com.trabalhojaxrs.business;

/**
 * Classe de excecao disparada pela camada de negocio.
 */
public class VeiculoNaoEncontradoException extends Exception {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -1071896537277884578L;

	public VeiculoNaoEncontradoException() {
		super("Veículo não existe!");
	}
}
