package ch.ne.ceg.hibernate.helloworld.annotation.onetomany.unidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONTENU")
public class Contenu {
	@Id
	@Column(name="CONTENU_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int contenuId;
	
	@Column(name="CONTENU_NAME")
	private String contenuName;
	
	@Column(name="STOCK_ID")
	private int stockId;

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
