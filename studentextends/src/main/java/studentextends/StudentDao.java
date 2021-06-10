package studentextends;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class StudentDao {

	private SessionFactory factory = StudentUtil.getFactory();

	public void addstudent(Student student) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		session.save(student);

		tx.commit();
		session.close();
	}

	public void updatestudent(Student student) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		session.saveOrUpdate(student);

		tx.commit();
		session.close();
	}

	public void deletestudent(Student student) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		session.delete(student);

		tx.commit();
		session.close();
	}

	public void getstudent(int id) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		Student st = session.load(Student.class, id);
		System.out.println(st);

		tx.commit();
		session.close();
	}

	public void getallstudent() {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		// String hql="from student s where s.id=3";
		// List<Student> slist = session.createQuery(hql).getResultList();

		List<Student> slist = session.createNativeQuery("select * from student").addEntity(Student.class).list();

		slist.forEach((s) -> {
			System.out.println(s);
		});

		tx.commit();
		session.close();
	}

	public void getbyname(String name) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		Query q = session.createNamedQuery("getbyname");
		q.setParameter("name", name);
		List<Student> slist = q.getResultList();
		
		slist.forEach((s) -> {System.out.println(s);});

		tx.commit();
		session.close();

	}
	
	public void getbycity(String city) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		Query q = session.createNamedQuery("getbycity");
		q.setParameter("city", city);
		List<Student> slist = q.getResultList();
		
		slist.forEach((s) -> {System.out.println(s);});

		tx.commit();
		session.close();

	}

}
