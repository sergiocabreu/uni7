package br.com.trabalhocursoweb.model;

public class Cep {

	private String regiao;
	private String sufixo;
	
	
	public Cep() {
		
	}
	
	public Cep(String regiao, String sufixo) {
		this.regiao = regiao;
		this.sufixo = sufixo;
	}

	/*public String toString(){
		return getRegiao() +"-"+getSufixo();
	}*/
	
	
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public String getSufixo() {
		return sufixo;
	}
	public void setSufixo(String sufixo) {
		this.sufixo = sufixo;
	}
}
