package com.sergiocabreu.trabalhofinal.questao2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ShoppingCartList implements ShoppingCart {

	private List<Item> shoppingCart;
	
	public ShoppingCartList() {
		shoppingCart = new ArrayList<Item>();
	}
	
	public Item addItem(Product product, Integer amount) {
		
		Item item = new Item(product, amount);
		
		shoppingCart.add(item);
		
		return item;
	}

	public Collection<Product> getProductsOrderByNameAsc() {
		List<Product> productList = new ArrayList<Product>();
		
		for (Item item : shoppingCart) {
			productList.add(item.getProduct());
		}
				
		productList.sort( (p1, p2) -> p1.getName().compareTo(p2.getName()) );
		
		return productList;
	}

	public Iterator<Item> getItems() {
		return shoppingCart.iterator();
	}

	public void removeItemByProductId(Integer productId) {
		
		for (int i = 0; i < shoppingCart.size(); i++) {
			if(shoppingCart.get(i).getProduct().getId() == productId)
				shoppingCart.remove(i);
		}

	}

	public Double getTotal() {
		double total = 0.0;
		
		for (Item item : shoppingCart) {
			total+= (item.getProduct().getPrice() * item.getAmount());
		}
		
		return total;
	}

}
