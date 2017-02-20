package com.bolao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.context.RequestContext;

import com.bolao.business.ApostaClassificacaoGrupoBusiness;
import com.bolao.business.ApostaClassificacaoGrupoBusinessImpl;
import com.bolao.business.ApostasBusiness;
import com.bolao.business.ApostasBusinessImpl;
import com.bolao.business.ParticipanteBusiness;
import com.bolao.business.ParticipanteBusinessImpl;
import com.bolao.exception.BolaoRuntimeException;
import com.bolao.model.ApostaClassificacaoGrupo;
import com.bolao.model.ApostaJogo;
import com.bolao.model.Participante;
import com.bolao.util.FacesUtil;



@ManagedBean
@RequestScoped
public class ApostasParticipanteController implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private ApostasBusiness apostasBusiness;

	private ParticipanteBusiness participanteBusiness;

	private ApostaClassificacaoGrupoBusiness apostaClassificacaoGrupoBusiness;

/*	@Autowired
	private RelatorioUtil relatorioUtil;*/

	// entidades das telas
	private Participante participante = new Participante();
	private ApostaJogo aposta;
	private Long apostasGolNull;
	private String nomeParticipante = new String();

	// listas
	private List<Participante> participanteList = new ArrayList<Participante>();
	private List<ApostaJogo> apostas;
	private List<ApostaClassificacaoGrupo> apostaGrupo;
	
	@PostConstruct
	public void init() {
		participanteBusiness = new ParticipanteBusinessImpl();
		apostasBusiness = new ApostasBusinessImpl();
		apostaClassificacaoGrupoBusiness = new ApostaClassificacaoGrupoBusinessImpl(); 
	}

	public void searchByParticipante() {
		try {
			apostas = apostasBusiness.findByIdParticipante(participante.getId());
			apostaGrupo = apostaClassificacaoGrupoBusiness
					.findByIdParticipante(participante.getId());
			System.out.println(apostaGrupo.size());
		} catch (Exception e) {
			apostas = new ArrayList<ApostaJogo>();
			apostaGrupo = new ArrayList<ApostaClassificacaoGrupo>();
			FacesUtil.addErroMessage(e.getMessage());
			
		}
		if (participante.getNome() == null)
			FacesUtil.addErroMessage("Usuário não selecionado");
	}

	public void consultarParticipante() {
		try {
			participanteList = participanteBusiness
					.searchByNome(getNomeParticipante());
		} catch (Exception e) {
			participanteList = new ArrayList<Participante>();
			FacesUtil.addErroMessage(e.getMessage());
			
		}
	}

	public void consultarParticipanteDialog() {
		consultarParticipante();

		if (!participanteList.isEmpty()) {
			RequestContext.getCurrentInstance().execute("dlg.show()");
		}

	}

	public void aposConsultarParticipante(Participante usu) {
		Participante p = new Participante();
		p.setId(getParticipante().getId());
		p = (Participante) usu;
		setParticipante(participanteBusiness.findByParticipante(p));
		nomeParticipante = participante.getNome();
		
		//testar consulta automatica
		searchByParticipante();
	}

	public String limpaTela() {

		participante = new Participante();
		apostas = new ArrayList<ApostaJogo>();
		apostaGrupo = new ArrayList<ApostaClassificacaoGrupo>();
		nomeParticipante = "";
		return "apostasParticipante";
	}

	/**
	 * Emitir Relatorio
	 * 
	 * @return
	 */
	public String relatorio() {

		try {
			FacesContext facesContext = FacesContext.getCurrentInstance(); 
			ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
			Map<String, Object> parametros = new HashMap<String, Object>();
			
			String pathRel = servletContext.getRealPath("//WEB-INF/relatorios/");  
			String filtro = " WHERE participante.idparticipante <> 1 ";
			
			parametros.put("FILTRO", filtro.toString());
			parametros.put("SUBREPORT_DIR",pathRel);
			/*relatorioUtil.relatorio("apostasParticipante.jasper", parametros,
					"apostasParticipante.pdf");*/
		} catch (BolaoRuntimeException e) {
			FacesUtil.addErroMessage(e.getMessage());
			
		} catch (Exception e) {
			FacesUtil
					.addErroMessage("Erro na geração do Aposta por Participantes. Operação cancelada.");
			
		}

		return null;
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

	public Long getApostasGolNull() {
		return apostasGolNull;
	}

	public String getNomeParticipante() {
		return nomeParticipante;
	}

	public void setNomeParticipante(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
	}

	public List<Participante> getParticipanteList() {
		return participanteList;
	}

	public void setParticipanteList(List<Participante> participanteList) {
		this.participanteList = participanteList;
	}

	public void setApostasGolNull(Long apostasGolNull) {
		this.apostasGolNull = apostasGolNull;
	}

	public List<ApostaClassificacaoGrupo> getApostaGrupo() {
		return apostaGrupo;
	}

	public void setApostaGrupo(List<ApostaClassificacaoGrupo> apostaGrupo) {
		this.apostaGrupo = apostaGrupo;
	}

}
