package com.bolao.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.bolao.model.Grupo;
import com.bolao.model.Jogos;

public class JogosDAOImpl extends GenericDao implements JogosDAO {

	public JogosDAOImpl() throws Exception {
		super();
	}

	@Override
	public void salvar(Jogos jogos) {
		if (jogos.getId() == null )
			super.salvar(jogos);
		else 
			super.session.merge(jogos);
	}

	@Override
	public void excluir(Jogos Jogos) {
		super.deletar(Jogos);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Jogos> findByCriterios(Date datajogo, Grupo grupo) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select j from Jogos j where 1=1 ");

		if (datajogo != null)
			sql.append(" AND j.dtJogo = :datajogo");
		if (grupo != null)
			sql.append(" AND j.grupo = :grupo");

		sql.append(" ORDER BY  j.id");

		Query query = session.getNamedQuery(sql.toString());
		if (grupo != null)
			query.setParameter("grupo", grupo);

		if (datajogo != null)
			query.setParameter("datajogo", datajogo);

		return query.list();
	}

	@Override
	public Jogos findById(Long id) {
		Query query = session.getNamedQuery("Jogos.findById");
		query.setParameter("id", id);
		return (Jogos) query.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Jogos> findAll() {
		return super.session.getNamedQuery("Jogos.findAll").list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Jogos> findAllOk() {

		Query query = session.getNamedQuery("Jogos.findAllOK");
		return query.list();
	}

}
