
package ch.hearc.orlac.tools;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.prefs.Preferences;

import ch.hearc.orlac.data.effect.DataEffectCurrent;
import ch.hearc.orlac.data.effect.DataEffectNoUser;
import ch.hearc.orlac.data.effect.DataEffectUserCrypted;
import ch.hearc.orlac.data.effect.DataEffectUserDecrypted;
import ch.hearc.orlac.data.transition.TransitionSettingsNoUserToUserCrypted;
import ch.hearc.orlac.data.transition.TransitionSettingsToNoUser;
import ch.hearc.orlac.data.transition.TransitionSettingsUserCryptedToUserDecrypted;
import ch.hearc.orlac.data.transition.TransitionSettingsUserDecryptedInactiv;
import ch.hearc.orlac.data.transition.TransitionSettingsUserDecryptedToUserCrypted;
import ch.hearc.orlac.leapmotion.GestureAnalysis;
import ch.hearc.orlac.leapmotion.LeapMotionListener;
import ch.hearc.orlac.network.CommunicationWithPureData;
import ch.hearc.orlac.preferences.detection.PreferencesDetection;
import ch.hearc.orlac.preferences.effect.PreferencesNoUser;
import ch.hearc.orlac.preferences.effect.PreferencesUserCrypted;
import ch.hearc.orlac.preferences.effect.PreferencesUserDecrypted;
import ch.hearc.orlac.preferences.network.PreferencesNetwork;
import ch.hearc.orlac.preferences.transition.PreferencesTransitionCryptedToDecrypted;
import ch.hearc.orlac.preferences.transition.PreferencesTransitionDecryptedToCrypted;
import ch.hearc.orlac.preferences.transition.PreferencesTransitionNoUserToUserCrypted;
import ch.hearc.orlac.preferences.transition.PreferencesTransitionToNoUser;
import ch.hearc.orlac.preferences.transition.PreferencesTransitionUserInactiv;
import ch.hearc.orlac.transitionmachine.TransitionMachine;
import ch.hearc.orlac.view.jframe.JFrameApplication;
import ch.hearc.orlac.view.jpanel.controls.connection.JPanelIpAddressPureData;
import ch.hearc.orlac.view.jpanel.controls.connection.JPanelPortNumberPureData;
import ch.hearc.orlac.view.jpanel.tools.JPanelSlider;
import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * OrlacLauncher instantiate all the components and displays the Orlac Main Window.
 * @author chavailm
 */
