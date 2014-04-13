
package ch.hearc.orlac.view.jpanel.controls.transition.user;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import ch.hearc.orlac.data.transition.TransitionSettingsUserDecryptedToUserCrypted;
import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * {@link JPanel} to configure the transition duration from STATE_USER_DECRYPTED to STATE_USER_CRYPTED.
 * @author chavailm
 */
public class JPanelTransitionUserDecryptedToUserCrypted extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelTransitionUserDecryptedToUserCrypted()
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
	 * Sets the {@link TransitionSettingsUserDecryptedToUserCrypted} to the {@link JSpinner}.
	 * @param _transitionUserDecryptedToUserCrypted
	 */
	public void setTransitionSettings(TransitionSettingsUserDecryptedToUserCrypted _transitionUserDecryptedToUserCrypted)
		{
		this.jPanelSpinnerTransitionDuration.setTransitionSettings(_transitionUserDecryptedToUserCrypted);
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

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components containted in the {@link JPanelTransitionUserCryptedToUserDecrypted}.
	 */
	private void createComponents()
		{
		this.setLayout(new BorderLayout());

		this.setBorder(BorderFactory.createTitledBorder("Transition duration from USER DECRYPTED -> USER CRYPTED state"));
		this.jPanelSpinnerTransitionDuration = new JPanelSpinner("Duration", "seconds", Settings.JSPINNER_TRANSITION_DURATION_VALUE_MIN, Settings.JSPINNER_TRANSITION_DURATION_VALUE_MAX, Settings.TRANSITION_DURATION_USER_DECRYPTED_TO_USER_CRYPTED, Settings.JSPINNER_TRANSITION_DURATION_STEP);

		this.vBox = Box.createVerticalBox();
		}

	/**
	 * Adds the components in the {@link JPanelTransitionUserCryptedToUserDecrypted} Layout.
	 */
	private void addComponents()
		{
		this.vBox.add(this.jPanelSpinnerTransitionDuration);

		this.add(this.vBox);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JPanelSpinner jPanelSpinnerTransitionDuration;

	private Box vBox;
	}
