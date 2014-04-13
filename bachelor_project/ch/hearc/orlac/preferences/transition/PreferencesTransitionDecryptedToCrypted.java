
package ch.hearc.orlac.preferences.transition;

import java.util.prefs.Preferences;

import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.controls.transition.user.JPanelTransitionUserDecryptedToUserCrypted;
import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * Saves and restores the {@link Preferences} of the attributes in {@link JPanelTransitionUserDecryptedToUserCrypted}.
 * @author chavailm
 */
public class PreferencesTransitionDecryptedToCrypted extends PreferencesTransitionJSpinner_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public PreferencesTransitionDecryptedToCrypted(JPanelSpinner _jPanelSpinnerTransitionDuration)
		{
		super(_jPanelSpinnerTransitionDuration);

		this.userDecryptedToUserCryptedPreferences = Preferences.userRoot().node(this.getClass().getName());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void savePreferences()
		{
		savePreferences(this.userDecryptedToUserCryptedPreferences);
		}

	@Override
	public void restorePreferences()
		{
		restorePreferences(this.userDecryptedToUserCryptedPreferences, Settings.TRANSITION_DURATION_USER_DECRYPTED_TO_USER_CRYPTED);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private Preferences userDecryptedToUserCryptedPreferences;
	}
