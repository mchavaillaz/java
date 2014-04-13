package ch.ne.ceg.hibernate.helloworld.annotation.onetomany.bidirectional;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ch.ne.ceg.hibernate.helloworld.annotation.onetomany.bidirectional.Contenu;
import ch.ne.ceg.hibernate.helloworld.annotation.onetomany.bidirectional.Stock;
import ch.ne.ceg.hibernate.helloworld.annotation.onetomany.bidirectional.Tools;

/**
 * @author mchavaillaz
 * Description: Use hibernate persistence with annotations in a bidirectional relationship between Stock and Contenu
 */
public class MainAppAnnotation {
	
public static void main(String[] args) {
		
		////////////// Hibernate Session Configuration //////////////////
		SessionFactory sf = Tools.getSession();

		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		////////////// END Hibernate Session Configuration //////////////////

		////////////// Hibernate Adding Row //////////////////
		// Create Stock
		Stock stock = new Stock();
		stock.setStockCode("332211");
		stock.setStockName("Stock annot 1-n Bi");

		// Create Contenu1
		Contenu contenu1 = new Contenu();
		contenu1.setContenuName("c1 annot. 1-n Bi");

		// Create Contenu2
		Contenu contenu2 = new Contenu();
		contenu2.setContenuName("c2 annot. 1-n Bi");
		
		// Adding Stock to the Contenu1 and Contenu2
		contenu1.setStock(stock);
		contenu2.setStock(stock);
		
		// Adding Contenu1 and Contenu2 to Stock
		stock.addContenu(contenu1);
		stock.addContenu(contenu2);

		// Save the Stock and return his id
		int stockId = (Integer)ss.save(stock);
		
		////////////// END Hibernate Adding Row //////////////////

		////////////// Query with HQL //////////////////
		String hqlStock = "FROM Stock AS s WHERE s.stockId = :stockId";
		List resHqlStock = ss.createQuery(hqlStock).setParameter("stockId", stockId).list();
		System.out.println("############ Request with HQL ############");
		Tools.printResultQueryFromStock(resHqlStock);
		////////////// END Query with HQL //////////////////

		////////////// Query with Criteria //////////////////
		Criteria crStock = ss.createCriteria(ch.ne.ceg.hibernate.helloworld.annotation.onetomany.bidirectional.Stock.class);
		crStock.add(Restrictions.eq("stockId", stockId));
		List resStock = crStock.list();
		System.out.println("############ Request with CRITERIA ############");
		Tools.printResultQueryFromStock(resStock);
		////////////// End Criteria //////////////////
		
		////////////// Query with HQL Finding Stock by querying Contenu //////////////////
		String hqlContenu = "FROM Contenu AS c WHERE c.contenuId = :contenuId";
		List resHqlContenu = ss.createQuery(hqlContenu).setParameter("contenuId", 183).list();
		System.out.println("############ Request with HQL Finding Stock by querying Contenu ############");
		Tools.printResultQueryFromContenu(resHqlContenu);
		////////////// END Query with HQL //////////////////

		// Closing Transaction and Session
		tr.commit();
		ss.close();
		System.exit(0);
	}
}
