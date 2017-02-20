/**
 * 
 */
package com.bolao.business;

import java.util.List;

import com.bolao.dao.ApostaClassificacaoGrupoDAO;
import com.bolao.dao.ApostaClassificacaoGrupoDAOImpl;
import com.bolao.model.ApostaClassificacaoGrupo;
import com.bolao.model.Grupo;
import com.bolao.model.Participante;


public class ApostaClassificacaoGrupoBusinessImpl implements ApostaClassificacaoGrupoBusiness {


	private ApostaClassificacaoGrupoDAO apostaClassificacaoGrupoDAO;
	
	public ApostaClassificacaoGrupoBusinessImpl() {
		
		try {
			apostaClassificacaoGrupoDAO = new ApostaClassificacaoGrupoDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void salvar(ApostaClassificacaoGrupo aposta) {
		apostaClassificacaoGrupoDAO.salvar(aposta);
	}

	@Override
	public List<ApostaClassificacaoGrupo> findByUsername(String username) {
		return apostaClassificacaoGrupoDAO.findByUsername(username);
	}
	
	@Override
	public List<ApostaClassificacaoGrupo> findByGrupo(Long idGrupo,int first, int rows) {
		return apostaClassificacaoGrupoDAO.findByGrupo(idGrupo, first, rows);
	}

	@Override
	public void setDAO(ApostaClassificacaoGrupoDAO dao) {
		this.apostaClassificacaoGrupoDAO = dao;
	}

	@Override
	public int countByGrupo(Long idGrupo) {
		return apostaClassificacaoGrupoDAO.countByGrupo( idGrupo);
	}

	@Override
	public List<ApostaClassificacaoGrupo> findByIdParticipante(Long idParticipante) {
		return apostaClassificacaoGrupoDAO.findByIdParticipante(idParticipante);
	}

	@Override
	public ApostaClassificacaoGrupo findById(Long id) {
		return  apostaClassificacaoGrupoDAO.findById(id);
	}

	@Override
	public ApostaClassificacaoGrupo findByParticipanteGrupo(Grupo grupo,
			Participante participante) {
		return  apostaClassificacaoGrupoDAO.getApostaByGrupoParticipante(participante,grupo);
	}

	@Override
	public int countByApostasPendentes(Participante participante) {
		return apostaClassificacaoGrupoDAO.countByApostasPendentes(participante);
	}

}
