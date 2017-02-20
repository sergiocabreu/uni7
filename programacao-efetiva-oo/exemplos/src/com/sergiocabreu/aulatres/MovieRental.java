package com.sergiocabreu.aulatres;

public class MovieRental extends Rental {

	private int classification;

	public int getClassification() {
		return classification;
	}

	public void setClassification(int classification) {
		this.classification = classification;
	}

	protected double getTax() {
		
		return 1.3;
	}

}
