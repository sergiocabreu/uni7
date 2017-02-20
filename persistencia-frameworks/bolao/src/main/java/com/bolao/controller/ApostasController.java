package com.bolao.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.PersistenceException;

import org.hibernate.JDBCException;

import com.bolao.business.ApostasBusiness;
import com.bolao.business.ApostasBusinessImpl;
import com.bolao.business.AuthenticationBusiness;
import com.bolao.business.JogosBusiness;
import com.bolao.business.JogosBusinessImpl;
import com.bolao.business.ParticipanteBusiness;
import com.bolao.business.ParticipanteBusinessImpl;
import com.bolao.exception.BolaoRuntimeException;
import com.bolao.model.ApostaJogo;
import com.bolao.model.Jogos;
import com.bolao.model.Participante;
import com.bolao.util.FacesUtil;

@ManagedBean
@RequestScoped
public class ApostasController implements Serializable {

	private static final long serialVersionUID = 1L;

	private JogosBusiness jogosBusiness;

	private ApostasBusiness apostasBusiness;

	private ParticipanteBusiness participanteBusiness;
	
	private AuthenticationBusiness authenticationBusiness;

	// entidades das telas
	private List<Jogos> jogos;
	private List<ApostaJogo> apostas;
	private String usuario; //= FacesUtil.getName();
	private Participante participante;
	private ApostaJogo aposta;
	private Long apostasGolNull;

	private boolean flagApostasIncompletas = false;

	@PostConstruct
	public void init() {

		jogosBusiness = new JogosBusinessImpl();
		apostasBusiness = new ApostasBusinessImpl();
		participanteBusiness = new ParticipanteBusinessImpl();
		authenticationBusiness = new AuthenticationBusiness();
		usuario =  authenticationBusiness.getUsuarioLogado().getNome();
		participante = participanteBusiness.findByUsername(usuario);

		apostas = apostasBusiness.findByUsername(usuario);
		for (ApostaJogo a : apostas) {
			if (a.getGol1() != null)
				a.setGol1t(a.getGol1().toString());
			if (a.getGol2() != null)
				a.setGol2t(a.getGol2().toString());
		}

		if (apostas.size() == 0) {
			apostas.clear();

			jogos = jogosBusiness.findAll();

			for (Jogos j : jogos) {
				aposta = new ApostaJogo();
				//aposta.setParticipante(participante);
				aposta.setJogos(j);
				if (aposta.getGol1() != null)
					aposta.setGol1t(aposta.getGol1().toString());
				if (aposta.getGol2() != null)
					aposta.setGol2t(aposta.getGol2().toString());
				apostas.add(aposta);
			}
			//participante.setApostas(apostas);

			participanteBusiness.salvar(participante);
		}

		apostasGolNull = apostasBusiness.countByParticipanteAndGolNull(participante);
		System.out.println(apostasGolNull);

		FacesUtil.addWarnMessageWithouDetail("Existem " + apostasGolNull.toString() + " apostas incompletas!");
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

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public ApostaJogo getAposta() {
		return aposta;
	}

	public void setAposta(ApostaJogo aposta) {
		this.aposta = aposta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getApostasGolNull() {
		return apostasGolNull;
	}

	public void setApostasGolNull(Long apostasGolNull) {
		this.apostasGolNull = apostasGolNull;
	}

	public boolean isFlagApostasIncompletas() {
		return flagApostasIncompletas;
	}

	public void setFlagApostasIncompletas(boolean flagApostasIncompletas) {
		this.flagApostasIncompletas = flagApostasIncompletas;
	}

	// public void onCellEdit(CellEditEvent event) {
	public void onCellEdit() {

		ApostaJogo apostaAtualizar = FacesUtil.getApplication().evaluateExpressionGet(FacesUtil.getFacesContext(),
				"#{item}", ApostaJogo.class);

		if (apostaAtualizar.getGol1t() == null || apostaAtualizar.getGol1t().equals("")) {
			apostaAtualizar.setGol1(null);
		} else {
			apostaAtualizar.setGol1(Integer.parseInt(apostaAtualizar.getGol1t()));
		}

		if (apostaAtualizar.getGol2t() == null || apostaAtualizar.getGol2t().equals("")) {
			apostaAtualizar.setGol2(null);
		} else {
			apostaAtualizar.setGol2(Integer.parseInt(apostaAtualizar.getGol2t()));
		}

		try {
			apostasBusiness.salvar(apostaAtualizar);

			apostasGolNull = apostasBusiness.countByParticipanteAndGolNull(participante);
			FacesUtil.addWarnMessageWithouDetail("Existem " + apostasGolNull.toString() + " apostas incompletas!");

			FacesUtil.addInfoMessageWithouDetail("Opera��o realizada com sucesso. Resultado da aposta foi gravado.");

			if (apostaAtualizar.getGol1() != null && apostaAtualizar.getGol2() != null) {

				FacesUtil.addInfoDetail(apostaAtualizar.getJogos().getGrupo().getNome() + " | "
						+ new SimpleDateFormat("dd/MM/yyyy").format(apostaAtualizar.getJogos().getDtJogo()) + " | "
						+ apostaAtualizar.getJogos().getTime1().getNome() + " " + apostaAtualizar.getGol1() + " x "
						+ +apostaAtualizar.getGol2() + " " + apostaAtualizar.getJogos().getTime2().getNome() + ".");

			} else if (apostaAtualizar.getGol1() != null) {

				FacesUtil.addInfoDetail(apostaAtualizar.getJogos().getGrupo().getNome() + " | "
						+ new SimpleDateFormat("dd/MM/yyyy").format(apostaAtualizar.getJogos().getDtJogo()) + " | "
						+ apostaAtualizar.getJogos().getTime1().getNome() + " " + apostaAtualizar.getGol1()
						+ ". Preencha o campo da sele��o " + apostaAtualizar.getJogos().getTime2().getNome());

			} else if (apostaAtualizar.getGol2() != null) {

				FacesUtil.addInfoDetail(apostaAtualizar.getJogos().getGrupo().getNome() + " | "
						+ new SimpleDateFormat("dd/MM/yyyy").format(apostaAtualizar.getJogos().getDtJogo()) + " | "
						+ apostaAtualizar.getJogos().getTime2().getNome() + " " + apostaAtualizar.getGol2()
						+ ". Preencha o campo da sele��o " + apostaAtualizar.getJogos().getTime1().getNome());
			} else {
				FacesUtil.addInfoDetail(
						"Preencha os campos das sele��es " + apostaAtualizar.getJogos().getTime1().getNome() + " e "
								+ apostaAtualizar.getJogos().getTime2().getNome());
			}

		} catch (BolaoRuntimeException e) {
			FacesUtil.addErroMessage("Ocorreu o seguinte erro: " + e.getMessage());

		} catch (PersistenceException e) {
			FacesUtil.addErroMessage("Ocorreu algum erro ao salvar. Opera��o cancelada.");

		} catch (JDBCException e) {
			FacesUtil.addErroMessage("Ocorreu algum erro ao salvar. Opera��o cancelada.");

		} catch (Exception e) {
			FacesUtil.addErroMessage("Ocorreu algum erro ao salvar. Opera��o cancelada.");

		}

	}

	public void apostasIncompletas() {
		setFlagApostasIncompletas(true);
	}

}
