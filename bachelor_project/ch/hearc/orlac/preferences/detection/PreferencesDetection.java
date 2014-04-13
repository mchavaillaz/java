
package ch.hearc.orlac.preferences.detection;

import java.util.prefs.Preferences;

import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.controls.detection.JPanelDetectionSettings;
import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * Saves and restores the {@link Preferences} of the {@link JPanelDetectionSettings}.
 * @author chavailm
 */
public class PreferencesDetection extends PreferencesDetection_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public PreferencesDetection(JPanelSpinner _jPanelSpinnerCircleNumber, JPanelSpinner _jPanelSpinnerCircleRadius)
		{
		super(_jPanelSpinnerCircleNumber, _jPanelSpinnerCircleRadius);

		this.detectionPreferences = Preferences.userRoot().node(this.getClass().getName());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void savePreferences()
		{
		savePreferences(this.detectionPreferences);
		}

	@Override
	public void restorePreferences()
		{
		restorePreferences(this.detectionPreferences, Settings.JSPINNER_CIRCLE_NUMBER_VALUE_INIT, Settings.JSPINNER_CIRCLE_RADIUS_VALUE_INIT);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private Preferences detectionPreferences;
	}
