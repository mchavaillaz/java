
package ch.hearc.orlac.preferences.effect;

import java.util.prefs.Preferences;

import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.controls.stateeffect.JPanelUserDecryptedEffects;
import ch.hearc.orlac.view.jpanel.tools.JPanelSlider;

/**
 * Saves and restores the {@link Preferences} of the attributes in {@link JPanelUserDecryptedEffects}.
 * @author chavailm
 */
public class PreferencesUserDecrypted extends PreferencesEffect_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * Constructor of UserDecryptedPreferences.
	 * @param _jPanelSliderRed
	 * @param _jPanelSliderGreen
	 * @param _jPanelSliderBlue
	 * @param _jPanelSliderSpeed
	 * @param _jPanelSliderEncrypt
	 */
	public PreferencesUserDecrypted(JPanelSlider _jPanelSliderRed, JPanelSlider _jPanelSliderGreen, JPanelSlider _jPanelSliderBlue, JPanelSlider _jPanelSliderSpeed, JPanelSlider _jPanelSliderEncrypt)
		{
		super(_jPanelSliderRed, _jPanelSliderGreen, _jPanelSliderBlue, _jPanelSliderSpeed, _jPanelSliderEncrypt);

		this.userDecryptedPreferences = Preferences.userRoot().node(this.getClass().getName());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void savePreferences()
		{
		savePreferences(this.userDecryptedPreferences);
		}

	@Override
	public void restorePreferences()
		{
		restorePreferences(this.userDecryptedPreferences, Settings.JSLIDER_USER_DECRYPTED_RED_INIT, Settings.JSLIDER_USER_DECRYPTED_GREEN_INIT, Settings.JSLIDER_USER_DECRYPTED_BLUE_INIT, Settings.JSLIDER_USER_DECRYPTED_SPEED_INIT, Settings.JSLIDER_USER_DECRYPTED_ENCRYPT_INIT);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private Preferences userDecryptedPreferences;
	}
