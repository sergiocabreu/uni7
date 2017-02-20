package com.sergiocabreu.trabalhofinal.questao1;

public enum EnumBingo {
	TOTAL_NUMEROS_CARTELA(20);
	
	private Integer codigo;

	private EnumBingo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
}
