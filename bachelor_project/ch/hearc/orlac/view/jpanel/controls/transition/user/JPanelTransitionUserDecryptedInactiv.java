
package ch.hearc.orlac.view.jpanel.controls.transition.user;

import java.awt.BorderLayout;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import ch.hearc.orlac.data.transition.TransitionSettingsUserDecryptedInactiv;
import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.tools.JPanelSlider;
import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * {@link JPanel} to configure the inactiv time allowed in the STATE_USER_DECRYPTED.
 * @author chavailm
 */
public class JPanelTransitionUserDecryptedInactiv extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelTransitionUserDecryptedInactiv()
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
	 * Sets the {@link TransitionSettingsUserDecryptedInactiv} to the {@link JSpinner} and the {@link JPanelSlider}.
	 * @param _transitionUserDecryptedInactiv
	 */
	public void setTransitionSettings(TransitionSettingsUserDecryptedInactiv _transitionUserDecryptedInactiv)
		{
		this.jPanelSliderEnergyToGive.setTransitionSettings(_transitionUserDecryptedInactiv);
		this.jPanelSpinnerTransitionDuration.setTransitionSettings(_transitionUserDecryptedInactiv);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the attribute {@link JPanelSpinner}.
	 * @return jPanelSpinnerTransitionDuration
	 */
	public JPanelSpinner getjPanelSpinnerTransitionDuration()
		{
		return this.jPanelSpinnerTransitionDuration;
		}

	/**
	 * Gets the attribute {@link JPanelSlider}.
	 * @return jPanelSliderEnergyToGive
	 */
	public JPanelSlider getjPanelSliderEnergyToGive()
		{
		return this.jPanelSliderEnergyToGive;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components containted in the {@link JPanelTransitionUserDecryptedInactiv}.
	 */
	private void createComponents()
		{
		this.setLayout(new BorderLayout());

		this.setBorder(BorderFactory.createTitledBorder("Inactiv duration in USER DECRYPTED state"));
		this.jPanelSpinnerTransitionDuration = new JPanelSpinner("Duration", "seconds", Settings.JSPINNER_TRANSITION_DURATION_VALUE_MIN, Settings.JSPINNER_TRANSITION_DURATION_VALUE_MAX, Settings.TRANSITION_DURATION_USER_DECRYPTED_INACTIV_INIT, Settings.JSPINNER_TRANSITION_DURATION_STEP);

		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(new Integer(0), new JLabel("low"));
		labelTable.put(new Integer(25), new JLabel(""));
		labelTable.put(new Integer(50), new JLabel("medium"));
		labelTable.put(new Integer(75), new JLabel(""));
		labelTable.put(new Integer(100), new JLabel("high"));

		this.jPanelSliderEnergyToGive = new JPanelSlider("Energy to give", 0, 100, Settings.JSLIDER_ENERGY_USER_DECRYPTED_INACTIV_INIT, labelTable, false);

		this.vBox = Box.createVerticalBox();
		}

	/**
	 * Adds the components in the {@link JPanelTransitionUserDecryptedInactiv} Layout.
	 */
	private void addComponents()
		{
		this.vBox.add(this.jPanelSpinnerTransitionDuration);
		this.vBox.add(this.jPanelSliderEnergyToGive);

		this.add(this.vBox);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JPanelSpinner jPanelSpinnerTransitionDuration;

	private JPanelSlider jPanelSliderEnergyToGive;

	private Box vBox;
	}
