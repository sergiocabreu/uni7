package com.bolao.business;

import java.util.List;

import com.bolao.dao.ApostaClassificacaoGrupoDAO;
import com.bolao.model.ApostaClassificacaoGrupo;
import com.bolao.model.Grupo;
import com.bolao.model.Participante;



public interface ApostaClassificacaoGrupoBusiness {

	public void salvar(ApostaClassificacaoGrupo aposta);
	
	public ApostaClassificacaoGrupo findById(Long id);
	
	public ApostaClassificacaoGrupo findByParticipanteGrupo(Grupo grupo, Participante participante);
	
	public List<ApostaClassificacaoGrupo> findByUsername(String username);
	
	public List<ApostaClassificacaoGrupo> findByGrupo(Long idGrupo,int first, int rows);
	
	public int countByGrupo (Long idGrupo);
	
	public List<ApostaClassificacaoGrupo> findByIdParticipante(Long idParticipante);
	
	public void setDAO(ApostaClassificacaoGrupoDAO dao);
	
	public int countByApostasPendentes (Participante participante);
	
	

}
