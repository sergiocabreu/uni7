/**
 * 
 */
package com.bolao.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;

import com.bolao.model.Grupo;

public class GrupoDAOImpl extends GenericDao implements GrupoDAO {

	public GrupoDAOImpl() throws Exception {
		super();
	}

	@Override
	public void salvar(Grupo grupo) {
		
		if (grupo.getId() == null)
			super.salvar(grupo);
		else
			super.session.merge(grupo);
	}

	@Override
	public void excluir(Grupo grupo) {
		super.deletar(grupo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo> buscar() {
		return super.session.getNamedQuery("Grupo.findAll").list();
	}

	@Override
	public Grupo buscar(String nome) {

		Query query = session.getNamedQuery("Grupo.findByNome");
		query.setParameter("nome", nome);

		return (Grupo) query.uniqueResult();
	}

	@Override
	public Grupo buscar(Long id) {

		Query query = session.getNamedQuery("Grupo.findById");
		query.setParameter("id", id);

		return (Grupo) query.uniqueResult();
	}

	@Override
	public int count(String nome) {

		Query query = session.getNamedQuery("Grupo.countByNome");
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		return ((Long) query.uniqueResult()).intValue();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Grupo> search(String nome, int first, int rows) {

		Query query = session.getNamedQuery("Grupo.searchByNome");
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		query.setFirstResult(first);
		query.setMaxResults(rows);
		return query.list();
	}

	@Override
	public Grupo findByGrupo(Grupo grupo) {

		Query query = session.getNamedQuery("Grupo.findByGrupo");
		query.setParameter("id", grupo.getId());
		return (Grupo) query.uniqueResult();
	}

	@Override
	public Grupo findByNome(String nome) {
		try {

			Query query = session.getNamedQuery("Grupo.findByNome");
			query.setParameter("nome", nome.toUpperCase());
			return (Grupo) query.uniqueResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Grupo findById(Long id) {
		try {

			Query query = session.getNamedQuery("Grupo.findById");
			query.setParameter("id", id);
			return (Grupo) query.uniqueResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo> searchByNome(String nome) {

		Query query = session.getNamedQuery("Grupo.searchByNome");
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		return query.list();
	}

}
