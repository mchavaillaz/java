
package ch.hearc.orlac.view.jpanel.information;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Contains the He-Arc logo.
 * @author chavailm
 */
public class JPanelLogo extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelLogo()
		{
		createComponents();
		addComponents();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components contained in the {@link JPanelLogo}.
	 */
	private void createComponents()
		{
		URL imgURL = getClass().getResource("./image/ING_LOGO.png");
		this.logo = new ImageIcon(imgURL);

		this.lblLogo = new JLabel("", this.logo, SwingConstants.CENTER);
		}

	/**
	 * Adds the component in the {@link JPanelLogo} layout.
	 */
	private void addComponents()
		{
		this.add(this.lblLogo);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	// Tools
	private ImageIcon logo;
	private JLabel lblLogo;
	}
