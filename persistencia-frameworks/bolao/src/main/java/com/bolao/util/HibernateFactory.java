package com.bolao.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
	
	private static final SessionFactory factory;

	static {
		
		Configuration c = new Configuration();
		c.setInterceptor(new AuditInterceptor());
		factory = c.configure().buildSessionFactory();
	}
	
	public static synchronized SessionFactory getSessionFactory() {
		return factory;
	}
}