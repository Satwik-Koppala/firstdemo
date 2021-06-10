package loginmodule.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import loginmodule.entity.Login;
import loginmodule.entity.User;
import loginmodule.util.LoginUtil;

public class LoginDao {
	private static SessionFactory factory = LoginUtil.getFactory();

	public Login getlogin(String loginid) {
		Session session = factory.openSession();
		
		Login login = session.get(Login.class, loginid);
		
		session.close();

		return login;
	}

	public boolean addlogin(Login login, User user) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		session.save(login);
		session.save(user);

		tx.commit();
		session.close();
		return true;
	}

	public List<Login> getAllLogins() {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		List<Login> slist = session.createNativeQuery("select * from Login").addEntity(Login.class).list();
		
		tx.commit();
		session.close();
		
		return slist;
	}

	public boolean updateuserid(int id) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Query q3 = session.createQuery("update Login s set s.status = 'unlocked' where s.user.userid="+id);
		q3.executeUpdate();
		tx.commit();
		session.close();
		
		return true;
		
	}

	public List<Login> getByCity(String city) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		Query q = session.createNamedQuery("getbycity");
		q.setParameter("city", city);
		List<Login> citylist = q.getResultList();
		
		tx.commit();
		session.close();
		
		return citylist;
	}

	public List<Login> getByLocked(String lock) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		Query q = session.createNamedQuery("getbylock");
		q.setParameter("status", lock);
		List<Login> locklist = q.getResultList();
		
		tx.commit();
		session.close();
		return locklist;
	}

	public void updatepassword(Login login, String newp) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		login.setPassword(newp);
		session.saveOrUpdate(login);

		tx.commit();
		session.close();
	}

	public boolean updatestatus(Login login, String string) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		login.setStatus(string);
		session.saveOrUpdate(login);

		tx.commit();
		session.close();
		return true;
		
	}

	public boolean updateUser(User user) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		session.saveOrUpdate(user);

		tx.commit();
		session.close();
		return true;
	}

}
