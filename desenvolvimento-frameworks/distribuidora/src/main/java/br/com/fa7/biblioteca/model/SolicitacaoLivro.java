package br.com.fa7.biblioteca.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class SolicitacaoLivro implements Serializable{

	private static final long serialVersionUID = 1L;

	private String titulo;
	private String autor;
	private Integer quantidade;
	private Pedido pedido;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}