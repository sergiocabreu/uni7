/**
 * 
 */
package com.bolao.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;

import com.bolao.model.Bolao;

public class BolaoDAOImpl extends GenericDao implements BolaoDAO {

	public BolaoDAOImpl() throws Exception {
		super();
	}

	@Override
	public void salvar(Bolao bolao) {
		
		if (bolao.getId() == null)
			super.salvar(bolao);
		else
			super.session.merge(bolao);
	}

	@Override
	public void excluir(Bolao bolao) {
		super.deletar(bolao);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bolao> buscar() {
		return super.session.getNamedQuery("Bolao.findAll").list();
	}

	@Override
	public Bolao buscar(String nome) {

		Query query = session.getNamedQuery("Bolao.findByNome");
		query.setParameter("nome", nome);

		return (Bolao) query.uniqueResult();
	}

	@Override
	public Bolao buscar(Long id) {

		Query query = session.getNamedQuery("Bolao.findById");
		query.setParameter("id", id);

		return (Bolao) query.uniqueResult();
	}

	@Override
	public int count(String nome) {

		Query query = session.getNamedQuery("Bolao.countByNome");
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		return ((Long) query.uniqueResult()).intValue();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Bolao> search(String nome, int first, int rows) {

		Query query = session.getNamedQuery("Bolao.searchByNome");
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		query.setFirstResult(first);
		query.setMaxResults(rows);
		return query.list();
	}

	@Override
	public Bolao findByBolao(Bolao bolao) {

		Query query = session.getNamedQuery("Bolao.findByBolao");
		query.setParameter("id", bolao.getId());
		return (Bolao) query.uniqueResult();
	}

	@Override
	public Bolao findByNome(String nome) {
		try {

			Query query = session.getNamedQuery("Bolao.findByNome");
			query.setParameter("nome", nome.toUpperCase());
			return (Bolao) query.uniqueResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Bolao findById(Long id) {
		try {

			Query query = session.getNamedQuery("Bolao.findById");
			query.setParameter("id", id);
			return (Bolao) query.uniqueResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bolao> searchByNome(String nome) {

		Query query = session.getNamedQuery("Bolao.searchByNome");
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		return query.list();
	}

}
