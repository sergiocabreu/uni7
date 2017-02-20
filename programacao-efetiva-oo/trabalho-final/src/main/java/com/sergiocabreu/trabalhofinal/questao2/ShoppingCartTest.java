package com.sergiocabreu.trabalhofinal.questao2;

import java.util.Iterator;

public class ShoppingCartTest {

	public static void main(String[] args) {
		
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("Produto 1");
		p1.setPrice(10.00);
		
		Product p2 = new Product();
		p2.setId(2);
		p2.setName("Produto 2");
		p2.setPrice(20.00);

		Product p3 = new Product();
		p3.setId(3);
		p3.setName("Produto 3");
		p3.setPrice(30.00);
		
		//ShoppingCart carList = new ShoppingCartList();
		//ShoppingCart carList = new ShoppingCartSet();
		ShoppingCart carList = new ShoppingCartMap();
		carList.addItem(p1, 1);
		carList.addItem(p2, 1);
		carList.addItem(p3, 1);

		//Todos os Itens.
		imprime(carList);
		
		System.out.println("Produto ordenado por nome");
		imprimeProduto(carList);
		
		
		System.out.println();
		System.out.println("Removendo");
		remove(carList, 2);
		imprimeProduto(carList);
	}
	

	/**
	 * Testa o iterator, o getTotal
	 * @param shoppingCart
	 */
	public static void imprime(ShoppingCart shoppingCart){

		Iterator<Item> iterator = shoppingCart.getItems();
		
		
		while(iterator.hasNext()){
			Item item = (Item) iterator.next();
			
			System.out.println("Quantidade " + item.getAmount());
			System.out.println("Produtos --------------------------");
			imprimeProduto(item.getProduct());
			System.out.println();
		}
		
		System.out.println("Preço total: " + shoppingCart.getTotal());
		System.out.println();
	}
	
	public static void imprimeProduto(ShoppingCart shoppingCart){
		for (Product p : shoppingCart.getProductsOrderByNameAsc()) {
			imprimeProduto(p);
		}
	}
	
	public static void imprimeProduto(Product produto){
		System.out.println("Id: " + produto.getId());
		System.out.println("Name: "+ produto.getName());
		System.out.println("Price: "+produto.getPrice());
	}
	
	public static void remove(ShoppingCart shoppingCart, Integer id) {
		shoppingCart.removeItemByProductId(id);
	}
}
