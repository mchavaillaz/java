
package ch.hearc.orlac.preferences.transition;

import java.util.prefs.Preferences;

import javax.swing.JSlider;
import javax.swing.JSpinner;

import ch.hearc.orlac.view.jpanel.tools.JPanelSlider;
import ch.hearc.orlac.view.jpanel.tools.JPanelSpinner;

/**
 * Abstract class used to save and restore {@link Preferences} of {@link JPanelSlider} and {@link JPanelSpinner}.
 * @author chavailm
 */
public abstract class PreferencesTransitionJSliderJSpinner_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * Constructor of PreferencesTransition_A.
	 * @param _jPanelSpinnerTransitionDuration
	 */
	public PreferencesTransitionJSliderJSpinner_A(JPanelSpinner _jPanelSpinnerTransitionDuration, JPanelSlider _jPanelSliderEnergyToGive)
		{
		this.jPanelSpinnerTransitionDuration = _jPanelSpinnerTransitionDuration;
		this.jPanelSliderEnergyToGive = _jPanelSliderEnergyToGive;
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
		_preferences.putInt(this.paraEnergyToGive, this.jPanelSliderEnergyToGive.getjSliderCurrentValue());
		}

	/**
	 * Restores the preferences of the {@link JSlider} and the {@link JSpinner}.
	 * @param _preferences
	 * @param _transitionDurationValueDefault
	 * @param _energyToGiveValueDefault
	 */
	protected void restorePreferences(Preferences _preferences, double _transitionDurationValueDefault, int _energyToGiveValueDefault)
		{
		double transitionDurationValue = _preferences.getDouble(this.paraTransitionDurationValue, _transitionDurationValueDefault);
		int energyToGiveValue = _preferences.getInt(this.paraEnergyToGive, _energyToGiveValueDefault);

		this.jPanelSpinnerTransitionDuration.setjSpinnerCurrentValue(transitionDurationValue);
		this.jPanelSliderEnergyToGive.setjSliderCurrentValue(energyToGiveValue);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Inputs
	private JPanelSlider jPanelSliderEnergyToGive;
	private JPanelSpinner jPanelSpinnerTransitionDuration;

	//Tools
	private final String paraTransitionDurationValue = "transitionDuration";
	private final String paraEnergyToGive = "energyToGive";
	}
