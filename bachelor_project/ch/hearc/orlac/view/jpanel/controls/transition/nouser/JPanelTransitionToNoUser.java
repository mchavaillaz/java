
package ch.hearc.orlac.view.jpanel.controls.transition.nouser;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import ch.hearc.orlac.data.transition.TransitionSettingsToNoUser;
import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * {@link JPanel} to configure the transition duration from any state to STATE_NO_USER.
 * @author chavailm
 */
public class JPanelTransitionToNoUser extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelTransitionToNoUser()
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
	 * Sets the {@link TransitionSettingsToNoUser} to the {@link JSpinner}.
	 * @param _transitionToNoUser
	 */
	public void setTransitionSettings(TransitionSettingsToNoUser _transitionToNoUser)
		{
		this.jPanelSpinnerTransitionDuration.setTransitionSettings(_transitionToNoUser);
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
	 * Creates all the components containted in the {@link JPanelTransitionToNoUser}.
	 */
	private void createComponents()
		{
		this.setLayout(new BorderLayout());

		this.setBorder(BorderFactory.createTitledBorder("Transition duration to NO USER state"));
		this.jPanelSpinnerTransitionDuration = new JPanelSpinner("Duration", "seconds", Settings.JSPINNER_TRANSITION_DURATION_VALUE_MIN, Settings.JSPINNER_TRANSITION_DURATION_VALUE_MAX, Settings.TRANSITION_DURATION_TO_NO_USER, Settings.JSPINNER_TRANSITION_DURATION_STEP);

		this.vBox = Box.createVerticalBox();
		}

	/**
	 * Adds the components in the {@link JPanelTransitionToNoUser} Layout.
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
