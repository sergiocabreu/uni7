package com.bolao.dao;

import java.util.List;

import com.bolao.model.ApostaJogo;
import com.bolao.model.Jogos;
import com.bolao.model.Participante;


public interface ApostasDAO {

	public void salvar(ApostaJogo aposta);

	public List<ApostaJogo> findByUsername(String username);
	
	public List<ApostaJogo> findByIdParticipante(Long idParticipante);
	
	public List<ApostaJogo> findByJogo(Long idJogo, int first, int rows);
	
	public Long countByParticipanteAndGolNull(Participante participante);
	
	public int countByJogo (Long idJogo);
	
	public ApostaJogo getApostaByJogoParticipante(Participante participante, Jogos jogo);

}
