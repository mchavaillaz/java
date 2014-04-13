
package ch.hearc.orlac.preferences.transition;

import java.util.prefs.Preferences;

import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.controls.transition.user.JPanelTransitionUserDecryptedInactiv;
import ch.hearc.orlac.view.jpanel.tools.JPanelSlider;
import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * Saves and restores the {@link Preferences} of the attributes in {@link JPanelTransitionUserDecryptedInactiv}.
 * @author chavailm
 */
public class PreferencesTransitionUserInactiv extends PreferencesTransitionJSliderJSpinner_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public PreferencesTransitionUserInactiv(JPanelSpinner _jPanelSpinnerTransitionDuration, JPanelSlider _jPanelSliderEnergyToGive)
		{
		super(_jPanelSpinnerTransitionDuration, _jPanelSliderEnergyToGive);

		this.userInactivPreferences = Preferences.userRoot().node(this.getClass().getName());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void savePreferences()
		{
		savePreferences(this.userInactivPreferences);
		}

	@Override
	public void restorePreferences()
		{
		restorePreferences(this.userInactivPreferences, Settings.TRANSITION_DURATION_USER_DECRYPTED_INACTIV_INIT, Settings.JSLIDER_ENERGY_USER_DECRYPTED_INACTIV_INIT);
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
	private Preferences userInactivPreferences;
	}
