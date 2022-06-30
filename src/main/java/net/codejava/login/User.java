package net.codejava.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ruser")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "u_code")
	private String uCode;
	
	@Column(name = "first_name")
	private String fname;
	
	@Column(name = "last_name")
	private String lname;
	
	@Column(name = "function_")
	private String function;
	
	@Column(name = "is_enabled")
	private int isEnabled;
	
	@OneToOne
	@JoinColumn(name = "profile_id")
	private UserP ruserProfile;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "is_signatory")
	private int isSignatory;
	
	@Column(name = "password_date")
	private String passwordDate;
	
	@Column(name = "grace_date")
	private String graceDate;
	
	@Column(name = "failed_attempts")
	private String failedAttempts;

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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public int getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(int isEnabled) {
		this.isEnabled = isEnabled;
	}

	public UserP getRuserProfile() {
		return ruserProfile;
	}

	public void setRuserProfile(UserP ruserProfile) {
		this.ruserProfile = ruserProfile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsSignatory() {
		return isSignatory;
	}

	public void setIsSignatory(int isSignatory) {
		this.isSignatory = isSignatory;
	}

	public String getPasswordDate() {
		return passwordDate;
	}

	public void setPasswordDate(String passwordDate) {
		this.passwordDate = passwordDate;
	}

	public String getGraceDate() {
		return graceDate;
	}

	public void setGraceDate(String graceDate) {
		this.graceDate = graceDate;
	}

	public String getFailedAttempts() {
		return failedAttempts;
	}

	public void setFailedAttempts(String failedAttempts) {
		this.failedAttempts = failedAttempts;
	}

	public User() {}
	
	
}
