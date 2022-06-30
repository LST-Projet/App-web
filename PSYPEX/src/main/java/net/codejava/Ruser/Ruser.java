package net.codejava.Ruser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.codejava.RuserProfile.RuserProfile;

@Entity
@Table(name = "ruser")
public class Ruser {

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
	private boolean Enabled;
	
	@OneToOne
	@JoinColumn(name = "profile_id")
	private RuserProfile ruserProfile;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "is_signatory")
	private boolean Signatory;
	
	@Column(name = "password_date")
	private String passwordDate;
	
	@Column(name = "grace_date")
	private String graceDate;
	
	@Column(name = "failed_attempts")
	private Integer failedAttempts;

	public Ruser() {}

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

	public RuserProfile getRuserProfile() {
		return ruserProfile;
	}

	public void setRuserProfile(RuserProfile ruserProfile) {
		this.ruserProfile = ruserProfile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Integer getFailedAttempts() {
		return failedAttempts;
	}

	public void setFailedAttempts(Integer failedAttempts) {
		this.failedAttempts = failedAttempts;
	}

	public boolean isEnabled() {
		return Enabled;
	}

	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}

	public boolean isSignatory() {
		return Signatory;
	}

	public void setSignatory(boolean signatory) {
		Signatory = signatory;
	}

	
}
