package com.sergiocabreu.auladois;

public class Data {

	private int dia;
	private int mes;
	private int ano;
	
	public Data(){
		
	}
	
	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public void incremetarAno(){
		this.ano++;
	}
	
	public void incremetarAno(int incremento){
		ano+=incremento;
	}
	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String toString(){
		return dia +"/"+mes+"/"+ano;
	}
}
