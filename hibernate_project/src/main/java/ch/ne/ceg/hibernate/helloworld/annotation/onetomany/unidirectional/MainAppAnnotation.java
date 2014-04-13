package ch.ne.ceg.hibernate.helloworld.annotation.onetomany.unidirectional;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ch.ne.ceg.hibernate.helloworld.annotation.onetomany.unidirectional.Tools;

/**
 * @author mchavaillaz
 * Description: Use hibernate persistence with annotations mapping in a unidirectional relationship between Stock and Contenu
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
		stock.setStockName("Stock ANNOTATION");

		// Save the new Stocks and getting the new ids
		int stockId = (Integer) ss.save(stock);

		// Create Contenu1 with the new stockId
		Contenu contenu1 = new Contenu();
		contenu1.setStockId(stockId);
		contenu1.setContenuName("Contenu1 ANNOTATION");

		// Create Contenu2 with the new stockId
		Contenu contenu2 = new Contenu();
		contenu2.setStockId(stockId);
		contenu2.setContenuName("Contenu2 ANNOTATION");

		// Save the Contenus
		ss.save(contenu1);
		ss.save(contenu2);
		////////////// END Hibernate Adding Row //////////////////

		////////////// Query with HQL //////////////////
		String hqlStock = "FROM Stock AS s WHERE s.stockId = :stockId";
		List resHqlStock = ss.createQuery(hqlStock).setParameter("stockId", stockId).list();
		System.out.println("############ Request with HQL ############");
		Tools.printResultQuery(resHqlStock);
		////////////// END Query with HQL //////////////////

		////////////// Query with Criteria //////////////////
		Criteria crStock = ss.createCriteria(ch.ne.ceg.hibernate.helloworld.xmlconfig.Stock.class);
		crStock.add(Restrictions.eq("stockId", stockId));
		List resStock = crStock.list();
		System.out.println("############ Request with CRITERIA ############");
		Tools.printResultQuery(resStock);
		////////////// End Criteria //////////////////

		// Closing Transaction and Session
		tr.commit();
		ss.close();
		System.exit(0);
	}
}
