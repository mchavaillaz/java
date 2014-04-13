package ch.ne.ceg.hibernate.helloworld.annotation.onetomany.bidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name="STOCK_ID")
	private Stock stock;

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
	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
}
