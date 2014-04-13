
package ch.hearc.orlac.data.effect;

import ch.hearc.orlac.tools.Settings;

/**
 * Contains the current data effect values.</br>
 * The OSC message sended to Pure Data is build with the current values of this class.
 * @author chavailm
 */
public class DataEffectCurrent extends DataEffect_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public DataEffectCurrent()
		{
		this.redValue = Settings.getNoUserRedInitValue();
		this.greenValue = Settings.getNoUserGreenInitValue();
		this.blueValue = Settings.getNoUserBlueInitValue();
		this.speedValue = Settings.getNoUserSpeedInitValue();
		this.encryptValue = Settings.getNoUserEncryptInitValue();
		this.distanceValue = Settings.DISTANCE_NO_USER_INIT;
		this.rollValue = Settings.ROLL_PURE_DATA_VALUE_INIT;
		this.pitchValue = Settings.PITCH_PURE_DATA_VALUE_INIT;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	/**
	 * Adds the step value to the redValue attribute.
	 * @param _stepValue
	 */
	public void updateRedValue(double _stepValue)
		{
		double newValue = this.redValue + _stepValue;

		if (newValue <= Settings.RED_MIN)
			{
			newValue = Settings.RED_MIN;
			}
		else if (newValue >= Settings.RED_MAX)
			{
			newValue = Settings.RED_MAX;
			}

		this.redValue = newValue;
		}

	/**
	 * Adds the step value to the greenValue attribute.
	 * @param _stepValue
	 */
	public void updateGreenValue(double _stepValue)
		{
		double newValue = this.greenValue + _stepValue;

		if (newValue <= Settings.GREEN_MIN)
			{
			newValue = Settings.GREEN_MIN;
			}
		else if (newValue >= Settings.GREEN_MAX)
			{
			newValue = Settings.GREEN_MAX;
			}

		this.greenValue = newValue;
		}

	/**
	 * Adds the step value to the blueValue attribute.
	 * @param _stepValue
	 */
	public void updateBlueValue(double _stepValue)
		{
		double newValue = this.blueValue + _stepValue;

		if (newValue <= Settings.BLUE_MIN)
			{
			newValue = Settings.BLUE_MIN;
			}
		else if (newValue >= Settings.BLUE_MAX)
			{
			newValue = Settings.BLUE_MAX;
			}

		this.blueValue = newValue;
		}

	/**
	 * Adds the step value to the speedValue attribute.
	 * @param _stepValue
	 */
	public void updateSpeedValue(double _stepValue)
		{
		double newValue = this.speedValue + _stepValue;

		if (newValue <= Settings.SPEED_ARC_LENGTH_MIN)
			{
			newValue = Settings.SPEED_ARC_LENGTH_MIN;
			}
		else if (newValue >= Settings.SPEED_ARC_LENGTH_MAX)
			{
			newValue = Settings.SPEED_ARC_LENGTH_MAX;
			}

		this.speedValue = newValue;
		}

	/**
	 * Adds the step value to the zoomValue attribute.
	 * @param _stepValue
	 */
	public void updateEncryptValue(double _stepValue)
		{
		this.encryptValue += _stepValue;
		}

	/**
	 * Adds the step value to the distanceValue attribute.
	 * @param _stepValue
	 */
	public void updateDistanceValue(double _stepValue)
		{
		this.distanceValue += _stepValue;
		}

	/**
	 * Adds the step value to the rollValue attribute.
	 * @param _stepValue
	 */
	public void updateRollValue(double _stepValue)
		{
		this.rollValue += _stepValue;
		}

	/**
	 * Adds the step value to the pitchValue attribute.
	 * @param _stepValue
	 */
	public void updatePitchValue(double _stepValue)
		{
		this.pitchValue += _stepValue;
		}

	/**
	 * Adds the arc length to speedCurrent if is in range Tools.SPEED_ARC_LENGTH_MAX and Tools.SPEED_ARC_LENGTH_MAX.
	 * @param _arcLength
	 */
	public void addArcLength(double _arcLength)
		{
		double newValue = this.speedValue + _arcLength;

		if (newValue < Settings.SPEED_ARC_LENGTH_MAX)
			{
			this.speedValue = newValue;
			}
		else
			{
			this.speedValue = Settings.SPEED_ARC_LENGTH_MAX;
			}
		}

	/**
	 * Substracts the arc length to speedCurrent if is in range Tools.SPEED_ARC_LENGTH_MIN and Tools.SPEED_ARC_LENGTH_MIN.
	 * @param _arcLength
	 */
	public void subArcLength(double _arcLength)
		{
		double newValue = this.speedValue - _arcLength;

		if (newValue > Settings.SPEED_ARC_LENGTH_MIN)
			{
			this.speedValue = newValue;
			}
		else
			{
			this.speedValue = Settings.SPEED_ARC_LENGTH_MIN;
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	@Override
	public void setRedValue(double _redValue)
		{
		this.redValue = _redValue;
		}

	@Override
	public void setGreenValue(double _greenValue)
		{
		this.greenValue = _greenValue;
		}

	@Override
	public void setBlueValue(double _blueValue)
		{
		this.blueValue = _blueValue;
		}

	@Override
	public void setSpeedValue(double _speedValue)
		{
		this.speedValue = _speedValue;
		}

	@Override
	public void setDistanceValue(double _distanceValue)
		{
		this.distanceValue = _distanceValue;
		}

	@Override
	public void setEncryptValue(double _encryptValue)
		{
		this.encryptValue = _encryptValue;
		}

	@Override
	public void setRollValue(double _rollValue)
		{
		this.rollValue = _rollValue;
		}

	@Override
	public void setPitchValue(double _pitchValue)
		{
		this.pitchValue = _pitchValue;
		}

	/**
	 * Sets the attribute speedValue after conversion.
	 * @param _speedValueUnconverted
	 */
	public void setSpeedValueUnconverted(double _speedValueUnconverted)
		{
		this.setSpeedValue(_speedValueUnconverted * Settings.getSpeedArcLengthNormal());
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	@Override
	public double getRedValue()
		{
		return this.redValue;
		}

	@Override
	public double getGreenValue()
		{
		return this.greenValue;
		}

	@Override
	public double getBlueValue()
		{
		return this.blueValue;
		}

	@Override
	public double getSpeedValue()
		{
		return this.speedValue;
		}

	@Override
	public double getEncryptValue()
		{
		return this.encryptValue;
		}

	@Override
	public double getDistanceValue()
		{
		return this.distanceValue;
		}

	@Override
	public double getRollValue()
		{
		return this.rollValue;
		}

	@Override
	public double getPitchValue()
		{
		return this.pitchValue;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Inputs
	private double redValue;
	private double greenValue;
	private double blueValue;
	private double speedValue;
	private double encryptValue;
	private double distanceValue;
	private double rollValue;
	private double pitchValue;
	}
