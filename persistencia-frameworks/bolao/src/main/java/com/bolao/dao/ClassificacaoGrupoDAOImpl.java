package com.bolao.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;

import com.bolao.model.ClassificacaoGrupo;
import com.bolao.model.Grupo;

public class ClassificacaoGrupoDAOImpl extends GenericDao implements ClassificacaoGrupoDAO {

	public ClassificacaoGrupoDAOImpl() throws Exception {
		super();
	}

	@Override
	public void salvar(ClassificacaoGrupo classificacaoGrupo) {
		super.salvar(classificacaoGrupo);
	}

	public Long setMaxId() {

		Query query = session.getNamedQuery("ClassificacaoGrupo.findMaxId");
		if (query.uniqueResult() == null) {
			return (long) 1;
		} else {
			return (Long) query.uniqueResult() + 1;
		}
	}

	@Override
	public void excluir(ClassificacaoGrupo classificacaoGrupo) {
		super.deletar(classificacaoGrupo);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ClassificacaoGrupo> findByCriterios(Grupo grupo) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select j from ClassificacaoGrupo j where 1=1 ");

		if (grupo != null)
			sql.append(" AND j.grupo = :grupo");

		sql.append(" ORDER BY  j.id");

		Query query = session.getNamedQuery(sql.toString());
		if (grupo != null)
			query.setParameter("grupo", grupo);

		return query.list();
	}

	@Override
	public ClassificacaoGrupo findById(Long id) {

		Query query = session.getNamedQuery("ClassificacaoGrupo.findById");
		query.setParameter("id", id);
		return (ClassificacaoGrupo) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClassificacaoGrupo> findAllOk() {
		Query query = session.getNamedQuery("ClassificacaoGrupo.findAllOk");
		return query.list();
	}

	@Override
	public ClassificacaoGrupo findByGrupo(Grupo grupo) {
		try {

			Query query = session.getNamedQuery("ClassificacaoGrupo.findByGrupo");
			query.setParameter("idGrupo", grupo.getId());
			return (ClassificacaoGrupo) query.uniqueResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
