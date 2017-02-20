package com.bolao.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Transient;

@Entity
@Table(name="JOGOS")
@NamedQueries({ 
	@NamedQuery(name = "Jogos.findAll", query = "SELECT j FROM Jogos j ORDER BY j.dtJogo"),
	@NamedQuery(name = "Jogos.findAllOK", query = "SELECT j FROM Jogos j WHERE j.flResultadoOk =1 ORDER BY j.dtJogo"),
	@NamedQuery(name = "Jogos.findById", query = "SELECT j FROM Jogos j WHERE j.id = :id"),
	@NamedQuery(name = "Jogos.findMaxId", query = "SELECT MAX(j.id) FROM Jogos j"),
})												
		
public class Jogos extends BaseModel<Long> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IDJOGOS")
	private Long id;
	
	@ManyToOne 
	@JoinColumn(name = "IDGRUPO")	
	private Grupo grupo;
	
	@ManyToOne 
	@JoinColumn(name = "IDBOLAO")	
	private Bolao bolao;
	
	@ManyToOne 
	@JoinColumn(name = "TIME1")	
	private Time time1;
	
	@Column(name="GOL1")
	private Integer gol1;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name = "TIME2")	
	private Time time2;
	
	@Column(name="GOL2")
	private Integer gol2;
	
	@Column(name="FLRESULTADOOK")
	private boolean flResultadoOk;
			
	@Column(name="DTJOGO")
	private Date dtJogo;	
	
	@Transient
	private String gol1t;

	@Transient
	private String gol2t;
	
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

	public Time getTime1() {
		return time1;
	}

	public void setTime1(Time time1) {
		this.time1 = time1;
	}

	public Integer getGol1() {
		return gol1;
	}

	public void setGol1(Integer gol1) {
		this.gol1 = gol1;
	}

	public Time getTime2() {
		return time2;
	}

	public void setTime2(Time time2) {
		this.time2 = time2;
	}

	public Integer getGol2() {
		return gol2;
	}

	public void setGol2(Integer gol2) {
		this.gol2 = gol2;
	}

	public boolean isFlResultadoOk() {
		return flResultadoOk;
	}

	public void setFlResultadoOk(boolean flResultadoOk) {
		this.flResultadoOk = flResultadoOk;
	}

	public Date getDtJogo() {
		return dtJogo;
	}

	public void setDtJogo(Date dtJogo) {
		this.dtJogo = dtJogo;
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

	public Bolao getBolao() {
		return bolao;
	}

	public void setBolao(Bolao bolao) {
		this.bolao = bolao;
	}
	
	

}