public class OrlacLauncher implements WindowListener
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public OrlacLauncher()
		{
		createComponents();
		createPreferences();
		addListeners();
		setComponentsAttributes();
		restorePreferences();
		restoreDataEffectCurrent();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void windowClosed(WindowEvent arg0)
		{
		// Nothing to do
		}

	@Override
	public void windowClosing(WindowEvent arg0)
		{
		savePreferences();
		}

	@Override
	public void windowDeactivated(WindowEvent arg0)
		{
		// Nothing to do.
		}

	@Override
	public void windowDeiconified(WindowEvent arg0)
		{
		// Nothing to do.
		}

	@Override
	public void windowIconified(WindowEvent arg0)
		{
		// Nothing to do.
		}

	@Override
	public void windowOpened(WindowEvent arg0)
		{
		// Nothing to do.
		}

	@Override
	public void windowActivated(WindowEvent arg0)
		{
		// Nothing to do.
		}

	/**
	 * Saves the current preferences.
	 */
	public void savePreferences()
		{
		this.networkPreferences.savePreferences();
		this.noUserPreferences.savePreferences();
		this.userCryptedPreferences.savePreferences();
		this.userDecryptedPreferences.savePreferences();

		this.toNoUserTransitionPreferences.savePreferences();
		this.noUserToUserCryptedTransitionPreferences.savePreferences();
		this.userDecryptedToUserCryptedTransitionPreferences.savePreferences();
		this.userCryptedToDecryptedTransitionPreferences.savePreferences();
		this.userInactivTransitionPreferences.savePreferences();
		this.detectionPreferences.savePreferences();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components of Orlac application.
	 */
	private void createComponents()
		{
		this.jFrameApplication = new JFrameApplication();

		this.communicationWithPureData = new CommunicationWithPureData();

		this.gestureAnalysis = new GestureAnalysis();

		this.dataEffectCurrent = new DataEffectCurrent();
		this.dataEffectNoUser = new DataEffectNoUser();
		this.dataEffectUserCrypted = new DataEffectUserCrypted();
		this.dataEffectUserDecrypted = new DataEffectUserDecrypted();

		this.transitionNoUserToUserCrypted = new TransitionSettingsNoUserToUserCrypted();
		this.transitionUserCryptedToUserDecrypted = new TransitionSettingsUserCryptedToUserDecrypted();
		this.transitionUserDecryptedInactiv = new TransitionSettingsUserDecryptedInactiv();
		this.transitionUserDecryptedToUserCrypted = new TransitionSettingsUserDecryptedToUserCrypted();
		this.transitionToNoUser = new TransitionSettingsToNoUser();

		this.leapMotionListener = new LeapMotionListener();

		this.transitionMachine = new TransitionMachine();
		}

	/**
	 * Sets the components properties.
	 */
	private void setComponentsAttributes()
		{
		this.leapMotionListener.setGestureAnalysis(this.gestureAnalysis);

		this.jFrameApplication.setGestureAnalysis(this.gestureAnalysis);
		this.jFrameApplication.setDataEffects(this.dataEffectCurrent, this.dataEffectNoUser, this.dataEffectUserCrypted, this.dataEffectUserDecrypted);
		this.jFrameApplication.setTransitionSettings(this.transitionNoUserToUserCrypted, this.transitionUserCryptedToUserDecrypted, this.transitionUserDecryptedInactiv, this.transitionUserDecryptedToUserCrypted, this.transitionToNoUser);
		this.jFrameApplication.setOrlacLauncher(this);

		this.gestureAnalysis.setLeapMotionListener(this.leapMotionListener);
		this.gestureAnalysis.setCommunicationWithPureData(this.communicationWithPureData);
		this.gestureAnalysis.setJFrameApplication(this.jFrameApplication);
		this.gestureAnalysis.setDataEffect(this.dataEffectCurrent);
		this.gestureAnalysis.setTransitionMachine(this.transitionMachine);

		this.transitionMachine.setDataEffectCurrent(this.dataEffectCurrent);
		this.transitionMachine.setDataEffectNoUser(this.dataEffectNoUser);
		this.transitionMachine.setDataEffectUserCrypted(this.dataEffectUserCrypted);
		this.transitionMachine.setDataEffectUserDecrypted(this.dataEffectUserDecrypted);
		this.transitionMachine.setTransitionSettingsNoUserToUserCrypted(this.transitionNoUserToUserCrypted);
		this.transitionMachine.setTransitionSettingsUserCryptedToUserDecrypted(this.transitionUserCryptedToUserDecrypted);
		this.transitionMachine.setTransitionSettingsUserDecryptedInactiv(this.transitionUserDecryptedInactiv);
		this.transitionMachine.setTransitionToNoUser(this.transitionToNoUser);
		this.transitionMachine.setTransitionUserDecryptedToUserCrypted(this.transitionUserDecryptedToUserCrypted);

		this.communicationWithPureData.setDataEffect(this.dataEffectCurrent);

		this.transitionNoUserToUserCrypted.setTransitionMachine(this.transitionMachine);
		this.transitionToNoUser.setTransitionMachine(this.transitionMachine);
		this.transitionUserCryptedToUserDecrypted.setTransitionMachine(this.transitionMachine);
		this.transitionUserDecryptedInactiv.setTransitionMachine(this.transitionMachine);
		this.transitionUserDecryptedToUserCrypted.setTransitionMachine(this.transitionMachine);
		}

	/**
	 * Adds listeners to the attributes.
	 */
	private void addListeners()
		{
		this.jFrameApplication.addWindowListener(this);
		}

	/**
	 * Restores the preferences or sets default value if no preferences has been saved.
	 */
	private void restorePreferences()
		{
		this.networkPreferences.restorePreferences();
		this.detectionPreferences.restorePreferences();
		this.noUserPreferences.restorePreferences();
		this.userCryptedPreferences.restorePreferences();
		this.userDecryptedPreferences.restorePreferences();
		this.toNoUserTransitionPreferences.restorePreferences();
		this.noUserToUserCryptedTransitionPreferences.restorePreferences();
		this.userDecryptedToUserCryptedTransitionPreferences.restorePreferences();
		this.userCryptedToDecryptedTransitionPreferences.restorePreferences();
		this.userInactivTransitionPreferences.restorePreferences();
		}

	/**
	 * Creates all the {@link Preferences} attributes.
	 */
	private void createPreferences()
		{
		JPanelIpAddressPureData jPanelIpAddressPureData = this.jFrameApplication.getjPanelTabbedPane().getjPanelConnection().getjPanelIpAddressPureData();
		JPanelPortNumberPureData jPanelPortNumberAudioPureData = this.jFrameApplication.getjPanelTabbedPane().getjPanelConnection().getjPanelPortNumberPureDataAudio();
		JPanelPortNumberPureData jPanelPortNumberVideoPureData = this.jFrameApplication.getjPanelTabbedPane().getjPanelConnection().getjPanelPortNumberPureDataVideo();

		this.networkPreferences = new PreferencesNetwork(jPanelIpAddressPureData, jPanelPortNumberAudioPureData, jPanelPortNumberVideoPureData);

		JPanelSlider jPanelSliderRedNoUser = this.jFrameApplication.getjPanelTabbedPane().getjPanelNoUserEffects().getjPanelColors().getjPanelSliderRed();
		JPanelSlider jPanelSliderGreenNoUser = this.jFrameApplication.getjPanelTabbedPane().getjPanelNoUserEffects().getjPanelColors().getjPanelSliderGreen();
		JPanelSlider jPanelSliderBlueNoUser = this.jFrameApplication.getjPanelTabbedPane().getjPanelNoUserEffects().getjPanelColors().getjPanelSliderBlue();
		JPanelSlider jPanelSliderSpeedNoUser = this.jFrameApplication.getjPanelTabbedPane().getjPanelNoUserEffects().getjPanelSpeed().getjPanelSliderSpeed();
		JPanelSlider jPanelSliderEncryptNoUser = this.jFrameApplication.getjPanelTabbedPane().getjPanelNoUserEffects().getjPanelEncrypt().getjPanelSliderEncrypt();

		this.noUserPreferences = new PreferencesNoUser(jPanelSliderRedNoUser, jPanelSliderGreenNoUser, jPanelSliderBlueNoUser, jPanelSliderSpeedNoUser, jPanelSliderEncryptNoUser);

		JPanelSlider jPanelSliderRedUserCrypted = this.jFrameApplication.getjPanelTabbedPane().getjPanelUserCryptedEffects().getjPanelColors().getjPanelSliderRed();
		JPanelSlider jPanelSliderGreenUserCrypted = this.jFrameApplication.getjPanelTabbedPane().getjPanelUserCryptedEffects().getjPanelColors().getjPanelSliderGreen();
		JPanelSlider jPanelSliderBlueUserCrypted = this.jFrameApplication.getjPanelTabbedPane().getjPanelUserCryptedEffects().getjPanelColors().getjPanelSliderBlue();
		JPanelSlider jPanelSliderSpeedUserCrypted = this.jFrameApplication.getjPanelTabbedPane().getjPanelUserCryptedEffects().getjPanelSpeed().getjPanelSliderSpeed();
		JPanelSlider jPanelSliderEncryptUserCrypted = this.jFrameApplication.getjPanelTabbedPane().getjPanelUserCryptedEffects().getjPanelEncrypt().getjPanelSliderEncrypt();

		this.userCryptedPreferences = new PreferencesUserCrypted(jPanelSliderRedUserCrypted, jPanelSliderGreenUserCrypted, jPanelSliderBlueUserCrypted, jPanelSliderSpeedUserCrypted, jPanelSliderEncryptUserCrypted);

		JPanelSlider jPanelSliderRedUserDecrypted = this.jFrameApplication.getjPanelTabbedPane().getjPanelUserDecryptedEffects().getjPanelColors().getjPanelSliderRed();
		JPanelSlider jPanelSliderGreenUserDecrypted = this.jFrameApplication.getjPanelTabbedPane().getjPanelUserDecryptedEffects().getjPanelColors().getjPanelSliderGreen();
		JPanelSlider jPanelSliderBlueUserDecrypted = this.jFrameApplication.getjPanelTabbedPane().getjPanelUserDecryptedEffects().getjPanelColors().getjPanelSliderBlue();
		JPanelSlider jPanelSliderSpeedUserDecrypted = this.jFrameApplication.getjPanelTabbedPane().getjPanelUserDecryptedEffects().getjPanelSpeed().getjPanelSliderSpeed();
		JPanelSlider jPanelSliderEncryptUserDecryptedS = this.jFrameApplication.getjPanelTabbedPane().getjPanelUserDecryptedEffects().getjPanelEncrypt().getjPanelSliderEncrypt();

		this.userDecryptedPreferences = new PreferencesUserDecrypted(jPanelSliderRedUserDecrypted, jPanelSliderGreenUserDecrypted, jPanelSliderBlueUserDecrypted, jPanelSliderSpeedUserDecrypted, jPanelSliderEncryptUserDecryptedS);

		JPanelSpinner jPanelSpinnerTransitionToNoUser = this.jFrameApplication.getjPanelTabbedPane().getjPanelTransitionControl().getjPanelTransitionToNoUser().getjPanelSpinnerTransitionDuration();

		this.toNoUserTransitionPreferences = new PreferencesTransitionToNoUser(jPanelSpinnerTransitionToNoUser);

		JPanelSpinner jPanelSpinnerTransitionNoUserToUserCrypted = this.jFrameApplication.getjPanelTabbedPane().getjPanelTransitionControl().getjPanelTransitionNoUserToUserCrypted().getjPanelSpinnerTransitionDuration();

		this.noUserToUserCryptedTransitionPreferences = new PreferencesTransitionNoUserToUserCrypted(jPanelSpinnerTransitionNoUserToUserCrypted);

		JPanelSpinner jPanelSpinnerUserDecryptedToUserCrypted = this.jFrameApplication.getjPanelTabbedPane().getjPanelTransitionControl().getjPanelTransitionUserDecryptedToUserCrypted().getjPanelSpinnerTransitionDuration();

		this.userDecryptedToUserCryptedTransitionPreferences = new PreferencesTransitionDecryptedToCrypted(jPanelSpinnerUserDecryptedToUserCrypted);

		JPanelSpinner jPanelSpinnerUserCryptedToUserDecrypted = this.jFrameApplication.getjPanelTabbedPane().getjPanelTransitionControl().getjPanelTransitionUserCryptedToUserDecrypted().getjPanelSpinnerTransitionDuration();
		JPanelSlider jPanelSliderUserCryptedToUserDecrypted = this.jFrameApplication.getjPanelTabbedPane().getjPanelTransitionControl().getjPanelTransitionUserCryptedToUserDecrypted().getjPanelSliderEnergyToGive();

		this.userCryptedToDecryptedTransitionPreferences = new PreferencesTransitionCryptedToDecrypted(jPanelSpinnerUserCryptedToUserDecrypted, jPanelSliderUserCryptedToUserDecrypted);

		JPanelSpinner jPanelSpinnerUserInactiv = this.jFrameApplication.getjPanelTabbedPane().getjPanelTransitionControl().getjPanelTransitionUserDecryptedInactiv().getjPanelSpinnerTransitionDuration();
		JPanelSlider jPanelSliderUserInactiv = this.jFrameApplication.getjPanelTabbedPane().getjPanelTransitionControl().getjPanelTransitionUserDecryptedInactiv().getjPanelSliderEnergyToGive();

		this.userInactivTransitionPreferences = new PreferencesTransitionUserInactiv(jPanelSpinnerUserInactiv, jPanelSliderUserInactiv);

		JPanelSpinner jPanelSpinnerCircleNumber = this.jFrameApplication.getjPanelTabbedPane().getjPanelDetectionSettings().getjPanelCircleSettings().getJPanelSpinnerCircleNumber();
		JPanelSpinner jPanelSpinnerCircleRadius = this.jFrameApplication.getjPanelTabbedPane().getjPanelDetectionSettings().getjPanelCircleSettings().getJPanelSpinnerCircleRadius();

		this.detectionPreferences = new PreferencesDetection(jPanelSpinnerCircleNumber, jPanelSpinnerCircleRadius);
		}

	/**
	 * Restores the {@link DataEffectCurrent} attribute after restored the {@link DataEffectNoUser} because the first state of the application is NO_USER.
	 */
	private void restoreDataEffectCurrent()
		{
		this.dataEffectCurrent.setRedValue(this.dataEffectNoUser.getRedValue());
		this.dataEffectCurrent.setGreenValue(this.dataEffectNoUser.getGreenValue());
		this.dataEffectCurrent.setBlueValue(this.dataEffectNoUser.getBlueValue());
		this.dataEffectCurrent.setEncryptValue(this.dataEffectNoUser.getEncryptValue());
		this.dataEffectCurrent.setSpeedValue(this.dataEffectNoUser.getSpeedValue());
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JFrameApplication jFrameApplication;

	private CommunicationWithPureData communicationWithPureData;

	private GestureAnalysis gestureAnalysis;

	private DataEffectCurrent dataEffectCurrent;
	private DataEffectNoUser dataEffectNoUser;
	private DataEffectUserCrypted dataEffectUserCrypted;
	private DataEffectUserDecrypted dataEffectUserDecrypted;

	private TransitionSettingsNoUserToUserCrypted transitionNoUserToUserCrypted;
	private TransitionSettingsUserCryptedToUserDecrypted transitionUserCryptedToUserDecrypted;
	private TransitionSettingsToNoUser transitionToNoUser;
	private TransitionSettingsUserDecryptedInactiv transitionUserDecryptedInactiv;
	private TransitionSettingsUserDecryptedToUserCrypted transitionUserDecryptedToUserCrypted;

	private LeapMotionListener leapMotionListener;

	private TransitionMachine transitionMachine;

	private PreferencesNetwork networkPreferences;

	private PreferencesDetection detectionPreferences;

	private PreferencesNoUser noUserPreferences;
	private PreferencesUserCrypted userCryptedPreferences;
	private PreferencesUserDecrypted userDecryptedPreferences;

	private PreferencesTransitionToNoUser toNoUserTransitionPreferences;
	private PreferencesTransitionNoUserToUserCrypted noUserToUserCryptedTransitionPreferences;
	private PreferencesTransitionDecryptedToCrypted userDecryptedToUserCryptedTransitionPreferences;
	private PreferencesTransitionCryptedToDecrypted userCryptedToDecryptedTransitionPreferences;
	private PreferencesTransitionUserInactiv userInactivTransitionPreferences;
	}
