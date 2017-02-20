package com.bolao.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;

import com.bolao.model.Participante;


public class ParticipanteDAOImpl extends GenericDao  implements ParticipanteDAO{

	public ParticipanteDAOImpl() throws Exception {
		super();
	}
	
	private Long getMaxId() {
		Query query;
		String consulta; 
		consulta = new String("SELECT MAX(u.id) FROM Participante u");
		query = session.createQuery(consulta);
		return query.uniqueResult() == null ? 1 : (Long) query.uniqueResult() + 1;
	}
	
	@Override
	public Participante findByUsername(String nome) {
		try {
			Query query = session.getNamedQuery("Participante.findByUsername");
			query.setParameter("username", nome.toUpperCase());

			return (Participante) query.uniqueResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Participante> searchByNome(String nome, int ativo) {
		try {
			StringBuilder consulta = 
					new StringBuilder("SELECT *" +
									  " FROM Participante" +
									  " WHERE UPPER(replace(nome, 'âàãáÁÂÀÃéêÉÊíÍóôõÓÔÕüúÜÚÇç', 'AAAAAAAAEEEEIIOOOOOOUUUUCC'))" +
									  " LIKE UPPER(replace('%" + nome +"%', 'âàãáÁÂÀÃéêÉÊíÍóôõÓÔÕüúÜÚÇç', 'AAAAAAAAEEEEIIOOOOOOUUUUCC'))");
			if(ativo == 0 || ativo == 1) {
				consulta.append(" AND flativo = " + ativo);
			}
			consulta.append(" ORDER BY nome");
			
			Query query = session.createSQLQuery(consulta.toString());
			
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Participante findByParticipante(Participante participante) {
		try{
			Query query = session.createSQLQuery("Participante.findByParticipante");
			query.setParameter("participante", participante);
			return (Participante) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void salvar(Participante participante) {
		//verifica se é um novo usuário ou se é apenas uma alteração 
		if(participante.getId() == null || participante.getId() == 0) {
			participante.setId(getMaxId());
		}
	
		System.out.println("Inserindo participante... "+participante.getNome());
		if (participante.getId() == null)
			super.salvar(participante);
		else
			super.session.merge(participante);
	}

	@Override
	public Participante findByCpf(String cpf) 
	{
		try
		{
			String consulta = new String("SELECT * FROM Participante WHERE cpf LIKE " + cpf);
			Query query = session.createSQLQuery(consulta.toString());
			return (Participante)query.uniqueResult(); 
			
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	//consultas com lazy para tela de tabela Participante
	public List<Participante> findByNome(String nome, int ativo, int inicio, int maxPerPage) {
		/*StringBuilder consulta = 
			new StringBuilder("SELECT p.* " +
							  " FROM Participante p" +
							  " WHERE UPPER(replace(nome, 'âàãáÁÂÀÃéêÉÊíÍóôõÓÔÕüúÜÚÇç', 'AAAAAAAAEEEEIIOOOOOOUUUUCC'))" +
							  " LIKE UPPER(replace('%" + nome +"%', 'âàãáÁÂÀÃéêÉÊíÍóôõÓÔÕüúÜÚÇç', 'AAAAAAAAEEEEIIOOOOOOUUUUCC'))");
		if(ativo == 0 || ativo == 1) {
			consulta.append(" AND flativo = " + ativo);
		}
		consulta.append(" ORDER BY nome");*/
	//	Query query = session.createSQLQuery("Participante.findAll");
		Query query = session.getNamedQuery("Participante.findAll");
		//query.setParameter("username", nome.toUpperCase());
		//query.setParameter("participante", participante);
		/*return (Participante) query.uniqueResult();
		Query query = session.createSQLQuery(consulta.toString());*/
		//query.setFirstResult(inicio);
		//query.setMaxResults(maxPerPage);	
		List<Participante> participantes = (List<Participante>) query.list(); 
		return participantes;		
	}

	@Override
	public int count(String nome, int ativo) {
		StringBuilder consulta = 
				new StringBuilder("SELECT *" +
								  " FROM Participante" +
								  " WHERE UPPER(replace(nome, 'âàãáÁÂÀÃéêÉÊíÍóôõÓÔÕüúÜÚÇç', 'AAAAAAAAEEEEIIOOOOOOUUUUCC'))" +
								  " LIKE UPPER(replace('%" + nome +"%', 'âàãáÁÂÀÃéêÉÊíÍóôõÓÔÕüúÜÚÇç', 'AAAAAAAAEEEEIIOOOOOOUUUUCC'))");
			if(ativo == 0 || ativo == 1) {
				consulta.append(" AND flativo = " + ativo);
			}
			consulta.append(" ORDER BY nome");
			Query query = session.createSQLQuery(consulta.toString());	
			System.out.println(query.list().size());
			return query.list().size();
	}

	@Override
	public Participante findByEmail(String email) {
		try{
			StringBuilder sql = new StringBuilder("SELECT * FROM Participante WHERE email LIKE '"+ email +"'");
			Query query = session.createQuery(sql.toString());
			
			return (Participante)query.uniqueResult();
		}catch (NoResultException e){
			return null;
		}
	}

	@Override
	public Participante findByLoginAndEmail(String login, String email) {
		try{
			String sql = new String("SELECT p FROM Participante p WHERE p.email LIKE '" + email + "' AND p.username LIKE '" + login + "'");
			Query query = session.createQuery(sql.toString());
			return (Participante)query.uniqueResult();
		}catch (NoResultException e){
			return null;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Participante> findAll() {
		StringBuilder sql = new StringBuilder("Select p from Participante p order by p.nome");
		Query query = session.createQuery(sql.toString());
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Participante> findAllOk() {
		StringBuilder sql = new StringBuilder("Select p from Participante p where p.ativo = 1 and p.id <>1 order by p.nome");
		Query query = session.createQuery(sql.toString());
		return query.list();
	}

	@Override
	public Participante findById(Long idParticipante) {
		try{
			Query query = session.createSQLQuery("Participante.findById");
			query.setParameter("id", idParticipante);
			return (Participante) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}

}
