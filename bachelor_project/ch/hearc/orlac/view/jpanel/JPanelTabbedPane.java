
package ch.hearc.orlac.view.jpanel;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ch.hearc.orlac.data.effect.DataEffectCurrent;
import ch.hearc.orlac.data.effect.DataEffectNoUser;
import ch.hearc.orlac.data.effect.DataEffectUserCrypted;
import ch.hearc.orlac.data.effect.DataEffectUserDecrypted;
import ch.hearc.orlac.data.effect.DataEffect_A;
import ch.hearc.orlac.data.transition.TransitionSettingsNoUserToUserCrypted;
import ch.hearc.orlac.data.transition.TransitionSettingsToNoUser;
import ch.hearc.orlac.data.transition.TransitionSettingsUserCryptedToUserDecrypted;
import ch.hearc.orlac.data.transition.TransitionSettingsUserDecryptedInactiv;
import ch.hearc.orlac.data.transition.TransitionSettingsUserDecryptedToUserCrypted;
import ch.hearc.orlac.data.transition.TransitionSettings_A;
import ch.hearc.orlac.leapmotion.GestureAnalysis;
import ch.hearc.orlac.view.jframe.JFrameApplication;
import ch.hearc.orlac.view.jpanel.controls.connection.JPanelConnection;
import ch.hearc.orlac.view.jpanel.controls.detection.JPanelDetectionSettings;
import ch.hearc.orlac.view.jpanel.controls.stateeffect.JPanelNoUserEffects;
import ch.hearc.orlac.view.jpanel.controls.stateeffect.JPanelUserCryptedEffects;
import ch.hearc.orlac.view.jpanel.controls.stateeffect.JPanelUserDecryptedEffects;
import ch.hearc.orlac.view.jpanel.controls.transition.JPanelTransitionControl;

/**
 * Contains a {@link JTabbedPane} with {@link JPanel} to configure the application.
 * @author chavailm
 */
