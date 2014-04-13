
package ch.hearc.orlac.view.jpanel.controls.detection;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JPanel;

/**
 * {@link JPanel} contains {@link JPanelCircleSettings}.
 * @author chavailm
 */
public class JPanelDetectionSettings extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelDetectionSettings()
		{
		createComponents();
		addComponents();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the attribute {@link JPanelCircleSettings}.
	 * @return jPanelCircleSettings
	 */
	public JPanelCircleSettings getjPanelCircleSettings()
		{
		return this.jPanelCircleSettings;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components contains in the {@link JPanelDetectionSettings}.
	 */
	private void createComponents()
		{
		this.setLayout(new BorderLayout());

		this.jPanelCircleSettings = new JPanelCircleSettings();

		this.vBox = Box.createVerticalBox();
		}

	/**
	 * Adds the components in the {@link JPanelDetectionSettings} Layout.
	 */
	private void addComponents()
		{
		this.vBox.add(this.jPanelCircleSettings);

		this.add(this.vBox, BorderLayout.NORTH);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JPanelCircleSettings jPanelCircleSettings;

	private Box vBox;
	}
