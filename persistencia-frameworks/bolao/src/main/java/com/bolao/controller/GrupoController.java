package com.bolao.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.bolao.business.GrupoBusiness;
import com.bolao.business.GrupoBusinessImpl;
import com.bolao.exception.GrupoJaCadastradoException;
import com.bolao.exception.NomeObrigatorioException;
import com.bolao.model.Grupo;
import com.bolao.util.FacesUtil;

@ManagedBean
@RequestScoped
public class GrupoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private GrupoBusiness grupoBusiness;

	private Grupo grupo;

	public GrupoController() {
		grupo = new Grupo();
		grupoBusiness = new GrupoBusinessImpl();
	}

	public void salvar() {

		try {
			grupoBusiness.salvar(grupo);
			limpar();

			FacesUtil.addInfoMessage("Operação realizada com sucesso.");
		} catch (GrupoJaCadastradoException | NomeObrigatorioException e) {
			FacesUtil.addWarnMessageWithouDetail(e.getMessage());
		} catch (Exception e) {
			FacesUtil.addErroMessage(e.getMessage());
		}
	}
	
	public void excluir() {
		
		try {
			grupoBusiness.excluir(getGrupo());

			FacesUtil.addInfoMessage("Operação realizada com sucesso.");
		} catch (Exception e) {
			FacesUtil.addErroMessage(e.getMessage());
		}
	}	

	public String limpar() {
		setGrupo(new Grupo());
		return "cadastro-grupo";
	}

	public List<Grupo> getGrupos() {
		return grupoBusiness.buscar();
	}

	/**
	 * Gets and Sets
	 */
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}