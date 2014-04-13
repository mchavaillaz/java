
package ch.hearc.orlac.view.jpanel.controls.transition.nouser;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;

import ch.hearc.orlac.data.transition.TransitionSettingsNoUserToUserCrypted;
import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * {@link JPanel} to configure the transition duration from STATE_NO_USER to STATE_USER_CRYPTED.
 * @author chavailm
 */
public class JPanelTransitionNoUserToUserCrypted extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelTransitionNoUserToUserCrypted()
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
	 * Sets the {@link TransitionSettingsNoUserToUserCrypted} to the {@link JPanelSpinner}.
	 * @param _transitionNoUserToUserCrypted
	 */
	public void setTransitionSettings(TransitionSettingsNoUserToUserCrypted _transitionNoUserToUserCrypted)
		{
		this.jPanelSpinnerTransitionDuration.setTransitionSettings(_transitionNoUserToUserCrypted);
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

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components containted in the {@link JPanelTransitionNoUserToUserCrypted}.
	 */
	private void createComponents()
		{
		this.setLayout(new BorderLayout());

		this.setBorder(BorderFactory.createTitledBorder("Transition duration from NO USER -> USER CRYPTED state"));
		this.jPanelSpinnerTransitionDuration = new JPanelSpinner("Duration", "seconds", Settings.JSPINNER_TRANSITION_DURATION_VALUE_MIN, Settings.JSPINNER_TRANSITION_DURATION_VALUE_MAX, Settings.TRANSITION_DURATION_NO_USER_TO_USER_CRYPTED, Settings.JSPINNER_TRANSITION_DURATION_STEP);

		this.vBox = Box.createVerticalBox();
		}

	/**
	 * Adds the components in the {@link JPanelTransitionNoUserToUserCrypted} Layout.
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
