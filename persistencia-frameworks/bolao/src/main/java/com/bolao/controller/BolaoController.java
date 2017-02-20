package com.bolao.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.bolao.business.BolaoBusiness;
import com.bolao.business.BolaoBusinessImpl;
import com.bolao.exception.BolaoRuntimeException;
import com.bolao.model.Bolao;
import com.bolao.util.FacesUtil;

@ManagedBean
@RequestScoped
public class BolaoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private BolaoBusiness bolaoBusiness;

	private Bolao bolao;

	public BolaoController() {
		bolao = new Bolao();
		bolaoBusiness = new BolaoBusinessImpl();
	}

	public void salvar() {

		try {
			bolaoBusiness.salvar(bolao);
			limpar();

			FacesUtil.addInfoMessage("Operação realizada com sucesso.");
		} catch (BolaoRuntimeException e) {
			FacesUtil.addWarnMessageWithouDetail(e.getMessage());
		} catch (Exception e) {
			FacesUtil.addErroMessage(e.getMessage());
		}
	}
	
	public void excluir() {
		
		try {
			bolaoBusiness.excluir(getBolao());

			FacesUtil.addInfoMessage("Operação realizada com sucesso.");
		} catch (Exception e) {
			FacesUtil.addErroMessage(e.getMessage());
		}
	}	

	public String limpar() {
		setBolao(new Bolao());
		return "cadastro-bolao";
	}

	public List<Bolao> getBolaos() {
		return bolaoBusiness.buscar();
	}

	/**
	 * Gets and Sets
	 */
	public Bolao getBolao() {
		return bolao;
	}

	public void setBolao(Bolao bolao) {
		this.bolao = bolao;
	}

}