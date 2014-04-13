
package ch.hearc.orlac.view.jpanel.controls.transition.user;

import java.awt.BorderLayout;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import ch.hearc.orlac.data.transition.TransitionSettingsUserCryptedToUserDecrypted;
import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.tools.JPanelSlider;
import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * {@link JPanel} to configure the transition duration from STATE_USER_CRYPTED to STATE_USER_DECRYPTED.
 * @author chavailm
 */
public class JPanelTransitionUserCryptedToUserDecrypted extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelTransitionUserCryptedToUserDecrypted()
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
	 * Sets the {@link TransitionSettingsUserCryptedToUserDecrypted} to the {@link JSpinner} and the {@link JPanelSlider}.
	 * @param _transitionUserCryptedToUserDecrypted
	 */
	public void setTransitionSettings(TransitionSettingsUserCryptedToUserDecrypted _transitionUserCryptedToUserDecrypted)
		{
		this.jPanelSpinnerTransitionDuration.setTransitionSettings(_transitionUserCryptedToUserDecrypted);
		this.jPanelSliderEnergyToGive.setTransitionSettings(_transitionUserCryptedToUserDecrypted);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the {@link JPanelSpinner} attribute.
	 * @return jPanelSpinnerTransitionDuration
	 */
	public JPanelSpinner getjPanelSpinnerTransitionDuration()
		{
		return this.jPanelSpinnerTransitionDuration;
		}

	/**
	 * Gets the {@link JPanelSlider} attribute.
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
	 * Creates all the components containted in the {@link JPanelTransitionUserCryptedToUserDecrypted}.
	 */
	private void createComponents()
		{
		this.setLayout(new BorderLayout());

		this.setBorder(BorderFactory.createTitledBorder("Transition duration from USER CRYPTED -> USER DECRYPTED state"));
		this.jPanelSpinnerTransitionDuration = new JPanelSpinner("Duration", "seconds", Settings.JSPINNER_TRANSITION_DURATION_VALUE_MIN, Settings.JSPINNER_TRANSITION_DURATION_VALUE_MAX, Settings.TRANSITION_DURATION_USER_CRYPTED_TO_USER_DECRYPTED, Settings.JSPINNER_TRANSITION_DURATION_STEP);

		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(new Integer(0), new JLabel("low"));
		labelTable.put(new Integer(25), new JLabel(""));
		labelTable.put(new Integer(50), new JLabel("medium"));
		labelTable.put(new Integer(75), new JLabel(""));
		labelTable.put(new Integer(100), new JLabel("high"));

		this.jPanelSliderEnergyToGive = new JPanelSlider("Energy to give", Settings.JSLIDER_ENERGY_USER_CRYPTED_TO_USER_DECRYPTED_MIN, Settings.JSLIDER_ENERGY_USER_CRYPTED_TO_USER_DECRYPTED_MAX, Settings.JSLIDER_ENERGY_USER_CRYPTED_TO_USER_DECRYPTED_INIT, labelTable, false);

		this.vBox = Box.createVerticalBox();
		}

	/**
	 * Adds the components in the {@link JPanelTransitionUserCryptedToUserDecrypted} Layout.
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
