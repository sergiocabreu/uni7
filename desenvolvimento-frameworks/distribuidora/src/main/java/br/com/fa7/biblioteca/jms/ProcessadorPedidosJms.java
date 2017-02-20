package br.com.fa7.biblioteca.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import br.com.fa7.biblioteca.EstoqueService;
import br.com.fa7.biblioteca.model.Pedido;

@Component
public class ProcessadorPedidosJms {
	
	@Autowired
	EstoqueService estoque;
	
	@JmsListener(destination = "distribuidora-queue")
	@SendTo("biblioteca-queue")
	public Pedido process(Pedido pedido) {
		
		Pedido pedidoDeRetorno = null;
		
		if (pedido != null) 
			pedidoDeRetorno = estoque.processarPedido(pedido);
		
		return pedidoDeRetorno;
	}
	
}
