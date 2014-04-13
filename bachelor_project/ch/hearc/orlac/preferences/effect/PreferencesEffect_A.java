
package ch.hearc.orlac.preferences.effect;

import java.util.prefs.Preferences;

import javax.swing.JSlider;

import ch.hearc.orlac.view.jpanel.tools.JPanelSlider;

/**
 * Abstract class used to save and restore {@link Preferences} effects .
 * @author chavailm
 */
public abstract class PreferencesEffect_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * Constructor of PreferencesEffect_A.
	 * @param _jPanelSliderRed
	 * @param _jPanelSliderGreen
	 * @param _jPanelSliderBlue
	 * @param _jPanelSliderSpeed
	 * @param _jPanelSliderEncrypt
	 */
	public PreferencesEffect_A(JPanelSlider _jPanelSliderRed, JPanelSlider _jPanelSliderGreen, JPanelSlider _jPanelSliderBlue, JPanelSlider _jPanelSliderSpeed, JPanelSlider _jPanelSliderEncrypt)
		{
		this.jPanelSliderRed = _jPanelSliderRed;
		this.jPanelSliderGreen = _jPanelSliderGreen;
		this.jPanelSliderBlue = _jPanelSliderBlue;
		this.jPanelSliderSpeed = _jPanelSliderSpeed;
		this.jPanelSliderEncrypt = _jPanelSliderEncrypt;
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
		_preferences.putInt(this.paraRedValue, this.jPanelSliderRed.getjSliderCurrentValue());
		_preferences.putInt(this.paraGreenValue, this.jPanelSliderGreen.getjSliderCurrentValue());
		_preferences.putInt(this.paraBlueValue, this.jPanelSliderBlue.getjSliderCurrentValue());
		_preferences.putInt(this.paraSpeedValue, this.jPanelSliderSpeed.getjSliderCurrentValue());
		_preferences.putInt(this.paraEncryptValue, this.jPanelSliderEncrypt.getjSliderCurrentValue());
		}

	/**
	 * Restores the preferences of the {@link JSlider}.
	 * @param _preferences
	 * @param _redValueDefault
	 * @param _greenValueDefault
	 * @param _blueValueDefault
	 * @param _speedValueDefault
	 * @param _encryptValueDefault
	 */
	protected void restorePreferences(Preferences _preferences, int _redValueDefault, int _greenValueDefault, int _blueValueDefault, int _speedValueDefault, int _encryptValueDefault)
		{
		int redValue = _preferences.getInt(this.paraRedValue, _redValueDefault);
		int greenValue = _preferences.getInt(this.paraGreenValue, _greenValueDefault);
		int blueValue = _preferences.getInt(this.paraBlueValue, _blueValueDefault);
		int speedValue = _preferences.getInt(this.paraSpeedValue, _speedValueDefault);
		int encryptValue = _preferences.getInt(this.paraEncryptValue, _encryptValueDefault);

		this.jPanelSliderRed.setjSliderCurrentValue(redValue);
		this.jPanelSliderGreen.setjSliderCurrentValue(greenValue);
		this.jPanelSliderBlue.setjSliderCurrentValue(blueValue);
		this.jPanelSliderSpeed.setjSliderCurrentValue(speedValue);
		this.jPanelSliderEncrypt.setjSliderCurrentValue(encryptValue);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Inputs
	private JPanelSlider jPanelSliderRed;
	private JPanelSlider jPanelSliderGreen;
	private JPanelSlider jPanelSliderBlue;
	private JPanelSlider jPanelSliderSpeed;
	private JPanelSlider jPanelSliderEncrypt;

	//Tools
	private final String paraRedValue = "redValue";
	private final String paraGreenValue = "greenValue";
	private final String paraBlueValue = "blueValue";
	private final String paraSpeedValue = "speedValue";
	private final String paraEncryptValue = "encryptValue";
	}
