package net.codejava.CpefCategory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.codejava.Clistsys.Clistsys;

@Entity
@Table(name = "cperf_category")
public class CpefCategory {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "period_type")
	private Clistsys type;
	
	@Column(name = "period_value")
	private int category;
	
	@ManyToOne
	@JoinColumn(name = "method")
	private Clistsys method;
	
}
