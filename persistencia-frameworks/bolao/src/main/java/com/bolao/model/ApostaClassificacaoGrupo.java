package com.bolao.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "APOSTACLASSIFICACAOGRUPO")
/*@NamedQueries({
		@NamedQuery(name = "ApostaClassificacaoGrupo.findMaxId", query = "SELECT MAX(a.id) FROM ApostaClassificacaoGrupo a"),
		@NamedQuery(name = "ApostaClassificacaoGrupo.findById", query = "SELECT a FROM ApostaClassificacaoGrupo a WHERE a.id = :id"),
		@NamedQuery(name = "ApostaClassificacaoGrupo.findByGrupo", query = "SELECT a FROM ApostaClassificacaoGrupo a WHERE a.grupo.id =:idGrupo order by a.participante.nome"),
		@NamedQuery(name = "ApostaClassificacaoGrupo.countByGrupo", query = "SELECT a FROM ApostaClassificacaoGrupo a WHERE a.grupo.id =:idGrupo order by a.participante.nome"),
		@NamedQuery(name = "ApostaClassificacaoGrupo.findByIdParticipante", query = "SELECT a FROM ApostaClassificacaoGrupo a WHERE a.participante.id =:idParticipante  ORDER BY a.grupo.id"),
		@NamedQuery(name = "ApostaClassificacaoGrupo.findByUsername", query = "SELECT a FROM ApostaClassificacaoGrupo a JOIN FETCH a.participante p WHERE p.username =:username ORDER BY a.id"),
		@NamedQuery(name = "ApostaClassificacaoGrupo.countByApostasPendentes", query = "SELECT a FROM ApostaClassificacaoGrupo a WHERE a.participante.id =:idParticipante order by a.participante.nome"),
		@NamedQuery(name = "ApostaClassificacaoGrupo.apostaByGrupoParticipante", query = "SELECT a FROM ApostaClassificacaoGrupo a WHERE a.participante.id =:idParticipante AND  a.grupo.id =:idGrupo"),

		@NamedQuery(name = "ApostaClassificacaoGrupo.findAll", query = "SELECT a FROM ApostaClassificacaoGrupo a ORDER BY a.id") })*/

public class ApostaClassificacaoGrupo extends Aposta implements Serializable {

	private static final long serialVersionUID = 1L;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDGRUPO")
	private Grupo grupo;

	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "POSICAO1")
	private Time posicao1;

	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "POSICAO2")
	private Time posicao2;

	@JoinColumn(name = "PONTOS")
	private BigDecimal pontos;

	public BigDecimal getPontos() {
		return pontos;
	}

	public void setPontos(BigDecimal pontos) {
		this.pontos = pontos;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Time getPosicao1() {
		return posicao1;
	}

	public void setPosicao1(Time posicao1) {
		this.posicao1 = posicao1;
	}

	public Time getPosicao2() {
		return posicao2;
	}

	public void setPosicao2(Time posicao2) {
		this.posicao2 = posicao2;
	}

}
