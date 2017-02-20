package com.bolao.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.SessionFactory;

import com.bolao.util.HibernateFactory;

@WebFilter("*.faces")
public class FiltroJPA implements Filter {

	private SessionFactory factory;

	public FiltroJPA() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		factory = HibernateFactory.getSessionFactory();
		
		try {
			
			factory.getCurrentSession().beginTransaction();
			
			chain.doFilter(request, response);
			
			if (!factory.getCurrentSession().getTransaction().wasCommitted())
				factory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			factory.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void destroy() {
	}
}