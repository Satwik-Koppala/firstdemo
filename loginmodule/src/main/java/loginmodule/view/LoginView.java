package loginmodule.view;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import loginmodule.dao.LoginDao;
import loginmodule.entity.Login;
import loginmodule.entity.User;
import loginmodule.service.Service;
import loginmodule.util.LoginUtil;

public class LoginView {

	private static SessionFactory factory = LoginUtil.getFactory();
	static Service service = new Service();

	public LoginView() {
		for (;;) {
			System.out.println("1. Login \n2. Resgister User\n3. EXIT");
			Scanner x = new Scanner(System.in);
			int a = x.nextInt();
			int count = 0, flag = 0;
			x.nextLine();
			if (a == 1) {
				for (;;) {
					System.out.println("Enter your Loginid");
					String id = x.nextLine();
					System.out.println("Enter you Password");
					String password = x.nextLine();
					Login login = service.getlogin(id);
					if (login == null) {
						System.out.println("Please Register");
						break;
					} else {
						if (login.getPassword().equals(password) == true) {
							if (login.getStatus().equals("locked")) {
								System.out.println("Your Account is Locked");
								break;
							} else if (login.getType().equals("Admin")) {
								for (;;) {
									System.out.println("Main Menu");
									System.out.println("1. Display All Users");
									System.out.println("2. Display Users from City");
									System.out.println("3. Display Locked Users");
									System.out.println("4. Exit");
									int b = x.nextInt();
									x.nextLine();
									if (b == 1) {
										List<Login> loginlist = service.getAllLogin();
										loginlist.forEach((s) -> {
											System.out.println(s);
										});
									} else if (b == 2) {
										System.out.println("Enter City Name: ");
										String city = x.nextLine();
										List<Login> citylist = service.getByCity(city);
										if (citylist.size() == 0) {
											System.out.println("No users from city '" + city + "'");

										} else {
											citylist.forEach((s) -> {
												System.out.println(s);
											});
											for (int j = 0; j < 100; j++) {
												System.out.println(
														"Enter UserId to Unlock the Account or Enter 0 to go to MainMenu");
												String userid = x.nextLine();
												if (userid.equals("0") == true) {
													break;
												}
												if (service.updatestatus(login, "unlocked")) {
													System.out.println("Successfully Unlocked ");
												}
											}
										}
									} else if (b == 3) {
										List<Login> locklist = service.getByLocked("locked");
										if (locklist.size() == 0) {
											System.out.println("No Locked Users");
										} else {
											locklist.forEach((s) -> {
												System.out.println(s);
											});
											for (int j = 0; j < 100; j++) {
												System.out.println(
														"Enter UserId to Unlock the Account or Enter 0 to go to MainMenu");
												int userid = x.nextInt();
												if (userid == 0) {
													break;
												}
												if (service.updateuserid(userid)) {
													System.out.println("Successfully Unlocked ");
												}
											}
										}
									} else if (b == 4) {
										flag = 1;
										break;
									}
								}
							} else {
								System.out.println(
										"Welcome " + login.getUser().getFname() + " " + login.getUser().getLname());
								System.out.println("Address: " + login.getUser().getAddress());
								System.out.println("City: " + login.getUser().getCity());
								System.out.println("Pincode: " + login.getUser().getPincode());
								System.out.println("Country: " + login.getUser().getCountry());
								System.out.println("Email: " + login.getUser().getEmail());

								for (;;) {
									System.out.println("1.Update Password ");
									System.out.println("2.Update Details ");
									System.out.println("3.EXIT ");
									int c = x.nextInt();
									x.nextLine();
									if (c == 1) {
										for (;;) {
											System.out.println("Please Enter Old Password");
											String oldp = x.nextLine();
											if (oldp.equals(login.getPassword()) == false) {
												continue;
											}
											System.out.println("Enter New Password");
											String newp = x.nextLine();
											if (oldp.equals(newp) == true) {
												System.out.println("Invalid...Try Again");
											} else {
												service.updatepassword(login, newp);
												System.out.println("Password Changed Successfully");
												break;
											}
										}
									} else if (c == 2) {

										System.out.println("Enter the first name");
										String Fname = x.nextLine();
										System.out.println("Enter the last name");
										String Lname = x.nextLine();
										System.out.println("Enter the address");
										String Address = x.nextLine();
										System.out.println("Enter the city");
										String city = x.nextLine();
										System.out.println("Enter the country");
										String country = x.nextLine();
										System.out.println("Enter the pincode");
										int pincode = x.nextInt();
										x.nextLine();
										System.out.println("Enter the email");
										String email = x.nextLine();

										if (service.updateUser(login.getUser().getUserid(), Fname, Lname, Address, city,
												country, pincode, email)) {
											System.out.println("Successfully Updated");
										}
									} else if (c == 3) {
										flag = 1;
										break;
									}
								}
							}
						} else {
							count++;
							if (count == 3) {
								System.out.println("Your account has been locked...!");
								service.updatestatus(login, "locked");
								break;
							}
							System.out.println("Please enter your details again");
						}
					}
					if (flag == 1) {
						break;
					}
				}
			}
			if (a == 2) {
				System.out.println("-------Welcome to Registration Form-------");
				String id;
				for (;;) {
					System.out.println("Please enter Login id with 6 characters( A to Z or 0-9):");
					id = x.nextLine();
					if(service.validate(id)) {
						break;
					}
				}
				String password;
				for (;;) {
					System.out.println("Please enter Login id with 6 characters( A to Z or 0-9):");
					password = x.nextLine();
					if(service.validate(password)) {
						break;
					}
				}
				System.out.println("Enter the Type /n1. Admin/n2. Normal");
				int Type = x.nextInt();
				x.nextLine();

				System.out.println("Enter Userid");
				int userid = x.nextInt();
				x.nextLine();

				System.out.println("Enter First Name");
				String Fname = x.nextLine();

				System.out.println("Enter Last Name");
				String Lname = x.nextLine();

				System.out.println("Enter Address");
				String address = x.nextLine();

				System.out.println("Enter City");
				String city = x.nextLine();

				System.out.println("Enter Country");
				String country = x.nextLine();

				System.out.println("Enter Pincode");
				int pin = x.nextInt();
				x.nextLine();

				System.out.println("Enter Email");
				String email = x.nextLine();

				if (service.addlogin(id, password, userid, Type, Fname, Lname, address, city, country, pin, email)) {
					System.out.println("Registered Successfully");
				}
			}
			if (flag == 1 || a == 3) {
				System.out.println("Thank You...!");
				break;
			}
		}
	}
}