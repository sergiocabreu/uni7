package com.sergiocabreu.trabalhofinal.questao2;

import java.util.Collection;
import java.util.Iterator;

public interface ShoppingCart {

	/**
	* Adiciona um novo Item no carrinho de compras
	*/
	public Item addItem(Product product, Integer amount);
	/**
	* Retorna uma coleção dos produtos contidos no carrinho, ordenados pelo
	nome (asc).
	*/
	public Collection<Product> getProductsOrderByNameAsc();
	/**
	* Retorna um iterator contendo todos os itens do carrinho.
	*/
	public Iterator<Item> getItems();
	/**
	* Remove um item da lista, pelo id do produto associado.
	*/
	public void removeItemByProductId(Integer productId);
	/**
	* Retorna o preco total dos itens contidos no carrinho.
	*/
	public Double getTotal();
}
