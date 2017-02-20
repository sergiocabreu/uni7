package com.sergiocabreu.lambidas;

import java.util.Arrays;

public class ExercicioLambdasBasico {

	
	
	public static void main(String[] args) {
		String[] testString = {"cachorro","gato","baleia","papagaio","galinha","burro","coelho","abelha","elefante"};
		
		//a. tamanho (menor para a maior)
		Arrays.sort(testString, (s1, s2) -> s1.length() - s2.length());
		System.out.println("[a] "+Arrays.toString(testString));
		
		//b. tamanho reverso (maior para menor)
		Arrays.sort(testString, (s1, s2) -> s2.length() - s1.length());
		System.out.println("[b] "+Arrays.toString(testString));
		
		//c. alfabeticamente pelo primeiro caracter
		Arrays.sort(testString, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
		System.out.println("[c] "+Arrays.toString(testString));
		
		//d. Strings que contem “e” primerio, tudo mais depois;
		Arrays.sort(testString, (s1, s2) -> {
			int resultado = 0;
			
			if (s1.contains("e")) 
				resultado = -1;
			else  
				resultado = 1;
			
			return resultado;	
		});
		System.out.println("[d] "+Arrays.toString(testString));
		
		//e. Refaça o item anterior, mas use um método static auxiliary para que seu lambda se pareça com isso:
		//Arrays.sort(words, (s1,s2) -> Utils.yourMethod(s1,s2))
		
		Arrays.sort(testString, (s1, s2) -> ExercicioLambdasBasico.testaLetraE(s1, s2));
		System.out.println("[e] "+Arrays.toString(testString));
		
	}

	private static int testaLetraE(String s1, String s2) {
		int resultado = 0;
		
		if (s1.contains("e")) 
			resultado = -1;
		else  
			resultado = 1;
		
		return resultado;
	}
}
