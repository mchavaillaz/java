package ch.ne.ceg.hibernate.helloworld.annotation.onetomany.bidirectional;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author mchavaillaz
 * Description: Contains useful methods
 */
public class Tools {
	
	/**
	 * Description: Print the result of a query of a List<Stock> with his Set<Contenu>
	 * @param resultList: List<Stock> to print
	 */
	public static void printResultQueryFromStock(List<Stock> resultList) {
		Iterator<Stock> itRes = resultList.iterator();

		// Iterate over List<Stock>
		while (itRes.hasNext()) {
			Stock stk = (Stock) itRes.next();

			System.out.println("Stock id: " + stk.getstockId());
			System.out.println("Stock code: " + stk.getStockCode());
			System.out.println("Stocke name: " + stk.getStockName());

			// Try to get the Set<Contenu> for the current Stock if exist
			try {
				Set<Contenu> contenus = stk.getStockContenu();

				Iterator<Contenu> itContenus = contenus.iterator();

				while (itContenus.hasNext()) {
					Contenu ctn = (Contenu) itContenus.next();

					System.out.println("Contenu id: " + ctn.getContenuId());
					System.out.println("Contenu name: " + ctn.getContenuName());
				}

			} catch (Exception e) {
				System.err.println("Tools.java printResultQuery() No Contenu available " + e.toString());
			}
		}
	}
	
	/**
	 * Description: Print the result of a query of a List<Contenu> with his Stock
	 * @param resultList: List<Contenu> to print
	 */
	public static void printResultQueryFromContenu(List<Contenu> resultList){
		Iterator<Contenu> itRes = resultList.iterator();
		
		if(itRes.hasNext()){
			Contenu ctn = itRes.next();
			Stock stk = ctn.getStock();
			System.out.println("Stock id: " + stk.getstockId());
			System.out.println("Stock code: " + stk.getStockCode());
			System.out.println("Stock name: " + stk.getStockName());
		}
	}
	
	/**
	 * Create and configure the SessionFactory for the DB
	 * @return SessionFactory
	 */
	public static SessionFactory getSession(){
		Configuration cfg = new Configuration();
		cfg.configure();
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		return(cfg.buildSessionFactory(sr));
	}
}
