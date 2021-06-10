package loginmodule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="User")
public class User {
	
	@Id
	@Column(name = "userid")
	private int userid;
	
	@Column(name = "Fname")
	private String Fname;
	
	@Column(name = "Lname")
	private String Lname;
	
	@Column(name = "Address")
	private String Address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "pincode")
	private int pincode;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "email")
	private String email;

}
