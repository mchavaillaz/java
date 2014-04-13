
package ch.hearc.orlac.preferences.effect;

import java.util.prefs.Preferences;

import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.controls.stateeffect.JPanelUserCryptedEffects;
import ch.hearc.orlac.view.jpanel.tools.JPanelSlider;

/**
 * Saves and restores the {@link Preferences} of the attributes in {@link JPanelUserCryptedEffects}.
 * @author chavailm
 */
public class PreferencesUserCrypted extends PreferencesEffect_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * Constructor of UserCryptedPreferences.
	 * @param _jPanelSliderRed
	 * @param _jPanelSliderGreen
	 * @param _jPanelSliderBlue
	 * @param _jPanelSliderSpeed
	 * @param _jPanelSliderEncrypt
	 */
	public PreferencesUserCrypted(JPanelSlider _jPanelSliderRed, JPanelSlider _jPanelSliderGreen, JPanelSlider _jPanelSliderBlue, JPanelSlider _jPanelSliderSpeed, JPanelSlider _jPanelSliderEncrypt)
		{
		super(_jPanelSliderRed, _jPanelSliderGreen, _jPanelSliderBlue, _jPanelSliderSpeed, _jPanelSliderEncrypt);

		this.userCryptedPreferences = Preferences.userRoot().node(this.getClass().getName());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void savePreferences()
		{
		savePreferences(this.userCryptedPreferences);
		}

	@Override
	public void restorePreferences()
		{
		restorePreferences(this.userCryptedPreferences, Settings.JSLIDER_USER_CRYPTED_RED_INIT, Settings.JSLIDER_USER_CRYPTED_GREEN_INIT, Settings.JSLIDER_USER_CRYPTED_BLUE_INIT, Settings.JSLIDER_USER_CRYPTED_SPEED_INIT, Settings.JSLIDER_USER_CRYPTED_ENCRYPT_INIT);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private Preferences userCryptedPreferences;
	}
