
package ch.hearc.orlac.preferences.transition;

import java.util.prefs.Preferences;

import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.controls.transition.user.JPanelTransitionUserCryptedToUserDecrypted;
import ch.hearc.orlac.view.jpanel.tools.JPanelSlider;
import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * Saves and restores the {@link Preferences} of the attributes in {@link JPanelTransitionUserCryptedToUserDecrypted}.
 * @author chavailm
 */
public class PreferencesTransitionCryptedToDecrypted extends PreferencesTransitionJSliderJSpinner_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public PreferencesTransitionCryptedToDecrypted(JPanelSpinner _jPanelSpinnerTransitionDuration, JPanelSlider _jPanelSliderEnergyToGive)
		{
		super(_jPanelSpinnerTransitionDuration, _jPanelSliderEnergyToGive);

		this.userCryptedToUserDecryptedPreferences = Preferences.userRoot().node(this.getClass().getName());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void savePreferences()
		{
		savePreferences(this.userCryptedToUserDecryptedPreferences);
		}

	@Override
	public void restorePreferences()
		{
		restorePreferences(this.userCryptedToUserDecryptedPreferences, Settings.TRANSITION_DURATION_USER_CRYPTED_TO_USER_DECRYPTED, Settings.JSLIDER_ENERGY_USER_CRYPTED_TO_USER_DECRYPTED_INIT);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private Preferences userCryptedToUserDecryptedPreferences;
	}
