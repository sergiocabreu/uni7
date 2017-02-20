package com.sergiocabreu.aulatres;

import java.util.Date;

public abstract class Rental {

	protected String titulo;
	protected Date rentDate;
	protected Date dueDate;
	protected double rentalFee;
	
	public  boolean isOverdue(){
		Date now = new Date();
		return dueDate.before(now);
	}
	
	double getTotalFee() {
		return isOverdue() ? getTax() * rentalFee : rentalFee;
	}

	protected abstract double getTax();	
	
}
