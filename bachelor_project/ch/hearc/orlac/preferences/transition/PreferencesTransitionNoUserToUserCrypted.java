
package ch.hearc.orlac.preferences.transition;

import java.util.prefs.Preferences;

import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.controls.transition.nouser.JPanelTransitionNoUserToUserCrypted;
import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * Saves and restores the {@link Preferences} of the attributes in {@link JPanelTransitionNoUserToUserCrypted}.
 * @author chavailm
 */
public class PreferencesTransitionNoUserToUserCrypted extends PreferencesTransitionJSpinner_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public PreferencesTransitionNoUserToUserCrypted(JPanelSpinner _jPanelSpinnerTransitionDuration)
		{
		super(_jPanelSpinnerTransitionDuration);

		this.noUserToUserCryptedPreferences = Preferences.userRoot().node(this.getClass().getName());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void savePreferences()
		{
		savePreferences(this.noUserToUserCryptedPreferences);
		}

	@Override
	public void restorePreferences()
		{
		restorePreferences(this.noUserToUserCryptedPreferences, Settings.TRANSITION_DURATION_NO_USER_TO_USER_CRYPTED);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private Preferences noUserToUserCryptedPreferences;
	}
