package com.bolao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="TIME")
@NamedQueries({ 
	@NamedQuery(name = "Time.findAll", query = "SELECT t FROM Time t ORDER BY t.nome"),
	@NamedQuery(name = "Time.findById", query = "SELECT t FROM Time t WHERE t.id = :id"),
	@NamedQuery(name = "Time.findByNome", query = "SELECT t FROM Time t WHERE UPPER(t.nome) LIKE :nome ORDER BY t.id"),
	@NamedQuery(name = "Time.findMaxId", query = "SELECT MAX(t.id) FROM Time t"),
	@NamedQuery(name = "Time.findByGrupo", query = "SELECT t FROM Time t WHERE t.grupo = :grupo"),
	@NamedQuery(name = "Time.countByNome", query = "SELECT count(t) FROM Time t WHERE UPPER( t.nome ) LIKE :nome "),
	@NamedQuery(name = "Time.countByGrupo", query = "SELECT count(t) FROM Time t WHERE t.grupo = :grupo AND UPPER (t.nome) LIKE :nome"),
	@NamedQuery(name = "Time.findNomeByGrupo", query = "SELECT t FROM Time t Where t.grupo =:grupo AND UPPER (t.nome) = :nome"),
	@NamedQuery(name = "Time.searchByNome", query = "SELECT t FROM Time t WHERE UPPER(t.nome) LIKE :nome ORDER BY t.nome")
})												
		
public class Time extends BaseModel<Long> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IDTIME")
	private Long id;
	
	@ManyToOne 
	@JoinColumn(name = "IDGRUPO")	
	private Grupo grupo;
		
	@Column(name="NOME")
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Time))
			return false;
		Time other = (Time) obj;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
