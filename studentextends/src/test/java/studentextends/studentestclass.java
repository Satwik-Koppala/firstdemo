package studentextends;

import org.junit.jupiter.api.Test;

public class studentestclass {

	//@Test
	void testGetFactory() {
		StudentUtil.getFactory();
	}

	//@Test
	void addstudent() {
		StudentDao dao = new StudentDao();
		dao.addstudent(new Student(2, "satwik", new Address("pune", 530017)));
	}

	// @Test
	void updatstudent() {
		StudentDao dao = new StudentDao();
		dao.updatestudent(new Student(2, "satwik", new Address("pune", 530017)));
	}

	// @Test
	void deletestudent() {
		StudentDao dao = new StudentDao();
		dao.deletestudent(new Student(2, "satwik", new Address("pune", 530017)));
	}

	// @Test
	void getallstudent() {
		StudentDao dao = new StudentDao();
		dao.getallstudent();
	}

	// @Test
	void getstudent() {
		StudentDao dao = new StudentDao();
		dao.getstudent(1);
	}

	// @Test
	void getbyname() {
		StudentDao dao = new StudentDao();
		dao.getbyname("kivtas");
	}
	
	@Test
	void getbycity() {
		StudentDao dao=new StudentDao();
		dao.getbycity("pune");
	}

}
