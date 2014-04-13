
package ch.hearc.orlac.view.jpanel.controls.detection;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;

import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * {@link JPanel} contains components to configure the circle detection settings.
 * @author chavailm
 */
public class JPanelCircleSettings extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelCircleSettings()
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
	 * Gets the attribute {@link JPanelSpinner}.
	 * @return JPanelSpinnerCircleNumber
	 */
	public JPanelSpinner getJPanelSpinnerCircleNumber()
		{
		return this.JPanelSpinnerCircleNumber;
		}

	/**
	 * Gets the attribute {@link JPanelSpinner}.
	 * @return JPanelSpinnerCircleRadius
	 */
	public JPanelSpinner getJPanelSpinnerCircleRadius()
		{
		return this.JPanelSpinnerCircleRadius;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components contained in the {@link JPanelCircleSettings}.
	 */
	private void createComponents()
		{
		this.setLayout(new BorderLayout());

		this.setBorder(BorderFactory.createTitledBorder("Circle detection settings"));

		this.JPanelSpinnerCircleNumber = new JPanelSpinner("Number of circle", " ", Settings.JSPINNER_CIRCLE_NUMBER_VALUE_MIN, Settings.JSPINNER_CIRCLE_NUMBER_VALUE_MAX, Settings.JSPINNER_CIRCLE_NUMBER_VALUE_INIT, Settings.JSPINNER_CIRCLE_NUMBER_STEP);
		this.JPanelSpinnerCircleRadius = new JPanelSpinner("Circle radius", "mm", Settings.JSPINNER_CIRCLE_RADIUS_VALUE_MIN, Settings.JSPINNER_CIRCLE_RADIUS_VALUE_MAX, Settings.JSPINNER_CIRCLE_RADIUS_VALUE_INIT, Settings.JSPINNER_CIRCLE_RADIUS_STEP);

		this.vBox = Box.createVerticalBox();
		}

	/**
	 * Adds all the components in the {@link JPanelCircleSettings} layout.
	 */
	private void addComponents()
		{
		this.vBox.add(this.JPanelSpinnerCircleNumber);
		this.vBox.add(this.JPanelSpinnerCircleRadius);

		this.add(this.vBox, BorderLayout.NORTH);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JPanelSpinner JPanelSpinnerCircleNumber;

	private JPanelSpinner JPanelSpinnerCircleRadius;

	private Box vBox;
	}
