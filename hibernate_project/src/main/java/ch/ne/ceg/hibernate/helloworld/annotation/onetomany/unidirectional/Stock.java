package ch.ne.ceg.hibernate.helloworld.annotation.onetomany.unidirectional;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ch.ne.ceg.hibernate.helloworld.xmlconfig.Contenu;

@Entity
@Table(name="STOCK")
public class Stock {
	@Id
	@Column(name="STOCK_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int stockId;
	
	@Column(name="STOCK_NAME")
	private String stockName;
	
	@Column(name="STOCK_CODE")
	private String stockCode;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	// Join the column STOCK_ID in the Contenu table
	@JoinColumn(name="STOCK_ID")
	private Set<Contenu> stockContenu;

	public int getstockId() {
		return this.stockId;
	}

	public void setstockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
	public Set<Contenu> getStockContenu() {
		return stockContenu;
	}

	public void setStockContenu(Set<Contenu> stockContenu) {
		this.stockContenu = stockContenu;
	}
}
