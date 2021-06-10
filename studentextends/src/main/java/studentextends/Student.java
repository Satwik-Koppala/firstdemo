package studentextends;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@NamedQueries({ @NamedQuery(name="getbycity", query = "from Student s where s.address.city=:city")})
@NamedQuery(name="getbyname", query = "from Student s where s.name=:name")

public class Student {
	
	@Id
	private int id;
	
	private String name;
	
	@Embedded
	private Address address;

}
