
package ch.hearc.orlac.view.jpanel.controls.transition;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JPanel;

import ch.hearc.orlac.data.transition.TransitionSettingsNoUserToUserCrypted;
import ch.hearc.orlac.data.transition.TransitionSettingsToNoUser;
import ch.hearc.orlac.data.transition.TransitionSettingsUserCryptedToUserDecrypted;
import ch.hearc.orlac.data.transition.TransitionSettingsUserDecryptedInactiv;
import ch.hearc.orlac.data.transition.TransitionSettingsUserDecryptedToUserCrypted;
import ch.hearc.orlac.data.transition.TransitionSettings_A;
import ch.hearc.orlac.view.jpanel.controls.transition.nouser.JPanelTransitionNoUserToUserCrypted;
import ch.hearc.orlac.view.jpanel.controls.transition.nouser.JPanelTransitionToNoUser;
import ch.hearc.orlac.view.jpanel.controls.transition.user.JPanelTransitionUserCryptedToUserDecrypted;
import ch.hearc.orlac.view.jpanel.controls.transition.user.JPanelTransitionUserDecryptedInactiv;
import ch.hearc.orlac.view.jpanel.controls.transition.user.JPanelTransitionUserDecryptedToUserCrypted;

/**
 * {@link JPanel} contains other {@link JPanel} to configure the transition settings.
 * @author chavailm
 */
public class JPanelTransitionControl extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelTransitionControl()
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
	 * Sets the {@link TransitionSettings_A} to all the JPanel wich can modify the transition settings.
	 * @param _transitionNoUserToUserCrypted
	 * @param _transitionUserCryptedToUserDecrypted
	 * @param _transitionUserDecryptedInactiv
	 * @param _transitionUserDecryptedToUserCrypted
	 * @param _transitionToNoUser
	 */
	public void setTransitionSettings(TransitionSettingsNoUserToUserCrypted _transitionNoUserToUserCrypted, TransitionSettingsUserCryptedToUserDecrypted _transitionUserCryptedToUserDecrypted, TransitionSettingsUserDecryptedInactiv _transitionUserDecryptedInactiv,
			TransitionSettingsUserDecryptedToUserCrypted _transitionUserDecryptedToUserCrypted, TransitionSettingsToNoUser _transitionToNoUser)
		{
		this.jPanelTransitionNoUserToUserCrypted.setTransitionSettings(_transitionNoUserToUserCrypted);
		this.jPanelTransitionUserCryptedToUserDecrypted.setTransitionSettings(_transitionUserCryptedToUserDecrypted);
		this.jPanelTransitionUserDecryptedInactiv.setTransitionSettings(_transitionUserDecryptedInactiv);
		this.jPanelTransitionUserDecryptedToUserCrypted.setTransitionSettings(_transitionUserDecryptedToUserCrypted);
		this.jPanelTransitionToNoUser.setTransitionSettings(_transitionToNoUser);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the {@link JPanelTransitionNoUserToUserCrypted} attribute.
	 * @return jPanelTransitionNoUserToUserCrypted
	 */
	public JPanelTransitionNoUserToUserCrypted getjPanelTransitionNoUserToUserCrypted()
		{
		return this.jPanelTransitionNoUserToUserCrypted;
		}

	/**
	 * Gets the {@link JPanelTransitionUserCryptedToUserDecrypted} attribute.
	 * @return jPanelTransitionUserCryptedToUserDecrypted
	 */
	public JPanelTransitionUserCryptedToUserDecrypted getjPanelTransitionUserCryptedToUserDecrypted()
		{
		return this.jPanelTransitionUserCryptedToUserDecrypted;
		}

	/**
	 * Gets the {@link JPanelTransitionUserDecryptedToUserCrypted} attribute.
	 * @return jPanelTransitionUserDecryptedToUserCrypted
	 */
	public JPanelTransitionUserDecryptedToUserCrypted getjPanelTransitionUserDecryptedToUserCrypted()
		{
		return this.jPanelTransitionUserDecryptedToUserCrypted;
		}

	/**
	 * Gets the {@link JPanelTransitionUserDecryptedInactiv} attribute.
	 * @return jPanelTransitionUserDecryptedInactiv
	 */
	public JPanelTransitionUserDecryptedInactiv getjPanelTransitionUserDecryptedInactiv()
		{
		return this.jPanelTransitionUserDecryptedInactiv;
		}

	/**
	 * Gets the {@link JPanelTransitionToNoUser} attribute.
	 * @return jPanelTransitionToNoUser
	 */
	public JPanelTransitionToNoUser getjPanelTransitionToNoUser()
		{
		return this.jPanelTransitionToNoUser;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components containted in the {@link JPanelTransitionControl}.
	 */
	private void createComponents()
		{
		this.setLayout(new BorderLayout());

		this.jPanelTransitionNoUserToUserCrypted = new JPanelTransitionNoUserToUserCrypted();
		this.jPanelTransitionToNoUser = new JPanelTransitionToNoUser();
		this.jPanelTransitionUserCryptedToUserDecrypted = new JPanelTransitionUserCryptedToUserDecrypted();
		this.jPanelTransitionUserDecryptedInactiv = new JPanelTransitionUserDecryptedInactiv();
		this.jPanelTransitionUserDecryptedToUserCrypted = new JPanelTransitionUserDecryptedToUserCrypted();

		this.vBox = Box.createVerticalBox();
		}

	/**
	 * Adds the components in the {@link JPanelTransitionControl} Layout.
	 */
	private void addComponents()
		{
		this.vBox.add(this.jPanelTransitionNoUserToUserCrypted);
		this.vBox.add(this.jPanelTransitionUserCryptedToUserDecrypted);
		this.vBox.add(this.jPanelTransitionUserDecryptedInactiv);
		this.vBox.add(this.jPanelTransitionUserDecryptedToUserCrypted);
		this.vBox.add(this.jPanelTransitionToNoUser);

		this.add(this.vBox);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JPanelTransitionNoUserToUserCrypted jPanelTransitionNoUserToUserCrypted;

	private JPanelTransitionUserCryptedToUserDecrypted jPanelTransitionUserCryptedToUserDecrypted;
	private JPanelTransitionUserDecryptedToUserCrypted jPanelTransitionUserDecryptedToUserCrypted;
	private JPanelTransitionUserDecryptedInactiv jPanelTransitionUserDecryptedInactiv;
	private JPanelTransitionToNoUser jPanelTransitionToNoUser;

	private Box vBox;
	}
