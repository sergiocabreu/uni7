package com.bolao.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.bolao.business.TimeBusiness;
import com.bolao.business.TimeBusinessImpl;
import com.bolao.model.Grupo;
import com.bolao.model.Time;
import com.bolao.util.FacesUtil;

@ManagedBean
@RequestScoped
public class TimeController implements Serializable {

	private static final long serialVersionUID = 1L;

	private TimeBusiness timeBusiness;

	private Time time;

	public TimeController() {
		time = new Time();
		timeBusiness = new TimeBusinessImpl();
	}

	public void salvar() {
		
		try {
			timeBusiness.salvar(getTime());
			limpar();
			FacesUtil.addInfoMessage("Operação realizada com sucesso.");
		} catch (Exception e) {
			FacesUtil.addErroMessage(e.getMessage());
		}
	}

	public void excluir() {
		
		try {
			timeBusiness.excluir(getTime());

			FacesUtil.addInfoMessage("Operação realizada com sucesso.");
		} catch (Exception e) {
			FacesUtil.addErroMessage(e.getMessage());
		}
	}

	public String limpar() {
		setTime(new Time());
		return "cadastro-time";
	}

	public List<Time> getTimes() {
		return timeBusiness.buscar();
	}
	
	public List<Grupo> getGrupos() {
		
		List<Grupo> grupos = timeBusiness.grupos();
		
		return grupos;
	}

	/**
	 * Gets and Sets
	 */
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}