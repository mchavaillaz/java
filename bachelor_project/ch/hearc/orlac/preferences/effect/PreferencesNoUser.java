
package ch.hearc.orlac.preferences.effect;

import java.util.prefs.Preferences;

import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.controls.stateeffect.JPanelNoUserEffects;
import ch.hearc.orlac.view.jpanel.tools.JPanelSlider;

/**
 * Saves and restores the {@link Preferences} of the attributes in {@link JPanelNoUserEffects}.
 * @author chavailm
 */
public class PreferencesNoUser extends PreferencesEffect_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * Constructor of NoUserPreferences.
	 * @param _jPanelSliderRed
	 * @param _jPanelSliderGreen
	 * @param _jPanelSliderBlue
	 * @param _jPanelSliderSpeed
	 * @param _jPanelSliderEncrypt
	 */
	public PreferencesNoUser(JPanelSlider _jPanelSliderRed, JPanelSlider _jPanelSliderGreen, JPanelSlider _jPanelSliderBlue, JPanelSlider _jPanelSliderSpeed, JPanelSlider _jPanelSliderEncrypt)
		{
		super(_jPanelSliderRed, _jPanelSliderGreen, _jPanelSliderBlue, _jPanelSliderSpeed, _jPanelSliderEncrypt);

		this.noUserPreferences = Preferences.userRoot().node(this.getClass().getName());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void savePreferences()
		{
		savePreferences(this.noUserPreferences);
		}

	@Override
	public void restorePreferences()
		{
		restorePreferences(this.noUserPreferences, Settings.JSLIDER_NO_USER_RED_INIT, Settings.JSLIDER_NO_USER_GREEN_INIT, Settings.JSLIDER_NO_USER_BLUE_INIT, Settings.JSLIDER_NO_USER_SPEED_INIT, Settings.JSLIDER_NO_USER_ENCRYPT_INIT);
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private Preferences noUserPreferences;
	}
