package net.codejava.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ruser_profile")
public class UserP {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "u_code")
	private String uCode;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "isAdminRole")
	private boolean isAdminRole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getuCode() {
		return uCode;
	}

	public void setuCode(String uCode) {
		this.uCode = uCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdminRole() {
		return isAdminRole;
	}

	public void setAdminRole(boolean isAdminRole) {
		this.isAdminRole = isAdminRole;
	}

	public UserP() {}

}
