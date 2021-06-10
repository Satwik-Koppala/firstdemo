package com.nau.hibernate;

import org.junit.jupiter.api.Test;

import com.nau.hibernate.dao.PersonDao;
import com.nau.hibernate.entity.Person;
import com.nau.hibernate.util.HibernateUtil;

class HibernateUtilTest {

	@Test
	void testHibernateUtil() {
		new HibernateUtil();
	}
	
	@Test
	void testaddPerson() {
		PersonDao dao = new PersonDao();
		Person person = new Person(4,"Kivtas","Visakha"); 
		dao.addPerson(person);
	}

}
