package net.codejava.CWarning;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.codejava.Clistsys.Clistsys;
import net.codejava.RuserProfile.RuserProfile;

@Entity
@Table(name = "cwarning")
public class CWarning {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "nature_id")
	private Clistsys nature;
	
	@ManyToOne
	@JoinColumn(name = "proc_profile_id")
	private RuserProfile proc;
	
	@ManyToOne
	@JoinColumn(name = "view_profile_id")
	private RuserProfile view;
	
	@Column(name = "short_msg")
	private String msg;
	
	@Column(name = "is_with_notif")
	private boolean notif;
	
	@Column(name = "mail_subject")
	private String Msubject;
	
	@Column(name = "mail_body")
	private String Mbody;
	
	@Column(name = "mail_cc")
	private String Mcc;
	
	@Column(name = "mail_bcc")
	private String Mbc;
	
	@Column(name = "advance_days")
	private int Dadvance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Clistsys getNature() {
		return nature;
	}

	public void setNature(Clistsys nature) {
		this.nature = nature;
	}

	public RuserProfile getProc() {
		return proc;
	}

	public void setProc(RuserProfile proc) {
		this.proc = proc;
	}

	public RuserProfile getView() {
		return view;
	}

	public void setView(RuserProfile view) {
		this.view = view;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isNotif() {
		return notif;
	}

	public void setNotif(boolean notif) {
		this.notif = notif;
	}

	public String getMsubject() {
		return Msubject;
	}

	public void setMsubject(String msubject) {
		Msubject = msubject;
	}

	public String getMbody() {
		return Mbody;
	}

	public void setMbody(String mbody) {
		Mbody = mbody;
	}

	public String getMcc() {
		return Mcc;
	}

	public void setMcc(String mcc) {
		Mcc = mcc;
	}

	public String getMbc() {
		return Mbc;
	}

	public void setMbc(String mbc) {
		Mbc = mbc;
	}

	public int getDadvance() {
		return Dadvance;
	}

	public void setDadvance(int dadvance) {
		Dadvance = dadvance;
	}

	public CWarning() {	}
	
	
}
