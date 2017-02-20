package br.com.trabalhojaxrs.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.trabalhojaxrs.model.xml.DateAdapter;

public class Veiculo extends BaseModel implements Serializable {

	private static final long serialVersionUID = -3064306490724801147L;

	private String placa;
	
	private String proprietario;
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date emplacamento;
	
	private Double ipva;

	public Veiculo() {
		super();
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public Date getEmplacamento() {
		return emplacamento;
	}

	public void setEmplacamento(Date emplacamento) {
		this.emplacamento = emplacamento;
	}

	public Double getIpva() {
		return ipva;
	}

	public void setIpva(Double ipva) {
		this.ipva = ipva;
	}
}