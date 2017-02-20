package com.bolao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PARTICIPANTE_BOLAO")
												
		
public class ParticipanteBolao extends BaseModel<Long> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IDPARTICIPANTE_BOLAO")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDPARTICIPANTE",nullable = false)    
	private Participante participante;
      
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDBOLAO",nullable = false)    
	private Bolao bolao;
	
	@Column(name="TOTALPONTOS")
	private Integer totalPontos;
	
	@Column(name="QTDEESCORESCHEIOS")
	private Integer qtdeEscoresCheios;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Bolao getBolao() {
		return bolao;
	}

	public void setBolao(Bolao bolao) {
		this.bolao = bolao;
	}

	public Integer getTotalPontos() {
		return totalPontos;
	}

	public void setTotalPontos(Integer totalPontos) {
		this.totalPontos = totalPontos;
	}

	public Integer getQtdeEscoresCheios() {
		return qtdeEscoresCheios;
	}

	public void setQtdeEscoresCheios(Integer qtdeEscoresCheios) {
		this.qtdeEscoresCheios = qtdeEscoresCheios;
	}

	

	
}
