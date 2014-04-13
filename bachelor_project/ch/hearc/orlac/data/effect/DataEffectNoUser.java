
package ch.hearc.orlac.data.effect;

import ch.hearc.orlac.tools.Settings;

/**
 * Contains all the data effects for the STATE_NO_USER.
 * @author chavailm
 */
public class DataEffectNoUser extends DataEffect_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public DataEffectNoUser()
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
	public void setDistanceValue(double _distanceValue)
		{
		this.distanceValue = _distanceValue;
		}

	@Override
	public void setSpeedValue(double _speedValue)
		{
		this.speedValue = _speedValue * Settings.getSpeedArcLengthNormal();
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
