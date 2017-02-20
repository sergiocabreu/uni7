package com.sergiocabreu.aulatres;

public class BookRental extends Rental {

	private String author;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	protected double getTax() {
		return 1.2;
	}
	
	

}
