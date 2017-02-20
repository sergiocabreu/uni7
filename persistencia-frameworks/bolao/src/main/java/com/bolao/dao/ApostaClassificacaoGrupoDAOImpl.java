package com.bolao.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;

import com.bolao.model.ApostaClassificacaoGrupo;
import com.bolao.model.Grupo;
import com.bolao.model.Participante;

public class ApostaClassificacaoGrupoDAOImpl extends GenericDao implements ApostaClassificacaoGrupoDAO {

	public ApostaClassificacaoGrupoDAOImpl() throws Exception {
		super();
	}

	public Long setMaxId() {

		Query query = session.getNamedQuery("ApostaClassificacaoGrupo.findMaxId");
		if (query.uniqueResult() == null) {
			return (long) 1;
		} else {
			return (Long) query.uniqueResult() + 1;
		}
	}

	@Override
	public void salvar(ApostaClassificacaoGrupo aposta) {
		super.salvar(aposta);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ApostaClassificacaoGrupo> findByUsername(String username) {
		Query query = session.getNamedQuery("ApostaClassificacaoGrupo.findByUsername");
		query.setParameter("username", username);
		return query.list();
	}

	@Override
	public ApostaClassificacaoGrupo getApostaByGrupoParticipante(Participante participante, Grupo grupo) {

		try {
			Query query = session.getNamedQuery("ApostaClassificacaoGrupo.apostaByGrupoParticipante");
			query.setParameter("idParticipante", participante.getId());
			query.setParameter("idGrupo", grupo.getId());

			return (ApostaClassificacaoGrupo) query.uniqueResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ApostaClassificacaoGrupo> findByGrupo(Long idGrupo, int first, int maxPerPage) {

		Query query = session.getNamedQuery("ApostaClassificacaoGrupo.findByGrupo");
		query.setParameter("idGrupo", idGrupo);
		query.setFirstResult(first);
		query.setMaxResults(maxPerPage);
		return query.list();
	}

	@Override
	public int countByGrupo(Long idGrupo) {
		Query query = session.getNamedQuery("ApostaClassificacaoGrupo.countByGrupo");
		query.setParameter("idGrupo", idGrupo);
		return query.list().size();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ApostaClassificacaoGrupo> findByIdParticipante(Long idParticipante) {
		Query query = session.getNamedQuery("ApostaClassificacaoGrupo.findByIdParticipante");
		query.setParameter("idParticipante", idParticipante);
		return query.list();
	}

	@Override
	public ApostaClassificacaoGrupo findById(Long id) {
		Query query = session.getNamedQuery("ClassificacaoGrupo.findById");
		query.setParameter("id", id);
		return (ApostaClassificacaoGrupo) query.uniqueResult();
	}

	@Override
	public int countByApostasPendentes(Participante participante) {
		Query query = session.getNamedQuery("ApostaClassificacaoGrupo.countByApostasPendentes");
		query.setParameter("idParticipante", participante.getId());
		return 8 - query.list().size();
	}

}
