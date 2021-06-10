package com.nau.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nau.hibernate.entity.Person;

public class HibernateUtil {

	
	private static SessionFactory factory;
	static {
		System.out.println("start");
 
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Person.class);
		configuration.configure();

		factory = configuration.buildSessionFactory();
	
		System.out.println("end");
	}
	public static SessionFactory getFactory() {
		return factory;
	}

}
