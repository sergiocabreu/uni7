package com.bolao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bolao.business.ApostaClassificacaoGrupoBusiness;
import com.bolao.business.ApostasBusiness;
import com.bolao.business.ClassificacaoGrupoBusiness;
import com.bolao.business.JogosBusiness;
import com.bolao.business.ParticipanteBusiness;
import com.bolao.business.ParticipanteBusinessImpl;
import com.bolao.exception.BolaoRuntimeException;
import com.bolao.model.ApostaJogo;
import com.bolao.model.ClassificacaoGrupo;
import com.bolao.model.Jogos;
import com.bolao.model.Participante;
import com.bolao.util.BolaoUtil;
import com.bolao.util.FacesUtil;

@ManagedBean
@ViewScoped
public class InicioControler implements Serializable {

	private static final long serialVersionUID = 1L;


	private ClassificacaoGrupoBusiness classificacaoGrupoBusiness;

	private JogosBusiness jogosBusiness;

	private ApostasBusiness apostasBusiness;

	private ParticipanteBusiness participanteBusiness;

	private BolaoUtil bolaoUtil;

	private ApostaClassificacaoGrupoBusiness apostaClassificacaoGrupoBusiness;

	/* private RelatorioUtil relatorioUtil; */

	private String nome = new String();
	private int ativo = -1;// traz a lista toda
	
	private List<Jogos> jogos = new ArrayList<Jogos>();
	private List<ApostaJogo> apostas = new ArrayList<ApostaJogo>();
	private List<ClassificacaoGrupo> classificacoesOk = new ArrayList<ClassificacaoGrupo>();
	private boolean mensagem = true;
	private Jogos ultimoJogo = new Jogos();
	private ClassificacaoGrupo ultimoClassificacaoGrupo = new ClassificacaoGrupo();
	private String usuario = FacesUtil.getName();
	private Participante participante;
	private Long apostasGolNull;
	private int apostasPendentes;
	private int totalParticipantes;
	private int totalParticipantesAtivos;

	// util
	// verifica se já foi feita alguma consulta
	private boolean consultar = false;

	@PostConstruct
	public void init() {
		participanteBusiness = new ParticipanteBusinessImpl();
		participante = participanteBusiness.findByUsername(usuario);
		bolaoUtil = new BolaoUtil();
		

		jogos = jogosBusiness.findAll();

		if (!participante.getUsername().equals("ADMIN")) {

			apostasGolNull = apostasBusiness.countByParticipanteAndGolNull(participante);

			apostas = apostasBusiness.findByUsername(participante.getUsername());

			if (apostasGolNull == 0 && apostas.size() == 0)
				apostasGolNull = new Long(48);

			apostasPendentes = apostaClassificacaoGrupoBusiness.countByApostasPendentes(participante);

		}
		setTotalParticipantes(participanteBusiness.findAll().size() - 1);
		setTotalParticipantesAtivos(participanteBusiness.count("", 1) - 1);

	}

	public String limpaTela() {
		ativo = -1;
		
		nome = new String();
		
		consultar = false;

		return "classificacaoGeral";
	}

	/**
	 * Emitir Relatorio
	 * 
	 * @return
	 */
	public String relatorio() {

		try {
			System.out.println("inicio relatorio");
			Map<String, Object> parametros = new HashMap<String, Object>();
			StringBuilder resultado = new StringBuilder();
			jogos = jogosBusiness.findAllOk();
			if (jogos != null) {
				ultimoJogo = jogos.get(jogos.size() - 1);
				resultado.append("Classificação gerada até o jogo " + ultimoJogo.getTime1().getNome() + " "
						+ ultimoJogo.getGol1() + " X " + ultimoJogo.getGol2() + " " + ultimoJogo.getTime2().getNome());
			}
			classificacoesOk = classificacaoGrupoBusiness.findAllOk();
			if (classificacoesOk != null) {
				ultimoClassificacaoGrupo = classificacoesOk.get(classificacoesOk.size() - 1);
				resultado.append("\n Classificação do Grupo  " + ultimoClassificacaoGrupo.getGrupo().getNome()
						+ " 1º Lugar: " + ultimoClassificacaoGrupo.getPosicao1().getNome() + " 2º Lugar: "
						+ ultimoClassificacaoGrupo.getPosicao2().getNome());
			}
			parametros.put("RESULTADO", resultado.toString());
			parametros.put("FILTRO", "WHERE 1=1");

			/*
			 * relatorioUtil.relatorio("classificacao.jasper", parametros,
			 * "classificacao.pdf");
			 */
			System.out.println("fim relatorio");
		} catch (BolaoRuntimeException e) {
			FacesUtil.addErroMessage(e.getMessage());
			// logger.warn("Ocorreu o seguinte erro: " + e.getMessage());
		} catch (Exception e) {
			FacesUtil.addErroMessage("Erro na geração da Classificação. Operação cancelada.");
			// logger.fatal("Ocorreu o seguinte erro: " + e.getMessage());
		}

		return null;
	}

	/**
	 * Getters e Setters
	 */

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public boolean isConsultar() {
		return consultar;
	}

	public void setConsultar(boolean consultar) {
		this.consultar = consultar;
	}

	

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public Jogos getUltimoJogo() {
		return ultimoJogo;
	}

	public void setUltimoJogo(Jogos ultimoJogo) {
		this.ultimoJogo = ultimoJogo;
	}

	public boolean isMensagem() {
		return mensagem;
	}

	public void setMensagem(boolean mensagem) {
		this.mensagem = mensagem;
	}

	public List<ClassificacaoGrupo> getClassificacoesOk() {
		return classificacoesOk;
	}

	public void setClassificacoesOk(List<ClassificacaoGrupo> classificacoesOk) {
		this.classificacoesOk = classificacoesOk;
	}

	public List<Jogos> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogos> jogos) {
		this.jogos = jogos;
	}

	public Long getApostasGolNull() {
		return apostasGolNull;
	}

	public void setApostasGolNull(Long apostasGolNull) {
		this.apostasGolNull = apostasGolNull;
	}

	public int getApostasPendentes() {
		return apostasPendentes;
	}

	public void setApostasPendentes(int apostasPendentes) {
		this.apostasPendentes = apostasPendentes;
	}

	public int getTotalParticipantes() {
		return totalParticipantes;
	}

	public void setTotalParticipantes(int totalParticipantes) {
		this.totalParticipantes = totalParticipantes;
	}

	public int getTotalParticipantesAtivos() {
		return totalParticipantesAtivos;
	}

	public void setTotalParticipantesAtivos(int totalParticipantesAtivos) {
		this.totalParticipantesAtivos = totalParticipantesAtivos;
	}

}
