package com.sergiocabreu.trabalhofinal.questao2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ShoppingCartMap implements ShoppingCart {

	private Map<Item, Product> shoppingCart;
	
	public ShoppingCartMap() {
		shoppingCart = new HashMap<Item, Product>();
	}
	
	public Item addItem(Product product, Integer amount) {
		Item item = new Item(product, amount);
		
		shoppingCart.put(item, product);
		
		return item;
	}

	public Collection<Product> getProductsOrderByNameAsc() {
		
		List<Product> productList = new ArrayList<Product>();
		
		for (Map.Entry<Item, Product> item: shoppingCart.entrySet()) {
			productList.add(item.getValue());
		}
				
		productList.sort( (p1, p2) -> p1.getName().compareTo(p2.getName()) );
		
		return productList;
	}

	public Iterator<Item> getItems() {
		
		return shoppingCart.keySet().iterator();
	}

	public void removeItemByProductId(Integer productId) {
		for(Iterator<Item> iter = getItems(); iter.hasNext();) {
			Item item = iter.next();
	        if (item.getProduct().getId() == productId)
	        	iter.remove();
	    }
	}

	public Double getTotal() {
		double total = 0.0;
		
		  for(Iterator<Item> iter = getItems(); iter.hasNext();) {
	            Item item = iter.next();
	            total+= item.getProduct().getPrice();
	       
	      }
		
		return total;
	}

}
