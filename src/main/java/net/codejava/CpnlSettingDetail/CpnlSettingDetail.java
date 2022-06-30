package net.codejava.CpnlSettingDetail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.codejava.Clistcust.Clistcust;
import net.codejava.Clistsys.Clistsys;
import net.codejava.CpnlSetting.CpnlSetting;

@Entity
@Table(name = "cpnl_setting_detail")
public class CpnlSettingDetail {

	/*@Id
	private String id;*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "pnl_setting_id")
	private CpnlSetting pnlSetting;  //String
	
	@OneToOne
	@JoinColumn(name = "class_id")  //String
	private Clistsys class1;

	@OneToOne
	@JoinColumn(name = "category_id")
	private Clistcust category;
	
	@OneToOne
	@JoinColumn(name = "inventory_meth_id")
	private Clistsys inventory;
	
	@Column(name = "is_gross_mode")
	private boolean gross;
	
	@Column(name = "is_provisioned")
	private boolean provisioned;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CpnlSetting getPnlSetting() {
		return pnlSetting;
	}

	public void setPnlSetting(CpnlSetting pnlSetting) {
		this.pnlSetting = pnlSetting;
	}

	public Clistsys getClass1() {
		return class1;
	}

	public void setClass1(Clistsys class1) {
		this.class1 = class1;
	}

	public Clistcust getCategory() {
		return category;
	}

	public void setCategory(Clistcust category) {
		this.category = category;
	}

	public Clistsys getInventory() {
		return inventory;
	}

	public void setInventory(Clistsys inventory) {
		this.inventory = inventory;
	}

	public boolean isGross() {
		return gross;
	}

	public void setGross(boolean gross) {
		this.gross = gross;
	}

	public boolean isProvisioned() {
		return provisioned;
	}

	public void setProvisioned(boolean provisioned) {
		this.provisioned = provisioned;
	}
	
	/*@Column(name="provision_rate")
	private int provision;*/
 
	/*	public int getProvision() {
	return provision;
}

public void setProvision(int provision) {
	this.provision = provision;
}*/
}