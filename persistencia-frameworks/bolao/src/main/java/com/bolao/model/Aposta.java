package com.bolao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "APOSTA")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
		@NamedQuery(name = "Aposta.findMaxId", query = "SELECT MAX(a.id) FROM Aposta a"),
		@NamedQuery(name = "Aposta.findById", query = "SELECT a FROM Aposta a WHERE a.id = :id"),
		@NamedQuery(name = "Aposta.findAll", query = "SELECT a FROM Aposta a ORDER BY a.id")})

public class Aposta extends BaseModel<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDAPOSTA")
	private Long id;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDCATELA")
	private Cartela cartela;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Cartela getCartela() {
		return cartela;
	}

	public void setCartela(Cartela cartela) {
		this.cartela = cartela;
	}	
	
	

}
