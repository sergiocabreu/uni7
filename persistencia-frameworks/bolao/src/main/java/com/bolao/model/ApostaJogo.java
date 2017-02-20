package com.bolao.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "APOSTAJOGO")
@PrimaryKeyJoinColumn(name="IDAPOSTA")
/*@NamedQueries({
		@NamedQuery(name = "ApostaJogo.findMaxId", query = "SELECT MAX(a.id) FROM ApostaJogo a"),
		@NamedQuery(name = "ApostaJogo.findById", query = "SELECT a FROM ApostaJogo a WHERE a.id = :id"),
		//@NamedQuery(name = "ApostaJogo.countByParticipanteAndGolNull", query = "SELECT count(a) FROM ApostaJogo a WHERE a.participante.id =:idParticipante AND (a.gol1 IS NULL OR a.gol2 IS NULL"),
		@NamedQuery(name = "ApostaJogo.findByUsername", query = "SELECT a FROM ApostaJogo a JOIN FETCH a.participante p WHERE p.username =:username ORDER BY a.id"),
		@NamedQuery(name = "ApostaJogo.apostaByJogoParticipante", query = "SELECT a FROM ApostaJogo a WHERE a.participante.id =:idParticipante AND  a.jogos.id =:idJogo"),
		@NamedQuery(name = "ApostaJogo.findByJogo", query = "SELECT a FROM ApostaJogo a WHERE a.jogos.id =:idJogo order by a.participante.nome"),
		@NamedQuery(name = "ApostaJogo.findByIdParticipante", query = "SELECT a FROM ApostaJogo a JOIN FETCH a.participante p WHERE p.id =:idParticipante ORDER BY a.id"),
		@NamedQuery(name = "ApostaJogo.findAll", query = "SELECT a FROM ApostaJogo a ORDER BY a.id")})*/

public class ApostaJogo extends Aposta implements Serializable {

	private static final long serialVersionUID = 1L;

/*	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDAPOSTAJOGO")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDAPOSTA")
	private Aposta aposta;*/

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDJOGO")
	private Jogos jogos;

	@Column(name = "GOL1")
	private Integer gol1;

	@Column(name = "GOL2")
	private Integer gol2;

	@JoinColumn(name = "PONTOS")
	private BigDecimal pontos;

	@Transient
	private String gol1t;

	@Transient
	private String gol2t;

	/*public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}*/

	public Integer getGol1() {
		return gol1;
	}

	public void setGol1(Integer gol1) {
		this.gol1 = gol1;
	}

	public Integer getGol2() {
		return gol2;
	}

	public void setGol2(Integer gol2) {
		this.gol2 = gol2;
	}

	public Jogos getJogos() {
		return jogos;
	}

	public void setJogos(Jogos jogos) {
		this.jogos = jogos;
	}

	public BigDecimal getPontos() {
		return pontos;
	}

	public void setPontos(BigDecimal pontos) {
		this.pontos = pontos;
	}

	public String getGol1t() {
		return gol1t;
	}

	public void setGol1t(String gol1t) {
		this.gol1t = gol1t;
	}

	public String getGol2t() {
		return gol2t;
	}

	public void setGol2t(String gol2t) {
		this.gol2t = gol2t;
	}

	/*public Aposta getAposta() {
		return aposta;
	}

	public void setAposta(Aposta aposta) {
		this.aposta = aposta;
	}*/

}
