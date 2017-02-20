/**
 * 
 */
package com.bolao.business;

import java.util.List;

import com.bolao.dao.ApostasDAO;
import com.bolao.dao.ApostasDAOImpl;
import com.bolao.model.ApostaJogo;
import com.bolao.model.Participante;

public class ApostasBusinessImpl implements ApostasBusiness {

	private ApostasDAO apostasDAO;

	public ApostasBusinessImpl() {

		try {
			apostasDAO = new ApostasDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void salvar(ApostaJogo aposta) {
		apostasDAO.salvar(aposta);
	}

	@Override
	public List<ApostaJogo> findByUsername(String username) {
		return apostasDAO.findByUsername(username);
	}

	@Override
	public List<ApostaJogo> findByIdParticipante(Long idParticipante) {
		return apostasDAO.findByIdParticipante(idParticipante);
	}

	@Override
	public List<ApostaJogo> findByJogo(Long idJogo, int first, int rows) {
		return apostasDAO.findByJogo(idJogo, first, rows);
	}

	@Override
	public Long countByParticipanteAndGolNull(Participante participante) {
		return apostasDAO.countByParticipanteAndGolNull(participante);
	}

	@Override
	public void setDAO(ApostasDAO dao) {
		this.apostasDAO = dao;
	}

	@Override
	public int countByJogo(Long idJogo) {
		return apostasDAO.countByJogo(idJogo);
	}

}
