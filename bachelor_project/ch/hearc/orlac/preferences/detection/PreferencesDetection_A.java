
package ch.hearc.orlac.preferences.detection;

import java.util.prefs.Preferences;

import javax.swing.JSpinner;

import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * Abstract class used to save and restore detection preferences.
 * @author chavailm
 */
public abstract class PreferencesDetection_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * Constructor of PreferencesDetection_A.
	 * @param _jPanelSpinnerCircleNumber
	 * @param _jPanelSpinnerCircleRadius
	 */
	public PreferencesDetection_A(JPanelSpinner _jPanelSpinnerCircleNumber, JPanelSpinner _jPanelSpinnerCircleRadius)
		{
		this.jPanelSpinnerCircleNumber = _jPanelSpinnerCircleNumber;
		this.jPanelSpinnerCircleRadius = _jPanelSpinnerCircleRadius;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	/**
	 * Saves the {@link Preferences}.
	 */
	public abstract void savePreferences();

	/**
	 * Restores the {@link Preferences}.
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
		_preferences.putDouble(this.paraCircleNumber, this.jPanelSpinnerCircleNumber.getjSpinnerCurrentValue());
		_preferences.putDouble(this.paraCircleRadius, this.jPanelSpinnerCircleRadius.getjSpinnerCurrentValue());
		}

	/**
	 * Restores the preferences of the {@link JSpinner}.
	 * @param _preferences
	 * @param _circleNumberValueDefault
	 * @param _circleRadiusValueDefault
	 */
	protected void restorePreferences(Preferences _preferences, double _circleNumberValueDefault, double _circleRadiusValueDefault)
		{
		double circleNumberValue = _preferences.getDouble(this.paraCircleNumber, _circleNumberValueDefault);
		double circleRadiusValue = _preferences.getDouble(this.paraCircleRadius, _circleRadiusValueDefault);

		this.jPanelSpinnerCircleNumber.setjSpinnerCurrentValue(circleNumberValue);
		this.jPanelSpinnerCircleRadius.setjSpinnerCurrentValue(circleRadiusValue);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Inputs
	private JPanelSpinner jPanelSpinnerCircleNumber;
	private JPanelSpinner jPanelSpinnerCircleRadius;

	//Tools
	private final String paraCircleNumber = "circleNumber";
	private final String paraCircleRadius = "circleRadius";
	}
