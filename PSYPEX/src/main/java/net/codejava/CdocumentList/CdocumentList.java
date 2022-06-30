package net.codejava.CdocumentList;

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


@Entity
@Table(name = "cdocument_list")
public class CdocumentList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "type_id")
	private Clistsys type;
	
	@OneToOne
	@JoinColumn(name = "category_id")
	private Clistcust category;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "is_mandatory")
	private boolean mandatory;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Clistsys getType() {
		return type;
	}

	public void setType(Clistsys type) {
		this.type = type;
	}

	public Clistcust getCategory() {
		return category;
	}

	public void setCategory(Clistcust category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}
	
}
