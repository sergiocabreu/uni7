package com.bolao.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.bolao.business.JogosBusiness;
import com.bolao.business.JogosBusinessImpl;
import com.bolao.dao.TimeDAO;
import com.bolao.dao.TimeDAOImpl;
import com.bolao.model.Grupo;
import com.bolao.model.Jogos;
import com.bolao.model.Time;
import com.bolao.util.FacesUtil;

@ManagedBean
@RequestScoped
public class JogosController implements Serializable {

	private static final long serialVersionUID = 1L;

	private JogosBusiness jogosBusiness;
	private Jogos jogo;

	public JogosController() {
		jogo = new Jogos();
		jogosBusiness = new JogosBusinessImpl();
	}

	public void salvar() {
		
		try {
			jogosBusiness.salvar(getJogo());
			limpar();
			FacesUtil.addInfoMessage("Operação realizada com sucesso.");
		} catch (Exception e) {
			FacesUtil.addErroMessage(e.getMessage());
		}
	}

	public void excluir() {
		
		try {
			jogosBusiness.excluir(getJogo());

			FacesUtil.addInfoMessage("Operação realizada com sucesso.");
		} catch (Exception e) {
			FacesUtil.addErroMessage(e.getMessage());
		}
	}

	public String limpar() {
		setJogo(new Jogos());
		return "cadastro-jogos";
	}

	public void atualizarTimes() {
		//List<Time> times = jogosBusiness.times(getJogo().getGrupo());
		//setTimes(times);
	}
	
	public List<Grupo> getGrupos() {
		return jogosBusiness.grupos();
	}
	
	public List<Jogos> getJogos() {
		return jogosBusiness.findAll();
	}
	
	public List<Time> getTimes() throws Exception {
		TimeDAO t = new TimeDAOImpl();
		return t.buscar();
	}

	/**
	 * Gets and Sets
	 */
	
	public Jogos getJogo() {
		return jogo;
	}

	public void setJogo(Jogos jogo) {
		this.jogo = jogo;
	}
}