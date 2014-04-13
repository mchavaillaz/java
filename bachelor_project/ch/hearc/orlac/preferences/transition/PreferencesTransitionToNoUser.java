
package ch.hearc.orlac.preferences.transition;

import java.util.prefs.Preferences;

import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.controls.transition.nouser.JPanelTransitionToNoUser;
import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * Saves and restores the {@link Preferences} of the attributes in {@link JPanelTransitionToNoUser}.
 * @author chavailm
 */
public class PreferencesTransitionToNoUser extends PreferencesTransitionJSpinner_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public PreferencesTransitionToNoUser(JPanelSpinner _jPanelSpinnerTransitionDuration)
		{
		super(_jPanelSpinnerTransitionDuration);

		this.toNoUserPreferences = Preferences.userRoot().node(this.getClass().getName());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void savePreferences()
		{
		savePreferences(this.toNoUserPreferences);
		}

	@Override
	public void restorePreferences()
		{
		restorePreferences(this.toNoUserPreferences, Settings.TRANSITION_DURATION_TO_NO_USER);
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
	private Preferences toNoUserPreferences;
	}
