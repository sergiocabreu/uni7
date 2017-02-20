package br.com.trabalhocursoweb.business;

/**
 * Classe de excecao disparada pela camada de negocio.
 * @author Fabio Barros
 */
public class CepInvalidoException extends Exception {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -1071896537277884578L;

	public CepInvalidoException(String mensagem) {
		super(mensagem);
	}
	
	
	public CepInvalidoException() {
		super("CEP invalido!");
	}
}
