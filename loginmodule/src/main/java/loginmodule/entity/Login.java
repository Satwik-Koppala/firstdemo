package loginmodule.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Login")

@NamedQuery(name = "getbylock", query = "from Login l where l.status=:status")
@NamedQueries({ @NamedQuery(name = "getbycity", query = "from Login l where l.user.city=:city") })

public class Login {
	
	@Id
	@Column(length = 6)
	private String loginid;
	
	@Column(length = 6)
	private String password;
	
	@Column(length = 8)
	private String status;
	
	@Column(length = 8)
	private String type;
	
	@CreationTimestamp
	private Timestamp creationtime;

	@OneToOne
	@JoinColumn(name="userid")
	private User user;
	
}
