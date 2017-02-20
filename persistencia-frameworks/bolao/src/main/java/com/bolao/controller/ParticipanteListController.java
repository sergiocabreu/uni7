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

import com.bolao.business.ParticipanteBusiness;
import com.bolao.business.ParticipanteBusinessImpl;
import com.bolao.exception.BolaoRuntimeException;
import com.bolao.model.Participante;
import com.bolao.util.BolaoUtil;
import com.bolao.util.FacesUtil;

@SuppressWarnings("serial")
@ManagedBean
@RequestScoped
public class ParticipanteListController implements Serializable {

	private ParticipanteBusiness participanteBusiness;

	private BolaoUtil bolaoUtil;

	private String nome = new String();
	private int ativo = -1;// traz a lista toda

	private Participante participante = new Participante();
	private List<Participante> participanteList = new ArrayList<Participante>();

	private LazyDataModel<Participante> model;

	// util
	// verifica se j� foi feita alguma consulta
	private boolean consultar = false;
	
	@PostConstruct
	public void init() {
		participanteBusiness = new ParticipanteBusinessImpl();
		bolaoUtil = new BolaoUtil();
	}

	public String ParticipanteByNome() {

		try {	
			consultar = true;
			participanteList = participanteBusiness.searchByNome(nome);

		} catch (Exception e) {
			participanteList = new ArrayList<Participante>();
			FacesUtil.addErroMessage(e.getMessage());
		}

		return "participanteList?faces-redirect=true";
	}

	public void consultar() {

		consultar = true;
		model = new LazyDataModel<Participante>() {

			@Override
			public List<Participante> load(int inicio, int maxPerPage, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				participanteList = participanteBusiness.findByNome(nome, ativo, inicio, maxPerPage);
				setPageSize(maxPerPage);
				setRowCount(participanteBusiness.count(nome, ativo));
				return participanteList;
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
		System.out.println();
		//return "participanteList";
	}

	public String resetarSenha() {

		try {
			String password = new String("Tce12345");
			try {
				participante.setPassword(bolaoUtil.criptografarSenha(password.toUpperCase()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			participanteBusiness.salvar(participante);
			participante = new Participante();

			FacesUtil.addInfoMessage("Opera��o realizada com sucesso.");

		} catch (BolaoRuntimeException e) {
			FacesUtil.addErroMessage(e.getMessage());

		} catch (Exception e) {
			FacesUtil.addErroMessage("Ocorreu algum erro ao salvar. Opera��o cancelada.");

		}
		return "participanteList";
	}

	public String limpaTela() {
		ativo = -1;
		participante = new Participante();
		nome = new String();
		participanteList = new ArrayList<Participante>();
		this.model = new LazyDataModel<Participante>() {

			private static final long serialVersionUID = 1L;

			@Override
			public List<Participante> load(int inicio, int maxPerPage, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				return participanteList;
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
		consultar = false;

		return "participanteList?faces-redirect=true";
	}

	/**
	 * Getters e Setters
	 */

	public Participante getParticipante() {
		return participante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setParticipante(Participante Participante) {
		this.participante = Participante;
	}

	public List<Participante> getParticipanteList() {
		return participanteList;
	}

	public void setParticipanteList(List<Participante> participanteList) {
		this.participanteList = participanteList;
	}

	public boolean isConsultar() {
		return consultar;
	}

	public void setConsultar(boolean consultar) {
		this.consultar = consultar;
	}

	public LazyDataModel<Participante> getModel() {
		return model;
	}

	public void setModel(LazyDataModel<Participante> model) {
		this.model = model;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

}
