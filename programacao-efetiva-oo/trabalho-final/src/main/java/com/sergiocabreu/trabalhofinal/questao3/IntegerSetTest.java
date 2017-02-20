package com.sergiocabreu.trabalhofinal.questao3;

public class IntegerSetTest {

	public static void main(String[] args) {
		
		IntegerSet set1 = new IntegerSetImpl();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		System.out.println("set 01: " + set1);
		
		IntegerSet set2 = new IntegerSetImpl();
		set2.add(3);
		set2.add(4);
		set2.add(5);
		set2.add(6);
		set2.add(7);
		System.out.println("set 02: " + set2);
		
		System.out.println("Remove valor 2 do set01;");		
		set1.remove(2);
		System.out.println("set 01: " + set1);
		System.out.println("set 02: " + set2);
		
		IntegerSet setUnion = set1.union(set2);
		
		System.out.println("Union " + setUnion);
		
		IntegerSet setIntersection = set1.intersection(set2);
		System.out.println("Intersection: " + setIntersection);
		
		IntegerSet setDiff = set1.diff(set2);
		System.out.println("Dif: " + setDiff);
	}
}
