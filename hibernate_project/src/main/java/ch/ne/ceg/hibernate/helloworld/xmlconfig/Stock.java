package ch.ne.ceg.hibernate.helloworld.xmlconfig;

import java.util.Set;

public class Stock {

	private int stockId;
	private String stockName;
	private String stockCode;
	private Set<Contenu> stockContenu;

	public Stock() {
		// Empty
	}

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
