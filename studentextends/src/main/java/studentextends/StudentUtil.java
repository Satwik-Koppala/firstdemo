package studentextends;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentUtil {
	
	private static SessionFactory factory; 
	static {
		System.out.println("factory started");
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Student.class);
		configuration.configure("student.cfg.xml");// load cfg.xml
		factory =configuration.buildSessionFactory();
		System.out.println("factory returned");
	}
	public static SessionFactory getFactory() {
		return factory;
	}
}
