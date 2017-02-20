package com.bolao.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BOLAO")
@NamedQueries({
	@NamedQuery(name = "Bolao.findAll", query = "SELECT b FROM Bolao b ORDER BY b.campeonato"),
	@NamedQuery(name = "Bolao.findById", query = "SELECT b FROM Bolao b WHERE b.id = :id"),
	@NamedQuery(name = "Bolao.findByNome", query = "SELECT b FROM Bolao b WHERE UPPER(b.campeonato) LIKE :nome ORDER BY b.id"),
})

public class Bolao extends BaseModel<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDBOLAO")
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bolao", cascade = CascadeType.ALL)
	private List<Jogos> jogos;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bolao", cascade = CascadeType.ALL)
	private List<Cartela> cartelas;

	@Column(name = "CAMPEONATO")
	private String campeonato;

	@Column(name = "ANO")
	private String ano;

	@Column(name = "OBSERVACAO")
	private String observacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Jogos> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogos> jogos) {
		this.jogos = jogos;
	}

	public List<Cartela> getCartelas() {
		return cartelas;
	}

	public void setCartelas(List<Cartela> cartelas) {
		this.cartelas = cartelas;
	}

	public String getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(String campeonato) {
		this.campeonato = campeonato;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
