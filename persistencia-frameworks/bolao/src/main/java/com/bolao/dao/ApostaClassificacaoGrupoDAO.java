package com.bolao.dao;

import java.util.List;

import com.bolao.model.ApostaClassificacaoGrupo;
import com.bolao.model.Grupo;
import com.bolao.model.Participante;


public interface ApostaClassificacaoGrupoDAO {

	public void salvar(ApostaClassificacaoGrupo aposta);

	public List<ApostaClassificacaoGrupo> findByUsername(String username);
	
	public List<ApostaClassificacaoGrupo> findByIdParticipante(Long idParticipante);
	
	public List<ApostaClassificacaoGrupo> findByGrupo(Long igGrupo, int first, int rows);
	
	public int countByGrupo (Long idGrupo);
	
	public ApostaClassificacaoGrupo getApostaByGrupoParticipante(Participante participante, Grupo grupo);
	
	public ApostaClassificacaoGrupo findById(Long id);
	
	public int countByApostasPendentes (Participante participante);

}
