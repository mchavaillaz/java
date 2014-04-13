
package ch.hearc.orlac.view.jpanel.information;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * {@link JPanel} display a colored state: KO in red and OK in green as information.
 * @author chavailm
 */
public class JPanelColoredState extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelColoredState()
		{
		createComponents();
		addComponents();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	/**
	 * Sets the colored state to KO in red.
	 */
	public void setColoredStateKO()
		{
		this.lblColoredState.setText("KO");
		this.lblColoredState.setForeground(Color.RED);
		}

	/**
	 * Sets the colored state to OK in green.
	 */
	public void setColoredStateOK()
		{
		this.lblColoredState.setText("OK");
		this.lblColoredState.setForeground(Color.GREEN);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components containted in the {@link JPanelColoredState}.
	 */
	private void createComponents()
		{
		this.lblColoredState = new JLabel("KO");
		this.lblColoredState.setForeground(Color.RED);
		}

	/**
	 * Adds the components in the {@link JPanelColoredState} Layout.
	 */
	private void addComponents()
		{
		this.add(this.lblColoredState);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JLabel lblColoredState;
	}
