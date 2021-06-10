package loginmodule.service;

import java.util.List;

import loginmodule.dao.LoginDao;
import loginmodule.entity.Login;
import loginmodule.entity.User;

public class Service {
	LoginDao dao = new LoginDao();

	public Login getlogin(String id) {
		Login login = dao.getlogin(id);
		return login;
	}

	public boolean addlogin(String id, String password,int userid, int type, String Fname, String Lname, String address,
			String city, String country, int pin, String email) {
		Login log = new Login();
		log.setLoginid(id);
		log.setPassword(password);
		log.setCreationtime(new java.sql.Timestamp(new java.util.Date().getTime()));
		log.setStatus("unlocked");
		String Type;
		if(type==1) {
			Type="Admin";
		}else {
			Type="Normal";
		}
		log.setType(Type);

		User user = new User();
		user.setUserid(userid);
		user.setFname(Fname);
		user.setLname(Lname);
		user.setAddress(address);
		user.setCity(city);
		user.setCountry(country);
		user.setPincode(pin);
		user.setEmail(email);
		log.setUser(user);
		if (dao.addlogin(log, user)) {
			return true;
		}
		return false;
	}

	public List<Login> getAllLogin() {
		List<Login> loginlist = dao.getAllLogins();
		return loginlist;
	}

	public List<Login> getByCity(String city) {

		List<Login> citylist = dao.getByCity(city);
		return citylist;
	}

	public boolean updatestatus(Login login, String string) {

		if (dao.updatestatus(login, string)) {
			return true;
		}
		return false;

	}

	public List<Login> getByLocked(String string) {
		List<Login> locklist = dao.getByLocked(string);
		return locklist;

	}

	public boolean updateuserid(int userid) {
		if (dao.updateuserid(userid)) {
			return true;
		}
		return false;
	}

	public boolean updateUser(int userid, String Fname, String Lname, String Address, String city, String country,
			int pincode, String email) {
		User user = new User();
		user.setUserid(userid);
		user.setAddress(Address);
		user.setCity(city);
		user.setCountry(country);
		user.setEmail(email);
		user.setFname(Fname);
		user.setLname(Lname);
		user.setPincode(pincode);
		if (dao.updateUser(user)) {
			return true;
		}
		return false;
	}

	public void updatepassword(Login login, String newp) {
		dao.updatepassword(login, newp);
	}

	public boolean validate(String string) {
		for(int i=0;i<string.length();i++) {
			if(('A'<=string.charAt(i) && string.charAt(i)<='Z') || ('0'<=string.charAt(i) && string.charAt(i)<='9')) {
				continue;		
			}
			else {
				return false;
			}
		}
		return true;
	}

}
