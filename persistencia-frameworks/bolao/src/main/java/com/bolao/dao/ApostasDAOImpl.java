package com.bolao.dao;

import java.util.List;

import org.hibernate.Query;

import com.bolao.model.ApostaJogo;
import com.bolao.model.Jogos;
import com.bolao.model.Participante;

public class ApostasDAOImpl extends GenericDao implements ApostasDAO {

	public ApostasDAOImpl() throws Exception {
		super();
	}

	public Long setMaxId() {
		Query query = session.getNamedQuery("ApostaJogo.findMaxId");
		if (query.uniqueResult() == null) {
			return (long) 1;
		} else {
			return (Long) query.uniqueResult() + 1;
		}
	}

	@Override
	public void salvar(ApostaJogo aposta) {
		super.salvar(aposta);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ApostaJogo> findByUsername(String username) {
		Query query = session.getNamedQuery("ApostaJogo.findByUsername");
		query.setParameter("username", username);
		return query.list();
	}

	@Override
	public Long countByParticipanteAndGolNull(Participante participante) {
		Query query = session.getNamedQuery("ApostaJogo.countByParticipanteAndGolNull");
		query.setParameter("idParticipante", participante.getId());
		return (Long) query.uniqueResult();
	}

	@Override
	public ApostaJogo getApostaByJogoParticipante(Participante participante, Jogos jogo) {
		Query query = session.getNamedQuery("ApostaJogo.apostaByJogoParticipante");
		query.setParameter("idParticipante", participante.getId());
		query.setParameter("idJogo", jogo.getId());
		return (ApostaJogo) query.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ApostaJogo> findByJogo(Long idJogo, int first, int maxPerPage) {
		Query query = session.getNamedQuery("ApostaJogo.findByJogo");
		query.setParameter("idJogo", idJogo);
		query.setFirstResult(first);
		query.setMaxResults(maxPerPage);
		return query.list();
	}

	@Override
	public int countByJogo(Long idJogo) {
		Query query = session.getNamedQuery("ApostaJogo.findByJogo");
		query.setParameter("idJogo", idJogo);
		return query.list().size();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ApostaJogo> findByIdParticipante(Long idParticipante) {
		Query query = session.getNamedQuery("ApostaJogo.findByIdParticipante");
		query.setParameter("idParticipante", idParticipante);
		return query.list();
	}

}
