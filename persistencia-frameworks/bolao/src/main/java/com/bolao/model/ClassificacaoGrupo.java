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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="CLASSIFICACAOGRUPO")
@NamedQueries({ 
	@NamedQuery(name = "ClassificacaoGrupo.findAll", query = "SELECT c FROM ClassificacaoGrupo c ORDER BY c.id"),
	@NamedQuery(name = "ClassificacaoGrupo.findAllOk", query = "SELECT c FROM ClassificacaoGrupo c WHERE c.flResultadoOk = 1 ORDER BY c.grupo"),
	@NamedQuery(name = "ClassificacaoGrupo.findById", query = "SELECT c FROM ClassificacaoGrupo c WHERE c.id = :id"),
	@NamedQuery(name = "ClassificacaoGrupo.findMaxId", query = "SELECT MAX(c.id) FROM ClassificacaoGrupo c"),
	@NamedQuery(name = "ClassificacaoGrupo.findByGrupo", query = "SELECT cg FROM ClassificacaoGrupo cg WHERE cg.grupo.id = :idGrupo")
})												
		
public class ClassificacaoGrupo extends BaseModel<Long> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IDCLASSIFICACAOGRUPO")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name = "IDGRUPO")	
	private Grupo grupo;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "POSICAO1")	
	private Time posicao1;
	
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name = "POSICAO2")	
	@Fetch(FetchMode.JOIN)
	private Time posicao2;
	

	@Column(name="FLRESULTADOOK")
	private boolean flResultadoOk;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public boolean isFlResultadoOk() {
		return flResultadoOk;
	}

	public void setFlResultadoOk(boolean flResultadoOk) {
		this.flResultadoOk = flResultadoOk;
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
