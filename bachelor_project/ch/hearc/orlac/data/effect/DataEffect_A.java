
package ch.hearc.orlac.data.effect;

/**
 * Abstract class for the DataEffect concrete classes.</br>
 * Contains abstract getter and setter methods for all the effect values.
 * @author chavailm
 */
public abstract class DataEffect_A
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	/**
	 * Sets the attribute redValue in range [0;1].
	 * @param _redValue
	 */
	public abstract void setRedValue(double _redValue);

	/**
	 * Sets the attribute greenValue in range [0;1].
	 * @param _greenValue
	 */
	public abstract void setGreenValue(double _greenValue);

	/**
	 * Sets the attribute blueValue in range [0;1].
	 * @param _blueValue
	 */
	public abstract void setBlueValue(double _blueValue);

	/**
	 * Sets the attribue speedValue in range [0;1]
	 * @param _speedValue
	 */
	public abstract void setSpeedValue(double _speedValue);

	/**
	 * Sets the attribute encryptValue in range [0;1].
	 * @param _encryptValue
	 */
	public abstract void setEncryptValue(double _encryptValue);

	/**
	 * Sets the attribute distanceValue in range [0;1].
	 * @param _distanceValue
	 */
	public abstract void setDistanceValue(double _distanceValue);

	/**
	 * Sets the attribute rollValue in range [Settings.ROLL_CAPTURED_MIN;Settings.ROLL_CAPTURED_MAX].
	 * @param _rollValue
	 */
	public abstract void setRollValue(double _rollValue);

	/**
	 * Sets the attribute pitchValue in range [Settings.PITCH_CAPTURED_MIN;Settings.PITCH_CAPTURED_MAX].
	 * @param _pitchValue
	 */
	public abstract void setPitchValue(double _pitchValue);

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the attribute redValue in range [0;1].
	 * @return redValue
	 */
	public abstract double getRedValue();

	/**
	 * Gets the attribute greenValue in range [0;1].
	 * @return greenValue
	 */
	public abstract double getGreenValue();

	/**
	 * Gets the attribute blueValue in range [0;1].
	 * @return blueValue
	 */
	public abstract double getBlueValue();

	/**
	 * Gets the attribute speedValue.
	 * @return speedValue
	 */
	public abstract double getSpeedValue();

	/**
	 * Gets the attribute encryptValue in range [0;1].
	 * @return encryptValue
	 */
	public abstract double getEncryptValue();

	/**
	 * Gets the attribute distanceValue in range [0,1]
	 * @return distanceValue
	 */
	public abstract double getDistanceValue();

	/**
	 * Gets the attribute rollValue in range [Settings.ROLL_PURE_DATA_MIN;Settings.ROLL_PURE_DATA_MAX].
	 * @return rollValue
	 */
	public abstract double getRollValue();

	/**
	 * Gets the attribute pitchValue in range [Settings.PITCH_PURE_DATA_MIN;Settings.PITCH_PURE_DATA_MAX].
	 * @return pitchValue
	 */
	public abstract double getPitchValue();
	}
