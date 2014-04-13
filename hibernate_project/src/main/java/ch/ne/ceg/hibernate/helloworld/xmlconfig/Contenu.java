package ch.ne.ceg.hibernate.helloworld.xmlconfig;

public class Contenu {
	private int contenuId;
	private int stockId;
	private String contenuName;
	
	public Contenu(){
		// Empty
	}

	public Contenu(String contenuName) {
		this.contenuName = contenuName;
	}

	public int getContenuId() {
		return contenuId;
	}

	public void setContenuId(int contenuId) {
		this.contenuId = contenuId;
	}

	public String getContenuName() {
		return contenuName;
	}

	public void setContenuName(String contenuName) {
		this.contenuName = contenuName;
	}
	
	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
}
