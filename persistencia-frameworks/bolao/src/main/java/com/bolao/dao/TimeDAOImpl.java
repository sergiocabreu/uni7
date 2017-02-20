package com.bolao.dao;

import java.util.List;

import org.hibernate.Query;

import com.bolao.model.Grupo;
import com.bolao.model.Participante;
import com.bolao.model.Time;

public class TimeDAOImpl extends GenericDao implements TimeDAO {

	public TimeDAOImpl() throws Exception {
		super();
	}

	@Override
	public void salvar(Time time) {
		if (time.getId() == null)
			super.salvar(time);
		else
			super.session.merge(time);
	}

	@Override
	public void excluir(Time time) {
		super.deletar(time);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Time> buscar() {
		return super.session.getNamedQuery("Time.findAll").list();
	}

	@Override
	public Time buscar(String nome) {
		Query query = session.getNamedQuery("Time.findByNome");
		query.setParameter("nome", nome);

		return (Time) query.uniqueResult();
	}

	@Override
	public Time buscar(Long id) {
		Query query = session.getNamedQuery("Time.findById");
		query.setParameter("id", id);

		return (Time) query.uniqueResult();
	}

	public Long setMaxId() {
		Query query = session.getNamedQuery("Time.findById");
		if (query.uniqueResult() == null) {
			return (long) 1;
		} else
			return (Long) query.uniqueResult() + 1;
	}

	@Override
	public Time findByNome(String nome) {

		Query query = session.getNamedQuery("Time.findByNome");
		query.setParameter("nome", nome.toUpperCase());

		return (Time) query.uniqueResult();

	}

	@Override
	public Time findNomeByGrupo(String nome, Grupo grupo) {

		Query query = session.getNamedQuery("Time.findNomeByGrupo");
		query.setParameter("nome", nome.toUpperCase());
		query.setParameter("grupo", grupo);
		return (Time) query.uniqueResult();

	}

	@Override
	public Time findById(Long id) {

		Query query = session.getNamedQuery("Time.findById");
		query.setParameter("id", id);
		return (Time) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Time> findByGrupo(Grupo grupo) {

		Query query = session.getNamedQuery("Time.findByGrupo");
		query.setParameter("grupo", grupo);
		return query.list();

	}

	@Override
	public int countByGrupo(Grupo grupo, String nome) {
		Query query = session.getNamedQuery("Time.countByGrupo");
		query.setParameter("grupo", grupo);
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		return ((Long) query.uniqueResult()).intValue();
	}

	@Override
	public int countByNome(String nome) {

		Query query = session.getNamedQuery("Time.countByNome");
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		return ((Long) query.uniqueResult()).intValue();
	}

	/*@SuppressWarnings("unchecked")
	@Override
	public List<Time> findByGrupoPaginado(String nome, Grupo grupo, int inicio, int maxPerPage) {

		Query query = session.getNamedQuery("Time.findByGrupoPaginado");
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		query.setParameter("grupo", grupo);
		query.setFirstResult(inicio);
		query.setMaxResults(maxPerPage);
		return query.list();
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public List<Time> findByCriterios(String nome, Grupo grupo) {
		String consulta = "Time.findByNome";

		if (grupo != null)
			consulta = "Time.findByGrupoPaginado";

		Query query = session.getNamedQuery(consulta);
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		if (grupo != null)
			query.setParameter("grupo", grupo);
		return query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Time> search(String nome) {

		Query query = session.getNamedQuery("Time.searchByNome");
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		return query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Time> findTime(String nome, int startingAt, int maxPerPage) {

		Query query = session.getNamedQuery("Time.findByNome");
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		query.setFirstResult(startingAt);
		query.setMaxResults(maxPerPage);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Time> findAllTime(int inicio, int max) {

		Query query = session.getNamedQuery("Time.findAll");
		query.setFirstResult(inicio);
		query.setMaxResults(max);
		return query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Time> search(String nome, int first, int rows) {

		Query query = session.getNamedQuery("Time.searchByNome");
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		query.setFirstResult(first);
		query.setMaxResults(rows);
		return query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Time> findTimeNaoClassificadaByGrupo(Grupo grupo) {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT * FROM Time s INNER JOIN CLASSIFICACAOGRUPO cg ON cg.IDGRUPO = s.IDGRUPO WHERE s.IDGRUPO = :idGrupo AND s.IDTime NOT IN (cg.POSICAO1, cg.POSICAO2)");
		Query query = session.createSQLQuery(sql.toString());
		query.setParameter("idGrupo", grupo.getId());
		return query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Time> findTimeNaoClassificadaByGrupoParticipante(Grupo grupo, Participante participante) {

		StringBuilder consulta = new StringBuilder("select * from Time, ( ");
		consulta.append(" select posicao1, posicao2 from apostaclassificacaogrupo ");
		consulta.append(" where apostaclassificacaogrupo.IDGRUPO =  " + grupo.getId());
		consulta.append(" and apostaclassificacaogrupo.IDPARTICIPANTE =  " + participante.getId());
		consulta.append(" )  apostagrupo ");

		consulta.append(" where Time.IDGRUPO =  " + grupo.getId());
		consulta.append(" and Time.IDTime <> apostagrupo.posicao1 ");
		consulta.append(" and Time.IDTime <> apostagrupo.posicao2 ");
		consulta.append(" ORDER BY Time.idTime");

		System.out.println(consulta.toString());
		Query query = session.createSQLQuery(consulta.toString());

		return query.list();
	}

}
