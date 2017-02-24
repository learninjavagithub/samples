package com.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.stat.Statistics;

public class SecondLevelCache {
	
	public static void main(String[] args) {

		
		// creating configuration object
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");// populates the data of the
											// configuration file

		// creating session factory object
		//SessionFactory factory = cfg.buildSessionFactory(); -- Deprecated in 4.0
		
		// Deprecated in 4.3, Works fine in 4.0, 4.1 and 4.2
		//ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
		//		cfg.getProperties()).buildServiceRegistry();
		//SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		
		// From 4.3
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				cfg.getProperties()).build();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		
		Statistics stats = factory.getStatistics();
		stats.setStatisticsEnabled(true);
		
		try {
			// creating session object
			Session session = factory.openSession();
			session.beginTransaction();
			
			Employee e1 = (Employee) session.load(Employee.class, 115); //
			System.out.println("Employee from DB: " + e1.getFirstName());
	
			System.out.println("Fetching Employee from First Level Cache...");
			e1 = (Employee) session.load(Employee.class, 115); // 
			System.out.println("Employee from FLC : " + e1.getFirstName()); 
			
			session.evict(e1);
			System.out.println("Removed Employee from FLC...");

			// Uncommenting the below line removes the object from SLC and hence new DB query is fired
			//factory.getCache().evictEntityRegion(Employee.class);
			//factory.evit() and factory.evictCollection, factory.evictEntiry() are all deprecated
			//so use methods from getCache() instead like above
			
			System.out.println("Fetching Employee from Second Level Cache...");
			e1 = (Employee) session.load(Employee.class, 115); // 
			System.out.println("Employee from SLC : " + e1.getFirstName()); 
			
			session.getTransaction().commit();
			session.close();

		} finally {
			// Prints 1 - Works only when stats are enabled
			System.out.println(factory.getStatistics().getEntityFetchCount());
			// Prints 1 - Works when stats are enabled
			System.out.println(factory.getStatistics().getSecondLevelCacheHitCount()); 
			factory.close(); // If this statement is not present, then the program will be running for ever
		}
	}
}