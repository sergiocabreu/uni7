package com.sergiocabreu.aulaum;

import java.util.Scanner;

public class LendoSeuNome {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite seu nome: ");
		String nome = sc.next();
		System.out.println("Ol�, " + nome);
		sc.close();
	}
}
