package com.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	
	public static void main(String[] args) {

		// creating configuration object
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");// populates the data of the
											// configuration file

		// creating seession factory object
		SessionFactory factory = cfg.buildSessionFactory();

		// creating session object
		Session session = factory.openSession();

		// creating transaction object
		Transaction t = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setId(115);
		e1.setFirstName("Ganesh");
		e1.setLastName("Venkatesh");

		//session.persist(e1);// persisting the object - Called during first insert
		session.update(e1);

		Employee e2 = (Employee) session.load(Employee.class, 117);
		//System.out.println("Loaded Employee from DB with Id : " + e2.getLastName()); // Throws ObjectNotFoundException
		System.out.println("Loaded Employee from DB with Id : " + e2.getId()); // Works fine as only Id is accessed and displays 117

		Employee e3 = (Employee) session.get(Employee.class, 115); // Throws ObjectNotFoundException here itself if id not found
		System.out.println("Get Employee from DB with Id : " + e3.getId()); // Displays 115
		
		
		t.commit();// transaction is commited
		session.close();

		// Merge - Used to attach a detached entity, here e3 to a persistent state
		Session session1 = factory.openSession();
		session1.beginTransaction();
		e3.setLastName("Venky");
		
		session1.merge(e3); // can use session1.update(e3) also to make a detached entity to persistent state
		session1.getTransaction().commit();
		System.out.println("Merged Employee from DB with Id : " + e3.getLastName()); // Displays Venky
		
		session1.close();
		factory.close();// If this statement is not present, then the program will be running for ever
		
		// Refresh - Used to do the opposite to update() that is, get the entity in sync with the outdated entity state 
		// flush() - used to force the session data to synchronize with database. Commit does flush the session, but it also ends the unit of work.
		// replicate() - Persist the state of the given detached instance, reusing the current identifier value
		
		System.out.println("successfully saved");

	}
}