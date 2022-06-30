package net.codejava.Rcurrency;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rcurrency")
public class Rcurrency {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "num_code")
	private String numCode;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "visible")
	private boolean visible;
	
	@Column(name = "rate_decimal_nbr")
	private int rateDecimalNbr;
	
	@Column(name = "trade_unit")
	private int tradeUnnit;
	
	@Column(name = "default_decimal")
	private int defaultDecimal;
	
	public Rcurrency() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRateDecimalNbr() {
		return rateDecimalNbr;
	}

	public void setRateDecimalNbr(int rateDecimalNbr) {
		this.rateDecimalNbr = rateDecimalNbr;
	}

	public int getTradeUnnit() {
		return tradeUnnit;
	}

	public void setTradeUnnit(int tradeUnnit) {
		this.tradeUnnit = tradeUnnit;
	}

	public int getDefaultDecimal() {
		return defaultDecimal;
	}

	public void setDefaultDecimal(int defaultDecimal) {
		this.defaultDecimal = defaultDecimal;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
}
