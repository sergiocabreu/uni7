package com.bolao.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bolao.model.Grupo;
import com.bolao.model.Time;
import com.bolao.util.HibernateFactory;

public class TesteCache {

	public static void main(String[] args) throws Exception {

		// ------------ Cache Grupo ---------
		Session session = HibernateFactory.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		Transaction t = session.beginTransaction();

		Grupo g1 = (Grupo) session.get(Grupo.class, new Long(1));

		System.out.println("1 - pos session.get");
		System.out.println(g1.getNome());

		// Atualiza a tabela usando JDBC.
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bolao?autoReconnect=true", "root",
				"root");

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("update grupo set nome = 'A' where idgrupo = 1");

		t.commit();

		//session.close();

		 session = HibernateFactory.getSessionFactory().openSession();
		
		t = session.beginTransaction();

		 

		g1 = (Grupo) session.get(Grupo.class, new Long(1));

		System.out.println("2 - pos session.get");

		System.out.println(g1.getNome());

		t.commit();

		session.close();
		
		
		// ------------ Cache Time ---------

		Session session2 = HibernateFactory.getSessionFactory().getCurrentSession();
		session2.getTransaction().begin();
		Transaction t2 = session2.beginTransaction();

		Time t1 = (Time) session2.get(Time.class, new Long(1));

		System.out.println("1 - pos session.get");
		System.out.println(t1.getNome());

		// Atualiza a tabela usando JDBC.
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost/bolao?autoReconnect=true", "root",
				"root");

		Statement stmt2 = conn2.createStatement();

		stmt2.executeUpdate("update time set nome = 'Ceará' where idgrupo = 1");

		t2.commit();

		//session.close();

		 session2 = HibernateFactory.getSessionFactory().openSession();
		
		t2 = session2.beginTransaction();

		 

		t1 = (Time) session2.get(Time.class, new Long(1));

		System.out.println("2 - pos session.get");

		System.out.println(t1.getNome());

		t2.commit();

		session2.close();

	

	}
}
