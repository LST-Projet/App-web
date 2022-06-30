package net.codejava.CpnlSetting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cpnl_setting")
public class CpnlSetting {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "is_visible")
	private boolean visible;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	

}
