package com.sergiocabreu.aulatres;

import java.time.LocalDate;
import java.util.Date;

public class RentalTeste {
	
	public static void main(String[] args) {
		
		Rental r = new BookRental();
		
		LocalDate emissaoRG = LocalDate.of(2016, 05, 31);

		
		System.out.println(r.getTotalFee());
		
		
	}

}
