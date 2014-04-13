
package ch.hearc.orlac.preferences.transition;

import java.util.prefs.Preferences;

import javax.swing.JSpinner;

import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * Abstract class used to save and restore {@link Preferences} of {@link JPanelSpinner}.
 * @author chavailm
 */
public abstract class PreferencesTransitionJSpinner_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * Constructor of PreferencesTransition_A.
	 * @param _jPanelSpinnerTransitionDuration
	 */
	public PreferencesTransitionJSpinner_A(JPanelSpinner _jPanelSpinnerTransitionDuration)
		{
		this.jPanelSpinnerTransitionDuration = _jPanelSpinnerTransitionDuration;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	/**
	 * Saves the {@link Preferences}.
	 */
	public abstract void savePreferences();

	/**
	 * Restore the {@link Preferences}.
	 */
	public abstract void restorePreferences();

	/*------------------------------------------------------------------*\
	|*							Methodes Protected						*|
	\*------------------------------------------------------------------*/
	/**
	 * Saves the preferences.
	 */
	protected void savePreferences(Preferences _preferences)
		{
		_preferences.putDouble(this.paraTransitionDurationValue, this.jPanelSpinnerTransitionDuration.getjSpinnerCurrentValue());
		}

	/**
	 * Restores the preferences of the {@link JSpinner}.
	 * @param _preferences
	 * @param _transitionDurationValueDefault
	 */
	protected void restorePreferences(Preferences _preferences, double _transitionDurationValueDefault)
		{
		double transitionDurationValue = _preferences.getDouble(this.paraTransitionDurationValue, _transitionDurationValueDefault);

		this.jPanelSpinnerTransitionDuration.setjSpinnerCurrentValue(transitionDurationValue);
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
	//Inputs
	private JPanelSpinner jPanelSpinnerTransitionDuration;

	//Tools
	private final String paraTransitionDurationValue = "transitionDuration";
	}
