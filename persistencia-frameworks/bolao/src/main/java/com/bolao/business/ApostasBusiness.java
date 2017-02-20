package com.bolao.business;

import java.util.List;

import com.bolao.dao.ApostasDAO;
import com.bolao.model.ApostaJogo;
import com.bolao.model.Participante;


public interface ApostasBusiness {

	public void salvar(ApostaJogo aposta);

	public List<ApostaJogo> findByUsername(String username);
	
	public List<ApostaJogo> findByIdParticipante(Long idParticipante);
	
	public List<ApostaJogo> findByJogo(Long idJogo,int first, int rows);
	
	public int countByJogo (Long idJogo);
	
	public Long countByParticipanteAndGolNull(Participante participante);

	public void setDAO(ApostasDAO dao);

}
