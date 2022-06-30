package net.codejava.Clistsys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "clistsys")
public class Clistsys {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "list_name")
	private String listname;
	
	@Column(name = "visible")
	private boolean visible;
	
	@Column(name = "sorting")
	private int sorting;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getListname() {
		return listname;
	}

	public void setListname(String listname) {
		this.listname = listname;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getSorting() {
		return sorting;
	}

	public void setSorting(int sorting) {
		this.sorting = sorting;
	}

	public Clistsys() {}
	
	
}
