package net.codejava.ccurve;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.codejava.Clistsys.Clistsys;
import net.codejava.Rcurrency.Rcurrency;





@Entity
@Table(name = "ccurve")
public class Ccurve {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "is_visible")
	private boolean visible;
	
	@OneToOne
	@JoinColumn(name = "type_id")//String
	private Clistsys type;
	
	@OneToOne
	@JoinColumn(name = "source_id")//String
	private Ccurve source;
	
	@Column(name = "rate_type_id")//String
	private String rate;
	
	@OneToOne
	@JoinColumn(name = "currency_id")//String
	private Rcurrency currency;
	
	@Column(name = "matur_type_id")
	private String matur;
	
	@Column(name = "flatt_maturity")
	private Integer flatt1;
	
	@OneToOne
	@JoinColumn(name = "rf_currency_id")
	private Rcurrency rfcurrency;

	public Ccurve() {}

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

	public Clistsys getType() {
		return type;
	}

	public void setType(Clistsys type) {
		this.type = type;
	}

	public Ccurve getSource() {
		return source;
	}

	public void setSource(Ccurve source) {
		this.source = source;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public Rcurrency getCurrency() {
		return currency;
	}

	public void setCurrency(Rcurrency currency) {
		this.currency = currency;
	}

	public String getMatur() {
		return matur;
	}

	public void setMatur(String matur) {
		this.matur = matur;
	}

	public Integer getFlatt1() {
		return flatt1;
	}

	public void setFlatt1(Integer flatt1) {
		this.flatt1 = flatt1;
	}

	public Rcurrency getRfcurrency() {
		return rfcurrency;
	}

	public void setRfcurrency(Rcurrency rfcurrency) {
		this.rfcurrency = rfcurrency;
	}

	
}
