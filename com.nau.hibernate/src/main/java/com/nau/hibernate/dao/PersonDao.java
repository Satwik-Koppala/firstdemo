package com.nau.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nau.hibernate.entity.Person;
import com.nau.hibernate.util.HibernateUtil;

public class PersonDao {
	
	SessionFactory factory = HibernateUtil.getFactory();
	
	public void addPerson(Person person) {
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(person);
		
		tx.commit();
		session.close();
	}

}
