package com.sergiocabreu.lambidas;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaSort {
	
	public static void main(String[] args) {
	
		String[] testString = {"fa7","ufc","fanor","fic","uece"};
		
		//System.out.println(Arrays.toString(testString));
				
		//Java 7
		Arrays.sort(testString, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		
		System.out.println(Arrays.toString(testString));
		
		//Lampda java 8
		Arrays.sort(testString, (String o1, String o2) -> {
			return o1.length() - o2.length();
			}
		);
		
		//Forma mais compacta da lambda
		Arrays.sort(testString, (s1, s2) -> s2.length() - s1.length());
		
		System.out.println(Arrays.toString(testString));
	}
}
