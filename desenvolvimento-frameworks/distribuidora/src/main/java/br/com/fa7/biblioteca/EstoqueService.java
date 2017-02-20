package br.com.fa7.biblioteca;

import java.util.Random;

import org.springframework.stereotype.Service;

import br.com.fa7.biblioteca.model.Pedido;
import br.com.fa7.biblioteca.model.SolicitacaoLivro;

@Service
public class EstoqueService {

	private Random gerador;
	
	public EstoqueService () {
		gerador = new Random();
	}
	public Pedido processarPedido(Pedido pedido) {
		
		for (SolicitacaoLivro solicitacao : pedido.getSolicitacoes()) {
			int quantidade = 0;
			
			if (solicitacao.getQuantidade() > 0)
				quantidade = quantidadeDisponivel(solicitacao.getQuantidade());
				
			solicitacao.setQuantidade(quantidade);
		}
		
		return pedido;
	}
	
	public int quantidadeDisponivel(int quantidade) {
		return gerador.nextInt(quantidade);
	}
	
	
}