package com.bolao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.bolao.business.ApostasBusiness;
import com.bolao.business.ApostasBusinessImpl;
import com.bolao.business.JogosBusiness;
import com.bolao.business.JogosBusinessImpl;
import com.bolao.model.ApostaJogo;
import com.bolao.model.Jogos;

@SuppressWarnings("serial")
@ManagedBean
@RequestScoped
public class ApostasJogoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private JogosBusiness jogosBusiness;

	private ApostasBusiness apostasBusiness;

	// entidades das telas
	private Jogos jogoSelecionado;

	// listas
	private List<Jogos> jogos;
	private List<ApostaJogo> apostas;
	private LazyDataModel<ApostaJogo> model;

	@PostConstruct
	public void init() {
		jogosBusiness = new JogosBusinessImpl();
		apostasBusiness = new ApostasBusinessImpl();
		setJogos(jogosBusiness.findAll());
	}

	public void searchByBJogo() {
		model = new LazyDataModel<ApostaJogo>() {

			@Override
			public List<ApostaJogo> load(int inicio, int maxPerPage, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				apostas = apostasBusiness.findByJogo(jogoSelecionado.getId(), inicio, maxPerPage);
				setPageSize(maxPerPage);
				setRowCount(apostasBusiness.countByJogo(jogoSelecionado.getId()));
				System.out.println("tam " + apostas.size());
				return apostas;
			}

			@Override
			public void setRowIndex(int rowIndex) {
				if (rowIndex == -1 || getPageSize() == 0) {
					super.setRowIndex(-1);
				} else {
					super.setRowIndex(rowIndex % getPageSize());
				}
			}
		};

	}

	public String limpaTela() {
		jogoSelecionado = new Jogos();
		apostas = new ArrayList<ApostaJogo>();
		return "apostaJogo";
	}

	public List<Jogos> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogos> jogos) {
		this.jogos = jogos;
	}

	public List<ApostaJogo> getApostas() {
		return apostas;
	}

	public void setApostas(List<ApostaJogo> apostas) {
		this.apostas = apostas;
	}

	public Jogos getJogoSelecionado() {
		return jogoSelecionado;
	}

	public void setJogoSelecionado(Jogos jogoSelecionado) {
		this.jogoSelecionado = jogoSelecionado;
	}

	public LazyDataModel<ApostaJogo> getModel() {
		return model;
	}

	public void setModel(LazyDataModel<ApostaJogo> model) {
		this.model = model;
	}

}
