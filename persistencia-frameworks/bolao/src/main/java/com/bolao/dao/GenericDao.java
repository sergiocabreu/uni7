package com.bolao.dao;

import java.util.List;

import org.hibernate.Session;

import com.bolao.model.BaseModel;
import com.bolao.util.HibernateFactory;

public class GenericDao {	
	
	protected final Session session;
	
    public GenericDao() throws Exception {
    	this.session = HibernateFactory.getSessionFactory().getCurrentSession();
    }
    
    public void salvar(BaseModel bm){
    	session.saveOrUpdate(bm);
    }
    
    public void deletar(BaseModel bm){
    	session.delete(bm);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BaseModel> listarTodos(Class bm){
    	return session.createQuery("from "+bm.getName()+" e where e.estaAtivo = true").list();
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BaseModel> listarTodosComLimite(Class bm, Integer limite){
    	return session.createQuery("from "+bm.getName()+" e where e.estaAtivo = true").setMaxResults(limite).list();
    }
    
}
