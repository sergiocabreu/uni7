package br.com.fa7.biblioteca.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<SolicitacaoLivro> solicitacoes;

	public List<SolicitacaoLivro> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<SolicitacaoLivro> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}
}