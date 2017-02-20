package com.sergiocabreu.trabalhofinal.questao3;

public class IntegerSetImpl implements IntegerSet {

	private Integer[] array = new Integer[100];
	
	
	public IntegerSetImpl() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
	}
	
	
	@Override
	public void add(Integer n) {

		if(!contains(n)){
			array[proximaPosicaoLivre()] = n;
			ordenaArray();
		}
	}
	
	private void ordenaArray() {
	
		int aux = 0;
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array.length; j++){
				if(array[j] != null && array[j+1] != null && array[j] > array[j + 1]){
					aux = array[j];
					array[j] = array[j+1];
					array[j+1] = aux;
				}
			}
		}
		
	}


	private int proximaPosicaoLivre(){
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null )
				return i;
		}
		
		return 0;
	}
	

	@Override
	public void remove(Integer n) {
		
		if (contains(n)){
			
			for (int i = posicaoParaExclusao(n); i < array.length-1; i++)
				array[i] = array[i+1]; 
		}
			
	}
		
	private int posicaoParaExclusao(Integer n){
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null && array[i].intValue() == n.intValue() )
				return i;
		}
		
		return 0;
	}

	@Override
	public IntegerSet union(IntegerSet set) {
		
		IntegerSet setAux = new IntegerSetImpl();
		setAux = set.diff(this);
		
		for (int i = 0; i < proximaPosicaoLivre(); i++) {
			setAux.add(array[i]);
		}
		
		return setAux;
	}	

	@Override
	public IntegerSet intersection(IntegerSet set) {
		
		IntegerSet setAux = new IntegerSetImpl();
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null && set.contains(array[i])){
				setAux.add(array[i]);
			}
		}
		
		return setAux;
	}

	@Override
	public IntegerSet diff(IntegerSet set) {
		IntegerSet setAux = new IntegerSetImpl();
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null && !set.contains(array[i])){
				setAux.add(array[i]);
			}
		}
		
		return setAux;
	}
	
	@Override
	public String toString() {
		
		if (array.length == 0 ) return "[]";
		String s = "[ ";
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null)
				s += array[i]+", ";
		}
		
		String a = s.substring(0, s.length()- 2)+" ]"; 
		return a;

	}


	@Override
	public boolean contains(Integer n) {
		boolean contains = false;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null && array[i].intValue() == n.intValue() )
				contains = true;
		}
		return contains;
	}	
}
