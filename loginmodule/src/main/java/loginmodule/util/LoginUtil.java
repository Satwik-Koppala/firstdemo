package loginmodule.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import loginmodule.entity.Login;
import loginmodule.entity.User;

public class LoginUtil {

	private static SessionFactory factory;
	static {
		System.out.println("start");
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Login.class);
		configuration.addAnnotatedClass(User.class);
		configuration.configure("login.cfg.xml");
		factory = configuration.buildSessionFactory();
		System.out.println("end");
	}

	public static SessionFactory getFactory() {
		return factory;
	}
}
