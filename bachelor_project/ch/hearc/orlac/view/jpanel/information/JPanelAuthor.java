
package ch.hearc.orlac.view.jpanel.information;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Contains author's informations.
 * @author chavailm
 */
public class JPanelAuthor extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelAuthor()
		{
		createComponents();
		addComponents();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components contained in the {@link JPanelAuthor}.
	 */
	private void createComponents()
		{
		this.lblAuthor = new JLabel("Created by: Matthieu Chavaillaz");
		this.lblDate = new JLabel("Date: 12.07.2013");
		}

	/**
	 * Adds the component in the {@link JPanelAuthor} layout.
	 */
	private void addComponents()
		{
		this.add(this.lblAuthor);
		this.add(this.lblDate);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	// Tools
	private JLabel lblAuthor;
	private JLabel lblDate;
	}