public class JPanelTabbedPane extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelTabbedPane(JFrameApplication _jFrameApplication)
		{
		this.jFrameApplication = _jFrameApplication;
		createComponents();
		addComponents();
		addListeners();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	/**
	 * Sets the object {@link GestureAnalysis} to the {@link JPanelConnection}.
	 * @param _gestureAnalysis
	 */
	public void setGestureAnalysis(GestureAnalysis _gestureAnalysis)
		{
		this.jPanelConnection.setGestureAnalysis(_gestureAnalysis);
		}

	/**
	 * Sets the attribute {@link DataEffect_A} to all the {@link JPanel} wich can modify the data effect settings.
	 * @param _dataEffectCurrent
	 * @param _dataEffectNoUser
	 * @param _dataEffectUserCrypted
	 * @param _dataEffectUserDecrypted
	 */
	public void setDataEffects(DataEffectCurrent _dataEffectCurrent, DataEffectNoUser _dataEffectNoUser, DataEffectUserCrypted _dataEffectUserCrypted, DataEffectUserDecrypted _dataEffectUserDecrypted)
		{
		this.jPanelNoUserEffects.setDataEffectNoUser(_dataEffectCurrent, _dataEffectNoUser);
		this.jPanelUserCryptedEffects.setDataEffectUserCrypted(_dataEffectCurrent, _dataEffectUserCrypted);
		this.jPanelUserDecryptedEffects.setDataEffectUserDecrypted(_dataEffectCurrent, _dataEffectUserDecrypted);
		}

	/**
	 * Sets the attribute {@link TransitionSettings_A} to the {@link JPanelTransitionControl}.
	 * @param _transitionNoUserToUserCrypted
	 * @param _transitionUserCryptedToUserDecrypted
	 * @param _transitionUserDecryptedInactiv
	 * @param _transitionUserDecryptedToUserCrypted
	 * @param _transitionToNoUser
	 */
	public void setTransitionSettings(TransitionSettingsNoUserToUserCrypted _transitionNoUserToUserCrypted, TransitionSettingsUserCryptedToUserDecrypted _transitionUserCryptedToUserDecrypted, TransitionSettingsUserDecryptedInactiv _transitionUserDecryptedInactiv,
			TransitionSettingsUserDecryptedToUserCrypted _transitionUserDecryptedToUserCrypted, TransitionSettingsToNoUser _transitionToNoUser)
		{
		this.jPanelTransitionControl.setTransitionSettings(_transitionNoUserToUserCrypted, _transitionUserCryptedToUserDecrypted, _transitionUserDecryptedInactiv, _transitionUserDecryptedToUserCrypted, _transitionToNoUser);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the attribute {@link JPanelConnection}.
	 * @return jPanelConnection
	 */
	public JPanelConnection getjPanelConnection()
		{
		return this.jPanelConnection;
		}

	/**
	 * Gets the attribute {@link JPanelNoUserEffects}.
	 * @return jPanelNoUserEffects
	 */
	public JPanelNoUserEffects getjPanelNoUserEffects()
		{
		return this.jPanelNoUserEffects;
		}

	/**
	 * Gets the attribute {@link JPanelUserCryptedEffects}.
	 * @return jPanelUserCryptedEffects
	 */
	public JPanelUserCryptedEffects getjPanelUserCryptedEffects()
		{
		return this.jPanelUserCryptedEffects;
		}

	/**
	 * Gets the attribute {@link JPanelUserDecryptedEffects}.
	 * @return jPanelUserDecryptedEffects
	 */
	public JPanelUserDecryptedEffects getjPanelUserDecryptedEffects()
		{
		return this.jPanelUserDecryptedEffects;
		}

	/**
	 * Gets the attribute {@link JPanelTransitionControl}.
	 * @return jPanelTransitionControl
	 */
	public JPanelTransitionControl getjPanelTransitionControl()
		{
		return this.jPanelTransitionControl;
		}

	/**
	 * Gets the attribute {@link JPanelDetectionSettings}.
	 * @return jPanelDetectionSettings
	 */
	public JPanelDetectionSettings getjPanelDetectionSettings()
		{
		return this.jPanelDetectionSettings;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components containted in the {@link JPanelTabbedPane}.
	 */
	private void createComponents()
		{
		this.setLayout(new BorderLayout());

		this.jTabbedPane = new JTabbedPane();
		this.jPanelConnection = new JPanelConnection();
		this.jPanelNoUserEffects = new JPanelNoUserEffects();
		this.jPanelUserCryptedEffects = new JPanelUserCryptedEffects();
		this.jPanelUserDecryptedEffects = new JPanelUserDecryptedEffects();
		this.jPanelTransitionControl = new JPanelTransitionControl();
		this.jPanelDetectionSettings = new JPanelDetectionSettings();
		}

	/**
	 * Adds the components in the {@link JPanelTabbedPane} Layout.
	 */
	private void addComponents()
		{
		this.jTabbedPane.addTab("Connection", this.jPanelConnection);
		this.jTabbedPane.addTab("No user effects", this.jPanelNoUserEffects);
		this.jTabbedPane.addTab("User crypted effects", this.jPanelUserCryptedEffects);
		this.jTabbedPane.addTab("User decrypted effects", this.jPanelUserDecryptedEffects);
		this.jTabbedPane.addTab("Transition settings", this.jPanelTransitionControl);
		this.jTabbedPane.addTab("Detection settings", this.jPanelDetectionSettings);

		this.add(this.jTabbedPane, BorderLayout.CENTER);
		}

	/**
	 * Adds listeners for the {@link JPanelTabbedPane}.
	 */
	private void addListeners()
		{
		this.jTabbedPane.addChangeListener(new ChangeListener()
			{

				@Override
				public void stateChanged(ChangeEvent e)
					{
					jFrameApplication.pack();
					}
			});
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JTabbedPane jTabbedPane;

	private JPanelConnection jPanelConnection;

	private JPanelNoUserEffects jPanelNoUserEffects;
	private JPanelUserCryptedEffects jPanelUserCryptedEffects;
	private JPanelUserDecryptedEffects jPanelUserDecryptedEffects;
	private JPanelTransitionControl jPanelTransitionControl;
	private JPanelDetectionSettings jPanelDetectionSettings;

	private JFrameApplication jFrameApplication;
	}
