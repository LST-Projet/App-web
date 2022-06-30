package net.codejava.CinputControl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.codejava.Clistsys.Clistsys;

@Entity
@Table(name = "cinput_control")
public class CinputControl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "menu_id")
	private String menu;
	
	@Column(name = "criter_filed")
	private String Crfiled;
	
	@Column(name = "criter_value")
	private String Crvalue;
	
	@Column(name = "field_id")
	private String Fid;
	
	@Column(name = "field_name")
	private String Fname;
	
	@Column(name = "is_mandatory")
	private boolean mandatory;
	
	@Column(name = "limit_min")
	private Integer min;
	
	@Column(name = "limit_max")
	private Integer max;
	
	@Column(name = "default_value")
	private String Dvalue;
	
	@Column(name = "sorting")
	private int sorting;
	
	@Column(name = "is_system")
	private boolean system;
	
	@Column(name = "operator")
	private String operator; //enum('=','!=','>','<','>=','<=','IN','N_IN')
	
	@Column(name = "value")
	private String value;
	
	@OneToOne
	@JoinColumn(name = "data_type_id")
	private Clistsys Cdata;
	
	@OneToOne
	@JoinColumn(name = "value_type_id")
	private Clistsys Cvalue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getCrfiled() {
		return Crfiled;
	}

	public void setCrfiled(String crfiled) {
		Crfiled = crfiled;
	}

	public String getCrvalue() {
		return Crvalue;
	}

	public void setCrvalue(String crvalue) {
		Crvalue = crvalue;
	}

	public String getFid() {
		return Fid;
	}

	public void setFid(String fid) {
		Fid = fid;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public String getDvalue() {
		return Dvalue;
	}

	public void setDvalue(String dvalue) {
		Dvalue = dvalue;
	}

	public int getSorting() {
		return sorting;
	}

	public void setSorting(int sorting) {
		this.sorting = sorting;
	}

	public boolean isSystem() {
		return system;
	}

	public void setSystem(boolean system) {
		this.system = system;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Clistsys getCdata() {
		return Cdata;
	}

	public void setCdata(Clistsys cdata) {
		Cdata = cdata;
	}

	public Clistsys getCvalue() {
		return Cvalue;
	}

	public void setCvalue(Clistsys cvalue) {
		Cvalue = cvalue;
	}

	public CinputControl() {}
	
}
