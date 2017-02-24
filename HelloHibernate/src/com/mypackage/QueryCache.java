package com.mypackage;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.stat.Statistics;

public class QueryCache {

	public static void main(String[] args) {

		// creating configuration object
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");// populates the data of the
											// configuration file

		// creating session factory object
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);

		Statistics stats = factory.getStatistics();
		stats.setStatisticsEnabled(true);

		try {
			// creating session object
			Session session = factory.openSession();
			session.beginTransaction();

			Employee e1 = new QueryCache().getEmployeeUsingQuery(session, 115);
			System.out.println("Query Result from DB for the first call: " + e1.getFirstName());

			e1 = new QueryCache().getEmployeeUsingQuery(session, 115);
			System.out.println("Query Result from DB for the second call: " + e1.getFirstName());

			session.getTransaction().commit();
			session.close();

		} finally {
			// Prints 0 as entities are not cached but queries will be
			System.out.println(factory.getStatistics().getEntityFetchCount());
			// Prints 1
			System.out.println(factory.getStatistics().getQueryCacheHitCount());
			factory.close();// If this statement is not present, then the
							// program will be running for ever
		}
	}

	private Employee getEmployeeUsingQuery(Session session, int id) {

		Query query = session.createQuery("from Employee e where e.id = :id ");
		query.setParameter("id", id);
		query.setMaxResults(1);
		query.setCacheable(true); // This is required even though we enable it in cfg.xml 

		return query.list() == null ? null : (Employee) query.list().get(0);
	}
}